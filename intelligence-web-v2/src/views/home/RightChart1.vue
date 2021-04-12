<template>
  <div class="right-chart-1">
    <div class="rc1-header">整体水质评价结果</div>

    <div class="rc1-chart-container">
      <div class="left">
        <dv-decoration-11 class="number" style="width:200px;height:60px;">中度污染</dv-decoration-11>

      </div>

      <div class="right">
        <div><span>主要污染指标:</span><dv-decoration-7 style="width:150px;height:30px;color: #fcb853">总磷、氨氮、高锰酸盐指数</dv-decoration-7></div>
      </div>


    </div>
  </div>
</template>

<script>
export default {
  name: 'RightChart1',
  data () {
    return {
    }
  }
}
</script>

<style lang="less">
.right-chart-1 {
  width: 100%;
  height: 100%;
  display: flex;
  flex-direction: column;

  .rc1-header {
    font-size: 24px;
    font-weight: bold;
    height: 30px;
    line-height: 30px;
  }

  .rc1-chart-container {
    flex: 1;
    display: flex;
  }

  .left {
    width: 30%;
    font-size: 16px;
    display: flex;
    flex-direction: column;
    justify-content: center;

    .number {
      font-size: 34px;
      color: #096dd9;
      font-weight: bold;
      margin-bottom: 30px;
    }
  }

  .right {
    flex: 1;
    padding-bottom: 20px;
    padding-right: 20px;
    box-sizing: border-box;
    margin-top: 90px;
    margin-left: 90px;
  }
}
</style>
