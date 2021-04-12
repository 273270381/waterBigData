<template>
  <div class="left-chart-1">
    <div class="dc-left">
    <dv-border-box-5>
      <div class="compare-value"><span>水位测站</span>12个</div>
      <div class="compare-value"><span>超警戒水位站</span>2个</div>
    </dv-border-box-5>
    <div class="dc-text">
      最高、最低水位站
      <dv-decoration-3 style="width:200px;height:20px;" />
    </div>
    </div>
    <div class="dc-right">
      <div class="dc-text">
        水情概述
        <dv-decoration-3 style="width:200px;height:20px;" />
      </div>
      <dv-border-box-5 :reverse="true">
        <div class="compare-value"><span>东沙河</span>18.31m</div>
        <div class="compare-value"><span>流沙河</span>12.31m</div>
      </dv-border-box-5>
    </div>
  </div>
</template>

<script>
export default {
  name: 'LeftChart1',
  data () {
    return {
    }
  }
}
</script>

<style lang="less">
.left-chart-1 {
  width: 100%;
  height: 37%;
  display: flex;

.lc1-header {
  text-align: center;
  height: 40px;
  display: flex;
  justify-content: center;
  align-items: center;
  font-size: 30px;
  margin-bottom: 20px;
}
.dc-left, .dc-right {
  width: 50%;
}
.lc1-details {
  height: 50px;
  font-size: 16px;
  display: flex;
  align-items: center;
  text-indent: 20px;

  span {
    color: #096dd9;
    font-weight: bold;
    font-size: 35px;
    margin-left: 20px;
  }
}

.lc1-chart {
  flex: 1;
}

.dv-border-box-5 {
  height: 60%;
}
.compare-value {
  height: 35px;
  line-height: 35px;
  font-size: 18px;

  span {
    margin-right: 30px;
  }
}
.dc-text {
  display: flex;
  flex-direction: column;
  height: 40%;
  font-size: 20px;
  padding: 20px;
  box-sizing: border-box;
}
.dc-left .dc-text {
  align-items: flex-end;
  justify-content: center;
}
.dc-right .dc-text {
  justify-content: flex-start;
  padding-top: 20px;
}

.dc-left .dv-border-box-5 {
  padding: 30px;
  box-sizing: border-box;
}

.dc-right .dv-border-box-5 {
  padding: 40px;
  padding-left: 75px;
  box-sizing: border-box;
}
}
</style>
