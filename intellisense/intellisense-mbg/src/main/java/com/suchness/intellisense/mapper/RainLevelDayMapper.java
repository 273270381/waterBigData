package com.suchness.intellisense.mapper;

import com.suchness.intellisense.model.RainLevelDay;
import com.suchness.intellisense.model.RainLevelDayExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RainLevelDayMapper {
    long countByExample(RainLevelDayExample example);

    int deleteByExample(RainLevelDayExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(RainLevelDay record);

    int insertSelective(RainLevelDay record);

    List<RainLevelDay> selectByExample(RainLevelDayExample example);

    RainLevelDay selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") RainLevelDay record, @Param("example") RainLevelDayExample example);

    int updateByExample(@Param("record") RainLevelDay record, @Param("example") RainLevelDayExample example);

    int updateByPrimaryKeySelective(RainLevelDay record);

    int updateByPrimaryKey(RainLevelDay record);
}