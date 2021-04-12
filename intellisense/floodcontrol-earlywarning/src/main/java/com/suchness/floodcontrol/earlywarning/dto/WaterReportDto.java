package com.suchness.floodcontrol.earlywarning.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/***
 *  author: rushi
 *  create_time : 2020/12/2110:37
 *******/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WaterReportDto {

    /**
     * 站名
     */
    private String stationName;
    /***
     * 采集时间
     */
    private String captureTime;
    /**
     *
     * 水位
     */
    private Double waterLevel;
    /**
     * 水深
     */
    private Double waterdepth;
    /**
     * 预警值
     */
    private Double warningValue;
    /**
     * 报警值
     */
    private Double alarmingValue;
    /**
     * 雨量
     */
    private Double rainValue;






}
