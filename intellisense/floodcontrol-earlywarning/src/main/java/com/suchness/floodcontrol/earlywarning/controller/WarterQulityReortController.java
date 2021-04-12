package com.suchness.floodcontrol.earlywarning.controller;


import com.suchness.floodcontrol.earlywarning.dto.*;
import com.suchness.floodcontrol.earlywarning.service.WaterQualityDataService;
import com.suchness.intellisense.common.api.CommonPage;
import com.suchness.intellisense.common.api.CommonResult;
import com.suchness.intellisense.model.WaterQualityDataDay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

/**
 * @Author wangchan
 * @Date 14:38 2021/1/22
 * @Param
 * @Return
 * @Description  水质单站报表
**/

@Controller
@RequestMapping("/waterQualityReport")
public class WarterQulityReortController {

    @Autowired
    private WaterQualityDataService waterQualityDataService;

    @RequestMapping(value = "/waterQualityDay", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<WaterQualityDayDto> registerDay(@RequestParam(value = "siteId", required = true) Integer siteId,
                                                        @RequestParam(value = "date", required = true) String date,
                                                        @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                        @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        WaterQualityDayDto waterQualityDayDto = waterQualityDataService.dayList(siteId, date, pageSize, pageNum);
        return CommonResult.success(waterQualityDayDto);
    }


    @RequestMapping(value = "/waterQualityWeek", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<WaterQualityWeekDto> registerWeek(@RequestParam(value = "siteId", required = true) Integer siteId,
                                                          @RequestParam(value = "date", required = true) String date,
                                                          @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                          @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) throws ParseException {
        WaterQualityWeekDto waterQualityWeekDto = waterQualityDataService.weekList(siteId, date, pageSize, pageNum);
        return CommonResult.success(waterQualityWeekDto);
    }


    @RequestMapping(value = "/waterQualityMonth", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<WaterQualityWeekDto> registerMonth(@RequestParam(value = "siteId", required = true) Integer siteId,
                                                           @RequestParam(value = "date", required = true) String date,
                                                           @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                           @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) throws ParseException {
        WaterQualityWeekDto waterQualityWeekDto = waterQualityDataService.monthList(siteId, date, pageSize, pageNum);
        return CommonResult.success(waterQualityWeekDto);
    }

    @RequestMapping(value = "/waterQualityYear", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<WaterQualityYearDto> registerYear(@RequestParam(value = "siteId", required = true) Integer siteId,
                                                          @RequestParam(value = "date", required = true) String date,
                                                          @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                          @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) throws ParseException {
        WaterQualityYearDto waterQualityYearDto = waterQualityDataService.yearList(siteId, date, pageSize, pageNum);
        return CommonResult.success(waterQualityYearDto);
    }

    /**
     * @Author wangchan
     * @Date 15:34 2021/1/25
     * @Param
     * @Return
     * @Description 水质综合周报
     **/

    @RequestMapping(value = "/waterQualityComWeek", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<List<WaterQualityInfoDto>> registerComWeek(@RequestParam(value = "areaId", required = true) Integer areaId,
                                                                   @RequestParam(value = "date", required = true) String date,
                                                                   @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                                   @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) throws ParseException {
        List<WaterQualityInfoDto> waterQualityInfoDto = waterQualityDataService.comWeekList(areaId, date, pageSize, pageNum);
        return CommonResult.success(waterQualityInfoDto);
    }



    /**
     * @Author wangchan
     * @Date 15:34 2021/1/25
     * @Param
     * @Return
     * @Description 水质综合月报
     **/

    @RequestMapping(value = "/waterQualityComMonth", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<List<WaterQualityInfoDto>> registerComMonth(@RequestParam(value = "areaId", required = true) Integer areaId,
                                                                   @RequestParam(value = "date", required = true) String date,
                                                                   @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                                   @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) throws ParseException {
        List<WaterQualityInfoDto> waterQualityInfoDto = waterQualityDataService.comMonthList(areaId, date, pageSize, pageNum);
        return CommonResult.success(waterQualityInfoDto);
    }
}