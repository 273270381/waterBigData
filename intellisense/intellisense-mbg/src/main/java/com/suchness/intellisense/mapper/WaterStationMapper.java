package com.suchness.intellisense.mapper;

import com.suchness.intellisense.model.WaterStation;
import com.suchness.intellisense.model.WaterStationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WaterStationMapper {
    long countByExample(WaterStationExample example);

    int deleteByExample(WaterStationExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WaterStation record);

    int insertSelective(WaterStation record);

    List<WaterStation> selectByExample(WaterStationExample example);

    WaterStation selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WaterStation record, @Param("example") WaterStationExample example);

    int updateByExample(@Param("record") WaterStation record, @Param("example") WaterStationExample example);

    int updateByPrimaryKeySelective(WaterStation record);

    int updateByPrimaryKey(WaterStation record);
}