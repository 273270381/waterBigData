package com.suchness.intellisense.user.controller;

import com.suchness.intellisense.common.api.CommonPage;
import com.suchness.intellisense.common.api.CommonResult;
import com.suchness.intellisense.model.Resource;
import com.suchness.intellisense.user.service.ResourceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/***
 *  author: rushi
 *  create_time : 2020/11/249:53
 *******/
@Controller
@Api(tags = "ResourceController", description = "后台资源管理")
@RequestMapping("/resource")
public class ResourceController {

    @Autowired
    private ResourceService resourceService;

    @ApiOperation("添加后台资源")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult create(@RequestBody Resource resource) {
        int count = resourceService.create(resource);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("修改后台资源")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult update(@PathVariable Long id,
                               @RequestBody Resource resource) {
        int count = resourceService.update(id, resource);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("根据ID获取资源详情")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<Resource> getItem(@PathVariable Long id) {
        Resource resource = resourceService.getItem(id);
        return CommonResult.success(resource);
    }

    @ApiOperation("根据ID删除后台资源")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult delete(@PathVariable Long id) {
        int count = resourceService.delete(id);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("分页模糊查询后台资源")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<Resource>> list(@RequestParam(required = false) Long categoryId,
                                                   @RequestParam(required = false) String nameKeyword,
                                                   @RequestParam(required = false) String urlKeyword,
                                                   @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                   @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<Resource> resourceList = resourceService.list(categoryId,nameKeyword, urlKeyword, pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(resourceList));
    }

    @ApiOperation("查询所有后台资源")
    @RequestMapping(value = "/listAll", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<Resource>> listAll() {
        List<Resource> resourceList = resourceService.listAll();
        return CommonResult.success(resourceList);
    }

    @ApiOperation("初始化资源角色关联数据")
    @RequestMapping(value = "/initResourceRolesMap", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult initResourceRolesMap() {
        Map<String, List<String>> resourceRolesMap = resourceService.initResourceRolesMap();
        return CommonResult.success(resourceRolesMap);
    }
}
