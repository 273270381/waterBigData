import request from '@/utils/request'
export function getCMarked() {
  return request({
    url:'/intellisense-floodcontrol/waterReport/getCMarked/',
    method:'post'
  })
}
