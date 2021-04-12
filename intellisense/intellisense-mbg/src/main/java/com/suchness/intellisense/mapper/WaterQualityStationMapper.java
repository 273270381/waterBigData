package com.suchness.intellisense.mapper;

import com.suchness.intellisense.model.WaterQualityStation;
import com.suchness.intellisense.model.WaterQualityStationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WaterQualityStationMapper {
    long countByExample(WaterQualityStationExample example);

    int deleteByExample(WaterQualityStationExample example);

    int deleteByPrimaryKey(Long id);

    int insert(WaterQualityStation record);

    int insertSelective(WaterQualityStation record);

    List<WaterQualityStation> selectByExample(WaterQualityStationExample example);

    WaterQualityStation selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") WaterQualityStation record, @Param("example") WaterQualityStationExample example);

    int updateByExample(@Param("record") WaterQualityStation record, @Param("example") WaterQualityStationExample example);

    int updateByPrimaryKeySelective(WaterQualityStation record);

    int updateByPrimaryKey(WaterQualityStation record);
}