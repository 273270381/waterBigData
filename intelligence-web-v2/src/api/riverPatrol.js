import request from '@/utils/request'
export function getRiverArea(params) {
  return request({
    url:'/intellisense-riverpatorl/riverPatrolController/riverAreas',
    method:'get',
    params:params
  })
}

export function getPatrolData(params) {
  return request({
    url:'/intellisense-riverpatorl/riverPatrolController/historyPatorlDatas',
    method:'post',
    params:params
  })
}
