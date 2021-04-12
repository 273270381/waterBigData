package com.suchness.river.patorl.dao;

import com.suchness.river.patorl.dto.RiverPatrolDataDto;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * @author hejunfeng
 * @createTime 2021/01/28
 */
public interface RiverPatrolDao {
    List<RiverPatrolDataDto> getRiverPatrolData(@Param("areaId") String areaId, @Param("startTime") Date startTime, @Param("endTime") Date endTime,
                                                @Param("name") String name, @Param("status") Integer status);
}
