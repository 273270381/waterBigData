package com.suchness.waterquality.monitor.service;

import com.github.pagehelper.PageInfo;
import com.suchness.waterquality.monitor.dto.*;
import java.util.List;
import java.util.Map;

/**
 * @author hejunfeng
 * @createTime 2020/12/29
 */
public interface BasicInfoService {
    PageInfo<AreaDto> getAreaInfos(Integer areaId, String code, String superAreaId, Integer pageSize, Integer pageNum);

    PageInfo<DrainageAreaDto> getValleyInfo(Integer pageSize, Integer pageNum);

    List<WaterQualityCategory> getWaterCategory();

    PageInfo<RiversInfo> getRivers(String riverName,Double waterAcreage,Integer pageSize,Integer pageNum);

    PageInfo<RiverManagerInfo> getRiverManagers(String name, String account, Integer pageSize, Integer pageNum);

    List<DictInfo> getDictInfo(String name);

    Map getDicts();

}
