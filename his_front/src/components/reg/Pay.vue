<template>
  <div style="padding:10px;width: 900px">
    <div style="padding-left: 20px">
      <el-row style="font-size: large">患者信息查询</el-row>
      <el-form :inline="true" style="margin-top: 20px">
        <el-form-item label="病历号">
          <el-input style="width: 150px;" v-model="bingliID" placeholder=""></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="search">查询</el-button>
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
    <el-card>
      <el-row style="margin-bottom: 20px;font-size: large">患者缴费信息</el-row>
      <el-table
        ref="filterTable"
        :data="billTable"
        tooltip-effect="dark"
        style="width: 100%"
        max-height="250"
        @selection-change="handleSelectionChange">
        <el-table-column
          type="selection"
          fixed="left"
          width="55">
        </el-table-column>
        <el-table-column
          prop="preID"
          label="处方号"
          :filters="filters"
          :filter-method="filterHandler">
        </el-table-column>
        <el-table-column
          label="病历号"
          prop="bingliID">
        </el-table-column>
        <el-table-column
          prop="name"
          label="姓名">
        </el-table-column>
        <el-table-column
          prop="proName"
          label="项目名称">
        </el-table-column>
        <el-table-column
          prop="price"
          label="单价">
        </el-table-column>
        <el-table-column
          prop="num"
          label="数量">
        </el-table-column>
        <el-table-column
          prop="date"
          label="日期">
          <template slot-scope="scope">{{ scope.row.date }}</template>
        </el-table-column>
        <el-table-column
          prop="status"
          fixed="right"
          label="状态">
        </el-table-column>
      </el-table>
    </el-card>
    <div style="padding: 20px">
      <el-button type="primary" @click="showInvoiceDialog">确认缴费</el-button>
    </div>

    <!--收费-->
    <el-dialog title="填写发票信息" :visible.sync="invoiceDialog">
      <el-form :model="form">
        <el-row>
          <el-col :span=10>
            <el-form-item label="病历号" :label-width="formLabelWidth">
              <el-input v-model="form.bingliID" autocomplete="off"></el-input>
            </el-form-item>
          </el-col >
          <el-col  :span=10>
            <el-form-item label="患者姓名" :label-width="formLabelWidth">
              <el-input v-model="form.name" autocomplete="off"></el-input>
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span=10>
            <el-form-item label="支付方式" :label-width="formLabelWidth">
              <el-select v-model="form.type" >
                <el-option label="支付宝" value="1"></el-option>
                <el-option label="微信" value="2"></el-option>
                <el-option label="现金" value="3"></el-option>
              </el-select>
            </el-form-item>
          </el-col>
        </el-row>
       <el-row>
         <el-col :span="20">
           <el-form-item label="应收" :label-width="formLabelWidth">
             <el-input v-model="form.amount" autocomplete="off" ></el-input>
           </el-form-item>
         </el-col>

       </el-row>
        <el-row>
          <el-col :span="20">
          <el-form-item label="实收" :label-width="formLabelWidth">
            <el-input v-model="form.shishou" autocomplete="off" @change=" form.zhaoling=form.shishou-form.amount"></el-input>
          </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="20">
          <el-form-item label="找零" :label-width="formLabelWidth">
            <el-input v-model="form.zhaoling" autocomplete="off"></el-input>
          </el-form-item>
          </el-col>
        </el-row>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="invoiceDialog = false">取 消</el-button>
        <el-button type="primary" @click="newInvoice">确 定</el-button>
      </div>
    </el-dialog>
  </div>

</template>

<script>
    export default {
        name: "Pay",
      data(){
          return{
            formLabelWidth: '120px',
            preList:[],
            form:{
              name:'',
              invoiceID:'',
              type:'',
              yingshou:null,
              shishou:null,
              zhaoling:null,
              amount:null
            },
            invoiceDialog:false,
            bingliID:"12346",
            name:'',
            shenfenID:'',
            address:'',
            billTable:[
              {
                regID: 456,
                bingliID:'543138x',
                name:'yyc',
                proName:'感冒灵颗粒',
                num:3,
                price:12.65,
                status:'已开立',
                date:'2020-7-6'
              },
              {
                regID: 456,
                bingliID:'543138x',
                name:'yyc',
                proName:'感冒灵颗粒',
                num:3,
                price:12.65,
                status:'已开立',
                date:'2020-7-6'
              }, {
                regID: 456,
                bingliID:'543138x',
                name:'yyc',
                proName:'感冒灵颗粒',
                num:3,
                price:12.65,
                status:'已开立',
                date:'2020-7-6'
              }
            ],
            multipleSelection:[],
            filters:[]
          }
      },
      methods:{
        handleSelectionChange(val) {
          this.multipleSelection = val;
          console.log(val);
        },
        search:function () {
          //根据病历ID搜索费用条目
          this.axios.get("pay/getBills?bingliID="+this.bingliID
          ).then((response) => {
            console.log(response.data);//请求的返回体
            this.billTable=response.data;
            //得到filters
            for(let index in this.billTable){
              let filter={};
              let tag=true;
              filter.value=this.billTable[index].preID;
              filter.text=this.billTable[index].preID;
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
              console.log(error);//异常
            });
          //根据病历ID 搜索患者信息
          this.axios.get("pay/getPatientInfo?bingliID="+this.bingliID
          ).then((response) => {
            console.log(response.data);//请求的返回体
            this.name=response.data.pName;
            this.address=response.data.address;
            this.shenfenID=response.data.shenfenID;
          })
            .catch((error) => {
              console.log(error);//异常
            });
        },
        filterHandler(value, row, column) {
          const property = column['property'];
          return row[property] === value;
        },
        submit:function () {


        },newInvoice:function () {
          this.invoiceDialog=false;
          console.log(this.$route.params);

          let registrar = this.$route.params.user;
          this.$axios({
            method:"post",
            url:"pay",
            header:{
              'Content-Type':'application/json;charset=utf-8'  //如果写成contentType会报错
            },
            data:{
             "preID":this.preList,
              "registrarID":this.$cookies.get("uID")
            }
          }).then((res)=>{
            console.log(res);
            this.$alert('提交成功', '提示', {
              confirmButtonText: '确定',
              callback: action => {
              }
            });
          });

        },showInvoiceDialog:function () {
          console.log('[pay]uid '+this.$cookies.get("uID"));
          console.log('[pay]uid-localStorage '+localStorage.getItem("uID"));

          if (this.multipleSelection.length>0){
            this.invoiceDialog=true;

            //设置默认值
            this.form.name=this.multipleSelection[0].name;
            this.form.bingliID=this.multipleSelection[0].bingliID;
            let amount=0;
            for (let i in this.multipleSelection){
              amount=amount+this.multipleSelection[i].price*this.multipleSelection[i].num;
              let preID=this.multipleSelection[i].preID;
              let tag=true;
              for (let index in this.preList){
                if(this.preList[index]==preID){
                  tag=false;
                }
              }
              if(tag){
                this.preList.push(preID);
              }
            }
            console.log("[preList]"+this.preList);
            this.form.amount=amount;
          } else{
            this.$alert('未选中任何缴费记录', '提醒', {
              confirmButtonText: '确定',
              callback: action => {
                this.$message({
                  type: 'info',
                  message: `action: ${ action }`
                });
              }
            });
          }
        }
      }
    }
</script>

<style scoped>

</style>
