<template>
  <div class="app-wrapper" :class="classObj">
    <app-main></app-main>
  </div>
</template>

<script>
  import { AppMain } from './components'
  import ResizeMixin from './mixin/ResizeHandler'
  export default {
    name: 'layout2',
    components: {
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
  }
</style>
