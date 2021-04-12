<template>
  <div class="app-container">
    <el-card shadow="hover">
      <i class="el-icon-tickets"></i>
      <span>报警统计</span>
      <div style="margin-top: 20px">
        <el-card shadow = "hover">
          <!--<a style="font-size: 12px; font-family:Arial; margin-left: 20px">区域</a>-->

          <el-radio-group v-model="radio" @change="searchData">
            <el-radio-button label="区域"></el-radio-button>
            <el-radio-button label="流域"></el-radio-button>
          </el-radio-group>

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
                  row-key="ids"
                  :indent = 16
                  :tree-props="{children: 'alarmCounts', hasChildren: 'hasChildren'}"
                  v-loading="listLoading" border>
          <el-table-column label=""  align="center" width="50px" type="">
            <template slot-scope="scope">{{scope.row.id}}</template>
          </el-table-column>
          <el-table-column label="区域/站点"  width="200px"  >
            <template slot-scope="scope">{{scope.row.areaName}}</template>
          </el-table-column>
          <el-table-column label="数据报警"  align="center" >
            <template slot-scope="scope">{{scope.row.deviceCount}}</template>
          </el-table-column>
          <el-table-column label="设备报警"  align="center" >
            <template slot-scope="scope">{{scope.row.dataCount}}</template>
          </el-table-column>
          <el-table-column label="断线报警"  align="center" >
            <template slot-scope="scope">{{scope.row.disconnectCount}}</template>
          </el-table-column>
          <el-table-column label="总报警数"  align="center" >
            <template slot-scope="scope">{{scope.row.total }}</template>
          </el-table-column>
        </el-table>
      </div>
    </el-card>
  </div>
</template>

<script src="./count.js"></script>
