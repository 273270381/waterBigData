package com.suchness.floodcontrol.earlywarning.service.impl;

import cn.hutool.db.sql.SqlUtil;
import com.github.pagehelper.PageHelper;
import com.suchness.floodcontrol.earlywarning.dao.WaterLevelMapper;
import com.suchness.floodcontrol.earlywarning.dto.WaterLevelDayDto;
import com.suchness.floodcontrol.earlywarning.dto.WaterLevelMonthDto;
import com.suchness.floodcontrol.earlywarning.dto.WaterLevelYearDto;
import com.suchness.floodcontrol.earlywarning.service.WaterLevelService;
import com.suchness.intellisense.mapper.WaterLevelDayMapper;
import com.suchness.intellisense.mapper.WaterLevelMonthMapper;
import com.suchness.intellisense.mapper.WaterLevelYearMapper;
import com.suchness.intellisense.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * @Author wangchan
 * @Date 9:54 2021/1/12
 * @Param
 * @Return
 * @Description  水位service
**/


@Service
public class WaterLevelServiceImpl implements WaterLevelService {


    @Autowired
    private WaterLevelDayMapper waterLevelDayMapper;
    @Autowired
    private WaterLevelMonthMapper waterLevelMonthMapper;
    @Autowired
    private WaterLevelYearMapper waterLevelYearMapper;


    @Autowired
    private WaterLevelMapper waterLevelMapper;

    /**
     * @Author wangchan
     * @Date 9:54 2021/1/12
     * @Param [date]
     * @Return java.util.List<com.suchness.floodcontrol.earlywarning.dto.WaterLevelDayDto>
     * @Description    根据日期查询所有站点的水位日数据
    **/

    @Override
    public List<WaterLevelDayDto> getDayListByDate(String date) {
        WaterLevelDayExample example = new WaterLevelDayExample();
        example.setOrderByClause("day");
        WaterLevelDayExample.Criteria criteria = example.createCriteria();

        if(!StringUtils.isEmpty(date)){
            criteria .andDayLike( date + "%");
        }
        List<WaterLevelDay> waterLevelDays = waterLevelDayMapper.selectByExample(example);
        List<WaterLevelDayDto>waterLevelDayDtoList=new ArrayList<>();
        for (WaterLevelDay waterLevelDay:waterLevelDays){
            WaterLevelDayDto waterLevelDayDto=new WaterLevelDayDto(waterLevelDay);
            waterLevelDayDtoList.add(waterLevelDayDto);
        }
        return waterLevelDayDtoList;
    }
    /**
     * @Author wangchan
     * @Date 9:55 2021/1/12
     * @Param [date]
     * @Return java.util.List<com.suchness.intellisense.model.WaterLevelMonth>
     * @Description   根据日期查询所有站点月数据
    **/


    @Override
    public List<WaterLevelMonth> getMonthListByDate(String date) {
        WaterLevelMonthExample example = new WaterLevelMonthExample();
        WaterLevelMonthExample.Criteria criteria = example.createCriteria();

        if(!StringUtils.isEmpty(date)){
            criteria .andDateLike( date + "%");
        }
        List<WaterLevelMonth> waterLevelMonths = waterLevelMonthMapper.selectByExample(example);

        return  waterLevelMonths;


    }

    @Override
    public List<WaterLevelDay> getAllList() {

        WaterLevelDayExample example = new WaterLevelDayExample();
        example.setOrderByClause("day");

        List<WaterLevelDay> waterLevelDays = waterLevelDayMapper.selectByExample(example);


        return waterLevelDays;
    }
    /**
     * @Author wangchan
     * @Date 9:56 2021/1/12
     * @Param [stationId, date, pageSize, pageNum]
     * @Return java.util.List<com.suchness.floodcontrol.earlywarning.dto.WaterLevelDayDto>
     * @Description  水位日报表接口
    **/


    @Override
    public List<WaterLevelDayDto> list(String stationId, String date, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        WaterLevelDayExample example = new WaterLevelDayExample();
       example.setOrderByClause("day");
        WaterLevelDayExample.Criteria criteria = example.createCriteria();
        if (!StringUtils.isEmpty(stationId)) {
            criteria .andStationIdEqualTo(stationId);
        }
        if(!StringUtils.isEmpty(date)){
            criteria .andDayLike( date + "%");
        }
        List<WaterLevelDay> waterLevelDays = waterLevelDayMapper.selectByExample(example);
        List<WaterLevelDayDto>waterLevelDayDtoList=new ArrayList<>();
        for (WaterLevelDay waterLevelDay:waterLevelDays){
            WaterLevelDayDto waterLevelDayDto=new WaterLevelDayDto(waterLevelDay);
             waterLevelDayDtoList.add(waterLevelDayDto);
        }

        return  waterLevelDayDtoList;
    }
    /**
     * @Author wangchan
     * @Date 9:56 2021/1/12
     * @Param [stationId, date, pageSize, pageNum]
     * @Return java.util.List<com.suchness.floodcontrol.earlywarning.dto.WaterLevelMonthDto>
     * @Description  水位月报表
    **/


