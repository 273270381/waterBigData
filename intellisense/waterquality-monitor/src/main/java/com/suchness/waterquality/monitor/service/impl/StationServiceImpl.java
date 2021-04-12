package com.suchness.waterquality.monitor.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.suchness.intellisense.mapper.AreaMapper;
import com.suchness.intellisense.mapper.DictMapper;
import com.suchness.intellisense.mapper.WaterQualitySiteMapper;
import com.suchness.intellisense.mapper.WaterStationMapper;
import com.suchness.intellisense.model.AreaExample;
import com.suchness.intellisense.model.Dict;
import com.suchness.intellisense.model.DictExample;
import com.suchness.waterquality.monitor.dao.StationDao;
import com.suchness.waterquality.monitor.dto.*;
import com.suchness.waterquality.monitor.service.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.suchness.intellisense.model.Area;

/**
 * @author hejunfeng
 * @createTime 2020/12/25
 */
@Service
public class StationServiceImpl implements StationService {
    @Autowired
    private StationDao stationDao;
    @Autowired
    private AreaMapper areaMapper;
    @Autowired
    private DictMapper dictMapper;
    @Autowired
    private WaterQualitySiteMapper waterQualitySiteMapper;
    @Autowired
    private WaterStationMapper waterStationMapper;


    /**
     * @return java.util.List<com.suchness.waterquality.monitor.dto.WaterStation>
     * @Author hejunfeng
     * @Date 19:34 2020/12/28 0028
     * @Param [area, stationName, code]
     * @Description 水质站点查询
     **/
    @Override
    public PageInfo<WaterStation> getWaterStation(String areaName, String stationName, String code, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum,pageSize);
        List<String> alist = getStrings(areaName);
        List<WaterStation> stations = stationDao.getWaterStation(alist,stationName,code);
        PageInfo stationPageInfo = new PageInfo<>(stations);
        return stationPageInfo;
    }


    /**
     * @return java.util.List<com.suchness.waterquality.monitor.dto.HydrologyStation>
     * @Author hejunfeng
     * @Date 20:30 2020/12/28 0028
     * @Param [area, stationName, code]
     * @Description 水文站点查询
     **/
    @Override
    public PageInfo<HydrologyStation> getHydrologyStation(String areaName, String stationName, String code,Integer pageSize,Integer pageNum) {
        PageHelper.startPage(pageNum,pageSize);
        List<String> alist = getStrings(areaName);
        List<HydrologyStation> stations = stationDao.getHydrologyStation(alist,stationName, code);
        PageInfo hydrologyStationPageInfo = new PageInfo<>(stations);
        return hydrologyStationPageInfo;
    }

    private List<String> getStrings(String areaName) {
        List<String> alist = new ArrayList<>();
        if (areaName != null) {
            AreaExample areaExample = new AreaExample();
            AreaExample.Criteria criteria = areaExample.createCriteria();
            criteria.andAreaNameEqualTo(areaName);
            List<Area> areas = areaMapper.selectByExample(areaExample);
            if (areas.size() > 0) {
                for (com.suchness.intellisense.model.Area area : areas) {
                    AreaExample a = new AreaExample();
                    AreaExample.Criteria c = a.createCriteria();
                    c.andSuperAreaIdEqualTo(area.getAreaId());
                    List<Area> as = areaMapper.selectByExample(a);
                    if (as.size() > 0) {
                        for (Area area1 : as) {
                            alist.add(area1.getAreaName());
                        }
                    }
                    alist.add(area.getAreaName());
                }
            }
        }
        return alist;
    }


    /**
     * @return java.util.List<com.suchness.waterquality.monitor.dto.WaterQualityStation>
     * @Author hejunfeng
     * @Date 17:20 2021/1/12 0012
     * @Param [area]
     * @Description 水质站点分类
     **/
    @Override
    public List<WaterQualityStation> getWaterQualityStation() {
        DictExample dictExample = new DictExample();
        DictExample.Criteria dictExampleCriteria = dictExample.createCriteria();
        dictExampleCriteria.andNameEqualTo("市级");
        List<Dict> dicts = dictMapper.selectByExample(dictExample);
        List<WaterQualityStation> list = new ArrayList<>();
        if (dicts.size() > 0){
            AreaExample example = new AreaExample();
            AreaExample.Criteria criteria = example.createCriteria();
            criteria.andLeverIdEqualTo(dicts.get(0).getId());
            List<Area> areas = areaMapper.selectByExample(example);
            if (areas.size() > 0){
                for (Area a : areas){
                    AreaExample e = new AreaExample();
                    AreaExample.Criteria c = e.createCriteria();
                    c.andSuperAreaIdEqualTo(a.getAreaId());
                    List<Area> areaList = areaMapper.selectByExample(e);
                    if (areaList.size() > 0){
                        List<WaterStationdto> wsList = new ArrayList<>();
                        WaterQualityStation w = new WaterQualityStation();
                        for (Area a1 : areaList){
                            WaterStationdto waterStationdto = new WaterStationdto();
                            List<WaterStation> ws = stationDao.getWaterStationClassify(a1.getAreaName(),null,null,null,null);
                            waterStationdto.setName(a1.getAreaName());
                            waterStationdto.setStations(ws);
                            wsList.add(waterStationdto);
                        }
                        w.setName(a.getAreaName());
                        w.setStations(wsList);
                        list.add(w);
                    }
                }
            }
        }
        return list;
    }

    @Override
    public Integer addStation(Map map) {

        return null;
    }

    @Override
    public Integer addHydrologyStation(Map map) {
        return null;
    }

    @Override
    public Integer deleteStation(Integer id) {
        int s = waterQualitySiteMapper.deleteByPrimaryKey(id);
        return s;
    }

    @Override
    public Integer deleteHydrologyStation(Integer id) {
        int s = waterStationMapper.deleteByPrimaryKey(id);
        return s;
    }
}
