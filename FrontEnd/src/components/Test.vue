<template>
  <div class="test_container">
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
    
    <div>
      <br/><br/><br/><br/><br/><br/>
      <el-row class="callBtn" type="flex" style="left: 60%;">
        <el-button  @click="sw1(1)" :type="Color1" plain>乱针绣</el-button>
        <el-button  @click="sw2(2)" :type="Color2" plain>缎面绣</el-button>
        <el-button  @click="sw3(3)" :type="Color3" plain>长短针绣</el-button>
        <el-button  @click="sw4(4)" :type="Color4" plain>十字绣</el-button>
      </el-row>
    </div>
      <div class="callChartAaea">
        <div
          class="irregular"
          v-show="showChart == 1"
          :style="{
            height: '260px',
            width: '800px',
            boxShadow:
              '0 2px 4px rgba(0, 0, 0, .12), 0 0 6px rgba(0, 0, 0, .04)',
          }"
        > 
          <el-image 
              style="width: 150px; height:200px;left: 4%;top:13%"
              :src="'src/assets/img/l1.jpg'"
              :fit="fit"
              :preview-src-list="src_irregular"
              >
          </el-image>
          <el-image 
            style="width: 350px; height:200px;left:9%;top:13%"
            :src="'src/assets/img/l2.jpg'"
            :fit="fit"
            :preview-src-list="src_irregular"
            >
          </el-image>
          <el-image 
            style="width: 150px; height:200px;left:14%;top:13%"
            :src="'src/assets/img/l3.jpg'"
            :fit="fit"
            :preview-src-list="src_irregular"
            >
          </el-image>
        </div>
        <div
          class="satin"
          v-show="showChart == 2"
          :style="{
            height: '260px',
            width: '800px',
            boxShadow:
              '0 2px 4px rgba(0, 0, 0, .12), 0 0 6px rgba(0, 0, 0, .04)',
          }"
        >
        <el-image 
            style="width: 300px; height:200px;left: 31%;top:13%"
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
            width: '800px',
            boxShadow:
              '0 2px 4px rgba(0, 0, 0, .12), 0 0 6px rgba(0, 0, 0, .04)',
          }"
        > <el-image 
            style="width: 140px; height:200px;left: 5%;top:13%"
            :src="'src/assets/img/c1.jpg'"
            :fit="fit"
            :preview-src-list="src_longshort3"
            >
          </el-image>
          <el-image 
            style="width: 300px; height:200px;left: 10%;top:13%"
            :src="'src/assets/img/c2.jpg'"
            :fit="fit"
            :preview-src-list="src_longshort3"
            >
          </el-image>
          <el-image 
            style="width: 200px; height:200px;left: 15%;top:13%"
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
            width: '800px',
            boxShadow:
              '0 2px 4px rgba(0, 0, 0, .12), 0 0 6px rgba(0, 0, 0, .04)',
          }"
        ><el-image 
            style="width: 800px; height:240px;top:4%"
            :src="'src/assets/img/s.jpg'"
            :fit="fit"
            :preview-src-list="src_cross"
            >
          </el-image>
        </div>
      </div>
    
   

    <div>
      <br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
      <el-row class="callBtn0" type="flex" style="left:60%">
        <el-button  @click="sw10(1)" :type="Color10" plain>乱针绣</el-button>
        <el-button  @click="sw20(2)" :type="Color20" plain>缎面绣</el-button>
        <el-button  @click="sw30(3)" :type="Color30" plain>长短针绣</el-button>
        <el-button  @click="sw40(4)" :type="Color40" plain>十字绣</el-button>
      </el-row>
    </div>
      <div class="callChartAaea0">
        <div
          class="irregular0"
          v-show="showChart0 == 1"
          :style="{
            height: '260px',
            width: '800px',
            boxShadow:
              '0 2px 4px rgba(0, 0, 0, .12), 0 0 6px rgba(0, 0, 0, .04)',
          }"
        > 
          <!-- <el-image 
              style="width: 150px; height:200px;left: 4%;top:13%"
              :src="'src/assets/img/l1.jpg'"
              :fit="fit"
              :preview-src-list="src_irregular"
              >
          </el-image> -->
          <el-image 
            style="width: 180px; height:235px;left:15%;top:5%"
            :src="'src/assets/img/l11.jpg'"
            :fit="fit"
            :preview-src-list="src_irregular"
            >
          </el-image>
          <el-image 
            style="width: 180px; height:235px;left:40%;top:5%"
            :src="'src/assets/img/l12.jpg'"
            :fit="fit"
            :preview-src-list="src_irregular"
            >
          </el-image>
        </div>
        <div
          class="satin0"
          v-show="showChart0 == 2"
          :style="{
            height: '260px',
            width: '800px',
            boxShadow:
              '0 2px 4px rgba(0, 0, 0, .12), 0 0 6px rgba(0, 0, 0, .04)',
          }"
        >
        <el-image 
            style="width: 180px; height:235px;left: 40%;top:5%"
            :src="'src/assets/img/d0.jpg'"
            :fit="fit"
            :preview-src-list="src_satin"
            >
          </el-image>
        </div>
        <div
          class="longshort0"
          v-show="showChart0 == 3"
          :style="{
            height: '260px',
            width: '800px',
            boxShadow:
              '0 2px 4px rgba(0, 0, 0, .12), 0 0 6px rgba(0, 0, 0, .04)',
          }"
        > <el-image 
            style="width: 300px; height:230px;left: 8%;top:3%"
            :src="'src/assets/img/c10.jpg'"
            :fit="fit"
            :preview-src-list="src_longshort3"
            >
          </el-image>
          <el-image 
            style="width: 300px; height:240px;left: 20%;top:4%"
            :src="'src/assets/img/c20.jpg'"
            :fit="fit"
            :preview-src-list="src_longshort3"
            >
          </el-image>
          <!-- <el-image 
            style="width: 200px; height:200px;left: 15%;top:13%"
            :src="'src/assets/img/c3.jpg'"
            :fit="fit"
            :preview-src-list="src_longshort3"
            >
          </el-image> -->
        </div>
        <div
          class="cross0"
          v-show="showChart0 == 4"
          :style="{
            height: '260px',
            width: '800px',
            boxShadow:
              '0 2px 4px rgba(0, 0, 0, .12), 0 0 6px rgba(0, 0, 0, .04)',
          }"
        ><el-image 
            style="width: 800px; height:240px;top:4%"
            :src="'src/assets/img/s0.jpg'"
            :fit="fit"
            :preview-src-list="src_cross"
            >
          </el-image>
        </div>
      </div>
    </div>

  </template>
  <script>
  
  export default {
    mounted() {
    this.drawLine();
  },
  data() {
    return {
      Color1: "",
      Color2: "",
      Color3: "",
      Color4: "",
      Color10: "",
      Color20: "",
      Color30: "",
      Color40: "",
    };
  },
  methods: {
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
};
</script>
<style lang="less" scoped>
    //样式
 
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
  left: 44.8%;
 }  
 .satin{
  position: absolute;//居中
  top: 35%;
  left: 44.8%;
 } 
 .longshort{
  position: absolute;//居中
  top: 35%;
  left: 44.8%;
 } 
 .cross{
  position: absolute;//居中
  top: 35%;
  left: 44.8%;
 }  
 .irregular0{
  position: absolute;//居中
  top: 95%;
  left: 44.8%;
 }  
 .satin0{
  position: absolute;//居中
  top: 95%;
  left: 44.8%;
 } 
 .longshort0{
  position: absolute;//居中
  top: 95%;
  left: 44.8%;
 } 
 .cross0{
  position: absolute;//居中
  top: 95%;
  left: 44.8%;
 } 
</style>