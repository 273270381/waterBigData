package com.suchness.intellisense.mapper;

import com.suchness.intellisense.model.HydrologyStation;
import com.suchness.intellisense.model.HydrologyStationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HydrologyStationMapper {
    long countByExample(HydrologyStationExample example);

    int deleteByExample(HydrologyStationExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(HydrologyStation record);

    int insertSelective(HydrologyStation record);

    List<HydrologyStation> selectByExample(HydrologyStationExample example);

    HydrologyStation selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") HydrologyStation record, @Param("example") HydrologyStationExample example);

    int updateByExample(@Param("record") HydrologyStation record, @Param("example") HydrologyStationExample example);

    int updateByPrimaryKeySelective(HydrologyStation record);

    int updateByPrimaryKey(HydrologyStation record);
}