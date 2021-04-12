package com.suchness.river.patorl.dto;

import com.suchness.intellisense.model.RiverArea;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hejunfeng
 * @Description TODO
 * @createTime 2021/01/28
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RiverAreaDto extends RiverArea {
    /** 子区域 */
    private List<RiverAreaDto> children = new ArrayList<RiverAreaDto>();
}
