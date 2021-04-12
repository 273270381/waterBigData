package com.suchness.intellisense.mapper;

import com.suchness.intellisense.model.WaterLevelYear;
import com.suchness.intellisense.model.WaterLevelYearExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WaterLevelYearMapper {
    long countByExample(WaterLevelYearExample example);

    int deleteByExample(WaterLevelYearExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WaterLevelYear record);

    int insertSelective(WaterLevelYear record);

    List<WaterLevelYear> selectByExample(WaterLevelYearExample example);

    WaterLevelYear selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WaterLevelYear record, @Param("example") WaterLevelYearExample example);

    int updateByExample(@Param("record") WaterLevelYear record, @Param("example") WaterLevelYearExample example);

    int updateByPrimaryKeySelective(WaterLevelYear record);

    int updateByPrimaryKey(WaterLevelYear record);
}