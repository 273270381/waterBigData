<template>
    <baidu-map id="map" :center="{lng: map.center.lng, lat: map.center.lat}" :zoom="map.zoom" @ready="handler" :scroll-wheel-zoom="true">
      <bm-navigation anchor="BMAP_ANCHOR_TOP_LEFT"></bm-navigation>
      <bm-map-type :map-types="['BMAP_NORMAL_MAP', 'BMAP_HYBRID_MAP']" anchor="BMAP_ANCHOR_BOTTOM_RIGHT"></bm-map-type>
      <bm-control id="searAdressBox">
        <div class="controlBox">
          <el-button >联网率: {{onLineRate}}, 在线数: {{onLineNum}}, 离线数: {{offLineNum}}</el-button>
          <div class="control_right">
            <div>
              <span class="searchText">搜索站点：</span><el-input placeholder="请输入搜索站名"  @keyup.enter.native="searchAdress" style="width:200px" size="mini" v-model="searchadress"></el-input>
              <el-button type="primary" size="mini" @click="searchAdress" icon="el-icon-search">搜索</el-button>
            </div>
          </div>
        </div>
      </bm-control>

        <bm-marker v-for="Cmarker of Cmarkers" :dragging="true" animation="BMAP_ANIMATION_BOUNCE"  :key="Cmarker.siteId" :title="Cmarker.siteName" :position="{lng: Cmarker.longitude, lat: Cmarker.latitude}" @click="lookDetail(Cmarker)">
          <bm-label :content="Cmarker.siteName" :position="{lng: Cmarker.longitude, lat: Cmarker.latitude}" :offset="{width: -20, height: 30}" :labelStyle="{ border : '1px solid rgb(0, 255, 31)' ,fontSize : '16px'}"/>
          <bm-context-menu>
            <bm-context-menu-item :callback="getPosition" text="获取坐标"></bm-context-menu-item>
          </bm-context-menu>
        </bm-marker>

      <bm-info-window :width="550" :height="370" :position="{lng: infoWindow.info.longitude, lat: infoWindow.info.latitude}" :title="infoWindow.info.siteName" :show="infoWindow.show" @close="infoWindowClose" @open="infoWindowOpen">
        <div class="infoTitle">
          <el-row style="margin-top:6px">
            <el-col :span="10"><div class="info-content">水质目标：</div></el-col>
          </el-row>
          <el-row style="margin-top:6px">
            <el-col :span="10"><div class="info-content">点位类型：</div></el-col>
          </el-row>
          <el-row style="margin-top:6px">
            <el-col :span="10"><div class="info-content">地址：{{infoWindow.info.address}}</div></el-col>
          </el-row>
          <el-row style="margin-top:6px">
            <el-col :span="10">
              <div class="info-content">
                <span>点位状态：</span><el-button v-if="infoWindow.info.runStatus == '1'" type="success">{{infoWindow.info.runStatus | formatStatus}}</el-button>
                <el-button v-if="infoWindow.info.runStatus == '2'" type="info">{{infoWindow.info.runStatus | formatStatus}}</el-button>
              </div>
            </el-col>
          </el-row>
          <P class="infoHeader">实时数据:      {{infoWindow.info.captureTime}}</P>
          <el-row style="margin-top:6px;background-color: #779ECB">
            <el-col :span="6"><div class="info-content">监测因子</div></el-col>
            <el-col :span="6"><div class="info-content">监测值</div></el-col>
            <el-col :span="6"><div class="info-content">V类水标准</div></el-col>
            <el-col :span="6"><div class="info-content">单位</div></el-col>
          </el-row>
          <el-row style="margin-top:6px">
            <el-col :span="6"><div class="info-content">高猛酸盐指数</div></el-col>
            <el-col :span="6"><div class="info-content">{{infoWindow.info.gmsy}}</div></el-col>
            <el-col :span="6"><div class="info-content"><=15</div></el-col>
            <el-col :span="6"><div class="info-content">mg/L</div></el-col>
          </el-row>
          <el-row style="margin-top:6px">
            <el-col :span="6"><div class="info-content">总磷</div></el-col>
            <el-col :span="6"><div class="info-content">{{infoWindow.info.zl}}</div></el-col>
            <el-col :span="6"><div class="info-content"><=0.4</div></el-col>
            <el-col :span="6"><div class="info-content">mg/L</div></el-col>
          </el-row>
          <el-row style="margin-top:6px">
          <el-col :span="6"><div class="info-content">氨氮</div></el-col>
          <el-col :span="6"><div class="info-content">{{infoWindow.info.ad}}</div></el-col>
          <el-col :span="6"><div class="info-content"><=2</div></el-col>
          <el-col :span="6"><div class="info-content">mg/L</div></el-col>
          </el-row>
          <el-row style="margin-top:6px">
            <el-col :span="6"><div class="info-content">水温</div></el-col>
            <el-col :span="6"><div class="info-content">{{infoWindow.info.sw}}</div></el-col>
            <el-col :span="6"><div class="info-content"></div></el-col>
            <el-col :span="6"><div class="info-content">℃</div></el-col>
          </el-row>
          <el-row style="margin-top:6px">
          <el-col :span="6"><div class="info-content">PH</div></el-col>
          <el-col :span="6"><div class="info-content">{{infoWindow.info.ph}}</div></el-col>
          <el-col :span="6"><div class="info-content">6-9</div></el-col>
          <el-col :span="6"><div class="info-content">无量纲</div></el-col>
        </el-row>
          <el-row style="margin-top:6px">
            <el-col :span="6"><div class="info-content">溶解氧</div></el-col>
            <el-col :span="6"><div class="info-content">{{infoWindow.info.rjy}}</div></el-col>
            <el-col :span="6"><div class="info-content">>=2</div></el-col>
            <el-col :span="6"><div class="info-content">mg/L</div></el-col>
          </el-row>
          <el-row style="margin-top:6px">
            <el-col :span="6"><div class="info-content">氧化还原电位</div></el-col>
            <el-col :span="6"><div class="info-content">{{infoWindow.info.yhhydw}}</div></el-col>
            <el-col :span="6"><div class="info-content">>=50</div></el-col>
            <el-col :span="6"><div class="info-content">mV</div></el-col>
          </el-row>
        </div>
      </bm-info-window>
      <bm-control>
        <div class="layout-title">站点信息</div>
        <div class="info-window">
          <el-row>
            <el-col :span="24">
              <div >
                <div v-for="Cmarker of Cmarkers">
                  <div class="info-content">站名：{{Cmarker.siteName}}
                    <span v-if="Cmarker.runStatus == '1'" style="color: #67c23a;float: right;">{{Cmarker.runStatus | formatStatus}}</span>
                    <span v-if="Cmarker.runStatus == '2'" style="color: #8b8b8b;float: right;">{{Cmarker.runStatus | formatStatus}}</span>
                  </div>
                  <div class="info-content">点位类型: 河流断面</div>
                  <div class="info-content">水质目标: V类</div>
                  <div class="info-content">详细地址: {{Cmarker.address}}</div>
                  <br/>
                </div>
              </div>
            </el-col>
          </el-row>
        </div>
      </bm-control>

    </baidu-map>



