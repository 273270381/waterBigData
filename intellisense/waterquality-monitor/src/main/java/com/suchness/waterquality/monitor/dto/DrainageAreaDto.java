package com.suchness.waterquality.monitor.dto;

import com.suchness.intellisense.model.DrainageArea;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hejunfeng
 * @Description 流域
 * @createTime 2020/12/29
 */
@Getter
@Setter
public class DrainageAreaDto extends DrainageArea {
    private List<AreaDto> children = new ArrayList<AreaDto>();
}
