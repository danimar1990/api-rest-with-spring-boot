import axios from "axios";

const api = axios.create({
  baseURL: "https://dm-springboot-react.herokuapp.com/",
});

export default api;