<template>
  <div>
    <div>
      <el-scrollbar>
        <el-tree :data="data1" :props="defaultProps" @node-click="handlePatientClick"></el-tree>
      </el-scrollbar>
    </div>
  </div>

</template>

<script>
  export default {
    name: "DocAside",

    data() {
      return {
        data1: [],
        defaultProps: {
          children: 'children',
          label: 'label'
        }
      }
    },
    methods: {
      handleNodeClick(data) {
        console.log(data);
      },
      handlePatientClick(data) {
        console.log(data);
        this.$emit("currentPatient",data);
      }
    }
  }
</script>

<style scoped>
  .text {
    font-size: 14px;
  }

  .item {
    margin-bottom: 18px;
  }

  .clearfix {
    border-bottom: 1px solid #EBEEF5;
    -webkit-box-sizing: border-box;
    box-sizing: border-box;
    width: 180px;
  }

  .clearfix:before,
  .clearfix:after {
    display: table;
    content: "";
  }

  .clearfix:after {
    clear: both
  }

  .box-card {
    width: 180px;
    padding: 10px 10px;

  }
</style>
