<template>

  <div class="classObj":style="backgroundDiv">




  <div style="min-height: 100%">  <top-bar  style="width: 100%;height: 90px; "></top-bar>


  <div class="app-wrapper"  >
    <sidebar class="sidebar-container"></sidebar>

    <div class="main-container">
      <navbar></navbar>
      <app-main></app-main>
    </div>
  </div>
  </div>
  </div>
</template>

<script>
import { Navbar, Sidebar, AppMain ,TopBar} from './components'
import ResizeMixin from './mixin/ResizeHandler'

export default {
  data(){
    return {
      backgroundDiv: {
        backgroundImage: 'url(' + require('../../assets/images/beijing.jpg') + ')'
      },
    }
  },
  name: 'layout',
  components: {
    TopBar,
    Navbar,
    Sidebar,
    AppMain
  },
  mixins: [ResizeMixin],
  computed: {
    sidebar() {
      return this.$store.state.app.sidebar
    },
    device() {
      return this.$store.state.app.device
    },
    classObj() {
      return {
        hideSidebar: !this.sidebar.opened,
        withoutAnimation: this.sidebar.withoutAnimation,
        mobile: this.device === 'mobile'
      }
    }
  }
}
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
  @import "src/styles/mixin.scss";
  .app-wrapper {
    @include clearfix;
    position: relative;
    height: 100%;
    width: 100%;

    min-height: 100%;
    background-size: contain;
  }
  .classObj{
    height: 100%;
    background-size: cover;
  }
</style>
