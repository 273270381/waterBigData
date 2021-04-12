package com.suchness.intellisense.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class WaterQualityStation implements Serializable {
    private Long id;

    @ApiModelProperty(value = "水质站点名称")
    private String name;

    @ApiModelProperty(value = "水质站点id")
    private Integer stationId;

    @ApiModelProperty(value = "区域id")
    private Integer areaId;

    @ApiModelProperty(value = "流域id")
    private Integer valleyId;

    @ApiModelProperty(value = "编码")
    private String code;

    @ApiModelProperty(value = "站点类型id")
    private Integer stationTypeId;

    @ApiModelProperty(value = "经度")
    private BigDecimal longitude;

    @ApiModelProperty(value = "纬度")
    private BigDecimal latitude;

    @ApiModelProperty(value = "地区等级id")
    private Integer leverId;

    @ApiModelProperty(value = "是否联网")
    private String connected;

    @ApiModelProperty(value = "监测时间")
    private Date monitorTime;

    @ApiModelProperty(value = "高锰酸钾(mg/L)")
    private Float kmno4;

    @ApiModelProperty(value = "总磷(mg/L)")
    private Float p4;

    @ApiModelProperty(value = "氨氮(mg/L)")
    private Float nh4;

    @ApiModelProperty(value = "水温(℃)")
    private Float waterTemperature;

    @ApiModelProperty(value = "PH")
    private Float ph;

    @ApiModelProperty(value = "溶解氧(mg/L)")
    private Float dissolvedOxygen;

    @ApiModelProperty(value = "氧化还原电位(mV)")
    private Float redoxPotential;

    @ApiModelProperty(value = "点位状态")
    private String status;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStationId() {
        return stationId;
    }

    public void setStationId(Integer stationId) {
        this.stationId = stationId;
    }

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public Integer getValleyId() {
        return valleyId;
    }

    public void setValleyId(Integer valleyId) {
        this.valleyId = valleyId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getStationTypeId() {
        return stationTypeId;
    }

    public void setStationTypeId(Integer stationTypeId) {
        this.stationTypeId = stationTypeId;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public Integer getLeverId() {
        return leverId;
    }

    public void setLeverId(Integer leverId) {
        this.leverId = leverId;
    }

    public String getConnected() {
        return connected;
    }

    public void setConnected(String connected) {
        this.connected = connected;
    }

    public Date getMonitorTime() {
        return monitorTime;
    }

    public void setMonitorTime(Date monitorTime) {
        this.monitorTime = monitorTime;
    }

    public Float getKmno4() {
        return kmno4;
    }

    public void setKmno4(Float kmno4) {
        this.kmno4 = kmno4;
    }

    public Float getP4() {
        return p4;
    }

    public void setP4(Float p4) {
        this.p4 = p4;
    }

    public Float getNh4() {
        return nh4;
    }

    public void setNh4(Float nh4) {
        this.nh4 = nh4;
    }

    public Float getWaterTemperature() {
        return waterTemperature;
    }

    public void setWaterTemperature(Float waterTemperature) {
        this.waterTemperature = waterTemperature;
    }

    public Float getPh() {
        return ph;
    }

    public void setPh(Float ph) {
        this.ph = ph;
    }

    public Float getDissolvedOxygen() {
        return dissolvedOxygen;
    }

    public void setDissolvedOxygen(Float dissolvedOxygen) {
        this.dissolvedOxygen = dissolvedOxygen;
    }

    public Float getRedoxPotential() {
        return redoxPotential;
    }

    public void setRedoxPotential(Float redoxPotential) {
        this.redoxPotential = redoxPotential;
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
        sb.append(", name=").append(name);
        sb.append(", stationId=").append(stationId);
        sb.append(", areaId=").append(areaId);
        sb.append(", valleyId=").append(valleyId);
        sb.append(", code=").append(code);
        sb.append(", stationTypeId=").append(stationTypeId);
        sb.append(", longitude=").append(longitude);
        sb.append(", latitude=").append(latitude);
        sb.append(", leverId=").append(leverId);
        sb.append(", connected=").append(connected);
        sb.append(", monitorTime=").append(monitorTime);
        sb.append(", kmno4=").append(kmno4);
        sb.append(", p4=").append(p4);
        sb.append(", nh4=").append(nh4);
        sb.append(", waterTemperature=").append(waterTemperature);
        sb.append(", ph=").append(ph);
        sb.append(", dissolvedOxygen=").append(dissolvedOxygen);
        sb.append(", redoxPotential=").append(redoxPotential);
        sb.append(", status=").append(status);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}