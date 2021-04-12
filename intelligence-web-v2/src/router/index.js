import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

/* Layout */
import Layout from '../views/layout/Layout'

/**
 * hidden: true                   if `hidden:true` will not show in the sidebar(default is false)
 * alwaysShow: true               if set true, will always show the root menu, whatever its child routes length
 *                                if not set alwaysShow, only more than one route under the children
 *                                it will becomes nested mode, otherwise not show the root menu
 * redirect: noredirect           if `redirect:noredirect` will no redirct in the breadcrumb
 * name:'router-name'             the name is used by <keep-alive> (must set!!!)
 * meta : {
    title: 'title'               the name show in submenu and breadcrumb (recommend set)
    icon: 'svg-name'             the icon show in the sidebar,
  }
 **/
export const constantRouterMap = [
  {path: '/login', component: () => import('@/views/login/index'), hidden: true},
  {path: '/404', component: () => import('@/views/404'), hidden: true},
  {
    path: '',
    component: Layout,
    redirect: '/home',
    children: [{
      path: 'home',
      name: 'home',
      component: () => import('@/views/home/index'),
      meta: {title: '首页', icon: 'home'}
    }]
  }
]

export const asyncRouterMap = [
  {
    path: '/pms',
    component: Layout,
    redirect: '/pms/product',
    name: 'pms',
    meta: {title: '商品', icon: 'product'},
    children: [{
      path: 'product',
      name: 'product',
      component: () => import('@/views/pms/product/index'),
      meta: {title: '商品列表', icon: 'product-list'}
    },
      {
        path: 'addProduct',
        name: 'addProduct',
        component: () => import('@/views/pms/product/add'),
        meta: {title: '添加商品', icon: 'product-add'}
      },
      {
        path: 'updateProduct',
        name: 'updateProduct',
        component: () => import('@/views/pms/product/update'),
        meta: {title: '修改商品', icon: 'product-add'},
        hidden: true
      },
      {
        path: 'productCate',
        name: 'productCate',
        component: () => import('@/views/pms/productCate/index'),
        meta: {title: '商品分类', icon: 'product-cate'}
      },
      {
        path: 'addProductCate',
        name: 'addProductCate',
        component: () => import('@/views/pms/productCate/add'),
        meta: {title: '添加商品分类'},
        hidden: true
      },
      {
        path: 'updateProductCate',
        name: 'updateProductCate',
        component: () => import('@/views/pms/productCate/update'),
        meta: {title: '修改商品分类'},
        hidden: true
      },
      {
        path: 'productAttr',
        name: 'productAttr',
        component: () => import('@/views/pms/productAttr/index'),
        meta: {title: '商品类型', icon: 'product-attr'}
      },
      {
        path: 'productAttrList',
        name: 'productAttrList',
        component: () => import('@/views/pms/productAttr/productAttrList'),
        meta: {title: '商品属性列表'},
        hidden: true
      },
      {
        path: 'addProductAttr',
        name: 'addProductAttr',
        component: () => import('@/views/pms/productAttr/addProductAttr'),
        meta: {title: '添加商品属性'},
        hidden: true
      },
      {
        path: 'updateProductAttr',
        name: 'updateProductAttr',
        component: () => import('@/views/pms/productAttr/updateProductAttr'),
        meta: {title: '修改商品属性'},
        hidden: true
      },
      {
        path: 'brand',
        name: 'brand',
        component: () => import('@/views/pms/brand/index'),
        meta: {title: '品牌管理', icon: 'product-brand'}
      },
      {
        path: 'addBrand',
        name: 'addBrand',
        component: () => import('@/views/pms/brand/add'),
        meta: {title: '添加品牌'},
        hidden: true
      },
      {
        path: 'updateBrand',
        name: 'updateBrand',
        component: () => import('@/views/pms/brand/update'),
        meta: {title: '编辑品牌'},
        hidden: true
      }
    ]
  },
  {
    path: '/oms',
    component: Layout,
    redirect: '/oms/waterlevelchart',
    name: 'oms',
    meta: {title: '历史数据', icon: 'order'},
    children: [
      {
        path: 'waterlevelchart',
        name: 'waterlevelchart',
        component: () => import('@/views/oms/history/waterLevelChart'),
        meta: {title: '水位时段图', icon: 'product-list'}
      },
      {
        path: 'rainlevelchart',
        name: 'rainlevelchart',
        component: () => import('@/views/oms/history/rainLevelChart'),
        meta: {title: '雨量时段图',icon: 'product-list'},
        hidden:true
      },
      {
        path: 'waterqualityquery',
        name: 'waterqualityquery',
        component: () => import('@/views/oms/history/waterQualityQuery'),
        meta: {title: '数据查询',icon: 'product-list'},
        hidden:true
      },
      {
        path: 'waterqualityevaluation',
        name: 'waterqualityevaluation',
        component: () => import('@/views/oms/evaluation/index'),
        meta: {title: '水质评价',icon: 'product-list'},
        hidden:true
      },
      {
        path: 'riverpatroldata',
        name: 'riverpatroldata',
        component: () => import('@/views/oms/riverpatroldata/index'),
        meta: {title: '巡河记录',icon: 'product-list'},
        hidden:true
      }
    ]
  },
  {
    path:'/sms',
    component: Layout,
    redirect: '/sms/map',
    name: 'sms',
    meta: {title: '实时数据', icon: 'table'},
    children: [
      {
        path: 'map',
        name: 'map',
        component: () => import('@/views/sms/map/index'),
        meta: {title: '水文地图', icon: 'table'}
      },
      {
        path: 'report',
        name: 'report',
        component: () => import('@/views/sms/report/index'),
        meta: {title: '水文报表'},
        hidden:true
      },
      {
        path: 'waterqualityreport',
        name: 'waterqualityreport',
        component: () => import('@/views/sms/waterquality/index'),
        meta: {title: '水质报表'},
        hidden:true
      },
      {
        path: 'waterqualitymap',
        name: 'waterqualitymap',
        component: () => import('@/views/sms/waterquality/map/index'),
        meta: {title: '水质地图'},
        hidden:true
      }
    ]
  },

  {
    path:'/bms',
    component: Layout,
    redirect: '/bms/waterlevel',
    name: 'bms',
    meta: {title: '报表管理', icon: 'sms'},
    children: [
      {
        path: 'waterlevel',
        name: 'waterlevel',
        component: () => import('@/views/bms/waterLevel/index'),
        meta: {title: '水位报表', icon: 'sms-flash'}
      },

      {
        path: 'rainlevel',
        name: 'rainlevel',
        component: () => import('@/views/bms/rainLevel/index'),
        meta: {title: '雨量报表', icon: 'sms-flash'}
      },

    {
        path: 'waterqualitysglreport',
        name: 'waterqualitysglreport',
      component: () => import('@/views/bms/waterqualitysglreport/index'),
      meta: {title: '水质单站报表', icon: 'sms-flash'}
    },
    {
      path: 'waterqualitycomreport',
        name: 'waterqualitycomreport',
      component: () => import('@/views/bms/waterqualitycomreport/index'),
      meta: {title: '水质综合报表', icon: 'sms-flash'}
    },
    ]
  },
  {
    path:'/alarm',
    component:Layout,
    redirect:'/alarm/manage',
    name: 'alarm',
    meta: {title: '报警信息', icon :'alarm'},
    children: [
      {
        path: 'manage',
        name: 'manage',
        component: () => import('@/views/alarm/waterquality/manage/index'),
        meta: {title: '水质报警管理', icon: 'alarm'}
      },
      {
        path: 'count',
        name: 'count',
        component: () => import('@/views/alarm/waterquality/count/index'),
        meta: {title: '水质报警统计', icon: 'alarm'}
      },
      {
        path: 'waterrealalarm',
        name: 'waterrealalarm',
        component: () => import('@/views/alarm/water/real/index'),
        meta: {title: '水文实时报警', icon: 'alarm'}
      },
      {
        path: 'waterhistoryalarm',
        name: 'waterhistoryalarm',
        component: () => import('@/views/alarm/water/history/index'),
        meta: {title: '水文历史报警', icon: 'alarm'}
      }
    ]
  },
  {
    path:'/basicinfo',
    component:Layout,
    redirect:'/basicinfo/station',
    name:'basicinfo',
    meta: {title:'基础信息',icon:'alarm'},
    children:[
      {
        path:'station',
        name:'station',
        component: () => import("@/views/basicinfo/station/index"),
        meta :{title: "站点管理", icon:'alarm'}
      },
      {
        path:'area',
        name:'area',
        component: () => import("@/views/basicinfo/area/index"),
        meta :{title: "行政区划", icon:'alarm'}
      },
      {
        path:'drainagearea',
        name:'drainagearea',
        component: () => import("@/views/basicinfo/drainagearea/index"),
        meta :{title: "流域管理", icon:'alarm'}
      },
      {
        path:'watercategory',
        name:'watercategory',
        component: () => import("@/views/basicinfo/watercategory/index"),
        meta :{title: "水质类别", icon:'alarm'}
      },
      {
        path:'waterfeatures',
        name:'waterfeatures',
        component: () => import("@/views/basicinfo/waterfeatures/index"),
        meta :{title: "水功能区", icon:'alarm'}
      },
      {
        path:'rivers',
        name:'rivers',
        component: () => import("@/views/basicinfo/rivers/index"),
        meta :{title: "河湖名录", icon:'alarm'}
      },
      {
        path:'revermanagers',
        name:'revermanagers',
        component: () => import("@/views/basicinfo/rivermanagers/index"),
        meta :{title: "河长名录", icon:'alarm'}
      },
    ]
  },
  {
    path: '',
    component: Layout,
    redirect: '/video',
    children: [{
      path: 'video',
      name: 'video',
      component: () => import('@/views/video/index'),
      meta: {title: '视频列表', icon: 'alarm'}
    }]
  },
  {
    path:'/ums',
    component: Layout,
    redirect: '/ums/admin',
    name: 'ums',
    meta: {title: '权限', icon: 'ums'},
    children: [
      {
        path: 'admin',
        name: 'admin',
        component: () => import('@/views/ums/admin/index'),
        meta: {title: '用户列表', icon: 'ums-admin'}
      },
      {
        path: 'role',
        name: 'role',
        component: () => import('@/views/ums/role/index'),
        meta: {title: '角色列表', icon: 'ums-role'}
      },
      {
        path: 'allocMenu',
        name: 'allocMenu',
        component: () => import('@/views/ums/role/allocMenu'),
        meta: {title: '分配菜单'},
        hidden: true
      },
      {
        path: 'allocResource',
        name: 'allocResource',
        component: () => import('@/views/ums/role/allocResource'),
        meta: {title: '分配资源'},
        hidden: true
      },
      {
        path: 'menu',
        name: 'menu',
        component: () => import('@/views/ums/menu/index'),
        meta: {title: '菜单列表', icon: 'ums-menu'}
      },
      {
        path: 'addMenu',
        name: 'addMenu',
        component: () => import('@/views/ums/menu/add'),
        meta: {title: '添加菜单'},
        hidden: true
      },
      {
        path: 'updateMenu',
        name: 'updateMenu',
        component: () => import('@/views/ums/menu/update'),
        meta: {title: '修改菜单'},
        hidden: true
      },
      {
        path: 'resource',
        name: 'resource',
        component: () => import('@/views/ums/resource/index'),
        meta: {title: '资源列表', icon: 'ums-resource'}
      },
      {
        path: 'resourceCategory',
        name: 'resourceCategory',
        component: () => import('@/views/ums/resource/categoryList'),
        meta: {title: '资源分类'},
        hidden: true
      }
    ]
  },
  {path: '*', redirect: '/404', hidden: true}
]

export default new Router({
  // mode: 'history', //后端支持可开
  scrollBehavior: () => ({y: 0}),
  routes: constantRouterMap
})

