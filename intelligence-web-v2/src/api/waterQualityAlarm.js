import request from '@/utils/request'

export function fetchList(params) {
  return request({
    url:'/waterquality-monitor/waterAlarmController/list',
    method: 'post',
    params: params
  })
}

export function stationList(params) {
  return request({
    url:'/waterquality-monitor/waterStationController/stationlist',
    method:'post',
    params:params
  })
}

export function countList(params) {
  return request({
    url:'/waterquality-monitor/waterAlarmController/count',
    method:'post',
    params:params
  })
}

export function addAlarm(params) {
  return request({
    url:'/waterquality-monitor/waterAlarmController/add',
    method:'post',
    params:params
  })
}
