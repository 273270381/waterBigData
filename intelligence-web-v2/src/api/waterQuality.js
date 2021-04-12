import request from '@/utils/request'
export function fetchList() {
  return request({
    url:'/waterquality-monitor/waterQuality/realTimeData',
    method:'post'
  })
}

export function getlalg(name) {
  return request({
    url:'/waterquality-monitor/waterQuality/getStationInfo/' + name,
    method:'post'
  })
}

export function listStation() {
  return request({
    url:'/waterquality-monitor/waterQuality/stations',
    method:'post'
  })
}

export function allList(params) {
  return request({
    url:'/waterquality-monitor/waterQuality/historyData',
    method:'post',
    params:params
  })
}

export function waterQualityEvaluationList(params) {
  return request({
    url:'/waterquality-monitor/waterQuality/getQualityEvaluationByStation',
    method:'post',
    params:params
  })
}
