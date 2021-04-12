package com.suchness.river.patorl.service;

import com.github.pagehelper.PageInfo;
import com.suchness.river.patorl.domain.TreeSelect;
import com.suchness.river.patorl.dto.RiverAreaDto;
import com.suchness.river.patorl.dto.RiverPatrolDataDto;

import java.util.List;

/**
 * @author hejunfeng
 * @Description TODO
 * @createTime 2021/01/28
 */
public interface RiverPatrolService {
    List<RiverAreaDto> getRiverAreas();

    PageInfo<RiverPatrolDataDto> getRiverPatrolDatas(String areaId,String startTime,String endTime,String name,Integer status,Integer pageSize,Integer pageNum);

    List<TreeSelect> buildAreaTreeSelect(List<RiverAreaDto> areaDtos);

    List<RiverAreaDto> buildAreaTree(List<RiverAreaDto> depts);

    void uploadTrackData(String string);
}
