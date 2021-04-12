package com.suchness.intellisense.mapper;

import com.suchness.intellisense.model.RiverTrack;
import com.suchness.intellisense.model.RiverTrackExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RiverTrackMapper {
    long countByExample(RiverTrackExample example);

    int deleteByExample(RiverTrackExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(RiverTrack record);

    int insertSelective(RiverTrack record);

    List<RiverTrack> selectByExampleWithBLOBs(RiverTrackExample example);

    List<RiverTrack> selectByExample(RiverTrackExample example);

    RiverTrack selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") RiverTrack record, @Param("example") RiverTrackExample example);

    int updateByExampleWithBLOBs(@Param("record") RiverTrack record, @Param("example") RiverTrackExample example);

    int updateByExample(@Param("record") RiverTrack record, @Param("example") RiverTrackExample example);

    int updateByPrimaryKeySelective(RiverTrack record);

    int updateByPrimaryKeyWithBLOBs(RiverTrack record);
}