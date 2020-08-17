<template>
  <el-form :model="ruleForm" :rules="rules" ref="ruleForm" size="medium" label-width="100px" class="demo-ruleForm">
    <el-row>

        <el-form-item label="病历号" prop="bingliID" required>
          <el-col :span=6 >
          <el-input size="medium" v-model="ruleForm.bingliID" @keyup.native.enter="searchPatient"></el-input>
          </el-col>
          <el-col span=8 offset=1>
            <el-button type="primary" @click="getBingliID" style="padding-left: 20px">获取病历号</el-button>

          </el-col>
        </el-form-item>
    </el-row>
    <el-row>
      <el-col :span="8">
        <el-form-item label="姓名" prop="name" required>
          <el-input v-model="ruleForm.name"></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="2"></el-col>
      <el-col :span="12">
        <el-form-item label="" prop="gender" required>
          <el-radio-group v-model="ruleForm.gender">
            <el-radio label="男"></el-radio>
            <el-radio label="女"></el-radio>
          </el-radio-group>
        </el-form-item>
      </el-col>
    </el-row>

    <el-row>
      <el-col :span="10">
        <el-form-item label="出生日期" prop="birthdate" required>
          <el-date-picker type="date" format="yyyy-MM-dd" value-format="yyyy-MM-dd" placeholder="选择日期" v-model="ruleForm.birthdate" style="width: 100%;"></el-date-picker>
        </el-form-item>
      </el-col>
      <el-col :span="2"> </el-col>
      <el-col :span="6">
        <el-form-item label="年龄" prop="age">
          <el-input v-model="ruleForm.age"></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="1"> </el-col>
      <el-col :span="5">
        <el-form-item label="类型" prop="ageType">
          <el-input v-model="ruleForm.ageType"></el-input>
        </el-form-item>
      </el-col>
    </el-row>
    <el-form-item label="身份证号" prop="shenfenID" required>
      <el-input v-model="ruleForm.shenfenID"></el-input>
    </el-form-item>
    <el-form-item label="家庭住址" prop="address">
      <el-input type="textarea" v-model="ruleForm.address"></el-input>
    </el-form-item>
    <el-row>
        <el-col :span="10">
          <el-form-item label="看诊日期" prop="registerDate" required>
            <el-date-picker type="date" placeholder="选择日期" v-model="ruleForm.registerDate" style="width: 100%;"></el-date-picker>
          </el-form-item>
      </el-col>
      <el-col :span="8">
        <el-form-item label="午别" prop="wubie" required>
          <el-select v-model="ruleForm.wubie" >
            <el-option label="上午" value="morning"></el-option>
            <el-option label="下午" value="afternoon"></el-option>
          </el-select>
        </el-form-item>
      </el-col>
    </el-row>
    <el-row>
      <el-col :span="10">
        <el-form-item label="科室" prop="department" required>
          <el-select v-model="ruleForm.department"  @change="getDoctors">
          <el-option
            v-for="item in departmentList"
            :key="item.departmentID"
            :label="item.dName"
            :value="item.departmentID">
          </el-option>
          </el-select>
        </el-form-item>
      </el-col>
      <el-col :span="6">
        <el-form-item label="号别" prop="level" required>
          <el-select v-model="ruleForm.level"  @change="getPrice">
            <el-option label="普通号" value="2"></el-option>
            <el-option label="专家号" value="1"></el-option>
          </el-select>
        </el-form-item>
      </el-col>
    </el-row>
    <el-form-item label="医生" prop="doctor" required>
      <el-select v-model="ruleForm.doctor" >
        <el-option
          v-for="item in doctorList"
          :key="item.uID"
          :label="item.realName"
          :value="item.uID">
        </el-option>
      </el-select>

    </el-form-item>
    <el-row>
      <el-col :span="8">
        <el-form-item label="收费方式" prop="type" required>
          <el-select v-model="ruleForm.type" >
            <el-option label="支付宝" value="1"></el-option>
            <el-option label="微信" value="2"></el-option>
            <el-option label="现金" value="3"></el-option>
          </el-select>
        </el-form-item>
      </el-col>
      <el-col :span="8">
        <el-form-item label="病历本" prop="hasNote" >
          <el-switch v-model="ruleForm.hasNote" @change="calculatePrice"></el-switch>
        </el-form-item>
      </el-col>
    </el-row>
    <el-form-item label="应收金额" prop="amount">
      <el-input v-model="ruleForm.amount"></el-input>
    </el-form-item>
    <el-form-item>
      <el-button type="primary" @click="submitForm('ruleForm')">立即挂号</el-button>
      <el-button @click="resetForm('ruleForm')">重置</el-button>
    </el-form-item>
  </el-form>

</template>

