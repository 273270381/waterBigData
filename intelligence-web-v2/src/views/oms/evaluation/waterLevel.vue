
<template>
  <div class="app-container">
    <el-card class="filter-container" shadow="never">
      <div>
        <i class="el-icon-search"></i>
        <span>筛选搜索</span>
        <el-button
          style="float:right"
          type="primary"
          @click="handleSearchList()"
          size="small">
          查询
        </el-button>
        <el-button
          style="float:right;margin-right: 15px"
          @click="handleResetSearch()"
          size="small">
          重置
        </el-button>
      </div>
      <div style="margin-top: 15px">
        <el-form :inline="true" :model="listQuery" size="small" label-width="140px">
          <el-form-item label="区域：">
            <el-select v-model="listQuery.areaId" class="input-width" placeholder="全部" clearable>
              <el-option v-for="item in areas"
                         :key="item.id"
                         :label="item.name"
                         :value="item.id">
              </el-option>
            </el-select>
          </el-form-item>
          <el-form-item label="点位名称：">
            <el-select v-model="listQuery.stationId" class="input-width" placeholder="全部" clearable>
              <el-option v-for="item in stationOptions"
                         :key="item.id"
                         :label="item.name"
                         :value="item.id">
              </el-option>
            </el-select>
          </el-form-item>
          <el-form-item label="评价指标：">
            <el-select v-model="listQuery.indicatorId" class="input-width" placeholder="全部" clearable>
              <el-option v-for="item in indicators"
                         :key="item.id"
                         :label="item.name"
                         :value="item.id">
              </el-option>
            </el-select>
          </el-form-item>
         <br/>
          <el-form-item label="评价周期：">
            <el-select v-model="listQuery.period" class="input-width" placeholder="全部" clearable>
              <el-option v-for="item in periodOptions"
                         :key="item.id"
                         :label="item.name"
                         :value="item.id">
              </el-option>
            </el-select>
          </el-form-item>
          <el-form-item label="评价时间：">
            <el-date-picker
              v-model="listQuery.startTime"
              type="week"
              format="yyyy 第 WW 周"
              placeholder="选择周"
              >
            </el-date-picker>
          </el-form-item>
        </el-form>
      </div>
    </el-card>
    <el-card class="filter-container" shadow="never">
      <div>
        <el-tag style="color: #f2f6fc" color="#f56c6c">劣Ⅴ</el-tag><el-tag type="info">重度污染</el-tag>
        <el-tag style="float:left;color: #f2f6fc" color="#3a8ee6">Ⅰ</el-tag><el-tag style="float:left;margin-right: 15px" type="info">优</el-tag>
        <el-tag style="float:left;color: #f2f6fc" color="#66b1ff" >Ⅱ</el-tag><el-tag style="float:left;margin-right: 15px" type="info">优</el-tag>
        <el-tag style="float:left;color: #f2f6fc" color="#67c23a">Ⅲ</el-tag><el-tag style="float:left;margin-right: 15px" type="info">良好</el-tag>
        <el-tag style="float:left;color: #f2f6fc" color="#c9d245">Ⅳ</el-tag><el-tag style="float:left;margin-right: 15px" type="info">轻度污染</el-tag>
        <el-tag style="float:left;color: #f2f6fc" color="#e6a23c">Ⅴ</el-tag><el-tag style="float:left;margin-right: 15px" type="info">中度污染</el-tag>
      </div>
    </el-card>
    <el-card class="operate-container" shadow="never">
      <i class="el-icon-tickets" style="margin-top: 5px"></i>
      <span style="margin-top: 5px">数据列表</span>
    </el-card>
    <el-card class="operate-container" shadow="never">
      <div>
        <el-tag style="margin-left: 500px;font-size: 20px;">宿迁市{{this.weekNum}}周监测断面水质评价</el-tag>
      </div>

    </el-card>
    <div class="table-container">
      <el-table ref="waterLevelTable"
                style="width: 100%"
                :data="list"
                v-loading="listLoading" border>
        <el-table-column
          label="序号"
          type="index"
          show-overflow-tooltip
          width="60"
          align="center"
          fixed
        >
          <template slot-scope="scope">
            {{ scope.$index+1 }}
          </template>
        </el-table-column>
        <el-table-column label="区域" align="center">
          <template slot-scope="scope">{{scope.row.regionName}}</template>
        </el-table-column>
        <el-table-column label="点位名称" align="center">
          <template slot-scope="scope">{{scope.row.siteName}}</template>
        </el-table-column>
        <el-table-column label="高锰酸盐指数(mg/L)" align="center">
          <template slot-scope="scope">{{scope.row.gmsy }}</template>
        </el-table-column>
        <el-table-column label="总磷(mg/L)" align="center">
          <template slot-scope="scope">{{scope.row.zl }}</template>
        </el-table-column>
        <el-table-column label="氨氮(mg/L)" align="center">
          <template slot-scope="scope">{{scope.row.ad }}</template>
        </el-table-column>
        <el-table-column label="水温(℃)" align="center">
          <template slot-scope="scope">{{scope.row.sw }}</template>
        </el-table-column>
        <el-table-column label="PH(无量纲)" align="center">
          <template slot-scope="scope">{{scope.row.ph }}</template>
        </el-table-column>
        <el-table-column label="溶解氧(mg/L)" align="center">
          <template slot-scope="scope">{{scope.row.rjy }}</template>
        </el-table-column>
        <el-table-column label="氧化还原电位(mV)" align="center">
          <template slot-scope="scope">{{scope.row.rainValue }}</template>
        </el-table-column>
        <el-table-column label="水质类别" align="center">
          <template slot-scope="scope">{{scope.row.rainValue }}</template>
        </el-table-column>
        <el-table-column label="所属功能区" align="center">
          <template slot-scope="scope">{{scope.row.rainValue }}</template>
        </el-table-column>
        <el-table-column label="主要污染指数(超标倍数)" align="center">
          <template slot-scope="scope">{{scope.row.rainValue }}</template>
        </el-table-column>
      </el-table>
    </div>
  </div>
