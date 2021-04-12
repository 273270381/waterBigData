package com.suchness.intellisense.mapper;

import com.suchness.intellisense.model.WaterHistoryData;
import com.suchness.intellisense.model.WaterHistoryDataExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WaterHistoryDataMapper {
    long countByExample(WaterHistoryDataExample example);

    int deleteByExample(WaterHistoryDataExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WaterHistoryData record);

    int insertSelective(WaterHistoryData record);

    List<WaterHistoryData> selectByExample(WaterHistoryDataExample example);

    WaterHistoryData selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WaterHistoryData record, @Param("example") WaterHistoryDataExample example);

    int updateByExample(@Param("record") WaterHistoryData record, @Param("example") WaterHistoryDataExample example);

    int updateByPrimaryKeySelective(WaterHistoryData record);

    int updateByPrimaryKey(WaterHistoryData record);
}