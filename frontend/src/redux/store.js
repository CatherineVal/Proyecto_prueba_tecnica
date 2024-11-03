import { createStore, combineReducers, applyMiddleware } from "redux";

import ClienteReducer from "./clientes/cliente";
import EmpleadoReducer from "./empleados/empleado";
import CuentasReducer from "./cuentas/cuentas"
import thunk from 'redux-thunk';
import PruebaReducer from "./prueba/cliente";

const rootReducer = combineReducers({
    clienteReducer : ClienteReducer,
    empleadoReducer : EmpleadoReducer,
    cuentasReducer : ClienteReducer,
    pruebaReducer : PruebaReducer,
})
const store = createStore(rootReducer, applyMiddleware(thunk));

export default store