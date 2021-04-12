import axios from 'axios'
// 创建axios实例
const service = axios.create({
  baseURL: "https://open.ys7.com/api/lapp",
  timeout: 15000 // 请求超时时间
})

service.interceptors.request.use(config => {
  return config
}, error => {
  // Do something with request error
  console.log(error) // for debug
  Promise.reject(error)
})
service.interceptors.response.use(
  response => {
    /**
     * code为非200是抛错 可结合自己业务进行修改
     */
    return response.data;
  },
  error => {
    console.log('err' + error)// for debug
    return Promise.reject(error)
  }
)
export default service
