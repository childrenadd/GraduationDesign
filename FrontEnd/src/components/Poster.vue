<template>
  
  <div class="hello">
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
        <el-menu-item index="1" style="font-size:16px;font-family: \534E\6587\6977\4F53;font-weight:bold" @click="go_index">首页</el-menu-item>
        <el-menu-item ></el-menu-item>
        <el-menu-item index="2" style="font-size:16px;font-family:  \534E\6587\6977\4F53;font-weight:bold" @click="go_reconstructSystem">技法重构</el-menu-item>
        <el-menu-item ></el-menu-item>
        <el-menu-item index="3" style="font-size:16px;font-family:   \534E\6587\6977\4F53;font-weight:bold" @click="go_poster">智能海报设计</el-menu-item>
        <el-menu-item ></el-menu-item>
        <el-menu-item index="4" style="font-size:16px;font-family: \534E\6587\6977\4F53;font-weight:bold" @click="go_infoEdit">个人中心</el-menu-item>
     </el-menu>
    </div>
    <!-- 页面内容部分 -->
    <div class="content">
      <form>
        <div class="infile"> <input type="file" @change="getFile($event)"></div>
        <div class="upfile">
          <el-button @click="submit($event)"  style="font-size: 15px; color: black; font-family: \4EFF\5B8B; font-weight: bold;">主元素图片上传&nbsp;&nbsp;<i class="iconfont icon-upload" style="color:#409EFF;"></i></el-button>
        </div>
      </form>
      <div class="HBXX_box">
        <el-form :model="ruleForm" :rules="rules" ref="ruleFormref" label-width="100px" class="demo-ruleForm">
            <el-form-item label="主标题" prop="mainHeading" >
                <el-input v-model="ruleForm.mainHeading"></el-input>
            </el-form-item>
            <el-form-item label="副标题" prop="subHeading">
                <el-input v-model="ruleForm.subHeading"></el-input>
            </el-form-item>
            <el-form-item label="详细信息" prop="detail">
                <el-input v-model="ruleForm.detail"></el-input>
            </el-form-item>
        </el-form>
      </div>
      <div class="SC" >
        <el-button style="width: 210px;height: 50px;text-align: center;color: black;font-weight: 500; font-family: \534E\6587\6977\4F53;font-size: 25px;font-weight:bolder;" 
        @click="posterDataSubmit" >生 成&nbsp;<i class="iconfont icon-process" style="color: #409EFF; "></i></el-button>
      </div>

      
      <el-divider style="font-weight: bolder;" class="Divi"></el-divider>
      <div class="HBSCJG">
        <h2 style="width: 210px;height: 50px;text-align: center;font-weight:bolder; font-family: \534E\6587\6977\4F53;">海报生成结果</h2>
      </div>
    
    
      <el-row type="flex" justify="center" class="imgHBSCJG">
        <div v-for="(item, index) in imgs" :key="index" class="image-middle">  
          <el-col :span="8">
            <!-- <el-card shadow="hover" :body-style="{ padding: '20px' }">      -->
            
            <el-popover
              placement="right"
              trigger="click"
              > 
              <img :src="item" slot="reference"  class="image"/>    
              <img :src="item" class="imagePreview"/>
            </el-popover>  
            <!-- <div style="text-align:center;padding-top:12px">
              <span>{{imgs[index].name}}</span>
            </div>      -->
            <!-- </el-card> -->
          </el-col>
          </div>  
      </el-row>
    </div>
    
<!--     
    <el-container>
      
      <el-header></el-header>
      
      <el-main></el-main>
      
      <el-footer style="background-color:#545c64;text-align: center;" >
        <p style="color:#fff;">Copyright &copy; 2023 移动媒体与文化计算实验室 All rights reserved.</p>
      </el-footer>
   </el-container> -->


  </div>
</template>

<style  lang="less" scoped>
.hello{
  width:100%;
  position: relative;
}
.content{
  width:100%;
  position: relative;
  top: 200px;
    //el-row 宽度溢出修复
  //滚动条隐藏
  
  padding: 0 30px;
  box-sizing: border-box;
}
.el-drawer__container ::-webkit-scrollbar {
        display: none;
    }

 /* “Tissue Search”字体样式 */
.position {
  margin-left: 15px;
  font-size: 30px;
  font-weight: 600;
}
/* 图片总布局，样式 */
.images{
  display: flex;
  margin-top: 10px;
  margin-left: 10px;
  margin-right: 10px;
  flex-wrap: wrap;
}
/* 图片之间 */
.image-middle{
  margin-right: 20px;
  margin-bottom: 0px;
}
/* 单张图片样式 */
.image{
  width:200px;
  height:350px;
}
.imagePreview{
  width:400px;
  height:700px;
}

