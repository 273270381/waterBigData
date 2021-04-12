package com.suchness.intellisense.user.service.impl;

import com.suchness.intellisense.mapper.PermissionMapper;
import com.suchness.intellisense.model.Permission;
import com.suchness.intellisense.model.PermissionExample;
import com.suchness.intellisense.user.dto.PermissionNode;
import com.suchness.intellisense.user.service.PermissionService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/***
 *  author: rushi
 *  create_time : 2020/11/2611:19
 *******/
@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public int create(Permission permission) {
        permission.setStatus(1);
        permission.setCreateTime(new Date());
        permission.setSort(0);
        return permissionMapper.insert(permission);
    }

    @Override
    public int update(Long id, Permission permission) {
        permission.setId(id);
        return permissionMapper.updateByPrimaryKey(permission);
    }

    @Override
    public int delete(List<Long> ids) {
        PermissionExample example = new PermissionExample();
        example.createCriteria().andIdIn(ids);
        return permissionMapper.deleteByExample(example);
    }

    @Override
    public List<PermissionNode> treeList() {
        List<Permission> permissionList = permissionMapper.selectByExample(new PermissionExample());
        List<PermissionNode> result = permissionList.stream()
                .filter(permission -> permission.getPid().equals(0L))
                .map(permission -> covert(permission,permissionList)).collect(Collectors.toList());
        return result;
    }

    @Override
    public List<Permission> list() {
        return permissionMapper.selectByExample(new PermissionExample());
    }

    /**
     * 将权限转换为带有子级的权限对象
     * 当找不到子级权限的时候map操作不会再递归调用covert
     */
    private PermissionNode covert(Permission permission,List<Permission> permissionList){
        PermissionNode node = new PermissionNode();
        BeanUtils.copyProperties(permission,node);
        List<PermissionNode> children = permissionList.stream()
                .filter(subPermission -> subPermission.getPid().equals(permission.getId()))
                .map(subPermission -> covert(subPermission,permissionList)).collect(Collectors.toList());
        node.setChildren(children);
        return node;
    }
}
