<template>
  <div class="menu-wrapper">
    <template v-for="item in routes" v-if="!item.hidden&&item.children">
      <div>{{item.children[0]}}</div>

        </template>



  </div>
</template>

<script>
  export default {
    name: 'NavbarIndex',
    props: {
      routes: {
        type: Array
      },
      isNest: {
        type: Boolean,
        default: false
      }
    },
    methods: {

    }
  }
</script>
