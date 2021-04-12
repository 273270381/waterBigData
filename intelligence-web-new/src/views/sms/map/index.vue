<template>
    <baidu-map id="map" :center="{lng: map.center.lng, lat: map.center.lat}" :zoom="map.zoom" @ready="handler" :scroll-wheel-zoom="true">
      <bm-navigation anchor="BMAP_ANCHOR_TOP_LEFT"></bm-navigation>
      <bm-map-type :map-types="['BMAP_NORMAL_MAP', 'BMAP_HYBRID_MAP']" anchor="BMAP_ANCHOR_BOTTOM_RIGHT"></bm-map-type>
      <bm-control id="searAdressBox">
        <div class="controlBox">
          <div class="control_left">
            <div>
              <el-checkbox class="iconcommon check" >显示水位站点</el-checkbox>
              <el-checkbox class="iconcommon check" >显示雨量站点</el-checkbox>
              <el-checkbox class="iconcommon check" >显示积水点站点</el-checkbox>
            </div>
          </div>
          <div class="control_right">
            <div>
              <span class="searchText">搜索站点：</span><el-input placeholder="请输入搜索地址"  style="width:200px" size="mini" ></el-input>
              <el-button type="primary" size="mini"  icon="el-icon-search">搜索</el-button>
            </div>
            <div style="margin-left:10px;"><i  class="iconcommon iconfont icon-zhankai1" title="展开"></i></div>
          </div>
        </div>
      </bm-control>
      <div v-for="Cmarker of Cmarkers" :key="Cmarker.id" :title="Cmarker.stationName" >
        <bm-marker :dragging="true" animation="BMAP_ANIMATION_BOUNCE" :position="{lng: Cmarker.longitude, lat: Cmarker.latitude}" @click="infoWindowOpen(Cmarker)" >
          <bm-info-window  title="站点信息" :show="show" @close="infoWindowClose(Cmarker)" @open="infoWindowOpen(Cmarker)" :position="{lng: Cmarker.longitude, lat: Cmarker.latitude}">
            <div class="infoTitle">
              <el-row>
                <el-col :span="16"><div class="info-content">名称：{{Cmarker.stationName}}</div></el-col>
              </el-row>
              <el-row>
                <el-col :span="16"><div class="info-content">地址：{{Cmarker.address}}</div></el-col>
              </el-row>
            </div>
          </bm-info-window>
          <bm-context-menu>
            <bm-context-menu-item :callback="getPosition" text="获取坐标"></bm-context-menu-item>
          </bm-context-menu>
        </bm-marker>
      </div >


    </baidu-map>



</template>

<script>
  import { getCMarked } from '@/api/waterMap';
  export default {
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
      // 关闭信息窗口
      infoWindowClose(cmarker) {
        this.show = false
      },
      // 打开信息窗口
      infoWindowOpen(cmarker) {
        this.show = true
      },
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
  .control_left{
    display: flex;
  }
  .check{
    position: relative;
    bottom:7px;
  }
  .control_right{
    display: flex;
  }
  .iconcommon{
    color: #ff4f57;
    font-size: 30px;
    margin-right:20px;
    cursor: pointer;
    font-weight: 900;
  }
  .searchText{
    color:#ff4f57;
    font-size: 15px;
    font-weight: 900;
  }

  .infoTitle {
    margin-top: 0;
    border-top: 1px solid #eeeeee;
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



</style>


