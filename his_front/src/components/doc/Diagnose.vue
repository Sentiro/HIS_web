<template>
    <div>
      <el-form :model="form" :rules="rules" ref="form" label-width="100px"  class="demo-ruleForm">
        <el-row>
          <el-col :span=16>
            <el-form-item  label="主诉" prop="zhusu" required>
              <el-input v-model="form.zhusu"></el-input>
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span=20>
            <el-form-item label="现病史" prop="history" required>
              <el-input type="textarea" v-model="form.history" ></el-input>
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span=20> <el-form-item label="既往史" prop="jiwang" required>
            <el-input type="textarea" v-model="form.jiwang"></el-input>
          </el-form-item></el-col>
        </el-row>
        <el-row>
          <el-col :span=20>
            <el-form-item label="过敏史" prop="guoming" required >
              <el-input type="textarea" v-model="form.guoming" ></el-input>
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span=20>
            <el-form-item label="体格检查" prop="exam" required>
              <el-input type="textarea" v-model="form.exam"></el-input>
            </el-form-item>
          </el-col>
        </el-row>
        <el-form-item label="疾病诊断">
          <el-row style="float: right">
            <el-button size="small" type="primary" icon="el-icon-plus" round @click="diseaseDiaglog = true">添加疾病</el-button>
            <el-button size="small" type="danger" icon="el-icon-delete" round  @click="deleteDisease()">删除疾病</el-button>
          </el-row>
                  <el-table
            ref="multipleTable"
            :data="diseaseTable"
            tooltip-effect="dark"
            style="width: 100%"
            @selection-change="handleSelectionChange">
            <el-table-column
              type="selection"
              width="55">
            </el-table-column>
            <el-table-column
              label="ICD"
              prop="icd"
              width="250">
            </el-table-column>
            <el-table-column
              prop="disName"
              label="名称"
              width="260">
            </el-table-column>
            <el-table-column
              prop="date"
              label="日期"
              width="250">
              <template slot-scope="scope">{{ scope.row.date }}</template>
            </el-table-column>
          </el-table>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="submitForm('form')">确认</el-button>
          <el-button @click="resetForm('form')">重置</el-button>
        </el-form-item>
      </el-form>

      <el-dialog title="选择疾病" :visible.sync="diseaseDiaglog">
        <el-form :model="form" rules="diseaseFormRule" style="padding-right: 20px">
          <el-row>
            <el-col :span=10>
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
            </el-col>
            <el-col :span=10 offset=2>
              <el-date-picker
                v-model="tempDate"
                value-format="yyyy-MM-dd"
                align="right"
                type="date"
                placeholder="选择日期"
                :picker-options="pickerOptions">
              </el-date-picker>
            </el-col>
          </el-row>
          <el-form-item>
            <el-table :data="diseaseData"
                      ref="singleTable"
                      height="300"
                      highlight-current-row
                      @current-change="handleCurrentChangeTemplate">
              <el-table-column property="icd" label="ICD" width="150"></el-table-column>
              <el-table-column property="disName" label="名称" width="200"></el-table-column>
              <el-table-column property="pinyin" label="拼音助记码"></el-table-column>
            </el-table>
          </el-form-item>
        </el-form>
        <div slot="footer" class="dialog-footer">
          <el-button @click="diseaseDiaglog = false">取 消</el-button>
          <el-button type="primary" @click="addDisease">确 定</el-button>
        </div>
      </el-dialog>
    </div>
</template>

