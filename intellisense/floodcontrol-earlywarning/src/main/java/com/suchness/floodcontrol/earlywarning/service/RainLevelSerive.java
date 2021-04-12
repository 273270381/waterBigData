package com.suchness.floodcontrol.earlywarning.service;

import com.suchness.floodcontrol.earlywarning.dto.RainLevelDayDto;
import com.suchness.floodcontrol.earlywarning.dto.RainLevelMonthDto;
import com.suchness.floodcontrol.earlywarning.dto.RainLevelYearDto;
import com.suchness.floodcontrol.earlywarning.dto.WaterLevelDayDto;
import com.suchness.intellisense.model.RainLevelMonth;
import com.suchness.intellisense.model.WaterLevelDay;

import java.util.List;

public interface RainLevelSerive {


    /**
     * 雨量日报表列表
     */
    List<RainLevelDayDto> list(String stationId, String date, Integer pageSize, Integer pageNum);

    /**
     * 雨量月报表列表
     */
    List<RainLevelMonthDto> monthList(String stationId, String date, Integer pageSize, Integer pageNum);

    /**
     * 雨量年报表列表
     */
    List<RainLevelYearDto> yearList(String stationId, String date, Integer pageSize, Integer pageNum);

    /**
     * 根据date获取雨量日报表列表
     */

    List<RainLevelDayDto> getDayListByDate(String date);

    /**
     * 根据date获取雨量月报表列表
     */
    List<RainLevelMonth> getMonthListByDate(String month);
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
