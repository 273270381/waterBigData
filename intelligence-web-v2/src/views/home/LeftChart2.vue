<template>
  <div class="left-chart-2">
    <dv-decoration-2 style="height:10px;" />
    <dv-border-box-6>
      <div class="table-name"><img src="./img/icon1.png" />实时报警</div>
      <dv-scroll-board :config="config" />
    </dv-border-box-6>
    <dv-decoration-2 style="height:10px;" />
  </div>
</template>

<script>

  import {fetchList} from '@/api/waterAlarm';
  import {formatDate} from '@/utils/date';

export default {
  name: 'LeftChart2',
  data () {
    return {
      listQuery: {
        pageNum: 1,
        pageSize: 10
      },
      data1:[],
      list: null,
      config: {
        header: ['站名', '报警时间', '报警参数', '参数数值'],
        data: [],
        index: true,
        columnWidth: [100, 100, 150],
        align: ['center'],
        rowNum: 7,
        headerBGC: '#159efc',
        headerHeight: 45,
        oddRowBGC: 'rgba(0, 44, 81, 0.8)',
        evenRowBGC: 'rgba(10, 29, 50, 0.8)'
      }
    }
  },
  created() {
    this.getList();
  },

  methods: {



    getList() {
      fetchList(this.listQuery).then(response => {
        this.list = response.data.list;
        for(let i=0;i<this.list.length;i++){
          this.list[i].alarmTime = formatDate(new Date(this.list[i].alarmTime),'yyyy-MM-dd hh:mm:ss')
          let result = [];
          result.push(this.list[i].stationName);
          result.push(this.list[i].alarmTime);
          result.push(this.list[i].alarmName);
          result.push(this.list[i].alarmValue);
          this.data1.push(result);
        }
        let nowData = this.config
        nowData.data = this.data1
        this.config = {...nowData}
      });
    }
  }
}
</script>

<style lang="less">
.left-chart-2 {
  width: 100%;
  height: 30%;
  display: flex;
  flex-direction: column;



  .lc2-header {
    text-align: center;
    height: 40px;
    display: flex;
    justify-content: center;
    align-items: center;
    font-size: 30px;
    margin-bottom: 20px;
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
}
</style>
