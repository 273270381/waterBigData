package com.suchness.intellisense.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class RiverManagers implements Serializable {
    private Integer id;

    @ApiModelProperty(value = "河长姓名")
    private String name;

    @ApiModelProperty(value = "河长级别")
    private Integer leverId;

    @ApiModelProperty(value = "河长类型")
    private String type;

    @ApiModelProperty(value = "区域id")
    private Integer areaId;

    @ApiModelProperty(value = "行政职务")
    private String post;

    @ApiModelProperty(value = "河长账号")
    private String account;

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

    public Integer getLeverId() {
        return leverId;
    }

    public void setLeverId(Integer leverId) {
        this.leverId = leverId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", leverId=").append(leverId);
        sb.append(", type=").append(type);
        sb.append(", areaId=").append(areaId);
        sb.append(", post=").append(post);
        sb.append(", account=").append(account);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}