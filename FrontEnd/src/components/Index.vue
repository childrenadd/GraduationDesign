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
          <el-menu-item index="1" style="font-size:16px;font-family: \534E\6587\6977\4F53;font-weight:bold" @click="go_index" >首页</el-menu-item>
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
        <div class="demo-image__preview_0" v-for="fit in fits" :key="fit">
          <el-image 
            style="width: 700px; height:900px"
            :src="'src/assets/img/CiXiuLoGo.png'"
            :fit="fit"
            >
          </el-image>
        </div>
         <el-divider style="font-weight: bolder;" class="Divi_irregular">刺绣作品集</el-divider>
        <el-divider style="font-weight: bolder;" class="Divi_satin">技法重构集</el-divider>
        <div>
      <br/><br/><br/><br/><br/><br/>
      <el-row class="callBtn" type="flex" style="left: 52.3%;">
        <el-button  @click="sw1(1)" :type="Color1" plain>乱针绣</el-button>
        <el-button  @click="sw2(2)" :type="Color2" plain>缎面绣</el-button>
        <el-button  @click="sw3(3)" :type="Color3" plain>长短针绣</el-button>
        <el-button  @click="sw4(4)" :type="Color4" plain>十字绣</el-button>
      </el-row>
    </div>
       <div
          class="irregular"
          :style="{
            height: '260px',
            width: '900px',
            boxShadow:
              '0 2px 4px rgba(0, 0, 0, .12), 0 0 6px rgba(0, 0, 0, .04)',
          }"
        > 
          
        </div>
      <div class="callChartAaea">
        <div
          class="irregular"
          v-show="showChart == 1"
          :style="{
            height: '260px',
            width: '900px',
            boxShadow:
              '0 2px 4px rgba(0, 0, 0, .12), 0 0 6px rgba(0, 0, 0, .04)',
          }"
        > 
          <el-image 
              style="width: 150px; height:200px;left: 7.5%;top:12%"
              :src="'src/assets/img/l1.jpg'"
              :fit="fit"
              :preview-src-list="src_irregular1"
              >
          </el-image>
          <el-image 
            style="width: 350px; height:200px;left:13.5%;top:12%"
            :src="'src/assets/img/l2.jpg'"
            :fit="fit"
            :preview-src-list="src_irregular2"
            >
          </el-image>
          <el-image 
            style="width: 150px; height:200px;left:19.5%;top:12%"
            :src="'src/assets/img/l3.jpg'"
            :fit="fit"
            :preview-src-list="src_irregular3"
            >
          </el-image>
        </div>
        <div
          class="satin"
          v-show="showChart == 2"
          :style="{
            height: '260px',
            width: '900px',
            boxShadow:
              '0 2px 4px rgba(0, 0, 0, .12), 0 0 6px rgba(0, 0, 0, .04)',
          }"
        >
        <el-image 
            style="width: 300px; height:200px;left: 33.5%;top:12%"
            :src="'src/assets/img/d.jpg'"
            :fit="fit"
            :preview-src-list="src_satin"
            >
          </el-image>
        </div>
        <div
          class="longshort"
          v-show="showChart == 3"
          :style="{
            height: '260px',
            width: '900px',
            boxShadow:
              '0 2px 4px rgba(0, 0, 0, .12), 0 0 6px rgba(0, 0, 0, .04)',
          }"
        > <el-image 
            style="width: 140px; height:200px;left: 6%;top:13%"
            :src="'src/assets/img/c1.jpg'"
            :fit="fit"
            :preview-src-list="src_longshort1"
            >
          </el-image>
          <el-image 
            style="width: 300px; height:200px;left: 15%;top:13%"
            :src="'src/assets/img/c2.jpg'"
            :fit="fit"
            :preview-src-list="src_longshort2"
            >
          </el-image>
          <el-image 
            style="width: 200px; height:200px;left: 23%;top:13%"
            :src="'src/assets/img/c3.jpg'"
            :fit="fit"
            :preview-src-list="src_longshort3"
            >
          </el-image>
        </div>
        <div
          class="cross"
          v-show="showChart == 4"
          :style="{
            height: '260px',
            width: '900px',
            boxShadow:
              '0 2px 4px rgba(0, 0, 0, .12), 0 0 6px rgba(0, 0, 0, .04)',
          }"
        ><el-image 
            style="width: 800px; height:240px;left:5.4%;top:4%"
            :src="'src/assets/img/s.jpg'"
            :fit="fit"
            :preview-src-list="src_cross"
            >
          </el-image>
        </div>
      </div>
    
   

    <div>
      <br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
      <el-row class="callBtn0" type="flex" style="left:52.3%">
        <el-button  @click="sw10(1)" :type="Color10" plain>乱针绣</el-button>
        <el-button  @click="sw20(2)" :type="Color20" plain>缎面绣</el-button>
        <el-button  @click="sw30(3)" :type="Color30" plain>长短针绣</el-button>
        <el-button  @click="sw40(4)" :type="Color40" plain>十字绣</el-button>
      </el-row>
    </div>
       <div
          class="irregular0"
          :style="{
            height: '260px',
            width: '900px',
            boxShadow:
              '0 2px 4px rgba(0, 0, 0, .12), 0 0 6px rgba(0, 0, 0, .04)',
          }"
        > 
        </div>
      <div class="callChartAaea0">
        <div
          class="irregular0"
          v-show="showChart0 == 1"
          :style="{
            height: '260px',
            width: '900px',
            boxShadow:
              '0 2px 4px rgba(0, 0, 0, .12), 0 0 6px rgba(0, 0, 0, .04)',
          }"
        > 
          <el-image 
            style="width: 180px; height:235px;left:18%;top:5%"
            :src="'src/assets/img/l11.jpg'"
            :fit="fit"
            :preview-src-list="src_irregular11"
            >
          </el-image>
          <el-image 
            style="width: 180px; height:235px;left:42%;top:5%"
            :src="'src/assets/img/l12.jpg'"
            :fit="fit"
            :preview-src-list="src_irregular12"
            >
          </el-image>
        </div>
        <div
          class="satin0"
          v-show="showChart0 == 2"
          :style="{
            height: '260px',
            width: '900px',
            boxShadow:
              '0 2px 4px rgba(0, 0, 0, .12), 0 0 6px rgba(0, 0, 0, .04)',
          }"
        >
        <el-image 
            style="width: 180px; height:235px;left: 40%;top:5%"
            :src="'src/assets/img/d0.jpg'"
            :fit="fit"
            :preview-src-list="src_satin0"
            >
          </el-image>
        </div>
        <div
          class="longshort0"
          v-show="showChart0 == 3"
          :style="{
            height: '260px',
            width: '900px',
            boxShadow:
              '0 2px 4px rgba(0, 0, 0, .12), 0 0 6px rgba(0, 0, 0, .04)',
          }"
        > <el-image 
            style="width: 300px; height:230px;left: 10%;top:-3%"
            :src="'src/assets/img/c10.jpg'"
            :fit="fit"
            :preview-src-list="src_longshort10"
            >
          </el-image>
          <el-image 
            style="width: 315px; height:255px;left: 21%;top:1%"
            :src="'src/assets/img/c20.jpg'"
            :fit="fit"
            :preview-src-list="src_longshort20"
            >
          </el-image>
          
        </div>
        <div
          class="cross0"
          v-show="showChart0 == 4"
          :style="{
            height: '260px',
            width: '900px',
            boxShadow:
              '0 2px 4px rgba(0, 0, 0, .12), 0 0 6px rgba(0, 0, 0, .04)',
          }"
        ><el-image 
            style="width: 800px; height:240px;left:5.5%;top:4%"
            :src="'src/assets/img/s0.jpg'"
            :fit="fit"
            :preview-src-list="src_cross0"
            >
          </el-image>
        </div>
      </div>
      </div>
        
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
  top: 0px;
   //el-row 宽度溢出修复
  //滚动条隐藏
  overflow-x: hidden;
  padding: 0 30px;
  box-sizing: border-box;
}
.el-drawer__container ::-webkit-scrollbar {
        display: none;
    }
    .demo-image__preview_0{
        position: absolute;//居中
        top: 15%;
        left: -7%;
    }
    .el-button--primary:focus {
  background-color: #545c64;
  border-color: #545c64;
  color: #FFFF00;
}
 
