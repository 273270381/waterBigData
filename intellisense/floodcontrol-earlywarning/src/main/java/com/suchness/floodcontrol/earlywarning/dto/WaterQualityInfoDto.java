package com.suchness.floodcontrol.earlywarning.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WaterQualityInfoDto {

    /**
     * 开始日期
     */
    private  String startDate;


    /**
     * 结束日期
     */
    private  String endDate;


    /**
     * 流域
     */
    private   String waterArea;

    /**
     * 断面类型
     */
    private String stationType;
    /**
     * 是否联网  联网 1   未联网 2
     */
    private String onLine;
    /**
     * 运行状态  正常 1  断线 2  超标 3
     */
    private String runStatus;
    /**
     * 流域名称
     */
    private String valleyName;
    /**
     * 区域
     */
    private String regionName;
    /**
     * 点位id
     */
    private Integer siteId;
    /***
     * 点位名称
     */
    private String siteName;
    /**
     * 采集时间
     */
    private String captureTime;
    /**
     * 高猛酸盐指数
     */
    private String gmsy;
    /**
     * 总磷
     */
    private String zl;
    /**
     * 氨氮
     */
    private String ad;
    /**
     * 水温
     */
    private String sw;
    /**
     * ph
     */
    private String ph;
    /**
     * 溶解氧
     */
    private String rjy;
    /**
     * 氧化还原点位
     */
    private String yhhydw;
    /**
     * 站点地址
     */
    private String address;
    /**
     * 经度
     */
    private String longitude;
    /**
     * 纬度
     */
    private String latitude;



}
