import request from '@/utils/request'
export function fetchList(code,params) {
  return request({
    url:'/intellisense-floodcontrol/waterReport/realTimeData/'+code,
    method:'post',
    params:params
  })
}
