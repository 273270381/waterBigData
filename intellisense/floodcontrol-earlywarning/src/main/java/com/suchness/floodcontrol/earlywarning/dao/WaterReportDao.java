package com.suchness.floodcontrol.earlywarning.dao;

import com.suchness.floodcontrol.earlywarning.beans.WaterReportBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/***
 *  author: rushi
 *  create_time : 2020/12/2114:40
 *******/
@Mapper
public interface WaterReportDao {

    List<WaterReportBean> getRealTimeDataList(@Param("code") String code);
}
