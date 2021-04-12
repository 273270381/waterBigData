package com.suchness.intellisense.mapper;

import com.suchness.intellisense.model.WaterQualityDataWeek;
import com.suchness.intellisense.model.WaterQualityDataWeekExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WaterQualityDataWeekMapper {
    long countByExample(WaterQualityDataWeekExample example);

    int deleteByExample(WaterQualityDataWeekExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WaterQualityDataWeek record);

    int insertSelective(WaterQualityDataWeek record);

    List<WaterQualityDataWeek> selectByExample(WaterQualityDataWeekExample example);

    WaterQualityDataWeek selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WaterQualityDataWeek record, @Param("example") WaterQualityDataWeekExample example);

    int updateByExample(@Param("record") WaterQualityDataWeek record, @Param("example") WaterQualityDataWeekExample example);

    int updateByPrimaryKeySelective(WaterQualityDataWeek record);

    int updateByPrimaryKey(WaterQualityDataWeek record);
}