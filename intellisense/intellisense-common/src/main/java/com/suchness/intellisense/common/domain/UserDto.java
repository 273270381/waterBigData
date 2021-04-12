package com.suchness.intellisense.common.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

/***
 *  author: rushi
 *  create_time : 2020/11/1910:20
 *******/
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class UserDto {

    private Long id;
    private String username;
    private String password;
    private Integer status;
    private String clientId;
    private List<String> roles;
}
