package com.suchness.intellisense.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class Rivers implements Serializable {
    @ApiModelProperty(value = "主键id")
    private Integer id;

    @ApiModelProperty(value = "河流名称")
    private String rivername;

    @ApiModelProperty(value = "河长姓名")
    private String nameId;

    @ApiModelProperty(value = "河流等级")
    private Integer leverId;

    @ApiModelProperty(value = "河流长度")
    private Double length;

    @ApiModelProperty(value = "流域面积")
    private Double valleyacreage;

    @ApiModelProperty(value = "水域面积")
    private Double wateracreage;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRivername() {
        return rivername;
    }

    public void setRivername(String rivername) {
        this.rivername = rivername;
    }

    public String getNameId() {
        return nameId;
    }

    public void setNameId(String nameId) {
        this.nameId = nameId;
    }

    public Integer getLeverId() {
        return leverId;
    }

    public void setLeverId(Integer leverId) {
        this.leverId = leverId;
    }

    public Double getLength() {
        return length;
    }

    public void setLength(Double length) {
        this.length = length;
    }

    public Double getValleyacreage() {
        return valleyacreage;
    }

    public void setValleyacreage(Double valleyacreage) {
        this.valleyacreage = valleyacreage;
    }

    public Double getWateracreage() {
        return wateracreage;
    }

    public void setWateracreage(Double wateracreage) {
        this.wateracreage = wateracreage;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", rivername=").append(rivername);
        sb.append(", nameId=").append(nameId);
        sb.append(", leverId=").append(leverId);
        sb.append(", length=").append(length);
        sb.append(", valleyacreage=").append(valleyacreage);
        sb.append(", wateracreage=").append(wateracreage);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}