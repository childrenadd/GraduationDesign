<template>
  <div class = "hello">
    
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
        <el-menu-item index="1" style="font-size:16px;font-family: \534E\6587\6977\4F53;font-weight:bold"  @click="go_index">首页</el-menu-item>
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
      <div class="infile0"> <input type="file" @change="getFile($event)"></div>
      <div class="upfile0">
        <el-button   @click="submit0($event)" style=" font-size: 15px; color: black; font-family: \4EFF\5B8B; font-weight: bold;">图片上传&nbsp;&nbsp;<i class="iconfont icon-upload" style="color:#409EFF;"></i></el-button>
         <!-- <button class="button button-primary button-pill button-small" @click="submit($event)">图片上传</button> -->
         
      </div>
    </form>
    <br />
    <br />
    <br />
    <div style="position: absolute; width: 330px;height: 330px; left: 44.6%;top: 15px ;box-shadow:12px 12px 12px 12px rgba(0,0,0,0.1)">
      </div>
      <div style="position: absolute; width: 330px;height: 330px; left: 75%;top: 15px ;box-shadow:12px 12px 12px 12px rgba(0,0,0,0.1)"></div>
    <form>
    <div class="WZ">
      <h2 style="text-align: center;font-weight:bolder; font-family: \534E\6587\6977\4F53;">刺绣针迹样式</h2>
    </div>
    <!-- 多选 -->
    <div class="ZJselect">
      <el-select v-model="value" placeholder="请选择" :append-to-body="false">
        <el-option
          v-for="item in options"
          :key="item.value"
          :label="item.label"
          :value="item.value">
        </el-option>
      </el-select>
    </div>
    <!-- 中间标志 -->
    <i class="iconfont icon-arrow-right" style="position: absolute;left:70%;top:170px;font-size: 30px;color:#409EFF;"></i>
    <!-- <i class="el-icon-share"  style="font-size:40px; font-weight: 300;color:#909399;"></i> -->
    <el-button class="downicon" style=" font-size: 15px; color: black; font-family: \4EFF\5B8B; font-weight:bold;"  @click="downloadImg">图片下载&nbsp;<i class="iconfont icon-download" style="color: #409EFF; "></i></el-button>
    
    <div class="CG" >
      <el-button style="width: 280px;height: 50px;text-align: center;font-weight: 500;color: black; font-family: \534E\6587\6977\4F53;font-size: 25px; font-weight:bolder;" 
         @click="reconstruction">重 构&nbsp;<i class="iconfont icon-process" style="color: #409EFF; "></i></el-button>
    </div>
    </form>
   
    <!-- 原图显示 -->
      <div class="demo-image__preview_0" v-for="fit in fits" :key="fit">
        <!-- <div v-if='isRouterAlive0'>
          <el-image 
            style="width: 300px; height:300px"
            :src="'src/assets/img/default.png'"
            :fit="fit"
            >
          </el-image>
        </div> -->
        <div>
          <el-image 
            style="width: 300px; height:300px"
            :src="'src/assets/img/2.jpg'"
            :fit="fit"
            :preview-src-list="srcList0">
          </el-image>
        </div>
      </div>
    
    <!-- 重构图片显示 -->
      <div class="demo-image__preview_1" v-for="fit in fits" :key="fit">
        <!-- <div v-if='isRouterAlive1'>
          <el-image 
            style="width: 300px; height:300px"
            :src="'src/assets/img/default1.png'"
            :fit="fit"
            >
          </el-image>
        </div> -->
        <div>
          <el-image 
            style="width: 300px; height:300px"
            :src= "'src/assets/result.png'" 
            :fit="fit"
            :preview-src-list="srcList1">
          </el-image>
        </div>
      </div>
    </div>
    
  </div>
</template>

<style  lang="less" scoped>
//  #hello{
//     background:url("../assets/bg.png");
//     width:100%;			//大小设置为100%
//     height:100%;			//大小设置为100%
//     position:relative;
//     background-size:100% 100%;}
.hello{
  width:100%;
  position: relative;
}
.content{
  width:100%;
  height: 100%;
  position: relative;
  top: 130px;
  
}
.el-drawer__container ::-webkit-scrollbar {
        display: none;
    }
