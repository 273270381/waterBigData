package com.suchness.floodcontrol.earlywarning.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WaterQualityMathBean {
    private  float minW01019_Rtd;
    private  float maxW01019_Rtd;
    private  Integer countW01019_Rtd;
    private  float avgW01019_Rtd;


    private  float minW21011_Rtd;
    private  float maxW21011_Rtd;
    private  Integer countW21011_Rtd;
    private  float avgW21011_Rtd;

    private  float minW21003_Rtd;
    private  float maxW21003_Rtd;
    private  Integer countW21003_Rtd;
    private  float avgW21003_Rtd;

    private  float minW01010_Rtd;
    private  float maxW01010_Rtd;
    private  Integer countW01010_Rtd;
    private  float avgW01010_Rtd;

    private  float minW01001_Rtd;
    private  float maxW01001_Rtd;
    private  Integer countW01001_Rtd;
    private  float avgW01001_Rtd;

    private  float minW01009_Rtd;
    private  float maxW01009_Rtd;
    private  Integer countW01009_Rtd;
    private  float avgW01009_Rtd;
}
