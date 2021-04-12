package com.suchness.intellisense.mapper;

import com.suchness.intellisense.model.RiverArea;
import com.suchness.intellisense.model.RiverAreaExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RiverAreaMapper {
    long countByExample(RiverAreaExample example);

    int deleteByExample(RiverAreaExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(RiverArea record);

    int insertSelective(RiverArea record);

    List<RiverArea> selectByExample(RiverAreaExample example);

    RiverArea selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") RiverArea record, @Param("example") RiverAreaExample example);

    int updateByExample(@Param("record") RiverArea record, @Param("example") RiverAreaExample example);

    int updateByPrimaryKeySelective(RiverArea record);

    int updateByPrimaryKey(RiverArea record);
}