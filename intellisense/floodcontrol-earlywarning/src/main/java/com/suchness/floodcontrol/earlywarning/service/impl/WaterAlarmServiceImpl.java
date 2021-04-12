package com.suchness.floodcontrol.earlywarning.service.impl;

import com.github.pagehelper.PageHelper;
import com.suchness.floodcontrol.earlywarning.dao.WaterAlarmDao;
import com.suchness.floodcontrol.earlywarning.dto.WaterAlarmDto;
import com.suchness.floodcontrol.earlywarning.service.WaterAlarmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/***
 *  author: rushi
 *  create_time : 2021/1/49:48
 *******/
@Service
public class WaterAlarmServiceImpl implements WaterAlarmService {

    @Autowired
    private WaterAlarmDao waterAlarmDao;

    @Override
    public List<WaterAlarmDto> getWaterRealTimeAlarm(Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        List<WaterAlarmDto> waterAlarmDtoList = waterAlarmDao.getWaterRealTimeAlarm();
        return waterAlarmDtoList;
    }

    @Override
    public List<WaterAlarmDto> getWaterHistoryAlarm(Integer pageSize, Integer pageNum, String stationId, String startTime, String endTime) {
        PageHelper.startPage(pageNum, pageSize);
        List<WaterAlarmDto> waterAlarmDtoList = waterAlarmDao.getWaterHistoryAlarm(stationId,startTime,endTime);
        return waterAlarmDtoList;
    }
}
