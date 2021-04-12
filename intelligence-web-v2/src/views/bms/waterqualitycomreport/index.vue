
<template>
  <div class="app-container">
    <el-card>
      <el-tabs>

        <el-tab-pane label="周报">
<water-quality-com-week/>
        </el-tab-pane>
        <el-tab-pane label="月报">
          <water-quality-com-month/>
        </el-tab-pane>

      </el-tabs>
    </el-card>

  </div>
</template>

<script>
  import WaterQualityComMonth from "./waterQualityComMonth";
  import WaterQualityComWeek from "./waterQualityComWeek";

  export default {
    name: "waterLevelReport",
    components: {
      WaterQualityComMonth,
      WaterQualityComWeek},

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
    },
    watch: {
      $route(route) {
      }
    },
    methods: {

    }
  }
</script>

