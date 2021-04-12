package com.suchness.intellisense.user.dto;

import com.suchness.intellisense.model.Permission;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/***
 *  author: rushi
 *  create_time : 2020/11/2610:40
 *******/
public class PermissionNode extends Permission {

    @Getter
    @Setter
    @ApiModelProperty(value = "子级权限")
    private List<PermissionNode> children;
}
