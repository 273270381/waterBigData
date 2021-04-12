package com.suchness.floodcontrol.earlywarning.dto;

import com.suchness.intellisense.model.WaterLevelDay;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WaterLevelDayDto {

      private WaterLevelDay waterLevelDay;
    private  double max;
    private  String maxTime;
    private  double min;
    private  String minTime;
    private  double average;
    private  String  stationId;
   private  String date;
    public WaterLevelDayDto(WaterLevelDay waterLevelDay){
        this.date=waterLevelDay.getDay();
        this.stationId=waterLevelDay.getStationId();
        this.waterLevelDay=waterLevelDay;
        this.max=getMax();
      this.maxTime  =getMaxTime();
        this.min=getMin();
        this.minTime=getMinTime();
        this.average=getAverage();
    }



    public Map<String ,Double> AllValue(){

        Map<String,Double> map=new LinkedHashMap<>();
        map.put("0时",waterLevelDay.getZeroHour());
        map.put("1时",waterLevelDay.getFirstHour());
        map.put("2时",waterLevelDay.getSecondHour());
        map.put("3时",waterLevelDay.getThirdHour());
        map.put("4时",waterLevelDay.getFourthHour());
        map.put("5时",waterLevelDay.getFifthHour());
        map.put("6时",waterLevelDay.getSixthHour());
        map.put("7时",waterLevelDay.getSeventhHour());
        map.put("8时",waterLevelDay.getEighthHour());
        map.put("9时",waterLevelDay.getNinthHour());
        map.put("10时",waterLevelDay.getTenthHour());
        map.put("11时",waterLevelDay.getEleventhHour());
        map.put("12时",waterLevelDay.getTwelfthHour());
        map.put("13时",waterLevelDay.getThirteenthHour());
        map.put("14时",waterLevelDay.getFourteenthHour());
        map.put("15时",waterLevelDay.getFifteenthHour());
        map.put("16时",waterLevelDay.getSixteenthHour());
        map.put("17时",waterLevelDay.getSeventeenthHour());
        map.put("18时",waterLevelDay.getEighteenthHour());
        map.put("19时",waterLevelDay.getNineteenthHour());
        map.put("20时",waterLevelDay.getTwentiethHour());
        map.put("21时",waterLevelDay.getTwentiethFirstHour());
        map.put("22时",waterLevelDay.getTwentiethTwoHour());
        map.put("23时",waterLevelDay.getTwentiethThreeHour());

        return   map;

    }





    public  String  getMaxTime(){
        Map<String,Double> valueMap=AllValue();
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

        return  AllValue().get(getMaxTime());


    }



    public  Double getMin(){

        return AllValue().get(getMinTime());

    }


    public String getMinTime(){
        Map<String,Double> valueMap=AllValue();
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

        Map<String,Double> valueMap=AllValue();
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
