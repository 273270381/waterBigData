package com.suchness.intellisense.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class WaterLevelYear implements Serializable {
    private Integer id;

    private String stationid;

    private String date;

    private Double one;

    private Double two;

    private Double three;

    private Double four;

    private Double five;

    private Double six;

    private Double seven;

    private Double eight;

    private Double nine;

    private Double ten;

    private Double eleven;

    private Double twelve;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStationid() {
        return stationid;
    }

    public void setStationid(String stationid) {
        this.stationid = stationid;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Double getOne() {
        return one;
    }

    public void setOne(Double one) {
        this.one = one;
    }

    public Double getTwo() {
        return two;
    }

    public void setTwo(Double two) {
        this.two = two;
    }

    public Double getThree() {
        return three;
    }

    public void setThree(Double three) {
        this.three = three;
    }

    public Double getFour() {
        return four;
    }

    public void setFour(Double four) {
        this.four = four;
    }

    public Double getFive() {
        return five;
    }

    public void setFive(Double five) {
        this.five = five;
    }

    public Double getSix() {
        return six;
    }

    public void setSix(Double six) {
        this.six = six;
    }

    public Double getSeven() {
        return seven;
    }

    public void setSeven(Double seven) {
        this.seven = seven;
    }

    public Double getEight() {
        return eight;
    }

    public void setEight(Double eight) {
        this.eight = eight;
    }

    public Double getNine() {
        return nine;
    }

    public void setNine(Double nine) {
        this.nine = nine;
    }

    public Double getTen() {
        return ten;
    }

    public void setTen(Double ten) {
        this.ten = ten;
    }

    public Double getEleven() {
        return eleven;
    }

    public void setEleven(Double eleven) {
        this.eleven = eleven;
    }

    public Double getTwelve() {
        return twelve;
    }

    public void setTwelve(Double twelve) {
        this.twelve = twelve;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", stationid=").append(stationid);
        sb.append(", date=").append(date);
        sb.append(", one=").append(one);
        sb.append(", two=").append(two);
        sb.append(", three=").append(three);
        sb.append(", four=").append(four);
        sb.append(", five=").append(five);
        sb.append(", six=").append(six);
        sb.append(", seven=").append(seven);
        sb.append(", eight=").append(eight);
        sb.append(", nine=").append(nine);
        sb.append(", ten=").append(ten);
        sb.append(", eleven=").append(eleven);
        sb.append(", twelve=").append(twelve);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}