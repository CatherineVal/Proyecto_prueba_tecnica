import * as actions from "./actionTypes";
import axios from "axios";
import axiosRetry from "axios-retry";
import clienteServices from "./cliente.services";

const client = axios.create({ baseURL: process.env.REACT_APP_URL });
axiosRetry(client, { retries: 5, retryDelay: axiosRetry.exponentialDelay });

export const getClientes = (filters) => async (dispatch) => {
  try {
    dispatch({
      type: actions.LOADER_CLIENT,
      payload: true,
    });
    // console.log("hola");
    //  debugger;
    const resp = await client.get(`/api/clientes`, {
      headers: {
        "Content-Type": "application/json",
      },
    });
    console.log("resp:", resp);

    dispatch({
      type: actions.GET_CLIENT,
      payload: resp.data,
    });
    dispatch({
      type: actions.FAIL_CLIENT,
      payload: null,
    });
  } catch (ex) {
    console.error(ex.response);
  } finally {
    dispatch({
      type: actions.LOADER_CLIENT,
      payload: false,
    });
  }
};

export const saveClientes =
  (req, setShowModal) => async (dispatch, getState) => {
    try {
      dispatch({
        type: actions.LOADER_CLIENT,
        payload: true,
      });

      //Llamado al service
      // const resp = await clienteServices.saveClientes(req);
      // console.log("response save", resp);

      const resp = await client.post(`/api/clientes`, req, {
        headers: {
          "Content-Type": "application/json",
        },
      });

      console.log(resp);

      if (resp.status == 200) {
        dispatch(getClientes());

        setShowModal(false);
      } else {
        dispatch({
          type: actions.FAIL_CLIENT,
          payload: null,
        });
      }
    } catch (ex) {
      console.error("error response", ex.response);
      dispatch({
        type: actions.FAIL_CLIENT,
        payload: ex.response.data || "Error al guardar cliente",
      });
    } finally {
      dispatch({
        type: actions.LOADER_CLIENT,
        payload: false,
      });
    }
  };

export const deleteClientes = (id, index) => async (dispatch, getState) => {
  try {
    dispatch({
      type: actions.LOADER_CLIENT,
      payload: true,
    });
    const resp = await client.delete(`/api/clientes/${id}`, {
      headers: {
        "Content-Type": "application/json",
      },
    });

    // let { clientes } = getState().clienteReducer;
    // clientes.splice(index, 1);

    if (resp.status == 200) {
      dispatch(getClientes());
      alert("Borrado exitoso");
    } else {
      dispatch({
        type: actions.FAIL_CLIENT,
        payload: null,
      });
    }
  } catch (ex) {
    console.error("Error al eliminar cliente:", ex.response);

    dispatch({
      type: actions.FAIL_CLIENT,
      payload: ex.response
        ? ex.response.data
        : "Error desconocido al eliminar cliente",
    });
  } finally {
    dispatch({
      type: actions.LOADER_CLIENT,
      payload: false,
    });
  }
};
