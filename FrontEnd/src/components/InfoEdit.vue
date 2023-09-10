<template>
  <div  class="hello">
    <!-- 页面头部部分 -->
    <div class="header">
     
     <el-menu
        :default-active="activeIndex"
        class="el-menu-demo"
        mode="horizontal"
        @select="handleSelect"
        background-color="#545c64"
        text-color="#fff"
        active-text-color="#FFFF00">
        <el-menu-item ></el-menu-item>
        <el-menu-item ></el-menu-item>
        <el-menu-item ></el-menu-item>
        <el-menu-item >
          <img  src="static/logo.png" width="60px" height="60px">
        </el-menu-item>
      
        <el-menu-item style="font-size:30px;font-family: \534E\6587\6977\4F53; color:#fff;">刺绣技法重构系统</el-menu-item>
        <el-menu-item ></el-menu-item>
        <el-menu-item ></el-menu-item>
        <el-menu-item ></el-menu-item>
        <el-menu-item index="1" style="font-size:16px;font-family: \534E\6587\6977\4F53;font-weight:bold" @click="go_index" >首页</el-menu-item>
        <el-menu-item ></el-menu-item>
        <el-menu-item index="2" style="font-size:16px;font-family:  \534E\6587\6977\4F53;font-weight:bold" @click="go_reconstructSystem">技法重构</el-menu-item>
        <el-menu-item ></el-menu-item>
        <el-menu-item index="3" style="font-size:16px;font-family:   \534E\6587\6977\4F53;font-weight:bold" @click="go_poster">智能海报设计</el-menu-item>
        <el-menu-item ></el-menu-item>
        <el-menu-item index="4" style="font-size:16px;font-family: \534E\6587\6977\4F53;font-weight:bold" @click="go_infoEdit">个人中心</el-menu-item>
      </el-menu>
    </div>
    <div class="content">
      <div class="linkicon">
        <el-link type="primary" >注销</el-link>
      </div>
    
      <div class="login_box">
        <el-divider style="font-weight: bolder;">个人信息</el-divider>
        <!--      表单提交区域-->
        <el-form :rules="rules" label-width="85px" class="login_form" :model="loginForm">
            <!--        用户名-->
            <el-form-item label="昵称：" prop="username">
              <el-input v-model="loginForm.username"></el-input>
            </el-form-item>
            <el-form-item label="性别：" prop="username">
              <el-input v-model="loginForm.username"></el-input>
            </el-form-item>
            <el-form-item label="微信：" prop="username">
              <el-input v-model="loginForm.username"></el-input>
            </el-form-item>
            <el-form-item label="简介：" prop="username">
              <el-input v-model="loginForm.username"></el-input>
            </el-form-item>
            <!--        按钮区-->
            <el-form-item class="btns">
              <div style="width: 350px;height:30px;text-align: center;" >
                    <el-button type="info" plain  @click="login" :loading="loginLoading">保存</el-button>   
                    <br/>
              </div> 
            </el-form-item>
        </el-form>
        <el-divider style="">密码更改</el-divider>
        <!--      表单提交区域-->
        <el-form :rules="rules" label-width="85px" class="login_form" :model="loginForm">
            <!--        用户名-->
            <el-form-item label="旧密码：" prop="username">
              <el-input v-model="loginForm.username"></el-input>
            </el-form-item>
            <el-form-item label="新密码：" prop="username">
              <el-input v-model="loginForm.username"></el-input>
            </el-form-item>
            <el-form-item label="确认密码：" prop="username">
              <el-input v-model="loginForm.username"></el-input>
            </el-form-item>
            <!--        按钮区-->
            <el-form-item class="btns">
              <div style="width: 350px;height:30px;text-align: center;" >
                    <el-button type="info" plain  @click="login" :loading="loginLoading">保存</el-button>   
                    <br/>
              </div> 
            </el-form-item>
        </el-form>
      </div>
    </div>
    
  </div>
    
</template>
<script>
export default {
  name: 'InfoEdit',
data() {
  return {
    activeIndex: '4',
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
},
methods: {
      go_index(row) {
        this.$router.push('/index')
      },
      go_reconstructSystem(row) {
        this.$router.push('/stitches')
      },
      go_poster(row) {
        this.$router.push('/poster')
      },
      go_infoEdit(row) {
        this.$router.push('/infoEdit')
      },
}
};
  
</script>
<style lang="less" scoped>
.hello{
  width:100%;
  position: relative;
}
.content{
  width:100%;
  position: relative;
  top: 150px;
  
}
  
  .linkicon{
    position: absolute;//居中
    top: -115px;
    left: 68%;
  }
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
  top: 25%;
  left: 50%;
  transform: translate(-50%, -50%);
  width: 450px;
  height: 250px;
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
  }
  .login_form {
    border:1px solid  transparent;
    border-radius: 15px;
    padding-right: 50px;
   
    position: relative;
    
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
  .el-drawer__container ::-webkit-scrollbar {
        display: none;
    }
    
}
  </style>
  