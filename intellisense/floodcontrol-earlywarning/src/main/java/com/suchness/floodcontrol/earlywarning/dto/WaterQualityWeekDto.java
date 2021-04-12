package com.suchness.floodcontrol.earlywarning.dto;


import com.suchness.intellisense.model.WaterQualityDataDay;
import com.suchness.intellisense.model.WaterQualityDataWeek;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WaterQualityWeekDto {

    private List<WaterQualityDataWeek> waterQualityDataWeeks;
    private  WaterQualityDayBeanDto waterQualityDayBeanDto;
    private  String startTime;
    private  String endTime;

}
