import {countList} from '@/api/waterQualityAlarm';
import {formatDate} from '@/utils/date';

const defaultListQuery = {

};
export default {
  data(){
    return{
      listQuery: Object.assign({}, defaultListQuery),
      list: [],
      total: null,
      listLoading: false,
      areaName:"",
      radio:'区域',
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
      time: '',
      startTime:"",
      endTime:""
    }
  },
  created(){
    this.getCountList();
  },
  methods:{
    getCountList(){
      this.listLoading = true;
      countList(this.listQuery).then(response => {
        this.listLoading = false;
        this.list = response.data.list;
        this.total = response.data.total;
      })
    },
    searchData(){
      this.areaName = this.radio;
      this.listQuery.areaName = this.areaName;
      if (this.time != null && this.time != ''){
        this.listQuery.startTime = formatDate(this.time[0],'yyyy-MM-dd');
        this.listQuery.endTime = formatDate(this.time[1],'yyyy-MM-dd');
      }else {
        this.listQuery.startTime = this.startTime;
        this.listQuery.endTime = this.endTime;
      }
      this.getCountList();
    }
  }
}
