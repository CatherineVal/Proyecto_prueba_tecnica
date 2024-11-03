import * as actions from "./actionTypes";

const initialData = {
  loader: false,
  empleado: null,
  fail: null,
  save: false,
};

export default function PruebaReducer(state = initialData, action) {
  switch (action.type) {
    case actions.LOADER:
      return { ...state, loader: action.payload };

    case actions.GET_EMPLEADO:
      return { ...state, empleado: action.payload };

    case actions.FAIL:
      return { ...state, fail: action.payload };

    case actions.SAVE:
      return { ...state, save: action.payload };

    default:
      return state;
  }
}
