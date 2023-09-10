<template>
  <div class="hello">
    <h1>{{ msg }}</h1>
    <form>
      <input type="file" @change="getFile($event)">
      <button class="button button-primary button-pill button-small" @click="submit($event)">图片上传</button>
    </form>
    <!-- <img :src="url"> -->
    <br />
    
    <h1>海报生成结果</h1>
    <h1></h1>
    <h1></h1>
    <el-row>
      <div v-for="(item, index) in imgs" :key="index" class="image-middle">  
        <el-col :span="8">
          <el-card shadow="hover" :body-style="{ padding: '10px' }">     
          
          <el-popover> 
            <img :src="item" slot="reference" class="image"/>    
            <img :src="item" class="imagePreview"/>
          </el-popover>  
          <!-- <div style="text-align:center;padding-top:12px">
            <span>{{imgs[index].name}}</span>
          </div>      -->
          </el-card>
        </el-col>
        </div>  
    </el-row>  
  </div>
 
    


</template>

<style scoped>
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
  margin-right: 10px;
  margin-bottom: 0px;
}
/* 单张图片样式 */
.image{
  width:380px;
  height: 650px;
}
 </style>

<script>
  import axios from 'axios';

  export default {
    name: 'HelloWorld',
    inject:['reload'],                                 //注入App里的reload方法
    data() {
      return {
        msg: 'Welcome To Generation Of Poster',
        file: '',
        imgs: [
        ],
        isRouterAlive: true,
      }
    },
    methods: {
      getFile: function (event) {
        this.file = event.target.files[0];
        console.log(this.file);
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
            alert("已为您生成9张海报");
            console.log(response);
            
            this.imgs = response.data.urls;
            //this.reload();
            //window.location.reload();
            // let i = 0;
            // for(let val of response.data.urls){
            //   this.$set(this.imgs, i++, val);
            //   //console.log(val);
            // }
          })
          .catch(function (error) {
            alert("上传失败");
            console.log(error);
            //window.location.reload();
          });
          //window.location.reload();
      }
    }
  }
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
  h1, h2 {
    font-weight: normal;
  }

  .button-pill {
    border-radius: 200px;
  }

  .button-primary, .button-primary-flat {
    background-color: #1B9AF7;
    border-color: #1B9AF7;
    color: #FFF;
  }

  .button {
    /* color: #FFF;
    background-color: #1B9AF7;
    border-color: #EEE; */
    font-size: 16px;
    font-family: "Helvetica Neue Light", "Helvetica Neue", Helvetica, Arial, "Lucida Grande", sans-serif;
    text-decoration: none;
    text-align: center;
    line-height: 40px;
    height: 40px;
    padding: 0 40px;
    margin: 0;
    display: inline-block;
    appearance: none;
    cursor: pointer;
    border: none;
    -webkit-box-sizing: border-box;
    -moz-box-sizing: border-box;
    box-sizing: border-box;
    -webkit-transition-property: all;
    transition-property: all;
    -webkit-transition-duration: .3s;
    transition-duration: .3s;
  }

  .button-small {
    font-size: 12px;
    height: 30px;
    line-height: 30px;
    padding: 0 30px;
  }
</style>
