import Vue from 'vue'

import 'normalize.css/normalize.css'// A modern alternative to CSS resets

import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import locale from 'element-ui/lib/locale/lang/zh-CN' // lang i18n
import VCharts from 'v-charts'

import '@/styles/index.scss' // global css

import App from './App'
import router from './router'
import store from './store'

import '@/icons' // icon
import '@/permission' // permission control
import '@/styles/common.scss'
import '@/styles/basic.scss'
import BaiduMap from 'vue-baidu-map'

// 将自动注册所有组件为全局组件
import dataV from '@jiaminghi/data-view'

Vue.use(dataV)

Vue.use(ElementUI, { locale })
Vue.use(VCharts)

Vue.use(BaiduMap,{
  ak:'tGUHGt0juWbpMBjxv3IjEpfx7RsCopxB'
})

Vue.config.productionTip = false

new Vue({
  el: '#app',
  router,
  store,
  template: '<App/>',
  components: { App }
})