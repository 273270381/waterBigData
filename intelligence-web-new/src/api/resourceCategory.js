import request from '@/utils/request'

export function listAllCate() {
  return request({
    url: '/intellisense-user/resourceCategory/listAll',
    method: 'get'
  })
}

export function createResourceCategory(data) {
  return request({
    url: '/intellisense-user/resourceCategory/create',
    method: 'post',
    data: data
  })
}

export function updateResourceCategory(id, data) {
  return request({
    url: '/intellisense-user/resourceCategory/update/' + id,
    method: 'post',
    data: data
  })
}

export function deleteResourceCategory(id) {
  return request({
    url: '/intellisense-user/resourceCategory/delete/' + id,
    method: 'post'
  })
}
