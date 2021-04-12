<template>
<!--  <el-menu class="navbar" :style="backgroundDiv" mode="horizontal" text-color="#fff">
    <hamburger class="hamburger-container" :toggleClick="toggleSideBar" :isActive="sidebar.opened"></hamburger>
    <breadcrumb></breadcrumb>
    <el-dropdown class="avatar-container" trigger="click">
      <div class="avatar-wrapper">
        <img class="user-avatar" :src="avatar">
        <i class="el-icon-caret-bottom"></i>
      </div>
      <el-dropdown-menu class="user-dropdown" slot="dropdown">
        <router-link class="inlineBlock" to="/">
          <el-dropdown-item>
            首页
          </el-dropdown-item>
        </router-link>
        <el-dropdown-item divided>
          <span @click="logout" style="display:block;">退出</span>
        </el-dropdown-item>
      </el-dropdown-menu>
    </el-dropdown>
  </el-menu>-->

  <div  class="navbar":style="backgroundDiv" >
  <div style="margin-left:250px;color: white;font-size: 20px;padding:15px 0;">

     <span>{{levelList.meta.title}}</span>

    <!--<div v-for="(item,index)  in levelList" :key="item.path" v-if="item.meta.title">
      <span v-if="item.redirect==='noredirect'||index==routes.length-1" class="no-redirect">{{item.meta.title}}</span>
      <router-link v-else :to="item.redirect||item.path">{{item.meta.title}}</router-link></div>-->
  </div>
  </div>
</template>

<script>
import { mapGetters } from 'vuex'
import Breadcrumb from '@/components/Breadcrumb'
import Hamburger from '@/components/Hamburger'
import NavbarIndex from "./NavbarIndex";

export default {
  data() {
    return{
      backgroundDiv: {
        backgroundImage: 'url(' + require('../../../assets/images/menu_right.png') + ')'
      },
      levelList: null

    }
  },
  created(){
    this.getBreadcrumb()

  },
  watch: {
    $route() {
      this.getBreadcrumb()
    }
  },


  components: {
    NavbarIndex,
    Breadcrumb,
    Hamburger
  },
  computed: {
    ...mapGetters([
      'sidebar',
      'avatar',
      'routers'

    ]),
    routes() {

      // return this.$router.options.routes
      console.log(this.routers +'children______')

      return this.routers
    },
  },
  methods: {
    getBreadcrumb() {
      let matched = this.$route.matched.filter(item => item.name)
      const first = matched[0];
      const last=matched[matched.length-1];

      if (first && first.name !== 'home') {
        matched = [{ path: '/home', meta: { title: '首页' }}].concat(matched)
      }
      console.log(last+'last=-======')
      this.levelList = last

    },
    toggleSideBar() {
      this.$store.dispatch('ToggleSideBar')
    },
    logout() {
      this.$store.dispatch('LogOut').then(() => {
        location.reload() // 为了重新实例化vue-router对象 避免bug
      })
    }
  }
}
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
.navbar {
  height: 80px;
  line-height: 50px;
  border-radius: 0px !important;
  background: transparent;
  .hamburger-container {
    line-height: 58px;
    height: 50px;
    float: left;
    padding: 0 10px;
  }
  .screenfull {
    position: absolute;
    right: 90px;
    top: 16px;
    color: red;
  }
  .avatar-container {
    height: 50px;
    display: inline-block;
    position: absolute;
    right: 35px;
    .avatar-wrapper {
      cursor: pointer;
      margin-top: 5px;
      position: relative;
      .user-avatar {
        width: 40px;
        height: 40px;
        border-radius: 10px;
      }
      .el-icon-caret-bottom {
        position: absolute;
        right: -20px;
        top: 25px;
        font-size: 12px;
      }
    }
  }
  .el-menu.el-menu--horizontal {
    border-bottom: solid 1px transparent;
  }
  .no-redirect {
    color: #ffffff;
    cursor: text;
    margin-left: 190px;
  }
}
</style>