.el-button--primary:hover {
  background: #545c64;
  border-color: #545c64;
  color: #FFFF00;
}
 
.el-button--primary.is-active, .el-button--primary:active {
    background: #545c64;
  border-color: #545c64;
  color: #FFFF00;
}

 .irregular{
  position: absolute;//居中
  top: 35%;
  left: 35%;
 }  
 .satin{
  position: absolute;//居中
  top: 35%;
  left: 35%;
 } 
 .longshort{
  position: absolute;//居中
  top: 35%;
  left: 35%;
 } 
 .cross{
  position: absolute;//居中
  top: 35%;
  left: 35%;
 }  
 .irregular0{
  position: absolute;//居中
  top: 670px;
  left: 35%;
 }  
 .satin0{
  position: absolute;//居中
  top: 670px;
  left: 35%;
 } 
 .longshort0{
  position: absolute;//居中
  top: 670px;
  left: 35%;
 } 
 .cross0{
  position: absolute;//居中
  top: 670px;
  left: 35%;
 } 
    .Divi_irregular{
        position: absolute;//居中
        width: 950px;
        top: 50px;
        left: 33%;
    }
    .Divi_satin{
        position: absolute;//居中
        width: 950px;
        top: 500px;
        left: 33%;
    }
</style>
  <script>
  import axios from 'axios';
  import qs from 'qs';
  export default {
    name: 'Poster',
    inject:['reload'],                                 //注入App里的reload方法
    data() {
      return {
        activeIndex: '1',
        fits: ['fill'],
        url: require('@/assets/cat.png'),
        srcList: [
        require('@/assets/cat.png')
        ],
        Color1: "",
        Color2: "",
        Color3: "",
        Color4: "",
        Color10: "",
        Color20: "",
        Color30: "",
        Color40: "",
        src_irregular1: [
        'http://localhost:8080/src/assets/img/l1.jpg'],
        src_irregular2: [
        'http://localhost:8080/src/assets/img/l2.jpg'],
        src_irregular3: [
        'http://localhost:8080/src/assets/img/l3.jpg'],
        src_satin: [
        'http://localhost:8080/src/assets/img/d.jpg'],
        src_longshort1: [
        'http://localhost:8080/src/assets/img/c1.jpg'],
        src_longshort2: [
        'http://localhost:8080/src/assets/img/c2.jpg'],
        src_longshort3: [
        'http://localhost:8080/src/assets/img/c3.jpg'],
        src_cross: [
        'http://localhost:8080/src/assets/img/s.jpg'],
        src_irregular11: [
        'http://localhost:8080/src/assets/img/l11.jpg'],
        src_irregular12: [
        'http://localhost:8080/src/assets/img/l12.jpg'],
        src_irregular13: [
        'http://localhost:8080/src/assets/img/l13.jpg'],
        src_satin0: [
        'http://localhost:8080/src/assets/img/d0.jpg'],
        src_longshort10: [
        'http://localhost:8080/src/assets/img/c10.jpg'],
        src_longshort20: [
        'http://localhost:8080/src/assets/img/c20.jpg'],
        src_longshort30: [
        'http://localhost:8080/src/assets/img/c30.jpg'],
        src_cross0: [
        'http://localhost:8080/src/assets/img/s0.jpg'],
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
        ruleForm: {
          mainHeading: '',
          subHeading: '',
          detail: ''
        },
        rules: {
          mainHeading: [
            { required: true, message: '请输入主标题', trigger: 'blur' },
            { min: 1, max: 10, message: '长度在 1 到 10 个字符', trigger: 'blur' }
          ],
          subHeading: [
            { required: true, message: '请输入副标题', trigger: 'blur' },
            { min: 1, max: 5, message: '长度在 1 到 5 个字符', trigger: 'blur' }
          ],
          detail: [
            { required: true, message: '请输入详细信息描述', trigger: 'blur' },
            { min: 1, max: 20, message: '长度在 1 到 20 个字符', trigger: 'blur' }
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
        var params = {}
        params.mainHeading = this.ruleForm.mainHeading
        params.subHeading = this.ruleForm.subHeading
        params.detail = this.ruleForm.detail
        
        console.log(params);
        axios.post('http://localhost:8082/upload/posterGeneration',qs.stringify({mainHeading:this.ruleForm.mainHeading,subHeading:this.ruleForm.subHeading,detail:this.ruleForm.detail})).then((response) => {
            //this.reload();
            //this.imgs = [];
            alert("已为您生成6张海报");
            console.log(response);
            
            this.imgs = response.data.urls;
          })
          .catch(function (error) {
            alert("重构失败");
            console.log(error);
            //window.location.reload();
          });
      },
      submit: function (event) {
        //组织元素发生默认的行为
        event.preventDefault();
        let formData = new FormData();
        formData.append("file", this.file);
        
        axios.post('http://localhost:8082/upload/singlefile', formData)
          .then((response) => {
            //this.reload();
            //this.imgs = [];
            alert("图片上传成功");
             console.log(response);
            
   
          })
          .catch(function (error) {
            alert("上传失败");
            console.log(error);
            //window.location.reload();
          });
          //window.location.reload();
      },
      sw1(val) {
      this.showChart = val;
      
        this.Color1 = "primary";
        this.Color2 = "";
        this.Color3 = "";
        this.Color4 = "";
      
    },
    sw2(val) {
      this.showChart = val;
      
        this.Color1 = "";
        this.Color2 = "primary";
        this.Color3 = "";
        this.Color4 = "";
      
    },sw3(val) {
      this.showChart = val;
      
        this.Color1 = "";
        this.Color2 = "";
        this.Color3 = "primary";
        this.Color4 = "";
      
    },sw4(val) {
      this.showChart = val;
      
        this.Color1 = "";
        this.Color2 = "";
        this.Color3 = "";
        this.Color4 = "primary";
      
    },sw10(val) {
      this.showChart0 = val;
      
        this.Color10 = "primary";
        this.Color20 = "";
        this.Color30 = "";
        this.Color40 = "";
      
    },
    sw20(val) {
      this.showChart0 = val;
      
        this.Color10 = "";
        this.Color20 = "primary";
        this.Color30 = "";
        this.Color40 = "";
      
    },sw30(val) {
      this.showChart0 = val;
      
        this.Color10 = "";
        this.Color20 = "";
        this.Color30 = "primary";
        this.Color40 = "";
      
    },sw40(val) {
      this.showChart0 = val;
      
        this.Color10 = "";
        this.Color20 = "";
        this.Color30 = "";
        this.Color40 = "primary";
      
    }
    }
  }
</script>