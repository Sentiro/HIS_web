<template>
  <div>

    <el-container>
      <el-aside style="width: 160px"></el-aside>
      <el-container>
        <el-header>
          <Header ></Header>
        </el-header>
        <el-main  >
          <el-container  >
            <el-aside class="mainaside" width="220px" >
              <el-menu :default-openeds="['1', '3']" class="menu">
                <el-submenu index="1">
                  <template slot="title"><i class="el-icon-message"></i>挂号功能</template>
                  <el-menu-item-group>
                    <template slot="title">挂号部分</template>
                    <el-menu-item index="1-1" @click="toRegister">挂号
                    </el-menu-item>
                    <el-menu-item @click="toRefund">
                    退号
                    </el-menu-item>
                  </el-menu-item-group>
                  <el-menu-item-group title="分组2">
                    <el-menu-item index="1-3" @click="toPay">收费</el-menu-item>
                  </el-menu-item-group>
                </el-submenu>
                <el-submenu index="2" disabled>
                  <template slot="title"><i class="el-icon-menu"></i>药房医生功能</template>
                  <el-menu-item-group>
                    <el-menu-item index="2-1">医生诊断</el-menu-item>
                    <el-menu-item index="2-2">医生开药</el-menu-item>
                    <el-submenu index="2-3">
                      <template slot="title">医生诊断</template>
                      <el-menu-item index="2-3-1">病例首页</el-menu-item>
                      <el-menu-item index="2-3-2">病例首页</el-menu-item>
                    </el-submenu>
                  </el-menu-item-group>
                </el-submenu>
              </el-menu>
            </el-aside>
            <router-view/>
          </el-container>
        </el-main>
      </el-container>
      <el-aside style="width: 160px"></el-aside>
    </el-container>


  </div>
</template>

<script>
  import Register from './reg/Register'
  import Header from './Header'
  export default {
    name: 'Main',
    components: {Header},
    comments: {
      Register,
      Header
    },
    methods:{
      toPay:function () {
        this.$router.replace('/pay');
      },
      toRefund:function () {
        this.$router.replace('/refundReg');
      },
      toRegister:function () {
        this.$router.replace('/register');
      }
    }
  }
</script>

<style>
  #app {
    font-family: 'Avenir', Helvetica, Arial, sans-serif;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    color: #2c3e50;
  }

  .mainaside {
   /* border-right: 1px solid #eee;*/
  }

  .menu {
    /* border-right: solid 1px #e6e6e6; */
    border-right: 2px;
    list-style: none;
    position: relative;
    margin: 0;
    padding-left: 0;
    background-color: #FFF;
  }
</style>
