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
          查询搜索
        </el-button>
        <el-button
          style="float:right;margin-right: 15px"
          @click="handleResetSearch()"
          size="small">
          重置
        </el-button>
        <el-button
          style="float:right;margin-right: 15px"
          @click="handleResetSearch()"
          size="small">
          导出
        </el-button>
        <el-button
          style="float:right;margin-right: 15px"
          @click="handleResetSearch()"
          size="small">
          打印
        </el-button>
      </div>
      <div style="margin-top: 15px">
        <el-form :inline="true" :model="listQuery" size="small" label-width="140px">
          <el-form-item label="站点：">
            <el-select v-model="listQuery.stationId" class="input-width" placeholder="全部" clearable>
              <el-option v-for="item in stationOptions"
                         :key="item.stationId"
                         :label="item.stationName"
                         :value="item.stationId">
              </el-option>
            </el-select>
          </el-form-item>
          <el-form-item label="开始时间：">
            <el-date-picker
              class="input-width"
              v-model="listQuery.startTime"
              value-format="yyyy-MM-dd HH:mm:ss"
              type="date"
              placeholder="请选择时间">
            </el-date-picker>
          </el-form-item>
          <el-form-item label="结束时间：">
            <el-date-picker
              class="input-width"
              v-model="listQuery.endTime"
              value-format="yyyy-MM-dd HH:mm:ss"
              type="date"
              placeholder="请选择时间">
            </el-date-picker>
          </el-form-item>
        </el-form>
      </div>
    </el-card>
    <el-card class="operate-container" shadow="never">
      <i class="el-icon-tickets"></i>
      <span>数据列表</span>
    </el-card>

    <div class="statistics-layout">
      <el-row>
        <el-col :span="6">
          <div class="table-container">
            <el-table ref="orderTable"
                      :data="list"
                      style="width: 100%;"
                      @selection-change="handleSelectionChange"
                      v-loading="listLoading" border>

              <el-table-column label="时间" width="180" align="center">
                <template slot-scope="scope">{{scope.row.captureTime | formatCreateTime}}</template>
              </el-table-column>
              <el-table-column label="水位(m)" align="center">
                <template slot-scope="scope">{{scope.row.value}}</template>
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
              :page-sizes="[5,10,15]"
              :total="total">
            </el-pagination>
          </div>
        </el-col>
        <el-col :span="18">
          <div style="padding: 10px;border-left:1px solid #DCDFE6">
            <div>
              <el-button size="small" type="warning" @click="changeType">切换图表类型</el-button>
              <ve-chart
                :data="chartData"
                :legend-visible="true"
                :loading="loading"
                :data-empty="dataEmpty"
                :settings="chartSettings"
                :extend="extend"></ve-chart>
            </div>
          </div>
        </el-col>
      </el-row>
    </div>
  </div>
</template>
<script>
  import {fetchList} from '@/api/historyDataChart'
  import {formatDate} from '@/utils/date';
  import {str2Date} from '@/utils/date';
  import { getCMarked } from '@/api/waterMap';
  const defaultListQuery = {
    pageNum: 1,
    pageSize: 10,
    stationId: null,
    startTime:null,
    endTime: null,
    code:"WL"
  };

  export default {
    name: "waterLevelChartList",
    data() {
      this.extend = {
        series: {
          label: {
            normal: {
              show: true
            }
          }
        }
      }
      this.typeArr = ['line', 'histogram', 'pie']
      this.index = 0
      return {
        chartData: {
          columns: [],
          rows: []
        },
        chartSettings: {
          xAxisType: 'time',
          type: this.typeArr[this.index],
          area:true,
          labelMap: {'value': '水位'}},
        loading: false,
        dataEmpty: true,
        listQuery: Object.assign({}, defaultListQuery),
        listLoading: true,
        list: null,
        total: null,
        operateType: null,
        multipleSelection: [],
        closeOrder:{
          dialogVisible:false,
          content:null,
          orderIds:[]
        },
        orderCountDate: '',
        stationOptions: []
      }
    },
    created() {
      getCMarked().then(res =>{
        this.stationOptions = res.data.list
      })
      this.getList();
      this.getData();

    },
    filters: {

      formatCreateTime(time) {
        let date = new Date(time);
        return formatDate(date, 'yyyy-MM-dd hh:mm:ss')
      }
    },
    methods: {

      changeType: function () {
        this.index++
        if (this.index >= this.typeArr.length) { this.index = 0 }
        this.chartSettings = {
          xAxisType: 'time',
          type: this.typeArr[this.index],
          area:true,
          labelMap: {'value': '水位'}}
      },

      getData(){
        setTimeout(() => {
          this.chartData = {
            columns: ['captureTime', 'value'],
            rows: []
          };
          for(let i=0;i<this.list.length;i++){
            let item=this.list[i];
            this.chartData.rows.push(item);
          }
          this.dataEmpty = false;
          this.loading = false
        }, 1000)
      },
      handleResetSearch() {
        this.listQuery = Object.assign({}, defaultListQuery);
      },
      handleSearchList() {
        this.listQuery.pageNum = 1;
        this.getList();
        this.getData();
      },
      handleSelectionChange(val){
        this.multipleSelection = val;
      },
      handleSizeChange(val){
        this.listQuery.pageNum = 1;
        this.listQuery.pageSize = val;
        this.getList();
      },
      handleCurrentChange(val){
        this.listQuery.pageNum = val;
        this.getList();
      },
      getList() {
        this.listLoading = true;
        fetchList(this.listQuery).then(response => {
          this.listLoading = false;
          this.list = response.data.list;
          for(let i=0;i<this.list.length;i++){
            this.list[i].captureTime = formatDate(new Date(this.list[i].captureTime),'yyyy-MM-dd hh:mm:ss')
          }
          this.total = response.data.total;
          if(this.list.length > 0){
            this.orderCountDate=[this.list[0].captureTime,this.list[this.list.length-1].captureTime];
          }

        });
      }
    }
  }
</script>
<style scoped>
  .input-width {
    width: 203px;
  }
  .statistics-layout {
    margin-top: 20px;
    border: 1px solid #DCDFE6;
  }
</style>


