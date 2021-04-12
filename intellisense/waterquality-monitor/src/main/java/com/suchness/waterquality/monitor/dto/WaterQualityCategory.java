package com.suchness.waterquality.monitor.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author hejunfeng
 * @Description 水质类别
 * @createTime 2020/12/29
 */

@Getter
@Setter
public class WaterQualityCategory {
    private Integer id;
    private String name;
    private String lever;
    private String status;
    private String color;
    private String des;
}
