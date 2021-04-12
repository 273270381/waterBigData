<template>
  <el-row :gutter="12">
    <el-col :span="24">
      <el-card shadow="hover">
        <i class="el-icon-tickets"></i>
        <span>水质站点</span>
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
          <el-table ref="adminTable"
                    :data="list"
                    style="width: 100%;"
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
            <el-table-column label="所在区域" width="150" align="center">
              <template slot-scope="scope">{{scope.row.areaName}}</template>
            </el-table-column>
            <el-table-column label="站点类型" width="150" align="center">
              <template slot-scope="scope">{{scope.row.stationType}}</template>
            </el-table-column>
            <el-table-column label="经度" width="200" align="center">
              <template slot-scope="scope">{{scope.row.longitude }}</template>
            </el-table-column>
            <el-table-column label="纬度" width="200" align="center">
              <template slot-scope="scope">{{scope.row.latitude}}</template>
            </el-table-column>
            <el-table-column label="控制级别" width="150" align="center">
              <template slot-scope="scope">{{scope.row.controLever}}</template>
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

        <el-dialog
          :title="formTitle"
          :visible.sync="formVisible"
          :before-close="handleClose"
          :close-on-click-modal="false"
          width="70%">
          <el-form ref="form" :model="form" :rules="rules">
            <el-row>
              <el-col :span="6">
                <el-form-item label="站点名称" label-width="70px">
                  <el-input v-model="form.stationName" minlength=1></el-input>
                </el-form-item>
              </el-col>

              <el-col :span="6">
                <el-form-item label="站点Id" label-width="70px">
                  <el-input v-model="form.stationId"  minlength=1></el-input>
                </el-form-item>
              </el-col>

              <el-col :span="6">
                <el-form-item label="编码" label-width="70px">
                  <el-input v-model="form.code"  minlength=1></el-input>
                </el-form-item>
              </el-col>

              <el-col :span="6">
                <el-form-item label="所在区域" label-width="70px">
                  <el-select  v-model="form.areaName" filterable placeholder="请选择" style="width: 100%;">
                    <el-option
                      v-for="item in areaList"
                      :key="item.code"
                      :label="item.areaName"
                      :value="item.areaName"
                    >
                    </el-option>
                  </el-select>
                </el-form-item>
              </el-col>

              <el-col :span="6">
                <el-form-item label="所在流域" label-width="70px" >
                  <el-select  v-model="form.valley" filterable placeholder="请选择" style="width: 100%;">
                    <el-option
                      v-for="item in valleyList"
                      :key="item.valleyName"
                      :label="item.valleyName"
                      :value="item.valleyName"
                    >
                    </el-option>
                  </el-select>
                </el-form-item>
              </el-col>

              <el-col :span="6">
                <el-form-item label="站点类型" label-width="70px">
                  <el-select  v-model="form.sType" filterable placeholder="请选择" style="width: 100%;">
                    <el-option
                      v-for="item in typeList"
                      :key="item.id"
                      :label="item.name"
                      :value="item.name"
                    >
                    </el-option>
                  </el-select>
                </el-form-item>
              </el-col>

              <el-col :span="6">
                <el-form-item label="控制级别" label-width="70px" >
                  <el-select  v-model="form.lever" filterable placeholder="请选择" style="width: 100%;">
                    <el-option
                      v-for="item in leverList"
                      :key="item.id"
                      :label="item.name"
                      :value="item.name"
                    >
                    </el-option>
                  </el-select>
                </el-form-item>
              </el-col>

              <el-col :span="6">
                <el-form-item label="是否联网" label-width="70px" >
                  <el-select  v-model="form.isConnected" filterable placeholder="请选择" style="width: 100%;">
                    <el-option
                      v-for="item in connenctList"
                      :key="item.key"
                      :label="item.value"
                      :value="item.value"
                    >
                    </el-option>
                  </el-select>
                </el-form-item>
              </el-col>

              <el-col :span="6">
                <el-form-item label="监测时间" label-width="70px">
                  <el-date-picker
                    v-model="form.time"
                    type="datetime"
                    placeholder="选择日期时间"
                    style="width: 100%;"
                    >
                  </el-date-picker>
                </el-form-item>
              </el-col>

              <el-col :span="6">
                <el-form-item label="经度" label-width="70px" >
                  <el-input v-model="form.longitude"  minlength=1></el-input>
                </el-form-item>
              </el-col>

              <el-col :span="6">
                <el-form-item label="纬度" label-width="70px" >
                  <el-input v-model="form.latitude"  minlength=1></el-input>
                </el-form-item>
              </el-col>

              <el-col :span="6">
                <el-form-item label="高锰酸钾(mg/L)" label-width="110px">
                  <el-input v-model="form.latitude"  minlength=1></el-input>
                </el-form-item>
              </el-col>

              <el-col :span="6">
                <el-form-item label="总磷(mg/L)" label-width="100px">
                  <el-input v-model="form.latitude"  minlength=1></el-input>
                </el-form-item>
              </el-col>

              <el-col :span="6">
                <el-form-item label="氨氮(mg/L)" label-width="100px" >
                  <el-input v-model="form.latitude"  minlength=1></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="6">
                <el-form-item label="水温(℃)" label-width="70px" >
                  <el-input v-model="form.latitude"  minlength=1></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="6">
                <el-form-item label="PH" label-width="30px" >
                  <el-input v-model="form.latitude"  minlength=1></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="6">
                <el-form-item label="溶解氧(mg/L)" label-width="100px">
                  <el-input v-model="form.latitude"  minlength=1></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="6">
                <el-form-item label="氧化还原电位(mV)" label-width="130px">
                  <el-input v-model="form.latitude"  minlength=1></el-input>
                </el-form-item>
              </el-col>

              <el-col :span="6">
                <el-form-item label="点位状态" label-width="70px" >
                  <el-select  v-model="form.status" filterable placeholder="请选择" style="width: 100%;">
                    <el-option
                      v-for="item in statuList"
                      :key="item.key"
                      :label="item.value"
                      :value="item.value"
                    >
                    </el-option>
                  </el-select>
                </el-form-item>
              </el-col>
            </el-row>
            <el-form-item>
              <div class="bt">
                <el-button type="primary" @click="save">确定</el-button>
                <el-button @click.native="cancel">取消</el-button>
              </div>
            </el-form-item>
          </el-form>
        </el-dialog>

      </el-card>
    </el-col>
  </el-row>
</template>

<script src="./waterquality.js"></script>

<style scoped>
  .el-form >>> .el-form-item__label{
    text-align: left;
  }
  .el-form-item{
    margin-left: 10px;
  }
  .bt{
    float: right;
  }
</style>
