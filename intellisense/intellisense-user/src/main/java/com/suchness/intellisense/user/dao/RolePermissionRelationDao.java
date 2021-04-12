package com.suchness.intellisense.user.dao;

import com.suchness.intellisense.model.Permission;
import com.suchness.intellisense.model.RolePermissionRelation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/***
 *  author: rushi
 *  create_time : 2020/11/2515:12
 *******/
public interface RolePermissionRelationDao {

    /**
     * 批量插入角色和权限关系
     */
    int insertList(@Param("list")List<RolePermissionRelation> list);

    /**
     * 根据角色获取权限
     */
    List<Permission> getPermissionList(@Param("roleId") Long roleId);
}
