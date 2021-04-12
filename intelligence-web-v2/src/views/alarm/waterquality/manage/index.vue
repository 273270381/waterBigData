<template>
  <el-card shadow="hover" class="basic-info">
    <i class="el-icon-tickets"></i>
    <span>报警管理</span>
    <div style="margin-top: 20px" >
      <a class="basic-info-a">报警类型</a>
      <span style="margin-left: 10px;">
              <el-select
                v-model="alarmType"
                filterable
                clearable
                placeholder="全部"
                style="width: 120px;"
                :popper-append-to-body="false"
                >
                <el-option
                  v-for="item in options"
                  :key="item.value1"
                  :label="item.alarmType"
                  :value="item.alarmType">
                </el-option>
              </el-select>
            </span>

      <a class="basic-info-a">站点</a>
      <span style="margin-left: 10px;">
              <el-select
                v-model="stationName"
                :popper-append-to-body="false"
                filterable
                clearable
                placeholder="全部"
                style="width: 200px;"
              >
                <el-option
                  v-for="item in options2"
                  :key="item.id"
                  :label="item.stationName"
                  :value="item.stationName">
                </el-option>
              </el-select>
            </span>

      <a class="basic-info-a">时间</a>
      <span style="margin-left: 10px;">
              <el-date-picker
                popper-class="basic-date"
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
      <span style="padding: 10px">
          <el-button class="basic-search"   size="small" type="primary" @click.native="searchData">查询</el-button>
        </span>
      <span style="float: right; margin-right: 10px;">
          <button type="button" class="btn print"></button>
          <button type="button" class="btn export"></button>
        <!--<el-button type="primary" @click.native="searchData">导出</el-button>-->
        <!--<el-button type="primary">打印</el-button>-->
        </span>
    </div>
    <div class="table-container">
      <el-table ref="adminTable"
                :data="list"
                style="width: 100%;"
                v-loading="listLoading" border>
        <el-table-column label="序号" width="80" align="center">
          <template slot-scope="scope">{{scope.row.id}}</template>
        </el-table-column>
        <el-table-column label="站名" width="150" align="center">
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
        popper-class="basic-pagination"
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
</template>
<script src="./manage.js"></script>
<style scoped>
  @import "../../../../styles/basicdeep.scss";
  .el-range-separator{
    width: 20px !important;
  }
</style>


