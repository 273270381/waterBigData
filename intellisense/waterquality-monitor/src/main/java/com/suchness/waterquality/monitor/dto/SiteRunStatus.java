package com.suchness.waterquality.monitor.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/***
 *  author: rushi
 *  create_time : 2021/1/610:20
 *******/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SiteRunStatus {
    /**
     * 联网率
     */
    private String onLineRate;
    /**
     * 联网个数
     */
    private String onLineNum;
    /**
     * 下线率
     */
    private String offLineNum;
    /**
     * 异常
     */
    private String unNormalNum;
    /**
     * 超标
     */
    private String overNum;

}
