package com.suchness.floodcontrol.earlywarning.dao;

import com.suchness.floodcontrol.earlywarning.dto.WaterAlarmDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/***
 *  author: rushi
 *  create_time : 2021/1/410:54
 *******/
@Mapper
public interface WaterAlarmDao {

    List<WaterAlarmDto> getWaterRealTimeAlarm();

    List<WaterAlarmDto> getWaterHistoryAlarm(@Param("stationId") String stationId, @Param("startTime") String startTime, @Param("endTime") String endTime);
}
