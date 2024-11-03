import * as actions from "./actionTypes";

const initialData = {
  loaderPrueba: true,
  prueba: null,
  failPrueba: null,
  savePrueba: false,
};

export default function PruebaReducer(state = initialData, action) {
  switch (action.type) {
    case actions.LOADER_PRUEBA:
      return { ...state, loaderPrueba: action.payload };

    case actions.GET_PRUEBA:
      return { ...state, prueba : action.payload};

    case actions.FAIL_PRUEBA:
      return { ...state, failPrueba: action.payload };

    case actions.SAVE_PRUEBA:
      return { ...state, savePrueba: action.payload };
      
    default:
      return state;
  }
}