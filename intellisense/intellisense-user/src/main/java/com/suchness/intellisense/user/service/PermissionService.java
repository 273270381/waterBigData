package com.suchness.intellisense.user.service;

import com.suchness.intellisense.model.Permission;
import com.suchness.intellisense.user.dto.PermissionNode;

import java.util.List;

/***
 *  author: rushi
 *  create_time : 2020/11/2610:30
 *******/
public interface PermissionService {
    /**
     * 添加权限
     */
    int create(Permission permission);

    /**
     * 修改权限
     */
    int update(Long id,Permission permission);

    /**
     * 批量删除权限
     */
    int delete(List<Long> ids);

    /**
     * 以层级结构返回所有权限
     */
    List<PermissionNode> treeList();

    /**
     * 获取所有权限
     */
    List<Permission> list();
}
