import request from '@/utils/videoRequest'
export function getToken(params) {
  return request({
    url:'/token/get',
    method:'post',
    params:params
  })
}
export function getCameraList(params) {
  return request({
    url:'/camera/list',
    method:'post',
    params:params
  })
}
export function startPtz(params) {
  return request({
    url:'/device/ptz/start',
    method:'post',
    params:params
  })
}
export function stopPtz(params) {
  return request({
    url:'/device/ptz/stop',
    method:'post',
    params:params
  })
}
export function mirror(params) {
  return request({
    url:'/device/ptz/mirror',
    method:'post',
    params:params
  })
}
