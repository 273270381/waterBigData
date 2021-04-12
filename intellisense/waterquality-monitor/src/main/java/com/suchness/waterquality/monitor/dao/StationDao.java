package com.suchness.waterquality.monitor.dao;

import com.suchness.waterquality.monitor.dto.HydrologyStation;
import com.suchness.waterquality.monitor.dto.WaterStation;
import org.apache.ibatis.annotations.Param;


import java.util.List;

/**
 * @author hejunfeng
 * @Description 站点查询
 * @createTime 2020/12/28
 */
public interface StationDao {
    List<WaterStation> getWaterStation(@Param("areaName") List<String> areaName, @Param("stationName") String stationName,
                                       @Param("code") String code);

    List<HydrologyStation> getHydrologyStation(@Param("areaName") List<String> areaName,@Param("stationName") String stationName,
                                               @Param("code") String code);

    List<WaterStation> getWaterStationClassify(@Param("areaName") String areaName,@Param("stationName") String stationName,
                                       @Param("code") String code,@Param("page") Integer page,@Param("size") Integer size);
}
