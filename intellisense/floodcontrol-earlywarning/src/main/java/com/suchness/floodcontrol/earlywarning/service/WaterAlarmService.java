package com.suchness.floodcontrol.earlywarning.service;

import com.suchness.floodcontrol.earlywarning.dto.WaterAlarmDto;

import java.util.List;

/***
 *  author: rushi
 *  create_time : 2021/1/49:48
 *******/
public interface WaterAlarmService {

    List<WaterAlarmDto> getWaterRealTimeAlarm(Integer pageSize, Integer pageNum);

    List<WaterAlarmDto> getWaterHistoryAlarm(Integer pageSize, Integer pageNum, String stationId, String startTime, String endTime);
}
