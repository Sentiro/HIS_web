<template>
  <div>

    <el-container>
      <el-aside style="width: 160px;padding: 5px"></el-aside>
      <el-container>
        <el-header>
          <Header></Header>
        </el-header>
        <el-container style="margin-top: 20px">
          <el-aside class="mainaside" width="220px" style="margin-top: 10px">
            <el-scrollbar>
                <el-tree highlight-current=true :data="list" :props="defaultProps"  @node-click="handleNodeClick"></el-tree>
              </el-scrollbar>
          </el-aside>
          <el-container>
            <el-header>
              <el-tabs v-model="activeName" @tab-click="handleClick"> <!-- @tab-click="handleClick"-->
                <el-tab-pane label="病历首页" name="first"  >
                  <Diagnose v-bind:patient="currentPatient" v-bind:doctor="user"></Diagnose>
                </el-tab-pane>
                <el-tab-pane label="申请检查" name="second">申请检查</el-tab-pane>
                <el-tab-pane label="门诊确诊" name="third">门诊确诊</el-tab-pane>
                <el-tab-pane label="开立处方" name="fourth">
                  <Prescription  v-bind:myPatient="currentPatient" v-bind:doctor="user"></Prescription>
                </el-tab-pane>
              </el-tabs>
            </el-header>
            <el-main>
              <router-view/>
            </el-main>
          </el-container>
        </el-container>
        <el-footer></el-footer>
      </el-container>
      <el-aside style="width: 160px"></el-aside>
    </el-container>


  </div>
</template>

<script>
  import Register from './reg/Register'
  import Header from '../components/Header'
 // import DocAside from '../components/doc/DocAside'
  import Prescription from './doc/Prescription'
  import Diagnose from './doc/Diagnose'
  import Vue from 'vue'

  export default {
    name: 'doctorMain',
    data() {
      return {
        activeName:'',
        flag:false,
        currentPatient:{},
        user: {},
        patient: [],
        list:[{
          label:'待诊患者',
            children:[]
          },{
          label:'已诊患者',
            children:[]
          }],
        defaultProps: {
          children: 'children',
          label: 'label'
        }
      }
    },
    components: {
      Header,
      Diagnose,
      Prescription
    },
    created() {
      this.getPatientList();
      console.log('[pay]uid '+this.$cookies.get("uID"));
    },
    comments: {
      Register,
      Header
    }, methods: {
      handleClick(tab, event) {
        console.log(tab, event);
        console.log('[currentPatient]'+this.currentPatient.pName);
        if(this.flag){

          if(tab.index==0){
            this.activeName='first';
            // this.$router.push({name:'diagnose',params:{'patient':this.currentPatient}});
          }else if(tab.index==3){
            // this.$router.push({name:'prescription',params:{'patient':this.currentPatient}})
          }

        }else{
          this.activeName='';
          this.$alert('未选择患者 无法跳转', '提示', {
            confirmButtonText: '确定',
            callback: action => {
            }
          });
        }
      },
      getPatientList() {
        var that = this;
        // console.log("doctorMain[获取到的医生信息]"+that.$route.params.user.uID);
        //
        // that.doctor = that.$route.params.user;
        const data = {
          'id': this.$cookies.get("uID"),//that.doctor.uID ,
          'date': '2020-7-20'
        }
        const options = {
          method: 'POST',
          headers: {'content-type': 'application/x-www-form-urlencoded'},
          data: that.$qs.stringify(data),
          url: "docMain/getPatients"
        };
        that.axios(options
        ).then((response) => {
          console.log(response.data);
          if (response.data != null) {
            this.patient=response.data;
            let list1=[];
            let list2=[];
            for (let index in this.patient) {
              if (this.patient[index].regStatus == '1') {
                list1.push({
                  id: this.patient[index].medRecordID,
                  label: this.patient[index].medRecordID + '  ' + this.patient[index].name,
                })
              }else if(this.patient[index].regStatus=='2'){
                console.log(index);
                list2.push({
                  id: this.patient[index].medRecordID,
                  label: this.patient[index].medRecordID + '  ' + this.patient[index].name,
                })
              }
            }
            this.$set(this.list[0],"children",list1);
            this.$set(this.list[1],"children",list2);
            console.log(this.list);
          }
        }).catch((error) => {
          console.log(error);
        });
      },
      //更新当前患者
      handleNodeClick(data) {
        console.log(data);
        for(let i in this.patient){
          if(this.patient[i].medRecordID==data.id){
            this.currentPatient=this.patient[i];
            console.log("doctorMain[更新患者信息]"+this.currentPatient);
            this.flag=true;

          }
        }
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
