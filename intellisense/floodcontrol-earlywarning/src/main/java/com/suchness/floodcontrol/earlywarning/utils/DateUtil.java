package com.suchness.floodcontrol.earlywarning.utils;

import com.suchness.intellisense.common.utils.DateUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {


    public  static  void main(String[]sre) throws ParseException {

/*
        String weekDays = getWeekDays(2019, 44, 7);
        System.out.println(weekDays);
        String[] weeks = getWeeks("2019", "01");


             System.out.println(Arrays.toString(weeks));*/


        Date afterDate = getBeforeOrAfterDate(DateUtils.parseDate("2019-10-28", "yyyy-MM-dd"), 6);
        System.out.println(afterDate+"=====");
    }

    public  static String getWeekDays(int year, int week, int targetNum) {

 // 计算目标周数
 if (week + targetNum > 52) {
 year++;
 week += targetNum - 52;
 } else if (week + targetNum <= 0) {
 year--;
 week += targetNum + 52;
 } else {
 week += targetNum;
 }

 SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
 Calendar cal= Calendar.getInstance();

 // 设置每周的开始日期
 cal.setFirstDayOfWeek(Calendar.SUNDAY);

 cal.set(Calendar.YEAR, year);
 cal.set(Calendar.WEEK_OF_YEAR, week);

 cal.set(Calendar.DAY_OF_WEEK, cal.getFirstDayOfWeek());
 String beginDate = sdf.format(cal.getTime());

 cal.add(Calendar.DAY_OF_WEEK, 6);
 String endDate = sdf.format(cal.getTime());
 return beginDate + "~" + endDate;
    }



    public static  String[]getWeeks(String year,String week){
        String[] dates = new String[7];
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, Integer.parseInt(year));
        cal.set(Calendar.WEEK_OF_YEAR, Integer.parseInt(week));
        Calendar cal1 = (Calendar)cal.clone();
        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        cal.add(Calendar.DATE,cal.getActualMinimum(Calendar.DAY_OF_WEEK)-dayOfWeek);
        cal.add(Calendar.DATE, 1);
        Date d = cal.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        dates[0] = sdf.format(d).trim();
        String temp = sdf.format(d).trim();
        Calendar tempcal = Calendar.getInstance();
        for(int i = 1; i < 6; i ++){
            try {
                tempcal.setTime(new SimpleDateFormat("yyyy-MM-dd").parse(temp));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            tempcal.set(cal.get(Calendar.YEAR),tempcal.get(Calendar.MONTH),   tempcal.get(Calendar.DATE) + i);
            dates[i] = sdf.format(tempcal.getTime()).trim();
        }
        cal1.add(Calendar.DATE,cal1.getActualMaximum(Calendar.DAY_OF_WEEK)-dayOfWeek);
        cal1.add(Calendar.DATE, 1);
        dates[6] = sdf.format(cal1.getTime()).trim();
        return  dates;
    }



    public static Date getBeforeOrAfterDate(Date date, int num) {
        Calendar calendar = Calendar.getInstance();//获取日历
        calendar.setTime(date);//当date的值是当前时间，则可以不用写这段代码。
        calendar.add(Calendar.DATE, num);
        Date d = calendar.getTime();//把日历转换为Date
        return d;
    }

}
