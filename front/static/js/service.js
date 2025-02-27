import config from '../config/config.js'
import axios from './axios.min.js'
const contentType=config.appConfig.contentType

const axiosClient = axios.create({
 timeout: config.appConfig.timeOut,
  headers: {"Content-type": contentType,}
});
function apiRequest(params,successCallback,failCallback){
	axiosClient({
	method : "POST",
    url: config.appConfig.baseUrl,
    data: JSON.stringify(params),
  }).then(result => {
      successCallback(result.data.output)
  }).catch(result => {
    failCallback(result)
  })
}

export default{
	apiRequest
}
