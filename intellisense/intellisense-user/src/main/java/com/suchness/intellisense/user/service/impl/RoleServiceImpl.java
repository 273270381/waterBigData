package com.suchness.intellisense.user.service.impl;

import com.github.pagehelper.PageHelper;
import com.suchness.intellisense.mapper.RoleMapper;
import com.suchness.intellisense.mapper.RoleMenuRelationMapper;
import com.suchness.intellisense.mapper.RolePermissionRelationMapper;
import com.suchness.intellisense.mapper.RoleResourceRelationMapper;
import com.suchness.intellisense.model.*;
import com.suchness.intellisense.user.dao.RoleDao;
import com.suchness.intellisense.user.dao.RolePermissionRelationDao;
import com.suchness.intellisense.user.service.ResourceService;
import com.suchness.intellisense.user.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/***
 *  author: rushi
 *  create_time : 2020/11/2416:26
 *******/
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private ResourceService resourceService;
    @Autowired
    private RolePermissionRelationDao rolePermissionRelationDao;
    @Autowired
    private RolePermissionRelationMapper rolePermissionRelationMapper;
    @Autowired
    private RoleDao roleDao;
    @Autowired
    private RoleMenuRelationMapper roleMenuRelationMapper;
    @Autowired
    private RoleResourceRelationMapper roleResourceRelationMapper;


    @Override
    public int create(Role role) {

        role.setCreateTime(new Date());
        role.setAdminCount(0);
        role.setSort(0);
        return roleMapper.insert(role);
    }

    @Override
    public int update(Long id, Role role) {
        role.setId(id);
        return roleMapper.updateByPrimaryKeySelective(role);
    }

    @Override
    public int delete(List<Long> ids) {
        RoleExample example = new RoleExample();
        example.createCriteria().andIdIn(ids);
        int count = roleMapper.deleteByExample(example);
        resourceService.initResourceRolesMap();
        return count;
    }

    @Override
    public List<Permission> getPermissionList(Long roleId) {
        return rolePermissionRelationDao.getPermissionList(roleId);
    }

    @Override
    public int updatePermission(Long roleId, List<Long> permissionIds) {
        //先删除原有关系
        RolePermissionRelationExample example=new RolePermissionRelationExample();
        example.createCriteria().andRoleIdEqualTo(roleId);
        rolePermissionRelationMapper.deleteByExample(example);
        //批量插入新关系
        List<RolePermissionRelation> relationList = new ArrayList<>();
        for (Long permissionId : permissionIds) {
            RolePermissionRelation relation = new RolePermissionRelation();
            relation.setRoleId(roleId);
            relation.setPermissionId(permissionId);
            relationList.add(relation);
        }
        return rolePermissionRelationDao.insertList(relationList);
    }

    @Override
    public List<Role> list() {
        return roleMapper.selectByExample(new RoleExample());
    }

    @Override
    public List<Role> list(String keyword, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        RoleExample example = new RoleExample();
        if (!StringUtils.isEmpty(keyword)) {
            example.createCriteria().andNameLike("%" + keyword + "%");
        }
        return roleMapper.selectByExample(example);

    }

    @Override
    public List<Menu> getMenuList(Long adminId) {
        return roleDao.getMenuList(adminId);
    }

    @Override
    public List<Menu> listMenu(Long roleId) {
        return roleDao.getMenuListByRoleId(roleId);
    }

    @Override
    public List<Resource> listResource(Long roleId) {
        return roleDao.getResourceListByRoleId(roleId);
    }

    @Override
    public int allocMenu(Long roleId, List<Long> menuIds) {
        //先删除原有关系
        RoleMenuRelationExample example=new RoleMenuRelationExample();
        example.createCriteria().andRoleIdEqualTo(roleId);
        roleMenuRelationMapper.deleteByExample(example);
        //批量插入新关系
        for (Long menuId : menuIds) {
            RoleMenuRelation relation = new RoleMenuRelation();
            relation.setRoleId(roleId);
            relation.setMenuId(menuId);
            roleMenuRelationMapper.insert(relation);
        }
        return menuIds.size();
    }

    @Override
    public int allocResource(Long roleId, List<Long> resourceIds) {
        //先删除原有关系
        RoleResourceRelationExample example=new RoleResourceRelationExample();
        example.createCriteria().andRoleIdEqualTo(roleId);
        roleResourceRelationMapper.deleteByExample(example);
        //批量插入新关系
        for (Long resourceId : resourceIds) {
            RoleResourceRelation relation = new RoleResourceRelation();
            relation.setRoleId(roleId);
            relation.setResourceId(resourceId);
            roleResourceRelationMapper.insert(relation);
        }
        resourceService.initResourceRolesMap();
        return resourceIds.size();
    }
}
