
import { createApp } from "vue"
import axios from "axios"
import VueAxios from "vue-axios"
const app = createApp({})
// create an axios api
const api = axios.create({
    //baseURL: "http://localhost:8080" // replace with your base URL
    baseURL: "/api"
    })
app.use(VueAxios, api)
export default api