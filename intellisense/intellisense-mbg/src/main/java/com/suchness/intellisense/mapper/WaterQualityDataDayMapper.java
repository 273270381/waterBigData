package com.suchness.intellisense.mapper;

import com.suchness.intellisense.model.WaterQualityDataDay;
import com.suchness.intellisense.model.WaterQualityDataDayExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WaterQualityDataDayMapper {
    long countByExample(WaterQualityDataDayExample example);

    int deleteByExample(WaterQualityDataDayExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WaterQualityDataDay record);

    int insertSelective(WaterQualityDataDay record);

    List<WaterQualityDataDay> selectByExample(WaterQualityDataDayExample example);

    WaterQualityDataDay selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WaterQualityDataDay record, @Param("example") WaterQualityDataDayExample example);

    int updateByExample(@Param("record") WaterQualityDataDay record, @Param("example") WaterQualityDataDayExample example);

    int updateByPrimaryKeySelective(WaterQualityDataDay record);

    int updateByPrimaryKey(WaterQualityDataDay record);
}