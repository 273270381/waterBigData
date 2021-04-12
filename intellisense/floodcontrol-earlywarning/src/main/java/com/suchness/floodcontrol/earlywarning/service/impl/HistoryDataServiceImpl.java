package com.suchness.floodcontrol.earlywarning.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.suchness.floodcontrol.earlywarning.dto.WaterHistoryDto;
import com.suchness.floodcontrol.earlywarning.dto.WaterReportDto;
import com.suchness.floodcontrol.earlywarning.service.HistoryDataService;
import com.suchness.intellisense.mapper.WaterHistoryDataMapper;
import com.suchness.intellisense.model.WaterHistoryData;
import com.suchness.intellisense.model.WaterHistoryDataExample;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.suchness.intellisense.common.utils.DateUtils.YYYY_MM_DD_HH_MM_SS;
import static com.suchness.intellisense.common.utils.DateUtils.dateTime;

/***
 *  author: rushi
 *  create_time : 2020/12/2110:31
 *******/
@Service
public class HistoryDataServiceImpl implements HistoryDataService {

    @Autowired
    private WaterHistoryDataMapper waterHistoryDataMapper;

    @Override
    public PageInfo<WaterHistoryDto> list(String code, String stationId, String startTime, String endTime, Integer pageSize, Integer pageNum) {

        PageHelper.startPage(pageNum, pageSize);
        WaterHistoryDataExample example = new WaterHistoryDataExample();
        WaterHistoryDataExample.Criteria criteria = example.createCriteria();
        if (!StringUtils.isEmpty(code)) {
            criteria.andElementEqualTo(code);
        }
        if(!StringUtils.isEmpty(stationId)){
            criteria.andStationIdEqualTo(stationId);
        }
        if (!StringUtils.isEmpty(endTime) && !StringUtils.isEmpty(startTime)) {
            criteria.andCaptureTimeBetween(dateTime(YYYY_MM_DD_HH_MM_SS,startTime), dateTime(YYYY_MM_DD_HH_MM_SS,endTime));
        }
        example.setOrderByClause("capture_time");
        List<WaterHistoryData> waterHistoryDataList  = waterHistoryDataMapper.selectByExample(example);
        PageInfo waterHistoryDataPageInfo = new PageInfo<>(waterHistoryDataList);
        List<WaterHistoryDto> waterHistoryDtoList = cumulativeRain(waterHistoryDataList);
        waterHistoryDataPageInfo.setList(waterHistoryDtoList);
        return waterHistoryDataPageInfo;

    }

    private List<WaterHistoryDto> cumulativeRain(List<WaterHistoryData> waterHistoryDataList) {

        List<WaterHistoryDto> waterHistoryDtoList = new ArrayList<>();
        for(WaterHistoryData waterHistoryData : waterHistoryDataList){
            WaterHistoryDto waterHistoryDto = new WaterHistoryDto();
            waterHistoryDto.setId(waterHistoryData.getId());
            waterHistoryDto.setElement(waterHistoryData.getElement());
            waterHistoryDto.setCaptureTime(waterHistoryData.getCaptureTime());
            waterHistoryDto.setStationId(waterHistoryData.getStationId());
            waterHistoryDto.setValue(waterHistoryData.getValue());
            waterHistoryDto.setCumulativeRain(0.0);
            waterHistoryDtoList.add(waterHistoryDto);
        }
        return waterHistoryDtoList;
    }

}
