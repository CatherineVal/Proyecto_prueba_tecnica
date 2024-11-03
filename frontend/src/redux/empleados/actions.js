import * as actions from "./actionTypes";
import axios from "axios";
import axiosRetry from "axios-retry";
import EmpleadosService from "./prueba.services"

const client = axios.create({ baseURL: process.env.REACT_APP_URL });
axiosRetry(client, { retries: 5, retryDelay: axiosRetry.exponentialDelay });

export const getEmpleados = () => async (dispatch) => {
  try {
    dispatch({
      type: actions.LOADER,
      payload: true,
    });
    console.log("hola");

    const resp = await client.get(`/api/empleados`, {
      headers: {
        "Content-Type": "application/json",
      },
    });
    console.log("resp:", resp);

    dispatch({
      type: actions.GET_EMPLEADO,
      payload: resp.data,
    });
    dispatch({
      type: actions.FAIL,
      payload: null,
    });
  } catch (ex) {
    console.error(ex.response);
  } finally {
    dispatch({
      type: actions.LOADER,
      payload: false,
    });
  }
};


export const saveEmpleados =
  (req, setShowModal) => async (dispatch, getState) => {
    try {
      dispatch({
        type: actions.LOADER,
        payload: true,
      });

      //Llamado al service
      const resp = await EmpleadosService.saveClientes(req);

      //Se agraga el nuevo cliente al estado
      let { empleados } = getState().clienteReducer;
      dispatch({
        type: actions.GET_EMPLEADO,
        payload: [...empleados, resp.data], //add cliente al array
      });
      dispatch({
        type: actions.FAIL,
        payload: null,
      });
      setShowModal(false);
    } catch (ex) {
      console.error(ex.response);
      dispatch({
        type: actions.FAIL,
        payload: ex.response.data || "Error al guardar cliente",
      });
    } finally {
      dispatch({
        type: actions.LOADER,
        payload: false,
      });
    }
  };

export const deleteEmpleados = (id, index) => async (dispatch, getState) => {
  try {
    dispatch({
      type: actions.LOADER,
      payload: true,
    });

    // Llamado al servicio
    await EmpleadosService.deleteClientes(id);

    // Si la solicitud es exitosa, elimina al cliente
    let { empleados } = getState().empleadosReducer;
    const updatedEmpleados = empleados.filter((_, i) => i !== index); // Filtro del cliente
    dispatch({
      type: actions.GET_EMPLEADO,
      payload: updatedEmpleados,
    });
    dispatch({
      type: actions.FAIL,
      payload: null,
    });
  } catch (ex) {
    console.error(ex.response);
    dispatch({
      type: actions.FAIL,
      payload: ex.response.data || "Error al eliminar cliente",
    });
  } finally {
    dispatch({
      type: actions.LOADER,
      payload: false,
    });
  }
};
