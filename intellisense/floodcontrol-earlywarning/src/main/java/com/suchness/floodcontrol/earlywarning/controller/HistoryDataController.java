package com.suchness.floodcontrol.earlywarning.controller;

import com.github.pagehelper.PageInfo;
import com.suchness.floodcontrol.earlywarning.dto.WaterHistoryDto;
import com.suchness.floodcontrol.earlywarning.dto.WaterReportDto;
import com.suchness.floodcontrol.earlywarning.service.HistoryDataService;
import com.suchness.intellisense.common.api.CommonPage;
import com.suchness.intellisense.common.api.CommonResult;
import com.suchness.intellisense.model.WaterHistoryData;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/***
 *  author: rushi
 *  create_time : 2020/12/2811:08
 *******/
@Controller
@Api(tags = "HistoryDataController", description = "历史水文数据")
@RequestMapping("/history")
public class HistoryDataController {

    @Autowired
    private HistoryDataService historyDataService;

    @RequestMapping(value = "/historyData", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<CommonPage<WaterHistoryDto>> register(@RequestParam(value = "code") String code,
                                                             @RequestParam(value = "stationId",required = false) String stationId,
                                                             @RequestParam(value = "startTime",required = false) String startTime,
                                                             @RequestParam(value = "endTime",required = false) String endTime,
                                                             @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                             @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        PageInfo<WaterHistoryDto> historyDtoPageInfo = historyDataService.list(code,stationId,startTime,endTime,pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(historyDtoPageInfo));
    }


}
