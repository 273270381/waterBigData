package com.suchness.floodcontrol.earlywarning.dao;

import com.suchness.floodcontrol.earlywarning.dto.WaterQualityCompDto;
import com.suchness.floodcontrol.earlywarning.dto.WaterQualityInfoDto;
import com.suchness.floodcontrol.earlywarning.dto.WaterQualityMathBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface WaterQualityMapper {

    WaterQualityMathBean  getWaterQualityDayBean(@Param("site_id") Integer siteId, @Param("date_time") String dateTime);


    WaterQualityMathBean  getWaterQualityWeekBean(@Param("site_id") Integer siteId,  List<String> dates);

    WaterQualityMathBean  getWaterQualityMonthBean(@Param("site_id") Integer siteId, @Param("date_time") String dateTime);


    WaterQualityMathBean  getWaterQualityYearBean(@Param("site_id") Integer siteId, @Param("date_time") String dateTime);

      List<WaterQualityInfoDto> getQualityEvaluationByStation(
                                                                                 @Param("areaId") Integer areaId,
                                                                                 List<String> dates
                                                                                );


    List<WaterQualityInfoDto> getQualityEvaluationByStationByMonth(@Param("areaId") Integer areaId, @Param("date_time") String date);
}
