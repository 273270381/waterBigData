import {formatDate} from '@/utils/date';
import {waterQualityStationList,areaList,dictInfoList,valleyList} from '@/api/basicInfo'
import {addAlarm} from '@/api/waterQualityAlarm'

const defaultListQuery = {
  pageSize: 10,
  pageNum: 1,
};
export default {
  data(){
    return{
      formTitle:'水文站点/新增',
      formVisible: false,
      listQuery: Object.assign({}, defaultListQuery),
      type_name:"站点类型",
      lever_name:"地区等级",
      list: null,
      total: null,
      listLoading: false,
      multipleSelection: [],
      areaList:[],
      valleyList:[],
      typeList:[],
      leverList:[],
      connenctList:[{key:"1",value:"是"},{key:"2",value:"否"}],
      statuList:[{key:"1",value:"正常"},{key:"2",value:"异常"}],
      time:'',
      formInline: {
        areaName: '',
        stationName: '',
        code: ''
      },
      form:{
        stationName:'',
        stationId:'',
        code:'',
        areaName:'',
        stationType:'',
        longitude:'',
        latitude:'',
        controLever:'',
        valley:'',
        sType:'',
        lever:'',
        isConnected:"",
        status:''
      }

    }
  },
  created() {
    this.getList();
    this.init();
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
  computed:{
    rules(){
      return{

      }
    }
  },
  methods:{
    getList() {
      this.listLoading = true;
      waterQualityStationList(this.listQuery).then(response => {
        this.listLoading = false;
        this.list = response.data.list;
        this.total = response.data.total;
      });
    },
    init(){
      areaList().then(response => {
        this.areaList = response.data.list;
      });
      dictInfoList(this.type_name).then(response => {
        this.typeList = response.data;
      });
      dictInfoList(this.lever_name).then(response => {
        this.leverList = response.data;
      });
      valleyList().then(response => {
        this.valleyList = response.data.list;
      });
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
    onSubmit() {
      this.listQuery.area = this.formInline.areaName;
      this.listQuery.stationName = this.formInline.stationName;
      this.listQuery.code = this.formInline.code;
      this.getList();
    },
    renderHeader(){
      return (<el-checkbox v-model="checked"></el-checkbox>);
    },
    addStation(){
      this.formVisible = true;
    },
    deleteStation(){
      console.log("delete")
    },
    handleSelectionChange(val) {
      this.multipleSelection = val;
    },
    handleClose(done) {
      this.$confirm('确认关闭？')
        .then(_ => {
          done();
        })
        .catch(_ => {});
    },
    save(){
      this.formVisible = false
    },
    cancel(){
      this.formVisible = false;
    }
  }
}
