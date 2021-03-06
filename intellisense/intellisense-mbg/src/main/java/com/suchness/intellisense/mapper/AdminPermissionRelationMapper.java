package com.suchness.intellisense.mapper;

import com.suchness.intellisense.model.AdminPermissionRelation;
import com.suchness.intellisense.model.AdminPermissionRelationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdminPermissionRelationMapper {
    long countByExample(AdminPermissionRelationExample example);

    int deleteByExample(AdminPermissionRelationExample example);

    int deleteByPrimaryKey(Long id);

    int insert(AdminPermissionRelation record);

    int insertSelective(AdminPermissionRelation record);

    List<AdminPermissionRelation> selectByExample(AdminPermissionRelationExample example);

    AdminPermissionRelation selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AdminPermissionRelation record, @Param("example") AdminPermissionRelationExample example);

    int updateByExample(@Param("record") AdminPermissionRelation record, @Param("example") AdminPermissionRelationExample example);

    int updateByPrimaryKeySelective(AdminPermissionRelation record);

    int updateByPrimaryKey(AdminPermissionRelation record);
}