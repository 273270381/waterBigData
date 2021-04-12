<template>
  <el-card shadow="hover">
    <div style="margin-top: 20px">
      <el-form :inline="true" :model="formInline">
        <el-form-item label="区域">
          <el-select
            v-model="formInline.areaName"
            clearable
            filterable
            :popper-append-to-body="false"
            placeholder="全部">
            <el-option
              v-for= "item in areaList"
              :key="item.ids"
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
        <el-table-column label="编码" width="100" align="center">
          <template slot-scope="scope">{{scope.row.code}}</template>
        </el-table-column>
        <el-table-column label="所在区域" width="100" align="center">
          <template slot-scope="scope">{{scope.row.areaName}}</template>
        </el-table-column>
        <el-table-column label="经度" width="120" align="center">
          <template slot-scope="scope">{{scope.row.longitude }}</template>
        </el-table-column>
        <el-table-column label="纬度" width="120" align="center">
          <template slot-scope="scope">{{scope.row.latitude}}</template>
        </el-table-column>
        <el-table-column label="高程" width="60" align="center">
          <template slot-scope="scope">{{scope.row.high}}</template>
        </el-table-column>
        <el-table-column label="设立日期" width="200" align="center">
          <template slot-scope="scope">{{scope.row.createTime | formatDateTime}}</template>
        </el-table-column>
        <el-table-column label="所属小流域" align="center">
          <template slot-scope="scope">{{scope.row.valleyName}}</template>
        </el-table-column>
        <el-table-column label="关联乡村" width="100" align="center">
          <template slot-scope="scope">{{scope.row.country}}</template>
        </el-table-column>
        <el-table-column label="操作" width="150" align="center">
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
</template>

<script src="./hydrology.js"></script>
<style scoped>

</style>
