



<template> 
  <div class="app-container">

    <el-card class="filter-container" shadow="never">
      <div>

        <!--
                type="primary"
        -->

        <el-button
          style="float:right"
          @click="handleSearchList()"
          size="small">
          打印
        </el-button>
        <el-button
          style="float:right;margin-right: 15px"
          @click="handleResetSearch()"
          size="small">
          导出
        </el-button>
      </div>


      <el-row :gutter="5">
        <el-col :span="10"><!--
          <span class="inputTitle" style="margin-left: 12px;">站点:</span>

          <el-input v-model="listQuery.name" class="searchInput" @keyup.native="btKeyUp" placeholder="请输入姓名" />-->
          <el-select v-model="listQuery.stationId" filterable placeholder="请选择" @change="changeOption">
            <el-option
              v-for="item in stations"
              :key="item.stationId"
              :label="item.stationName"
              :value="item.stationId">
            </el-option>
          </el-select>

          <span class="demonstration">时间： </span>
          <!-- <el-date-picker

            v-model="listQuery.date"
             type="year"
             placeholder="选择年"
             format="yyyy"
            value-format="yyyy"

           >
           </el-date-picker>-->


          <el-date-picker
            v-model="listQuery.date"
            value-format="yyyy"
            type="year"
            placeholder="选择年">
          </el-date-picker>

          <el-button   icon="el-icon-search" @click.native="search" style="margin-left: 12px;background: #E6E6FA">查询</el-button>
        </el-col>
      </el-row>


      <!--<div style="margin-top: 15px">
        <el-form :inline="true" :model="listQuery" size="small" label-width="140px">
          <el-form-item label="输入搜索：">
            <el-input v-model="listQuery.keyword" class="input-width" placeholder="帐号/姓名" clearable></el-input>
          </el-form-item>
        </el-form>
      </div>-->
    </el-card>
    <div style="text-align:center;">{{this.stationname}}雨量月报表</div>

    <div class="table-container">
      <el-table ref="adminTable"
                :data="list"
                :row-class-name="tableRowClass" :header-cell-style="headeRowClass"
                style="width: 100%;"
                v-loading="listLoading" border>
        <el-table-column label="时间" width="100" align="center">
          <template slot-scope="scope">{{scope.row.waterLevelMonth.date}}</template>
        </el-table-column>
        <el-table-column label="1日" align="center">
          <template slot-scope="scope">{{scope.row.waterLevelMonth.one}}</template>
        </el-table-column>
        <el-table-column label="2日" align="center">
          <template slot-scope="scope">{{scope.row.waterLevelMonth.two}}</template>
        </el-table-column>
        <el-table-column label="3日" align="center">
          <template slot-scope="scope">{{scope.row.waterLevelMonth.three}}</template>
        </el-table-column>
        <el-table-column label="4日" align="center">
          <template slot-scope="scope">{{scope.row.waterLevelMonth.four}}</template>
        </el-table-column>
        <el-table-column label="5日" align="center">
          <template slot-scope="scope">{{scope.row.waterLevelMonth.five}}</template>
        </el-table-column>
        <el-table-column label="6日" align="center">
          <template slot-scope="scope">{{scope.row.waterLevelMonth.six}}</template>
        </el-table-column>
        <el-table-column label="7日" align="center">
          <template slot-scope="scope">{{scope.row.waterLevelMonth.seven}}</template>
        </el-table-column>
        <el-table-column label="8日" align="center">
          <template slot-scope="scope">{{scope.row.waterLevelMonth.eight}}</template>
        </el-table-column>
        <el-table-column label="9日" align="center">
          <template slot-scope="scope">{{scope.row.waterLevelMonth.nine}}</template>
        </el-table-column>
        <el-table-column label="10日" align="center">
          <template slot-scope="scope">{{scope.row.waterLevelMonth.ten}}</template>
        </el-table-column>
        <el-table-column label="11日" align="center">
          <template slot-scope="scope">{{scope.row.waterLevelMonth.eleven}}</template>
        </el-table-column>
        <el-table-column label="12日" align="center">
          <template slot-scope="scope">{{scope.row.waterLevelMonth.twelve}}</template>
        </el-table-column>
        <el-table-column label="13日" align="center">
          <template slot-scope="scope">{{scope.row.waterLevelMonth.thirteen}}</template>
        </el-table-column>
        <el-table-column label="14日" align="center">
          <template slot-scope="scope">{{scope.row.waterLevelMonth.fourteen}}</template>
        </el-table-column>
        <el-table-column label="15日" align="center">
          <template slot-scope="scope">{{scope.row.waterLevelMonth.fifteen}}</template>
        </el-table-column>
        <el-table-column label="16日" align="center">
          <template slot-scope="scope">{{scope.row.waterLevelMonth.sixteen}}</template>
        </el-table-column>
        <el-table-column label="17日" align="center">
          <template slot-scope="scope">{{scope.row.waterLevelMonth.seventeen}}</template>
        </el-table-column>
        <el-table-column label="18日" align="center">
          <template slot-scope="scope">{{scope.row.waterLevelMonth.eighteen}}</template>
        </el-table-column>
        <el-table-column label="19日" align="center">
          <template slot-scope="scope">{{scope.row.waterLevelMonth.nineteen}}</template>
        </el-table-column>
        <el-table-column label="20日" align="center">
          <template slot-scope="scope">{{scope.row.waterLevelMonth.twenty}}</template>
        </el-table-column>
        <el-table-column label="21日" align="center">
          <template slot-scope="scope">{{scope.row.waterLevelMonth.twentyOne}}</template>
        </el-table-column>
        <el-table-column label="22日" align="center">
          <template slot-scope="scope">{{scope.row.waterLevelMonth.twentyTwo}}</template>
        </el-table-column>
        <el-table-column label="23日" align="center">
          <template slot-scope="scope">{{scope.row.waterLevelMonth.twentyThree}}</template>
        </el-table-column>
        <el-table-column label="24日" align="center">
          <template slot-scope="scope">{{scope.row.waterLevelMonth.twentyFour}}</template>
        </el-table-column>
        <el-table-column label="25日" align="center">
          <template slot-scope="scope">{{scope.row.waterLevelMonth.twentyFive}}</template>
        </el-table-column>
        <el-table-column label="26日" align="center">
          <template slot-scope="scope">{{scope.row.waterLevelMonth.twentySix}}</template>
        </el-table-column>
        <el-table-column label="27日" align="center">
          <template slot-scope="scope">{{scope.row.waterLevelMonth.twentySeven}}</template>
        </el-table-column>
        <el-table-column label="28日" align="center">
          <template slot-scope="scope">{{scope.row.waterLevelMonth.twentyEight}}</template>
        </el-table-column>
        <el-table-column label="29日" align="center">
          <template slot-scope="scope">{{scope.row.waterLevelMonth.twentyNine}}</template>
        </el-table-column>
        <el-table-column label="30日" align="center">
          <template slot-scope="scope">{{scope.row.waterLevelMonth.thirty}}</template>
        </el-table-column>
        <el-table-column label="31日" align="center">
          <template slot-scope="scope">{{scope.row.waterLevelMonth.thirtyOne}}</template>
        </el-table-column>



        <el-table-column label="最大值" align="center">
          <template slot-scope="scope">{{scope.row.max}}</template>
        </el-table-column>
        <el-table-column label="最大发生时间" align="center">
          <template slot-scope="scope">{{scope.row.maxTime}}</template>
        </el-table-column>
        <el-table-column label="最小值" align="center">
          <template slot-scope="scope">{{scope.row.min}}</template>
        </el-table-column>
        <el-table-column label="最小发生时间" align="center">
          <template slot-scope="scope">{{scope.row.minTime}}</template>
        </el-table-column>
        <el-table-column label="平均值" align="center">
          <template slot-scope="scope">{{scope.row.average}}</template>
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
        :page-sizes="[50]"
        :total="total">
      </el-pagination>
    </div>


  </div>
