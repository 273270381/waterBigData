
<template>
  <div class="app-container">
    <el-card>
      <el-tabs>
        <el-tab-pane label="雨量日报表">
   <rain-level-day/>
        </el-tab-pane>
        <el-tab-pane label="雨量月报表">
          <rain-level-month/>
        </el-tab-pane>
        <el-tab-pane label="雨量年报表">
          <rain-level-year/>
        </el-tab-pane>
      </el-tabs>
    </el-card>

  </div>
</template>

<script>
  import RainLevelDay from "./rainLevelDay";
  import RainLevelMonth from "./rainLevelMonth";
  import RainLevelYear from "./rainLevelYear";
  export default {
    name: "waterLevelReport",
    components: {RainLevelDay, RainLevelMonth,RainLevelYear},

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

