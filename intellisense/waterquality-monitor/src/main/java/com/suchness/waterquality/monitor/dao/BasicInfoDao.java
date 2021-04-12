package com.suchness.waterquality.monitor.dao;

import com.suchness.waterquality.monitor.dto.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author hejunfeng
 * @createTime 2020/12/29
 */
public interface BasicInfoDao {
    List<WaterQualityCategory> getWaterCategory();

    List<RiversInfo> getRivers(@Param("riverName") String riverName,@Param("valleyAcreage") Double valleyAcreage);

}
