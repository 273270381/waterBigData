package com.suchness.intellisense.mapper;

import com.suchness.intellisense.model.RainLevelMonth;
import com.suchness.intellisense.model.RainLevelMonthExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RainLevelMonthMapper {
    long countByExample(RainLevelMonthExample example);

    int deleteByExample(RainLevelMonthExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(RainLevelMonth record);

    int insertSelective(RainLevelMonth record);

    List<RainLevelMonth> selectByExample(RainLevelMonthExample example);

    RainLevelMonth selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") RainLevelMonth record, @Param("example") RainLevelMonthExample example);

    int updateByExample(@Param("record") RainLevelMonth record, @Param("example") RainLevelMonthExample example);

    int updateByPrimaryKeySelective(RainLevelMonth record);

    int updateByPrimaryKey(RainLevelMonth record);
}