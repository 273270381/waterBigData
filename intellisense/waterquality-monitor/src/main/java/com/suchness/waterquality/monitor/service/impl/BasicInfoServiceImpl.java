package com.suchness.waterquality.monitor.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.suchness.intellisense.mapper.*;
import com.suchness.intellisense.model.*;
import com.suchness.intellisense.model.Area;
import com.suchness.waterquality.monitor.dao.BasicInfoDao;
import com.suchness.waterquality.monitor.dto.*;
import com.suchness.waterquality.monitor.dto.WaterQualityCategory;
import com.suchness.waterquality.monitor.service.BasicInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author hejunfeng
 * @Description TODO
 * @createTime 2020/12/29
 */
@Service
public class BasicInfoServiceImpl implements BasicInfoService {
    @Autowired
    private BasicInfoDao areaInfoDao;
    @Autowired
    private RiversMapper riversMapper;
    @Autowired
    private RiverManagersMapper managersMapper;
    @Autowired
    private AreaMapper areaMapper;
    @Autowired
    private DepartmentMapper departmentMapper;
    @Autowired
    private DictMapper dictMapper;
    @Autowired
    private DrainageAreaMapper drainageAreaMapper;

    /**
     * @return java.util.List<com.suchness.waterquality.monitor.dto.AreaDto>
     * @Author hejunfeng
     * @Date 11:41 2020/12/29 0029
     * @Param [areaName, code, superArea]
     * @Description 行政区划
     **/
    @Override
    public PageInfo<AreaDto> getAreaInfos(Integer areaId, String code, String superAreaId, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum,pageSize);
        AreaExample areaExample = new AreaExample();
        AreaExample.Criteria criteria = areaExample.createCriteria();
        List<AreaDto> areaDtos = new ArrayList<>();
        if (!StringUtils.isEmpty(areaId)){
            criteria.andAreaIdEqualTo(areaId);
        }
        if(!StringUtils.isEmpty(code)){
            criteria.andAreaCodeLike("%"+code+"%");
        }
        List<Area> areaList = areaMapper.selectByExample(areaExample);
        if (areaList.size() > 0){
            for (Area area : areaList){
                AreaDto areaDto = new AreaDto();
                areaDto.setAreaCode(area.getAreaCode());
                areaDto.setAreaId(area.getAreaId());
                areaDto.setAreaName(area.getAreaName());
                areaDto.setId(area.getId());
                areaDto.setLeverId(area.getLeverId());
                areaDto.setSuperAreaId(area.getSuperAreaId());
                areaDto.setAncestors(area.getAncestors());
                areaDto.setChildren(new ArrayList<>());
                areaDtos.add(areaDto);
            }
        }
        PageInfo listInfo = new PageInfo<>(areaDtos);
        return listInfo;
    }


    /***
     * @return java.util.List<com.suchness.waterquality.monitor.dto.DrainageAreaDto>
     * @Author hejunfeng
     * @Date 14:50 2020/12/29 0029
     * @Param []
     * @Description 流域管理
     **/
    @Override
    public PageInfo<DrainageAreaDto> getValleyInfo(Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum,pageSize);
        DrainageAreaExample example = new DrainageAreaExample();
        DrainageAreaExample.Criteria criteria = example.createCriteria();
        criteria.andValleyIdIsNotNull();
        List<DrainageArea> ls =  drainageAreaMapper.selectByExample(example);
        List<DrainageAreaDto> list = new ArrayList<>();
        if (ls.size() > 0){
            for (DrainageArea drainageArea : ls){
                DrainageAreaDto dto = new DrainageAreaDto();
                dto.setChildren(new ArrayList<>());
                dto.setAncestors(drainageArea.getAncestors());
                dto.setCode(drainageArea.getCode());
                dto.setId(drainageArea.getId());
                dto.setName(drainageArea.getName());
                dto.setSuperValleyId(drainageArea.getSuperValleyId());
                dto.setType(drainageArea.getType());
                dto.setValleyId(drainageArea.getValleyId());
                list.add(dto);
            }
        }
        PageInfo listInfo = new PageInfo<>(list);
        return listInfo;
    }

    /**
     * @return java.util.List<com.suchness.waterquality.monitor.dto.WaterQualityCategory>
     * @Author hejunfeng
     * @Date 16:04 2020/12/29 0029
     * @Param []
     * @Description 水质类别      
     **/
    @Override
    public List<WaterQualityCategory> getWaterCategory() {
        List<WaterQualityCategory> list = areaInfoDao.getWaterCategory();
        return list;
    }

    /**
     * @return java.util.List<com.suchness.intellisense.model.Rivers>
     * @Author hejunfeng
     * @Date 16:05 2020/12/29 0029
     * @Param []
     * @Description 河湖名录
     **/
    @Override
    public PageInfo<RiversInfo> getRivers(String riverName,Double waterAcreage,Integer pageSize,Integer pageNum) {
        PageHelper.startPage(pageNum,pageSize);
        List<RiversInfo> riversInfos = areaInfoDao.getRivers(riverName,waterAcreage);
        PageInfo listInfo = new PageInfo<>(riversInfos);
        return listInfo;
    }

    /***
     * @return java.util.List<com.suchness.waterquality.monitor.dto.RiverManagerInfo>
     * @Author hejunfeng
     * @Date 16:44 2020/12/29 0029
     * @Param [name, account]
     * @Description 河长名录
     **/
    @Override
    public PageInfo<RiverManagerInfo> getRiverManagers(String name, String account,Integer pageSize,Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        RiverManagersExample managersExample = new RiverManagersExample();
        RiverManagersExample.Criteria criteria = managersExample.createCriteria();
        if (!StringUtils.isEmpty(name)){
            criteria.andNameLike("%"+name+"%");
        }
        if (!StringUtils.isEmpty(account)){
            criteria.andAccountLike("%"+account+"%");
        }
        List<RiverManagers> list = managersMapper.selectByExample(managersExample);
        List<RiverManagerInfo> managersList = new ArrayList<>();
        for (RiverManagers managers : list){
            RiverManagerInfo riverManagerInfo = new RiverManagerInfo();
            AreaExample areaExample = new AreaExample();
            AreaExample.Criteria criteria1 = areaExample.createCriteria();
            if (!StringUtils.isEmpty(managers.getAreaId())){
                criteria1.andAreaIdEqualTo(managers.getAreaId());
                List<Area> areas = areaMapper.selectByExample(areaExample);
                if (areas.size() > 0){
                    riverManagerInfo.setAreaName(areas.get(0).getAreaName());
                }
            }
            RiversExample riversExample = new RiversExample();
            RiversExample.Criteria criteria2 = riversExample.createCriteria();
            if (!StringUtils.isEmpty(managers.getId())){
                criteria2.andNameIdEqualTo(managers.getId().toString());
                List<Rivers> rivers = riversMapper.selectByExample(riversExample);
                List<String> ls = new ArrayList<>();
                for (Rivers r : rivers){
                    ls.add(r.getRivername());
                }
                riverManagerInfo.setRiverName(ls);
            }
            if (!StringUtils.isEmpty(managers.getLeverId())){
                Dict dict = dictMapper.selectByPrimaryKey(managers.getLeverId());
                riverManagerInfo.setLever(dict.getName());
            }
            riverManagerInfo.setId(managers.getId());
            riverManagerInfo.setName(managers.getName());
            riverManagerInfo.setType(managers.getType());
            riverManagerInfo.setPost(managers.getPost());
            riverManagerInfo.setAccount(managers.getAccount());
            managersList.add(riverManagerInfo);
        }
        PageInfo listInfo = new PageInfo<>(managersList);
        return listInfo;
    }


    @Override
    public List<DictInfo> getDictInfo(String name) {
        DictExample dictExample = new DictExample();
        DictExample.Criteria criteria = dictExample.createCriteria();
        criteria.andNameEqualTo(name);
        List<Dict> dicts = dictMapper.selectByExample(dictExample);
        List<DictInfo> list = new ArrayList<>();
        if (dicts.size() > 0){
            Integer id = dicts.get(0).getId();
            DictExample dictExample1 = new DictExample();
            DictExample.Criteria criteria1 = dictExample1.createCriteria();
            criteria1.andPidEqualTo(id);
            List<Dict> dictList = dictMapper.selectByExample(dictExample1);
            for (Dict dict : dictList){
                DictInfo dictInfo = new DictInfo();
                dictInfo.setId(dict.getId());
                dictInfo.setName(dict.getName());
                list.add(dictInfo);
            }
        }
        return list;
    }

    @Override
    public Map getDicts() {
        DictExample example = new DictExample();
        DictExample.Criteria criteria = example.createCriteria();
        criteria.andIdIsNotNull();
        List<Dict> dicts = dictMapper.selectByExample(example);
        Map<Integer,Object> map = dicts.stream().collect(Collectors.toMap(dict -> dict.getId(),dict -> dict.getName()));
        return map;
    }
}
