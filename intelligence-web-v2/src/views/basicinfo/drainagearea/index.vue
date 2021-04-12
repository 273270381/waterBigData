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
            </el-form>
          </el-card>
        </div>
        <div class="table-container">
          <el-table ref="adminTable"
                    :data="list"
                    row-key="valleyId"
                    default-expand-all
                    style="width: 100%;"
                    v-loading="listLoading" border
                    :tree-props="{children: 'children', hasChildren: 'hasChildren'}">
            <el-table-column prop="name" label="流域名称"  align="left"></el-table-column>
            <el-table-column prop="code" label="流域代码"  align="center"></el-table-column>
            <el-table-column prop="type" label="水体类型"  align="center"></el-table-column>
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
  import {formatDate,handleTree,selectDictLabel} from '@/utils/date';
  import {valleyList} from '@/api/basicInfo'
  const defaultListQuery = {
    pageSize: 10,
    pageNum: 1,
  };
  export default {
    data(){
      return{
        listQuery: Object.assign({}, defaultListQuery),
        list: [],
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
          this.list = handleTree(response.data.list,"valleyId","superValleyId");
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
      add() {
        console.log("add")
      }
    }
  }
</script>

<style scoped>

</style>
