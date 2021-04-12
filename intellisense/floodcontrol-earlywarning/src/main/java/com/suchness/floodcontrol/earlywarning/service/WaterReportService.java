package com.suchness.floodcontrol.earlywarning.service;

import com.suchness.floodcontrol.earlywarning.dto.WaterReportDto;
import com.suchness.intellisense.model.WaterStation;

import java.util.List;

/***
 *  author: rushi
 *  create_time : 2020/12/2110:31
 *******/
public interface WaterReportService {

    List<WaterReportDto> list(String code, Integer pageSize, Integer pageNum);

    List<WaterStation> listStation();

    WaterStation getStationInfoByName(String name);
}
