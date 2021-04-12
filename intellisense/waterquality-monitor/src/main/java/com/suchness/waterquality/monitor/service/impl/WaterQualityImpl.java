package com.suchness.waterquality.monitor.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.suchness.intellisense.common.utils.DateUtils;
import com.suchness.intellisense.mapper.WaterQualityHistoryDataMapper;
import com.suchness.intellisense.mapper.WaterQualitySiteMapper;
import com.suchness.intellisense.model.WaterQualityHistoryData;
import com.suchness.intellisense.model.WaterQualityHistoryDataExample;
import com.suchness.intellisense.model.WaterQualitySite;
import com.suchness.intellisense.model.WaterQualitySiteExample;
import com.suchness.waterquality.monitor.contants.Contants;
import com.suchness.waterquality.monitor.dao.WaterQualityDao;
import com.suchness.waterquality.monitor.dto.SiteRunStatus;
import com.suchness.waterquality.monitor.dto.WaterQualityDto;
import com.suchness.waterquality.monitor.dto.WaterQualityEvaluationDto;
import com.suchness.waterquality.monitor.dto.WaterQualityInfoDto;
import com.suchness.waterquality.monitor.service.WaterQuality;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

import static com.suchness.intellisense.common.utils.DateUtils.YYYY_MM_DD_HH_MM_SS;
import static com.suchness.intellisense.common.utils.DateUtils.dateTime;

/***
 *  author: rushi
 *  create_time : 2021/1/68:47
 *******/
@Service
@Slf4j
public class WaterQualityImpl implements WaterQuality {


    @Autowired
    private WaterQualityDao waterQualityDao;
    @Autowired
    private WaterQualitySiteMapper waterQualitySiteMapper;
    @Autowired
    private WaterQualityHistoryDataMapper waterQualityHistoryDataMapper;
    @Override
    public WaterQualityDto listRealTimeData() {
        int online =0;
        int offline =0;
        List<WaterQualityInfoDto> waterQualityInfoDtoList = waterQualityDao.getRealTimeData();
        List<WaterQualitySite> waterQualitySites = waterQualitySiteMapper.selectByExample(new WaterQualitySiteExample());
        List<Integer> siteIds = waterQualitySites.stream().map(waterQualitySite -> waterQualitySite.getId()).collect(Collectors.toList());
        List<Integer> realSiteIds = waterQualityInfoDtoList.stream().map(waterQualityInfoDto ->waterQualityInfoDto.getSiteId()).collect(Collectors.toList());
        siteIds.removeAll(realSiteIds);
        for(WaterQualityInfoDto waterQualityInfoDto : waterQualityInfoDtoList){
            waterQualityInfoDto.setOnLine("1");
            waterQualityInfoDto.setRunStatus("1");
            online++;
        }

        for(Integer id : siteIds){
            for(WaterQualitySite waterQualitySite : waterQualitySites){
                if(id .equals(waterQualitySite.getId())){
                    WaterQualityInfoDto waterQualityInfoDto = new WaterQualityInfoDto();
                    waterQualityInfoDto.setOnLine("2");
                    waterQualityInfoDto.setRunStatus("2");
                    waterQualityInfoDto.setAd("--");
                    waterQualityInfoDto.setCaptureTime("--");
                    waterQualityInfoDto.setGmsy("--");
                    waterQualityInfoDto.setPh("--");
                    waterQualityInfoDto.setRjy("--");
                    waterQualityInfoDto.setSw("--");
                    waterQualityInfoDto.setYhhydw("--");
                    waterQualityInfoDto.setZl("--");
                    waterQualityInfoDto.setSiteName(waterQualitySite.getName());
                    waterQualityInfoDto.setRegionName(waterQualitySite.getCodeRegion());
                    waterQualityInfoDto.setValleyName(waterQualitySite.getCodeWaterarea());
                    waterQualityInfoDto.setLongitude(waterQualitySite.getLongitude());
                    waterQualityInfoDto.setLatitude(waterQualitySite.getLatitude());
                    waterQualityInfoDto.setAddress(waterQualitySite.getAddress());
                    offline++;
                    waterQualityInfoDtoList.add(waterQualityInfoDto);
                }
            }

        }

        SiteRunStatus siteRunStatus =new SiteRunStatus();
        siteRunStatus.setOnLineNum(String.valueOf(online));
        siteRunStatus.setOffLineNum(String.valueOf(offline));
        NumberFormat numberFormat = NumberFormat.getInstance();
        numberFormat.setMaximumFractionDigits(2);

        String rate = numberFormat.format((float)online/(float) (online+offline) * 100);
        siteRunStatus.setOnLineRate(String.valueOf(rate)+"%");

        WaterQualityDto waterQualityDto = new WaterQualityDto();
        waterQualityDto.setSiteRunStatus(siteRunStatus);
        waterQualityDto.setWaterQualityInfoDtos(waterQualityInfoDtoList);

        return waterQualityDto;
    }

    @Override
    public WaterQualitySite getStationInfoByName(String name) {
        WaterQualitySiteExample example = new WaterQualitySiteExample();
        WaterQualitySiteExample.Criteria criteria = example.createCriteria();
        if(!StringUtils.isEmpty(name)){
            criteria.andNameLike(name + '%');
        }
        List<WaterQualitySite> waterStations = waterQualitySiteMapper.selectByExample(example);
        if(waterStations.size() > 0){
            return waterStations.get(0);
        }
        return null;
    }

    @Override
    public List<WaterQualitySite> listStations() {
        return waterQualitySiteMapper.selectByExample(new WaterQualitySiteExample());
    }