</template>
<script>
  import {fetchMonthList,createAdmin,updateAdmin,updateStatus,deleteAdmin,getRoleByAdmin,allocRole,fetchStationList} from '@/api/report.js';
  import {fetchAllRoleList} from '@/api/role';
  import {formatDate} from '@/utils/date';

  const defaultListQuery = {
    pageNum: 1,
    pageSize: 50,
    stationId: null,
    date:''
  };
  const defaultAdmin = {
    waterLevelMonth:null,
    id: null,
    username: null,
    password: null,
    nickName: null,
    email: null,
    note: null,
    status: 1
  };
  export default {
    name: 'rainLevelDay',
    data() {
      return {
        value3: '',
        stations: [],
        stationname:'',
        obj:{},

        listQuery: Object.assign({}, defaultListQuery),
        list: null,
        total: null,
        listLoading: false,
        dialogVisible: false,
        admin: Object.assign({}, defaultAdmin),
        isEdit: false,
        allocDialogVisible: false,
        allocRoleIds:[],
        allRoleList:[],
        allocAdminId:null
      }
    },
    created() {
      this.initDate({});
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
    methods: {
      handleResetSearch() {
        this.listQuery = Object.assign({}, defaultListQuery);
      },
      handleSearchList() {
        this.listQuery.pageNum = 1;
        this.getList();
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



      getList() {
        this.listLoading = true;
        fetchMonthList(this.listQuery).then(response => {
          this.listLoading = false;
          this.list = response.data.list;
          this.total = response.data.total;
        });
      },

      getStationList(){


        this.listLoading = true;
        fetchStationList().then(response => {
          this.listLoading = false;
          this.stations = response.data.list;
          this.listQuery.stationId=this.stations[0].stationId;
          this.stationname=this.stations[0].stationName;

          this.getList();


        });
      },


      tableRowClass({row,rowIndex}){
        //表格的行背景隔行变色
        if((rowIndex+1)%2==0){

          return 'success-row'

        }else{
          return
        }
        return 'warning-row'
      },
      headeRowClass({row, column, rowIndex, columnIndex}){
        //表头的背景颜色
        if(rowIndex==0){
          return 'background:#B0C4DE;color:#000000;height:0px;padding:0px'
        }
      },

      async initDate(data){

        var now=new Date();
        var month=now.getMonth()+1;
        var yaern=now.getFullYear();
        if(month < 10){
          month = "0" + month;
        }

        this.listQuery.date=yaern.toString();

      },
      isEmpty(obj){
        if(typeof obj == "undefined" || obj == null || obj == ""){
          return true;
        }else{
          return false;
        }
      }
      ,
      search() {
        this.listQuery.page = 1
        if(!this.isEmpty(this.obj.stationName)){
          this.stationname=this.obj.stationName;

        }

        this.getList()
      },
      changeOption() {
        this.obj = this.stations.find(
          item => {
            return item.stationId === this.listQuery.stationId//筛选出对应数据
          }
        )

      },


    },

  }
</script>

<style >
  .el-table  {
    font-size: 10px;

  }
  .el-table td, .el-table th{
    padding: 0 0;
  }
  .el-table .warning-row {
    background: #f7faff;
  }
  .el-table .success-row {
    background: #E6E6FA;
  }
  .inputTitle{
    margin-right: 8px;
    color: #777777;
  }
  .searchInput{
    width: 200px;
  }

</style>
