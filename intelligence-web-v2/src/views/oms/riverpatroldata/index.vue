<template>
  <div class="app-container">
    <el-row :gutter="20">
      <el-col :span="4">
        <el-input
          v-model="name"
          placeholder="请输入地区名称"
          clearable
          size="small"
          prefix-icon="el-icon-search"
          style="margin-bottom: 20px"
        />
        <el-tree
          :data="riverArea"
          :props="defaultProps"
          :expand-on-click-node="false"
          :filter-node-method="filterNode"
          ref="tree"
          default-expand-all
          @node-click="handleNodeClick"
        />
      </el-col>
      <el-col :span="20" :xs="24">
        <el-form :model="queryParams" ref="queryForm" :inline="true"  label-width="68px">
          <el-form-item label="创建时间">
            <el-date-picker
              v-model="dateRange"
              size="small"
              style="width: 240px"
              value-format="yyyy-MM-dd"
              type="daterange"
              range-separator="-"
              start-placeholder="开始日期"
              end-placeholder="结束日期"
            ></el-date-picker>
          </el-form-item>
          <el-form-item label="巡河人员" prop="userName">
            <el-input
              v-model="queryParams.name"
              placeholder="请输入人员名称"
              clearable
              size="small"
              style="width: 200px"
              @keyup.enter.native="handleQuery"
            />
          </el-form-item>
          <el-form-item label="巡河状态" prop="status">
            <el-select
              v-model="queryParams.status"
              placeholder="全部"
              clearable
              size="small"
              style="width: 120px"
            >
              <el-option
                v-for="dict in statusOptions"
                :key="dict.id"
                :label="dict.name"
                :value="dict.id"
              />
            </el-select>
          </el-form-item>

          <el-form-item>
            <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
          </el-form-item>

          <el-table
            v-loading="loading"
            :data="dataList"
            :show-header="false"
            style="width: 100%">
            <el-table-column  label="日期">
              <template slot-scope="scope">
                <el-card>
                  <div>
                    <a>{{scope.row.riverArea}}</a>
                    <a style="margin-left: 10px">{{scope.row.name}}</a>
                    <a style="margin-left: 40px">{{scope.row.riverName}}</a>
                    <a style="margin-left: 10px">{{scope.row.startTime | formatDateTime}}</a>
                    <a>至</a>
                    <a>{{scope.row.endTime | formatDateTime}}</a>
                  </div>
                  <div>
                    <a>巡河时长：{{scope.row.startTime  | formatDurationTime(scope.row.endTime)}} 分钟</a>
                    <a style="margin-left: 40px">巡河里程：{{scope.row.mileage}}公里</a>
                  </div>
                  <div>
                    <a>巡河问题：{{scope.row.problem}}个</a>
                  </div>
                  <div>
                    <a class="redit" @click="readRedit(scope.$index, scope.row)">查看巡河记录</a>
                    <a class="redit" style="margin-left: 40px" @click="deleteRedit(scope.$index, scope.row)">删除巡河记录</a>
                  </div>
                </el-card>
              </template>
            </el-table-column>
          </el-table>
        </el-form>
        <div class="pagination-container">
          <el-pagination
            background
            @size-change="handleSizeChange"
            @current-change="handleCurrentChange"
            layout="total, sizes,prev, pager, next,jumper"
            :current-page.sync="queryParams.pageNum"
            :page-size="queryParams.pageSize"
            :page-sizes="[10,15,20]"
            :total="total">
          </el-pagination>
        </div>

        <el-dialog
          :visible.sync="formVisible"
          :before-close="handleClose"
          :close-on-click-modal="false"
          width="50%">
          <baidu-map class="map" :center="endPoint" :zoom="zoom" @ready="handler" :scroll-wheel-zoom="true">
            <bm-marker :position="endPoint"  animation="BMAP_ANIMATION_BOUNCE" :icon="{url:'../../../../static/images/icon_end.png',size:{width: 30, height: 50}}"></bm-marker>
            <bm-marker :position="startPoint"  animation="BMAP_ANIMATION_BOUNCE" :icon="{url:'../../../../static/images/icon_start.png',size:{width: 30, height: 50}}"></bm-marker>
            <newPolyline :path="polylinePath" stroke-color="red" :stroke-opacity="0.8" :stroke-weight="8" :icons="icons"></newPolyline>
          </baidu-map>
        </el-dialog>
      </el-col>
    </el-row>
  </div>
</template>
<script src="./riverpatroldata.js"></script>
<style scoped>
  .redit{
    color: #1478F0;
  }
  .redit:hover{
    color: red;
  }
  .map{
    width: 100%;
    height: 400px;
  }
</style>
