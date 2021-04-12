package com.suchness.intellisense.mapper;

import com.suchness.intellisense.model.RiverManagers;
import com.suchness.intellisense.model.RiverManagersExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RiverManagersMapper {
    long countByExample(RiverManagersExample example);

    int deleteByExample(RiverManagersExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(RiverManagers record);

    int insertSelective(RiverManagers record);

    List<RiverManagers> selectByExample(RiverManagersExample example);

    RiverManagers selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") RiverManagers record, @Param("example") RiverManagersExample example);

    int updateByExample(@Param("record") RiverManagers record, @Param("example") RiverManagersExample example);

    int updateByPrimaryKeySelective(RiverManagers record);

    int updateByPrimaryKey(RiverManagers record);
}