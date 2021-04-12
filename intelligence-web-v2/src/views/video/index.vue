<!--
<template>
  <div class="app-container tab-container">
    <div :style="conheight">
      <el-tabs :tab-position="tabPosition" @tab-click="tabClick" style="width: 200px;height: 100%;overflow-y:auto;overflow-x:hidden;">
        <el-tab-pane
          v-for="(item, index) in list"
          :key="item.channelNo+''"
          :label="item.channelName"
          :name="item.channelNo+''"
          >
        </el-tab-pane>
      </el-tabs>
    </div>
    <div class="video hello-ezuikit-js" :style="vdo">
      <div id="myPlayer" style="width:100%;height:100%"></div>
    </div>
    <div class="control">
      <span>云台</span>
      <el-divider></el-divider>
      <div class="d1">
        <div class="d2">
          <el-button size="mini" @mousedown.native="start(4)" @mouseup.native="stop">左上</el-button>
          <el-button size="mini" @mousedown.native="start(0)" @mouseup.native="stop">&nbsp;&nbsp;上&nbsp;&nbsp;</el-button>
          <el-button size="mini" @mousedown.native="start(6)" @mouseup.native="stop">右上</el-button>
        </div>
        <div class="d2">
          <el-button size="mini" @mousedown.native="start(2)" @mouseup.native="stop">&nbsp;&nbsp;左&nbsp;&nbsp;</el-button>
          <el-button size="mini" @mousedown.native="startmirror(0)" @mouseup.native="stop">自动</el-button>
          <el-button size="mini" @mousedown.native="start(3)" @mouseup.native="stop">&nbsp;&nbsp;右&nbsp;&nbsp;</el-button>
        </div>
        <div class="d2">
          <el-button size="mini" @mousedown.native="start(5)" @mouseup.native="stop">左下</el-button>
          <el-button size="mini" @mousedown.native="start(1)" @mouseup.native="stop">&nbsp;&nbsp;下&nbsp;&nbsp;</el-button>
          <el-button size="mini" @mousedown.native="start(7)" @mouseup.native="stop">右下</el-button>
        </div>
        <div class="d2">
          <el-button size="mini" @mousedown.native="start(8)" @mouseup.native="stop">变倍+</el-button>
          <el-button size="mini" @mousedown.native="start(9)" @mouseup.native="stop">变倍-</el-button>
        </div>
        <div class="d2">
          <el-button size="mini" @mousedown.native="start(10)" @mouseup.native="stop">变焦+</el-button>
          <el-button size="mini" @mousedown.native="start(11)" @mouseup.native="stop">变焦-</el-button>
        </div>
        <div id="log">

        </div>
        &lt;!&ndash;<el-tabs  type="card"  style="height: 30px;width: 100%">&ndash;&gt;
          &lt;!&ndash;<el-tab-pane label="预置点" name="first"></el-tab-pane>&ndash;&gt;
          &lt;!&ndash;<el-tab-pane label="巡航" name="second"></el-tab-pane>&ndash;&gt;
          &lt;!&ndash;<el-tab-pane label="扫描" name="third"></el-tab-pane>&ndash;&gt;
        &lt;!&ndash;</el-tabs>&ndash;&gt;
      </div>
    </div>
  </div>
</template>
<script src="./video.js"></script>

<style scoped>
  .el-menu-vertical-demo:not(.el-menu&#45;&#45;collapse) {
    width: 100px;
    min-height: 400px;
  }
  .tab-container{
    display: flex;
    width: 100%;
    height: 100%;
    justify-content: space-between;
  }
  .video{
    background-color: black;
  }
  .control{
    width: 200px;
  }
  .d1{
    margin-bottom: 0px;
  }
  .d2{
    display: flex;
    width: 100%;
    justify-content: space-between;
    flex-wrap: wrap;
    margin-bottom: 10px;
    align-content:center;
  }
  #log{
    position: fixed;
    border: 1px solid #DCDFE6;
    font-size: 13px;
    height: 51%;
    width: 14%;
  }
  /deep/ .el-tabs__item{
    padding: 0 18px;
    font-size: 12px;
    height: 30px;
  }
  /deep/ .el-icon-arrow-right:before{
    display: none;
  }
  /deep/ .el-icon-arrow-left:before{
    display: none;
  }
  /deep/.el-tabs&#45;&#45;card>.el-tabs__header .el-tabs__nav{
    width: 100%;
  }
</style>
-->
