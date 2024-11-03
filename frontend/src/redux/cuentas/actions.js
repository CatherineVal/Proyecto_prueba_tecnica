import * as actions from "./actionTypes";
import axios from "axios";
import axiosRetry from "axios-retry";

const client = axios.create({ baseURL: process.env.REACT_APP_URL });
axiosRetry(client, { retries: 5, retryDelay: axiosRetry.exponentialDelay });

export const getCuentas = (filters) => async (dispatch) => {
  try {
    dispatch({
      type: actions.LOADER_CUENTA,
      payload: true,
    });
    const resp = await client.get(`/api/cuentas`, {
      headers: {
        "Content-Type": "application/json",
      },
    });
    dispatch({
      type: actions.GET_CUENTA,
      payload: resp.data,
    });
    dispatch({
      type: actions.FAIL_CUENTA,
      payload: null,
    });
  } catch (ex) {
    // dispatch({
    //     type: actions.FAIL,
    //     payload: message
    // })

    console.error(ex.response);
  } finally {
    dispatch({
      type: actions.LOADER_CUENTA,
      payload: false,
    });
  }
};

// export const saveCuentas =
//   (req, setShowModal) => async (dispatch, getState) => {
//     try {
//       dispatch({
//         type: actions.LOADER_CUENTA,
//         payload: true,
//       });
//       const resp = await client.post(`/api/cuentas`, req, {
//         headers: {
//           "Content-Type": "application/json",
//         },
//       });
//       let { cuenta } = getState().cuentasReducer;
//       dispatch({
//         type: actions.GET_CUENTA,
//         payload: [...cuenta, resp.data],
//       });
//       dispatch({
//         type: actions.FAIL_CUENTA,
//         payload: null,
//       });
//       setShowModal(false);
//     } catch (ex) {
//       // dispatch({
//       //     type: actions.FAIL,
//       //     payload: message
//       // })

//       console.error(ex.response);
//     } finally {
//       dispatch({
//         type: actions.LOADER_CUENTA,
//         payload: false,
//       });
//     }
//   };
