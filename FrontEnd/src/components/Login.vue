<template>
    <div class="login_container">
      <div class="login_box">
      
      <!--      表单提交区域-->
      <el-form :rules="loginFormRules" ref="loginFormRef" label-width="85px" class="login_form" :model="loginForm">
        <div class="login_title"><h2>Login</h2></div>
        
        <!--        用户名-->
        <el-form-item label="账号" prop="username">
          <el-input v-model="loginForm.username" prefix-icon="el-icon-s-custom" placeholder="请输入用户名"></el-input>
        </el-form-item>
        <!--        密码-->
        <el-form-item label="密码" prop="password">
          <el-input type="password" v-model="loginForm.password" prefix-icon="el-icon-lock" placeholder="请输入密码"></el-input>
        </el-form-item>
        <!--        按钮区-->
        <el-form-item class="btns">
          <div style="width: 375px;height: 60px;text-align: center;" >
                <el-button type="primary" style="width:80%;" round size="medium"  @click="login" :loading="loginLoading">登录</el-button>   
                <br/>
                <el-button type="text" @click="resetLoginForm">忘记密码？</el-button>
          </div> 
          
        </el-form-item>
      </el-form>
    </div>
    </div>
  </template>
  <script>
  export default {
    name: 'Login',
  data() {
    return {
      loginLoading: false, // 登录限制
      loginForm: {
        // 登录的表单数据的绑定对象
        username: '',
        password: ''
      },
      loginFormRules: {
        // 验证用户名是否合法
        username: [
          { required: true, message: '请输入登录名称', trigger: 'blur' },
          { min: 3, max: 10, message: '长度在 3 到 10 个字符', trigger: 'blur' }
        ],
        // 验证密码是否合法
        password: [
          { required: true, message: '请输入登录密码', trigger: 'blur' },
          { min: 6, max: 15, message: '长度在 6 到 15 个字符', trigger: 'blur' }
        ]
      }
    }
  },methods: {
    resetLoginForm() {
      // 点击重置按钮,重置登录表单
      // this.$refs[loginFormRef].resetFields()
      this.$refs.loginFormRef.resetFields()
    },
    login() {
      this.loginLoading = true
      this.$refs.loginFormRef.validate(async valid => { 
        if (!valid) {
          return (this.loginLoading = false)
        }        
        this.$message.success('登录成功!')
        // 2. 通过编程式路由导航跳转到后台主页,路由地址是 /home
        this.$router.push('/index')       
      })
    }
  }
  };
    
  </script>
  <style lang="less" scoped>
  .login_container {
    width:100%;
    height: 100%;
    background-image:url("../assets/background.jpg");
    background-size: cover;
    background-position: center;
    position: relative;
  }
  .login_title{
    position: relative;
    text-align: center;
    width:100%;
    left: 3%;
  }
  .login_box {
  position: absolute;//居中
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  width: 450px;
  height: 300px;
  background-color: transparent;
  border-radius: 3px;
  .avatar_box {
    position: absolute;
    left: 50%;
    transform: translate(-50%, -50%);
    
    width: 100px;
    height: 100px;
    border: 1px solid #c0c0c0;
    border-radius: 50%;
    box-shadow: 0 0 10px #c0c0c0;
    background-color: #fff;
    img {
      width: 100%;
      height: 100%;
      border-radius: 50%;
      background-color: #c0c0c0;
    }
  }
  .login_form {
    border:1px solid  transparent;
    border-radius: 15px;
    padding-right: 30px;
    /* 为其整体设置接近透明的效果*/
    background-color: rgba(255,255,255,0.1);
    /* 设置box-shadow使其有立体感 */
    box-shadow: 5px 5px 0 0  rgba(0,0,0,0.2);
    position: relative;
    left: -15px;
  }
  .el-form-item__label{
        /* 给el-form组件的label标签颜色修改 */
        color: #FFFFFF;
    }

    .el-input__inner{
        /* 使input框的背景变透明 */
        background-color: transparent;
        /* 使边框也变透明 */
        border-color: transparent;
        /* 给边框加阴影能够使其有立体感 */
        box-shadow: 2px 2px 0 0 rgba(0,0,0,0.2);
        /* 改变获取焦点后的竖线颜色 */
        caret-color: rgba(0, 255, 255,0.8);
        color:#FFFFFF;
        
    }

    .el-input__inner:hover{
        border-color: rgb(0, 255, 255);
    }

    .el-input__inner:focus{
        border-color: aqua;
    }

  .btns {
    display: flex;
    justify-content: flex-end;
  }
}
  </style>