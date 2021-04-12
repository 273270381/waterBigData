package com.suchness.intellisense.mapper;

import com.suchness.intellisense.model.RiverPatrolData;
import com.suchness.intellisense.model.RiverPatrolDataExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RiverPatrolDataMapper {
    long countByExample(RiverPatrolDataExample example);

    int deleteByExample(RiverPatrolDataExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(RiverPatrolData record);

    int insertSelective(RiverPatrolData record);

    List<RiverPatrolData> selectByExample(RiverPatrolDataExample example);

    RiverPatrolData selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") RiverPatrolData record, @Param("example") RiverPatrolDataExample example);

    int updateByExample(@Param("record") RiverPatrolData record, @Param("example") RiverPatrolDataExample example);

    int updateByPrimaryKeySelective(RiverPatrolData record);

    int updateByPrimaryKey(RiverPatrolData record);
}