package com.suchness.intellisense.mapper;

import com.suchness.intellisense.model.WaterLevelMonth;
import com.suchness.intellisense.model.WaterLevelMonthExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WaterLevelMonthMapper {
    long countByExample(WaterLevelMonthExample example);

    int deleteByExample(WaterLevelMonthExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WaterLevelMonth record);

    int insertSelective(WaterLevelMonth record);

    List<WaterLevelMonth> selectByExample(WaterLevelMonthExample example);

    WaterLevelMonth selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WaterLevelMonth record, @Param("example") WaterLevelMonthExample example);

    int updateByExample(@Param("record") WaterLevelMonth record, @Param("example") WaterLevelMonthExample example);

    int updateByPrimaryKeySelective(WaterLevelMonth record);

    int updateByPrimaryKey(WaterLevelMonth record);
}