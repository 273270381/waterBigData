package com.suchness.intellisense.user.service;

import com.suchness.intellisense.model.Admin;

/***
 *  author: rushi
 *  create_time : 2020/12/213:14
 *******/
public interface AdminCacheService {

    /**
     * 删除后台用户缓存
     */
    void delAdmin(Long adminId);

    /**
     * 获取缓存后台用户信息
     */
    Admin getAdmin(Long adminId);

    /**
     * 设置缓存后台用户信息
     */
    void setAdmin(Admin admin);
}
