import Axios from "axios";

export const axios = Axios.create({
  headers: {
    "Content-Type": "application/json",
  },
});

axios.interceptors.response.use(
  (res) => res,
  (err) => Promise.reject(err.response?.data || err)
);
