import {formatDate} from '@/utils/date';
import {fetchList,stationList} from '@/api/waterQualityAlarm';
const defaultListQuery = {
  pageSize: 10,
  pageNum: 1,
};
const defaultParams = {
  pageSize: 15,
  pageNum: 1,
};
export default {
  data(){
    return{
      listQuery: Object.assign({}, defaultListQuery),
      stationParam:Object.assign({},defaultParams),
      list: null,
      total: null,
      listLoading: false,
      options: [{
        value1: '选项1',
        alarmType: '数据报警'
      }, {
        value1: '选项2',
        alarmType: '设备报警'
      }, {
        value1: '选项3',
        alarmType: '断线报警'
      }],
      options2:[],

      pickerOptions: {
        shortcuts: [{
          text: '最近一周',
          onClick(picker) {
            const end = new Date();
            const start = new Date();
            start.setTime(start.getTime() - 3600 * 1000 * 24 * 7);
            picker.$emit('pick', [start, end]);
          }
        }, {
          text: '最近一个月',
          onClick(picker) {
            const end = new Date();
            const start = new Date();
            start.setTime(start.getTime() - 3600 * 1000 * 24 * 30);
            picker.$emit('pick', [start, end]);
          }
        }, {
          text: '最近三个月',
          onClick(picker) {
            const end = new Date();
            const start = new Date();
            start.setTime(start.getTime() - 3600 * 1000 * 24 * 90);
            picker.$emit('pick', [start, end]);
          }
        }]
      },
      alarmType:'',
      stationName: '',
      time: '',
      startTime:"",
      endTime:"",
    }
  },
  created(){
    this.getList();
    this.getStationList();
  },
  filters: {
    formatDateTime(time) {
      if (time == null || time === '') {
        return 'N/A';
      }
      let date = new Date(time);
      return formatDate(date, 'yyyy-MM-dd hh:mm:ss')
    }
  },
  methods:{
    getList() {
      this.listLoading = true;
      fetchList(this.listQuery).then(response => {
        this.listLoading = false;
        this.list = response.data.list;
        this.total = response.data.total;
      });
    },
    searchData(){
      this.listQuery.stationName = this.stationName;
      this.listQuery.alarmType = this.alarmType;
      if (this.time != null && this.time != ''){
        this.listQuery.startTime = formatDate(this.time[0],'yyyy-MM-dd');
        this.listQuery.endTime = formatDate(this.time[1],'yyyy-MM-dd');
      }else {
        this.listQuery.startTime = this.startTime;
        this.listQuery.endTime = this.endTime;
      }
      this.getList();
    },
    getStationList(){
      stationList(this.stationParam).then(response =>{
        this.options2 = response.data.list;
      })
    },
    handleSizeChange(val) {
      this.listQuery.pageNum = 1;
      this.listQuery.pageSize = val;
      this.getList();
    },
    handleCurrentChange(val) {
      this.listQuery.pageNum = val;
      this.getList();
    },
  }
}
