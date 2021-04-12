package com.suchness.waterquality.monitor.dao;

import com.suchness.waterquality.monitor.dto.WaterQualityInfoDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


import java.util.Date;
import java.util.List;

/***
 *  author: rushi
 *  create_time : 2021/1/69:36
 *******/
@Mapper
public interface WaterQualityDao {

    List<WaterQualityInfoDto> getRealTimeData();

    List<WaterQualityInfoDto> getHistoryData();

    List<WaterQualityInfoDto> getQualityEvaluationByStation(@Param("stationId") String stationId,
                                                            @Param("areaId") String areaId,
                                                            @Param("indicatorId") String indicatorId,
                                                            @Param("callbackTimeStart") String callbackTimeStart,
                                                            @Param("endTime") String endTime);


    WaterQualityInfoDto getQualityStationInfo(@Param("stationId") String stationId);
}
