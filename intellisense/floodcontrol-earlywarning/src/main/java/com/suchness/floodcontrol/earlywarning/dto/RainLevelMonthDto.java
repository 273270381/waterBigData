package com.suchness.floodcontrol.earlywarning.dto;

import com.suchness.intellisense.model.RainLevelMonth;
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
public class RainLevelMonthDto {
    private RainLevelMonth rainLevelMonth;
    private  double max;
    private  String maxTime;
    private  double min;
    private  String minTime;
    private  double average;

    public RainLevelMonthDto(RainLevelMonth rainLevelMonth){

        this.rainLevelMonth=rainLevelMonth;
        this.max=getMax();
        this.maxTime  =getMaxTime();
        this.min=getMin();
        this.minTime=getMinTime();
        this.average=getAverage();
    }



    public Map<String ,Double> getAllValue(){

        Map<String,Double> map=new LinkedHashMap<>();
        map.put("1日",rainLevelMonth.getOne());
        map.put("2日",rainLevelMonth.getTwo());
        map.put("3日",rainLevelMonth.getThree());
        map.put("4日",rainLevelMonth.getFour());
        map.put("5日",rainLevelMonth.getFive());
        map.put("6日",rainLevelMonth.getSix());
        map.put("7日",rainLevelMonth.getSeven());
        map.put("8日",rainLevelMonth.getEight());
        map.put("9日",rainLevelMonth.getNine());
        map.put("10日",rainLevelMonth.getTen());
        map.put("11日",rainLevelMonth.getEleven());
        map.put("12日",rainLevelMonth.getTwelve());
        map.put("13日",rainLevelMonth.getThirteen());
        map.put("14日",rainLevelMonth.getFourteen());
        map.put("15日",rainLevelMonth.getFifteen());
        map.put("16日",rainLevelMonth.getSixteen());
        map.put("17日",rainLevelMonth.getSeventeen());
        map.put("18日",rainLevelMonth.getEighteen());
        map.put("19日",rainLevelMonth.getNineteen());
        map.put("20日",rainLevelMonth.getTwenty());
        map.put("21日",rainLevelMonth.getTwentyOne());
        map.put("22日",rainLevelMonth.getTwentyTwo());
        map.put("23日",rainLevelMonth.getTwentyThree());
        map.put("24日",rainLevelMonth.getTwentyFour());
        map.put("25日",rainLevelMonth.getTwentyFive());
        map.put("26日",rainLevelMonth.getTwentySix());
        map.put("27日",rainLevelMonth.getTwentySeven());
        map.put("28日",rainLevelMonth.getTwentyEight());
        map.put("29日",rainLevelMonth.getTwentyNine());
        map.put("30日",rainLevelMonth.getThirty());
        map.put("31日",rainLevelMonth.getThirtyOne());

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
