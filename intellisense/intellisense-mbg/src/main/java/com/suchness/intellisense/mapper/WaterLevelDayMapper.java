package com.suchness.intellisense.mapper;

import com.suchness.intellisense.model.WaterLevelDay;
import com.suchness.intellisense.model.WaterLevelDayExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WaterLevelDayMapper {
    long countByExample(WaterLevelDayExample example);

    int deleteByExample(WaterLevelDayExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WaterLevelDay record);

    int insertSelective(WaterLevelDay record);

    List<WaterLevelDay> selectByExample(WaterLevelDayExample example);

    WaterLevelDay selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WaterLevelDay record, @Param("example") WaterLevelDayExample example);

    int updateByExample(@Param("record") WaterLevelDay record, @Param("example") WaterLevelDayExample example);

    int updateByPrimaryKeySelective(WaterLevelDay record);

    int updateByPrimaryKey(WaterLevelDay record);
}