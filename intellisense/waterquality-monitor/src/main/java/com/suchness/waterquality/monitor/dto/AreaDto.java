package com.suchness.waterquality.monitor.dto;

import com.suchness.intellisense.model.Area;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hejunfeng
 * @Description 区域
 * @createTime 2021/01/23
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AreaDto extends Area {
    /** 子区域 */
    private List<AreaDto> children = new ArrayList<AreaDto>();
}
