import {getToken,getCameraList,startPtz,stopPtz,mirror} from '@/api/video';
import EZUIKit from "ezuikit-js";
const defaultListQuery = {
  pageStart:'0',
  pageSize:'50'
};
const defaultPtz = {
  speed:2
}
const token = {
  appKey:'bec27f333fd04a95a352bec49d466754',
  appSecret:'d55a02b00c894303eedf279419d2bd94'
}
export default {
  data(){
    return{
      player:undefined,
      ptzParam:Object.assign({}, defaultPtz),
      listQuery: Object.assign({}, defaultListQuery),
      tokenParam: Object.assign({}, token),
      tabPosition: 'left',
      list:[],
      index:'',
      url:'',
      value: '',
      conheight:{
        height:''
      },
      vdo:{
        width:'',
        height:''
      }
    }
  },
  created(){
    window.addEventListener('resize', this.getHeight);
    this.getHeight();
    this.getToken();
  },
  methods:{
    cameraList(){
      getCameraList(this.listQuery).then(response =>{
        this.showOPInfo(response.msg,'d3')
        this.list = response.data;
        this.url = 'ezopen://open.ys7.com/'+this.list[0].deviceSerial+'/'+this.list[0].channelNo+'.live';
        this.ptzParam.deviceSerial = this.list[0].deviceSerial;
        this.ptzParam.channelNo = this.list[0].channelNo;
        this.init();
      })
    },
    getHeight(){
      this.conheight.height=window.innerHeight-120+'px';
      this.vdo.width = window.innerWidth-630+'px'
      this.vdo.height = this.conheight.height;
    },
    getToken(){
      getToken(this.tokenParam).then(response =>{
        this.showOPInfo(response.msg,'d3')
        this.listQuery.accessToken = response.data.accessToken;
        this.ptzParam.accessToken = response.data.accessToken;
        this.cameraList();
      }).catch((e) =>{});
    },
    init(){
      this.player =  new EZUIKit.EZUIKitPlayer({
        autoplay: false,
        id: "myPlayer",
        accessToken:this.listQuery.accessToken,
        url: this.url,
        template: "security"
      });
    },
    tabClick(tab,event){
      this.index = tab.index;
      this.url = 'ezopen://open.ys7.com/'+this.list[this.index].deviceSerial+'/'+this.list[this.index].channelNo+'.live';
      this.ptzParam.deviceSerial = this.list[this.index].deviceSerial;
      this.ptzParam.channelNo = this.list[this.index].channelNo;
      this.init();
      this.player.stop();
      $("#EZUIKitPlayer-myPlayer").remove();
    },
    start(direction){
      this.ptzParam.direction = direction;
        startPtz(this.ptzParam).then(response =>{
          this.showOPInfo(response.msg,'d3')
        }).catch((e) =>{});
    },
    stop(){
      stopPtz(this.ptzParam).then(r => {
        this.showOPInfo(response.msg,'d3')
      }).catch((e) =>{});
    },
    startmirror(index){
      const params = {
        accessToken:this.ptzParam.accessToken,
        deviceSerial:this.ptzParam.deviceSerial,
        channelNo:this.ptzParam.channelNo,
        command:index
      }
      mirror(params).then(response =>{
        this.showOPInfo(response.msg,'d3')
      })
    },
    showOPInfo(str,name){
      var div = document.createElement('DIV');
      div.className = name;
      div.innerHTML = JSON.stringify(str);
      document.getElementById('log').appendChild(div);
    }
  }
}
