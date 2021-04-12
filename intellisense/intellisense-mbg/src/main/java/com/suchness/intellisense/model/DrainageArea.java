package com.suchness.intellisense.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class DrainageArea implements Serializable {
    @ApiModelProperty(value = "流域id")
    private Long id;

    @ApiModelProperty(value = "流域名称")
    private String name;

    @ApiModelProperty(value = "流域id")
    private Integer valleyId;

    @ApiModelProperty(value = "流域代码")
    private String code;

    @ApiModelProperty(value = "水体类型")
    private String type;

    @ApiModelProperty(value = "上级流域")
    private Integer superValleyId;

    @ApiModelProperty(value = "祖级列表")
    private String ancestors;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getSuperValleyId() {
        return superValleyId;
    }

    public void setSuperValleyId(Integer superValleyId) {
        this.superValleyId = superValleyId;
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
        sb.append(", name=").append(name);
        sb.append(", valleyId=").append(valleyId);
        sb.append(", code=").append(code);
        sb.append(", type=").append(type);
        sb.append(", superValleyId=").append(superValleyId);
        sb.append(", ancestors=").append(ancestors);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}