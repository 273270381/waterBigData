<template>
  <el-row :gutter="12">
    <el-col :span="24">
      <el-card shadow="hover">
        <i class="el-icon-tickets"></i>
        <span>行政区划</span>
        <div style="margin-top: 20px">
          <el-card shadow = "hover">
            <el-form :inline="true" :model="formInline">
              <el-form-item label="地区名称">
                <el-input v-model="formInline.areaName" clearable placeholder="全部"></el-input>
              </el-form-item>
              <el-form-item label="地区编号">
                <el-input v-model="formInline.code" clearable placeholder="全部"></el-input>
              </el-form-item>
              <el-form-item label="上级地区名称">
                <el-input v-model="formInline.superAreaName" clearable placeholder="全部"></el-input>
              </el-form-item>
              <el-form-item>
                <el-button type="primary" @click="onSubmit">查询</el-button>
              </el-form-item>
            </el-form>
          </el-card>
        </div>
        <div class="table-container">
          <el-table ref="adminTable"
                    :data="list"
                    style="width: 100%;"
                    v-loading="listLoading" border>
            <el-table-column label="地区名称"  align="center">
              <template slot-scope="scope">{{scope.row.areaName}}</template>
            </el-table-column>
            <el-table-column label="地区编号"  align="center">
              <template slot-scope="scope">{{scope.row.code}}</template>
            </el-table-column>
            <el-table-column label="地区等级"  align="center">
              <template slot-scope="scope">{{scope.row.lever}}</template>
            </el-table-column>
            <el-table-column label="上级地区名称"  align="center">
              <template slot-scope="scope">{{scope.row.superAreaName}}</template>
            </el-table-column>
            <el-table-column label="上级地区编号"  align="center">
              <template slot-scope="scope">{{scope.row.superCode }}</template>
            </el-table-column>
            <el-table-column label="上级地区等级"  align="center">
              <template slot-scope="scope">{{scope.row.superLever}}</template>
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
  import {areaList} from '@/api/basicInfo'
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
          areaName: '',
          code: '',
          superAreaName: ''
        }
      }
    },
    created(){
      this.getList();
    },
    methods:{
      getList() {
        this.listLoading = true;
        areaList(this.listQuery).then(response => {
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
      onSubmit() {
        this.listQuery.areaName = this.formInline.areaName;
        this.listQuery.code = this.formInline.code;
        this.listQuery.superArea = this.formInline.superAreaName;
        this.getList();
      }
    }
  }
</script>

<style scoped>

</style>
