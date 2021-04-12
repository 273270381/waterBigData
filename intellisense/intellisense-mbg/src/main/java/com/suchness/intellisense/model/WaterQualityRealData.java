package com.suchness.intellisense.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class WaterQualityRealData implements Serializable {
    @ApiModelProperty(value = "主键id")
    private Integer id;

    @ApiModelProperty(value = "站点id")
    private Integer siteId;

    @ApiModelProperty(value = "采样时间")
    private Date dateTime;

    @ApiModelProperty(value = "ph值")
    private Float w01001Rtd;

    @ApiModelProperty(value = "ph值实时数据标记")
    private String w01001Flag;

    @ApiModelProperty(value = "高锰酸盐指数")
    private Float w01019Rtd;

    @ApiModelProperty(value = "高锰酸盐指数实时数据标记")
    private String w01019Flag;

    @ApiModelProperty(value = "总磷")
    private Float w21011Rtd;

    @ApiModelProperty(value = "总磷实时数据标记")
    private String w21011Flag;

    @ApiModelProperty(value = "氨氮")
    private Float w21003Rtd;

    private String w21003Flag;

    @ApiModelProperty(value = "水温")
    private Float w01010Rtd;

    private String w01010Flag;

    @ApiModelProperty(value = "溶解氧")
    private Float w01009Rtd;

    private String w01009Flag;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSiteId() {
        return siteId;
    }

    public void setSiteId(Integer siteId) {
        this.siteId = siteId;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public Float getW01001Rtd() {
        return w01001Rtd;
    }

    public void setW01001Rtd(Float w01001Rtd) {
        this.w01001Rtd = w01001Rtd;
    }

    public String getW01001Flag() {
        return w01001Flag;
    }

    public void setW01001Flag(String w01001Flag) {
        this.w01001Flag = w01001Flag;
    }

    public Float getW01019Rtd() {
        return w01019Rtd;
    }

    public void setW01019Rtd(Float w01019Rtd) {
        this.w01019Rtd = w01019Rtd;
    }

    public String getW01019Flag() {
        return w01019Flag;
    }

    public void setW01019Flag(String w01019Flag) {
        this.w01019Flag = w01019Flag;
    }

    public Float getW21011Rtd() {
        return w21011Rtd;
    }

    public void setW21011Rtd(Float w21011Rtd) {
        this.w21011Rtd = w21011Rtd;
    }

    public String getW21011Flag() {
        return w21011Flag;
    }

    public void setW21011Flag(String w21011Flag) {
        this.w21011Flag = w21011Flag;
    }

    public Float getW21003Rtd() {
        return w21003Rtd;
    }

    public void setW21003Rtd(Float w21003Rtd) {
        this.w21003Rtd = w21003Rtd;
    }

    public String getW21003Flag() {
        return w21003Flag;
    }

    public void setW21003Flag(String w21003Flag) {
        this.w21003Flag = w21003Flag;
    }

    public Float getW01010Rtd() {
        return w01010Rtd;
    }

    public void setW01010Rtd(Float w01010Rtd) {
        this.w01010Rtd = w01010Rtd;
    }

    public String getW01010Flag() {
        return w01010Flag;
    }

    public void setW01010Flag(String w01010Flag) {
        this.w01010Flag = w01010Flag;
    }

    public Float getW01009Rtd() {
        return w01009Rtd;
    }

    public void setW01009Rtd(Float w01009Rtd) {
        this.w01009Rtd = w01009Rtd;
    }

    public String getW01009Flag() {
        return w01009Flag;
    }

    public void setW01009Flag(String w01009Flag) {
        this.w01009Flag = w01009Flag;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", siteId=").append(siteId);
        sb.append(", dateTime=").append(dateTime);
        sb.append(", w01001Rtd=").append(w01001Rtd);
        sb.append(", w01001Flag=").append(w01001Flag);
        sb.append(", w01019Rtd=").append(w01019Rtd);
        sb.append(", w01019Flag=").append(w01019Flag);
        sb.append(", w21011Rtd=").append(w21011Rtd);
        sb.append(", w21011Flag=").append(w21011Flag);
        sb.append(", w21003Rtd=").append(w21003Rtd);
        sb.append(", w21003Flag=").append(w21003Flag);
        sb.append(", w01010Rtd=").append(w01010Rtd);
        sb.append(", w01010Flag=").append(w01010Flag);
        sb.append(", w01009Rtd=").append(w01009Rtd);
        sb.append(", w01009Flag=").append(w01009Flag);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}