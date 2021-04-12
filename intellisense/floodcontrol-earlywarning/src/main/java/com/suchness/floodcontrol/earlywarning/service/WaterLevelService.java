package com.suchness.floodcontrol.earlywarning.service;



import com.suchness.floodcontrol.earlywarning.dto.WaterLevelDayDto;
import com.suchness.floodcontrol.earlywarning.dto.WaterLevelMonthDto;
import com.suchness.floodcontrol.earlywarning.dto.WaterLevelYearDto;
import com.suchness.intellisense.model.WaterLevelDay;
import com.suchness.intellisense.model.WaterLevelMonth;
import com.suchness.intellisense.model.WaterLevelYear;

import java.util.Date;
import java.util.List;

/**
 * @Author wangchan
 * @Date 14:45 2021/1/6
 * @Param
 * @Return
 * @Description
**/

public interface WaterLevelService {

    /**
     * 根据date获取水位日报表列表
     */

     List<WaterLevelDayDto> getDayListByDate(String date);

/**
 * 根据date获取水位月报表列表
 */
       List<WaterLevelMonth>  getMonthListByDate(String date);


    /**
     * 水位日报表列表
     */
    List<WaterLevelDay> getAllList();

    /**
     * 水位日报表列表
     */
    List<WaterLevelDayDto> list(String stationId, String date, Integer pageSize, Integer pageNum);


    /**
     * 水位月报表列表
     */
    List<WaterLevelMonthDto> monthList(String stationId, String date, Integer pageSize, Integer pageNum);


    /**
     * 水位年报表列表
     */
    List<WaterLevelYearDto> yearList(String stationId, String date, Integer pageSize, Integer pageNum);

    /**
     * 根据月份获取月报表
     *
     */
    List<WaterLevelMonth> getAllMonthListByDate(String date);


    /**
     * 更新月报表
     *
     */
    void   updateMonth(String stationId,String date,Double  rainLevel,String rainDay);

    /**
     * 更新月报表
     *
     */
    void   insertMonth(String stationId,String date,Double  rainLevel,String rainDay);
}
