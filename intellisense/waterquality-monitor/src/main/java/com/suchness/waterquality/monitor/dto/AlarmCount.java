package com.suchness.waterquality.monitor.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author hejunfeng
 * @createTime 2020/12/21
 */
@Getter
@Setter
public class AlarmCount implements Serializable {
    private Integer id;
    private Integer ids;
    private String areaName;
    private Integer deviceCount;
    private Integer dataCount;
    private Integer disconnectCount;
    private Integer total;
    private String area;
    private String superArea;
}
