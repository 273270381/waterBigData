package com.suchness.river.patorl.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author hejunfeng
 * @Description TODO
 * @createTime 2021/01/28
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RiverPatrolDataDto {

    @ApiModelProperty(value = "巡河人员")
    private String name;

    @ApiModelProperty(value = "开始时间")
    private Date startTime;

    @ApiModelProperty(value = "结束时间")
    private Date endTime;

    @ApiModelProperty(value = "巡河里程")
    private String mileage;

    @ApiModelProperty(value = "巡河问题")
    private Integer problem;

    @ApiModelProperty(value = "巡河轨迹")
    private String trackPoints;

    @ApiModelProperty(value = "河湖名称")
    private String riverName;

    @ApiModelProperty(value = "巡河状态")
    private String status;

    @ApiModelProperty(value = "所属区域")
    private String riverArea;
}
