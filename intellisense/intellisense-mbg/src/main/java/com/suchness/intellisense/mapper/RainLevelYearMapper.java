package com.suchness.intellisense.mapper;

import com.suchness.intellisense.model.RainLevelYear;
import com.suchness.intellisense.model.RainLevelYearExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RainLevelYearMapper {
    long countByExample(RainLevelYearExample example);

    int deleteByExample(RainLevelYearExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(RainLevelYear record);

    int insertSelective(RainLevelYear record);

    List<RainLevelYear> selectByExample(RainLevelYearExample example);

    RainLevelYear selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") RainLevelYear record, @Param("example") RainLevelYearExample example);

    int updateByExample(@Param("record") RainLevelYear record, @Param("example") RainLevelYearExample example);

    int updateByPrimaryKeySelective(RainLevelYear record);

    int updateByPrimaryKey(RainLevelYear record);
}