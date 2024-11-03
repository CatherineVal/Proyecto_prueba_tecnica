import * as actions from "./actionTypes";

const initialData = {
  loaderCuenta: false,
  cuenta: null,
  failcuenta: null,
};

export default function CuentasReducer(state = initialData, action) {
  switch (action.type) {
    case actions.LOADER_CUENTA:
      return { ...state, loaderCuenta: action.payload };

    case actions.GET_CUENTA:
      return { ...state, cuenta: action.payload };

    case actions.FAIL_CUENTA:
      return { ...state, failCuenta: action.payload };

    default:
      return state;
  }
}
