import * as actions from "./actionTypes";
import axios from "axios";
import axiosRetry from "axios-retry";

const client = axios.create({ baseURL: process.env.REACT_APP_URL });
axiosRetry(client, { retries: 5, retryDelay: axiosRetry.exponentialDelay });

export const getPrueba = () => async (dispatch) => {
  try {
    dispatch({
      type: actions.LOADER_PRUEBA,
      payload: true,
    });
    // console.log("hola");
    //  debugger;
    const resp = await client.get(`https://dummyapi.online/api/movies`, {
      headers: {
        "Content-Type": "application/json",
      },
    });
    console.log("resp:", resp);

    dispatch({
      type: actions.GET_PRUEBA,
      payload: resp.data,
    });
    dispatch({
      type: actions.FAIL_PRUEBA,
      payload: null,
    });
  } catch (ex) {
    console.error(ex.response);
  } finally {
    dispatch({
      type: actions.LOADER_PRUEBA,
      payload: false,
    });
  }
};

export const getPruebaID = (id) => async (dispatch) => {
  try {
    dispatch({
      type: actions.LOADER_PRUEBA,
      payload: true,
    });

    const resp = await client.get(`https://dummyapi.online/api/movies/${id}`, {
      headers: {
        "Content-Type": "application/json",
      },
    });

    console.log("RESPONSE BUSQUEDA :", resp);

    if (resp.status = 200) {
      let dataResponse = [];
    dataResponse.push(resp.data);

    dispatch({
      type: actions.GET_PRUEBA,
      payload: dataResponse,
    });
    }

    

  } catch (ex) {
    console.error(ex.response);
    dispatch({
      type: actions.FAIL_PRUEBA,
      payload: ex.response.data,
    });
  } finally {
    dispatch({
      type: actions.LOADER_PRUEBA,
      payload: false,
    });
  }
};
