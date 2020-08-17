<template xmlns="http://www.w3.org/1999/html">
    <div>
      <el-container>
        <el-main>
          <!--新建处方模板dialog-->
          <el-dialog width="40%" title="新建处方模板" :visible.sync="newTemDialog">
            <el-form :model="form" style="padding-right: 20px">
              <el-form-item label="模板名称" :label-width="formLabelWidth">
                <el-input v-model="form.name" autocomplete="off"></el-input>
              </el-form-item>
            </el-form>
            <div slot="footer" class="dialog-footer">
              <el-button @click="newTemDialog = false">取 消</el-button>
              <el-button type="primary" @click="newTemplate">确 定</el-button>
            </div>
          </el-dialog>
          <!--修改药品信息dialog-->
          <el-dialog width="40%" title="修改药品信息" :visible.sync="editDialog">
            <el-form :model="form" style="padding-right: 20px">
              <el-form-item label="药品名称" :label-width="formLabelWidth">
                <el-input v-model="editMed.row.mName" autocomplete="off"></el-input>
              </el-form-item>
              <el-form-item label="药品规格" :label-width="formLabelWidth">
                <el-input v-model="editMed.row.standard" autocomplete="off"></el-input>
              </el-form-item>
              <el-form-item label="药品单价" :label-width="formLabelWidth">
                <el-input v-model="editMed.row.price" autocomplete="off"></el-input>
              </el-form-item>
              <el-form-item label="用法" :label-width="formLabelWidth">
                <el-input v-model="editMed.row.usage" autocomplete="off"></el-input>
              </el-form-item>
              <el-form-item label="用量" :label-width="formLabelWidth">
                <el-input v-model="editMed.row.times" autocomplete="off"></el-input>
              </el-form-item>
              <el-form-item label="数量" :label-width="formLabelWidth">
                <el-input v-model="editMed.row.num" autocomplete="off"></el-input>
              </el-form-item>
            </el-form>
            <div slot="footer" class="dialog-footer">
              <el-button @click="editMedicineDialog = false">取 消</el-button>
              <el-button type="primary" @click="editMedicine">确 定</el-button>
            </div>
          </el-dialog>
          <!--选择药品dialog-->
          <el-dialog title="添加药品" :visible.sync="addMedicineDialog">
            <el-form style="margin-right: 40px" size="small" :model="form" label-width="80px" rules="diseaseFormRule" >
              <el-row>
                <el-col :span=10>
                  <el-form-item size="medium" label="药品" >
                    <el-select
                      v-model="value"
                      multiple
                      filterable
                      remote
                      reserve-keyword
                      placeholder="请输入关键词"
                      :remote-method="remoteMethod"
                      :loading="loading">
                      <el-option
                        v-for="item in options"
                        :key="item.value"
                        :label="item.label"
                        :value="item.value">
                      </el-option>
                    </el-select>
                  </el-form-item>
                </el-col>
              </el-row>
              <el-form-item>
                <el-table :data="medicineList"
                          ref="singleTable"
                          height="300"
                          highlight-current-row
                          @current-change="handleCurrentChangeMedicine">
                  <el-table-column property='medicineID' label="药品ID" width="150"></el-table-column>
                  <el-table-column property="mName" label="名称" width="200"></el-table-column>
                  <el-table-column property="standard" label="规格"></el-table-column>
                  <el-table-column property="price" label="价格" ></el-table-column>
                  <el-table-column property="pinyin" label="拼音"></el-table-column>
                </el-table>
              </el-form-item>
              <el-row>
                <el-col :span=9>
                  <el-form-item label="用法">
                    <el-input v-model="newMed.usage" ></el-input>
                  </el-form-item>
                </el-col>
                <el-col :span=9>
                  <el-form-item label="用量">
                    <el-input v-model="newMed.times" ></el-input>
                  </el-form-item>
                </el-col>
                <el-col :span=6>
                  <el-form-item label="数量" >
                    <el-input v-model="newMed.num" ></el-input>
                  </el-form-item>
                </el-col>
              </el-row>
            </el-form>

            <div slot="footer" class="dialog-footer">
              <el-button @click="addMedicineDialog = false">取 消</el-button>
              <el-button type="primary" @click="addMedicine">确 定</el-button>
            </div>
          </el-dialog>

          <!--主页面-->
          <!--模板表格-->
          <el-row style="padding-bottom: 10px" >
            <el-col :span=11>
              <el-card >
                <div style=" font-size: 13px;height: 150px">
                  <el-row style="margin: 15px">
                    <el-col span=6>姓名：{{myPatient.name}}</el-col>
                    <el-col span=8>     性别：男</el-col>
                  </el-row>
                  <el-row style="margin: 15px" >
                   <el-col :span="6">年龄：{{myPatient.age}}</el-col>
                  </el-row>
                  <div style="margin: 15px">病历ID：{{myPatient.medRecordID}}</div>
                </div>
              </el-card>
            </el-col>
            <el-col span=12 :offset=1>
              <el-card>
                <el-row>
                  <span >当前处方</span>
                  <span style="float: right;">
                    <el-button size="small"  type="info" icon="el-icon-edit" circle  @click="newTemDialog = true"></el-button>
                    <el-button size="small" type="primary" icon="el-icon-plus" circle @click.add="addTemDialog=true"></el-button>
                    <el-button size="small" type="danger" icon="el-icon-delete" circle  @click="deleteTem"></el-button>
                  </span>
                </el-row>
                          <el-table
                  ref="singleTable"
                  :data="myTemplate"
                  height="150"
                  tooltip-effect="dark"
                  highlight-current-row
                  @current-change="handleCurrentChangeTem">
                  <el-table-column type="index" width="50"></el-table-column>
                  <el-table-column  prop="name" label="模板名称" width="199"></el-table-column>
                  <el-table-column  prop="status" label="状态" width="150"></el-table-column>
                </el-table>
              </el-card>
            </el-col>
          </el-row >
          <!--我的药品表格-->
          <el-row style="padding-top: 10px">
            <el-card >
              <el-row>
                <el-button size="small"  type="info" icon="el-icon-plus" circle @click.native="openMedicineDialog"></el-button>
                <el-button size="small" type="primary" icon="el-icon-edit" circle @click="editMedicineDialog=true"></el-button>
              </el-row>
              <el-table
                :data="myMedicineTable"
                height="200"
                style="width: 100%">
                <el-table-column
                  prop="mName"
                  label="药品名称"
                  width="200"
                >
                </el-table-column>
                <el-table-column
                  prop="standard"
                  label="规格">
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
                  prop="usage"
                  label="用法">
                </el-table-column>
                <el-table-column
                  prop="times"
                  label="用量">
                </el-table-column>
                <el-table-column label="操作">
                  <template slot-scope="scope">
                    <el-button
                      size="mini"
                      type="text"
                      @click.native="handleEdit(scope.$index, scope.row)">编辑</el-button>
                    <el-button
                      size="mini"
                      type="text"
                      @click.native="handleDelete(scope.$index, scope.row)">删除</el-button>
                  </template>
                </el-table-column>
              </el-table>
            </el-card>
          </el-row>
          <el-row style="margin-top: 20px">
            <el-button style="float: right;" type="primary" @click="onSubmit">提交处方</el-button>
          </el-row>


        </el-main>
      </el-container>


    </div>

