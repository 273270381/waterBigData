package com.suchness.waterquality.monitor.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author hejunfeng
 * @Description TODO
 * @createTime 2021/01/12
 */
@Getter
@Setter
public class WaterStationdto {
    private String name;
    private List<WaterStation> stations;
}
