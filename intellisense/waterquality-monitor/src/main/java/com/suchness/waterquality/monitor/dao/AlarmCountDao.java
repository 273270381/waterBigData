package com.suchness.waterquality.monitor.dao;

import com.suchness.intellisense.model.DrainageArea;
import com.suchness.waterquality.monitor.dto.AlarmCount;
import com.suchness.waterquality.monitor.dto.Area;
import org.apache.ibatis.annotations.Param;


import java.util.Date;
import java.util.List;

/**
 * @author hejunfeng
 * @createTime 2020/12/21
 */
public interface AlarmCountDao {
    List<AlarmCount> getAlarmCount(@Param("startTime") Date startTime, @Param("endTime") Date endTime);

    List<AlarmCount> getAlarmCountValley(@Param("startTime") Date startTime, @Param("endTime") Date endTime);

    List<Area> getAreas(@Param("dictName") String dictName,@Param("areaName") String areaName);

    List<DrainageArea> getVallrys(@Param("name") String name);
}
