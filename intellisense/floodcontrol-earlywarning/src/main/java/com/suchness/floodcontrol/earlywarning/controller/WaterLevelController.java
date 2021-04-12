package com.suchness.floodcontrol.earlywarning.controller;


import com.suchness.floodcontrol.earlywarning.dto.WaterLevelDayDto;
import com.suchness.floodcontrol.earlywarning.dto.WaterLevelMonthDto;
import com.suchness.floodcontrol.earlywarning.dto.WaterLevelYearDto;
import com.suchness.floodcontrol.earlywarning.service.WaterLevelService;
import com.suchness.floodcontrol.earlywarning.utils.DayEnum;
import com.suchness.intellisense.common.api.CommonPage;
import com.suchness.intellisense.common.api.CommonResult;
import com.suchness.intellisense.mapper.WaterLevelMonthMapper;
import com.suchness.intellisense.model.WaterLevelDay;
import com.suchness.intellisense.model.WaterLevelDayExample;
import com.suchness.intellisense.model.WaterLevelMonth;
import com.suchness.intellisense.model.WaterLevelMonthExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


/** 
 * @Author wangchan
 * @Date 15:58 2021/1/5
 * @Param 
 * @Return 
 * @Description 
**/
 
@Controller
@RequestMapping("/waterLevel")
public class WaterLevelController {
     @Autowired
    WaterLevelService waterLevelService;
     @Autowired
    WaterLevelMonthMapper waterLevelMonthMapper;



    @RequestMapping(value = "/waterLevelDay", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<CommonPage<WaterLevelDayDto>> register(@RequestParam(value = "stationId", required = true) String stationId,
                                                            @RequestParam(value = "date",required = true) String date,
                                                            @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<WaterLevelDayDto> roleList = waterLevelService.list(stationId, date,pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(roleList));
    }

    @RequestMapping(value = "/waterLevelMonth", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<CommonPage<WaterLevelMonthDto>> registerMonth(@RequestParam(value = "stationId", required = true) String stationId,
                                                                      @RequestParam(value = "date",required = true) String date,
                                                                      @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                                      @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<WaterLevelMonthDto> roleList = waterLevelService.monthList(stationId, date,pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(roleList));
    }


    @RequestMapping(value = "/waterLevelYear", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<CommonPage<WaterLevelYearDto>> registerYear(@RequestParam(value = "stationId", required = true) String stationId,
                                                                      @RequestParam(value = "date",required = true) String date,
                                                                      @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                                      @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<WaterLevelYearDto> roleList = waterLevelService.yearList(stationId, date,pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(roleList));
    }



    @RequestMapping(value = "/test", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<CommonPage<WaterLevelDayDto>> test( ) {
        java.util.Date nowTime = new Date(System.currentTimeMillis());

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

         if(waterLevelMonthList.size()==0){
             System.out.println("=========");

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
        return CommonResult.success(CommonPage.restPage(waterLevelDayDtoList));
    }

}
