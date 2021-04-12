package com.suchness.waterquality.monitor.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.suchness.intellisense.common.utils.DateUtils;
import com.suchness.intellisense.mapper.DrainageAreaMapper;
import com.suchness.intellisense.mapper.WaterQualityAlarmDataMapper;
import com.suchness.intellisense.model.*;
import com.suchness.waterquality.monitor.dao.AlarmCountDao;
import com.suchness.waterquality.monitor.dao.AlarmManageDao;
import com.suchness.waterquality.monitor.dto.*;
import com.suchness.waterquality.monitor.dto.Area;
import com.suchness.waterquality.monitor.service.AlarmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author hejunfeng
 * @createTime 2020/12/19
 */
@Service
public class AlarmServiceImpl implements AlarmService {
    @Autowired
    private AlarmCountDao countDao;
    @Autowired
    private AlarmManageDao manageDao;
    @Autowired
    private WaterQualityAlarmDataMapper mapper;
    @Autowired
    private DrainageAreaMapper drainageAreaMapper;

    /**
     * @return java.util.List<com.suchness.waterquality.monitor.dto.AlarmManagerParam>
     * @Author hejunfeng
     * @Date 14:08 2020/12/21 0021
     * @Param [stationId, type, status, startTime, endTime, pageSize, pageNum]
     * @Description 水质报警管理
     **/
    @Override
    public PageInfo<AlarmManagerParam> getWaterAlarm(String stationName, String alarmType, String status, String startTime, String endTime, Integer pageSize, Integer pageNum) throws ParseException {
        PageHelper.startPage(pageNum,pageSize);
        List<AlarmManagerParam> alarmManagerParamList = new ArrayList<>();
        if (!StringUtils.isEmpty(startTime) && !StringUtils.isEmpty(endTime)){
            alarmManagerParamList = manageDao.getAlarmList(stationName,alarmType,status,DateUtils.dateTime(DateUtils.YYYY_MM_DD,startTime),DateUtils.dateTime(DateUtils.YYYY_MM_DD,endTime),pageSize,pageNum);
        }else{
            alarmManagerParamList = manageDao.getAlarmList(stationName,alarmType,status,null,null,pageSize,pageNum);
        }
        PageInfo alarmDataPageInfo = new PageInfo<>(alarmManagerParamList);
        return alarmDataPageInfo;
    }



    /**
     * @return java.util.List<com.suchness.waterquality.monitor.dto.AlarmCountList>
     * @Author hejunfeng
     * @Date 10:40 2021/1/6 0006
     * @Param [str, startTime, endTime]
     * @Description 水质报警统计
     **/
    @Override
    public List<AlarmCountList> getAlarmMum(String str, String startTime, String endTime) throws ParseException {
        List<AlarmCountList> alarmCountLists = new ArrayList<>();
        if (("流域").equals(str)){
            List<AlarmCount> alarmCountList = new ArrayList<>();
            if (!StringUtils.isEmpty(startTime) && !StringUtils.isEmpty(endTime)){
                alarmCountList = countDao.getAlarmCountValley(DateUtils.dateTime(DateUtils.YYYY_MM_DD,startTime),DateUtils.dateTime(DateUtils.YYYY_MM_DD,endTime));
            }else{
                alarmCountList = countDao.getAlarmCountValley(null,null);
            }
            DrainageAreaExample drainageAreaExample = new DrainageAreaExample();
            DrainageAreaExample.Criteria criteria = drainageAreaExample.createCriteria();
            criteria.andSuperValleyIdEqualTo(0);
            List<DrainageArea> drainageAreas = drainageAreaMapper.selectByExample(drainageAreaExample);//淮河流域、黄河流域
            HashMap<String,Object> map = new LinkedHashMap<>();
            if (drainageAreas.size() > 0){
                for (DrainageArea drainageArea : drainageAreas){
                    List<AlarmCount> ls = new ArrayList<>();
                    for (AlarmCount alarmCount : alarmCountList){
                        if (drainageArea.getName().equals(alarmCount.getSuperArea())){
                            ls.add(alarmCount);
                        }
                    }
                    if (ls.size() > 0){
                        map.put(drainageArea.getName(),ls);
                    }
                }
                Set<Map.Entry<String,Object>> set = map.entrySet();
                Iterator<Map.Entry<String,Object>> iter = set.iterator();
                int a_1 = 1;
                int ids = 1;
                while (iter.hasNext()){
                    Map.Entry<String,Object> entry = iter.next();
                    List<AlarmCount> ls = (List<AlarmCount>) entry.getValue();
                    AlarmCountList acl = new AlarmCountList();
                    List<AlarmCountBat> bats = new ArrayList<>();
                    Count count = new Count();
                    List<DrainageArea> areas = countDao.getVallrys(entry.getKey());
                    for (DrainageArea area : areas){
                        ids = alt(ls, bats, count, area.getName(),ids);
                    }
                    acl.setId(a_1++);
                    acl.setIds(ids);
                    acl.setTotal(count.getTotal());
                    acl.setAlarmCounts(bats);
                    acl.setDisconnectCount(count.getDisConnectCount());
                    acl.setDeviceCount(count.getDeviceCount());
                    acl.setDataCount(count.getDataCount());
                    acl.setAreaName(entry.getKey());
                    alarmCountLists.add(acl);
                }
            }
        }else {
            List<AlarmCount> alarmCountList = new ArrayList<>();
            if (!StringUtils.isEmpty(startTime) && !StringUtils.isEmpty(endTime)){
                alarmCountList = countDao.getAlarmCount(DateUtils.dateTime(DateUtils.YYYY_MM_DD,startTime),DateUtils.dateTime(DateUtils.YYYY_MM_DD,endTime));
            }else{
                alarmCountList = countDao.getAlarmCount(null,null);
            }
            List<Area> areas = countDao.getAreas("市级","");
            HashMap<String,Object> map = new LinkedHashMap<>();
            for (Area area : areas){
                List<AlarmCount> ls = new ArrayList<>();
                for (AlarmCount alarmCount : alarmCountList){
                    if (alarmCount.getSuperArea().equals(area.getName())){
                        ls.add(alarmCount);
                    }
                }
                if (ls.size() >0){
                    map.put(area.getName(),ls);
                }
            }
            Set<Map.Entry<String,Object>> set = map.entrySet();
            Iterator<Map.Entry<String,Object>> iter = set.iterator();
            int a_1 = 1;
            int ids = 1;
            while (iter.hasNext()){
                Map.Entry<String,Object> entry = iter.next();
                List<AlarmCount> ls = (List<AlarmCount>) entry.getValue();
                AlarmCountList acl = new AlarmCountList();
                List<AlarmCountBat> bats = new ArrayList<>();
                Count count = new Count();
                List<Area> areas2 = countDao.getAreas("区级",entry.getKey());
                for (Area area2 : areas2){
                    ids = alt(ls, bats, count, area2.getName(),ids);
                }
                acl.setId(a_1++);
                acl.setIds(ids++);
                acl.setTotal(count.getTotal());
                acl.setAlarmCounts(bats);
                acl.setDisconnectCount(count.getDisConnectCount());
                acl.setDeviceCount(count.getDeviceCount());
                acl.setDataCount(count.getDataCount());
                acl.setAreaName(entry.getKey());
                alarmCountLists.add(acl);
            }
        }
        return alarmCountLists;
    }

