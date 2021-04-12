package com.suchness.floodcontrol.earlywarning.service.impl;

import com.github.pagehelper.PageHelper;
import com.suchness.floodcontrol.earlywarning.dao.RainLevelMapper;
import com.suchness.floodcontrol.earlywarning.dto.*;
import com.suchness.floodcontrol.earlywarning.service.RainLevelSerive;
import com.suchness.intellisense.mapper.RainLevelDayMapper;
import com.suchness.intellisense.mapper.RainLevelMonthMapper;
import com.suchness.intellisense.mapper.RainLevelYearMapper;
import com.suchness.intellisense.model.*;
import com.suchness.intellisense.model.WaterLevelDay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

@Service
public class RainLevelServiceImpl implements RainLevelSerive {
    @Autowired
    private RainLevelDayMapper rainLevelDayMapper;
    @Autowired
    private RainLevelMonthMapper  rainLevelMonthMapper;
    @Autowired
    private RainLevelYearMapper rainLevelYearMapper;
@Autowired
private RainLevelMapper  rainLevelMapper;

    @Override
    public List<RainLevelDayDto> list(String stationId, String date, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        RainLevelDayExample example = new RainLevelDayExample();
        example.setOrderByClause("day");
        RainLevelDayExample.Criteria criteria = example.createCriteria();
        if (!StringUtils.isEmpty(stationId)) {
            criteria .andStationIdEqualTo(stationId);
        }
        if(!StringUtils.isEmpty(date)){
            criteria .andDayLike( date + "%");
        }
        List<RainLevelDay> rainLevelDays = rainLevelDayMapper.selectByExample(example);
        List<RainLevelDayDto>rainLevelDayDtos=new ArrayList<>();
        for (RainLevelDay rainLevelDay:rainLevelDays){
            RainLevelDayDto rainLevelDayDto=new RainLevelDayDto(rainLevelDay);
            rainLevelDayDtos.add(rainLevelDayDto);
        }

        return  rainLevelDayDtos;
    }

    @Override
    public List<RainLevelMonthDto> monthList(String stationId, String date, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        RainLevelMonthExample example = new RainLevelMonthExample();
        example.setOrderByClause("date");
        RainLevelMonthExample.Criteria criteria = example.createCriteria();
        if (!StringUtils.isEmpty(stationId)) {
            criteria .andStationidEqualTo(stationId);
        }
        if(!StringUtils.isEmpty(date)){
            criteria .andDateLike( date + "%");
        }
        List<RainLevelMonth> rainLevelMonths = rainLevelMonthMapper.selectByExample(example);
        List<RainLevelMonthDto>rainLevelMonthDtoList=new ArrayList<>();
        for (RainLevelMonth rainLevelMonth:rainLevelMonths){
            RainLevelMonthDto rainLevelMonthDto=new RainLevelMonthDto(rainLevelMonth);
            rainLevelMonthDtoList.add(rainLevelMonthDto);
        }

        return  rainLevelMonthDtoList;
    }

    @Override
    public List<RainLevelYearDto> yearList(String stationId, String date, Integer pageSize, Integer pageNum) {

        PageHelper.startPage(pageNum, pageSize);
        RainLevelYearExample  example = new RainLevelYearExample();
        example.setOrderByClause("date");
        RainLevelYearExample.Criteria criteria = example.createCriteria();
        if (!StringUtils.isEmpty(stationId)) {
            criteria .andStationidEqualTo(stationId);
        }
        if(!StringUtils.isEmpty(date)){
            criteria .andDateLike( date + "%");
        }
        List<RainLevelYear> rainLevelYears = rainLevelYearMapper.selectByExample(example);
        List<RainLevelYearDto>rainLevelYearDtoList=new ArrayList<>();
        for (RainLevelYear rainLevelYear:rainLevelYears){
            RainLevelYearDto rainLevelYearDto=new RainLevelYearDto(rainLevelYear);
            rainLevelYearDtoList.add(rainLevelYearDto);
        }

        return  rainLevelYearDtoList;
    }

    @Override
    public List<RainLevelDayDto> getDayListByDate(String date) {

        RainLevelDayExample example = new RainLevelDayExample();

        example.setOrderByClause("day");
        RainLevelDayExample.Criteria criteria = example.createCriteria();

        if(!StringUtils.isEmpty(date)){
            criteria .andDayLike( date + "%");
        }
        List<RainLevelDay> rainLevelDays = rainLevelDayMapper.selectByExample(example);
        List<RainLevelDayDto>rainLevelDayDtoList=new ArrayList<>();
        for (RainLevelDay rainLevelDay:rainLevelDays){
            RainLevelDayDto rainLevelDayDto=new RainLevelDayDto(rainLevelDay);
            rainLevelDayDtoList.add(rainLevelDayDto);
        }
        return rainLevelDayDtoList;
    }

    @Override
    public List<RainLevelMonth> getMonthListByDate(String date) {
        RainLevelMonthExample example = new RainLevelMonthExample();
        RainLevelMonthExample.Criteria criteria = example.createCriteria();

        if(!StringUtils.isEmpty(date)){
            criteria .andDateLike( date + "%");
        }
        List<RainLevelMonth> rainLevelMonths = rainLevelMonthMapper.selectByExample(example);

        return  rainLevelMonths;

    }

    @Override
    public void updateMonth(String stationId, String date, Double rainLevel,String rainDay) {
        String sql="update rain_level_month set  {0}={1,number,0.00} WHERE stationId={2} and date={3}";
        String resultSql="";
        resultSql = MessageFormat.format(sql, rainDay, rainLevel, stationId,"'"+date+"'");
        rainLevelMapper.updateMonth(resultSql);
    }

    @Override
    public void insertMonth(String stationId, String date, Double rainLevel, String rainDay) {
        String sql="insert into rain_level_month(stationId,date,{0}) VALUES({1},{2},{3,number,0.00})";
        String resultSql="";
        resultSql = MessageFormat.format(sql, rainDay, stationId, "'"+date+"'",rainLevel);
        rainLevelMapper.insertMonth(resultSql);
        System.out.println(resultSql);
    }
}
