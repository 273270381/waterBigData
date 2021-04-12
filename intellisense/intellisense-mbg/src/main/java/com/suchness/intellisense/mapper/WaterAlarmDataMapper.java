package com.suchness.intellisense.mapper;

import com.suchness.intellisense.model.WaterAlarmData;
import com.suchness.intellisense.model.WaterAlarmDataExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WaterAlarmDataMapper {
    long countByExample(WaterAlarmDataExample example);

    int deleteByExample(WaterAlarmDataExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WaterAlarmData record);

    int insertSelective(WaterAlarmData record);

    List<WaterAlarmData> selectByExample(WaterAlarmDataExample example);

    WaterAlarmData selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WaterAlarmData record, @Param("example") WaterAlarmDataExample example);

    int updateByExample(@Param("record") WaterAlarmData record, @Param("example") WaterAlarmDataExample example);

    int updateByPrimaryKeySelective(WaterAlarmData record);

    int updateByPrimaryKey(WaterAlarmData record);
}