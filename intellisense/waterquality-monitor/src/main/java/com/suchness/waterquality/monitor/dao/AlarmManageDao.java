package com.suchness.waterquality.monitor.dao;

import com.suchness.waterquality.monitor.dto.AlarmManagerParam;
import org.apache.ibatis.annotations.Param;


import java.util.Date;
import java.util.List;

/**
 * @author hejunfeng
 * @createTime 2020/12/25
 */
public interface AlarmManageDao {
    List<AlarmManagerParam> getAlarmList(@Param("stationName") String stationName, @Param("alarmType") String alarmType,
                                         @Param("status") String status, @Param("startTime") Date startTime, @Param("endTime") Date endTime,
                                         @Param("pageSize") Integer pageSize, @Param("pageNum") Integer pageNum);
}
