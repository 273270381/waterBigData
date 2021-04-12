<template>
  <div class="bottom-charts">
    <div class="bc-chart-item">
      <div class="bcci-header">实时动态</div>
      <dv-active-ring-chart :config="config1" />
      <Label-Tag :config="labelConfig" />
    </div>
    <dv-decoration-2 class="decoration-1" :reverse="true" style="width:5px;" />

    <div class="bc-chart-item">
      <div class="bcci-header">事件统计</div>
      <dv-charts :option="option" />
    </div>

    <dv-decoration-2 class="decoration-2" :reverse="true" style="width:5px;" />

    <div class="bc-chart-item2">
      <div class="bcci-header">水质站点列表</div>
      <dv-border-box-6>
        <dv-scroll-board :config="config" />
      </dv-border-box-6>

    </div>


  </div>
</template>

<script>
import LabelTag from './LabelTag'
import {fetchList} from '@/api/waterQuality'

export default {
  name: 'BottomCharts',
  components: {
    LabelTag
  },
  data () {
    return {
      list: null,
      config1: {
        data: [
          {
            name: '正在巡河',
            value: 22
          },
          {
            name: '今日完成',
            value: 22
          },
          {
            name: '今日事件',
            value: 22
          },
          {
            name: '在线人数',
            value: 22
          }
        ],
        color: ['#00baff', '#3de7c9', '#fff', '#ffc530', '#469f4b'],
        radius: '65%',
        activeRadius: '70%',
        showOriginValue: true
      },

      option: {
        legend: {
          data: [
            {
              name: '已完成',
              color: '#f5d94e'
            },
            {
              name: '待审核',
              color: '#ff5ca9'
            },
            {
              name: '未处理',
              color: '#3de7c9'
            }
          ],
          textStyle: {
            fill: '#fff'
          }
        },
        xAxis: {
          data: [
            '10/01', '10/02', '10/03', '10/04', '10/05', '10/06', '10/07'
          ],
          axisLine: {
            style: {
              stroke: '#999'
            }
          },
          axisLabel: {
            style: {
              fill: '#999'
            }
          },
          axisTick: {
            show: false
          }
        },
        yAxis: {
          data: 'value',
          splitLine: {
            show: false
          },
          axisLine: {
            style: {
              stroke: '#999'
            }
          },
          axisLabel: {
            style: {
              fill: '#999'
            }
          },
          axisTick: {
            show: false
          },
          min: 0,
          max: 10
        },
        series: [
          {
            data: [
              0.2, 1.2, 4.2, 4.2, 5.2, 4.2, 0.2
            ],
            type: 'line',
            name: '已完成',
            lineArea: {
              show: true,
              gradient: ['rgba(245, 217, 79, 0.8)', 'rgba(245, 217, 79, 0.2)']
            },
            lineStyle: {
              stroke: '#f5d94e'
            },
            linePoint: {
              radius: 4,
              style: {
                fill: '#f5d94e',
                stroke: 'transparent'
              }
            },
            label: {
              show: true
            }
          },
          {
            name: '待审核',
            data: [
              2.5, 3.5, 6.5, 6.5, 7.5, 6.5, 2.5
            ],
            type: 'line',
            lineStyle: {
              stroke: '#ff5ca9'
            },
            linePoint: {
              radius: 4,
              style: {
                fill: '#ff5ca9',
                stroke: 'transparent'
              }
            },
            label: {
              show: true
            }
          },
          {
            name: '未处理',
            data: [
              1.3, 2.3, 5.3, 5.3, 6.3, 5.3, 1.3
            ],
            type: 'line',
            smooth: true,
            lineArea: {
              show: true,
              gradient: ['rgba(55, 162, 218, 0.6)', 'rgba(55, 162, 218, 0)']
            },
            lineStyle: {
              lineDash: [5, 5]
            },
            linePoint: {
              radius: 4,
              style: {
                fill: '#00db95'
              }
            },
            label: {
              show: true
            }
          }
        ]
      },

      config: {
        header: ['站点', '监测时间', '区域', '流域','运行状态'],
        data: [],
        index: true,
        columnWidth: [50, 100, 150],
        align: ['center'],
        rowNum: 7,
        headerBGC: '#159efc',
        headerHeight: 45,
        oddRowBGC: 'rgba(0, 44, 81, 0.8)',
        evenRowBGC: 'rgba(10, 29, 50, 0.8)'
      },
      labelConfig: {
        data: ['正在巡河', '今日完成', '今日事件', '在线人数']
      },
      data1:[]
    }
  },
  created() {
    this.getList();
  },
  methods: {
    formatStatus(flag){
      if(flag ==1){return "正常"}
      if(flag ==2){return "断线"}
      if(flag ==3){return "超标"}
    },
    getList() {
      fetchList().then(response => {
        this.list = response.data.waterQualityInfoDtos;
        for(let i=0;i<this.list.length;i++){
          let result = [];
          result.push(this.list[i].siteName);
          result.push(this.list[i].captureTime);
          result.push(this.list[i].regionName);
          result.push(this.list[i].valleyName);
          result.push(this.formatStatus(this.list[i].runStatus));
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
.bottom-charts {
  width: 100%;
  height: 100%;
  display: flex;
  position: relative;

  .bc-chart-item {
    width: 25%;
    height: 100%;
    padding-top: 20px;
    box-sizing: border-box;
  }


  .bc-chart-item2 {
    width: 50%;
    height: 100%;
    box-sizing: border-box;
  }

  .bcci-header {
    height: 30px;
    text-align: center;
    line-height: 50px;
    font-size: 15px;
  }

  .dv-active-ring-chart {
    height: calc(~"100% - 80px");
  }

  .label-tag {
    height: 30px;
  }

  .active-ring-name {
    font-size: 18px !important;
  }

  .decoration-1, .decoration-2, .decoration-3 {
    display: absolute;
    left: 0%;
  }

}
</style>
