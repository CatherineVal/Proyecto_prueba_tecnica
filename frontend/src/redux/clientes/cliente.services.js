import AxiosClient from "../../services/axios.services";

class ClienteServices {
  getClientes = (params) =>
    AxiosClient.get("/api/clientes", {
      headers: { "Content-Type": "application/json" },
      params: params,
    });

  saveClientes = (data) =>
    AxiosClient.post("/api/clientes", data, {
      headers: { "Content-Type": "application/json" },
    });


  deleteClientes = (id) =>
    AxiosClient.delete(`/api/clientes/${id}`, {
      headers: { "Content-Type": "application/json" },
    });
}

export default new ClienteServices();
