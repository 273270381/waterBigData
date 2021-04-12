
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
      </div>
      <div style="margin-top: 15px">
        <el-form :inline="true" :model="listQuery" size="small" label-width="140px">
          <el-form-item label="点位名称：">
            <el-select v-model="listQuery.stationId" class="input-width" placeholder="全部" clearable>
              <el-option v-for="item in stationOptions"
                         :key="item.id"
                         :label="item.name"
                         :value="item.id">
              </el-option>
            </el-select>
          </el-form-item>
          <el-form-item label="评价周期：">
            <el-select v-model="listQuery.period" class="input-width" placeholder="全部" clearable>
              <el-option v-for="item in periodOptions"
                         :key="item.id"
                         :label="item.name"
                         :value="item.id">
              </el-option>
            </el-select>
          </el-form-item>
          <el-form-item label="时间范围：">
            <el-date-picker
              v-model="this.time"
              type="daterange"
              align="right"
              unlink-panels
              range-separator="至"
              start-placeholder="开始日期"
              end-placeholder="结束日期"
              value-format="yyyy-MM-dd"
              :picker-options="pickerOptions">
            </el-date-picker>
          </el-form-item>
        </el-form>
      </div>
    </el-card>
    <el-card class="operate-container" shadow="never">
      <el-tag type="danger">站点名称:</el-tag><el-tag>{{siteName}}</el-tag>
      <el-tag style="margin-left: 15px" type="danger">所属区域:</el-tag><el-tag>{{regionName}}</el-tag>
      <el-tag style="margin-left: 15px" type="danger">所属河流/湖库:</el-tag><el-tag>{{valleyName}}</el-tag>
    </el-card>
    <el-card class="operate-container" shadow="never">
      <i class="el-icon-tickets" style="margin-top: 5px"></i>
      <span style="margin-top: 5px">数据列表</span>
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
          <template slot-scope="scope">{{scope.row.yfhydw }}</template>
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

  export default {
    name: "RainFall",
    data() {
      return {
        list: null,
        total: null,
        listLoading: true,
        valleyName:null,
        regionName:null,
        siteName:null,
        stationOptions:[],
        time:[],
        periodOptions:[{
          id: '1',
          name: '年'
        }, {
          id: '2',
          name: '周'
        }, {
          id: '3',
          name: '日'
        }],
        pickerOptions: {
          shortcuts: [{
            text: '最近一周',
            onClick(picker) {
              const end = new Date();
              const start = new Date();
              start.setTime(start.getTime() - 3600 * 1000 * 24 * 7);
              picker.$emit('pick', [start, end]);
            }
          }, {
            text: '最近一个月',
            onClick(picker) {
              const end = new Date();
              const start = new Date();
              start.setTime(start.getTime() - 3600 * 1000 * 24 * 30);
              picker.$emit('pick', [start, end]);
            }
          }, {
            text: '最近三个月',
            onClick(picker) {
              const end = new Date();
              const start = new Date();
              start.setTime(start.getTime() - 3600 * 1000 * 24 * 90);
              picker.$emit('pick', [start, end]);
            }
          }]
        },
        listQuery: {
          startTime:null,
          endTime:null,
          stationId:null,
          period:null
        }
      }
    },
    created() {
      listStation().then(res =>{
        this.stationOptions = res.data.list
        this.listQuery.stationId = this.stationOptions[1].id;
        this.listQuery.period =this.periodOptions[2].id;
        this.getList();
      });

      this.listQuery.startTime = this.handleTimeOld(new Date());
      this.listQuery.endTime = this.handleTimeNew(new Date());
      this.time.push(this.listQuery.startTime)
      this.time.push(this.listQuery.endTime)


    },
    watch: {
      $route(route) {
        this.getList();
      }
    },
    methods: {
      handleTimeOld (time, split) {  //是我用来获取当月的第一天的
        let date = new Date(time)
        let year = date.getFullYear()
        let month = date.getMonth() + 1
        split = '-'
        return [year, month, 1].map(num => this.formatNumber(num)).join(split)
      },
      handleTimeNew (time) { //handleTimeNew是获取今天的日期
        let date = new Date(time)
        let year = date.getFullYear()
        let month = (date.getMonth() + 1) > 10 ? (date.getMonth() + 1) : ('0' + (date.getMonth() + 1))
        let day = date.getDate() > 10 ? date.getDate() : ('0' + date.getDate())
        return `${year}-${month}-${day}`
      },
      formatNumber(number) {
        return String(number)[1] ? String(number) : `0${number}`
      },
      getList() {
        this.listLoading = true;
        waterQualityEvaluationList( this.listQuery).then(response => {
          this.listLoading = false;
          this.regionName = response.data.areaName;
          this.siteName = response.data.siteName;
          this.valleyName = response.data.valleyName;
          this.list = response.data.waterQualityInfoDtoList;
          this.total = response.data.total;
        });
      },
      handleSizeChange(val) {
        this.listQuery.pageNum = 1;
        this.listQuery.pageSize = val;
        this.getList();
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

