package com.suchness.waterquality.monitor.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/***
 *  author: rushi
 *  create_time : 2021/1/2116:16
 *******/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WaterQualityEvaluationDto {
    /**
     * 第几周
     */
    private Integer weekNum;
    /**
     * 站名
     */
    private String siteName;
    /**
     * 区域名称
     */
    private String areaName;
    /**
     * 流域名称
     */
    private String valleyName;

    private List<WaterQualityInfoDto> waterQualityInfoDtoList;
}
