package com.suchness.floodcontrol.earlywarning.utils;


import com.suchness.floodcontrol.earlywarning.dto.RainLevelDayDto;
import com.suchness.floodcontrol.earlywarning.dto.WaterLevelDayDto;
import com.suchness.floodcontrol.earlywarning.service.RainLevelSerive;
import com.suchness.floodcontrol.earlywarning.service.WaterLevelService;
import com.suchness.intellisense.model.*;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Component
@EnableScheduling//可以在启动类上注解也可以在当前文
public class RainLevelMonthInsert {


    @Autowired
    private RainLevelSerive rainLevelSerive;


    // 以表达式得形式表示时间
    //每早1点执行
    /**
     * 每早一点插入月报表
     */
    @Scheduled(cron = "0 0 1 * * ?")
    public void runfirst(){

        Date nowTime = new Date(System.currentTimeMillis());


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

        List<RainLevelDayDto> rainLevelDayDtoList = rainLevelSerive.getDayListByDate( date);

        DayEnum match = DayEnum.match(day);
        String rainDay = match.name();


        List<RainLevelMonth> rainLevelMonthList=rainLevelSerive.getMonthListByDate(month);
        RainLevelMonthExample example = new RainLevelMonthExample();
        example.setOrderByClause("day");
        RainLevelMonthExample.Criteria criteria = example.createCriteria();
        //判断月报表该月是否存在，不存在则新建，存在则插入相对日期位置
        if(rainLevelMonthList.size()==0){
            for (RainLevelDayDto rainLevelDayDto:rainLevelDayDtoList){
                rainLevelSerive.insertMonth(rainLevelDayDto.getStationId(),month,rainLevelDayDto.getAverage(),rainDay);
            }
        }
        for (RainLevelDayDto rainLevelDayDto:rainLevelDayDtoList){
            for (RainLevelMonth rainLevelMonth: rainLevelMonthList){
                if(rainLevelDayDto.getStationId().equals(rainLevelMonth.getStationid())){
                    rainLevelSerive.updateMonth(rainLevelDayDto.getStationId(),month,rainLevelDayDto.getAverage(),rainDay);
                }
            }
        }


    }

}
