package com.suchness.waterquality.monitor.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author hejunfeng
 * @createTime 2020/12/31
 */
@Getter
@Setter
public class RiversInfo {
    private Integer id;

    private String rivername;

    private String managername;

    private String lever;

    private Double length;

    private Double valleyacreage;

    private Double wateracreage;

    private String post;
}
