package com.suchness.intellisense.mapper;

import com.suchness.intellisense.model.RoleResourceRelation;
import com.suchness.intellisense.model.RoleResourceRelationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RoleResourceRelationMapper {
    long countByExample(RoleResourceRelationExample example);

    int deleteByExample(RoleResourceRelationExample example);

    int deleteByPrimaryKey(Long id);

    int insert(RoleResourceRelation record);

    int insertSelective(RoleResourceRelation record);

    List<RoleResourceRelation> selectByExample(RoleResourceRelationExample example);

    RoleResourceRelation selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") RoleResourceRelation record, @Param("example") RoleResourceRelationExample example);

    int updateByExample(@Param("record") RoleResourceRelation record, @Param("example") RoleResourceRelationExample example);

    int updateByPrimaryKeySelective(RoleResourceRelation record);

    int updateByPrimaryKey(RoleResourceRelation record);
}