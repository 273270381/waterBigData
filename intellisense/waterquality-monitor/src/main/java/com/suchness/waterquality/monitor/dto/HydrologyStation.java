package com.suchness.waterquality.monitor.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author hejunfeng
 * @Description 水文站点
 * @createTime 2020/12/28
 */
@Getter
@Setter
public class HydrologyStation {
    private Integer id;
    private Integer ids;
    private String stationName;
    private String stationId;
    private String code;
    private String areaName;
    private String valleyName;
    private String longitude;
    private String latitude;
    private String high;
    private String createTime;
    private String country;
    private Boolean isChecked = false;
}
