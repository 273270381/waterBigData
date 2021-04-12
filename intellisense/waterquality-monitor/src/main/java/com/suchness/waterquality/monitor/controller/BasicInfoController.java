package com.suchness.waterquality.monitor.controller;

import com.github.pagehelper.PageInfo;
import com.suchness.intellisense.common.api.CommonPage;
import com.suchness.intellisense.common.api.CommonResult;
import com.suchness.waterquality.monitor.dto.*;
import com.suchness.waterquality.monitor.service.BasicInfoService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

/**
 * @author hejunfeng
 * @Description 基础信息
 * @createTime 2020/12/29
 */
@Controller
@RequestMapping("/basicInfoController")
public class BasicInfoController {
    @Autowired
    private BasicInfoService service;

    @ApiOperation("行政区划")
    @RequestMapping(value = "/areas", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<CommonPage<AreaDto>> list(@RequestParam(value = "areaId",required = false)Integer areaId,
                                                   @RequestParam(value = "code",required = false)String code,
                                                   @RequestParam(value = "superAreaId",required = false)String superAreaId,
                                                   @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                   @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum){
        PageInfo<AreaDto> list = service.getAreaInfos(areaId,code,superAreaId,pageSize,pageNum);
        return CommonResult.success(CommonPage.restPage(list));
    }




    @ApiOperation("流域管理")
    @RequestMapping(value = "/valley", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<CommonPage<DrainageAreaDto>> list(@RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                          @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum){
        PageInfo<DrainageAreaDto> list = service.getValleyInfo(pageSize,pageNum);
        return CommonResult.success(CommonPage.restPage(list));
    }


    @ApiOperation("水质类别")
    @RequestMapping(value = "/waterQualityCategory", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<WaterQualityCategory>> Object(){
        List<WaterQualityCategory> list = service.getWaterCategory();
        return CommonResult.success(list);
    }

    @ApiOperation("河湖名录")
    @RequestMapping(value = "/rivers", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<CommonPage<RiversInfo>> Object(@RequestParam(value = "riverName",required = false)String riverName,
                                                   @RequestParam(value = "waterAcreage",required = false)Double waterAcreage,
                                                   @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                   @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum){
        PageInfo<RiversInfo> list = service.getRivers(riverName, waterAcreage, pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(list));
    }

    @ApiOperation("河长名录")
    @RequestMapping(value = "/riverManagers", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<CommonPage<RiverManagerInfo>> Object2(@RequestParam(value = "name",required = false)String name,
                                                              @RequestParam(value = "account",required = false)String account,
                                                              @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                              @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum){
        PageInfo<RiverManagerInfo> list = service.getRiverManagers(name, account, pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(list));
    }


    @GetMapping(value = "/dictInfo/{dictName}")
    @ResponseBody
    public CommonResult<List<DictInfo>> Object2(@PathVariable String dictName){
        List<DictInfo> list = service.getDictInfo(dictName);
        return CommonResult.success(list);
    }

    @GetMapping(value = "/getdicts")
    @ResponseBody
    public CommonResult<Map> Object3(){
        Map map = service.getDicts();
        return CommonResult.success(map);
    }


}
