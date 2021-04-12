package com.suchness.waterquality.monitor.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
/**
 * @author hejunfeng
 * @createTime 2020/12/19
 */
@Getter
@Setter
public class AlarmManagerParam {

    @ApiModelProperty(value = "id")
    private Integer id;

    @ApiModelProperty(value = "站点")
    private String stationName;

    @ApiModelProperty(value = "监测项目/设备")
    private String device;

    @ApiModelProperty(value = "报警时间")
    private String alarmTime;

    @ApiModelProperty(value = "报警类型")
    private String alarmType;

    @ApiModelProperty(value = "报警描述")
    private String description;

    @ApiModelProperty(value = "通知状态")
    private String status;

}
