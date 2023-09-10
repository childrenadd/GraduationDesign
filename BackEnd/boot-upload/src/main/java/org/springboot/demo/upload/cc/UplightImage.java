package org.springboot.demo.upload.cc;

/**
 * @author wxy
 * @date 2023/1/9 10:36
 */
import org.springframework.stereotype.Component;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

@Component
public class UplightImage {
    private static final String PYTHON_EXE_ROUTE = "F:\\python37\\python.exe";//py执行器地址
    private static final String STITCHES_ROUTE = "E:\\boot-upload\\";//后端地址
    private static final String FONT_ROUTE = "E:\\Lab\\GraduationDesign\\font\\";//前端地址
    public UplightImage() {
    }

    public static void upLightPoint(BufferedImage image, int x, int y, double redScale, double greenScale, double blueScale) {
        Pixel pixel = new Pixel();
        pixel.setRGB(image.getRGB(x, y));

        pixel.red = pixel.red + (int) ( (255 - pixel.red) * redScale);
        pixel.green = pixel.green + (int) ( (255 - pixel.green) * greenScale);
        pixel.blue = pixel.blue + (int) ( (255 - pixel.blue) * blueScale);

        image.setRGB(x, y, pixel.getRGB());
    }

    public static Pixel getImageScale(BufferedImage image, int x, int y) {
        Pixel pixel = new Pixel();
        x = x % image.getWidth();
        y = y % image.getHeight();
        pixel.setRGB(image.getRGB(x, y));
        return pixel;
    }

    public static BufferedImage mergerLightImage(BufferedImage image, BufferedImage mask) {
        BufferedImage bimg = image;
        Pixel scale;

        for (int y=0; y < image.getHeight(); y++) {
            for (int x=0; x < image.getWidth(); x++) {
                scale = getImageScale(mask, x, y);
                upLightPoint(bimg, x, y, scale.red/255.0, scale.green/255.0, scale.blue/255.0);
            }
        }

        return bimg;
    }
    public static void step1(String a,String b) throws IOException{
        BufferedImage img = ImageIO.read(new File(a));
        BufferedImage maskSnow = ImageIO.read(new File(b));
        BufferedImage img2 = UplightImage.mergerLightImage(img, maskSnow);
        ImageIO.write(img2, "png", new File(STITCHES_ROUTE+"src\\main\\java\\org\\springboot\\demo\\upload\\dbsy\\intermediate.png"));
    }
    public static void step2() throws IOException{
        Process proc;
        try {
            String[] aaa = new String[]{PYTHON_EXE_ROUTE, STITCHES_ROUTE+"src\\main\\java\\org\\springboot\\demo\\upload\\util\\PyFile\\touming.py"};
            proc = Runtime.getRuntime().exec(aaa);// 执行py文件
            proc.waitFor();
            /*System.out.println("ssss");*/
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static Boolean step3(String a,String b) throws IOException{

        try {
            /* 1 读取第一张图片*/
            File fileOne = new File(a);
            BufferedImage imageFirst = ImageIO.read(fileOne);
            /* 2读取第二张图片 */
            File fileTwo = new File(STITCHES_ROUTE+"src\\main\\java\\org\\springboot\\demo\\upload\\dbsy\\intermediate2.png");
            BufferedImage imageSecond = ImageIO.read(fileTwo);
            //创建一个最底层画布 高和宽为第一章图片的高和宽
            BufferedImage image = new BufferedImage(imageFirst.getWidth(),imageFirst.getHeight(),BufferedImage.TYPE_INT_ARGB);
            //通过底图创建画笔
            Graphics graphics = image.getGraphics();
            //在底图上画第一张图
            graphics.drawImage(imageFirst,0,0,null);
            //在底图上画第二张图
            graphics.drawImage(imageSecond,0,0,null);
            //在图片上写文字
            //graphics.drawString("i am a str", 10, 30);
            //输出图片
            File outFile = new File(FONT_ROUTE+"src\\assets\\result.png");
            ImageIO.write(image, "png", outFile);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

  /*  public static void main(String[] argv) throws IOException {
        String original = "G:\\实验室资料\\2023年1月\\原图&生成结果\\2.png";
        String stitch = "E:\\boot-upload\\src\\main\\java\\org\\springboot\\demo\\upload\\cc\\长短针绣.png";
        step1(original,stitch);
        step2();
        step3(original,stitch);


    }*/
    public static void process(String stitchPara) throws IOException{
        String fileName = FONT_ROUTE+"src\\assets\\img\\2.jpg";
        System.out.println(stitchPara);
        String stitch = STITCHES_ROUTE+"src\\main\\java\\org\\springboot\\demo\\upload\\cc\\"+stitchPara+".png";
        step1(fileName,stitch);
        step2();
        step3(fileName,stitch);
    }
}

