



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
          <span class="demonstration">区域： </span>

          <el-select v-model="listQuery.areaId" filterable placeholder="请选择" @change="changeOption" >
            <el-option
              v-for="(item,index) in areas"
              :key="index"
              :label="item.areaName"
              :value="item.areaId">
            </el-option>
          </el-select>

          <el-date-picker
            v-model="listQuery.date"
            type="week"
            format="yyyy 第 WW 周"
            placeholder="选择周"
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

    <div style="text-align:center;">{{this.areaName}}周报表</div>

    <div style="">   日期：{{ this.startTime}}~{{ this.endTime}}</div>


    <div class="table-container">
      <el-table ref="adminTable"
                :data="list"
                :row-class-name="tableRowClass" :header-cell-style="headeRowClass"
                style="width: 100%;"
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

        <el-table-column label="流域/湖库" width="150" align="center">
          <template slot-scope="scope">{{scope.row.waterArea}}</template>
        </el-table-column>

        <el-table-column label="断面名称" width="150" align="center">
          <template slot-scope="scope">
            <span v-if="scope.row.siteName==null">--</span>
            <span v-else> {{scope.row.siteName}}
            </span>
         </template>
        </el-table-column>

        <el-table-column label="断面属性" align="center">
          <template slot-scope="scope">
            <span v-if="scope.row.stationType==null">--</span>
            <span v-else> {{scope.row.stationType}}
            </span>
          </template>
        </el-table-column>
        <el-table-column label="高锰酸钾指数(mg/L)" align="center">
          <template slot-scope="scope">
            <span v-if="scope.row.gmsy==null">--</span>
            <span v-else> {{scope.row.gmsy}}
            </span>
          </template>
        </el-table-column>
        <el-table-column label="氨氮(mg/L)" align="center">
          <template slot-scope="scope">
            <span v-if="scope.row.ad==null">--</span>
            <span v-else> {{scope.row.ad}}
            </span>
          </template>
        </el-table-column>
        <el-table-column label="PH(无量纲)" align="center">
          <template slot-scope="scope">
            <span v-if="scope.row.ph==null">--</span>
            <span v-else> {{scope.row.ph}}
            </span>
       </template>
        </el-table-column>
        <el-table-column label="本周水质" align="center">
          <template slot-scope="scope">
            <span v-if="scope.row.w01001Rtd==null">--</span>
            <span v-else> {{scope.row.w01001Rtd}}
            </span>
           </template>
        </el-table-column>
        <el-table-column label="上周水质" align="center">
          <template slot-scope="scope">
            <span v-if="scope.row.w01009Rtd==null">--</span>
            <span v-else> {{scope.row.w01009Rtd}}
            </span>
       </template>
        </el-table-column>
        <el-table-column label="功能区类型" align="center">
          <template slot-scope="scope">
            <span v-if="scope.row.w01009Rtd==null">--</span>
            <span v-else> {{scope.row.w01009Rtd}}
            </span>
       </template>
        </el-table-column>
        <el-table-column label="主要污染物" align="center">
          <template slot-scope="scope">
            <span v-if="scope.row.w01009Rtd==null">--</span>
            <span v-else> {{scope.row.w01009Rtd}}
            </span>
        </template>
        </el-table-column>



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
  import {fetchWeekList,createAdmin,updateAdmin,updateStatus,deleteAdmin,getRoleByAdmin,allocRole,fetchStationList} from '@/api/waterQualityCom.js';
  import {fetchAllRoleList} from '@/api/role';
  import {getWeekDay,parse} from '@/utils/date';

  const defaultListQuery = {
    pageNum: 1,
    pageSize: 50,
    areaId: '',
    date:''
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

        startTime:null,
        endTime:null,
        obj:{},
        loginfo: {
          'dateList': ['06-01','06-02','06-03','06-04']
        },
        areas: [],
        stationname:'',
        areaName:'',
        listQuery: Object.assign({}, defaultListQuery),
        list:[],
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
        return getWeekDay(time)
      },

      parse(time){
        return parse(time);
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
        fetchWeekList(this.listQuery).then(response => {
          this.listLoading = false;



            this.list = response.data;

          if(!this.isEmpty(this.list)){

            this.startTime= this.list[0].startDate;
            this.endTime= this.list[0].endDate;
          }


        });
      },

      getStationList(){


        this.listLoading = true;
        fetchStationList().then(response => {
          this.listLoading = false;
          this.areas = response.data.list;
          //this.listQuery.areaId=this.stations[0].areaId;
         // this.areaName=this.stations[0].areaName;
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
        //this.listQuery.date=now;
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


        if(!this.isEmpty(this.obj.areaName)){


          this.areaName=this.obj.areaName;
        }

        this.getList()
      },


      changeOption() {
        this.obj = this.areas.find(
          item => {
            return item.areaId === this.listQuery.areaId//筛选出对应数据
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
  .el-table__body-wrapper .is-scrolling-none{

    height: 0px;
  }
  .el-table__empty-block{
    min-height: 0px;
  }
</style>
