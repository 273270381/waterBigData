package com.suchness.intellisense.mapper;

import com.suchness.intellisense.model.DrainageArea;
import com.suchness.intellisense.model.DrainageAreaExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DrainageAreaMapper {
    long countByExample(DrainageAreaExample example);

    int deleteByExample(DrainageAreaExample example);

    int deleteByPrimaryKey(Long id);

    int insert(DrainageArea record);

    int insertSelective(DrainageArea record);

    List<DrainageArea> selectByExample(DrainageAreaExample example);

    DrainageArea selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") DrainageArea record, @Param("example") DrainageAreaExample example);

    int updateByExample(@Param("record") DrainageArea record, @Param("example") DrainageAreaExample example);

    int updateByPrimaryKeySelective(DrainageArea record);

    int updateByPrimaryKey(DrainageArea record);
}