package com.suchness.floodcontrol.earlywarning.service.impl;

import com.github.pagehelper.PageHelper;
import com.suchness.floodcontrol.earlywarning.beans.WaterReportBean;
import com.suchness.floodcontrol.earlywarning.contants.Contants;
import com.suchness.floodcontrol.earlywarning.dao.WaterReportDao;
import com.suchness.floodcontrol.earlywarning.dto.WaterReportDto;
import com.suchness.floodcontrol.earlywarning.enums.Water;
import com.suchness.floodcontrol.earlywarning.service.WaterReportService;
import com.suchness.intellisense.mapper.WaterRealTimeDataMapper;
import com.suchness.intellisense.mapper.WaterStationMapper;
import com.suchness.intellisense.model.WaterStation;
import com.suchness.intellisense.model.WaterStationExample;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.suchness.intellisense.common.utils.DateUtils.dateExactTime;

/***
 *  author: rushi
 *  create_time : 2020/12/2110:31
 *******/
@Service
public class WaterReportServiceImpl implements WaterReportService {

    @Autowired
    private WaterRealTimeDataMapper waterRealTimeDataMapper;
    @Autowired
    private WaterStationMapper waterStationMapper;
    @Autowired
    private WaterReportDao waterReportDao;


    @Override
    public List<WaterReportDto> list(String code, Integer pageSize, Integer pageNum) {
        List<WaterReportDto> waterReportDtoList = new ArrayList<>();
        PageHelper.startPage(pageNum, pageSize);
        List<WaterReportBean> list = waterReportDao.getRealTimeDataList(code);
        if(Water.WATER_LEVEL.getCode().equals(code)){
            for(WaterReportBean waterReportBean : list){
                WaterReportDto waterReportDto = new WaterReportDto();
                waterReportDto.setStationName(waterReportBean.getStationName());
                waterReportDto.setCaptureTime(dateExactTime(waterReportBean.getCaptureTime()));
                waterReportDto.setWaterLevel(waterReportBean.getValue());
                waterReportDto.setWarningValue(Contants.WARNING_VALUE);
                waterReportDto.setAlarmingValue(Contants.ALARM_VALUE);
                waterReportDtoList.add(waterReportDto);
            }
        }
        if(Water.RAIN_FALL.getCode().equals(code)){
            for(WaterReportBean waterReportBean : list){
                WaterReportDto waterReportDto = new WaterReportDto();
                waterReportDto.setStationName(waterReportBean.getStationName());
                waterReportDto.setCaptureTime(dateExactTime(waterReportBean.getCaptureTime()));
                waterReportDto.setRainValue(waterReportBean.getValue());
                waterReportDtoList.add(waterReportDto);
            }

        }
        return waterReportDtoList;
    }

    @Override
    public List<WaterStation> listStation() {
        return waterStationMapper.selectByExample(new WaterStationExample());
    }

    @Override
    public WaterStation getStationInfoByName(String name) {
        WaterStationExample example = new WaterStationExample();
        WaterStationExample.Criteria criteria = example.createCriteria();
        if(!StringUtils.isEmpty(name)){
            criteria.andStationNameLike(name);
        }
        List<WaterStation> waterStations = waterStationMapper.selectByExample(example);
        if(waterStations.size() > 0){
            return waterStationMapper.selectByExample(example).get(0);
        }
        return null;
    }
}
