<template>
  <el-row :gutter="12">
    <el-col :span="24">
      <el-card shadow="hover">
        <i class="el-icon-tickets"></i>
        <span>河湖名录</span>
        <div style="margin-top: 20px">
          <el-card shadow = "hover">
            <el-form :inline="true" :model="formInline">
              <el-form-item label="河流名称">
                <el-input v-model="formInline.riverName" clearable placeholder="全部"></el-input>
              </el-form-item>
              <el-form-item label="水域面积">
                <el-input v-model="formInline.waterAcreage" clearable placeholder="全部"></el-input>
              </el-form-item>
              <el-form-item>
                <el-button type="primary" @click="search">查询</el-button>
              </el-form-item>
              <el-form-item>
                <el-button type="primary" @click="refresh">刷新</el-button>
              </el-form-item>
              <el-form-item>
                <el-button type="primary" @click="add">新增</el-button>
              </el-form-item>
              <el-form-item>
                <el-button type="primary" @click="exported">导出</el-button>
              </el-form-item>
            </el-form>
          </el-card>
        </div>
        <div class="table-container">
          <el-table ref="adminTable"
                    :data="list"
                    style="width: 100%;"
                    v-loading="listLoading" border>
            <el-table-column label="河流名称"  align="center">
              <template slot-scope="scope">{{scope.row.rivername}}</template>
            </el-table-column>
            <el-table-column label="河长姓名"  align="center">
              <template slot-scope="scope">{{scope.row.managername}}</template>
            </el-table-column>
            <el-table-column label="河流等级"  align="center">
              <template slot-scope="scope">{{scope.row.lever}}</template>
            </el-table-column>
            <el-table-column label="河流长度(km)"  align="center">
              <template slot-scope="scope">{{scope.row.length}}</template>
            </el-table-column>
            <el-table-column label="流域面积(km2)" align="center">
              <template slot-scope="scope">{{scope.row.valleyacreage}}</template>
            </el-table-column>
            <el-table-column label="水域面积(km2)" align="center">
              <template slot-scope="scope">{{scope.row.wateracreage}}</template>
            </el-table-column>
            <el-table-column label="操作" align="center">
              <template slot-scope="scope">
                <el-button size="mini" @click="handleEdit(scope.$index, scope.row)">编辑</el-button>
                <el-button size="mini" type="danger" @click="handleDelete(scope.$index, scope.row)">删除</el-button>
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
  import {riverList} from '@/api/basicInfo'
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
          riverName:"",
          waterAcreage:""
        }
      }
    },
    created(){
      this.getList();
    },
    methods:{
      getList() {
        this.listLoading = true;
        riverList(this.listQuery).then(response => {
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
      },
      search(){
        this.listQuery.riverName = this.formInline.riverName;
        this.listQuery.waterAcreage = this.formInline.waterAcreage;
        this.getList();
      },
      refresh(){
        this.getList();
      },
      add(){
        console.log("add");
      },
      exported(){
        console.log("export");
      },
    }
  }
</script>

<style scoped>

</style>
