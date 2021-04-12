<template>
  <div class="center-cmp">
    <div class="cc-header">
      <dv-decoration-1 style="width:200px;height:50px;" />
      <div>站点分布</div>
      <dv-decoration-1 style="width:200px;height:50px;" />
    </div>

    <div class="cc-main-container">
      <baidu-map id="map" :center="{lng: map.center.lng, lat: map.center.lat}" :zoom="map.zoom" @ready="handler" :scroll-wheel-zoom="true" >
        <bm-marker v-for="Cmarker of Cmarkers" :icon="{url: '../../../static/images/wq.png', size: {width: 30, height: 30}}" :key="Cmarker.siteId" :title="Cmarker.siteName" :position="{lng: Cmarker.longitude, lat: Cmarker.latitude}">
          <bm-label :content="Cmarker.siteName" :position="{lng: Cmarker.longitude, lat: Cmarker.latitude}" :offset="{width: -20, height: 30}" :labelStyle="{ border : '1px solid rgb(0, 255, 31)' ,fontSize : '10px'}"/>
          <bm-context-menu>
            <bm-context-menu-item :callback="getPosition" text="获取坐标"></bm-context-menu-item>
          </bm-context-menu>
        </bm-marker>

        <bm-marker v-for="waterMarker of waterMarkers" :icon="{url: '../../../static/images/wl.png', size: {width: 30, height: 30}}" :key="waterMarker.id+'|'+waterMarker.id" :title="waterMarker.stationName" :position="{lng: waterMarker.longitude, lat: waterMarker.latitude}">
          <bm-label :content="waterMarker.stationName" :position="{lng: waterMarker.longitude, lat: waterMarker.latitude}" :offset="{width: -20, height: 30}" :labelStyle="{ fontSize : '10px'}"/>
          <bm-context-menu>
            <bm-context-menu-item :callback="getPosition" text="获取坐标"></bm-context-menu-item>
          </bm-context-menu>
        </bm-marker>
        <bm-control>
        <div class="layout-title">测站统计</div>
        <div class="info-window">
          <el-row>
            <el-col :span="24">
              <div >
                <div>
                  <div class="info-content" style="padding-top: 5px;color: #1e6abc">总测站点: {{sum}}个</div>
                  <div class="info-content" style="padding-top: 5px;color: #1e6abc">水位测点: {{wlNum}}个</div>
                  <div class="info-content" style="padding-top: 5px;color: #1e6abc">雨量测点: 0个</div>
                  <div class="info-content" style="padding-top: 5px;color: #1e6abc">水质测站: {{wqNum}}个</div>
                  <br/>
                </div>
              </div>
            </el-col>
          </el-row>
        </div>
        </bm-control>

        <bm-control id="searAdressBox">
          <div class="controlBox">
            <el-button style="padding-top: 5px">水位站 <img src="../../../static/images/wl.png" /> 水质测站 <img src="../../../static/images/wq.png" /></el-button>
          </div>
        </bm-control>
      </baidu-map>
    </div>
  </div>
</template>

<script>
import LabelTag from './LabelTag'
import {fetchList,getlalg} from '@/api/waterQuality';
import { getCMarked } from '@/api/waterMap';

export default {
  name: 'CenterCmp',
  components: {
    LabelTag
  },
  data () {
    return {
      map: {
        center: { lng: 118.293328, lat: 33.945154 }, // '宿迁市',
        zoom: 13
      },
      Cmarkers: [],
      waterMarkers:[],
      wlNum:0,
      wqNum:0,
      sum:0
    }
  },

  methods:{

    handler({ BMap, map }) {
      this.fetchList()
      this.getCMarked()
    },
    fetchList() {
      fetchList().then(res => {
        if (res.data.waterQualityInfoDtos.length > 0 || res.waterQualityInfoDtos.list !== undefined) {
          var cArr = []
          for (var i = 0; i < res.data.waterQualityInfoDtos.length; i++) {
            cArr.push(res.data.waterQualityInfoDtos[i])

          }
          this.Cmarkers= cArr
          this.wqNum =cArr.length;
          this.sum = this.sum + this.wqNum;
        } else {
          this.$message({
            message: '获取数据失败',
            type: 'error'
          })
        }
      })
    },
    getCMarked() {
      getCMarked().then(res => {
        if (res.data.list.length > 0 || res.data.list !== undefined) {
          var cArr = []
          for (var i = 0; i < res.data.list.length; i++) {
            cArr.push(res.data.list[i])

          }
          this.waterMarkers= cArr
          this.wlNum = cArr.length
          this.sum = this.sum + this.wlNum;
        } else {
          this.$message({
            message: '获取数据失败',
            type: 'error'
          })
        }
      })
    },
    getPosition(e) {
      this.$notify({
        title: '成功',
        message: '经纬度：'+ `（${e.point.lng} / ${e.point.lat}）`,
        type: 'success',
        duration: 0
      });
    }
  }
}
</script>

<style lang="less">

.center-cmp {
  width: 100%;
  height: 100%;
  margin: 0px;
  padding: 0px;
  display: flex;
  flex-direction: column;

  .cc-header {
    height: 70px;
    display: flex;
    justify-content: space-between;
    align-items: center;
    font-size: 30px;
  }

  .cc-main-container {
    position: relative;
    flex: 1;
    display: flex;
  }

}

#map {
  width: 100%;
  height: 100%;
  padding: 5px;
}
.layout-title {
  color: #303133;
  padding: 15px 20px;
  background: #159efc;
  font-weight: bold;
  margin-top: 100px;
  margin-left: 10px;
}
.info-window{
  padding-right: 8px;
  width: 120px;
  overflow: auto;
  border: 1px solid #159efc;
  margin-left: 10px;
  height: 120px;
  background: rgba(255,255,255,.5);
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
.info-content{
  font-size: 14px;
  color:#666;
}

#searAdressBox{
  position:absolute;
  top:0 !important;
  right:0 !important;
  left: 0 !important;
  bottom:auto !important;
  z-index: 1000;
  width:100%;
  height:50px;
  line-height: 50px;
  background-color:rgba(0,0,0,0.1)
}
.controlBox{
  padding-left:10px;
  padding-right:20px;
  display: flex;
  justify-content: space-between;
}
</style>
