import {formatDate} from '@/utils/date';
import {hydrologyStationList,areaList,deleteHydrologyStation} from '@/api/basicInfo'
const defaultListQuery = {
  pageSize: 10,
  pageNum: 1,
};
export default {
  data(){
    return{
      listQuery: Object.assign({}, defaultListQuery),
      list: null,
      total: null,
      listLoading: false,
      ids:[],
      multipleSelection: [],
      areaList:[],
      formInline: {
        areaName:"",
        stationName: '',
        code: ''
      }
    }
  },
  created(){
    this.getList();
    this.getAreaList();
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
      hydrologyStationList(this.listQuery).then(response => {
        this.listLoading = false;
        this.list = response.data.list;
        this.total = response.data.total;
      });
    },
    getAreaList(){
      areaList().then(response => {
        this.areaList = response.data.list;
        console.log(this.formInline.areaList)
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
    onSubmit() {
      this.listQuery.area = this.formInline.areaName;
      this.listQuery.stationName = this.formInline.stationName;
      this.listQuery.code = this.formInline.code;
      this.getList();
    },
    addStation(){
      console.log("add")
    },
    deleteStation(){
      if (this.ids.length > 0){
        this.$confirm('确认删除水文站点数据？','警告',{
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(()=> {
          return deleteHydrologyStation(this.ids);
        }).then(()=>{
          this.getList();
          this.$message({
            message: '删除成功',
            type: 'success'
          })
        })
      }
    },
    handleSelectionChange(val) {
      this.ids = val.map(item => item.ids);
    },
    handleDelete(index,row){
      this.$confirm('确认删除水文站点数据？','警告',{
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      }).then(()=> {
        return deleteHydrologyStation(row.ids);
      }).then(()=>{
        this.getList();
        this.$message({
          message: '删除成功',
          type: 'success'
        })
      })
    },
  }
}
