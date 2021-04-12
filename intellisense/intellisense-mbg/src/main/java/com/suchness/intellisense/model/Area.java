package com.suchness.intellisense.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class Area implements Serializable {
    private Long id;

    @ApiModelProperty(value = "区域id")
    private Integer areaId;

    @ApiModelProperty(value = "地区名称")
    private String areaName;

    @ApiModelProperty(value = "地区编码")
    private String areaCode;

    @ApiModelProperty(value = "地区等级")
    private Integer leverId;

    @ApiModelProperty(value = "上级地区id")
    private Integer superAreaId;

    @ApiModelProperty(value = "组级列表")
    private String ancestors;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public Integer getLeverId() {
        return leverId;
    }

    public void setLeverId(Integer leverId) {
        this.leverId = leverId;
    }

    public Integer getSuperAreaId() {
        return superAreaId;
    }

    public void setSuperAreaId(Integer superAreaId) {
        this.superAreaId = superAreaId;
    }

    public String getAncestors() {
        return ancestors;
    }

    public void setAncestors(String ancestors) {
        this.ancestors = ancestors;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", areaId=").append(areaId);
        sb.append(", areaName=").append(areaName);
        sb.append(", areaCode=").append(areaCode);
        sb.append(", leverId=").append(leverId);
        sb.append(", superAreaId=").append(superAreaId);
        sb.append(", ancestors=").append(ancestors);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}