package com.suchness.intellisense.mapper;

import com.suchness.intellisense.model.WaterQualityRealData;
import com.suchness.intellisense.model.WaterQualityRealDataExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WaterQualityRealDataMapper {
    long countByExample(WaterQualityRealDataExample example);

    int deleteByExample(WaterQualityRealDataExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WaterQualityRealData record);

    int insertSelective(WaterQualityRealData record);

    List<WaterQualityRealData> selectByExample(WaterQualityRealDataExample example);

    WaterQualityRealData selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WaterQualityRealData record, @Param("example") WaterQualityRealDataExample example);

    int updateByExample(@Param("record") WaterQualityRealData record, @Param("example") WaterQualityRealDataExample example);

    int updateByPrimaryKeySelective(WaterQualityRealData record);

    int updateByPrimaryKey(WaterQualityRealData record);
}