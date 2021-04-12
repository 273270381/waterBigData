package com.suchness.intellisense.mapper;

import com.suchness.intellisense.model.WaterQualitySite;
import com.suchness.intellisense.model.WaterQualitySiteExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WaterQualitySiteMapper {
    long countByExample(WaterQualitySiteExample example);

    int deleteByExample(WaterQualitySiteExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WaterQualitySite record);

    int insertSelective(WaterQualitySite record);

    List<WaterQualitySite> selectByExample(WaterQualitySiteExample example);

    WaterQualitySite selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WaterQualitySite record, @Param("example") WaterQualitySiteExample example);

    int updateByExample(@Param("record") WaterQualitySite record, @Param("example") WaterQualitySiteExample example);

    int updateByPrimaryKeySelective(WaterQualitySite record);

    int updateByPrimaryKey(WaterQualitySite record);
}