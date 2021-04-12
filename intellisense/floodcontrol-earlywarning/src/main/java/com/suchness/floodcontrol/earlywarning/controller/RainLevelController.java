package com.suchness.floodcontrol.earlywarning.controller;

import com.suchness.floodcontrol.earlywarning.dto.*;
import com.suchness.floodcontrol.earlywarning.service.RainLevelSerive;
import com.suchness.floodcontrol.earlywarning.service.WaterLevelService;
import com.suchness.intellisense.common.api.CommonPage;
import com.suchness.intellisense.common.api.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/rainLevel")
public class RainLevelController {
    @Autowired
    RainLevelSerive rainLevelSerive;


    
    /** 
     * @Author wangchan
     * @Date 10:15 2021/1/12
     * @Param [stationId, date, pageSize, pageNum]
     * @Return com.suchness.intellisense.common.api.CommonResult<com.suchness.intellisense.common.api.CommonPage<com.suchness.floodcontrol.earlywarning.dto.RainLevelDayDto>>
     * @Description   雨量日报表接口
    **/
     
    @RequestMapping(value = "/rainLevelDay", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<CommonPage<RainLevelDayDto>> register(@RequestParam(value = "stationId", required = true) String stationId,
                                                              @RequestParam(value = "date",required = true) String date,
                                                              @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                              @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<RainLevelDayDto> roleList = rainLevelSerive.list(stationId, date,pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(roleList));
    }


    /**
     * @Author wangchan
     * @Date 10:15 2021/1/12
     * @Param [stationId, date, pageSize, pageNum]
     * @Return com.suchness.intellisense.common.api.CommonResult<com.suchness.intellisense.common.api.CommonPage<com.suchness.floodcontrol.earlywarning.dto.RainLevelMonthDto>>
     * @Description  雨量月报表接口
    **/

    @RequestMapping(value = "/rainLevelMonth", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<CommonPage<RainLevelMonthDto>> registerMonth(@RequestParam(value = "stationId", required = true) String stationId,
                                                                     @RequestParam(value = "date",required = true) String date,
                                                                     @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                                     @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<RainLevelMonthDto> roleList = rainLevelSerive.monthList(stationId, date,pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(roleList));
    }


    /**
     * @Author wangchan
     * @Date 11:10 2021/1/12
     * @Param [stationId, date, pageSize, pageNum]
     * @Return com.suchness.intellisense.common.api.CommonResult<com.suchness.intellisense.common.api.CommonPage<com.suchness.floodcontrol.earlywarning.dto.RainLevelYearDto>>
     * @Description  雨量年报接口
    **/

    @RequestMapping(value = "/rainLevelYear", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<CommonPage<RainLevelYearDto>> registerYear(@RequestParam(value = "stationId", required = true) String stationId,
                                                                    @RequestParam(value = "date",required = true) String date,
                                                                    @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                                    @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<RainLevelYearDto> roleList = rainLevelSerive.yearList(stationId, date,pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(roleList));
    }


}
