package com.suchness.floodcontrol.earlywarning.controller;

import com.suchness.floodcontrol.earlywarning.dto.WaterLevelDayDto;
import com.suchness.floodcontrol.earlywarning.dto.WaterReportDto;
import com.suchness.floodcontrol.earlywarning.service.WaterReportService;
import com.suchness.intellisense.common.api.CommonPage;
import com.suchness.intellisense.common.api.CommonResult;
import com.suchness.intellisense.model.WaterStation;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/***
 *  author: rushi
 *  create_time : 2020/12/2110:24
 *******/
@Controller
@Api(tags = "WaterReportController", description = "水文报表")
@RequestMapping("/waterReport")
public class WaterReportController {

   @Autowired
   private WaterReportService waterReportService;

    @RequestMapping(value = "/realTimeData/{code}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<CommonPage<WaterReportDto>> register(@PathVariable(value = "code") String code,
                                                             @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                             @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<WaterReportDto> waterReportList = waterReportService.list(code,pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(waterReportList));
    }

    @RequestMapping(value = "getCMarked", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<CommonPage<WaterStation>> getCMarked(){
        List<WaterStation> waterStationList = waterReportService.listStation();
        return CommonResult.success(CommonPage.restPage(waterStationList));
    }

    @RequestMapping(value = "/getStationInfo/{name}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<WaterStation> getStationInfo(@PathVariable(value = "name") String name){
        WaterStation waterStation = waterReportService.getStationInfoByName(name);
        if(waterStation != null){
            return CommonResult.success(waterStation);
        }else {
            return CommonResult.failed("未找到指定站点");
        }
    }



}
