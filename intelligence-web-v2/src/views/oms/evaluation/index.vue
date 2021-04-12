
<template>
  <div class="app-container">
    <el-card>
      <el-tabs>
        <el-tab-pane label="按站点">
            <water-level/>
        </el-tab-pane>
        <el-tab-pane label="按时间">
            <rain-fall/>
        </el-tab-pane>
      </el-tabs>
    </el-card>

  </div>
</template>

<script>
  import WaterLevel from "./waterLevel";
  import RainFall from "./rainfall";
  import {fetchList} from '@/api/waterReport';

  export default {
    name: "waterReportList",
    components: {RainFall, WaterLevel},

    data() {
      return {
        list: null,
        total: null,
        listLoading: true,
        listQuery: {
          pageNum: 1,
          pageSize: 5
        },
        code:"WL"
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
    methods: {

      getList() {
        this.listLoading = true;
        fetchList(this.code, this.listQuery).then(response => {
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