<script>
  export default {
    name:"diagnose",
    props:{
      patient: Object,
      doctor: Object
    },
    created(){
      console.log("[diagnose 得到的患者信息]"+this.patient.pName);
      console.log("[diagnose 得到的doc信息]"+this.doctor.uID);
      console.log('[diagnose]uid '+this.$cookies.get("uID"));
    },
    data() {
      return {
        form: {
          zhusu: null,
          jiwang: null,
          guoming: null,
          history: null,
          exam: null,
        },
        diseaseDiaglog:false,
        multipleSelection:[],
        diseaseTable:[],
        diseaseData:[
          {
            icd:'ai1223',
            disName:'破伤风',
            pinyin:'psf'
          },
          {
            icd:'3',
            disName:'感冒',
            pinyin:'gm'
          },{
            icd:'ai123',
            disName:'伤寒',
            pinyin:'psf'
          }
        ],
        tempDate:null, //选择疾病得发病日期
        tempSelectDisease:{}, //选择得疾病
        rules: {
          zhusu: [
            { required: true, message: '主诉不能为空', trigger: 'change' },
          ],
          guoming: [
            { required: true, message: '过敏史不能为空', trigger: 'change' },
          ],
          jiwang: [
            { required: true, message: '既往史不能为空', trigger: 'change' }
          ],
          history: [
            { required: true, message: '现病史不能为空', trigger: 'change' },
          ],
          exam: [
            { required: true, message: '体格检查不能为空', trigger: 'change' },
          ]
        },
        /*diseaseFormRule:{
          tempDate:[
            { required: true, message: '请选择发病日期', trigger: 'change',type:'datetime' },
          ]
        },*/
        options: [],
        value: [],
        list: [],
        loading: false
      }
    },
    methods: {
      handleCurrentChangeTemplate(val) {
        console.log("药品："+val);
        //this.tempSelectDisease = val;
        this.tempSelectDisease.id=val.id;
        this.tempSelectDisease.icd=val.icd;
        this.tempSelectDisease.disName=val.disName;
        this.tempSelectDisease.date=this.tempDate;
        this.tempDate=null;
        console.log(val);
      },
      //药品远程搜索
      remoteMethod(query) {
        if (query !== '') {
          this.loading = true;
          this.axios.get("http://localhost:8090/searchDisease",{
            params: {
              str: query
            }
          })
            .then((response) => {
              console.log(response.data);//请求的返回体
              this.list=response.data;
              this.diseaseData=response.data;
            })
            .catch((error) => {
              console.log(error);//异常
            });
        } else {
          this.options = [];
        }
      },
      submitForm(formName) {
        console.log("[disgnose doctor]"+this.doctor);
        let disease=[];
        let temp={};
        for(let index in this.diseaseTable){
          temp.id=this.diseaseTable[index].id;
          temp.disName=this.diseaseTable[index].disName;
          disease.push(temp);
        }
        const data={
          "history": this.form.history,
          "zhusu":this.form.zhusu,
          "type":"西医诊断",
          "jiwang":this.form.jiwang,
          "guoming":this.form.guoming,
          "exam":this.form.exam,
          "doctorID":1,
          "regID":this.patient.regID,
          "diseases":disease
        }
        this.$axios({
          method:"post",
          url:"diagnose",
          contentType:'application/json;charset=utf-8',
          dataType:'json',
          data:data
        }).then((res)=>{
          console.log(res);
          this.$alert('提交成功', '提示', {
            confirmButtonText: '确定',
            callback: action => {
            }
          });
        });
      },
      resetForm(formName) {
        this.$refs[formName].resetFields();
      },
      handleSelectionChange(val) {
        this.multipleSelection = val;
        console.log(val);
      },
      addDisease:function () {

        this.tempSelectDisease.date=this.tempDate;
        this.tempSelectDisease.key=this.diseaseTable.length;
        this.diseaseTable.push(this.tempSelectDisease);
        console.log(this.diseaseTable);
        this.tempSelectDisease={};
        this.diseaseDiaglog=false;
      },
      deleteDisease:function () {
            for(var i in this.multipleSelection){
              console.log(this.multipleSelection[i]);
            this.diseaseTable.splice(this.diseaseTable.indexOf(this.multipleSelection[i]).key,1);
            }
      },
    }
  }
</script>

<style scoped>

</style>
