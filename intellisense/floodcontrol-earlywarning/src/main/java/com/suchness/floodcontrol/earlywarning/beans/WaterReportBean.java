package com.suchness.floodcontrol.earlywarning.beans;

import com.suchness.intellisense.model.WaterRealTimeData;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/***
 *  author: rushi
 *  create_time : 2020/12/2115:43
 *******/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WaterReportBean extends WaterRealTimeData {

    /**
     * 站点名称
     */
    private String stationName;


}
