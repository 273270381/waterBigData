package com.suchness.floodcontrol.earlywarning.dto;


import com.suchness.intellisense.model.WaterQualityDataDay;
import com.suchness.intellisense.model.WaterQualityDataYear;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WaterQualityYearDto {

    private List<WaterQualityDataYear> waterQualityDataDays;
    private  WaterQualityDayBeanDto waterQualityDayBeanDto;
}
