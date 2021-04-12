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
                    row-key="areaId"
                    style="width: 100%;"
                    default-expand-all
                    v-loading="listLoading" border
                    :tree-props="{children: 'children', hasChildren: 'hasChildren'}"
                    >
            <el-table-column prop="areaName" label="地区名称"  align="left"></el-table-column>
            <el-table-column prop="areaCode" label="地区编号"  align="center"></el-table-column>
            <el-table-column prop="leverId" label="地区等级" :formatter="statusFormat" align="center"></el-table-column>
            <el-table-column label="操作" align="center">
              <template slot-scope="scope">
                <el-button size="mini" @click="handleEdit(scope.$index, scope.row)">编辑</el-button>
                <el-button size="mini" type="danger" @click="handleDelete(scope.$index, scope.row)">删除</el-button>
                <!--<el-button size="mini" type="primary" icon="el-icon-edit" ></el-button>-->
                <!--<el-button size="mini" type="danger" icon="el-icon-delete" ></el-button>-->
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
  import {areaList,getDicts} from '@/api/basicInfo'
  const defaultListQuery = {
    pageSize: 10,
    pageNum: 1,
  };
  export default {
    data(){
      return{
        listQuery: Object.assign({}, defaultListQuery),
        statusOptions: [],
        list: [],
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
      getDicts().then(response => {
        this.statusOptions = response.data;
      });
    },
    methods:{
      getList() {
        this.listLoading = true;
        areaList(this.listQuery).then(response => {
          this.listLoading = false;
          this.list = handleTree(response.data.list,"areaId","superAreaId");
          this.total = response.data.total;
        });
      },
      // 字典状态字典翻译
      statusFormat(row, column) {
        return selectDictLabel(this.statusOptions, row.leverId);
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
