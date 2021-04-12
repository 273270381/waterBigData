import request from '@/utils/request'

export function login(username, password) {
  return request({
    url: '/intellisense-user/admin/login',
    method: 'post',
    data: {
      username,
      password
    }
  })
}

export function getInfo() {
  return request({
    url: '/intellisense-user/admin/info',
    method: 'get',
  })
}

export function logout() {
  return request({
    url: '/intellisense-user/admin/logout',
    method: 'post'
  })
}

export function fetchStationList() {
  return request({
    url: '/waterquality-monitor/basicInfoController/areas',
    method: 'post',

  })
}

export function fetchList(params) {
  return request({
    url: 'intellisense-floodcontrol/waterQualityReport/waterQualityDay',
    method: 'post',
    params: params
  })
}

export function fetchWeekList(params) {
  return request({
    url: 'intellisense-floodcontrol/waterQualityReport/waterQualityComWeek',
    method: 'post',
    params: params
  })
}

export function fetchMonthList(params) {
  return request({
    url: 'intellisense-floodcontrol/waterQualityReport/waterQualityComMonth',
    method: 'post',
    params: params
  })
}

export function fetchYearList(params) {
  return request({
    url: 'intellisense-floodcontrol/waterQualityReport/waterQualityYear',
    method: 'post',
    params: params
  })
}



export function createAdmin(data) {
  return request({
    url: '/intellisense-user/admin/register',
    method: 'post',
    data: data
  })
}

export function updateAdmin(id, data) {
  return request({
    url: '/intellisense-user/admin/update/' + id,
    method: 'post',
    data: data
  })
}

export function updateStatus(id, params) {
  return request({
    url: '/intellisense-user/admin/updateStatus/' + id,
    method: 'post',
    params: params
  })
}

export function deleteAdmin(id) {
  return request({
    url: '/intellisense-user/admin/delete/' + id,
    method: 'post'
  })
}

export function getRoleByAdmin(id) {
  return request({
    url: '/intellisense-user/admin/role/' + id,
    method: 'get'
  })
}

export function allocRole(data) {
  return request({
    url: '/intellisense-user/admin/role/update',
    method: 'post',
    data: data
  })
}
