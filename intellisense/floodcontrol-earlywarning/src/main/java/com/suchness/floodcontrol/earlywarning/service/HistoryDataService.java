package com.suchness.floodcontrol.earlywarning.service;

import com.github.pagehelper.PageInfo;
import com.suchness.floodcontrol.earlywarning.dto.WaterHistoryDto;
import com.suchness.floodcontrol.earlywarning.dto.WaterReportDto;
import com.suchness.intellisense.model.WaterHistoryData;

import java.util.List;

/***
 *  author: rushi
 *  create_time : 2020/12/2110:31
 *******/
public interface HistoryDataService {

    PageInfo<WaterHistoryDto> list(String code, String stationId, String startTime, String endTime, Integer pageSize, Integer pageNum);

}
