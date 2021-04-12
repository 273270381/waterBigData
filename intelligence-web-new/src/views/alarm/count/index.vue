<template>
  <el-row :gutter="12">
    <el-col :span="24">
      <el-card shadow="hover">
        <i class="el-icon-tickets"></i>
        <span>报警统计</span>
        <div style="margin-top: 20px">
          <el-card shadow = "hover">
            <a style="font-size: 12px; font-family:Arial; margin-left: 20px">区域</a>
            <span style="margin-left: 10px;">
              <el-select v-model="areaName" filterable clearable placeholder="全部" style="width: 120px">
                <el-option
                  v-for="item in options"
                  :key="item.value1"
                  :label="item.areaName"
                  :value="item.areaName">
                </el-option>
              </el-select>
            </span>

            <a style="font-size: 12px; font-family:Arial; margin-left: 20px">时间</a>
            <span style="margin-left: 10px;">
              <el-date-picker
                v-model="time"
                type="daterange"
                align="right"
                unlink-panels
                range-separator="至"
                start-placeholder="开始日期"
                end-placeholder="结束日期"
                :picker-options="pickerOptions">
              </el-date-picker>
            </span>

            <span style="float: right; margin-right: 10px">
              <el-button type="primary" @click.native="searchData">查询</el-button>
              <el-button type="primary">导出</el-button>
            </span>

          </el-card>
        </div>
        <div class="table-container">
          <el-table ref="adminTable"
                    :data="list"
                    style="width: 100%;"
                    v-loading="listLoading" border>
            <el-table-column label="" width="50" align="center">
              <template slot-scope="scope">{{scope.row.id}}</template>
            </el-table-column>
            <el-table-column label="区域/站点"  align="center">
              <template slot-scope="scope">{{scope.row.stationName}}</template>
            </el-table-column>
            <el-table-column label="数据报警"  align="center">
              <template slot-scope="scope">{{scope.row.deviceCount}}</template>
            </el-table-column>
            <el-table-column label="设备报警"  align="center">
              <template slot-scope="scope">{{scope.row.dataCount}}</template>
            </el-table-column>
            <el-table-column label="断线报警"  align="center">
              <template slot-scope="scope">{{scope.row.disconnectCount}}</template>
            </el-table-column>
            <el-table-column label="总报警数"  align="center">
              <template slot-scope="scope">{{scope.row.total }}</template>
            </el-table-column>
          </el-table>
        </div>
      </el-card>
    </el-col>
  </el-row>
</template>

<script>
  import {countList} from '@/api/waterQualityAlarm';
  import {formatDate} from '@/utils/date';

  const defaultListQuery = {

  };
  export default {
    data(){
      return{
        listQuery: Object.assign({}, defaultListQuery),
        list: null,
        total: null,
        listLoading: false,
        areaName:"",
        options: [{
          value1: '选项1',
          areaName: '宿城区'
        }, {
          value1: '选项2',
          areaName: '宿豫区'
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
        time: '',
        startTime:"",
        endTime:""
      }
    },
    created(){
      this.getCountList();
    },
    methods:{
      getCountList(){
        this.listLoading = true;
        countList(this.listQuery).then(response => {
          this.listLoading = false;
          this.list = response.data.list;
          this.total = response.data.total;
        })
      },
      searchData(){
        this.listQuery.areaName = this.areaName;
        if (this.time != null && this.time != ''){
          this.listQuery.startTime = formatDate(this.time[0],'yyyy-MM-dd');
          this.listQuery.endTime = formatDate(this.time[1],'yyyy-MM-dd');
        }else {
          this.listQuery.startTime = this.startTime;
          this.listQuery.endTime = this.endTime;
        }
        this.getCountList();
      }
    }
  }
</script>
