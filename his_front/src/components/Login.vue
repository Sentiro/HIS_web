<template>
  <div>
    <el-form ref="loginForm" :model="form" :rules="rules" label-width="80px" class="login-box">
      <h3 class="login-title">欢迎登录</h3>
      <el-form-item label="账号" prop="username">
        <el-input type="text" placeholder="请输入账号" v-model="form.username"/>
      </el-form-item>
      <el-form-item label="密码" prop="password">
        <el-input type="password" placeholder="请输入密码" v-model="form.password"/>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" v-on:click="onSubmit('loginForm')">登录</el-button>
      </el-form-item>
    </el-form>

    <el-dialog
      title="温馨提示"
      :visible.sync="dialogVisible"
      width="30%"
      :before-close="handleClose">
      <span>请输入账号和密码</span>
      <span slot="footer" class="dialog-footer">
        <el-button type="primary" @click="dialogVisible = false">确 定</el-button>
      </span>
    </el-dialog>
  </div>
</template>

<script>
  export default {
    name: "Login",
    data() {
      return {
        form: {
          username: '',
          password: ''
        },
        // 表单验证，需要在 el-form-item 元素中增加 prop 属性
        rules: {
          username: [
            {required: true, message: '账号不可为空', trigger: 'blur'}
          ],
          password: [
            {required: true, message: '密码不可为空', trigger: 'blur'}
          ]
        },
        // 对话框显示和隐藏
        dialogVisible: false
      }
    },
    methods: {
      onSubmit(formName) {
        var that=this;
        console.log(this.form.username + this.form.password);
        that.axios.post("http://localhost:8090/login",
          that.$qs.stringify(
             {
              'id': that.form.username,
              'password': that.form.password
            })
        ).then((response) => {
          this.$cookies.set("uID",response.data.uID);
          this.$cookies.set("login","true");
          if(response.data!=null){
            if(response.data.uType=='2'){//跳转挂号页面
              this.$router.push({name:'register',params:{user: response.data}})
            }else if(response.data.uType=='1'){//跳转药房医生页面
              this.$router.push({name:'distribute',params:{user:response.data}})
            }else if(response.data.uType=='3'){//跳转医生页面
              this.$router.push({name:'doctorMain',params:{user:response.data}});
            }else {
            }
          }else{
            this.$alert('用户名密码不正确', '登陆失败', {
              confirmButtonText: '确定',
            });
          }
        }).catch((error) => {
          console.log(error);
          this.$alert('用户名密码不正确', '登陆失败', {
            confirmButtonText: '确定',
          });
        });
      }
    }
  }
</script>

<style lang="scss" scoped>
  .login-box {
    border: 1px solid #DCDFE6;
    width: 350px;
    margin: 180px auto;
    padding: 35px 35px 15px 35px;
    border-radius: 5px;
    -webkit-border-radius: 5px;
    -moz-border-radius: 5px;
    box-shadow: 0 0 25px #909399;
  }

  .login-title {
    text-align: center;
    margin: 0 auto 40px auto;
    color: #303133;
  }
</style>
