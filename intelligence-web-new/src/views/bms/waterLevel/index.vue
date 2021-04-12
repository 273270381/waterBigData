
<template>
  <div class="app-container">
<!--    background-image:url('../assets/images/beijing.jpg');
    background-size:100% 100%;-->

    <el-card   style="background: transparent;height:850px;overflow-y:auto;overflow-x:hidden; border: 0;">
      <el-tabs>
        <el-tab-pane label="水位日报表" >
          <water-level-day/>
        </el-tab-pane>
        <el-tab-pane label="水位月报表">
          <water-level-month/>
        </el-tab-pane>
      </el-tabs>
    </el-card>

  </div>
</template>


<style>


</style>

<script>
  import WaterLevelDay from "./waterLevelDay";
  import WaterLevelMonth from "./waterLevelMonth";

  export default {
    name: "waterLevelReport",
    components: {WaterLevelDay, WaterLevelMonth},

    data() {
      return {
        backgroundDiv: {
          backgroundImage: 'url(' + require('../../../assets/images/beijing.jpg') + ')'
        },
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

