
<template>
  <div class="app-container">
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
        <el-table-column label="站名" align="center" width="160">
          <template slot-scope="scope">{{scope.row.stationName}}</template>
        </el-table-column>
        <el-table-column label="报警时间" width="160" align="center">
          <template slot-scope="scope">{{scope.row.alarmTime | formatCreateTime}}</template>
        </el-table-column>
        <el-table-column label="报警类型" width="100" align="center">
          <template slot-scope="scope">{{scope.row.alarmName }}</template>
        </el-table-column>
        <el-table-column label="报警数值" width="100" align="center">
          <template slot-scope="scope">{{scope.row.alarmValue }}</template>
        </el-table-column>
        <el-table-column label="报警描述" align="center">
          <template slot-scope="scope">{{scope.row.alarmDesc }}</template>
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
  import {fetchList} from '@/api/waterAlarm';
  import {formatDate} from '@/utils/date';

  export default {
    name: "RainFall",
    data() {
      return {
        list: null,
        total: null,
        listLoading: true,
        listQuery: {
          pageNum: 1,
          pageSize: 5
        }
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
    filters: {

      formatCreateTime(time) {
        let date = new Date(time);
        return formatDate(date, 'yyyy-MM-dd hh:mm:ss')
      }
    },
    methods: {

      getList() {
        this.listLoading = true;
        fetchList(this.listQuery).then(response => {
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
      handleCurrentChange(val) {
        this.listQuery.pageNum = val;
        this.getList();
      }
    }
  }
</script>

