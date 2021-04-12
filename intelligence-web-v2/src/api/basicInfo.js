import request from '@/utils/request'
export function hydrologyStationList(params) {
  return request({
    url:'/waterquality-monitor/waterStationController/hydrologyStationList',
    method:'post',
    params:params
  })
}

export function waterQualityStationList(params) {
  return request({
    url:'/waterquality-monitor/waterStationController/stationlist',
    method:'post',
    params:params
  })
}

export function areaList(params) {
  return request({
    url:'/waterquality-monitor/basicInfoController/areas',
    method:'post',
    params:params
  })
}

export function valleyList(params) {
  return request({
    url:'/waterquality-monitor/basicInfoController/valley',
    method:'post',
    params:params
  })
}

export function waterCategoryList() {
  return request({
    url:'/waterquality-monitor/basicInfoController/waterQualityCategory',
    method:'get',
  })
}

export function riverList(params) {
  return request({
    url:'/waterquality-monitor/basicInfoController/rivers',
    method:'post',
    params:params
  })
}

export function riverManagerList(params) {
  return request({
    url:'/waterquality-monitor/basicInfoController/riverManagers',
    method:'post',
    params:params
  })
}

export function dictInfoList(params) {
  return request({
    url:'/waterquality-monitor/basicInfoController/dictInfo/'+params,
    method:'get',
  })
}

export function deleteStations(params) {
  return request({
    url:'/waterquality-monitor/waterStationController/Station/'+params,
    method:'delete',
  })
}

export function deleteHydrologyStation(params) {
  return request({
    url:'/waterquality-monitor/waterStationController/hydrologyStation/'+params,
    method:'delete',
  })
}

export function getDicts(){
  return request({
    url:'/waterquality-monitor/basicInfoController/getdicts',
    method:'get'
  })
}
