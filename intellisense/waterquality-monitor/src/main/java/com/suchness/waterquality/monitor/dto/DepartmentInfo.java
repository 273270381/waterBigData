package com.suchness.waterquality.monitor.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author hejunfeng
 * @Description TODO
 * @createTime 2020/12/30
 */
@Getter
@Setter
public class DepartmentInfo {
    private String name;
    private String area;
    private String address;
    private String telephone;
    private String lever;
    private List<String> member;
}
