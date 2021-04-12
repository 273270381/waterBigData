<template>
    <baidu-map id="map" :center="{lng: map.center.lng, lat: map.center.lat}" :zoom="map.zoom" @ready="handler" :scroll-wheel-zoom="true">
      <bm-navigation anchor="BMAP_ANCHOR_TOP_LEFT"></bm-navigation>
      <bm-map-type :map-types="['BMAP_NORMAL_MAP', 'BMAP_HYBRID_MAP']" anchor="BMAP_ANCHOR_BOTTOM_RIGHT"></bm-map-type>
      <bm-control id="searAdressBox">
        <div class="controlBox">
          <div class="control_right">
            <div>
              <span class="searchText">搜索站点：</span><el-input placeholder="请输入搜索站名"  @keyup.enter.native="searchAdress" style="width:200px" size="mini" v-model="searchadress"></el-input>
              <el-button type="primary" size="mini" @click="searchAdress" icon="el-icon-search">搜索</el-button>
            </div>
          </div>
        </div>
      </bm-control>

      <bml-marker-clusterer :averageCenter="true" :maxZoom="16">
        <bm-marker v-for="Cmarker of Cmarkers" :dragging="true" animation="BMAP_ANIMATION_BOUNCE"  :key="Cmarker.id" :title="Cmarker.stationName" :position="{lng: Cmarker.longitude, lat: Cmarker.latitude}">
          <bm-label :content="Cmarker.stationName + '<br/>'+'水位:15m'" :position="{lng: Cmarker.longitude, lat: Cmarker.latitude}" :offset="{width: -20, height: 30}" :labelStyle="{ fontSize : '24px'}"/>
          <bm-context-menu>
            <bm-context-menu-item :callback="getPosition" text="获取坐标"></bm-context-menu-item>
          </bm-context-menu>
        </bm-marker>
      </bml-marker-clusterer>

      <bm-control>
        <div class="layout-title">站点信息</div>
        <div class="info-window">
          <el-row>
            <el-col :span="24">
              <div >
                <div v-for="Cmarker of Cmarkers">
                  <div >站名：{{Cmarker.stationName}} <span style="color: #67c23a;float: right;">在线</span></div>
                  <div >水位:15m</div>
                  <div >详细地址:{{Cmarker.address}}</div>
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
  import { getCMarked,getlalg } from '@/api/waterMap';
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
        active: false
      }
    },

    methods: {
      handler({ BMap, map }) {
        this.getCMarked()
      },
      getCMarked() {
        getCMarked().then(res => {
          if (res.data.list.length > 0 || res.data.list !== undefined) {
            var cArr = []
            for (var i = 0; i < res.data.list.length; i++) {
                cArr.push(res.data.list[i])

            }
            this.Cmarkers= cArr
          } else {
            this.$message({
              message: '获取数据失败',
              type: 'error'
            })
          }
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
        this.show = false
      },
      // 打开信息窗口
      infoWindowOpen(cmarker) {
        this.show = true
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
    padding-left:170px;
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


  .layout-title {
    color: #52663a;
    padding: 15px 20px;
    background: #fc9a88;
    font-weight: bold;
    margin-top: 300px;
    margin-left: 100px;
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


