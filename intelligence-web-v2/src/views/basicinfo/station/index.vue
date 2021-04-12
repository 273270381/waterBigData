<template>
  <el-row :gutter="12">
    <el-col :span="24">
      <el-card shadow="hover">
        <div >
          <el-card shadow = "hover">
            <el-tabs>
              <el-tab-pane label="水质站点">
                <waterquality/>
              </el-tab-pane>
              <el-tab-pane label="水文站点">
                <hydrology/>
              </el-tab-pane>
            </el-tabs>
          </el-card>
        </div>
      </el-card>
    </el-col>
  </el-row>
</template>

<script>
  import waterquality from "./waterquality/index";
  import hydrology from "./hydrology/index";

  export default {
    name: "index",
    components: {waterquality, hydrology},
  }
</script>

<style scoped>

</style>
