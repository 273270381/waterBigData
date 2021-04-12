package com.suchness.floodcontrol.earlywarning.dto;


import com.suchness.intellisense.model.WaterLevelMonth;
import com.suchness.intellisense.model.WaterLevelYear;
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
public class WaterLevelYearDto {
    private WaterLevelYear waterLevelYear;
    private  double max;
    private  String maxTime;
    private  double min;
    private  String minTime;
    private  double average;

    public WaterLevelYearDto(WaterLevelYear waterLevelYear){

        this.waterLevelYear=waterLevelYear;
        this.max=getMax();
        this.maxTime  =getMaxTime();
        this.min=getMin();
        this.minTime=getMinTime();
        this.average=getAverage();
    }



    public Map<String ,Double> getAllValue(){

        Map<String,Double> map=new LinkedHashMap<>();
        map.put("1月",waterLevelYear.getOne());
        map.put("2月",waterLevelYear.getTwo());
        map.put("3月",waterLevelYear.getThree());
        map.put("4月",waterLevelYear.getFour());
        map.put("5月",waterLevelYear.getFive());
        map.put("6月",waterLevelYear.getSix());
        map.put("7月",waterLevelYear.getSeven());
        map.put("8月",waterLevelYear.getEight());
        map.put("9月",waterLevelYear.getNine());
        map.put("10月",waterLevelYear.getTen());
        map.put("11月",waterLevelYear.getEleven());
        map.put("12月",waterLevelYear.getTwelve());


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
