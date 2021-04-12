package com.suchness.intellisense.user.service.impl;

import com.suchness.intellisense.mapper.ResourceCategoryMapper;
import com.suchness.intellisense.model.ResourceCategory;
import com.suchness.intellisense.model.ResourceCategoryExample;
import com.suchness.intellisense.user.service.ResourceCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/***
 *  author: rushi
 *  create_time : 2020/11/2615:37
 *******/
@Service
public class ResourceCategoryServiceImpl implements ResourceCategoryService {

    @Autowired
    private ResourceCategoryMapper resourceCategoryMapper;

    @Override
    public List<ResourceCategory> listAll() {
        ResourceCategoryExample example = new ResourceCategoryExample();
        example.setOrderByClause("sort desc");
        return resourceCategoryMapper.selectByExample(example);
    }

    @Override
    public int create(ResourceCategory resourceCategory) {
        resourceCategory.setCreateTime(new Date());
        return resourceCategoryMapper.insert(resourceCategory);
    }

    @Override
    public int update(Long id, ResourceCategory resourceCategory) {
        resourceCategory.setId(id);
        return resourceCategoryMapper.updateByPrimaryKeySelective(resourceCategory);
    }

    @Override
    public int delete(Long id) {
        return resourceCategoryMapper.deleteByPrimaryKey(id);
    }
}
