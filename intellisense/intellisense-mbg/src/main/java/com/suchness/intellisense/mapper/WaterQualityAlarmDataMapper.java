package com.suchness.intellisense.mapper;

import com.suchness.intellisense.model.WaterQualityAlarmData;
import com.suchness.intellisense.model.WaterQualityAlarmDataExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WaterQualityAlarmDataMapper {
    long countByExample(WaterQualityAlarmDataExample example);

    int deleteByExample(WaterQualityAlarmDataExample example);

    int deleteByPrimaryKey(Long id);

    int insert(WaterQualityAlarmData record);

    int insertSelective(WaterQualityAlarmData record);

    List<WaterQualityAlarmData> selectByExample(WaterQualityAlarmDataExample example);

    WaterQualityAlarmData selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") WaterQualityAlarmData record, @Param("example") WaterQualityAlarmDataExample example);

    int updateByExample(@Param("record") WaterQualityAlarmData record, @Param("example") WaterQualityAlarmDataExample example);

    int updateByPrimaryKeySelective(WaterQualityAlarmData record);

    int updateByPrimaryKey(WaterQualityAlarmData record);
}