package com.suchness.floodcontrol.earlywarning.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WaterQualityCompDto {
    //流域
    private  String area;

    // 断面名称
    private  String stationName;

   //断面类型
    private  String stationType;

    //高锰酸盐指数
    private  Double mnO;

    //氨氮含量
    private  Double  nH;
    //ph

    private  Double pH;

  //本周水质
    private  String     waterQualityNow;
    //上周水质
    private  String   waterQualityLast;

    //功能区类型
    private  String functionType;

    //主要污染物
    private String  polluteMain;


}
