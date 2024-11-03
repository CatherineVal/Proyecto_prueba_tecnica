import AxiosClient from "../../services/axios.services";

class EmpleadoServices {
  getEmpleados = (params) =>
    AxiosClient.get("/api/empleados", {
      headers: { "Content-Type": "application/json" },
      params: params,
    });

  saveEmpleados = (data) =>
    AxiosClient.post("/api/clientes", data, {
      headers: { "Content-Type": "application/json" },
    });

  deleteEmpleados = (id) =>
    AxiosClient.delete(`/api/clientes/${id}`, {
      headers: { "Content-Type": "application/json" },
    });
}

export default new EmpleadoServices();
