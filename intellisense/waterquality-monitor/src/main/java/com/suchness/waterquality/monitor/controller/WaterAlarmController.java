package com.suchness.waterquality.monitor.controller;

import com.github.pagehelper.PageInfo;
import com.suchness.intellisense.common.api.CommonPage;
import com.suchness.intellisense.common.api.CommonResult;
import com.suchness.waterquality.monitor.dto.AlarmCount;
import com.suchness.waterquality.monitor.dto.AlarmCountBat;
import com.suchness.waterquality.monitor.dto.AlarmCountList;
import com.suchness.waterquality.monitor.dto.AlarmManagerParam;
import com.suchness.waterquality.monitor.service.AlarmService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.text.ParseException;
import java.util.List;
import java.util.Map;


/**
 * Created by hejunfeng on 2020/12/19 0019
 */
@Controller
@RequestMapping("/waterAlarmController")
public class WaterAlarmController {
    @Autowired
    private AlarmService alarmService;

    @ApiOperation("水质报警管理")
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<CommonPage<AlarmManagerParam>> list(@RequestParam (value = "stationName", required = false) String stationName,
                                                                @RequestParam (value = "alarmType",required = false) String alarmType,
                                                                @RequestParam (value = "status",required = false) String status,
                                                                @RequestParam (value = "startTime",required = false) String startTime,
                                                                @RequestParam (value = "endTime",required = false) String endTime,
                                                                @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                                @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) throws ParseException {
        PageInfo<AlarmManagerParam> list = alarmService.getWaterAlarm(stationName,alarmType,status,startTime,endTime,pageSize,pageNum);
        return CommonResult.success(CommonPage.restPage(list));
    }


    @ApiOperation("水质报警统计")
    @RequestMapping(value = "/count", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<CommonPage<AlarmCountList>> list(@RequestParam (value = "areaName",required = false) String areaName,
                                                         @RequestParam (value = "startTime",required = false) String startTime,
                                                         @RequestParam (value = "endTime",required = false) String endTime) throws ParseException {
        List<AlarmCountList> list = alarmService.getAlarmMum(areaName, startTime, endTime);
        return CommonResult.success(CommonPage.restPage(list));
    }


    @ApiOperation("水质报警添加")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public Object list2(@RequestBody Map<String, Object> map) throws ParseException {
        Integer s= alarmService.addAlarm(map);
        if (s != null){
            return CommonResult.success("添加成功");
        }
        return CommonResult.failed();
    }
}