<script>
  export default {
    name:"Register",
    data() {
      var idcardReg = /^[1-9]\d{7}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}$|^[1-9]\d{5}[1-9]\d{3}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}([0-9]|X)$/;
      var checkID = (rule, value, callback) => {
        if (value==='') {
          callback(new Error('请填写身份证号'));
        }else {
          if (!idcardReg.test(value)) {
            callback(new Error('身份证号不符合格式'));
          }
          callback();
        }
      };
      return {
        departmentList:  [],
        doctorList:[
          {
            value: '1',
            label: '医生1'
          },{
            value: '2',
            label: '医生2'
          },
        ],
        allDoctors:[],
        registrar:{},
        ruleForm: {
          name: null,
          age: null,
          gender:null,
          birthdate:null,
          address:null,
          ageType: null,
          bingliID: null,
          shenfenID: null,
          registerDate:null,
          wubie:null,
          level:null,
          type:null,
          hasNote:false,
          amount:null,
          department:null,
          doctor:null,
          levelPrice:null
        },
        rules: {
          name: [
            { required: true, message: '请输入姓名' , trigger: 'blur' },
          ],
          shenfenID: [
            { required: true, validator: checkID,trigger: 'blur' },
          ],
          department: [
            { required: true, message: '请选择科室', trigger: 'change' }
          ],
          doctor: [
            { required: true, message: '请选择医生', trigger: 'change' }
          ],
          level: [
            { required: true, message: '请选择挂号级别', trigger: 'change' }
          ],
          birthdate: [
            { required: true, message: '请选择日期', trigger: 'change' }
          ],
          registerDate: [
            { required: true, message: '请选择日期', trigger: 'change' }
          ],
          type: [
            {  required: true, message: '请选择支付方式', trigger: 'change' }
          ]
        }
      };
    },
    created(){
      //页面加载时 向请求后端 病历号，部门 用户等信息
      this.getDepart();
      console.log("register.uID"+this.$cookies.get("uID"));
    },
    watch(){

      //监听部门变化
      //修改医生列表 doctorList

      //监听病历号变化

    },
    methods: {
      calculatePrice(){
        console.log(this.ruleForm.hasNote);
        if(this.ruleForm.hasNote){
          this.ruleForm.amount=this.ruleForm.levelPrice+1;
        }
      },
      getPrice(){
        this.axios.get("http://localhost:8090/register/getLevelPrice?levelID="+this.ruleForm.level).then((response) => {
          console.log(response.data);//请求的返回体
          if(this.ruleForm.hasNote){
            this.ruleForm.amount=response.data+1;
          }else {
            this.ruleForm.amount=response.data;
          }
          this.ruleForm.levelPrice=response.data;
        })
          .catch((error) => {
            console.log(error);//异常
          });
      },
      //生成病历号
      getBingliID:function(){
        this.axios.get("http://localhost:8090/getBingliID").then((response) => {
            console.log(response.data);//请求的返回体
            this.$set(this.ruleForm,"bingliID",response.data);
          })
          .catch((error) => {
            console.log(error);//异常
          });
      },
      getDoctors(){
        console.log(this.ruleForm.department);
        this.axios.get("http://localhost:8090/register/getDocs?departID="+this.ruleForm.department
        ).then((response) => {
          console.log(response.data);
          this.doctorList=response.data;
        })
          .catch((error) => {
            console.log(error);//异常
          });
      },
      getDepart(){
        console.log(this.$route.params);
        this.registrar = this.$route.params.user;
        this.axios.get("http://localhost:8090/register/getDepart"
        ).then((response) => {
          console.log(response.data);
           this.departmentList=response.data;
        })
          .catch((error) => {
            console.log(error);//异常
          });
      },
      //根据病历号查询患者信息
      searchPatient:function(){
        this.axios.get("http://localhost:8090/register/PatientInfo?bingliID="+this.ruleForm.bingliID
        ).then((response) => {
          console.log(response.data);//请求的返回体
          this.ruleForm.shenfenID=response.data.shenfenID;
          this.ruleForm.address=response.data.address;
          this.ruleForm.age=response.data.age;
          this.ruleForm.ageType=response.data.ageType;
          this.ruleForm.name=response.data.pName;
          this.ruleForm.gender=response.data.sex;
          this.$set(this.ruleForm,'birthdate',response.data.birthdate);
        })
          .catch((error) => {
            console.log(error);//异常
          });
      },
      submitForm(formName) {
       const data={
          "name":this.ruleForm.name,
         "age":this.ruleForm.age,
            "gender":this.ruleForm.gender,
            "birthdate":this.ruleForm.birthdate,
            "ageType":this.ruleForm.ageType,
            "shenfenID":this.ruleForm.shenfenID,
            "regStatus":1,
            "address":this.ruleForm.address,
            "regDate":this.ruleForm.registerDate,
            "department":this.ruleForm.department,
            "doctorID":this.ruleForm.doctor,
            "level":this.ruleForm.level,
            "type":this.ruleForm.type,
            "medRecordID":this.ruleForm.bingliID,
            "registrarID":this.$cookies.get("uID"),
            "wubie":this.ruleForm.wubie,
            "hasNote":this.ruleForm.hasNote
        }
        this.axios({
          method:"post",
          url:"http://localhost:8090/register",
          data: this.$qs.stringify(data)
        }).then((res)=>{
          console.log(res);
          this.$alert('挂号成功', '提示', {
            confirmButtonText: '确定',
            callback: action => {
            }
          });
        });
      },
      resetForm(formName) {
        this.$refs[formName].resetFields();
      }
    }
  }
</script>

<style scoped>

</style>
