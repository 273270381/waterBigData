package com.suchness.intellisense.mapper;

import com.suchness.intellisense.model.WaterRealTimeData;
import com.suchness.intellisense.model.WaterRealTimeDataExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WaterRealTimeDataMapper {
    long countByExample(WaterRealTimeDataExample example);

    int deleteByExample(WaterRealTimeDataExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WaterRealTimeData record);

    int insertSelective(WaterRealTimeData record);

    List<WaterRealTimeData> selectByExample(WaterRealTimeDataExample example);

    WaterRealTimeData selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WaterRealTimeData record, @Param("example") WaterRealTimeDataExample example);

    int updateByExample(@Param("record") WaterRealTimeData record, @Param("example") WaterRealTimeDataExample example);

    int updateByPrimaryKeySelective(WaterRealTimeData record);

    int updateByPrimaryKey(WaterRealTimeData record);
}