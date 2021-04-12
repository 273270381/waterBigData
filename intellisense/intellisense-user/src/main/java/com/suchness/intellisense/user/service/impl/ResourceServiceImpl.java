package com.suchness.intellisense.user.service.impl;

import cn.hutool.core.util.StrUtil;
import com.github.pagehelper.PageHelper;
import com.suchness.intellisense.common.constant.AuthConstant;
import com.suchness.intellisense.common.service.RedisService;
import com.suchness.intellisense.mapper.ResourceMapper;
import com.suchness.intellisense.mapper.RoleMapper;
import com.suchness.intellisense.mapper.RoleResourceRelationMapper;
import com.suchness.intellisense.model.*;
import com.suchness.intellisense.user.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/***
 *  author: rushi
 *  create_time : 2020/11/2615:06
 *******/
@Service
public class ResourceServiceImpl implements ResourceService {

    @Autowired
    private ResourceMapper resourceMapper;
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private RoleResourceRelationMapper roleResourceRelationMapper;
    @Autowired
    private RedisService redisService;


    @Value("${spring.application.name}")
    private String applicationName;
    @Override
    public int create(Resource resource) {
        resource.setCreateTime(new Date());
        int count = resourceMapper.insert(resource);
        initResourceRolesMap();
        return count;
    }

    @Override
    public int update(Long id, Resource resource) {
        resource.setId(id);
        int count = resourceMapper.updateByPrimaryKeySelective(resource);
        initResourceRolesMap();
        return count;
    }

    @Override
    public Resource getItem(Long id) {
        return resourceMapper.selectByPrimaryKey(id);
    }

    @Override
    public int delete(Long id) {
        int count = resourceMapper.deleteByPrimaryKey(id);
        initResourceRolesMap();
        return count;
    }

    @Override
    public List<Resource> list(Long categoryId, String nameKeyword, String urlKeyword, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum,pageSize);
        ResourceExample example = new ResourceExample();
        ResourceExample.Criteria criteria = example.createCriteria();
        if(categoryId!=null){
            criteria.andCategoryIdEqualTo(categoryId);
        }
        if(StrUtil.isNotEmpty(nameKeyword)){
            criteria.andNameLike('%'+nameKeyword+'%');
        }
        if(StrUtil.isNotEmpty(urlKeyword)){
            criteria.andUrlLike('%'+urlKeyword+'%');
        }
        return resourceMapper.selectByExample(example);
    }

    @Override
    public List<Resource> listAll() {
        return resourceMapper.selectByExample(new ResourceExample());
    }

    @Override
    public Map<String, List<String>> initResourceRolesMap() {
        Map<String,List<String>> resourceRoleMap = new TreeMap<>();
        List<Resource> resourceList = resourceMapper.selectByExample(new ResourceExample());
        List<Role> roleList = roleMapper.selectByExample(new RoleExample());
        List<RoleResourceRelation> relationList = roleResourceRelationMapper.selectByExample(new RoleResourceRelationExample());
        for (Resource resource : resourceList) {
            Set<Long> roleIds = relationList.stream().filter(item -> item.getResourceId().equals(resource.getId())).map(RoleResourceRelation::getRoleId).collect(Collectors.toSet());
            List<String> roleNames = roleList.stream().filter(item -> roleIds.contains(item.getId())).map(item -> item.getId() + "_" + item.getName()).collect(Collectors.toList());
            resourceRoleMap.put(resource.getUrl(),roleNames);
        }
        redisService.del(AuthConstant.RESOURCE_ROLES_MAP_KEY);
        redisService.hSetAll(AuthConstant.RESOURCE_ROLES_MAP_KEY, resourceRoleMap);
        return resourceRoleMap;
    }
}
