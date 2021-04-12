package com.suchness.waterquality.monitor.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/***
 *  author: rushi
 *  create_time : 2021/1/611:34
 *******/
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WaterQualityDto {

    private SiteRunStatus siteRunStatus;

    private List<WaterQualityInfoDto> waterQualityInfoDtos;
}
