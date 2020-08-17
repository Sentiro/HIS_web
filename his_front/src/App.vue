<template>
  <div id="app" >
    <router-view></router-view>
  </div>
</template>

<script>

  export default {
    name: 'App',
    data(){
      return{
        maxHeight: window.screen.height,
        maxWidth: window.screen.width
      }
    },
    methods:{
    }
  }
</script>

