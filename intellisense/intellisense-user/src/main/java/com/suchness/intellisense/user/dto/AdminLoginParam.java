package com.suchness.intellisense.user.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotEmpty;

/***
 *  author: rushi
 *  create_time : 2020/11/258:59
 *******/
@Data
@EqualsAndHashCode(callSuper = false)
public class AdminLoginParam {
    @ApiModelProperty(value = "用户名", required = true)
    @NotEmpty
    private String username;
    @ApiModelProperty(value = "密码", required = true)
    @NotEmpty
    private String password;
}
