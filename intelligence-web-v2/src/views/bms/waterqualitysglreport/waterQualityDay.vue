



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
          <span class="demonstration">站点： </span>

          <el-select v-model="listQuery.siteId" filterable placeholder="请选择" @change="changeOption" >
            <el-option
              v-for="(item,index) in stations"
              :key="index"
              :label="item.stationName"
              :value="item.ids">
            </el-option>
          </el-select>

          <span class="demonstration">时间： </span>
          <el-date-picker
            v-model="listQuery.date"
            type="date"
            placeholder="选择日期"
            value-format="yyyy-MM-dd"
          >
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

    <div style="text-align:center;">{{this.stationname}}日报表</div>

    <div style="">自动站名称：{{this.stationname}}    所在区域：{{this.areaName}}   日期：{{ this.listQuery.date}}</div>


    <div class="table-container">
      <el-table ref="adminTable"
                :data="list"
                :row-class-name="tableRowClass" :header-cell-style="headeRowClass"
                style="width: 100%;"
                v-loading="listLoading" border>
        <el-table-column label="时间" width="150" align="center">
          <template slot-scope="scope">{{scope.row.dateTime}}</template>
        </el-table-column>


        <el-table-column label="高锰酸盐指数(mg/L)" align="center">
          <template slot-scope="scope">{{scope.row.w01019Rtd}}</template>
        </el-table-column>
        <el-table-column label="总磷(mg/L)" align="center">
          <template slot-scope="scope">{{scope.row.w21011Rtd}}</template>
        </el-table-column>
        <el-table-column label="氨氮(mg/L)" align="center">
          <template slot-scope="scope">{{scope.row.w21003Rtd}}</template>
        </el-table-column>
        <el-table-column label="水温(℃)" align="center">
          <template slot-scope="scope">{{scope.row.w01010Rtd}}</template>
        </el-table-column>
        <el-table-column label="ph值(无量纲)" align="center">
          <template slot-scope="scope">{{scope.row.w01001Rtd}}</template>
        </el-table-column>
        <el-table-column label="溶解氧(mg/L)" align="center">
          <template slot-scope="scope">{{scope.row.w01009Rtd}}</template>
        </el-table-column>




      </el-table>

      <el-table
      border
      style="width: 100%"
      >
        <template slot="empty" style="height: 0px">
          <span  style="height: 0px"> </span>
        </template>
      <el-table-column
        width="150"
        align="center"
        label="样本数"
        fixed
      >
      </el-table-column>
      <template v-for='(col,i) in math.count'>
        <el-table-column
          :show-overflow-tooltip="true"
          :label="col+''"
          align="center"
        >

        </el-table-column>
      </template>
    </el-table>


      <el-table
        border
        style="width: 100%">
        <el-table-column
          width="150"
          align="center"
          label="最小值"
          fixed
        >
        </el-table-column>
        <template v-for='(col,i) in math.min'>
          <el-table-column
            :show-overflow-tooltip="true"
            :label="col+''"
            align="center"
          >

          </el-table-column>
        </template>
      </el-table>


      <el-table
        border
        style="width: 100%">
        <el-table-column
          width="150"
          align="center"
          label="最大值"
          fixed
        >
        </el-table-column>
        <template v-for='(col,i) in math.max'>
          <el-table-column
            :show-overflow-tooltip="true"
            :label="col+''"
            align="center"
          >

          </el-table-column>
        </template>
      </el-table>


      <el-table
        border
        style="width: 100%">
        <el-table-column
          width="150"
          align="center"
          label="平均值"
          fixed
        >
        </el-table-column>
        <template v-for='(col,i) in math.avg'>
          <el-table-column
            :show-overflow-tooltip="true"
            :label="col+''"
            align="center"
          >

          </el-table-column>
        </template>
      </el-table>
    </div>
  <!--  <div class="pagination-container">
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
-->

  </div>
</template>
<script>
  import {fetchList,createAdmin,updateAdmin,updateStatus,deleteAdmin,getRoleByAdmin,allocRole,fetchStationList} from '@/api/waterQualityReport.js';
  import {fetchAllRoleList} from '@/api/role';
  import {formatDate} from '@/utils/date';

  const defaultListQuery = {
    pageNum: 1,
    pageSize: 50,
    siteId: 1,
    date:null
  };
  const defaultAdmin = {
    waterLevelDay:null,
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
        obj:{},
        stations: [],
        stationname:'',
        areaName:'',
        listQuery: Object.assign({}, defaultListQuery),
       list:null,
        math:{},
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
        fetchList(this.listQuery).then(response => {
          this.listLoading = false;
         this.list = response.data.waterQualityDataDays;
        //  console.log(this.list+'==')
          this.math=response.data.waterQualityDayBeanDto;

        });
      },

      getStationList(){


        this.listLoading = true;
        fetchStationList().then(response => {
          this.listLoading = false;
          this.stations = response.data.list;
          this.listQuery.siteId=this.stations[0].ids;
          this.stationname=this.stations[0].stationName;
          this.areaName=this.stations[0].areaName;
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
       var day=now.getDate();
        this.listQuery.date=yaern+"-"+month+'-'+day;
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
            this.areaName=this.obj.areaName;
        }
        this.getList()
      },


      changeOption() {
        this.obj = this.stations.find(
          item => {


            return item.ids === this.listQuery.siteId//筛选出对应数据
          }
        )


      },


    },

  }
</script>

<style  >
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
   .el-table__body-wrapper .is-scrolling-none{

  height: 0px;
}
  .el-table__empty-block{
    min-height: 0px;
  }
</style>
