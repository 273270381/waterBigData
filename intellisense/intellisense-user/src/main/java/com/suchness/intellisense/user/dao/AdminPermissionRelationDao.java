package com.suchness.intellisense.user.dao;

import com.suchness.intellisense.model.AdminPermissionRelation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/***
 *  author: rushi
 *  create_time : 2020/11/2510:56
 *******/
public interface AdminPermissionRelationDao {
    /**
     * 批量创建
     */
    int insertList(@Param("list") List<AdminPermissionRelation> list);
}
