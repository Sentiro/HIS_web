<template>
  <div style="padding:10px;width: 900px">
    <div style="padding-left: 20px">
      <el-row style="font-size: large">患者信息查询</el-row>
      <el-form :inline="true" style="margin-top: 20px">
        <el-form-item label="病历号">
          <el-input style="width: 150px;" v-model="bingliID" placeholder=""></el-input>
        </el-form-item>
        <el-form-item label="时间">
          <el-date-picker style="width: 150px;" v-model="time" placeholder=""></el-date-picker>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="search">查询</el-button>
        </el-form-item>
      </el-form>

    </div>
    <div>
      <el-card>
        <el-row style="font-size: large">患者药品信息</el-row>
      <el-table
        :data="medicineList"
        tooltip-effect="dark"
        height="250"
        max-height="250"
        @selection-change="handleSelectionChange"
        style="width: 100%;margin-top: 10px">
        <el-table-column
          type="selection"
          width="55">
        </el-table-column>
        <el-table-column
          prop="preID"
          label="处方号"
          :filters="filters"
          :filter-method="filterHandler">
        </el-table-column>
        <el-table-column
          prop="proName"
          width="150"
          label="药品名称">
        </el-table-column>
        <el-table-column
          prop="price"
          label="价格">
        </el-table-column>
        <el-table-column
          prop="num"
          label="数量">
        </el-table-column>
        <el-table-column
          prop="docName"
          label="开立医生">
        </el-table-column>
        <el-table-column
          prop="status"
          label="药品状态">
        </el-table-column>
        <el-table-column
          prop="date"
          label="日期"
          width="250">
        </el-table-column>
      </el-table>
      </el-card>
      <div style="padding: 20px">
        <el-button type="primary" @click="handleDistribute">确认发药</el-button>
      </div>
    </div>
  </div>
</template>

<script>
    export default {
        name: "DistributeMed",
      data(){
          return{
            filters:[],
            preList:[],
            bingliID:null,
            time:null,
            medicineList:[
                ],
            multipleSelection:[]
          }
      },
      methods:{
          search:function () {
            this.axios.get("http://localhost:8090/distribute/query?bingliID="+this.bingliID
            ).then((response) => {
              console.log(response.data);//请求的返回体
              this.medicineList=response.data;
              for(let index in this.medicineList){
                let filter={};
                let tag=true;
                filter.value=this.medicineList[index].preID;
                filter.text=this.medicineList[index].preID;
                console.log(filter);
                for(let i in this.filters){
                  if(this.filters[i].value==filter.value){
                    tag=false;
                  }
                }
                if(tag){
                  this.filters.push(filter);
                }
              }
            })
              .catch((error) => {
              });
          },handleDistribute:function () {
          if (this.multipleSelection.length==this.medicineList.length){
            //TODO 修改药品状态
            this.axios.post("http://localhost:8090/distribute?bingliID="+this.bingliID
            ).then((response) => {
              console.log(response.data);//请求的返回体
              // this.tableData=response.data.registerInfos;
              this.$alert('提交成功', '消息', {
                confirmButtonText: '确定',
                callback: action => {
                }
              });
            })
              .catch((error) => {
                console.log(error);//异常
                this.$alert('提交失败', '消息', {
                  confirmButtonText: '确定',
                  callback: action => {
                  }
                });
              });
            //提示成功
          } else{
            this.$alert('请选择全部药品', '提醒', {
              confirmButtonText: '确定',
              callback: action => {
                this.$message({
                  type: 'info',
                  message: `action: ${ action }`
                });
              }
            });
            }
        }, handleSelectionChange(val) {
          this.multipleSelection = val;
          console.log('[selection改变]'+val);
        }, filterHandler(value, row, column) {
          const property = column['property'];
          return row[property] === value;
        },

      }
    }
</script>

<style scoped>

</style>
