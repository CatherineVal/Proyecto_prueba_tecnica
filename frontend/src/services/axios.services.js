import axios from "axios";
import axiosRetry from "axios-retry";
import generateStore from "../redux/store";

const AxiosClient = axios.create({ baseURL: process.env.REACT_APP_URL });
axiosRetry(AxiosClient, {
  retries: 5,
  retryDelay: axiosRetry.exponentialDelay,
});

AxiosClient.interceptors.request.use(async (config) => {
  config.params = config.params || {};
  const store = generateStore();
  const token = store.getState().auth && store.getState().auth.token !== '' ?  store.getState().auth.token : JSON.parse(localStorage.getItem('auth')) ? JSON.parse(localStorage.getItem('auth')).token : '';
  if(!!token){
    config.headers = {
      Authorization: `Token ${token}`,
    };
  }
  return config;
});

AxiosClient.interceptors.response.use(resp => {
  if(resp.status === 401){
    window.location.href = "/";
  }
  return resp;
});

export default AxiosClient;
