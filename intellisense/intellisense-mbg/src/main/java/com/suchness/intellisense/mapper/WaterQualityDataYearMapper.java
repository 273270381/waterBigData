package com.suchness.intellisense.mapper;

import com.suchness.intellisense.model.WaterQualityDataYear;
import com.suchness.intellisense.model.WaterQualityDataYearExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WaterQualityDataYearMapper {
    long countByExample(WaterQualityDataYearExample example);

    int deleteByExample(WaterQualityDataYearExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WaterQualityDataYear record);

    int insertSelective(WaterQualityDataYear record);

    List<WaterQualityDataYear> selectByExample(WaterQualityDataYearExample example);

    WaterQualityDataYear selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WaterQualityDataYear record, @Param("example") WaterQualityDataYearExample example);

    int updateByExample(@Param("record") WaterQualityDataYear record, @Param("example") WaterQualityDataYearExample example);

    int updateByPrimaryKeySelective(WaterQualityDataYear record);

    int updateByPrimaryKey(WaterQualityDataYear record);
}