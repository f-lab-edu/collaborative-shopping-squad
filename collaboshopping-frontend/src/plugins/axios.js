
import { createApp } from "vue"
import axios from "axios"
import VueAxios from "vue-axios"
import {TOKEN_KEY} from "../../common/variable.js";
const app = createApp({})

const setting = {
    //baseURL: "http://localhost:8080" // replace with your base URL
    baseURL: "/collaborative",
    headers: {
        "Cache-Control": "no-cache",
        "Content-Type": "application/json",
        "Access-Control-Allow-Origin": "*",
    },
    withCredentials: true,
};

if(!!localStorage.getItem('token')){
    setting.headers = {
        ...setting.headers,
        Authorization: `Bearer ${localStorage.getItem(TOKEN_KEY)}`,
    }
}

// create an axios api
const api = axios.create(setting)

app.use(VueAxios, api)
export default api