</template>

<script>
  import {fetchList,getlalg} from '@/api/waterQuality'
  import BmlMarkerClusterer from "vue-baidu-map/components/extra/MarkerClusterer";
  export default {
    components: {BmlMarkerClusterer},
    data () {
      return {
        map: {
          center: { lng: 118.293328, lat: 33.945154 }, // '宿迁市',
          zoom: 12
        },
        show: false,
        Cmarkers: [],
        active: false,
        offLineNum:null,
        onLineNum:null,
        onLineRate:null,
        infoWindow: { // 站点信息窗口
          show: false,
          info: {
            latitude: '',
            longitude: '',
            id: ''
          }
        },
      }
    },
    filters:{
      formatStatus(flag){
        if(flag ==1){return "正常"}
        if(flag ==2){return "断线"}
        if(flag ==3){return "超标"}
      }
    },
    methods: {
      handler({ BMap, map }) {
        this.fetchList()
      },

      fetchList() {
        fetchList().then(res => {
          if (res.data.waterQualityInfoDtos.length > 0 || res.waterQualityInfoDtos.list !== undefined) {
            var cArr = []
            for (var i = 0; i < res.data.waterQualityInfoDtos.length; i++) {
                cArr.push(res.data.waterQualityInfoDtos[i])

            }
            this.Cmarkers= cArr
          } else {
            this.$message({
              message: '获取数据失败',
              type: 'error'
            })
          }
          this.offLineNum = res.data.siteRunStatus.offLineNum;
          this.onLineNum = res.data.siteRunStatus.onLineNum;
          this.onLineRate = res.data.siteRunStatus.onLineRate;
        })
      },
      searchAdress() {
        var adress = this.searchadress
        getlalg(adress).then(res => {
          if (res.code === 200) {
            var lg = res.data.longitude
            var la = res.data.latitude
            this.map.center.lng = lg
            this.map.center.lat = la
            this.map.zoom = 18
          } else {
            this.$message({
              message: '搜索失败',
              type: 'danger'
            })
          }
        })
      },
      // 关闭信息窗口
      infoWindowClose(cmarker) {
        this.infoWindow.show = false
      },
      // 打开信息窗口
      infoWindowOpen(cmarker) {
        this.infoWindow.show = true
      },
      getPosition(e) {
        this.$notify({
          title: '成功',
          message: '经纬度：'+ `（${e.point.lng} / ${e.point.lat}）`,
          type: 'success',
          duration: 0
        });
      },
      lookDetail(data){
        this.infoWindow.show = true
        this.infoWindow.info = data
        this.activeName = '站点信息'
        var that = this
        // 为弹窗口标题添加title
        this.$nextTick(() => {
          var win = document.querySelector('.BMap_bubble_title')
          win.title = that.activeName
        })
      }
    }
  }
