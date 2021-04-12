package com.suchness.floodcontrol.earlywarning.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.github.pagehelper.PageHelper;
import com.suchness.floodcontrol.earlywarning.dao.WaterQualityMapper;
import com.suchness.floodcontrol.earlywarning.dto.*;
import com.suchness.floodcontrol.earlywarning.service.WaterQualityDataService;
import com.suchness.intellisense.common.utils.DateUtils;
import com.suchness.intellisense.mapper.WaterQualityDataDayMapper;
import com.suchness.intellisense.mapper.WaterQualityDataWeekMapper;
import com.suchness.intellisense.mapper.WaterQualityDataYearMapper;
import com.suchness.intellisense.model.*;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class WaterQualityDataServiceImpl implements WaterQualityDataService {

    @Autowired
    private WaterQualityDataDayMapper waterQualityDataDayMapper;
    @Autowired
    private WaterQualityMapper waterQualityMapper;

    @Autowired
    private WaterQualityDataWeekMapper waterQualityDataWeekMapper;


    @Autowired
    private WaterQualityDataYearMapper waterQualityDataYearMapper;



    /**
     * @Author wangchan
     * @Date 8:50 2021/1/16
     * @Param [stationId, date, pageSize, pageNum]
     * @Return java.util.List<com.suchness.intellisense.model.WaterQualityDataDay>
     * @Descriptio    获取水质单站日报表
    **/

    @Override
    public WaterQualityDayDto dayList(Integer siteId, String date, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        WaterQualityDataDayExample example = new WaterQualityDataDayExample();
        example.setOrderByClause("date_time");
        WaterQualityDataDayExample.Criteria criteria = example.createCriteria();
        if (siteId!=null) {
            criteria .andSiteIdEqualTo(siteId);
        }
        if(!StringUtils.isEmpty(date)){
            criteria .andDateTimeLike( date + "%");
        }

        WaterQualityMathBean waterQualityDayBean = waterQualityMapper.getWaterQualityDayBean(siteId, date);

        List<WaterQualityDataDay> waterQualityDataDayList = waterQualityDataDayMapper.selectByExample(example);


        WaterQualityDayDto waterQualityDayDto=new WaterQualityDayDto(waterQualityDataDayList,new WaterQualityDayBeanDto(waterQualityDayBean));

        return  waterQualityDayDto;

    }

    @Override
    public WaterQualityWeekDto weekList(Integer siteId, String date, Integer pageSize, Integer pageNum) throws ParseException {

        if (StringUtils.isEmpty(date)){
            return  null;
        }


        String TimeStart = date.replace("Z", " UTC");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date callbackTimeStart = format.parse(TimeStart);


        List<String> beforeOrAfterDates = DateUtils.getBeforeOrAfterDates(callbackTimeStart, 7);


        PageHelper.startPage(pageNum, pageSize);
        WaterQualityDataWeekExample example = new WaterQualityDataWeekExample();
        example.setOrderByClause("date_time");
        WaterQualityDataWeekExample.Criteria criteria = example.createCriteria();
        if (siteId!=null) {
            criteria .andSiteIdEqualTo(siteId);
        }
        if(!StringUtils.isEmpty(date)){
            criteria .andDateTimeIn(beforeOrAfterDates);
        }

        WaterQualityMathBean waterQualityDayBean = waterQualityMapper.getWaterQualityWeekBean(siteId, beforeOrAfterDates);


        List<WaterQualityDataWeek> waterQualityDataWeekList = waterQualityDataWeekMapper.selectByExample(example);
        WaterQualityWeekDto waterQualityWeekDto=new WaterQualityWeekDto(waterQualityDataWeekList,new WaterQualityDayBeanDto(waterQualityDayBean),beforeOrAfterDates.get(0),beforeOrAfterDates.get(6));


        return waterQualityWeekDto;
    }

    @Override
    public WaterQualityWeekDto monthList(Integer siteId, String date, Integer pageSize, Integer pageNum)  {

        PageHelper.startPage(pageNum, pageSize);
        WaterQualityDataWeekExample example = new WaterQualityDataWeekExample();
        example.setOrderByClause("date_time");
        WaterQualityDataWeekExample.Criteria criteria = example.createCriteria();
        if (siteId!=null) {
            criteria .andSiteIdEqualTo(siteId);
        }
        if(!StringUtils.isEmpty(date)){
            criteria .andDateTimeLike( date + "%");
        }

        WaterQualityMathBean waterQualityDayBean = waterQualityMapper.getWaterQualityMonthBean(siteId, date);

        List<WaterQualityDataWeek> waterQualityDataMonthList = waterQualityDataWeekMapper.selectByExample(example);


        WaterQualityWeekDto waterQualityMonthDto=new WaterQualityWeekDto(waterQualityDataMonthList,new WaterQualityDayBeanDto(waterQualityDayBean),null,null);



        return waterQualityMonthDto;
    }

    @Override
    public WaterQualityYearDto yearList(Integer siteId, String date, Integer pageSize, Integer pageNum) {



        PageHelper.startPage(pageNum, pageSize);
        WaterQualityDataYearExample example = new WaterQualityDataYearExample();
        example.setOrderByClause("date_time");
        WaterQualityDataYearExample.Criteria criteria = example.createCriteria();
        if (siteId!=null) {
            criteria .andSiteIdEqualTo(siteId);
        }
        if(!StringUtils.isEmpty(date)){
            criteria .andDateTimeLike( date + "%");
        }

        WaterQualityMathBean waterQualityDayBean = waterQualityMapper.getWaterQualityYearBean(siteId, date);

        List<WaterQualityDataYear> waterQualityDataYearList = waterQualityDataYearMapper.selectByExample(example);


        WaterQualityYearDto waterQualityYearDto=new WaterQualityYearDto(waterQualityDataYearList,new WaterQualityDayBeanDto(waterQualityDayBean));



        return waterQualityYearDto;
    }

    /**
     * @Author wangchan
     * @Date 14:03 2021/1/27
     * @Param [siteId, date, pageSize, pageNum]
     * @Return com.suchness.floodcontrol.earlywarning.dto.WaterQualityCompDto
     * @Description   水质综合报表周报
    **/

    @Override
    public  List<WaterQualityInfoDto>  comWeekList(Integer areaId, String date, Integer pageSize, Integer pageNum) throws ParseException {
        if (StringUtils.isEmpty(date)){
            return  null;
        }


        String TimeStart = date.replace("Z", " UTC");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date callbackTimeStart = format.parse(TimeStart);
        List<String> beforeOrAfterDates = DateUtils.getBeforeOrAfterDates(callbackTimeStart, 7);



        List<WaterQualityInfoDto> result = new ArrayList<>();
        List<WaterQualityInfoDto> waterQualityInfoDtos = waterQualityMapper.getQualityEvaluationByStation(areaId,beforeOrAfterDates);

        Map<Integer,List<WaterQualityInfoDto>> groupByMap = waterQualityInfoDtos.stream().collect(Collectors.groupingBy(waterQualityInfoDto ->waterQualityInfoDto.getSiteId()));
        groupByMap.forEach((key, list) ->{
            WaterQualityInfoDto waterQualityInfoDto = new WaterQualityInfoDto();
            waterQualityInfoDto.setRegionName(list.get(0).getRegionName());
            waterQualityInfoDto.setSiteName(list.get(0).getSiteName());
            waterQualityInfoDto.setWaterArea(list.get(0).getWaterArea());
            waterQualityInfoDto.setStationType(list.get(0).getStationType());
            waterQualityInfoDto.setStartDate(beforeOrAfterDates.get(0));
            waterQualityInfoDto.setEndDate(beforeOrAfterDates.get(6));
            //gmsy
            DoubleSummaryStatistics gmsyStatistics =list.stream().filter(e->e.getGmsy()!=null).collect(Collectors.summarizingDouble(e -> Double.valueOf(e.getGmsy())));
            waterQualityInfoDto.setGmsy(String.format("%.2f", gmsyStatistics.getAverage()));
            //ad
            DoubleSummaryStatistics adStatistics =list.stream().filter(e->e.getAd()!=null).collect(Collectors.summarizingDouble(e -> Double.valueOf(e.getAd())));
            waterQualityInfoDto.setAd(String.format("%.2f", adStatistics.getAverage()));
            //ph
            DoubleSummaryStatistics phStatistics =list.stream().filter(e->e.getPh()!=null).collect(Collectors.summarizingDouble(e -> Double.valueOf(e.getPh())));
            waterQualityInfoDto.setPh(String.format("%.2f", phStatistics.getAverage()));
            //rjy
            DoubleSummaryStatistics rjyStatistics =list.stream().filter(e->e.getRjy()!=null).collect(Collectors.summarizingDouble(e -> Double.valueOf(e.getRjy())));
            waterQualityInfoDto.setRjy(String.format("%.2f", rjyStatistics.getAverage()));
            //sw
            DoubleSummaryStatistics swStatistics =list.stream().filter(e->e.getSw()!=null).collect(Collectors.summarizingDouble(e -> Double.valueOf(e.getSw())));
            waterQualityInfoDto.setSw(String.format("%.2f", swStatistics.getAverage()));
            //zl
            DoubleSummaryStatistics zlStatistics =list.stream().filter(e->e.getZl()!=null).collect(Collectors.summarizingDouble(e -> Double.valueOf(e.getZl())));
            waterQualityInfoDto.setZl(String.format("%.2f", zlStatistics.getAverage()));
            result.add(waterQualityInfoDto);
        });

        return result;
    }

    @SneakyThrows
    @Override
    public List<WaterQualityInfoDto> comMonthList(Integer areaId, String date, Integer pageSize, Integer pageNum) {
        if (StringUtils.isEmpty(date)){
            return  null;
        }





        List<WaterQualityInfoDto> result = new ArrayList<>();
        List<WaterQualityInfoDto> waterQualityInfoDtos = waterQualityMapper.getQualityEvaluationByStationByMonth(areaId,date);

        Map<Integer,List<WaterQualityInfoDto>> groupByMap = waterQualityInfoDtos.stream().collect(Collectors.groupingBy(waterQualityInfoDto ->waterQualityInfoDto.getSiteId()));
        groupByMap.forEach((key, list) ->{
            WaterQualityInfoDto waterQualityInfoDto = new WaterQualityInfoDto();
            waterQualityInfoDto.setRegionName(list.get(0).getRegionName());
            waterQualityInfoDto.setSiteName(list.get(0).getSiteName());
            waterQualityInfoDto.setWaterArea(list.get(0).getWaterArea());
            waterQualityInfoDto.setStationType(list.get(0).getStationType());



            //gmsy
            DoubleSummaryStatistics gmsyStatistics =list.stream().filter(e->e.getGmsy()!=null).collect(Collectors.summarizingDouble(e -> Double.valueOf(e.getGmsy())));
            waterQualityInfoDto.setGmsy(String.format("%.2f", gmsyStatistics.getAverage()));
            //ad
            DoubleSummaryStatistics adStatistics =list.stream().filter(e->e.getAd()!=null).collect(Collectors.summarizingDouble(e -> Double.valueOf(e.getAd())));
            waterQualityInfoDto.setAd(String.format("%.2f", adStatistics.getAverage()));
            //ph
            DoubleSummaryStatistics phStatistics =list.stream().filter(e->e.getPh()!=null).collect(Collectors.summarizingDouble(e -> Double.valueOf(e.getPh())));
            waterQualityInfoDto.setPh(String.format("%.2f", phStatistics.getAverage()));
            //rjy
            DoubleSummaryStatistics rjyStatistics =list.stream().filter(e->e.getRjy()!=null).collect(Collectors.summarizingDouble(e -> Double.valueOf(e.getRjy())));
            waterQualityInfoDto.setRjy(String.format("%.2f", rjyStatistics.getAverage()));
            //sw
            DoubleSummaryStatistics swStatistics =list.stream().filter(e->e.getSw()!=null).collect(Collectors.summarizingDouble(e -> Double.valueOf(e.getSw())));
            waterQualityInfoDto.setSw(String.format("%.2f", swStatistics.getAverage()));
            //zl
            DoubleSummaryStatistics zlStatistics =list.stream().filter(e->e.getZl()!=null).collect(Collectors.summarizingDouble(e -> Double.valueOf(e.getZl())));
            waterQualityInfoDto.setZl(String.format("%.2f", zlStatistics.getAverage()));
            result.add(waterQualityInfoDto);
        });

        return result;
    }
}
