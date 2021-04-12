package com.suchness.floodcontrol.earlywarning.dto;

import com.suchness.intellisense.model.WaterHistoryData;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

/***
 *  author: rushi
 *  create_time : 2020/12/299:23
 *******/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WaterHistoryDto extends WaterHistoryData {

    private Double cumulativeRain;
}
