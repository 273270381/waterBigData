package com.suchness.intellisense.mapper;

import com.suchness.intellisense.model.Rivers;
import com.suchness.intellisense.model.RiversExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RiversMapper {
    long countByExample(RiversExample example);

    int deleteByExample(RiversExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Rivers record);

    int insertSelective(Rivers record);

    List<Rivers> selectByExample(RiversExample example);

    Rivers selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Rivers record, @Param("example") RiversExample example);

    int updateByExample(@Param("record") Rivers record, @Param("example") RiversExample example);

    int updateByPrimaryKeySelective(Rivers record);

    int updateByPrimaryKey(Rivers record);
}