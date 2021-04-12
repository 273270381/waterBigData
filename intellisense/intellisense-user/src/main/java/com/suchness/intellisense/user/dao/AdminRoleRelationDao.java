package com.suchness.intellisense.user.dao;

import com.suchness.intellisense.model.AdminRoleRelation;
import com.suchness.intellisense.model.Permission;
import com.suchness.intellisense.model.Resource;
import com.suchness.intellisense.model.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/***
 *  author: rushi
 *  create_time : 2020/11/2510:34
 *******/
public interface AdminRoleRelationDao {
    /**
     * 批量插入用户角色关系
     */
    int insertList(@Param("list") List<AdminRoleRelation> adminRoleRelationList);

    /**
     * 获取用于所有角色
     */
    List<Role> getRoleList(@Param("adminId") Long adminId);

    /**
     * 获取用户所有角色权限
     */
    List<Permission> getRolePermissionList(@Param("adminId") Long adminId);

    /**
     * 获取用户所有权限(包括+-权限)
     */
    List<Permission> getPermissionList(@Param("adminId") Long adminId);

    /**
     * 获取用户所有可访问资源
     */
    List<Resource> getResourceList(@Param("adminId") Long adminId);

    /**
     * 获取资源相关用户ID列表
     */
    List<Long> getAdminIdList(@Param("resourceId") Long resourceId);
}