    @Override
    public List<WaterQualityHistoryData> listHistoryData(String stationId, String startTime, String endTime, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        WaterQualityHistoryDataExample example = new WaterQualityHistoryDataExample();
        WaterQualityHistoryDataExample.Criteria criteria = example.createCriteria();
        if (!StringUtils.isEmpty(stationId)) {
            criteria.andSiteIdEqualTo(Integer.valueOf(stationId));
        }
        if (!StringUtils.isEmpty(endTime) && !StringUtils.isEmpty(startTime)) {
            criteria.andDateTimeBetween(dateTime(YYYY_MM_DD_HH_MM_SS,startTime), dateTime(YYYY_MM_DD_HH_MM_SS,endTime));
        }
        example.setOrderByClause("date_time");

        return waterQualityHistoryDataMapper.selectByExample(example);
    }

    @Override
    public WaterQualityEvaluationDto getQualityEvaluationByStation(String stationId, String areaId, String indicatorId,
                                                                   String period, String startTime,String endTime) {
        if(Contants.WEEK.equals(period)){
            Integer weeknum =0;
            Date callbackTimeStart = null;
            String callbackTimeStart1 = "";
            Date endTime2 =null;
            String endTime1 = "";
            if(!StringUtils.isEmpty(startTime)){
                callbackTimeStart = DateUtils.getDate(startTime);
                weeknum = DateUtils.getWeekOfYear(callbackTimeStart);
                endTime2 = DateUtils.getBeforeOrAfterDate(callbackTimeStart, 6);
                callbackTimeStart1 = DateUtils.dateTime(callbackTimeStart);
                endTime1 = DateUtils.dateTime(endTime2);
            }
            List<WaterQualityInfoDto> result = new ArrayList<>();
            List<WaterQualityInfoDto> waterQualityInfoDtos = waterQualityDao.getQualityEvaluationByStation(stationId,areaId,indicatorId,callbackTimeStart1,endTime1);
            Map<Integer,List<WaterQualityInfoDto>> groupByMap = waterQualityInfoDtos.stream().collect(Collectors.groupingBy(waterQualityInfoDto ->waterQualityInfoDto.getSiteId()));
            groupByMap.forEach((key, list) ->{
                WaterQualityInfoDto waterQualityInfoDto = new WaterQualityInfoDto();
                waterQualityInfoDto.setRegionName(list.get(0).getRegionName());
                waterQualityInfoDto.setSiteName(list.get(0).getSiteName());
                //gmsy
                DoubleSummaryStatistics gmsyStatistics =list.stream().filter(e->e.getGmsy() != null).collect(Collectors.summarizingDouble(e -> Double.valueOf(e.getGmsy())));
                waterQualityInfoDto.setGmsy(String.format("%.2f", gmsyStatistics.getAverage()));
                //ad
                DoubleSummaryStatistics adStatistics =list.stream().filter(e->e.getAd() != null).collect(Collectors.summarizingDouble(e -> Double.valueOf(e.getAd())));
                waterQualityInfoDto.setAd(String.format("%.2f", adStatistics.getAverage()));
                //ph
                DoubleSummaryStatistics phStatistics =list.stream().filter(e->e.getPh() != null).collect(Collectors.summarizingDouble(e -> Double.valueOf(e.getPh())));
                waterQualityInfoDto.setPh(String.format("%.2f", phStatistics.getAverage()));
                //rjy
                DoubleSummaryStatistics rjyStatistics =list.stream().filter(e->e.getRjy() != null).collect(Collectors.summarizingDouble(e -> Double.valueOf(e.getRjy())));
                waterQualityInfoDto.setRjy(String.format("%.2f", rjyStatistics.getAverage()));
                //sw
                DoubleSummaryStatistics swStatistics =list.stream().filter(e->e.getSw() != null).collect(Collectors.summarizingDouble(e -> Double.valueOf(e.getSw())));
                waterQualityInfoDto.setSw(String.format("%.2f", swStatistics.getAverage()));
                //zl
                DoubleSummaryStatistics zlStatistics =list.stream().filter(e->e.getZl() != null).collect(Collectors.summarizingDouble(e -> Double.valueOf(e.getZl())));
                waterQualityInfoDto.setZl(String.format("%.2f", zlStatistics.getAverage()));
                result.add(waterQualityInfoDto);
            });
            WaterQualityEvaluationDto waterQualityEvaluationDto = new WaterQualityEvaluationDto();
            waterQualityEvaluationDto.setWaterQualityInfoDtoList(result);
            waterQualityEvaluationDto.setWeekNum(weeknum);
            return waterQualityEvaluationDto;
        }

        if(Contants.YEAR.equals(period)){

        }

        if(Contants.DAY.equals(period)){
            List<WaterQualityInfoDto> waterQualityInfoDtos = waterQualityDao.getQualityEvaluationByStation(stationId,areaId,indicatorId,startTime,endTime);
            WaterQualityEvaluationDto waterQualityEvaluationDto = new WaterQualityEvaluationDto();
            waterQualityEvaluationDto.setWaterQualityInfoDtoList(waterQualityInfoDtos);
            WaterQualityInfoDto waterQualityInfoDto = waterQualityDao.getQualityStationInfo(stationId);
            waterQualityEvaluationDto.setAreaName(waterQualityInfoDto.getRegionName());
            waterQualityEvaluationDto.setSiteName(waterQualityInfoDto.getSiteName());
            waterQualityEvaluationDto.setValleyName(waterQualityInfoDto.getValleyName());
            return waterQualityEvaluationDto;
        }

        return null;

    }
}
