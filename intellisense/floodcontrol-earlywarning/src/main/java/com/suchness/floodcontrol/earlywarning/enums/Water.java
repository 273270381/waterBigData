package com.suchness.floodcontrol.earlywarning.enums;

/***
 *  author: rushi
 *  create_time : 2020/12/2111:09
 *******/
public enum Water {

    WATER_LEVEL("水位","WL"),
    RAIN_FALL("雨量","YL");



    private String desc;
    private String code;

    Water(String desc, String code) {
        this.desc = desc;
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
