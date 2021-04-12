<template>
  <el-row :gutter="12">
    <el-col :span="24">
      <el-card shadow="hover">
        <i class="el-icon-tickets"></i>
        <span>河长名录</span>
        <div style="margin-top: 20px">
          <el-card shadow = "hover">
            <el-form :inline="true" :model="formInline">
              <el-form-item label="河长姓名">
                <el-input v-model="formInline.name" clearable placeholder="全部"></el-input>
              </el-form-item>
              <el-form-item label="登录账号">
                <el-input v-model="formInline.account" clearable placeholder="全部"></el-input>
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
            <el-table-column label="河长姓名"  align="center">
              <template slot-scope="scope">{{scope.row.name}}</template>
            </el-table-column>
            <el-table-column label="河长级别"  align="center">
              <template slot-scope="scope">{{scope.row.lever}}</template>
            </el-table-column>
            <el-table-column label="河长类型"  align="center">
              <template slot-scope="scope">{{scope.row.type}}</template>
            </el-table-column>
            <el-table-column label="行政区划"  align="center">
              <template slot-scope="scope">{{scope.row.post}}</template>
            </el-table-column>
            <el-table-column label="管辖河道" align="center">
              <template slot-scope="scope">{{scope.row.riverName}}</template>
            </el-table-column>
            <el-table-column label="河长账号" align="center">
              <template slot-scope="scope">{{scope.row.account}}</template>
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
  import {riverManagerList} from '@/api/basicInfo'
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
          name:"",
          account:""
        }
      }
    },
    created(){
      this.getList();
    },
    methods:{
      getList() {
        this.listLoading = true;
        riverManagerList(this.listQuery).then(response => {
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
        this.listQuery.name = this.formInline.name;
        this.listQuery.account = this.formInline.account;
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
