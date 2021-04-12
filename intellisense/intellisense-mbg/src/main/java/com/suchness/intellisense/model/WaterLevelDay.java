package com.suchness.intellisense.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class WaterLevelDay implements Serializable {
    private Integer id;

    private String stationId;

    private String day;

    private Double zeroHour;

    private Double firstHour;

    private Double secondHour;

    private Double thirdHour;

    private Double fourthHour;

    private Double fifthHour;

    private Double sixthHour;

    private Double seventhHour;

    private Double eighthHour;

    private Double ninthHour;

    private Double tenthHour;

    private Double eleventhHour;

    private Double twelfthHour;

    private Double thirteenthHour;

    private Double fourteenthHour;

    private Double fifteenthHour;

    private Double sixteenthHour;

    private Double seventeenthHour;

    private Double eighteenthHour;

    private Double nineteenthHour;

    private Double twentiethHour;

    private Double twentiethFirstHour;

    private Double twentiethTwoHour;

    private Double twentiethThreeHour;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStationId() {
        return stationId;
    }

    public void setStationId(String stationId) {
        this.stationId = stationId;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public Double getZeroHour() {
        return zeroHour;
    }

    public void setZeroHour(Double zeroHour) {
        this.zeroHour = zeroHour;
    }

    public Double getFirstHour() {
        return firstHour;
    }

    public void setFirstHour(Double firstHour) {
        this.firstHour = firstHour;
    }

    public Double getSecondHour() {
        return secondHour;
    }

    public void setSecondHour(Double secondHour) {
        this.secondHour = secondHour;
    }

    public Double getThirdHour() {
        return thirdHour;
    }

    public void setThirdHour(Double thirdHour) {
        this.thirdHour = thirdHour;
    }

    public Double getFourthHour() {
        return fourthHour;
    }

    public void setFourthHour(Double fourthHour) {
        this.fourthHour = fourthHour;
    }

    public Double getFifthHour() {
        return fifthHour;
    }

    public void setFifthHour(Double fifthHour) {
        this.fifthHour = fifthHour;
    }

    public Double getSixthHour() {
        return sixthHour;
    }

    public void setSixthHour(Double sixthHour) {
        this.sixthHour = sixthHour;
    }

    public Double getSeventhHour() {
        return seventhHour;
    }

    public void setSeventhHour(Double seventhHour) {
        this.seventhHour = seventhHour;
    }

    public Double getEighthHour() {
        return eighthHour;
    }

    public void setEighthHour(Double eighthHour) {
        this.eighthHour = eighthHour;
    }

    public Double getNinthHour() {
        return ninthHour;
    }

    public void setNinthHour(Double ninthHour) {
        this.ninthHour = ninthHour;
    }

    public Double getTenthHour() {
        return tenthHour;
    }

    public void setTenthHour(Double tenthHour) {
        this.tenthHour = tenthHour;
    }

    public Double getEleventhHour() {
        return eleventhHour;
    }

    public void setEleventhHour(Double eleventhHour) {
        this.eleventhHour = eleventhHour;
    }

    public Double getTwelfthHour() {
        return twelfthHour;
    }

    public void setTwelfthHour(Double twelfthHour) {
        this.twelfthHour = twelfthHour;
    }

    public Double getThirteenthHour() {
        return thirteenthHour;
    }

    public void setThirteenthHour(Double thirteenthHour) {
        this.thirteenthHour = thirteenthHour;
    }

    public Double getFourteenthHour() {
        return fourteenthHour;
    }

    public void setFourteenthHour(Double fourteenthHour) {
        this.fourteenthHour = fourteenthHour;
    }

    public Double getFifteenthHour() {
        return fifteenthHour;
    }

    public void setFifteenthHour(Double fifteenthHour) {
        this.fifteenthHour = fifteenthHour;
    }

    public Double getSixteenthHour() {
        return sixteenthHour;
    }

    public void setSixteenthHour(Double sixteenthHour) {
        this.sixteenthHour = sixteenthHour;
    }

    public Double getSeventeenthHour() {
        return seventeenthHour;
    }

    public void setSeventeenthHour(Double seventeenthHour) {
        this.seventeenthHour = seventeenthHour;
    }

    public Double getEighteenthHour() {
        return eighteenthHour;
    }

    public void setEighteenthHour(Double eighteenthHour) {
        this.eighteenthHour = eighteenthHour;
    }

    public Double getNineteenthHour() {
        return nineteenthHour;
    }

    public void setNineteenthHour(Double nineteenthHour) {
        this.nineteenthHour = nineteenthHour;
    }

    public Double getTwentiethHour() {
        return twentiethHour;
    }

    public void setTwentiethHour(Double twentiethHour) {
        this.twentiethHour = twentiethHour;
    }

    public Double getTwentiethFirstHour() {
        return twentiethFirstHour;
    }

    public void setTwentiethFirstHour(Double twentiethFirstHour) {
        this.twentiethFirstHour = twentiethFirstHour;
    }

    public Double getTwentiethTwoHour() {
        return twentiethTwoHour;
    }

    public void setTwentiethTwoHour(Double twentiethTwoHour) {
        this.twentiethTwoHour = twentiethTwoHour;
    }

    public Double getTwentiethThreeHour() {
        return twentiethThreeHour;
    }

    public void setTwentiethThreeHour(Double twentiethThreeHour) {
        this.twentiethThreeHour = twentiethThreeHour;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", stationId=").append(stationId);
        sb.append(", day=").append(day);
        sb.append(", zeroHour=").append(zeroHour);
        sb.append(", firstHour=").append(firstHour);
        sb.append(", secondHour=").append(secondHour);
        sb.append(", thirdHour=").append(thirdHour);
        sb.append(", fourthHour=").append(fourthHour);
        sb.append(", fifthHour=").append(fifthHour);
        sb.append(", sixthHour=").append(sixthHour);
        sb.append(", seventhHour=").append(seventhHour);
        sb.append(", eighthHour=").append(eighthHour);
        sb.append(", ninthHour=").append(ninthHour);
        sb.append(", tenthHour=").append(tenthHour);
        sb.append(", eleventhHour=").append(eleventhHour);
        sb.append(", twelfthHour=").append(twelfthHour);
        sb.append(", thirteenthHour=").append(thirteenthHour);
        sb.append(", fourteenthHour=").append(fourteenthHour);
        sb.append(", fifteenthHour=").append(fifteenthHour);
        sb.append(", sixteenthHour=").append(sixteenthHour);
        sb.append(", seventeenthHour=").append(seventeenthHour);
        sb.append(", eighteenthHour=").append(eighteenthHour);
        sb.append(", nineteenthHour=").append(nineteenthHour);
        sb.append(", twentiethHour=").append(twentiethHour);
        sb.append(", twentiethFirstHour=").append(twentiethFirstHour);
        sb.append(", twentiethTwoHour=").append(twentiethTwoHour);
        sb.append(", twentiethThreeHour=").append(twentiethThreeHour);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}