.el-icon-d-arrow-right{
  position: absolute;//居中
  top: 45%;
  left: 52%;
}
.ZN{
  position: absolute;//居中
  top: 100%;
  left:40.5%;
}
.HBXX_box{
  position: absolute;//居中
  top: 35%;
  left: 65%;
  transform: translate(-50%, -50%);
  width: 450px;
  height: 300px;
  background-color: transparent;
  border-radius: 3px;
}
.infile{
  position: absolute;//居中
  left: 20%;
  top: -80px;
  
}
.upfile{
  position: absolute;//居中
  left: 35%;
  top: -90px;
}
.HBSCJG{
  position: absolute;//居中
  top: 130px;
  left: 43%;
}
.Divi{
  position: absolute;//居中
  width: 1200px;
  top: 100px;
  left: 10%;
}
.imgHBSCJG{
  position: absolute;//居中
  top: 220px;
  left: 7%;
}
.SC{
  position: absolute;//居中
  top: 50px;
  left: 43%;
}
.el-container {
  min-height: 100vh;
}

</style>


<script>
  import axios from 'axios';
  import qs from 'qs';
  import { Loading } from 'element-ui';
  let loading;

  export default {
    name: 'Poster',
    inject:['reload'],                                 //注入App里的reload方法
    data() {
      return {
        activeIndex: '3',
        fits: ['fill'],
        url: require('@/assets/cat.png'),
        srcList: [
        require('@/assets/cat.png')
        ],
        msg: 'Reconstruction System Of Embroidery Stitches',
        file: '',
        imgs: [
        ],
        isRouterAlive: true,
        options: [{
          value: '',
          label: ''
        }, {
          value: '1',
          label: '乱针绣针迹'
        }, {
          value: '2',
          label: '缎面绣针迹'
        }, {
          value: '3',
          label: '长短针迹'
        }, {
          value: '4',
          label: '十字绣针迹模式1'
        }, {
          value: '5',
          label: '十字绣针迹模式2'
        }],
        value: '',
        posterLoading: false,
        ruleForm: {
          mainHeading: '刺绣技法重构',
          subHeading: '十字绣',
          detail: '刺绣在中国拥有久远的发展史'
        },
        rules: {
          mainHeading: [
            { required: true, message: '请输入主标题', trigger: 'blur' },
            { min: 1, max: 7, message: '长度在 1 到 7 个字符', trigger: 'blur' }
          ],
          subHeading: [
            { required: true, message: '请输入副标题', trigger: 'blur' },
            { min: 1, max: 5, message: '长度在 1 到 5 个字符', trigger: 'blur' }
          ],
          detail: [
            { required: true, message: '请输入详细信息描述', trigger: 'blur' },
            { min: 1, max: 15, message: '长度在 1 到 15 个字符', trigger: 'blur' }
          ]
        }
      };
    },
    methods: {
      handleSelect(key, keyPath) {
        console.log(key, keyPath);
      },
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
      getFile: function (event) {
        this.file = event.target.files[0];
        console.log(this.file);
      },
      posterDataSubmit(){
        const startLoading = () => {  // 使用Element loading-start 方法
          loading = Loading.service({
            lock: true,
            text: '海报生成中，请稍后...',
            background: 'rgba(0, 0, 0, 0.7)'
          });
        };
        
        var params = {}
        params.mainHeading = this.ruleForm.mainHeading
        params.subHeading = this.ruleForm.subHeading
        params.detail = this.ruleForm.detail
        console.log(params);
        this.posterLoading = true;
        this.$refs.ruleFormref.validate(async valid => { 
          if (!valid) {
            
            return (this.posterLoading = false)
          }else{
            startLoading();  // 开启加载
            axios.post('http://localhost:8082/upload/posterGeneration',qs.stringify({mainHeading:this.ruleForm.mainHeading,subHeading:this.ruleForm.subHeading,detail:this.ruleForm.detail})).then((response) => {
              //alert("已为您生成6张海报");
              
              console.log(response);
              
              this.imgs = response.data.urls;
              if(this.imgs != null){
                loading.close(); // 关闭加载
              }
              //this.reload(); 
              // let i = 0;
              // for(let val of response.data.urls){
              //   this.$set(this.imgs, i++, val);
              //   //console.log(val);
             // }  
          })
          .catch(function (error) {
            alert("生成失败");
            loading.close(); // 关闭加载
            console.log(error);
            //window.location.reload();
          });
          }
          
        })
        
      },
      submit: function (event) {
        //组织元素发生默认的行为
        event.preventDefault();
        let formData = new FormData();
        formData.append("file", this.file);
        const sLoading = () => {  // 使用Element loading-start 方法
        loading = Loading.service({
            lock: true,
            text: '图片上传中……',
            background: 'rgba(0, 0, 0, 0.7)'
          });
        };
        sLoading();  // 开启加载
        axios.post('http://localhost:8082/upload/singlefile', formData)
          .then((response) => {
            //this.reload();
            //this.imgs = [];
            //alert("图片上传成功");
             console.log(response);
             location.reload();
            // this.imgs = response.data.urls;
            //this.reload();
            //window.location.reload();
            // let i = 0;
            // for(let val of response.data.urls){
            //   this.$set(this.imgs, i++, val);
            //   //console.log(val);
            // }
          })
          .catch(function (error) {
            alert("上传失败,请重新选择图片");
            console.log(error);
            location.reload();
            //window.location.reload();
          });
          //window.location.reload();
      }
    }
  }
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->

