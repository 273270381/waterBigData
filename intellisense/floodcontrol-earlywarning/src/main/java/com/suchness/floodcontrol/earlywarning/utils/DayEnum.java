package com.suchness.floodcontrol.earlywarning.utils;

public enum  DayEnum {
    one("01") ,
    two("02") ,
    three("03") ,
    four("04") ,
    five("05") ,
    six("06") ,
    seven("07") ,
    eight("08") ,
    nine("09") ,
    ten("20") ,
    eleven("11") ,
    twelve("12") ,
    thirteen("13") ,
    fourteen("14") ,
    fifteen("15") ,
    sixteen("16") ,
    seventeen("17") ,
    eighteen("18") ,
    nineteen("19") ,
    twenty("20") ,
    twenty_one("21") ,
    twenty_two("22") ,
    twenty_three("23") ,
    twenty_four("24") ,
    twenty_five("25") ,
    twenty_six("26") ,
    twenty_seven("27") ,
    twenty_eight("28") ,
    twenty_nine("29") ,
    thirty("30") ,
    thirty_one("31") ;


    private final String day;

    private DayEnum(String day){
        this.day = day;
    }

    public String getDay() {
        return day;
    }

    public static DayEnum match(String day){
        if (day != null) {
            for (DayEnum item: DayEnum.values()) {
                if (item.getDay().equals(day)) {
                    return item;
                }
            }
        }
        return null;
    }

}
