package com.suchness.floodcontrol.earlywarning.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WaterQualityDayBeanDto {
  private List<Integer> count;
  private  List<Float>  min;
  private  List<Float> max;
  private  List<Float>avg;
    public WaterQualityDayBeanDto(WaterQualityMathBean waterQualityDayBean){
        ArrayList<Integer> countList = new ArrayList<>();
        countList.add(waterQualityDayBean.getCountW01019_Rtd());
        countList.add(waterQualityDayBean.getCountW21011_Rtd());
        countList.add(waterQualityDayBean.getCountW21003_Rtd());
        countList.add(waterQualityDayBean.getCountW01010_Rtd());
        countList.add(waterQualityDayBean.getCountW01001_Rtd());
        countList.add(waterQualityDayBean.getCountW01009_Rtd());

        this.count=countList;


        ArrayList<Float> minList = new ArrayList<>();
        minList.add(waterQualityDayBean.getMinW01019_Rtd());
        minList.add(waterQualityDayBean.getMinW21011_Rtd());
        minList.add(waterQualityDayBean.getMinW21003_Rtd());
        minList.add(waterQualityDayBean.getMinW01010_Rtd());
        minList.add(waterQualityDayBean.getMinW01001_Rtd());
        minList.add(waterQualityDayBean.getMinW01009_Rtd());

        this.min=minList;


        ArrayList<Float> maxList = new ArrayList<>();
        maxList.add(waterQualityDayBean.getMaxW01019_Rtd());
        maxList.add(waterQualityDayBean.getMaxW21011_Rtd());
        maxList.add(waterQualityDayBean.getMaxW21003_Rtd());
        maxList.add(waterQualityDayBean.getMaxW01010_Rtd());
        maxList.add(waterQualityDayBean.getMaxW01001_Rtd());
        maxList.add(waterQualityDayBean.getMaxW01009_Rtd());

        this.max=maxList;


        ArrayList<Float> avgList = new ArrayList<>();
        avgList.add(waterQualityDayBean.getAvgW01019_Rtd());
        avgList.add(waterQualityDayBean.getAvgW21011_Rtd());
        avgList.add(waterQualityDayBean.getAvgW21003_Rtd());
        avgList.add(waterQualityDayBean.getAvgW01010_Rtd());
        avgList.add(waterQualityDayBean.getAvgW01001_Rtd());
        avgList.add(waterQualityDayBean.getAvgW01009_Rtd());

        this.avg=avgList;







    }

}
