<template>
  <el-row :gutter="10" >
   <el-col style="border-bottom: 1px solid #eee;" >
     <div style="margin: 10px;float: left;color: #3a8ee6">
       <span style="margin-top: 10px">
            <i class="el-icon-connection" style="font-size: 3em;" ></i>
     </span>
         <span  style="font-size: 2em">HIS</span>
     </div>
     <el-menu :default-active="activeIndex" class="el-menu-demo"
              style="float: right;border-bottom: 0px" mode="horizontal" @select="handleSelect">
       <el-menu-item index="1">消息中心</el-menu-item>
       <el-menu-item index="2">我的工作台</el-menu-item>
       <el-submenu index="3">
         <template slot="title">个人中心</template>
       </el-submenu>
       <el-menu-item index="4">退出登录</el-menu-item>
     </el-menu>
   </el-col>
  </el-row>

</template>

<script>
    export default {
        name: "Header",
      methods:{
        handleSelect(key, keyPath) {
          console.log(key);
          if(key=4){
            this.$router.push({name:'login'});
            this.$cookies.set("uID","");
          }
        }
      }
    }
</script>

