package com.suchness.intellisense.user.service;

import com.suchness.intellisense.common.api.CommonResult;
import com.suchness.intellisense.common.domain.UserDto;
import com.suchness.intellisense.model.Admin;
import com.suchness.intellisense.model.Permission;
import com.suchness.intellisense.model.Resource;
import com.suchness.intellisense.model.Role;
import com.suchness.intellisense.user.dto.AdminParam;
import com.suchness.intellisense.user.dto.UpdateAdminPasswordParam;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/***
 *  author: rushi
 *  后台管理员Service
 *  create_time : 2020/11/24 10:00
 *******/
public interface AdminService {

    /**
     * 根据用户名获取后台管理员
     */
    Admin getAdminByUsername(String username);

    /**
     * 注册功能
     */
    Admin register(AdminParam adminParam);

    /**
     * 登录功能
     * @param username 用户名
     * @param password 密码
     * @return 调用认证中心返回结果
     */
    CommonResult login(String username, String password);

    /**
     * 根据用户id获取用户
     */
    Admin getItem(Long id);

    /**
     * 根据用户名或昵称分页查询用户
     */
    List<Admin> list(String keyword, Integer pageSize, Integer pageNum);

    /**
     * 修改指定用户信息
     */
    int update(Long id, Admin admin);

    /**
     * 删除指定用户
     */
    int delete(Long id);

    /**
     * 修改用户角色关系
     */
    @Transactional
    int updateRole(Long adminId, List<Long> roleIds);

    /**
     * 获取用户对于角色
     */
    List<Role> getRoleList(Long adminId);

    /**
     * 获取指定用户的可访问资源
     */
    List<Resource> getResourceList(Long adminId);

    /**
     * 修改用户的+-权限
     */
    @Transactional
    int updatePermission(Long adminId, List<Long> permissionIds);

    /**
     * 获取用户所有权限（包括角色权限和+-权限）
     */
    List<Permission> getPermissionList(Long adminId);

    /**
     * 修改密码
     */
    int updatePassword(UpdateAdminPasswordParam updatePasswordParam);

    /**
     * 获取用户信息
     */
    UserDto loadUserByUsername(String username);

    /**
     * 获取当前登录后台用户
     */
    Admin getCurrentAdmin();
}
