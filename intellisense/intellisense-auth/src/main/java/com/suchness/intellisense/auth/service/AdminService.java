package com.suchness.intellisense.auth.service;

import com.suchness.intellisense.common.domain.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/***
 *  author: rushi
 *  create_time : 2020/12/213:58
 *******/
@FeignClient("intellisense-user")
public interface AdminService {

    @GetMapping("/admin/loadByUsername")
    UserDto loadUserByUsername(@RequestParam("username") String username);
}
