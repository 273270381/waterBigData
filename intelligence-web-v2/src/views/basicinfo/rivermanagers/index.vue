<template>
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
        <el-table-column label="河长账号" align="center">
          <template slot-scope="scope">{{scope.row.account}}</template>
        </el-table-column>
        <el-table-column label="管辖河道" align="center">
          <template slot-scope="scope">
            <el-button size="mini" type="primary" @click="handleRead(scope.$index, scope.row)">点击查看</el-button>
          </template>
          <!--<template slot-scope="scope">{{scope.row.riverName}}</template>-->
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

    <el-dialog
      :title="formTitle"
      :visible.sync="formVisible"
      :before-close="handleClose"
      :close-on-click-modal="false"
      width="30%">
      <el-table
        ref="adminTable"
        :data="riverlist"
        style="width: 100%;"
        :show-header="false"
        v-loading="listLoading" border>
        <el-table-column label="管辖河道"  align="center">
          <template slot-scope="scope">{{scope.row}}</template>
        </el-table-column>
      </el-table>
    </el-dialog>
  </el-card>
</template>

<script src="./rivermanagers.js"></script>

<style scoped>

</style>
