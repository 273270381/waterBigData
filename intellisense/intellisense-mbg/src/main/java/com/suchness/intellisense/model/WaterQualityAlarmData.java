package com.suchness.intellisense.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class WaterQualityAlarmData implements Serializable {
    private Long id;

    @ApiModelProperty(value = "站点id")
    private Long stationId;

    @ApiModelProperty(value = "监测项目/设备")
    private Integer deviceId;

    @ApiModelProperty(value = "报警时间")
    private Date alarmtime;

    @ApiModelProperty(value = "报警类型")
    private Long alarmtype;

    @ApiModelProperty(value = "报警描述")
    private String description;

    @ApiModelProperty(value = "通知状态")
    private String status;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getStationId() {
        return stationId;
    }

    public void setStationId(Long stationId) {
        this.stationId = stationId;
    }

    public Integer getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Integer deviceId) {
        this.deviceId = deviceId;
    }

    public Date getAlarmtime() {
        return alarmtime;
    }

    public void setAlarmtime(Date alarmtime) {
        this.alarmtime = alarmtime;
    }

    public Long getAlarmtype() {
        return alarmtype;
    }

    public void setAlarmtype(Long alarmtype) {
        this.alarmtype = alarmtype;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", stationId=").append(stationId);
        sb.append(", deviceId=").append(deviceId);
        sb.append(", alarmtime=").append(alarmtime);
        sb.append(", alarmtype=").append(alarmtype);
        sb.append(", description=").append(description);
        sb.append(", status=").append(status);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}