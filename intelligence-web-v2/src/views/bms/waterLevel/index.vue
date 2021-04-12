
<template>
  <div class="app-container">
    <el-card>
      <el-tabs>
        <el-tab-pane label="水位日报表">
          <water-level-day/>
        </el-tab-pane>
        <el-tab-pane label="水位月报表">
          <water-level-month/>
        </el-tab-pane>
        <el-tab-pane label="水位年报表">
          <water-level-year/>
        </el-tab-pane>
      </el-tabs>
    </el-card>

  </div>
</template>

<script>
  import WaterLevelDay from "./waterLevelDay";
  import WaterLevelMonth from "./waterLevelMonth";
  import WaterLevelYear from "./waterLevelYear";
  export default {
    name: "waterLevelReport",
    components: {WaterLevelDay, WaterLevelMonth,WaterLevelYear},

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

