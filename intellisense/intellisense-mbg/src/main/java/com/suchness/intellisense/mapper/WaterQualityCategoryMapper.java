package com.suchness.intellisense.mapper;

import com.suchness.intellisense.model.WaterQualityCategory;
import com.suchness.intellisense.model.WaterQualityCategoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WaterQualityCategoryMapper {
    long countByExample(WaterQualityCategoryExample example);

    int deleteByExample(WaterQualityCategoryExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WaterQualityCategory record);

    int insertSelective(WaterQualityCategory record);

    List<WaterQualityCategory> selectByExample(WaterQualityCategoryExample example);

    WaterQualityCategory selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WaterQualityCategory record, @Param("example") WaterQualityCategoryExample example);

    int updateByExample(@Param("record") WaterQualityCategory record, @Param("example") WaterQualityCategoryExample example);

    int updateByPrimaryKeySelective(WaterQualityCategory record);

    int updateByPrimaryKey(WaterQualityCategory record);
}