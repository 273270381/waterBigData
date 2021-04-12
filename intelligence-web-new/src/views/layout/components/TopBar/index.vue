<template>
<div>
  <div style="height: 10px;width: 378px;"></div>
<div style="width: 90px;height:90px;">

  <div class="title">
<!--
  <img src="../../../../assets/images/light_kuang.png" style="height: 50px">
-->
    <div style="margin-left: 30px;margin-top: 15px;position: absolute; background-image:-webkit-linear-gradient(bottom,#B0C4DE,#E6E6FA,white);
    -webkit-background-clip:text;
    -webkit-text-fill-color:transparent;">数据采集与分析系统
    </div>
  </div>

</div>

</div>
</template>

<script>
    export default {
        name: "TopBar",
      data(){
        return {
          backgroundDiv: {
            backgroundImage: 'url(' + require('../../../../assets/images/light_kuang.png') + ')'
          },
        }
      },
    }
</script>



<style>
.title{
  background:url("../../../../assets/images/light_kuang.png")no-repeat;
  background-size: contain;
  width: 378px;
  height: 60px;
  color: #1e6abc;
  margin: 0 auto;
  font-size: 25px;
}
.biaoti{


}



</style>
