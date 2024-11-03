import axios from "axios";
import axiosRetry from "axios-retry";

const GestorDocumentalClient = axios.create({ baseURL: process.env.REACT_APP_GESTOR_DOCUMENTAL_URL });
axiosRetry(GestorDocumentalClient, {
  retries: 5,
  retryDelay: axiosRetry.exponentialDelay,
});

export default GestorDocumentalClient;