package com.suchness.floodcontrol.earlywarning.dto;

import com.suchness.intellisense.model.WaterAlarmData;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/***
 *  author: rushi
 *  create_time : 2021/1/49:51
 *******/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WaterAlarmDto extends WaterAlarmData {


    /**
     * 站点名称
     */
    private String stationName;
    /**
     * 报警名称
     */
    private String alarmName;

}