</template>

<script>
  export default {
    props:{
      myPatient: Object,
      doctor: Object
    },
    data() {
      return {
        patient:{
          pName:'',
          age:'',
          regID:0,
          gender:'',
          bingliID: 0
        },
        templateList:[
          {
            key:0,
            name:"模板1",
            status:"暂存",
            medicine:[
              {mName:"肠内营养粉剂",num:2,usage:"口服",times:"一日三次",standard:"1000mg/g",price:3},
              {mName:"丹参颗粒",num:2,usage:"口服",times:"一日三次",standard:"10g/袋",price:12}
            ]
          },
          {
            key:1,
            name:"测试模板",
            status:"暂存",
            medicine:[
              {mName:"感冒灵",num:2,usage:"口服",times:"一日三次",standard:"1000mg/g",price:3},
              {mName:"丹参颗粒",num:2,usage:"口服",times:"一日三次",standard:"10g/袋",price:12}
            ]
          }

        ],
        medicineList:[],
        myMedicineTable:[],
        myTemplate:[
          {
            key:0,
            name:"模板1",
            status:"暂存",
            medicines:[
              {mName:"肠内营养粉剂",num:2,usage:"口服",times:"一日三次",standard:"1000mg/g",price:3},
              {mName:"丹参颗粒",num:2,usage:"口服",times:"一日三次",standard:"10g/袋",price:12}
            ]
          },
          {
            key:1,
            name:"测试模板",
            status:"暂存",
            medicines:[
              {mName:"感冒灵",num:2,usage:"口服",times:"一日三次",standard:"1000mg/g",price:3},
              {mName:"999感冒灵",num:2,usage:"口服",times:"一日三次",standard:"10g/袋",price:12}
            ]
          }
        ],

        newMed:{},
        newTemDialog: false,
        addMedicineDialog:false,
        addTemDialog:false,
        editDialog:false,
        form: {
          name: ''
        },
        formLabelWidth: '120px',
        selectedTem:{},
        selectedMed:[],
        editMed:{
          index:null,
          temIndex:null,
          row:{}
        },
        options:[]
      }
    },created(){
      this.getPatientInfo();
      console.log('[pre]uid '+this.$cookies.get("uID"));
    },
    methods: {
      openMedicineDialog(){
        if(this.selectedTem!=null){
          this.addMedicineDialog=true;
        }else{
          this.$alert('请选择模板', '提示', {
            confirmButtonText: '确定',
            callback: action => {
            }
          });
        }

      },
      getPatientInfo(){
        console.log("[pre 得到的患者信息]"+this.patient)
        console.log("[pre 得到的doc信息]"+this.doctor)
      },
      remoteMethod(query) {
        if (query !== '') {
          this.loading = true;
          this.axios.get("http://localhost:8090/searchMedicine",{
            params: {
              str: query
            }
          })
            .then((response) => {
              console.log(response.data);//请求的返回体
              this.list=response.data;
              this.medicineList=response.data;
            })
            .catch((error) => {
              console.log(error);//异常
            });
        } else {
        }
      },
      addMedicine(){
        console.log("[this.newMed]"+this.newMed);
        this.myMedicineTable.push(this.newMed);
        this.selectedTem.medicines=this.myMedicineTable;
        this.newMed={};
        //this.medicineList=[];
        this.addMedicineDialog=false;
      },
      onSubmit() {
        console.log(this.myTemplate);
        const data={
          "docID": 1,//this.doctor.uID,
          "regID":this.myPatient.regID,
          "prescriptions":this.myTemplate,
          "status":"已开立"
        }
        console.log('submit!');
        this.$axios({
          method:"post",
          url:"prescript",
          header:{
            'Content-Type':'application/json;charset=utf-8'  //如果写成contentType会报错
          },
        data:data,
          dataType:'json',
        }).then((res)=>{
          console.log(res);
          this.$alert('提交成功', '提示', {
            confirmButtonText: '确定',
            callback: action => {
            }
          });
        });
      },
      newTemplate:function (event) {
        console.log(event);
        console.log(this.form.name);

        let size=this.myTemplate.length;
        console.log(this.myTemplate.length);
        this.myTemplate.push({key:size+1,name:this.form.name,status:"暂存",medicines:[]});
        this.newTemDialog=false;
      },
      handleCurrentChangeMedicine(val) {
        this.newMed = val;
        console.log(val);
      },
      handleCurrentChangeTem(val) {
        this.selectedTem = val;
        console.log(val);
        this.myMedicineTable=val.medicines;
      },
      deleteTem:function () {
          this.myTemplate.splice(this.myTemplate.indexOf(this.selectedTem), 1);
          this.myMedicineTable=[];
      },
      handleEdit(index, row) {
        console.log("[handleEdit]"+index, row);
        this.editMed.row=row;
        this.editMed.index=index;
        this.editMed.temIndex=this.selectedTem.key;
        this.editDialog=true;
      },
      editMedicine:function(){
        console.log(this.editMed);
        let temp=this.myTemplate[this.editMed.temIndex];
        temp.medicines[this.editMed.index]=this.editMed.row;
        this.$set(this.myTemplate, this.editMed.temIndex,temp);
        this.editDialog=false;
      },
      handleDelete(index, row) {
        console.log(index, row);
        let temp2=this.myTemplate[this.selectedTem.key];
        temp2.medicines.splice(index,1);
        //this.$set(this.myTemplate, this.selectedTem,temp);
      }
    }
  }
</script>

<style scoped>

</style>
