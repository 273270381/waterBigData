import request from '@/utils/request'
export function fetchList(params) {
  return request({
    url:'/intellisense-floodcontrol/history/historyData',
    method:'post',
    params:params
  })
}
