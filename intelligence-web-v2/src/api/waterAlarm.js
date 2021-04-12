import request from '@/utils/request'

export function fetchList(params) {
  return request({
    url:'/intellisense-floodcontrol/alarm/realTimeData',
    method:'post',
    params:params
  })
}

export function allList(params) {
  return request({
    url:'/intellisense-floodcontrol/alarm/historyData',
    method:'post',
    params:params
  })
}