</script>

<style>

  #map {
    width: 100%;
    height: 900px;
  }
  #searAdressBox{
    position:absolute;
    top:0 !important;
    right:0 !important;
    left: 0 !important;
    bottom:auto !important;
    z-index: 1000;
    width:100%;
    height:40px;
    line-height: 40px;
    background-color:rgba(0,0,0,0.1)
  }
  .controlBox{
    padding-left:100px;
    padding-right:20px;
    display: flex;
    justify-content: space-between;
  }
  .control_right{
    display: flex;
    margin-left: auto;
  }

  .searchText{
    color:#ff4f57;
    font-size: 15px;
    font-weight: 900;
  }
  .infoTitle{
    margin-top:0;
    border-top:1px solid #eeeeee;
  }
  .infoHeader{
    font-size: 14px;
    color:#666;
    border-bottom:1px solid #eeeeee;
  }
  .info-content{
    font-size: 14px;
    color:#666;
  }


  .layout-title {
    color: #52663a;
    padding: 15px 20px;
    background: #9bfafc;
    font-weight: bold;
    margin-top: 300px;
    margin-left: 100px;
  }
  .el-row{
    display:flex;
    flex-wrap: wrap;
  }
  .info-window{
    padding-right: 8px;
    width: 300px;
    overflow: auto;
    border: 1px solid #DCDFE6;
    margin-left: 100px;
    height: 300px;
    background: antiquewhite;
  }
  .info-window::-webkit-scrollbar{
    width: 6px;
    height: 1px;
  }
  .info-window::-webkit-scrollbar-thumb{
    border-radius: 6px;
    -webkit-box-shadow: inset 0 0 5px rgba(0,0,0,0.2);
    background: #535353;
  }
  .info-window::-webkit-scrollbar-track{
    -webkit-box-shadow: inset 0 0 5px rgba(0,0,0,0.2);
    border-radius: 6px;
    background: #EDEDED;
  }

</style>


