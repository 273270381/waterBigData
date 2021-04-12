package com.suchness.floodcontrol.earlywarning.controller;

import com.suchness.floodcontrol.earlywarning.dto.WaterAlarmDto;
import com.suchness.floodcontrol.earlywarning.service.WaterAlarmService;
import com.suchness.intellisense.common.api.CommonPage;
import com.suchness.intellisense.common.api.CommonResult;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/***
 *  author: rushi
 *  create_time : 2021/1/49:26
 *******/
@Controller
@Api(tags = "WaterAlarmController", description = "水文报警")
@RequestMapping("/alarm")
public class WaterAlarmController {


    @Autowired
    private WaterAlarmService waterAlarmService;

    @RequestMapping(value = "/realTimeData", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<CommonPage<WaterAlarmDto>> getWaterRealTimeAlarm(@RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                             @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<WaterAlarmDto> waterAlarmDtoList = waterAlarmService.getWaterRealTimeAlarm(pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(waterAlarmDtoList));
    }

    @RequestMapping(value = "/historyData", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<CommonPage<WaterAlarmDto>> getWaterHistoryAlarm( @RequestParam(value = "stationId",required = false) String stationId,
                                                                         @RequestParam(value = "startTime",required = false) String startTime,
                                                                         @RequestParam(value = "endTime",required = false) String endTime,
                                                                         @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                                         @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<WaterAlarmDto> waterAlarmDtoList = waterAlarmService.getWaterHistoryAlarm(pageSize, pageNum,stationId,startTime,endTime);
        return CommonResult.success(CommonPage.restPage(waterAlarmDtoList));
    }
}
