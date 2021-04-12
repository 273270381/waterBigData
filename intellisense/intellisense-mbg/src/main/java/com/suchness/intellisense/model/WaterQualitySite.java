package com.suchness.intellisense.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class WaterQualitySite implements Serializable {
    @ApiModelProperty(value = "主键id")
    private Integer id;

    @ApiModelProperty(value = "站点名称")
    private String name;

    @ApiModelProperty(value = "经度")
    private String longitude;

    @ApiModelProperty(value = "纬度")
    private String latitude;

    @ApiModelProperty(value = "地区")
    private String codeRegion;

    @ApiModelProperty(value = "水域")
    private String codeWaterarea;

    @ApiModelProperty(value = "地址")
    private String address;

    @ApiModelProperty(value = "手机号码")
    private String phone;

    @ApiModelProperty(value = "联系人")
    private String contactman;

    @ApiModelProperty(value = "描述")
    private String description;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "最后修改时间")
    private Date lastModifyTime;

    @ApiModelProperty(value = "图片")
    private String pictures;

    @ApiModelProperty(value = "编码")
    private String code;

    @ApiModelProperty(value = "站点类型")
    private Integer stationTypeId;

    @ApiModelProperty(value = "地区等级")
    private Integer leverId;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getCodeRegion() {
        return codeRegion;
    }

    public void setCodeRegion(String codeRegion) {
        this.codeRegion = codeRegion;
    }

    public String getCodeWaterarea() {
        return codeWaterarea;
    }

    public void setCodeWaterarea(String codeWaterarea) {
        this.codeWaterarea = codeWaterarea;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getContactman() {
        return contactman;
    }

    public void setContactman(String contactman) {
        this.contactman = contactman;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastModifyTime() {
        return lastModifyTime;
    }

    public void setLastModifyTime(Date lastModifyTime) {
        this.lastModifyTime = lastModifyTime;
    }

    public String getPictures() {
        return pictures;
    }

    public void setPictures(String pictures) {
        this.pictures = pictures;
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

    public Integer getLeverId() {
        return leverId;
    }

    public void setLeverId(Integer leverId) {
        this.leverId = leverId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", longitude=").append(longitude);
        sb.append(", latitude=").append(latitude);
        sb.append(", codeRegion=").append(codeRegion);
        sb.append(", codeWaterarea=").append(codeWaterarea);
        sb.append(", address=").append(address);
        sb.append(", phone=").append(phone);
        sb.append(", contactman=").append(contactman);
        sb.append(", description=").append(description);
        sb.append(", createTime=").append(createTime);
        sb.append(", lastModifyTime=").append(lastModifyTime);
        sb.append(", pictures=").append(pictures);
        sb.append(", code=").append(code);
        sb.append(", stationTypeId=").append(stationTypeId);
        sb.append(", leverId=").append(leverId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}