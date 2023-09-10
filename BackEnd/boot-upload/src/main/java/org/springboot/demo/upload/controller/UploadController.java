package org.springboot.demo.upload.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springboot.demo.upload.cc.UplightImage;
import org.springboot.demo.upload.service.FileFervice;
import org.springboot.demo.upload.util.Format;
import org.springboot.demo.upload.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/upload")
@CrossOrigin
public class UploadController {
    @Autowired
    private FileFervice fileservice;

    private Logger logger = LoggerFactory.getLogger(UploadController.class);

    private static final String FONT_ROUTE = "E:\\Lab\\GraduationDesign\\font";//前端地址
    private static final String IMG_ROUTE = "E:\\boot-upload\\";//后端地址
    @PostMapping("/singlefile")
    public Object singleFileUpload(MultipartFile file, HttpServletResponse res) {
        logger.debug("传入的文件参数：{}", JSON.toJSONString(file, true));
        if (Objects.isNull(file) || file.isEmpty()) {
            logger.error("文件为空");
            return "文件为空，请重新上传";
        }

        try {
            byte[] bytes = file.getBytes();
            Path path = Paths.get(IMG_ROUTE + "files\\1.jpg");
            //文件写入指定路径
            Files.write(path, bytes);
            logger.debug("文件写入成功...");
            return "100成功";
        } catch (Exception e) {
            e.printStackTrace();
            return "后端异常...";
        }

    }
    @PostMapping("/posterGeneration")
    public Object posterGeneration(@RequestParam String mainHeading, @RequestParam String subHeading,@RequestParam String detail) {

        try {
            if(mainHeading == null && subHeading == null && detail == null){
                mainHeading= "刺绣技法重构";
                subHeading = "十字绣";
                detail = "刺绣在中国拥有久远的发展史";
            }

            List<String> l = Format.initPoster(mainHeading,subHeading,detail);
            JSONObject json = new JSONObject();
            List<String> list = new ArrayList<>();
            int index = 0;
            for(int i = 0;i <6;i++){
                list.add("/static/ResultImgs/" + l.get(i));
            }
            json.put("urls", list);
            //res.getWriter().write(json.toString());
            //return "文件上传成功";
            return json.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "后端异常...";
        }

    }
    @PostMapping("/singlefile0")
    public Object singleFileUpload0(MultipartFile file, HttpServletResponse res) {
        logger.debug("传入的文件参数：{}", JSON.toJSONString(file, true));
        if (Objects.isNull(file) || file.isEmpty()) {
            logger.error("文件为空");
            return "文件为空，请重新上传";
        }

        try {
            byte[] bytes = file.getBytes();
            Path path = Paths.get(FONT_ROUTE+"\\src\\assets\\img\\2.jpg");
            //文件写入指定路径
            Files.write(path, bytes);
            logger.debug("文件写入成功...");

            return "src/assets/img/2.jpg";
        } catch (Exception e) {
            e.printStackTrace();
            return "后端异常...";
        }

    }
    @PostMapping("/stitches")
    public Object stitchesReconstruction(@RequestBody String Para) {

        if (Objects.isNull(Para) || Para.isEmpty()) {
            logger.error("参数为空");
            return "请重新选择参数";
        }
        int ParaDigit = Integer.valueOf(Para.substring(9,10));
        //System.out.println(ParaDigit);
        String stitchPara = "";
        switch (ParaDigit){
            case 1:stitchPara = "乱针绣";
                   break;
            case 2:stitchPara = "缎面绣";
                break;
            case 3:stitchPara = "长短针绣";
                break;
            case 4:stitchPara = "十字绣模式一";
                break;
            case 5:stitchPara = "十字绣模式二";
                break;
            default:
                stitchPara = "非法数据";
                break;
        }
        try {
            UplightImage.process(stitchPara);
            return "src/assets/result.png";
        } catch (IOException e) {
            e.printStackTrace();
            return "重构失败";
        }

    }
    @RequestMapping("/getImg")
    public Object getImg(){
        //log.info("获取所有用户的市民码");
        //根据自己的返回格式返回就行
        return new Result().ok("200", "查询完成",fileservice.personImgs());
    }
}