</template>

<script>
  import { listStation,waterQualityEvaluationList } from '@/api/waterQuality';
  import {getWeekFirst} from '@/utils/date';

  const defaultListQuery = {
    pageNum: 1,
    pageSize: 5,
    startTime:new Date("2021-01-17T16:00:00.000Z"),
    period: null,
    stationId: null,
    areaId:null,
    indicatorId:null
  };

  export default {
    name: "WaterLevel",
    data() {
      return {
        list: null,
        total: null,
        listLoading: true,
        stationOptions: [],
        areas:[],
        indicators:[],
        weekNum:null,
        periodOptions:[{
          id: '1',
          name: '年'
        }, {
          id: '2',
          name: '周'
        }],
        listQuery: Object.assign({}, defaultListQuery)
      }
    },
    created() {
      listStation().then(res =>{
        this.stationOptions = res.data.list
      });
      this.listQuery.period =this.periodOptions[1].id;
      this.getList();
    },
    watch: {
      $route(route) {
        this.getList();
      }
    },
    methods: {

      getList() {
        this.listLoading = true;
        waterQualityEvaluationList(this.listQuery).then(response => {
          this.listLoading = false;
          this.list = response.data.waterQualityInfoDtoList;
          this.weekNum = response.data.weekNum;
          this.total = response.data.total;
        });
      },
      handleSizeChange(val) {
        this.listQuery.pageNum = 1;
        this.listQuery.pageSize = val;
        this.getList();
      },
      handleResetSearch() {
        this.listQuery = Object.assign({}, defaultListQuery);
        this.listQuery.period =this.periodOptions[1].id;
      },
      handleCurrentChange(val) {
        this.listQuery.pageNum = val;
        this.getList();
      },
      handleSearchList(){
        this.getList();
      }
    }
  }
</script>

