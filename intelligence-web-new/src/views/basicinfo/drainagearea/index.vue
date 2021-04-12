<template>
  <el-row :gutter="12">
    <el-col :span="24">
      <el-card shadow="hover">
        <i class="el-icon-tickets"></i>
        <span>流域管理</span>
        <div style="margin-top: 20px">
          <el-card shadow = "hover">
            <el-form :inline="true" :model="formInline">
              <el-form-item>
                <el-button type="primary" @click="add">新增</el-button>
              </el-form-item>
              <el-form-item>
                <el-button type="primary" @click="deleted">删除</el-button>
              </el-form-item>
            </el-form>
          </el-card>
        </div>
        <div class="table-container">
          <el-table ref="adminTable"
                    :data="list"
                    style="width: 100%;"
                    v-loading="listLoading" border>
            <el-table-column label="" :render-header="renderHeader" width="50" align="center">
              <template slot-scope="scope"><el-checkbox v-model="checked"></el-checkbox></template>
            </el-table-column>
            <el-table-column label="流域代码"  align="center">
              <template slot-scope="scope">{{scope.row.code}}</template>
            </el-table-column>
            <el-table-column label="流域名称"  align="center">
              <template slot-scope="scope">{{scope.row.valleyName}}</template>
            </el-table-column>
            <el-table-column label="水体类型"  align="center">
              <template slot-scope="scope">{{scope.row.type}}</template>
            </el-table-column>
            <el-table-column label="上级流域"  align="center">
              <template slot-scope="scope">{{scope.row.superName}}</template>
            </el-table-column>
            <el-table-column label="操作" align="center">
              <template slot-scope="scope">
                <el-button type="primary" icon="el-icon-edit" circle></el-button>
                <el-button type="danger" icon="el-icon-delete" circle></el-button>
              </template>
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
            :page-sizes="[10,15,20]"
            :total="total">
          </el-pagination>
        </div>
      </el-card>
    </el-col>
  </el-row>
</template>

<script>
  import {formatDate} from '@/utils/date';
  import {valleyList} from '@/api/basicInfo'
  const defaultListQuery = {
    pageSize: 10,
    pageNum: 1,
  };
  export default {
    data(){
      return{
        listQuery: Object.assign({}, defaultListQuery),
        list: null,
        total: null,
        listLoading: false,
        formInline: {

        }
      }
    },
    created(){
      this.getList();
    },
    methods:{
      getList() {
        this.listLoading = true;
        valleyList(this.listQuery).then(response => {
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
      renderHeader(){
        return (<el-checkbox v-model="checked"></el-checkbox>);
      },
      handleCurrentChange(val) {
        this.listQuery.pageNum = val;
        this.getList();
      },
      add() {
        console.log("add")
      },
      deleted(){
        console.log("deleted")
      }
    }
  }
</script>

<style scoped>

</style>
