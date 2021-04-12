<template>
  <el-row :gutter="12">
    <el-col :span="24">
      <el-card shadow="hover">
        <i class="el-icon-tickets"></i>
        <span>水文站点</span>
        <div style="margin-top: 20px">
          <el-card shadow = "hover">
            <el-form :inline="true" :model="formInline">
              <el-form-item label="区域">
                <el-select v-model="formInline.areaName" clearable placeholder="全部">
                  <el-option
                    v-for= "item in areaList"
                    :key="item.code"
                    :lable="item.areaName"
                    :value="item.areaName"
                  >
                  </el-option>
                </el-select>
              </el-form-item>
              <el-form-item label="站点名称">
                <el-input v-model="formInline.stationName" clearable placeholder="全部"></el-input>
              </el-form-item>
              <el-form-item label="编码">
                <el-input v-model="formInline.code" clearable placeholder="全部"></el-input>
              </el-form-item>
              <el-form-item>
                <el-button type="primary" @click="onSubmit">查询</el-button>
              </el-form-item>
              <el-form-item>
                <el-button type="primary" @click="addStation">新增</el-button>
              </el-form-item>
              <el-form-item>
                <el-button type="primary" @click="deleteStation">删除</el-button>
              </el-form-item>
            </el-form>
          </el-card>
        </div>
        <div class="table-container">
          <el-table ref="multipleTable"
                    :data="list"
                    style="width: 100%;"
                    @selection-change="handleSelectionChange"
                    v-loading="listLoading" border>
            <el-table-column type="selection" width="50" align="center">
            </el-table-column>
            <el-table-column label="序号" width="50" align="center">
              <template slot-scope="scope">{{scope.row.id}}</template>
            </el-table-column>
            <el-table-column label="站名" width="150" align="center">
              <template slot-scope="scope">{{scope.row.stationName}}</template>
            </el-table-column>
            <el-table-column label="编码" width="50" align="center">
              <template slot-scope="scope">{{scope.row.code}}</template>
            </el-table-column>
            <el-table-column label="所在区域" width="100" align="center">
              <template slot-scope="scope">{{scope.row.areaName}}</template>
            </el-table-column>
            <el-table-column label="经度" width="150" align="center">
              <template slot-scope="scope">{{scope.row.longitude }}</template>
            </el-table-column>
            <el-table-column label="纬度" width="150" align="center">
              <template slot-scope="scope">{{scope.row.latitude}}</template>
            </el-table-column>
            <el-table-column label="高程" width="50" align="center">
              <template slot-scope="scope">{{scope.row.high}}</template>
            </el-table-column>
            <el-table-column label="设立日期" width="200" align="center">
              <template slot-scope="scope">{{scope.row.createTime | formatDateTime}}</template>
            </el-table-column>
            <el-table-column label="所属小流域" align="center">
              <template slot-scope="scope">{{scope.row.valleyName}}</template>
            </el-table-column>
            <el-table-column label="关联乡村" align="center">
              <template slot-scope="scope">{{scope.row.country}}</template>
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
  import {hydrologyStationList,areaList} from '@/api/basicInfo'
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
        multipleSelection: [],
        areaList:[],
        formInline: {
          areaName:"",
          stationName: '',
          code: ''
        }
      }
    },
    created(){
      this.getList();
      this.getAreaList();
    },
    filters: {
      formatDateTime(time) {
        if (time == null || time === '') {
          return 'N/A';
        }
        let date = new Date(time);
        return formatDate(date, 'yyyy-MM-dd hh:mm:ss')
      }
    },
    methods:{
      getList() {
        this.listLoading = true;
        hydrologyStationList(this.listQuery).then(response => {
          this.listLoading = false;
          this.list = response.data.list;
          this.total = response.data.total;
        });
      },
      getAreaList(){
        areaList().then(response => {
          this.areaList = response.data.list;
          console.log(this.formInline.areaList)
        })
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
        this.listQuery.area = this.formInline.areaName;
        this.listQuery.stationName = this.formInline.stationName;
        this.listQuery.code = this.formInline.code;
        this.getList();
      },
      addStation(){
        console.log("add")
      },
      deleteStation(){
        console.log("delete")
      },


      handleSelectionChange(val) {
        this.multipleSelection = val;
      }
    }
  }
</script>

<style scoped>

</style>
