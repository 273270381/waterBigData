package com.suchness.waterquality.monitor.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @author hejunfeng
 * @Description 水质站点
 * @createTime 2020/12/25
 */
@Getter
@Setter
public class WaterStation {
    @ApiModelProperty(value = "id")
    private Integer id;

    @ApiModelProperty(value = "ids")
    private Integer ids;

    @ApiModelProperty(value = "站点")
    private String stationName;

    @ApiModelProperty(value = "编码")
    private String code;

    @ApiModelProperty(value = "区域")
    private String areaName;

    @ApiModelProperty(value = "站点类型")
    private String stationType;

    @ApiModelProperty(value = "经度")
    private String longitude;

    @ApiModelProperty(value = "纬度")
    private String latitude;

    @ApiModelProperty(value = "控制级别")
    private String controLever;
}
