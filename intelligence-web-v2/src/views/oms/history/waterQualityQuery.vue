
<template>
  <div class="app-container">
    <el-card class="filter-container" shadow="never">
      <div>
        <i class="el-icon-search"></i>
        <span>筛选搜索</span>
        <el-button
          style="float:right"
          type="primary"
          icon="el-icon-search"
          @click="handleSearchList()"
          size="small">
          查询
        </el-button>
        <el-button
          style="float:right;margin-right: 15px"
          @click="handleResetSearch()"
          type="primary"
          icon="el-icon-refresh"
          size="small">
          重置
        </el-button>
        <el-button
          style="float:right;margin-right: 15px"
          @click="handleResetSearch()"
          icon="el-icon-download"
          type="primary"
          size="small">
          导出
        </el-button>
      </div>
      <div style="margin-top: 15px">
        <el-form :inline="true" :model="listQuery" size="small" label-width="140px">
          <el-form-item label="站点：">
            <el-select v-model="listQuery.id" class="input-width" placeholder="全部" clearable>
              <el-option v-for="item in stationOptions"
                         :key="item.id"
                         :label="item.name"
                         :value="item.id">
              </el-option>
            </el-select>
          </el-form-item>
          <el-form-item label="开始时间：">
            <el-date-picker
              class="input-width"
              v-model="listQuery.startTime"
              value-format="yyyy-MM-dd HH:mm:ss"
              type="datetime"
              placeholder="请选择时间">
            </el-date-picker>
          </el-form-item>
          <el-form-item label="结束时间：">
            <el-date-picker
              class="input-width"
              v-model="listQuery.endTime"
              value-format="yyyy-MM-dd HH:mm:ss"
              type="datetime"
              placeholder="请选择时间">
            </el-date-picker>
          </el-form-item>
        </el-form>
      </div>
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
        <el-table-column label="监测时间"  align="center">
          <template slot-scope="scope">{{scope.row.dateTime | formatCreateTime}}</template>
        </el-table-column>
        <el-table-column label="高猛酸盐指数(mg/L)"  align="center">
          <template slot-scope="scope">{{scope.row.w01001Rtd}}</template>
        </el-table-column>
        <el-table-column label="总磷(mg/L)"  align="center">
          <template slot-scope="scope">{{scope.row.w01009Rtd }}</template>
        </el-table-column>
        <el-table-column label="氨氮(mg/L)"  align="center">
          <template slot-scope="scope">{{scope.row.w01010Rtd }}</template>
        </el-table-column>
        <el-table-column label="水温(℃)"  align="center">
          <template slot-scope="scope">{{scope.row.w01019Rtd }}</template>
        </el-table-column>
        <el-table-column label="PH(无量纲)"  align="center">
          <template slot-scope="scope">{{scope.row.w21003Rtd }}</template>
        </el-table-column>
        <el-table-column label="溶解氧(mg/L)"  align="center">
          <template slot-scope="scope">{{scope.row.w21011Rtd }}</template>
        </el-table-column>
        <el-table-column label="氧化还原电位(mV)"  align="center">
          <template slot-scope="scope">{{scope.row.yhhydw }}</template>
        </el-table-column>

      </el-table>
    </div>
    <div class="pagination-container">
      <el-pagination
        background
        @size-change="handleSizeChange"
        @current-change="handleCurrentChange"
        layout="total, sizes,prev, pager, next,jumper"
        :page-size="listQuery.pageSize"
        :page-sizes="[5,10,15]"
        :current-page.sync="listQuery.pageNum"
        :total="total">
      </el-pagination>
    </div>
  </div>
</template>

<script>
  import {formatDate} from '@/utils/date';
  import { listStation,allList } from '@/api/waterQuality';

  const defaultListQuery = {
    pageNum: 1,
    pageSize: 5,
    stationId: null,
    startTime:null,
    endTime: null
  };

  export default {
    name: "waterQualityQuery",
    data() {
      return {
        list: null,
        total: null,
        listLoading: true,
        stationOptions: [],
        listQuery: Object.assign({}, defaultListQuery)

      }
    },
    created() {
      listStation().then(res =>{
        this.stationOptions = res.data.list
      });
      this.getList();
    },
    watch: {
      $route(route) {
        this.getList();
      }
    },
    filters: {

      formatCreateTime(time) {
        let date = new Date(time);
        return formatDate(date, 'yyyy-MM-dd hh:mm:ss')
      }
    },
    methods: {

      getList() {
        this.listLoading = true;
        allList(this.listQuery).then(response => {
          this.listLoading = false;
          this.list = response.data.list;
          this.total = response.data.total;
        });
      },
      handleSizeChange(val) {
        this.listQuery.pageNum = 1;
        this.listQuery.pageSize = val;
        this.getList();
      },
      handleSearchList() {
        this.listQuery.pageNum = 1;
        this.getList();
      },
      handleResetSearch() {
        this.listQuery = Object.assign({}, defaultListQuery);
      },
      handleCurrentChange(val) {
        this.listQuery.pageNum = val;
        this.getList();
      }
    }
  }
</script>

