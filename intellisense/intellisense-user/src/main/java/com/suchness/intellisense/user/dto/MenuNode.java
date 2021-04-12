package com.suchness.intellisense.user.dto;

import com.suchness.intellisense.model.Menu;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/***
 *  author: rushi
 *  create_time : 2020/11/2516:10
 *******/
@Getter
@Setter
public class MenuNode extends Menu {

    @ApiModelProperty(value = "子级菜单")
    private List<MenuNode> children;
}
