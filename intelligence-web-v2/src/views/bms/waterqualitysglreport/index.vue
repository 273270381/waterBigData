
<template>
  <div class="app-container">
    <el-card>
      <el-tabs>
        <el-tab-pane label="日报">
      <water-quality-day/>
        </el-tab-pane>
        <el-tab-pane label="周报">
         <water-quality-week/>
        </el-tab-pane>
        <el-tab-pane label="月报">
          <water-quality-month/>
        </el-tab-pane>
        <el-tab-pane label="年报">
        <water-quality-year/>
        </el-tab-pane>
      </el-tabs>
    </el-card>

  </div>
</template>

<script>
  import WaterQualityDay from "./waterQualityDay";
  import WaterQualityWeek from "./waterQualityWeek";
  import WaterQualityMonth from "./waterQualityMonth";
  import WaterQualityYear from "./waterQualityYear";
  export default {
    name: "waterLevelReport",
    components: {
      WaterQualityYear,
      WaterQualityMonth, WaterQualityDay, WaterQualityWeek},

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

