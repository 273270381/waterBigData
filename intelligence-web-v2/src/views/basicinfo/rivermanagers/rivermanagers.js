import {formatDate} from '@/utils/date';
import {riverManagerList} from '@/api/basicInfo'
const defaultListQuery = {
  pageSize: 10,
  pageNum: 1,
};
export default {
  data(){
    return{
      formTitle:'管辖河道',
      formVisible: false,
      listQuery: Object.assign({}, defaultListQuery),
      list: null,
      total: null,
      listLoading: false,
      riverlist:[],
      formInline: {
        name:"",
        account:""
      }
    }
  },
  created(){
    this.getList();
  },
  methods:{
    getList() {
      this.listLoading = true;
      riverManagerList(this.listQuery).then(response => {
        this.listLoading = false;
        this.list = response.data.list;
        this.total = response.data.total;
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
    search(){
      this.listQuery.name = this.formInline.name;
      this.listQuery.account = this.formInline.account;
      this.getList();
    },
    refresh(){
      this.getList();
    },
    add(){
      console.log("add");
    },
    exported(){
      console.log("export");
    },
    handleClose(done) {
      this.$confirm('确认关闭？')
        .then(_ => {
          done();
        })
        .catch(_ => {});
    },
    handleRead(index,row){
      this.formVisible = true;
      this.riverlist = row.riverName;
      console.log(row)
      console.log(this.riverlist)
    }
  }
}
