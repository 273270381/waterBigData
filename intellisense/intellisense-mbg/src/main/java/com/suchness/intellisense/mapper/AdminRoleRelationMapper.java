package com.suchness.intellisense.mapper;

import com.suchness.intellisense.model.AdminRoleRelation;
import com.suchness.intellisense.model.AdminRoleRelationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdminRoleRelationMapper {
    long countByExample(AdminRoleRelationExample example);

    int deleteByExample(AdminRoleRelationExample example);

    int deleteByPrimaryKey(Long id);

    int insert(AdminRoleRelation record);

    int insertSelective(AdminRoleRelation record);

    List<AdminRoleRelation> selectByExample(AdminRoleRelationExample example);

    AdminRoleRelation selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AdminRoleRelation record, @Param("example") AdminRoleRelationExample example);

    int updateByExample(@Param("record") AdminRoleRelation record, @Param("example") AdminRoleRelationExample example);

    int updateByPrimaryKeySelective(AdminRoleRelation record);

    int updateByPrimaryKey(AdminRoleRelation record);
}