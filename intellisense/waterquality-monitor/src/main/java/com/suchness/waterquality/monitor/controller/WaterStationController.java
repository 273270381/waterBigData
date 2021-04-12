package com.suchness.waterquality.monitor.controller;

import com.github.pagehelper.PageInfo;
import com.suchness.intellisense.common.api.CommonPage;
import com.suchness.intellisense.common.api.CommonResult;
import com.suchness.waterquality.monitor.dto.HydrologyStation;
import com.suchness.waterquality.monitor.dto.WaterQualityStation;
import com.suchness.waterquality.monitor.dto.WaterStation;
import com.suchness.waterquality.monitor.service.StationService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

/**
 * @author hejunfeng
 * @Description 水质站点查询
 * @createTime 2020/12/25
 */
@Controller
@RequestMapping("/waterStationController")
public class WaterStationController {
    @Autowired
    private StationService stationService;

    @ApiOperation("水质站点查询")
    @RequestMapping(value = "/stationlist", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<CommonPage<WaterStation>> getStation(@RequestParam(value = "area",required = false) String area,
                                                       @RequestParam(value = "stationName",required = false) String stationName,
                                                       @RequestParam(value = "code",required = false) String code,
                                                       @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                       @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum){
        PageInfo<WaterStation> list = stationService.getWaterStation(area,stationName,code,pageSize,pageNum);
        if (list.getList().size() > 0){
            return CommonResult.success(CommonPage.restPage(list));
        }else{
            return CommonResult.failed("未找到站点");
        }
    }

    @ApiOperation("水质站点添加")
    @RequestMapping(value = "/stationAdd", method = RequestMethod.POST)
    @ResponseBody
    public Object addStation(@RequestBody Map<String, Object> map){
        Integer s= stationService.addStation(map);
        if (s != null){
            return CommonResult.success("添加成功");
        }
        return CommonResult.failed();
    }

    @ApiOperation("水质站点删除")
    @DeleteMapping("/Station/{ids}")
    @ResponseBody
    public Object deleteStation(@PathVariable Integer[] ids){
        for (Integer id : ids){
            stationService.deleteStation(id);
        }
        return CommonResult.success("删除成功");
    }

    @ApiOperation("水质站点分类")
    @RequestMapping(value = "/stationClassify", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<List<WaterQualityStation>> getStation(){
        List<WaterQualityStation> list = stationService.getWaterQualityStation();
        return CommonResult.success(list);
    }




    @ApiOperation("水文站点查询")
    @RequestMapping(value = "/hydrologyStationList",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<CommonPage<HydrologyStation>> getHydrologyStation(@RequestParam(value = "area", required = false) String area,
                                                                    @RequestParam(value = "stationName", required = false) String stationName,
                                                                    @RequestParam(value = "code", required = false) String code,
                                                                    @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                                    @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum){
        PageInfo<HydrologyStation> list = stationService.getHydrologyStation(area,stationName,code,pageSize,pageNum);
        if (list.getList().size() > 0){
            return CommonResult.success(CommonPage.restPage(list));
        }else{
            return CommonResult.failed("未找到站点");
        }
    }


    @ApiOperation("水文站点添加")
    @RequestMapping(value = "/hydrologyStationAdd", method = RequestMethod.POST)
    @ResponseBody
    public Object addHydrologyStation(@RequestBody Map<String, Object> map){
        Integer s= stationService.addHydrologyStation(map);
        if (s != null){
            return CommonResult.success("添加成功");
        }
        return CommonResult.failed();
    }

    @ApiOperation("水文站点删除")
    @DeleteMapping("/hydrologyStation/{ids}")
    @ResponseBody
    public Object deleteHydrologyStation(@PathVariable Integer[] ids){
        for (Integer id : ids){
            stationService.deleteHydrologyStation(id);
        }
        return CommonResult.success("删除成功");
    }
}
