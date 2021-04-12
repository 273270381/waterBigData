package com.suchness.intellisense.user.service;

import com.suchness.intellisense.model.ResourceCategory;

import java.util.List;

/***
 *  author: rushi
 *  create_time : 2020/11/2615:23
 *******/
public interface ResourceCategoryService {


    /**
     * 获取所有资源分类
     */
    List<ResourceCategory> listAll();

    /**
     * 创建资源分类
     */
    int create(ResourceCategory resourceCategory);

    /**
     * 修改资源分类
     */
    int update(Long id, ResourceCategory resourceCategory);

    /**
     * 删除资源分类
     */
    int delete(Long id);
}
