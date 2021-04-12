<template>
  <div class="left-chart-3">
    <dv-border-box-6>
      <div class="table-name">
        <img src="./img/icon3.png" />雨情信息
      </div>

      <dv-scroll-ranking-board :config="config" />
    </dv-border-box-6>
  </div>
</template>

<script>
  import {fetchList} from '@/api/waterReport'
export default {
  name: 'LeftChart3',
  data () {
    return {
      list: null,
      listQuery: {
        pageNum: 1,
        pageSize: 10
      },
      code:"YL",
      config: {
        data: [],
        rowNum: 5
      }
    }
  },
  created() {
    this.getList();
  },
  methods: {

    getList() {
      fetchList(this.code, this.listQuery).then(response => {
        this.list = response.data.list;
        let list_map = [];
        for ( let i = 0; i < this.list.length; i++) {
          list_map.push({name:this.list[i].stationName,value:this.list[i].rainValue});
        }
        let nowData = this.config
        nowData.data = list_map
        this.config = {...nowData}
      });
    }
  }
}
</script>

<style lang="less">
.left-chart-3 {
  width: 100%;
  height: 33%;
  display: flex;
  flex-direction: column;

  .lc3-header {
    text-align: center;
    height: 40px;
    display: flex;
    justify-content: center;
    align-items: center;
    font-size: 30px;
    margin-bottom: 20px;
  }

  .lc3-details {
    height: 40px;
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
  .table-name {
    height: 45px;
    display: flex;
    justify-content: center;
    align-items: center;
    margin-bottom: 15px;

    img {
      width: 40px;
      height: 40px;
      margin-right: 5px;
    }
  }
  .lc3-chart {
    flex: 1;
  }
}
</style>
