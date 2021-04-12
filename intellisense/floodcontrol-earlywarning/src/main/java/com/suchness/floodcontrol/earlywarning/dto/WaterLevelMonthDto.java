package com.suchness.floodcontrol.earlywarning.dto;


import com.suchness.intellisense.model.WaterLevelDay;
import com.suchness.intellisense.model.WaterLevelMonth;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class WaterLevelMonthDto {
    private WaterLevelMonth waterLevelMonth;
    private  double max;
    private  String maxTime;
    private  double min;
    private  String minTime;
    private  double average;

    public WaterLevelMonthDto(WaterLevelMonth waterLevelMonth){

        this.waterLevelMonth=waterLevelMonth;
        this.max=getMax();
        this.maxTime  =getMaxTime();
        this.min=getMin();
        this.minTime=getMinTime();
        this.average=getAverage();
    }



    public Map<String ,Double> getAllValue(){

        Map<String,Double> map=new LinkedHashMap<>();
        map.put("1日",waterLevelMonth.getOne());
        map.put("2日",waterLevelMonth.getTwo());
        map.put("3日",waterLevelMonth.getThree());
        map.put("4日",waterLevelMonth.getFour());
        map.put("5日",waterLevelMonth.getFive());
        map.put("6日",waterLevelMonth.getSix());
        map.put("7日",waterLevelMonth.getSeven());
        map.put("8日",waterLevelMonth.getEight());
        map.put("9日",waterLevelMonth.getNine());
        map.put("10日",waterLevelMonth.getTen());
        map.put("11日",waterLevelMonth.getEleven());
        map.put("12日",waterLevelMonth.getTwelve());
        map.put("13日",waterLevelMonth.getThirteen());
        map.put("14日",waterLevelMonth.getFourteen());
        map.put("15日",waterLevelMonth.getFifteen());
        map.put("16日",waterLevelMonth.getSixteen());
        map.put("17日",waterLevelMonth.getSeventeen());
        map.put("18日",waterLevelMonth.getEighteen());
        map.put("19日",waterLevelMonth.getNineteen());
        map.put("20日",waterLevelMonth.getTwenty());
        map.put("21日",waterLevelMonth.getTwentyOne());
        map.put("22日",waterLevelMonth.getTwentyTwo());
        map.put("23日",waterLevelMonth.getTwentyThree());
        map.put("24日",waterLevelMonth.getTwentyFour());
        map.put("25日",waterLevelMonth.getTwentyFive());
        map.put("26日",waterLevelMonth.getTwentySix());
        map.put("27日",waterLevelMonth.getTwentySeven());
        map.put("28日",waterLevelMonth.getTwentyEight());
        map.put("29日",waterLevelMonth.getTwentyNine());
        map.put("30日",waterLevelMonth.getThirty());
        map.put("31日",waterLevelMonth.getThirtyOne());

        return   map;

    }





    public  String  getMaxTime(){
        Map<String,Double> valueMap=getAllValue();
        Double max=0.0;
        String maxTime="";
        Map<String,Double>maxMap=new HashMap<>();
        Iterator it=valueMap.keySet().iterator();

        while (it.hasNext()){

            String key = it.next().toString();
            Double value=valueMap.get(key);
            if(!StringUtils.isEmpty(value)){
                if(max<=value){
                    max=value;
                    maxTime=key;
                }

            }

        }

        maxMap.put(maxTime,valueMap.get(valueMap));

        return  maxTime;
    }

    public  Double getMax(){

        return  getAllValue().get(getMaxTime());


    }



    public  Double getMin(){

        return getAllValue().get(getMinTime());

    }


    public String getMinTime(){
        Map<String,Double> valueMap=getAllValue();
        Double min=1000.0;
        String minTime="";
        Map<String,Double>minMap=new HashMap<>();
        Iterator it=valueMap.keySet().iterator();
        while (it.hasNext()){
            String key = it.next().toString();
            Double value=valueMap.get(key);
            if(!StringUtils.isEmpty(value)){
                if(min>value){
                    min=value;
                    minTime=key;
                }

            }

        }

        minMap.put(minTime,valueMap.get(valueMap));

        return  minTime;
    }


    public  Double getAverage(){

        Map<String,Double> valueMap=getAllValue();
        Double  sum=0.0;
        int size=0;
        Iterator it=valueMap.keySet().iterator();
        while (it.hasNext()){
            String key = it.next().toString();
            Double value=valueMap.get(key);
            size++;
            if(!StringUtils.isEmpty(value)){
                sum+=value;


            }

        }


       /* DecimalFormat df = new DecimalFormat("#,##0.00");
        String format = df.format(sum / size);*/

        BigDecimal bg = new BigDecimal((double)(sum/size));
        double avg = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        return  avg;
    }

}
