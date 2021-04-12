package com.suchness.intellisense.user.service;

import com.suchness.intellisense.common.api.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/***
 *  author: rushi
 *  create_time : 2020/11/2510:18
 *******/
@FeignClient("intellisense-auth")
public interface AuthService {
    @PostMapping(value = "/oauth/token")
    CommonResult getAccessToken(@RequestParam Map<String, String> parameters);
}
