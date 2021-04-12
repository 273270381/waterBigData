import {formatDate,handleTree,addDateRange} from '@/utils/date';
import {getRiverArea,getPatrolData} from '@/api/riverPatrol'
import {dictInfoList} from '@/api/basicInfo'
import {unzip} from '@/utils/stringCompress'
import newPolyline from "./new-polyline";
export default {
  components: {
    newPolyline
  },
  name: "riverpatroldata",
  data(){
    return{
      startPoint:{lng:0,lat:0},
      endPoint:{lng:0,lat:0},
      polylinePath:[],
      latlng:{lng:0,lat:0},
      zoom:9,
      formVisible: false,
      loading: true,
      ids: [],
      total: 0,
      riverArea:undefined,
      name:'',
      statusOptions: [],
      dateRange: [],
      dataList:[],
      icons:[],
      status:'巡河状态',
      defaultProps: {
        children: "children",
        label: "name"
      },
      queryParams: {
        areaId:undefined,
        pageNum: 1,
        pageSize: 10,
        startTime: undefined,
        endTime: undefined,
        name: undefined,
        status: undefined,
      },
    }
  },
  watch:{
    name(val){
      this.$refs.tree.filter(val);
    }
  },
  created(){
    this.getList();
    this.getTreeselect();
    this.getDicts();
  },
  filters:{
    formatDateTime(time) {
      if (time == null || time === '') {
        return 'N/A';
      }
      let date = new Date(time);
      return formatDate(date, 'yyyy-MM-dd hh:mm:ss')
    },
    formatDurationTime(startTime,endTime){
      var duration = new Date(endTime).getTime() - new Date(startTime).getTime();
      var minutes = Math.floor(duration/(1000*60));
      return minutes;
    }
  },
  methods:{
    getList(){
      this.loading = true;
      getPatrolData(addDateRange(this.queryParams,this.dateRange)).then(r => {
        this.dataList = r.data.list;
        this.total = r.data.total;
        this.loading = false;
      })
    },
    getTreeselect(){
      getRiverArea().then(r =>{
        this.riverArea = r.data;
      });
    },
    getDicts(){
      dictInfoList(this.status).then(r =>{
        this.statusOptions = r.data;
      })
    },
    filterNode(value, data){
      if (!value) return true;
      return data.name.indexOf(value) !== -1;
    },
    handleNodeClick(data) {
      this.queryParams.areaId = data.id;
      this.getList();
    },
    handleQuery() {
      this.queryParams.page = 1;
      this.getList();
    },
    handleSizeChange(val) {
      this.queryParams.pageNum = 1;
      this.queryParams.pageSize = val;
      this.getList();
    },
    handleCurrentChange(val) {
      this.queryParams.pageNum = val;
      this.getList();
    },
    readRedit(index,row){
      this.formVisible = true;
      this.trackPoints = JSON.parse(unzip(row.trackPoints));
    },
    deleteRedit(){
      this.$confirm('确认删除巡河记录？','警告',{
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      }).then(()=> {

      }).then(()=>{
        this.getList();
        this.$message({
          message: '删除成功',
          type: 'success'
        })
      })
    },
    handleClose(done) {
      this.$confirm('确认关闭？')
        .then(_ => {
          done();
        })
        .catch(_ => {});
    },
    handler ({BMap, map}){
      var mapIcon = new BMap.Symbol(BMap_Symbol_SHAPE_BACKWARD_OPEN_ARROW,{
        scale: 0.6,//图标缩放大小
        strokeColor: '#ffffff', //设置矢量图标线填充颜色
        strokeWeight: '2' //设置线宽
      });
      var icon = new BMap.IconSequence(mapIcon,'100%','10%');
      this.icons.push(icon);

      this.endPoint.lng = this.trackPoints[this.trackPoints.length-1].longitude;
      this.endPoint.lat = this.trackPoints[this.trackPoints.length-1].latitude;
      this.startPoint.lng = this.trackPoints[0].longitude;
      this.startPoint.lat = this.trackPoints[0].latitude;
      this.zoom = 18;
      for (var i = 0 ; i < this.trackPoints.length ; i++){
        this.polylinePath.push({lng:this.trackPoints[i].longitude,lat:this.trackPoints[i].latitude});
      };
    }
  }
}
