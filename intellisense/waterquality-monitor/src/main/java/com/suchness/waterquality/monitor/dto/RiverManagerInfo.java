package com.suchness.waterquality.monitor.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author hejunfeng
 * @createTime 2020/12/29
 */
@Getter
@Setter
public class RiverManagerInfo {
    private Integer id;
    private String name;
    private String lever;
    private String type;
    private String areaName;
    private String post;
    private List<String> riverName;
    private String account;
}
