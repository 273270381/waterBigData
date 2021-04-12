<template>
  <el-row :gutter="12">
    <el-col :span="24">
      <el-card shadow="hover">
        <i class="el-icon-tickets"></i>
        <span>水功能区</span>
        <div class="table-container">
          <el-table ref="adminTable"
                    :data="list"
                    style="width: 100%;"
                    v-loading="listLoading" border>
            <el-table-column label="序号"  width = "50" align="center">
              <template slot-scope="scope">{{scope.row.id}}</template>
            </el-table-column>
            <el-table-column label="名称" width = "100" align="center">
              <template slot-scope="scope">{{scope.row.name}}</template>
            </el-table-column>
            <el-table-column label="级别值" width = "100" align="center">
              <template slot-scope="scope">{{scope.row.lever}}</template>
            </el-table-column>
            <el-table-column label="类别描述" align="left">
              <template slot-scope="scope">{{scope.row.des}}</template>
            </el-table-column>
            <el-table-column label="操作" width = "100" align="center">
              <template slot-scope="scope">
                <el-button type="primary" icon="el-icon-edit" circle></el-button>
              </template>
            </el-table-column>
          </el-table>
        </div>
      </el-card>
    </el-col>
  </el-row>
</template>

<script>
  import {formatDate} from '@/utils/date';
  import {waterCategoryList} from '@/api/basicInfo'
  export default {
    data(){
      return{
        list: null,
        listLoading: false,
      }
    },
    created(){
      this.getList();
    },
    methods:{
      getList() {
        this.listLoading = true;
        waterCategoryList().then(response => {
          this.listLoading = false;
          this.list = response.data;
        });
      }
    }
  }
</script>

<style scoped>

</style>
