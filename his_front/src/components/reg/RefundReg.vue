<template>
  <div style="margin: 10px">

    <div style="padding-left: 20px">
      <el-row style="font-size: large">患者信息查询</el-row>
      <el-form :inline="true" style="margin-top: 20px">
        <el-form-item label="病历号">
          <el-input style="width: 150px;" v-model="bingliID" placeholder=""></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="getRegisterInfo">查询</el-button>
        </el-form-item>
      </el-form>
    </div>
    <div style="padding-left: 20px">
      <el-row style="font-size: large">患者信息确认</el-row>
      <el-form :inline="true" style="margin-top: 20px">
        <el-form-item label="姓名">
          <el-input style="width: 150px;padding-left: 10px" v-model="name" placeholder=""></el-input>
        </el-form-item>
        <el-form-item label="身份证号">
          <el-input v-model="shenfenID" placeholder=""></el-input>
        </el-form-item>
        <el-form-item label="住址">
          <el-input v-model="address"></el-input>
        </el-form-item>
      </el-form>
    </div>
    <el-card shadow="never" style="margin-left: 20px">

      <el-table
        :data="tableData"
        height="300"
        style="width: 100%;">
        <el-table-column
          prop="name"
          label="姓名">
        </el-table-column>
        <el-table-column
          prop="medRecordID"
          label="病历号">
        </el-table-column>
        <el-table-column
          prop="shenfenID"
          label="身份证号"
        width="180">
        </el-table-column>
        <el-table-column
          prop="wubie"
          label="午别">
        </el-table-column>
        <el-table-column
          prop="regStatus"
          label="看诊状态">
        </el-table-column>
        <el-table-column
          prop="regDate"
          label="挂号日期"
        width="100">
        </el-table-column>
        <el-table-column label="操作" >
          <template slot-scope="scope">
            <el-button
              size="mini"
              @click="handleEdit(scope.$index, scope.row)">退号</el-button>
          </template>
        </el-table-column>
      </el-table>
    </el-card>

  </div>
</template>

<script>
    export default {
        name: "refundReg",
      data() {
        return {
          name:null,
          bingliID:null,
          shenfenID:null,
          address:null,
          tableData: []
        }
      },
      methods: {
        handleEdit(index, row) {//退号
          console.log(index, row);
          if(row.regStatus=="已看诊"||row.regStatus=="已退号"){
            this.$alert('当前状态无法退号', '提醒', {
              confirmButtonText: '确定',
              callback: action => {
                /* this.$message({
                   type: 'info',
                   message: `action: ${ action }`
                 });*/
              }
            });
          }else{
            //提交
            this.axios.post("http://localhost:8090/refundReg?regID="+row.regID
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
          }
        },
        getRegisterInfo(){
          this.axios.get("http://localhost:8090/refundReg/getRegInfoList?bingliID="+this.bingliID
          ).then((response) => {
            console.log(response.data);//请求的返回体
           // this.tableData=response.data.registerInfos;
            this.name=response.data.patient.pName;
            this.address=response.data.patient.address;
            this.shenfenID=response.data.patient.shenfenID;
            let list=[];
            for(let i in response.data.registerInfos){
              console.log(i);
              let temp={};
              temp.name=this.name;
              temp.shenfenID=this.shenfenID
              temp.regDate=response.data.registerInfos[i].regDate;
              temp.medRecordID=response.data.registerInfos[i].medRecordID;
              temp.regID=response.data.registerInfos[i].registerID;
              if(response.data.registerInfos[i].regStatus=='1') {
                temp.regStatus = "已挂号";
              }else if(response.data.registerInfos[i].regStatus=='2'){
                temp.regStatus="已看诊";
              }else if(response.data.registerInfos[i].regStatus=='3'){
                temp.regStatus="已退号";
              }
              temp.wubie=response.data.registerInfos[i].wubie;
              list.push(temp);
              console.log(temp);
            }
            this.tableData=list;
          })
            .catch((error) => {
              console.log(error);//异常
            });
        }

      }
    }
</script>

<style scoped>

</style>
