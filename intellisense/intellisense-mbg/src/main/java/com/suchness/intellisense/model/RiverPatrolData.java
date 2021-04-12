package com.suchness.intellisense.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class RiverPatrolData implements Serializable {
    @ApiModelProperty(value = "主键id")
    private Integer id;

    @ApiModelProperty(value = "巡河人员")
    private String name;

    @ApiModelProperty(value = "开始时间")
    private Date startTime;

    @ApiModelProperty(value = "结束时间")
    private Date endTime;

    @ApiModelProperty(value = "巡河里程")
    private String mileage;

    @ApiModelProperty(value = "巡河问题")
    private Integer problem;

    @ApiModelProperty(value = "巡河轨迹id")
    private Integer riverTrackId;

    @ApiModelProperty(value = "河湖id")
    private Integer riverId;

    @ApiModelProperty(value = "巡河状态id")
    private Integer status;

    @ApiModelProperty(value = "所属区域")
    private Integer riverAreaId;

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

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getMileage() {
        return mileage;
    }

    public void setMileage(String mileage) {
        this.mileage = mileage;
    }

    public Integer getProblem() {
        return problem;
    }

    public void setProblem(Integer problem) {
        this.problem = problem;
    }

    public Integer getRiverTrackId() {
        return riverTrackId;
    }

    public void setRiverTrackId(Integer riverTrackId) {
        this.riverTrackId = riverTrackId;
    }

    public Integer getRiverId() {
        return riverId;
    }

    public void setRiverId(Integer riverId) {
        this.riverId = riverId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getRiverAreaId() {
        return riverAreaId;
    }

    public void setRiverAreaId(Integer riverAreaId) {
        this.riverAreaId = riverAreaId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", startTime=").append(startTime);
        sb.append(", endTime=").append(endTime);
        sb.append(", mileage=").append(mileage);
        sb.append(", problem=").append(problem);
        sb.append(", riverTrackId=").append(riverTrackId);
        sb.append(", riverId=").append(riverId);
        sb.append(", status=").append(status);
        sb.append(", riverAreaId=").append(riverAreaId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}