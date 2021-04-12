package com.suchness.waterquality.monitor.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author hejunfeng
 * @Description TODO
 * @createTime 2021/01/04
 */
@Getter
@Setter
public class AlarmCountList {
    private Integer id;
    private Integer ids;
    private String areaName;
    private Integer deviceCount;
    private Integer dataCount;
    private Integer disconnectCount;
    private Integer total;
    private List<AlarmCountBat> alarmCounts;
}
