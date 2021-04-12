package com.suchness.river.patorl.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.suchness.intellisense.common.utils.DateUtils;
import com.suchness.intellisense.mapper.RiverAreaMapper;
import com.suchness.intellisense.mapper.RiverTrackMapper;
import com.suchness.intellisense.model.RiverArea;
import com.suchness.intellisense.model.RiverAreaExample;
import com.suchness.intellisense.model.RiverTrack;
import com.suchness.river.patorl.dao.RiverPatrolDao;
import com.suchness.river.patorl.domain.TreeSelect;
import com.suchness.river.patorl.dto.RiverAreaDto;
import com.suchness.river.patorl.dto.RiverPatrolDataDto;
import com.suchness.river.patorl.service.RiverPatrolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author hejunfeng
 * @Description TODO
 * @createTime 2021/01/28
 */
@Service
public class RiverPatorlServiceImpl implements RiverPatrolService {
    @Autowired
    private RiverAreaMapper riverAreaMapper;
    @Autowired
    private RiverPatrolDao dao;
    @Autowired
    private RiverTrackMapper trackMapper;

    /***
     * @return java.util.List<com.suchness.river.patorl.dto.RiverAreaDto>
     * @Author hejunfeng
     * @Date 11:26 2021/1/28 0028
     * @Param []
     * @Description 巡河区域
     **/
    @Override
    public List<RiverAreaDto> getRiverAreas() {
        RiverAreaExample example = new RiverAreaExample();
        RiverAreaExample.Criteria criteria = example.createCriteria();
        criteria.andIdIsNotNull();
        List<RiverArea> areas = riverAreaMapper.selectByExample(example);
        List<RiverAreaDto> dtos = new ArrayList<>();
        if (areas.size() > 0){
            for (RiverArea area : areas){
                RiverAreaDto dto = new RiverAreaDto();
                dto.setChildren(new ArrayList<>());
                dto.setAncestors(area.getAncestors());
                dto.setId(area.getId());
                dto.setName(area.getName());
                dto.setParentId(area.getParentId());
                dtos.add(dto);
            }
        }
        return dtos;
    }

    @Override
    public PageInfo<RiverPatrolDataDto> getRiverPatrolDatas(String areaId, String startTime, String endTime, String name, Integer status, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum,pageSize);
        List<RiverPatrolDataDto> dataDtos = new ArrayList<>();
        if (!StringUtils.isEmpty(startTime) && !StringUtils.isEmpty(endTime)){
            dataDtos = dao.getRiverPatrolData(areaId, DateUtils.dateTime(DateUtils.YYYY_MM_DD,startTime),DateUtils.dateTime(DateUtils.YYYY_MM_DD,endTime),name,status);
        }else{
            dataDtos = dao.getRiverPatrolData(areaId, null,null,name,status);
        }
        PageInfo listInfo = new PageInfo<>(dataDtos);
        return listInfo;
    }

    /**
     * 构建前端所需要下拉树结构
     *
     * @param depts 部门列表
     * @return 下拉树结构列表
     */
    @Override
    public List<TreeSelect> buildAreaTreeSelect(List<RiverAreaDto> depts)
    {
        List<RiverAreaDto> deptTrees = buildAreaTree(depts);
        return deptTrees.stream().map(TreeSelect::new).collect(Collectors.toList());
    }

    /**
     * 构建前端所需要树结构
     *
     * @param areaDtos 区域列表
     * @return 树结构列表
     */
    @Override
    public List<RiverAreaDto> buildAreaTree(List<RiverAreaDto> areaDtos) {
        List<RiverAreaDto> returnList = new ArrayList<RiverAreaDto>();
        List<Integer> tempList = new ArrayList<Integer>();
        for (RiverAreaDto dto : areaDtos)
        {
            tempList.add(dto.getId());
        }
        for (Iterator<RiverAreaDto> iterator = areaDtos.iterator(); iterator.hasNext();)
        {
            RiverAreaDto dto = (RiverAreaDto) iterator.next();
            // 如果是顶级节点, 遍历该父节点的所有子节点
            if (!tempList.contains(dto.getParentId()))
            {
                recursionFn(areaDtos, dto);
                returnList.add(dto);
            }
        }
        if (returnList.isEmpty())
        {
            returnList = areaDtos;
        }
        return returnList;
    }

    @Override
    public void uploadTrackData(String string) {
        RiverTrack track = new RiverTrack();
        track.setTrackpoints(string);
        trackMapper.insert(track);
    }

    /**
     * 递归列表
     */
    private void recursionFn(List<RiverAreaDto> list, RiverAreaDto t) {
        // 得到子节点列表
        List<RiverAreaDto> childList = getChildList(list, t);
        t.setChildren(childList);
        for (RiverAreaDto tChild : childList)
        {
            if (hasChild(list, tChild))
            {
                recursionFn(list, tChild);
            }
        }
    }

    /**
     * 得到子节点列表
     */
    private List<RiverAreaDto> getChildList(List<RiverAreaDto> list, RiverAreaDto t) {
        List<RiverAreaDto> tlist = new ArrayList<RiverAreaDto>();
        Iterator<RiverAreaDto> it = list.iterator();
        while (it.hasNext())
        {
            RiverAreaDto n = (RiverAreaDto) it.next();
            if (!StringUtils.isEmpty(n.getParentId()) && n.getParentId().longValue() == t.getId())
            {
                tlist.add(n);
            }
        }
        return tlist;
    }

    /**
     * 判断是否有子节点
     */
    private boolean hasChild(List<RiverAreaDto> list, RiverAreaDto t) {
        return getChildList(list, t).size() > 0 ? true : false;
    }
}
