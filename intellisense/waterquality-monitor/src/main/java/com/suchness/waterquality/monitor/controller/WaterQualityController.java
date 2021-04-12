package com.suchness.waterquality.monitor.controller;

import com.github.pagehelper.PageInfo;
import com.suchness.intellisense.common.api.CommonPage;
import com.suchness.intellisense.common.api.CommonResult;
import com.suchness.intellisense.model.WaterQualityHistoryData;
import com.suchness.intellisense.model.WaterQualitySite;
import com.suchness.intellisense.model.WaterQualityStation;
import com.suchness.waterquality.monitor.dto.WaterQualityDto;
import com.suchness.waterquality.monitor.dto.WaterQualityEvaluationDto;
import com.suchness.waterquality.monitor.dto.WaterQualityInfoDto;
import com.suchness.waterquality.monitor.service.WaterQuality;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/***
 *  author: rushi
 *  create_time : 2021/1/68:41
 *******/
@Controller
@Api(tags = "WaterQualityController", description = "水质")
@RequestMapping("/waterQuality")
public class WaterQualityController {

    @Autowired
    private WaterQuality waterQuality;

    @RequestMapping(value = "/realTimeData", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<WaterQualityDto> getRealTimeData() {
        WaterQualityDto waterQualityDto = waterQuality.listRealTimeData();
        return CommonResult.success(waterQualityDto);
    }

    @RequestMapping(value = "/historyData", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<CommonPage<WaterQualityHistoryData>> getHistoryData(
                                                                        @RequestParam(value = "id",required = false) String stationId,
                                                                        @RequestParam(value = "startTime",required = false) String startTime,
                                                                        @RequestParam(value = "endTime",required = false) String endTime,
                                                                        @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                                        @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<WaterQualityHistoryData> waterQualityHistoryData = waterQuality.listHistoryData(stationId,startTime,endTime,pageSize,pageNum);
        return CommonResult.success(CommonPage.restPage(waterQualityHistoryData));
    }


    @RequestMapping(value = "/getStationInfo/{name}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<WaterQualitySite> getStationInfo(@PathVariable(value = "name") String name){
        WaterQualitySite waterQualitySite = waterQuality.getStationInfoByName(name);
        if(waterQualitySite != null){
            return CommonResult.success(waterQualitySite);
        }else {
            return CommonResult.failed("未找到指定站点");
        }
    }

    @RequestMapping(value = "/stations", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<CommonPage<WaterQualitySite>> listStations(){
        List<WaterQualitySite> waterQualitySites = waterQuality.listStations();
        return CommonResult.success(CommonPage.restPage(waterQualitySites));
    }

    @RequestMapping(value = "/getQualityEvaluationByStation", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<WaterQualityEvaluationDto> getQualityEvaluationByStation(@RequestParam(value = "stationId",required = false) String stationId,
                                                                                                 @RequestParam(value = "areaId",required = false) String areaId,
                                                                                                 @RequestParam(value = "indicatorId",required = false) String indicatorId,
                                                                                                 @RequestParam(value = "period",required = false) String period,
                                                                                                 @RequestParam(value = "startTime",required = false) String startTime,
                                                                                                 @RequestParam(value = "endTime",required = false) String endTime) {
        WaterQualityEvaluationDto waterQualityEvaluationDto = waterQuality.getQualityEvaluationByStation(stationId,areaId,indicatorId,period,startTime,endTime);
        return CommonResult.success(waterQualityEvaluationDto);
    }

}