.infile0{
  position: absolute;//居中
  left: 10%;
  top:130px;
}
.upfile0{
  position: absolute;//居中
  left: 25%;
  top: 120px;
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
.ZJselect{
  
  position: absolute;//居中
  left: 25%;
  top: 220px;
}
.WZ{
  position: absolute;//居中
  top: 210px;
  left: 10%;
}
.demo-image__preview_0{
  position: absolute;//居中
  top: 30px;
  left: 45.5%;
}
.demo-image__preview_1{
  position: absolute;//居中
  top: 30px;
  left: 76%;
}
.downicon{
  position: absolute;//居中
  top: 400px;
  left: 82%;
}
.shareicon{
  position: absolute;//居中
  top: 80%;
  left: 85%;
}
.CG{
  position: absolute;//居中
  top: 400px;
  left: 15%;
}
.ZN{
  position: absolute;//居中
  top: 100%;
  left:40.5%;
}
.infile{
  position: absolute;//居中
  left: 20%;
  top: 130%;
}
.upfile{
  position: absolute;//居中
  left: 35%;
  top: 128.5%;
}

.el-row {
    margin-bottom: 20px;

    &:last-child {
      margin-bottom: 0;
    }
  }
  .el-col {
    border-radius: 4px;
  }
  .bg-purple-dark {
    background: #99a9bf;
  }
  .bg-purple {
    background: #d3dce6;
  }
  .bg-purple-light {
    background: #e5e9f2;
  }
  .grid-content {
    border-radius: 4px;
    min-height: 300px;
  }
  .row-bg {
    padding: 10px 0;
    background-color: #f9fafc;
  }
 </style>


<script>
  import axios from 'axios';
  import { Loading } from 'element-ui';
  let loading;

  export default {
    name: 'Stitches',
    inject:['reload'],                                 //注入App里的reload方法
    data() {
      return {
        activeIndex: '2',
        fits: ['contain'],
        url: require('@/assets/cat.png'),
        srcResult: [
         require('@/assets/result.png')
        ],
        reconImg:'',
        Echo:'',
        msg: 'Reconstruction System Of Embroidery Stitches',
        file: '',
        imgs: [
        ],
        isRouterAlive: true,
        srcList0: [
          'http://localhost:8080/src/assets/img/2.jpg'
        ],
        srcList1: [
          'http://localhost:8080/src/assets/result.png'
        ],
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
        //console.log(this.file);
      },
      downloadImg(){
        this.downloading = true //下载按钮的状态控制
        let x = new XMLHttpRequest();
        x.open("GET", 'http://localhost:8080/src/assets/result.png', true); //图片地址
        x.responseType = 'blob';
        x.onload = (e)=>{
          var url = window.URL.createObjectURL(x.response)
          var a = document.createElement('a');
          a.href = url
          a.download = ''
          a.click()
        }
        x.send();
        //监听onreadystatechange 判断返回值以改变状态（下载完成，恢复可点击状态）
        x.onreadystatechange = ()=>{
          if(x.readyState === 4){ //请求已完成，且响应已就绪
            this.downloading = false //下载状态复原
          }
        }
      }
,
      reconstruction(){
        console.log(this.value);
        const startLoading = () => {  // 使用Element loading-start 方法
        loading = Loading.service({
            lock: true,
            text: '技法重构中，请稍后...',
            background: 'rgba(0, 0, 0, 0.7)'
          });
        };
        startLoading();  // 开启加载
        let chedata = {
          data: this.value
        }
        axios.post('http://localhost:8082/upload/stitches', {
          data: this.value,
        }).then((response) => {
            //this.reload();
            //this.imgs = [];
            //alert("已完成重构");
            console.log(response);
            
            this.reconImg = response.data;
            location. reload();
            //this.reload();
            //window.location.reload();
            // let i = 0;
            // for(let val of response.data.urls){
            //   this.$set(this.imgs, i++, val);
            //   //console.log(val);
            // }
          })
          .catch(function (error) {
            alert("重构失败，请检查输入参数");
            location.reload();
            console.log(error);
            //window.location.reload();
          });
      },
      submit0: function (event) {
        //组织元素发生默认的行为
        const sLoading = () => {  // 使用Element loading-start 方法
        loading = Loading.service({
            lock: true,
            text: '图片上传中...',
            background: 'rgba(0, 0, 0, 0.7)'
          });
        };
        sLoading();  // 开启加载
        event.preventDefault();
        let formData = new FormData();
        formData.append("file", this.file);
        
        axios.post('http://localhost:8082/upload/singlefile0', formData)
          .then((response) => {
            //this.reload();
            //this.imgs = [];
            //alert("图片上传成功");
            console.log(response);        
            this.Echo = response.data;
            location.reload();
            //alert(this.Echo);
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

