<template>
  <el-row :gutter="12">
    <el-col :span="24">
      <el-card shadow="hover">
        <i class="el-icon-tickets"></i>
        <span>报警管理</span>
        <div style="margin-top: 20px">
          <el-card shadow = "hover">
            <a style="font-size: 12px; font-family:Arial; margin-left: 20px">报警类型</a>
            <span style="margin-left: 10px;">
              <el-select v-model="alarmType" filterable clearable placeholder="全部" style="width: 120px">
                <el-option
                  v-for="item in options"
                  :key="item.value1"
                  :label="item.alarmType"
                  :value="item.alarmType">
                </el-option>
              </el-select>
            </span>

            <a style="font-size: 12px; font-family:Arial; margin-left: 20px">站点</a>
            <span style="margin-left: 10px;">
              <el-select v-model="stationName" filterable clearable placeholder="全部" style="width: 200px">
                <el-option
                  v-for="item in options2"
                  :key="item.stationId"
                  :label="item.stationName"
                  :value="item.stationName">
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
            <el-table-column label="站点" width="150" align="center">
              <template slot-scope="scope">{{scope.row.stationName}}</template>
            </el-table-column>
            <el-table-column label="监测项目/设备" width="150" align="center">
              <template slot-scope="scope">{{scope.row.device}}</template>
            </el-table-column>
            <el-table-column label="报警时间" width="160" align="center">
              <template slot-scope="scope">{{scope.row.alarmTime | formatDateTime}}</template>
            </el-table-column>
            <el-table-column label="报警类型" width="100" align="center">
              <template slot-scope="scope">{{scope.row.alarmType }}</template>
            </el-table-column>
            <el-table-column label="报警描述" align="center">
              <template slot-scope="scope">{{scope.row.description}}</template>
            </el-table-column>
          </el-table>
        </div>
        <div class="pagination-container">
          <el-pagination
            background
            @size-change="handleSizeChange"
            @current-change="handleCurrentChange"
            layout="total, sizes,prev, pager, next,jumper"
            :current-page.sync="listQuery.pageNum"
            :page-size="listQuery.pageSize"
            :page-sizes="[10,15,20]"
            :total="total">
          </el-pagination>
        </div>
      </el-card>
    </el-col>
  </el-row>
</template>

<script>
  import {formatDate} from '@/utils/date';
  import {fetchList,stationList} from '@/api/waterQualityAlarm';

  const defaultListQuery = {
    pageSize: 10,
    pageNum: 1,
  };
  const defaultParams = {
    area:"宿城区"
  };
  export default {
    data(){
      return{
        listQuery: Object.assign({}, defaultListQuery),
        stationParam:Object.assign({},defaultParams),
        list: null,
        total: null,
        listLoading: false,
        options: [{
          value1: '选项1',
          alarmType: '数据报警'
        }, {
          value1: '选项2',
          alarmType: '设备报警'
        }, {
          value1: '选项3',
          alarmType: '断线报警'
        }],
        options2:null,
        stationName: '',

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
        alarmType:'',
        time: '',
        startTime:"",
        endTime:"",
      }
    },
    created(){
      this.getList();
      this.getStationList();
    },
    filters: {
      formatDateTime(time) {
        if (time == null || time === '') {
          return 'N/A';
        }
        let date = new Date(time);
        return formatDate(date, 'yyyy-MM-dd hh:mm:ss')
      }
    },
    methods:{
      getList() {
        this.listLoading = true;
        fetchList(this.listQuery).then(response => {
          this.listLoading = false;
          this.list = response.data.list;
          this.total = response.data.total;
        });
      },
      searchData(){
        this.listQuery.stationName = this.stationName;
        this.listQuery.alarmType = this.alarmType;
        if (this.time != null && this.time != ''){
          this.listQuery.startTime = formatDate(this.time[0],'yyyy-MM-dd');
          this.listQuery.endTime = formatDate(this.time[1],'yyyy-MM-dd');
        }else {
          this.listQuery.startTime = this.startTime;
          this.listQuery.endTime = this.endTime;
        }
        this.getList();
      },
      getStationList(){
        stationList(this.stationParam).then(response =>{
          this.options2 = response.data;
          console.log(this.options2);
        })
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
    }
  }
</script>
<style>
  .el-range-separator{
    width: 20px !important;
  }
</style>

