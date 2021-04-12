package com.suchness.intellisense.user.service.impl;

import com.suchness.intellisense.common.service.RedisService;
import com.suchness.intellisense.model.Admin;
import com.suchness.intellisense.user.service.AdminCacheService;
import com.suchness.intellisense.user.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/***
 *  author: rushi
 *  create_time : 2020/12/213:16
 *******/
@Service
public class AdminCacheServiceImpl implements AdminCacheService {

    @Autowired
    private AdminService adminService;
    @Autowired
    private RedisService redisService;
    @Value("${redis.database}")
    private String REDIS_DATABASE;
    @Value("${redis.expire.common}")
    private Long REDIS_EXPIRE;
    @Value("${redis.key.admin}")
    private String REDIS_KEY_ADMIN;



    @Override
    public void delAdmin(Long adminId) {
        String key = REDIS_DATABASE + ":" + REDIS_KEY_ADMIN + ":" + adminId;
        redisService.del(key);
    }

    @Override
    public Admin getAdmin(Long adminId) {
        String key = REDIS_DATABASE + ":" + REDIS_KEY_ADMIN + ":" + adminId;
        return (Admin) redisService.get(key);
    }

    @Override
    public void setAdmin(Admin admin) {
        String key = REDIS_DATABASE + ":" + REDIS_KEY_ADMIN + ":" + admin.getId();
        redisService.set(key, admin, REDIS_EXPIRE);
    }
}
