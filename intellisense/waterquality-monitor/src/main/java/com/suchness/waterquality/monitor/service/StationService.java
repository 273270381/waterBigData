package com.suchness.waterquality.monitor.service;


import com.github.pagehelper.PageInfo;
import com.suchness.waterquality.monitor.dto.HydrologyStation;
import com.suchness.waterquality.monitor.dto.WaterQualityStation;
import com.suchness.waterquality.monitor.dto.WaterStation;

import java.util.List;
import java.util.Map;

/**
 * @author hejunfeng
 * @createTime 2020/12/25
 */
public interface StationService {
    PageInfo<WaterStation> getWaterStation(String area, String stationName, String code, Integer pageSize, Integer pageNum);

    PageInfo<HydrologyStation> getHydrologyStation(String area, String stationName, String code,Integer pageSize,Integer pageNum);

    List<WaterQualityStation> getWaterQualityStation();

    Integer addStation(Map map);

    Integer addHydrologyStation(Map map);

    Integer deleteStation(Integer id);

    Integer deleteHydrologyStation(Integer id);
}