    @Override
    public List<WaterLevelMonthDto> monthList(String stationId, String date, Integer pageSize, Integer pageNum) {


        PageHelper.startPage(pageNum, pageSize);
        WaterLevelMonthExample example = new WaterLevelMonthExample();
        example.setOrderByClause("date");
        WaterLevelMonthExample.Criteria criteria = example.createCriteria();
        if (!StringUtils.isEmpty(stationId)) {
            criteria .andStationidEqualTo(stationId);
        }
        if(!StringUtils.isEmpty(date)){
            criteria .andDateLike( date + "%");
        }
        List<WaterLevelMonth> waterLevelMonths = waterLevelMonthMapper.selectByExample(example);
        List<WaterLevelMonthDto>waterLevelMonthDtoList=new ArrayList<>();
        for (WaterLevelMonth waterLevelMonth:waterLevelMonths){
            WaterLevelMonthDto waterLevelMonthDto=new WaterLevelMonthDto(waterLevelMonth);
            waterLevelMonthDtoList.add(waterLevelMonthDto);
        }

        return  waterLevelMonthDtoList;
    }
    /**
     * @Author wangchan
     * @Date 9:56 2021/1/12
     * @Param [stationId, date, pageSize, pageNum]
     * @Return java.util.List<com.suchness.floodcontrol.earlywarning.dto.WaterLevelYearDto>
     * @Description  水位年报表
    **/


    @Override
    public List<WaterLevelYearDto> yearList(String stationId, String date, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        WaterLevelYearExample  example = new WaterLevelYearExample();
        example.setOrderByClause("date");
        WaterLevelYearExample.Criteria criteria = example.createCriteria();
        if (!StringUtils.isEmpty(stationId)) {
            criteria .andStationidEqualTo(stationId);
        }
        if(!StringUtils.isEmpty(date)){
            criteria .andDateLike( date + "%");
        }
        List<WaterLevelYear> waterLevelMonths = waterLevelYearMapper.selectByExample(example);
        List<WaterLevelYearDto>waterLevelYearDtoArrayList=new ArrayList<>();
        for (WaterLevelYear waterLevelYear:waterLevelMonths){
            WaterLevelYearDto waterLevelYearDto=new WaterLevelYearDto(waterLevelYear);
            waterLevelYearDtoArrayList.add(waterLevelYearDto);
        }

        return  waterLevelYearDtoArrayList;
    }

    /**
     * @Author wangchan
     * @Date 9:57 2021/1/12
     * @Param [date]
     * @Return java.util.List<com.suchness.intellisense.model.WaterLevelMonth>
     * @Description 根据月份获取月报表
    **/

    @Override
    public List<WaterLevelMonth> getAllMonthListByDate(String date) {

        WaterLevelMonthExample example = new WaterLevelMonthExample();
        example.setOrderByClause("date");
        WaterLevelMonthExample.Criteria criteria = example.createCriteria();

        if(!StringUtils.isEmpty(date)){
            criteria .andDateLike( date + "%");
        }
        List<WaterLevelMonth> waterLevelMonths = waterLevelMonthMapper.selectByExample(example);

        return  waterLevelMonths;
    }

    @Override
    public void updateMonth(String stationId, String date, Double rainLevel,String rainDay) {
     String sql="update water_level_month set  {0}={1,number,0.00} WHERE stationId={2} and date={3}";
     String resultSql="";
        resultSql = MessageFormat.format(sql, rainDay, rainLevel, stationId,"'"+date+"'");
     waterLevelMapper.updateMonth(resultSql);
    }

    @Override
    public void insertMonth(String stationId, String date, Double rainLevel, String rainDay) {
        String sql="insert into water_level_month(stationId,date,{0}) VALUES({1},{2},{3,number,0.00})";
        String resultSql="";
        resultSql = MessageFormat.format(sql, rainDay, stationId, "'"+date+"'",rainLevel);
        waterLevelMapper.insertMonth(resultSql);
        System.out.println(resultSql);
    }
}
