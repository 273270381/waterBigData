package com.suchness.floodcontrol.earlywarning.service;

import com.suchness.floodcontrol.earlywarning.dto.*;
import com.suchness.intellisense.model.WaterQualityDataDay;
import io.swagger.models.auth.In;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Date;
import java.util.List;


public interface WaterQualityDataService {
    public WaterQualityDayDto dayList(Integer siteId, String date, Integer pageSize, Integer pageNum) ;

    public WaterQualityWeekDto weekList(Integer siteId, String date, Integer pageSize, Integer pageNum) throws ParseException;

    public WaterQualityWeekDto monthList(Integer siteId, String date, Integer pageSize, Integer pageNum);

    WaterQualityYearDto yearList(Integer siteId, String date, Integer pageSize, Integer pageNum);

    List<WaterQualityInfoDto> comWeekList(Integer areaId, String date, Integer pageSize, Integer pageNum) throws ParseException;

    List<WaterQualityInfoDto> comMonthList(Integer areaId, String date, Integer pageSize, Integer pageNum);
}
