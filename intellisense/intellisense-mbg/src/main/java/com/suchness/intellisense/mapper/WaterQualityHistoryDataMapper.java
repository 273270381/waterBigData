package com.suchness.intellisense.mapper;

import com.suchness.intellisense.model.WaterQualityHistoryData;
import com.suchness.intellisense.model.WaterQualityHistoryDataExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WaterQualityHistoryDataMapper {
    long countByExample(WaterQualityHistoryDataExample example);

    int deleteByExample(WaterQualityHistoryDataExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WaterQualityHistoryData record);

    int insertSelective(WaterQualityHistoryData record);

    List<WaterQualityHistoryData> selectByExample(WaterQualityHistoryDataExample example);

    WaterQualityHistoryData selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WaterQualityHistoryData record, @Param("example") WaterQualityHistoryDataExample example);

    int updateByExample(@Param("record") WaterQualityHistoryData record, @Param("example") WaterQualityHistoryDataExample example);

    int updateByPrimaryKeySelective(WaterQualityHistoryData record);

    int updateByPrimaryKey(WaterQualityHistoryData record);
}