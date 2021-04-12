import request from '@/utils/request'
export function getCMarked() {
  return request({
    url:'/intellisense-floodcontrol/waterReport/getCMarked/',
    method:'post'
  })
}

export function getlalg(name) {
  return request({
    url:'/intellisense-floodcontrol/waterReport/getStationInfo/' + name,
    method:'post'
  })
}
