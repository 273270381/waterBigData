package com.suchness.waterquality.monitor.service;

import com.github.pagehelper.PageInfo;
import com.suchness.waterquality.monitor.dto.AlarmCount;
import com.suchness.waterquality.monitor.dto.AlarmCountBat;
import com.suchness.waterquality.monitor.dto.AlarmCountList;
import com.suchness.waterquality.monitor.dto.AlarmManagerParam;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

/**
 * @author hejunfeng
 * @Description 水质报警管理service
 * @createTime 2020/12/19
 */
public interface AlarmService{
    PageInfo<AlarmManagerParam> getWaterAlarm(String stationId, String type, String status, String startTime, String endTime, Integer pageSize, Integer pageNum) throws ParseException;

    List<AlarmCountList> getAlarmMum(String areaName, String startTime, String endTime) throws ParseException;

    Integer addAlarm(Map<String,Object> map) throws ParseException;
}
