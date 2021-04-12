package com.suchness.floodcontrol.earlywarning.dto;


import com.suchness.intellisense.model.WaterQualityDataDay;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WaterQualityDayDto {
    private List<WaterQualityDataDay>  waterQualityDataDays;
   private  WaterQualityDayBeanDto waterQualityDayBeanDto;

}
