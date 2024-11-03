import * as actions from "./actionTypes";

const initialData = {
  loaderCliente: true,
  cliente: null,
  failCliente: null,
  saveCliente: false,
};

export default function ClienteReducer(state = initialData, action) {
  switch (action.type) {
    case actions.LOADER_CLIENT:
      return { ...state, loaderCliente: action.payload };

    case actions.GET_CLIENT:
      return { ...state, cliente : action.payload};

    case actions.FAIL_CLIENT:
      return { ...state, failCliente: action.payload };

    case actions.SAVE_CLIENT:
      return { ...state, saveCliente: action.payload };
      
    default:
      return state;
  }
}