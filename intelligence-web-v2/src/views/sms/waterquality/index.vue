
<template>
  <div class="app-container">
    <el-card class="operate-container" shadow="never">
      <i class="el-icon-tickets" style="margin-top: 5px"></i>
      <span style="margin-top: 5px">数据列表</span>
    </el-card>
    <el-card class="operate-container">
      <el-tag class="item">联网率 {{onLineRate}}</el-tag>
      <el-badge :value="onLineNum" class="item" >
        <el-button size="small" type="success">联网</el-button>
      </el-badge>
      <el-badge :value="offLineNum" class="item" >
        <el-button size="small" type="info">断线</el-button>
      </el-badge>
      <el-badge :value="1" class="item">
        <el-button size="small" type="warning">异常</el-button>
      </el-badge>
      <el-badge :value="2" class="item">
        <el-button size="small" type="danger">超标</el-button>
      </el-badge>
      <el-tag style="margin-top:10px;float: right;background-color: #fcb853">{{num}}s后刷新</el-tag>
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
        <el-table-column label="联网" align="center" width="100">
          <template slot-scope="scope">
            <el-button  v-if="scope.row.onLine == '1'" type="success" icon="el-icon-check" circle></el-button>
            <el-button  v-if="scope.row.onLine == '2'" type="info" icon="el-icon-close" circle></el-button>
          </template>
        </el-table-column>
        <el-table-column label="运行状态" align="center">
          <template slot-scope="scope">{{scope.row.runStatus | formatStatus}}</template>
        </el-table-column>
        <el-table-column label="流域" align="center">
          <template slot-scope="scope">{{scope.row.valleyName}}</template>
        </el-table-column>
        <el-table-column label="区域" align="center">
          <template slot-scope="scope">{{scope.row.regionName}}</template>
        </el-table-column>
        <el-table-column label="点位" align="center">
          <template slot-scope="scope"><el-button type="text" @click="dialogVisible = true">{{scope.row.siteName}}</el-button></template>
        </el-table-column>
        <el-table-column label="监测时间" width="160" align="center">
          <template slot-scope="scope">{{scope.row.captureTime}}</template>
        </el-table-column>
        <el-table-column label="高猛酸盐指数(mg/L)" width="100" align="center">
          <template slot-scope="scope">{{scope.row.gmsy}}</template>
        </el-table-column>
        <el-table-column label="总磷(mg/L)" width="100" align="center">
          <template slot-scope="scope">{{scope.row.zl }}</template>
        </el-table-column>
        <el-table-column label="氨氮(mg/L)" width="100" align="center">
          <template slot-scope="scope">{{scope.row.ad }}</template>
        </el-table-column>
        <el-table-column label="水温（℃)" width="100" align="center">
          <template slot-scope="scope">{{scope.row.sw }}</template>
        </el-table-column>
        <el-table-column label="PH(无量纲)" width="100" align="center">
          <template slot-scope="scope">{{scope.row.ph }}</template>
        </el-table-column>
        <el-table-column label="溶解氧(mg/L)" width="100" align="center">
          <template slot-scope="scope">{{scope.row.rjy }}</template>
        </el-table-column>
        <el-table-column label="氧化还原电位(mV)" width="100" align="center">
          <template slot-scope="scope">{{scope.row.yhhydw }}</template>
        </el-table-column>
      </el-table>
    </div>

  </div>
</template>

<script>
  import {fetchList} from '@/api/waterQuality'

  export default {
    name: "waterQualityRealData",
    data() {
      return {
        list: null,
        listLoading: true,
        offLineNum:null,
        onLineNum:null,
        onLineRate:null,
        num:60
      }
    },
    created() {
      this.getList();
    },
    watch: {
      $route(route) {
        this.getList();
      }
    },
    mounted(){
      let _this = this;
      this.timer = setInterval(() => {
        if(_this.num != 0){
          _this.num --;
        }
        if(_this.num == 0){
          _this.num = 60;
          _this.getList();
        }
      },1000);

    },
    beforeDestroy() {
      if (this.timer) {
        clearInterval(this.timer);
      }
    },

    filters:{
      formatStatus(flag){
        if(flag ==1){return "正常"}
        if(flag ==2){return "断线"}
        if(flag ==3){return "超标"}
      }
    },
    methods: {

      getList() {
        this.listLoading = true;
        fetchList().then(response => {
          this.listLoading = false;
          this.list = response.data.waterQualityInfoDtos;
          this.offLineNum = response.data.siteRunStatus.offLineNum;
          this.onLineNum = response.data.siteRunStatus.onLineNum;
          this.onLineRate = response.data.siteRunStatus.onLineRate;
        });
      }
    }
  }
</script>

<style>
  .item {
    margin-top: 10px;
    margin-right: 40px;
  }
</style>
