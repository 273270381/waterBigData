package com.suchness.waterquality.monitor.service;

import com.github.pagehelper.PageInfo;
import com.suchness.intellisense.model.WaterQualityHistoryData;
import com.suchness.intellisense.model.WaterQualitySite;
import com.suchness.waterquality.monitor.dto.WaterQualityDto;
import com.suchness.waterquality.monitor.dto.WaterQualityEvaluationDto;
import com.suchness.waterquality.monitor.dto.WaterQualityInfoDto;

import java.util.List;

/***
 *  author: rushi
 *  create_time : 2021/1/68:45
 *******/
public interface WaterQuality {

    WaterQualityDto listRealTimeData();

    WaterQualitySite getStationInfoByName(String name);

    List<WaterQualitySite> listStations();

    List<WaterQualityHistoryData> listHistoryData(String stationId, String startTime, String endTime, Integer pageSize, Integer pageNum);

    WaterQualityEvaluationDto getQualityEvaluationByStation(String stationId, String areaId, String indicatorId, String period, String startTime,String endTime);
}
