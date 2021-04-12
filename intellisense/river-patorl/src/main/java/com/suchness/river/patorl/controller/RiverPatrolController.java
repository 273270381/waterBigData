package com.suchness.river.patorl.controller;

import com.github.pagehelper.PageInfo;
import com.suchness.intellisense.common.api.CommonPage;
import com.suchness.intellisense.common.api.CommonResult;
import com.suchness.river.patorl.dto.RiverAreaDto;
import com.suchness.river.patorl.dto.RiverPatrolDataDto;
import com.suchness.river.patorl.service.RiverPatrolService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * @author hejunfeng
 * @createTime 2021/01/28
 */
@Controller
@RequestMapping("/riverPatrolController")
public class RiverPatrolController {
    @Autowired
    private RiverPatrolService service;

    @ApiOperation("巡河区域")
    @GetMapping(value = "/riverAreas")
    @ResponseBody
    public CommonResult<List<RiverAreaDto>> list(){
        List<RiverAreaDto> list = service.getRiverAreas();
        return CommonResult.success(service.buildAreaTree(list));
    }


    @ApiOperation("历史巡河记录")
    @RequestMapping(value = "/historyPatorlDatas", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<CommonPage<RiverPatrolDataDto>> Object(@RequestParam(value = "areaId",required = false)String areaId,
                                                               @RequestParam(value = "startTime",required = false)String startTime,
                                                               @RequestParam(value = "endTime", required = false) String endTime,
                                                               @RequestParam(value = "name", required = false) String name,
                                                               @RequestParam(value = "status", required = false) Integer status,
                                                               @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                               @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum){
        PageInfo<RiverPatrolDataDto> list = service.getRiverPatrolDatas(areaId,startTime,endTime,name,status,pageSize,pageNum);
        return CommonResult.success(CommonPage.restPage(list));
    }

    @ApiOperation("上传轨迹数据")
    @RequestMapping(value = "/uploadTrackData",method = RequestMethod.POST)
    @ResponseBody
    public Object upload(@RequestParam(value = "trackPoints",required = false)String trackPoints){
        service.uploadTrackData(trackPoints);
        return CommonResult.success("上传成功");
    }

}
