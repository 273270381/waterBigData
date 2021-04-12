package com.suchness.floodcontrol.earlywarning.utils;


import com.suchness.floodcontrol.earlywarning.dto.WaterLevelDayDto;
import com.suchness.floodcontrol.earlywarning.service.WaterLevelService;
import com.suchness.intellisense.model.WaterLevelDay;
import com.suchness.intellisense.model.WaterLevelMonth;
import com.suchness.intellisense.model.WaterLevelMonthExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @Author wangchan
 * @Date 15:58 2021/1/5
 * @Param
 * @Return 
 * @Description  定时插入月报表
**/
 
@Component
@EnableScheduling//可以在启动类上注解也可以在当前文
public class WaterLevelMonthInsert {
    @Autowired
    private WaterLevelService waterLevelService;


    // 以表达式得形式表示时间
    //每早1点执行
    /**
     * 每早一点插入月报表
     */
    @Scheduled(cron = "0 0 1 * * ?")
    public void runfirst(){
        java.util.Date nowTime = new Date(System.currentTimeMillis());



        System.out.println(nowTime+"=========数据插入");


        // 前一天时间
        Calendar cal=Calendar.getInstance();
        cal.add(Calendar.DATE,-1);
        Date yesterdayTime=cal.getTime();


        SimpleDateFormat sdFormatter = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat monthMatter=new SimpleDateFormat("yyyy-MM");
        SimpleDateFormat dayMatter=new SimpleDateFormat("dd");

        String date = sdFormatter.format(yesterdayTime);
        String month = monthMatter.format(yesterdayTime);
        String  day=dayMatter.format(yesterdayTime);
        //获取前一天得水位日报

        List<WaterLevelDayDto> waterLevelDayDtoList = waterLevelService.getDayListByDate( date);

        DayEnum match = DayEnum.match(day);
        String rainDay = match.name();


        List<WaterLevelMonth> waterLevelMonthList=waterLevelService.getMonthListByDate(month);
        WaterLevelMonthExample example = new WaterLevelMonthExample();
        example.setOrderByClause("day");
        WaterLevelMonthExample.Criteria criteria = example.createCriteria();
        //判断月报表该月是否存在，不存在则新建，存在则插入相对日期位置
        if(waterLevelMonthList.size()==0){
            for (WaterLevelDayDto waterLevelDayDto:waterLevelDayDtoList){
                waterLevelService.insertMonth(waterLevelDayDto.getStationId(),month,waterLevelDayDto.getAverage(),rainDay);
            }
        }
        for (WaterLevelDayDto waterLevelDayDto:waterLevelDayDtoList){
            for (WaterLevelMonth waterLevelMonth: waterLevelMonthList){
                if(waterLevelDayDto.getStationId().equals(waterLevelMonth.getStationid())){
                    waterLevelService.updateMonth(waterLevelDayDto.getStationId(),month,waterLevelDayDto.getAverage(),rainDay);
                }
            }
        }


    }


}