    private Integer alt(List<AlarmCount> ls, List<AlarmCountBat> bats, Count count, String name, int ids) {
        List<AlarmCount> ls2 = new ArrayList<>();
        AlarmCountBat bat = new AlarmCountBat();
        Count count2 = new Count();
        for (AlarmCount alarmCount : ls) {
            if (alarmCount.getArea().equals(name)) {
                count2.setTotal(count2.getTotal() + alarmCount.getTotal());
                count2.setDeviceCount(count2.getDeviceCount() + alarmCount.getDeviceCount());
                count2.setDataCount(count2.getDataCount() + alarmCount.getDataCount());
                count2.setDisConnectCount(count2.getDisConnectCount() + alarmCount.getDisconnectCount());
                alarmCount.setId(count2.getA());
                alarmCount.setIds(ids);
                ls2.add(alarmCount);
                count2.setA(count2.getA() + 1);
                ids++;
            }
        }
        bat.setIds(ids);
        bat.setId(count.getA());
        bat.setTotal(count2.getTotal());
        bat.setDisconnectCount(count2.getDisConnectCount());
        bat.setDataCount(count2.getDataCount());
        bat.setDeviceCount(count2.getDeviceCount());
        bat.setAreaName(name);
        bat.setAlarmCounts(ls2);
        if (bat.getAlarmCounts().size() > 0) {
            ids++;
            count.setA(count.getA() + 1);
            count.setTotal(count.getTotal() + count2.getTotal());
            count.setDeviceCount(count.getDeviceCount() + count2.getDeviceCount());
            count.setDataCount(count.getDataCount() + count2.getDataCount());
            count.setDisConnectCount(count.getDisConnectCount() + count2.getDisConnectCount());
            bats.add(bat);
        }
        return ids;
    }


    /**
     * @return java.lang.Integer
     * @Author hejunfeng
     * @Date 15:05 2021/1/4 0004
     * @Param [map]
     * @Description 添加水质报警
     **/
    @Override
    public Integer addAlarm(Map<String, Object> map) throws ParseException {
        WaterQualityAlarmData data = new WaterQualityAlarmData();
        if (!StringUtils.isEmpty(map.get("stationId"))){
            data.setStationId(Long.parseLong(map.get("stationId").toString()));
        }
        if (!StringUtils.isEmpty(map.get("deviceId"))){
            data.setDeviceId((Integer) map.get("deviceId"));
        }
        if (!StringUtils.isEmpty(map.get("alarmTime"))){
            String stringDate = (String)map.get("alarmTime");
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = simpleDateFormat.parse(stringDate);
            data.setAlarmtime(date);
        }
        if (!StringUtils.isEmpty(map.get("alarmType"))){
            data.setAlarmtype(Long.parseLong(map.get("alarmType").toString()));
        }
        if (!StringUtils.isEmpty(map.get("description"))){
            data.setDescription((String) map.get("description"));
        }
        if (!StringUtils.isEmpty(map.get("status"))){
            data.setStatus((String) map.get("status"));
        }
        Integer a = mapper.insert(data);
        return a;
    }
}
