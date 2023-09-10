package org.springboot.demo.upload.util;


import org.springboot.demo.upload.util.color.colorthief.ColorThiefMain;
import org.springboot.demo.upload.util.po.Poster;
import org.springframework.stereotype.Component;
import sun.font.FontDesignMetrics;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class Format {
    private static volatile boolean flag = false;
    private static final String IMG_ROUTE = "E:\\boot-upload\\";//后端地址
    private static final String FONT_ROUTE = "E:\\Lab\\GraduationDesign\\font\\";//前端地址
    public static void main(String[] args) throws Exception {
        String mainHeading = "刺绣技法重构";//主标题
        String subHeading = "十字绣";//副标题
        String detail = "刺绣在中国拥有久远的发展史";//详细文字
        System.out.println("开始生成海报...");

        long startTime = System.currentTimeMillis();
        java.util.List<String> resList = new ArrayList<>();
        for(int num =0;num < 6;num++){
            int index = new Random().nextInt(40);
            drawPoster(mainHeading,subHeading,detail,num,resList);
        }
        System.out.println("已完成，共耗时: " + (System.currentTimeMillis() - startTime) / 1000.0 + "s");

    }

    public static List<String> initPoster(String mainHeading, String subHeading,String detail) throws Exception{
        System.out.println("开始生成海报...");
        long startTime = System.currentTimeMillis();
        java.util.List<String> resList = new ArrayList<>();
        for(int num =0;num < 6;num++){
            int index = new Random().nextInt(27);
            drawPoster(mainHeading,subHeading,detail,num,resList);
        }
        System.out.println("耗时: " + (System.currentTimeMillis() - startTime) / 1000.0 + "s");
        return resList;
    }

     private static String bg_img = IMG_ROUTE + "src\\main\\resources\\draw\\bg\\bg3.png";
     private volatile static String primary_img = IMG_ROUTE + "files\\1.jpg";
     //private volatile static String primary_img = "E:\\draw\\src\\main\\resources\\draw\\PrimaryElement\\p5.png";
     private static String secondary_img0 = IMG_ROUTE + "src\\main\\resources\\draw\\SecondaryElement\\s1.png";
     private static String decorate1_img0 = IMG_ROUTE + "src\\main\\resources\\draw\\DecorativeElement1\\d10.png";
     private static String decorate1_img1 = IMG_ROUTE + "src\\main\\resources\\draw\\DecorativeElement1\\d11.png";
     private static String decorate2_img0 = IMG_ROUTE + "src\\main\\resources\\draw\\DecorativeElement2\\d23.png";
     private static String decorate2_img1 = IMG_ROUTE + "src\\main\\resources\\draw\\DecorativeElement2\\d24.png";
     private static String logo_img = IMG_ROUTE + "src\\main\\resources\\draw\\logo\\logo1.png";
     private static String barcode_img = IMG_ROUTE + "src\\main\\resources\\draw\\barcode\\b4.png";

    public static void drawPoster(String mainHeading, String subHeading,String detail,int num,List<String> resList) throws Exception {
        Poster poster = new Poster();

        //海报的宽度
        poster.setWidth(1242);
        //海报的高度
        poster.setHeight(2208);
        poster.setMainHeading(mainHeading);//主标题
        poster.setSubHeading(subHeading);//副标题
        poster.setDetail(detail);//详细文字

        Font mainFontStyle = FontUtil.getFont(28, 150);
        int mainSize = 150;
        Font subFontStyle = FontUtil.getFont(8, 80);
        int subSize = 80;
        Font detailFontStyle = FontUtil.getFont(18, 50);
        int detailSize = 50;
        //画布
        BufferedImage canvas = new BufferedImage(poster.getWidth(), poster.getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics2D g = (Graphics2D) canvas.getGraphics();
        //g.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);
        // 设置文字抗锯齿
        g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        BufferedImage bg = ImageIO.read(new File(bg_img));
        g.drawImage(bg.getScaledInstance(poster.getWidth(), poster.getHeight(), Image.SCALE_DEFAULT), 0, 0, null);

        //主素材
        BufferedImage primary = ImageIO.read(new File(primary_img));
        int primaryWidth = primary.getWidth();
        int primaryHeight = primary.getHeight();

        poster.setPrimaryWidth(primaryWidth);
        poster.setPrimaryHeight(primaryHeight);
        //辅助素材
        BufferedImage secondary = ImageIO.read(new File(secondary_img0));

        //装饰元素1
        BufferedImage decorate10 = ImageIO.read(new File(decorate1_img0));
        BufferedImage decorate11 = ImageIO.read(new File(decorate1_img1));

        //装饰元素2
        BufferedImage decorate20 = ImageIO.read(new File(decorate2_img0));
        BufferedImage decorate21 = ImageIO.read(new File(decorate2_img1));



        // logo
        BufferedImage logo = ImageIO.read(new File(logo_img));

        //二维码
        BufferedImage barcode = ImageIO.read(new File(barcode_img));

        //字体颜色
        ColorThiefMain ctm = new ColorThiefMain();

        String[] mainColor = ctm.test(IMG_ROUTE + "src\\main\\resources\\draw\\bg\\bg2.png");
        int red = colorReverse(Integer.parseInt(mainColor[0]));
        int green = colorReverse(Integer.parseInt(mainColor[1]));
        int blue = colorReverse(Integer.parseInt(mainColor[2]));
        //主标题
        poster.setMainFont(mainFontStyle);//字体
        poster.setMainColor(new Color(red,green,blue));//颜色red,green,blue
        //poster.setMainColor(new Color(red,255,255));
        //副标题
        poster.setSubFont(subFontStyle);
        poster.setSubColor(new Color(red,green,blue));
        //poster.setSubColor(new Color(255,255,255));
        //详细文字
        poster.setDetailFont(detailFontStyle);
        poster.setDetailColor(new Color(red,green,blue));
        //poster.setDetailColor(new Color(255,255,255));



        int firstMainHeadingWidth = 0;
        int secondMainHeadingWidth = 0;
        int firstSubHeadingWidth = 0;
        int secondSubHeadingWidth = 0;
        int firstDetailWidth = 0;
        int secondDetailWidth = 0;
        double curPrimaryWidth = 0;
        double curPrimaryHeight = 0;

        switch (num){
            //15
            case 0:
                //logo

//                g.setColor(new Color(251, 176, 58));
//                g.fillRect(548,63,145,55);//(552,66,134,52)

                poster.setLogoX(552);
                poster.setLogoY(66);
                poster.setLogoWidth(134);
                poster.setLogoHeight(52);

                //主素材
                /*
                g.setColor(new Color(254, 0, 0));
                g.fillRect(-49,765,1579,1369);(167,729,909,915)*/
                curPrimaryWidth = 909.0;
                curPrimaryHeight = 915.0;
                poster.setPrimaryX(167);
                poster.setPrimaryY(700);


                //详情文字

                /*
                g.setColor(new Color(0, 255, 1));
                g.fillRect(312,844,619,178);

                g.setColor(new Color(0, 255, 1));
                g.fillRect(540,2120,160,21);(253,1705,735,51)
                */
                poster.setDetailX(253);
                poster.setDetailY(1850);
                poster.setDetailWidth(735);
                poster.setDetailHeight(130);

                //主标题
                /*
                g.setColor(new Color(51, 51, 51));
                g.fillRect(288,329,666,216);(128,428,989,121)
                */
                poster.setMainX(108);
                poster.setMainY(200);
                poster.setMainWidth(1100);
                poster.setMainHeight(300);

                //副标题
                /*
                g.setColor(new Color(153, 153, 153));
                g.fillRect(244,624,755,70);(239,601,763,56)
                */
                poster.setSubX(239);
                poster.setSubY(410);
                poster.setSubWidth(763);
                poster.setSubHeight(100);

                //二维码
                /*g.setColor(new Color(102, 46, 145));
                g.fillRect(541,1877,160,160);*/
                poster.setBarcodeX(541);
                poster.setBarcodeY(1980);
                poster.setBarcodeWidth(160);
                poster.setBarcodeHeight(160);
                /*
                //logo
                g.setColor(new Color(251, 176, 58));
                g.fillRect(552,66,134,52);

                //主素材
                g.setColor(new Color(254, 0, 0));
                g.fillRect(167,729,909,915);

                //详情文字
                g.setColor(new Color(0, 255, 1));
                g.fillRect(521,296,199,67);

                g.setColor(new Color(0, 255, 1));
                g.fillRect(253,1705,735,51);

                g.setColor(new Color(0, 255, 1));
                g.fillRect(541,2055,160,26);

                //主标题
                g.setColor(new Color(51, 51, 51));
                g.fillRect(128,428,989,121);

                //副标题
                g.setColor(new Color(153, 153, 153));
                g.fillRect(239,601,763,56);

                //二维码
                g.setColor(new Color(102, 46, 145));
                g.fillRect(541,1877,160,160);*/
                break;
            //88
            case 1:
                //logo

//                g.setColor(new Color(251, 176, 58));
//                g.fillRect(548,63,145,55);//(93,65,130,38)

                poster.setLogoX(93);
                poster.setLogoY(65);
                poster.setLogoWidth(130);
                poster.setLogoHeight(38);

                //主素材
                /*
                g.setColor(new Color(254, 0, 0));
                g.fillRect(-49,765,1579,1369);(82,184,1094,890)*/
                curPrimaryWidth = 1094.0;
                curPrimaryHeight = 890;
                poster.setPrimaryX(82);
                poster.setPrimaryY(184);


                //详情文字

                /*
                g.setColor(new Color(0, 255, 1));
                g.fillRect(312,844,619,178);

                g.setColor(new Color(0, 255, 1));
                g.fillRect(540,2120,160,21);(278,1706,728,52);
                */
                poster.setDetailX(278);
                poster.setDetailY(1706);
                poster.setDetailWidth(728);
                poster.setDetailHeight(170);

                //主标题
                /*
                g.setColor(new Color(51, 51, 51));
                g.fillRect(288,329,666,216);(223,1209,793,194);
                */
                poster.setMainX(110);
                poster.setMainY(1220);
                poster.setMainWidth(1100);
                poster.setMainHeight(300);

                //副标题
                /*
                g.setColor(new Color(153, 153, 153));
                g.fillRect(244,624,755,70);(468,1463,298,71);
                */
                poster.setSubX(223);
                poster.setSubY(1463);
                poster.setSubWidth(793);
                poster.setSubHeight(100);

                /*//装饰素材2
                *//*
                g.setColor(new Color(255, 123, 172));
                g.fillRect(476,1282,606,561);(1061,65,82,164);
                *//*

                poster.setFirstDecorate2X(1061);
                poster.setFirstDecorate2Y(65);
                poster.setFirstDecorate2Width(82);
                poster.setFirstDecorate2Height(164);
                *//*g.setColor(new Color(102, 46, 145));
                g.fillRect(523,1883,203,203);*//*
                poster.setBarcodeX(523);
                poster.setBarcodeY(1883);
                poster.setBarcodeWidth(203);
                poster.setBarcodeHeight(203);*/
                //二维码
                /*g.setColor(new Color(102, 46, 145));
                g.fillRect(541,1877,160,160);*/
                poster.setBarcodeX(541);
                poster.setBarcodeY(1980);
                poster.setBarcodeWidth(160);
                poster.setBarcodeHeight(160);
                /*
                //logo
                g.setColor(new Color(251, 176, 58));
                g.fillRect(93,65,130,38);

                //主素材
                g.setColor(new Color(254, 0, 0));
                g.fillRect(82,184,1094,890);

                //装饰素材2
                g.setColor(new Color(255, 123, 172));
                g.fillRect(1061,65,82,164);
                g.fillRect(255,1695,772,74);

                //详情文字
                g.setColor(new Color(0, 255, 1));
                g.fillRect(424,1611,388,50);
                g.fillRect(278,1706,728,52);
                g.fillRect(545,2105,162,40);

                //主标题
                g.setColor(new Color(51, 51, 51));
                g.fillRect(223,1209,793,194);

                //副标题
                g.setColor(new Color(153, 153, 153));
                g.fillRect(468,1463,298,71);

                //二维码
                g.setColor(new Color(102, 46, 145));
                g.fillRect(523,1883,203,203);*/
                break;
            //22
            case 2:
                //logo

//                g.setColor(new Color(251, 176, 58));
//                g.fillRect(548,63,145,55);

                poster.setLogoX(113);
                poster.setLogoY(70);
                poster.setLogoWidth(129);
                poster.setLogoHeight(38);

                //主素材
                /*
                g.setColor(new Color(254, 0, 0));
                g.fillRect(-49,765,1579,1369);(114,684,1014,1035)*/
                curPrimaryWidth = 1014.0;
                curPrimaryHeight = 1035.0;
                poster.setPrimaryX(114);
                poster.setPrimaryY(684);


                //详情文字

                /*
                g.setColor(new Color(0, 255, 1));
                g.fillRect(312,844,619,178);

                g.setColor(new Color(0, 255, 1));
                g.fillRect(540,2120,160,21);(158,1831,518,192)
                */
                poster.setDetailX(158);
                poster.setDetailY(1950);
                poster.setDetailWidth(700);
                poster.setDetailHeight(192);

                //主标题
                /*
                g.setColor(new Color(51, 51, 51));
                g.fillRect(288,329,666,216);(111,451,1014,142)
                */
                poster.setMainX(111);
                poster.setMainY(300);
                poster.setMainWidth(1014);
                poster.setMainHeight(384);

                //副标题
                /*
                g.setColor(new Color(153, 153, 153));
                g.fillRect(244,624,755,70);(114,325,387,76)
                */
                poster.setSubX(114);
                poster.setSubY(150);
                poster.setSubWidth(500);
                poster.setSubHeight(150);

                //二维码
                /*g.setColor(new Color(102, 46, 145));
                g.fillRect(926,1828,160,160);*/
                poster.setBarcodeX(1000);
                poster.setBarcodeY(1980);
                poster.setBarcodeWidth(160);
                poster.setBarcodeHeight(160);

                /*
                //logo
                g.setColor(new Color(251, 176, 58));
                g.fillRect(113,137,129,38);

                //主素材
                g.setColor(new Color(254, 0, 0));
                g.fillRect(114,684,1014,1035);

                //装饰素材1
                g.setColor(new Color(205, 125, 255));
                g.fillRect(113,1773,1018,311);

                //详情文字
                g.setColor(new Color(0, 255, 1));
                g.fillRect(1006,138,125,49);

                g.setColor(new Color(0, 255, 1));
                g.fillRect(943,332,180,59);

                g.setColor(new Color(0, 255, 1));
                g.fillRect(158,1831,518,192);

                g.setColor(new Color(0, 255, 1));
                g.fillRect(926,2005,160,27);

                //主标题
                g.setColor(new Color(51, 51, 51));
                g.fillRect(111,451,1014,142);

                //副标题
                g.setColor(new Color(153, 153, 153));
                g.fillRect(114,325,387,76);

                //装饰素材2
                g.setColor(new Color(255, 123, 172));
                g.fillRect(113,208,1018,3);

                g.setColor(new Color(255, 123, 172));
                g.fillRect(112,619,1017,11);

                //二维码
                g.setColor(new Color(102, 46, 145));
                g.fillRect(926,1828,160,160);*/
                break;
            //5
            case 3:
                //logo

//                g.setColor(new Color(251, 176, 58));
//                g.fillRect(548,63,145,55);

                poster.setLogoX(1027);
                poster.setLogoY(77);
                poster.setLogoWidth(134);
                poster.setLogoHeight(52);

                //主素材
                /*
                g.setColor(new Color(254, 0, 0));
                g.fillRect(-49,765,1579,1369);(-134,-40,898,1224)*/
                curPrimaryWidth = 800.0;
                curPrimaryHeight = 2000.0;
                poster.setPrimaryX(70);
                poster.setPrimaryY(0);


                //详情文字

                /*
                g.setColor(new Color(0, 255, 1));
                g.fillRect(312,844,619,178);

                g.setColor(new Color(0, 255, 1));
                g.fillRect(540,2120,160,21);(92,2088,160,21)
                */
                poster.setDetailX(400);
                poster.setDetailY(1900);
                poster.setDetailWidth(600);
                poster.setDetailHeight(180);


                //主标题
                /*
                g.setColor(new Color(51, 51, 51));
                g.fillRect(288,329,666,216);(920,281,172,585)
                */
                poster.setMainX(990);
                poster.setMainY(281);
                poster.setMainWidth(172);
                poster.setMainHeight(1500);

                //副标题
                /*
                g.setColor(new Color(153, 153, 153));
                g.fillRect(244,624,755,70);(844,572,45,487);
                */
                poster.setSubX(904);
                poster.setSubY(572);
                poster.setSubWidth(45);
                poster.setSubHeight(800);
                /*//装饰素材2
                *//*
                g.setColor(new Color(255, 123, 172));
                g.fillRect(476,1282,606,561);

                g.fillRect(101,732,147,146);

                g.setColor(new Color(255, 123, 172));
                g.fillRect(999,66,95,96);
                *//*

                poster.setFirstDecorate2X(0);
                poster.setFirstDecorate2Y(350);
                poster.setFirstDecorate2Width(147);
                poster.setFirstDecorate2Height(146);

                poster.setSecondDecorate2X(700);
                poster.setSecondDecorate2Y(1650);
                poster.setSecondDecorate2Width(150);
                poster.setSecondDecorate2Height(120);*/

                //二维码
                /*g.setColor(new Color(102, 46, 145));
                g.fillRect(92,1908,160,160);*/
                poster.setBarcodeX(92);
                poster.setBarcodeY(1980);
                poster.setBarcodeWidth(160);
                poster.setBarcodeHeight(160);
                /*
                //logo
                g.setColor(new Color(251, 176, 58));
                g.fillRect(1027,77,134,52);

                //主素材
                g.setColor(new Color(254, 0, 0));
                g.fillRect(-134,-40,898,1224);

                g.setColor(new Color(254, 0, 0));
                g.fillRect(947,1275,553,689);

                //详情文字
                g.setColor(new Color(0, 255, 1));
                g.fillRect(92,2088,160,21);

                //主标题
                g.setColor(new Color(51, 51, 51));
                g.fillRect(920,281,172,585);

                //副标题
                g.setColor(new Color(153, 153, 153));
                g.fillRect(844,572,45,487);

                //二维码
                g.setColor(new Color(102, 46, 145));
                g.fillRect(92,1908,160,160);*/
                break;
            //6
            case 4:
                //logo

//                g.setColor(new Color(251, 176, 58));
//                g.fillRect(548,63,145,55);

                poster.setLogoX(555);
                poster.setLogoY(46);
                poster.setLogoWidth(130);
                poster.setLogoHeight(52);

                //主素材
                /*
                g.setColor(new Color(254, 0, 0));
                g.fillRect(-49,765,1579,1369);(183,518,686,1099)*/
                curPrimaryWidth = 686.0;
                curPrimaryHeight = 1099.0;
                poster.setPrimaryX(183);
                poster.setPrimaryY(518);

                //辅助素材
                /*g.setColor(new Color(0, 0, 254));
                g.fillRect(219,558,784,987);*/
                poster.setSecondaryX(219);
                poster.setSecondaryY(558);
                poster.setSecondaryWidth(784);
                poster.setSecondaryHeight(987);

                //详情文字

                /*
                g.setColor(new Color(0, 255, 1));
                g.fillRect(312,844,619,178);

                g.setColor(new Color(0, 255, 1));
                g.fillRect(540,2120,160,21);(332,1657,557,123)
                */
                poster.setDetailX(253);
                poster.setDetailY(1657);
                poster.setDetailWidth(735);
                poster.setDetailHeight(130);


                //主标题
                /*
                g.setColor(new Color(51, 51, 51));
                g.fillRect(288,329,666,216)(229,218,785,149);
                */
                poster.setMainX(100);
                poster.setMainY(150);
                poster.setMainWidth(1100);
                poster.setMainHeight(300);

                //副标题
                /*
                g.setColor(new Color(153, 153, 153));
                g.fillRect(244,624,755,70);(370,408,502,39)
                */
                poster.setSubX(370);
                poster.setSubY(408);
                poster.setSubWidth(502);
                poster.setSubHeight(100);


                //二维码
                /*g.setColor(new Color(102, 46, 145));
                g.fillRect(539,1916,160,160);*/
                poster.setBarcodeX(539);
                poster.setBarcodeY(1916);
                poster.setBarcodeWidth(160);
                poster.setBarcodeHeight(160);
                /*
                //logo
                g.setColor(new Color(251, 176, 58));
                g.fillRect(555,46,130,52);

                //辅助素材
                g.setColor(new Color(0, 0, 254));
                g.fillRect(219,558,784,987);

                //主素材
                g.setColor(new Color(254, 0, 0));
                g.fillRect(183,518,686,1099);

                //详情文字
                g.setColor(new Color(0, 255, 1));
                g.fillRect(332,1657,557,123);

                g.setColor(new Color(0, 255, 1));
                g.fillRect(539,2096,160,21);

                //主标题
                g.setColor(new Color(51, 51, 51));
                g.fillRect(229,218,785,149);

                //副标题
                g.setColor(new Color(153, 153, 153));
                g.fillRect(370,408,502,39);

                //二维码
                g.setColor(new Color(102, 46, 145));
                g.fillRect(539,1916,160,160);*/
                break;
            //10
            case 5:
                //logo

//                g.setColor(new Color(251, 176, 58));
//                g.fillRect(548,63,145,55);

                poster.setLogoX(996);
                poster.setLogoY(68);
                poster.setLogoWidth(134);
                poster.setLogoHeight(52);

                //主素材
                /*
                g.setColor(new Color(254, 0, 0));
                g.fillRect(-49,765,1579,1369);(170,278,905,1146)*/
                curPrimaryWidth = 905.0;
                curPrimaryHeight = 1146.0;
                poster.setPrimaryX(170);
                poster.setPrimaryY(278);
                //辅助素材
                /*g.setColor(new Color(0, 0, 254));
                g.fillRect(70,183,1089,1536);*/
                poster.setSecondaryX(70);
                poster.setSecondaryY(180);
                poster.setSecondaryWidth(1089);
                poster.setSecondaryHeight(1536);

                //详情文字

                /*
                g.setColor(new Color(0, 255, 1));
                g.fillRect(312,844,619,178);

                g.setColor(new Color(0, 255, 1));
                g.fillRect(540,2120,160,21);(158,1866,640,109)
                */
                poster.setDetailX(158);
                poster.setDetailY(2022);
                poster.setDetailWidth(640);
                poster.setDetailHeight(170);

                //主标题
                /*
                g.setColor(new Color(51, 51, 51));
                g.fillRect(288,329,666,216);(158,1695,800,110)
                */
                poster.setMainX(158);
                poster.setMainY(1695);
                poster.setMainWidth(1040);
                poster.setMainHeight(300);

                //副标题
                /*
                g.setColor(new Color(153, 153, 153));
                g.fillRect(244,624,755,70);(159,1599,514,67)
                */
                poster.setSubX(159);
                poster.setSubY(1520);
                poster.setSubWidth(514);
                poster.setSubHeight(100);

                /*//装饰素材2
                *//*
                g.setColor(new Color(255, 123, 172));
                g.fillRect(476,1282,606,561);

                g.fillRect(73,66,529,399);

                g.setColor(new Color(255, 123, 172));
                g.fillRect(850,1271,322,378);
                *//*

                poster.setFirstDecorate2X(73);
                poster.setFirstDecorate2Y(150);
                poster.setFirstDecorate2Width(150);
                poster.setFirstDecorate2Height(150);

                poster.setSecondDecorate2X(950);
                poster.setSecondDecorate2Y(1340);
                poster.setSecondDecorate2Width(150);
                poster.setSecondDecorate2Height(150);*/

                //二维码
                /*g.setColor(new Color(102, 46, 145));
                g.fillRect(995,1866,160,160);*/
                poster.setBarcodeX(995);
                poster.setBarcodeY(1980);
                poster.setBarcodeWidth(160);
                poster.setBarcodeHeight(160);
                /*
                //logo
                g.setColor(new Color(251, 176, 58));
                g.fillRect(996,68,134,52);

                //辅助素材
                g.setColor(new Color(0, 0, 254));
                g.fillRect(70,183,1089,1536);

                //主素材
                g.setColor(new Color(254, 0, 0));
                g.fillRect(170,278,905,1146);

                //详情文字
                g.setColor(new Color(0, 255, 1));
                g.fillRect(700,157,424,28);

                g.setColor(new Color(0, 255, 1));
                g.fillRect(158,2022,692,44);

                g.setColor(new Color(0, 255, 1));
                g.fillRect(158,1866,640,109);

                g.setColor(new Color(0, 255, 1));
                g.fillRect(995,2044,160,26);

                //主标题
                g.setColor(new Color(51, 51, 51));
                g.fillRect(158,1695,800,110);

                //副标题
                g.setColor(new Color(153, 153, 153));
                g.fillRect(159,1599,514,67);

                //装饰素材2
                g.setColor(new Color(255, 123, 172));
                g.fillRect(73,66,529,399);

                g.setColor(new Color(255, 123, 172));
                g.fillRect(850,1271,322,378);

                //二维码
                g.setColor(new Color(102, 46, 145));
                g.fillRect(995,1866,160,160);*/
                break;
            //7
            case 6:
                //logo
                /*
                g.setColor(new Color(251, 176, 58));
                g.fillRect(548,63,145,55);(553,60,134,52)*/

                poster.setLogoX(553);
                poster.setLogoY(60);
                poster.setLogoWidth(134);
                poster.setLogoHeight(52);

                //主素材
                /*
                g.setColor(new Color(254, 0, 0));
                g.fillRect(-49,765,1579,1369);(-36,359,990,1524)*/
                curPrimaryWidth = 990.0;
                curPrimaryHeight = 1524.0;
                poster.setPrimaryX(0);
                poster.setPrimaryY(359);


                //详情文字

                /*
                g.setColor(new Color(0, 255, 1));
                g.fillRect(312,844,619,178);

                g.setColor(new Color(0, 255, 1));
                g.fillRect(540,2120,160,21);(958,2090,160,26)
                */
                poster.setDetailX(100);
                poster.setDetailY(1900);
                poster.setDetailWidth(500);
                poster.setDetailHeight(170);

                //主标题
                /*
                g.setColor(new Color(51, 51, 51));
                g.fillRect(288,329,666,216);(903,310,205,444)
                */
                poster.setMainX(1000);
                poster.setMainY(310);
                poster.setMainWidth(205);
                poster.setMainHeight(1550);

                //副标题
                /*
                g.setColor(new Color(153, 153, 153));
                g.fillRect(244,624,755,70);(842,561,29,181)
                */
                poster.setSubX(900);
                poster.setSubY(561);
                poster.setSubWidth(29);
                poster.setSubHeight(800);
                //二维码
                /*g.setColor(new Color(102, 46, 145));
                g.fillRect(958,1912,160,160);*/
                poster.setBarcodeX(958);
                poster.setBarcodeY(1912);
                poster.setBarcodeWidth(160);
                poster.setBarcodeHeight(160);
                /*
                //logo
                g.setColor(new Color(251, 176, 58));
                g.fillRect(553,60,134,52);

                //主素材
                g.setColor(new Color(254, 0, 0));
                g.fillRect(-36,359,990,1524);

                //详情文字
                g.setColor(new Color(0, 255, 1));
                g.fillRect(921,918,100,478);

                g.setColor(new Color(0, 255, 1));
                g.fillRect(136,1883,495,33);

                g.setColor(new Color(0, 255, 1));
                g.fillRect(958,2090,160,26);

                //主标题
                g.setColor(new Color(51, 51, 51));
                g.fillRect(903,310,205,444);

                //装饰素材2
                g.setColor(new Color(255, 123, 172));
                g.fillRect(836,550,42,203);

                //副标题
                g.setColor(new Color(153, 153, 153));
                g.fillRect(842,561,29,181);

                //二维码
                g.setColor(new Color(102, 46, 145));
                g.fillRect(958,1912,160,160);*/
                break;
            //11
            case 7:
                flag = true;
                //logo
                /*
                g.setColor(new Color(251, 176, 58));
                g.fillRect(548,63,145,55);
                (73,76,137,52)
                */

                poster.setLogoX(73);
                poster.setLogoY(76);
                poster.setLogoWidth(137);
                poster.setLogoHeight(52);
                //主素材
                /*
                g.setColor(new Color(254, 0, 0));
                g.fillRect(-49,765,1579,1369);(170,278,905,1146)*/
                curPrimaryWidth = 1242.0;
                curPrimaryHeight = 2208.0;
                poster.setPrimaryX(0);
                poster.setPrimaryY(0);


                //辅助素材
                /*
                g.setColor(new Color(0, 0, 254));
                g.fillRect(0,1309,320,815);(411,621,775,307)
                */
                poster.setSecondaryX(411);
                poster.setSecondaryY(621);
                poster.setSecondaryWidth(775);
                poster.setSecondaryHeight(307);


                //详情文字

                /*
                g.setColor(new Color(0, 255, 1));
                g.fillRect(312,844,619,178);

                g.setColor(new Color(0, 255, 1));
                g.fillRect(540,2120,160,21);

                (541,689,516,139)
                */
                poster.setDetailX(541);
                poster.setDetailY(689);
                poster.setDetailWidth(516);
                poster.setDetailHeight(139);

                //主标题
                /*
                g.setColor(new Color(51, 51, 51));
                g.fillRect(288,329,666,216);(69,416,1089,144)
                */
                poster.setMainX(69);
                poster.setMainY(300);
                poster.setMainWidth(1089);
                poster.setMainHeight(200);


                //副标题
                /*
                g.setColor(new Color(153, 153, 153));
                g.fillRect(244,624,755,70);(73,269,406,92);
                */
                poster.setSubX(73);
                poster.setSubY(150);
                poster.setSubWidth(406);
                poster.setSubHeight(200);


                //装饰素材2
                /*
                g.setColor(new Color(255, 123, 172));
                g.fillRect(476,1282,606,561);

                (73,656,264,213);
                */
                poster.setFirstDecorate2X(73);
                poster.setFirstDecorate2Y(656);
                poster.setFirstDecorate2Width(264);
                poster.setFirstDecorate2Height(213);

                //二维码
                /*g.setColor(new Color(102, 46, 145));
                g.fillRect(540,1940,160,160);(73,1960,160,160)*/
                poster.setBarcodeX(73);
                poster.setBarcodeY(1960);
                poster.setBarcodeWidth(160);
                poster.setBarcodeHeight(160);
                //字体颜色


                mainColor = ctm.test(IMG_ROUTE + "src\\main\\resources\\draw\\PrimaryElement\\p1.png");
                red = colorReverse(Integer.parseInt(mainColor[0]));
                green = colorReverse(Integer.parseInt(mainColor[1]));
                blue = colorReverse(Integer.parseInt(mainColor[2]));
                //主标题
                poster.setMainFont(mainFontStyle);//字体
                poster.setMainColor(new Color(red,green,blue));//颜色
                //poster.setMainColor(new Color(red,255,255));
                //副标题
                poster.setSubFont(subFontStyle);
                poster.setSubColor(new Color(red,green,blue));
                //poster.setSubColor(new Color(255,255,255));
                //详细文字
                poster.setDetailFont(detailFontStyle);
                poster.setDetailColor(new Color(red,green,blue));
                //poster.setDetailColor(new Color(255,255,255));
                /*
                //主素材
                g.setColor(new Color(254, 0, 0));
                g.fillRect(0,0,1242,2208);

                //辅助素材
                g.setColor(new Color(0, 0, 254));
                g.fillRect(411,621,775,307);

                //logo
                g.setColor(new Color(251, 176, 58));
                g.fillRect(73,76,137,52);

                //详情文字
                g.setColor(new Color(0, 255, 1));
                g.fillRect(1030,88,165,102);

                g.setColor(new Color(0, 255, 1));
                g.fillRect(541,689,516,139);

                g.setColor(new Color(0, 255, 1));
                g.fillRect(297,2048,426,68);

                //主标题
                g.setColor(new Color(51, 51, 51));
                g.fillRect(69,416,1089,144);

                //副标题
                g.setColor(new Color(153, 153, 153));
                g.fillRect(73,269,406,92);

                //装饰素材2
                g.setColor(new Color(255, 123, 172));
                g.fillRect(73,656,264,213);

                //二维码
                g.setColor(new Color(102, 46, 145));
                g.fillRect(73,1960,160,160);*/
                break;
            //12
            case 8:
                //logo
                /*
                g.setColor(new Color(251, 176, 58));
                g.fillRect(548,63,145,55);(996,68,134,52)*/

                poster.setLogoX(996);
                poster.setLogoY(68);
                poster.setLogoWidth(134);
                poster.setLogoHeight(52);

                //主素材
                /*
                g.setColor(new Color(254, 0, 0));
                g.fillRect(-49,765,1579,1369);(196,749,968,1219)*/
                curPrimaryWidth = 968.0;
                curPrimaryHeight = 1219.0;
                poster.setPrimaryX(196);
                poster.setPrimaryY(749);


                //详情文字

                /*
                g.setColor(new Color(0, 255, 1));
                g.fillRect(312,844,619,178);

                g.setColor(new Color(0, 255, 1));
                g.fillRect(540,2120,160,21);(682,439,480,99)
                */
                poster.setDetailX(682);
                poster.setDetailY(439);
                poster.setDetailWidth(480);
                poster.setDetailHeight(170);

                //主标题
                /*
                g.setColor(new Color(51, 51, 51));
                g.fillRect(288,329,666,216);(51,80,350,630)
                */
                poster.setMainX(51);
                poster.setMainY(80);
                poster.setMainWidth(350);
                poster.setMainHeight(630);

                //副标题
                /*
                g.setColor(new Color(153, 153, 153));
                g.fillRect(244,624,755,70);(443,119,41,590)
                */
                poster.setSubX(443);
                poster.setSubY(119);
                poster.setSubWidth(41);
                poster.setSubHeight(590);

                //二维码
                /*g.setColor(new Color(102, 46, 145));
                g.fillRect(990,1931,160,160);*/
                poster.setBarcodeX(100);
                poster.setBarcodeY(2000);
                poster.setBarcodeWidth(160);
                poster.setBarcodeHeight(160);

                /*
                //主素材
                g.setColor(new Color(254, 0, 0));
                g.fillRect(196,749,968,1219);

                //详情文字
                g.setColor(new Color(0, 255, 1));
                g.fillRect(682,439,480,99);

                g.setColor(new Color(0, 255, 1));
                g.fillRect(686,223,484,93);

                g.setColor(new Color(0, 255, 1));
                g.fillRect(838,2060,328,66);

                //主标题
                g.setColor(new Color(51, 51, 51));
                g.fillRect(51,80,350,630);

                //装饰素材2
                g.setColor(new Color(255, 123, 172));
                g.fillRect(434,80,61,630);

                g.setColor(new Color(255, 123, 172));
                g.fillRect(530,80,61,518);

                //副标题
                g.setColor(new Color(153, 153, 153));
                g.fillRect(538,121,42,435);

                g.setColor(new Color(153, 153, 153));
                g.fillRect(443,119,41,590);

                //装饰素材1
                g.setColor(new Color(205, 125, 255));
                g.fillRect(627,80,540,37);

                g.setColor(new Color(205, 125, 255));
                g.fillRect(688,659,42,42);

                g.setColor(new Color(205, 125, 255));
                g.fillRect(907,659,42,42);

                g.setColor(new Color(205, 125, 255));
                g.fillRect(1125,659,42,42);

                g.setColor(new Color(205, 125, 255));
                g.fillRect(163,2105,170,27);
*/
                break;
            //13
            case 9:
                //logo
                /*
                g.setColor(new Color(251, 176, 58));
                g.fillRect(548,63,145,55);(1013,67,134,53)*/

                poster.setLogoX(1013);
                poster.setLogoY(67);
                poster.setLogoWidth(134);
                poster.setLogoHeight(53);

                //主素材
                /*
                g.setColor(new Color(254, 0, 0));
                g.fillRect(-49,765,1579,1369);(103,635,948,939)*/
                curPrimaryWidth = 948.0;
                curPrimaryHeight = 939.0;
                poster.setPrimaryX(103);
                poster.setPrimaryY(635);
                /*
                //辅助素材
                *//*g.setColor(new Color(0, 0, 254));
                g.fillRect(80,937,1162,1271);*//*
                poster.setSecondaryX(80);
                poster.setSecondaryY(937);
                poster.setSecondaryWidth(1162);
                poster.setSecondaryHeight(1271);
*/

                //详情文字

                /*
                g.setColor(new Color(0, 255, 1));
                g.fillRect(312,844,619,178);

                g.setColor(new Color(0, 255, 1));
                g.fillRect(540,2120,160,21);(227,1515,827,414)
                */
                poster.setDetailX(227);
                poster.setDetailY(1700);
                poster.setDetailWidth(827);
                poster.setDetailHeight(414);

                //主标题
                /*
                g.setColor(new Color(51, 51, 51));
                g.fillRect(288,329,666,216);(102,229,792,303)
                */
                poster.setMainX(102);
                poster.setMainY(229);
                poster.setMainWidth(1100);
                poster.setMainHeight(303);

                //副标题
                /*
                g.setColor(new Color(153, 153, 153));
                g.fillRect(244,624,755,70);(102,583,482,79)
                */
                poster.setSubX(102);
                poster.setSubY(500);
                poster.setSubWidth(482);
                poster.setSubHeight(100);

                //二维码
                /*g.setColor(new Color(102, 46, 145));
                g.fillRect(990,1931,160,160);*/
                poster.setBarcodeX(990);
                poster.setBarcodeY(1931);
                poster.setBarcodeWidth(160);
                poster.setBarcodeHeight(160);

                /*
                //logo
                g.setColor(new Color(251, 176, 58));
                g.fillRect(1013,67,134,53);

                //辅助素材
                g.setColor(new Color(0, 0, 254));
                g.fillRect(80,937,1162,1271);

                //主素材
                g.setColor(new Color(254, 0, 0));
                g.fillRect(103,635,948,939);

                //详情文字
                g.setColor(new Color(0, 255, 1));
                g.fillRect(227,1515,827,414);

                g.setColor(new Color(0, 255, 1));
                g.fillRect(990,2109,160,26);

                //主标题
                g.setColor(new Color(51, 51, 51));
                g.fillRect(102,229,792,303);

                //副标题
                g.setColor(new Color(153, 153, 153));
                g.fillRect(102,583,482,79);

                //二维码
                g.setColor(new Color(102, 46, 145));
                g.fillRect(990,1931,160,160);*/
                break;
            //1
            case 10:

                //logo
                /*
                g.setColor(new Color(251, 176, 58));
                g.fillRect(548,63,145,55);
                (1027,77,134,52);
                */

                poster.setLogoX(1027);
                poster.setLogoY(77);
                poster.setLogoWidth(134);
                poster.setLogoHeight(52);

                //主素材
                /*
                g.setColor(new Color(254, 0, 0));
                g.fillRect(-49,765,1579,1369);(328,638,916,1570);*/
                curPrimaryWidth = 916.0;
                curPrimaryHeight = 1570.0;
                poster.setPrimaryX(328);
                poster.setPrimaryY(638);


                //辅助素材
                /*
                g.setColor(new Color(0, 0, 254));
                g.fillRect(0,1309,320,815);
                */
                poster.setSecondaryX(0);
                poster.setSecondaryY(1309);
                poster.setSecondaryWidth(320);
                poster.setSecondaryHeight(815);


                //详情文字

                /*
                g.setColor(new Color(0, 255, 1));
                g.fillRect(312,844,619,178);

                g.setColor(new Color(0, 255, 1));
                g.fillRect(540,2120,160,21);

                (100,952,360,166);
                */
                poster.setDetailX(100);
                poster.setDetailY(952);
                poster.setDetailWidth(360);
                poster.setDetailHeight(166);

                //主标题
                /*
                g.setColor(new Color(51, 51, 51));
                g.fillRect(288,329,666,216);(104,323,766,430)
                */
                poster.setMainX(104);
                poster.setMainY(323);
                poster.setMainWidth(766);
                poster.setMainHeight(430);


                //副标题
                /*
                g.setColor(new Color(153, 153, 153));
                g.fillRect(244,624,755,70);(100,154,545,126);
                */
                poster.setSubX(100);
                poster.setSubY(154);
                poster.setSubWidth(545);
                poster.setSubHeight(126);

                //装饰素材1
                /*g.setColor(new Color(205, 125, 255));
                g.fillRect(98,1900,207,79);*/
                poster.setFirstDecorate1X(98);
                poster.setFirstDecorate1Y(1900);
                poster.setFirstDecorate1Width(207);
                poster.setFirstDecorate1Height(79);


                //装饰素材2
                /*
                g.setColor(new Color(255, 123, 172));
                g.fillRect(476,1282,606,561);

                g.fillRect(270,1429,362,352);
                g.fillRect(850,1880,210,229);
                */
                poster.setFirstDecorate2X(270);
                poster.setFirstDecorate2Y(1429);
                poster.setFirstDecorate2Width(362);
                poster.setFirstDecorate2Height(352);

                poster.setSecondDecorate2X(850);
                poster.setSecondDecorate2Y(1880);
                poster.setSecondDecorate2Width(210);
                poster.setSecondDecorate2Height(229);

                //二维码
                /*g.setColor(new Color(102, 46, 145));
                g.fillRect(540,1940,160,160);*/
                poster.setBarcodeX(540);
                poster.setBarcodeY(1940);
                poster.setBarcodeWidth(160);
                poster.setBarcodeHeight(160);

                /*//logo
                 *//*
                g.setColor(new Color(251, 176, 58));
                g.fillRect(1027,77,134,52);

                //主素材
                *//*
                g.setColor(new Color(254, 0, 0));
                g.fillRect(328,638,916,1570);

                //辅助素材
                *//*
                g.setColor(new Color(0, 0, 254));
                g.fillRect(0,1309,320,815);

                //详情文字
                *//*
                g.setColor(new Color(153, 153, 153));
                g.fillRect(100,952,360,166);


                g.setColor(new Color(0, 255, 1));
                g.fillRect(95,1717,215,144);

                g.setColor(new Color(0, 255, 1));
                g.fillRect(540,2120,160,21);

                //主标题
                *//*
                g.setColor(new Color(51, 51, 51));
                g.fillRect(104,323,766,430);*//*
                g.setColor(poster.getMainColor());
                g.setFont(poster.getMainFont());

                //副标题

                *//*g.setColor(new Color(0, 255, 1));
                g.fillRect(100,154,545,126);*//*
                g.setColor(poster.getSubColor());
                g.setFont(poster.getSubFont());

                //装饰素材1
                g.setColor(new Color(205, 125, 255));
                g.fillRect(98,1900,207,79);

                g.setColor(new Color(205, 125, 255));
                g.fillRect(100,910,130,3);

                //装饰素材2
                *//*
                g.setColor(new Color(255, 123, 172));
                g.fillRect(270,1429,362,352);

                g.setColor(new Color(255, 123, 172));
                g.fillRect(850,1880,210,229);

                //二维码
                g.setColor(new Color(102, 46, 145));
                g.fillRect(540,1940,160,160);
                */
                break;
            //16
            case 11:
                flag = true;
                //logo
                /*
                g.setColor(new Color(251, 176, 58));
                g.fillRect(548,63,145,55);
                (553,82,134,52)
                */

                poster.setLogoX(553);
                poster.setLogoY(82);
                poster.setLogoWidth(134);
                poster.setLogoHeight(52);
                //主素材
                /*
                g.setColor(new Color(254, 0, 0));
                g.fillRect(-49,765,1579,1369);(170,278,905,1146)*/
                curPrimaryWidth = 1242.0;
                curPrimaryHeight = 2208.0;
                poster.setPrimaryX(0);
                poster.setPrimaryY(0);

                //详情文字

                /*
                g.setColor(new Color(0, 255, 1));
                g.fillRect(312,844,619,178);

                g.setColor(new Color(0, 255, 1));
                g.fillRect(540,2120,160,21);

                (314,1451,613,250);
                */
                poster.setDetailX(314);
                poster.setDetailY(1451);
                poster.setDetailWidth(613);
                poster.setDetailHeight(250);

                //主标题
                /*
                g.setColor(new Color(51, 51, 51));
                g.fillRect(288,329,666,216);(156,357,933,182);
                */
                poster.setMainX(100);
                poster.setMainY(220);
                poster.setMainWidth(1100);
                poster.setMainHeight(350);


                //副标题
                /*
                g.setColor(new Color(153, 153, 153));
                g.fillRect(244,624,755,70);(151,574,939,110)
                */
                poster.setSubX(151);
                poster.setSubY(500);
                poster.setSubWidth(939);
                poster.setSubHeight(200);

                //二维码
                /*g.setColor(new Color(102, 46, 145));
                g.fillRect(540,1940,160,160);(541,1869,160,160);*/
                poster.setBarcodeX(541);
                poster.setBarcodeY(1869);
                poster.setBarcodeWidth(160);
                poster.setBarcodeHeight(160);

                mainColor = ctm.test(IMG_ROUTE + "src\\main\\resources\\draw\\PrimaryElement\\p1.png");
                red = colorReverse(Integer.parseInt(mainColor[0]));
                green = colorReverse(Integer.parseInt(mainColor[1]));
                blue = colorReverse(Integer.parseInt(mainColor[2]));
                //主标题
                poster.setMainFont(mainFontStyle);//字体
                poster.setMainColor(new Color(red,green,blue));//颜色
                //poster.setMainColor(new Color(red,255,255));
                //副标题
                poster.setSubFont(subFontStyle);
                poster.setSubColor(new Color(red,green,blue));
                //poster.setSubColor(new Color(255,255,255));
                //详细文字
                poster.setDetailFont(detailFontStyle);
                poster.setDetailColor(new Color(red,green,blue));
                //poster.setDetailColor(new Color(255,255,255));

                /*
                //主素材
                g.setColor(new Color(254, 0, 0));
                g.fillRect(0,0,1242,2208);

                //logo
                g.setColor(new Color(251, 176, 58));
                g.fillRect(553,82,134,52);

                //装饰素材2
                g.setColor(new Color(255, 123, 172));
                g.fillRect(271,759,700,96);

                //详情文字
                g.setColor(new Color(0, 255, 1));
                g.fillRect(323,779,593,58);

                g.setColor(new Color(0, 255, 1));
                g.fillRect(314,1451,613,250);

                g.setColor(new Color(0, 255, 1));
                g.fillRect(541,2047,160,27);

                //主标题
                g.setColor(new Color(51, 51, 51));
                g.fillRect(156,357,933,182);

                //副标题
                g.setColor(new Color(153, 153, 153));
                g.fillRect(151,574,939,110);

                //二维码
                g.setColor(new Color(102, 46, 145));
                g.fillRect(541,1869,160,160);
*/
                break;
            //17
            case 12:
                flag = true;
                //logo
                /*
                g.setColor(new Color(251, 176, 58));
                g.fillRect(548,63,145,55);
                (999,83,134,52)
                */

                poster.setLogoX(999);
                poster.setLogoY(83);
                poster.setLogoWidth(134);
                poster.setLogoHeight(52);
                //主素材
                /*
                g.setColor(new Color(254, 0, 0));
                g.fillRect(-49,765,1579,1369);(170,278,905,1146)*/
                curPrimaryWidth = 1242.0;
                curPrimaryHeight = 1565.0;
                poster.setPrimaryX(0);
                poster.setPrimaryY(0);

                //详情文字

                /*
                g.setColor(new Color(0, 255, 1));
                g.fillRect(312,844,619,178);

                g.setColor(new Color(0, 255, 1));
                g.fillRect(540,2120,160,21);

                g.fillRect(330,1735,602,159);
                */
                poster.setDetailX(330);
                poster.setDetailY(1735);
                poster.setDetailWidth(602);
                poster.setDetailHeight(250);

                //主标题
                /*
                g.setColor(new Color(51, 51, 51));
                g.fillRect(288,329,666,216);(126,334,1001,180);
                */
                poster.setMainX(126);
                poster.setMainY(180);
                poster.setMainWidth(1001);
                poster.setMainHeight(300);


                //副标题
                /*
                g.setColor(new Color(153, 153, 153));
                g.fillRect(244,624,755,70);(588,543,532,136);
                */
                poster.setSubX(588);
                poster.setSubY(543);
                poster.setSubWidth(532);
                poster.setSubHeight(400);

                //二维码
                /*g.setColor(new Color(102, 46, 145));
                g.fillRect(540,1940,160,160);(541,1957,160,160);*/
                poster.setBarcodeX(541);
                poster.setBarcodeY(1957);
                poster.setBarcodeWidth(160);
                poster.setBarcodeHeight(160);

                mainColor = ctm.test(IMG_ROUTE + "src\\main\\resources\\draw\\PrimaryElement\\p1.png");
                red = colorReverse(Integer.parseInt(mainColor[0]));
                green = colorReverse(Integer.parseInt(mainColor[1]));
                blue = colorReverse(Integer.parseInt(mainColor[2]));
                //主标题
                poster.setMainFont(mainFontStyle);//字体
                poster.setMainColor(new Color(red,green,blue));//颜色
                //poster.setMainColor(new Color(red,255,255));
                //副标题
                poster.setSubFont(subFontStyle);
                poster.setSubColor(new Color(red,green,blue));
                //poster.setSubColor(new Color(255,255,255));
                //详细文字
                poster.setDetailFont(detailFontStyle);
                poster.setDetailColor(new Color(red,green,blue));
                //poster.setDetailColor(new Color(255,255,255));

                /*
                //主素材
                g.setColor(new Color(254, 0, 0));
                g.fillRect(0,0,1242,1565);

                //logo
                g.setColor(new Color(251, 176, 58));
                g.fillRect(999,83,134,52);

                //装饰素材2
                g.setColor(new Color(255, 123, 172));
                g.fillRect(131,476,997,55);

                g.setColor(new Color(255, 123, 172));
                g.fillRect(578,639,549,55);

                //详情文字
                g.setColor(new Color(0, 255, 1));
                g.fillRect(329,248,806,46);

                g.setColor(new Color(0, 255, 1));
                g.fillRect(277,1625,693,62);

                g.setColor(new Color(0, 255, 1));
                g.fillRect(330,1735,602,159);

                g.setColor(new Color(0, 255, 1));
                g.fillRect(541,2135,160,26);

                //主标题
                g.setColor(new Color(51, 51, 51));
                g.fillRect(126,334,1001,180);

                //副标题
                g.setColor(new Color(153, 153, 153));
                g.fillRect(588,543,532,136);

                //装饰素材1
                g.setColor(new Color(205, 125, 255));
                g.fillRect(1088,740,19,171);

                g.setColor(new Color(205, 125, 255));
                g.fillRect(519,1568,205,25);

                //二维码
                g.setColor(new Color(102, 46, 145));
                g.fillRect(541,1957,160,160);*/
                break;
            //18
            case 13:
                //logo
                /*
                g.setColor(new Color(251, 176, 58));
                g.fillRect(548,63,145,55);(144,69,134,52)*/

                poster.setLogoX(144);
                poster.setLogoY(69);
                poster.setLogoWidth(134);
                poster.setLogoHeight(52);

                //主素材
                /*
                g.setColor(new Color(254, 0, 0));
                g.fillRect(-49,765,1579,1369);(528,987,745,746)*/
                curPrimaryWidth = 820.0;
                curPrimaryHeight = 1200.0;
                poster.setPrimaryX(320);
                poster.setPrimaryY(687);
                //辅助素材
                /*g.setColor(new Color(0, 0, 254));
                g.fillRect(0,625,1242,1583);*/
                poster.setSecondaryX(0);
                poster.setSecondaryY(625);
                poster.setSecondaryWidth(1242);
                poster.setSecondaryHeight(1583);


                //详情文字

                /*
                g.setColor(new Color(0, 255, 1));
                g.fillRect(312,844,619,178);

                g.setColor(new Color(0, 255, 1));
                g.fillRect(540,2120,160,21);(243,1923,342,115)
                */
                poster.setDetailX(243);
                poster.setDetailY(1923);
                poster.setDetailWidth(500);
                poster.setDetailHeight(170);

                //主标题
                /*
                g.setColor(new Color(51, 51, 51));
                g.fillRect(288,329,666,216);(140,262,785,147)
                */
                poster.setMainX(100);
                poster.setMainY(200);
                poster.setMainWidth(1100);
                poster.setMainHeight(300);

                //副标题
                /*
                g.setColor(new Color(153, 153, 153));
                g.fillRect(244,624,755,70);(142,450,787,55)
                */
                poster.setSubX(142);
                poster.setSubY(450);
                poster.setSubWidth(787);
                poster.setSubHeight(100);

                //装饰素材2
                /*
                g.setColor(new Color(255, 123, 172));
                g.fillRect(476,1282,606,561);
                g.fillRect(64,1022,275,275);

                g.setColor(new Color(255, 123, 172));
                g.fillRect(973,344,220,120);
                */

                poster.setFirstDecorate2X(64);
                poster.setFirstDecorate2Y(1022);
                poster.setFirstDecorate2Width(275);
                poster.setFirstDecorate2Height(275);

                poster.setSecondDecorate2X(973);
                poster.setSecondDecorate2Y(344);
                poster.setSecondDecorate2Width(220);
                poster.setSecondDecorate2Height(120);

                //二维码
                /*g.setColor(new Color(102, 46, 145));
                g.fillRect(999,1922,160,160);*/
                poster.setBarcodeX(999);
                poster.setBarcodeY(1922);
                poster.setBarcodeWidth(160);
                poster.setBarcodeHeight(160);
                /*
                //logo
                g.setColor(new Color(251, 176, 58));
                g.fillRect(144,69,134,52);

                //辅助素材
                g.setColor(new Color(0, 0, 254));
                g.fillRect(0,625,1242,1583);

                //主素材
                g.setColor(new Color(254, 0, 0));
                g.fillRect(76,1340,784,783);

                g.setColor(new Color(254, 0, 0));
                g.fillRect(528,987,745,746);

                g.setColor(new Color(254, 0, 0));
                g.fillRect(144,505,865,865);


                //详情文字
                g.setColor(new Color(0, 255, 1));
                g.fillRect(409,1103,387,164);

                g.setColor(new Color(0, 255, 1));
                g.fillRect(611,1449,427,179);

                g.setColor(new Color(0, 255, 1));
                g.fillRect(243,1923,342,115);

                g.setColor(new Color(0, 255, 1));
                g.fillRect(999,2100,160,26);

                //主标题
                g.setColor(new Color(51, 51, 51));
                g.fillRect(140,262,785,147);

                //副标题
                g.setColor(new Color(153, 153, 153));
                g.fillRect(142,450,787,55);

                //装饰素材2
                g.setColor(new Color(255, 123, 172));
                g.fillRect(64,1022,275,275);

                g.setColor(new Color(255, 123, 172));
                g.fillRect(973,344,220,120);

                //二维码
                g.setColor(new Color(102, 46, 145));
                g.fillRect(999,1922,160,160);*/
                break;
            //96
            case 14:
                //logo
                /*
                g.setColor(new Color(251, 176, 58));
                g.fillRect(548,63,145,55);(83,69,130,38)*/

                poster.setLogoX(83);
                poster.setLogoY(69);
                poster.setLogoWidth(130);
                poster.setLogoHeight(38);

                //主素材
                /*
                g.setColor(new Color(254, 0, 0));
                g.fillRect(-49,765,1579,1369);(0,0,1242,991)*/
                curPrimaryWidth = 1242.0;
                curPrimaryHeight = 991.0;
                poster.setPrimaryX(0);
                poster.setPrimaryY(110);


                //详情文字

                /*
                g.setColor(new Color(0, 255, 1));
                g.fillRect(312,844,619,178);

                g.setColor(new Color(0, 255, 1));
                g.fillRect(540,2120,160,21);(305,2032,624,105)
                */
                poster.setDetailX(350);
                poster.setDetailY(2032);
                poster.setDetailWidth(400);
                poster.setDetailHeight(150);

                //主标题
                /*
                g.setColor(new Color(51, 51, 51));
                g.fillRect(288,329,666,216);(834, 1161,279,556)
                */
                poster.setMainX(834);
                poster.setMainY(1161);
                poster.setMainWidth(279);
                poster.setMainHeight(1047);

                //副标题
                /*
                g.setColor(new Color(153, 153, 153));
                g.fillRect(244,624,755,70);(428,1161,59,548)
                */
                poster.setSubX(600);
                poster.setSubY(1161);
                poster.setSubWidth(59);
                poster.setSubHeight(870);

                //装饰素材2
                /*
                g.setColor(new Color(255, 123, 172));
                g.fillRect(476,1282,606,561);
                */
                poster.setFirstDecorate2X(836);
                poster.setFirstDecorate2Y(1595);
                poster.setFirstDecorate2Width(125);
                poster.setFirstDecorate2Height(123);


                //二维码
                /*g.setColor(new Color(102, 46, 145));
                g.fillRect(83,1938,199,199);*/
                poster.setBarcodeX(83);
                poster.setBarcodeY(1938);
                poster.setBarcodeWidth(199);
                poster.setBarcodeHeight(199);
                /*
                //主素材
                g.setColor(new Color(254, 0, 0));
                g.fillRect(0,0,1242,991);

                //logo
                g.setColor(new Color(251, 176, 58));
                g.fillRect(83,69,130,38);

                //主标题
                g.setColor(new Color(51, 51, 51));
                g.fillRect(834, 1161,279,556);

                //副标题
                g.setColor(new Color(153, 153, 153));
                g.fillRect(428,1161,59,548);

                //详情文字
                g.setColor(new Color(0, 255, 1));
                g.fillRect(126,769,544,152);
                g.fillRect(150,1162,160,552);
                g.fillRect(305,2032,624,105);


                //装饰素材2
                g.setColor(new Color(255, 123, 172));
                g.fillRect(836,1595,125,123);

                //二维码
                g.setColor(new Color(102, 46, 145));
                g.fillRect(83,1938,199,199);*/
                break;
            //21
            case 15:
                flag = true;
                //logo
                /*
                g.setColor(new Color(251, 176, 58));
                g.fillRect(548,63,145,55);
                (86,75,130,38)
                */

                poster.setLogoX(86);
                poster.setLogoY(76);
                poster.setLogoWidth(130);
                poster.setLogoHeight(38);
                //主素材
                /*
                g.setColor(new Color(254, 0, 0));
                g.fillRect(-49,765,1579,1369);(170,278,905,1146)*/
                curPrimaryWidth = 1242.0;
                curPrimaryHeight = 2208.0;
                poster.setPrimaryX(0);
                poster.setPrimaryY(0);


                //辅助素材
                /*
                g.setColor(new Color(0, 0, 254));
                g.fillRect(0,1309,320,815);(-103,160,1449,1450);
                */
                poster.setSecondaryX(0);
                poster.setSecondaryY(160);
                poster.setSecondaryWidth(1242);
                poster.setSecondaryHeight(1450);


                //详情文字

                /*
                g.setColor(new Color(0, 255, 1));
                g.fillRect(312,844,619,178);

                g.setColor(new Color(0, 255, 1));
                g.fillRect(540,2120,160,21);

                (432,665,380,55);
                */
                poster.setDetailX(432);
                poster.setDetailY(665);
                poster.setDetailWidth(380);
                poster.setDetailHeight(205);

                //主标题
                /*
                g.setColor(new Color(51, 51, 51));
                g.fillRect(288,329,666,216);(359,1029,524,79);
                */
                poster.setMainX(259);
                poster.setMainY(850);
                poster.setMainWidth(724);
                poster.setMainHeight(400);


                //副标题
                /*
                g.setColor(new Color(153, 153, 153));
                g.fillRect(244,624,755,70);(405,1180,433,42);
                */
                poster.setSubX(305);
                poster.setSubY(1180);
                poster.setSubWidth(600);
                poster.setSubHeight(500);

                //二维码
                /*g.setColor(new Color(102, 46, 145));
                g.fillRect(540,1940,160,160);(86,1944,160,160);*/
                poster.setBarcodeX(86);
                poster.setBarcodeY(1944);
                poster.setBarcodeWidth(160);
                poster.setBarcodeHeight(160);

                mainColor = ctm.test(IMG_ROUTE + "src\\main\\resources\\draw\\PrimaryElement\\p1.png");
                red = colorReverse(Integer.parseInt(mainColor[0]));
                green = colorReverse(Integer.parseInt(mainColor[1]));
                blue = colorReverse(Integer.parseInt(mainColor[2]));
                //主标题
                poster.setMainFont(mainFontStyle);//字体
                poster.setMainColor(new Color(red,green,blue));//颜色
                //poster.setMainColor(new Color(red,255,255));
                //副标题
                poster.setSubFont(subFontStyle);
                poster.setSubColor(new Color(red,green,blue));
                //poster.setSubColor(new Color(255,255,255));
                //详细文字
                poster.setDetailFont(detailFontStyle);
                poster.setDetailColor(new Color(red,green,blue));
                //poster.setDetailColor(new Color(255,255,255));

                /*
                //主素材
                g.setColor(new Color(254, 0, 0));
                g.fillRect(0,0,1242,2208);

                //logo
                g.setColor(new Color(251, 176, 58));
                g.fillRect(86,75,130,38);

                //辅助素材
                g.setColor(new Color(0, 0, 254));
                g.fillRect(-103,160,1449,1450);

                //装饰素材2
                g.setColor(new Color(255, 123, 172));
                g.fillRect(504,547,233,64);

                //详情文字
                g.setColor(new Color(0, 255, 1));
                g.fillRect(528,558,186,48);

                g.setColor(new Color(0, 255, 1));
                g.fillRect(432,665,380,55);

                g.setColor(new Color(0, 255, 1));
                g.fillRect(427,752,392,205);

                g.setColor(new Color(0, 255, 1));
                g.fillRect(86,2122,160,27);

                //主标题
                g.setColor(new Color(51, 51, 51));
                g.fillRect(359,1029,524,79);

                //副标题
                g.setColor(new Color(153, 153, 153));
                g.fillRect(405,1180,433,42);

                //二维码
                g.setColor(new Color(102, 46, 145));
                g.fillRect(86,1944,160,160);*/
                break;
            //4
            case 16:
                //logo
                /*
                g.setColor(new Color(251, 176, 58));
                g.fillRect(548,63,145,55);*/

                poster.setLogoX(548);
                poster.setLogoY(63);
                poster.setLogoWidth(145);
                poster.setLogoHeight(55);

                //主素材
                /*
                g.setColor(new Color(254, 0, 0));
                g.fillRect(-49,765,1579,1369);*/
                curPrimaryWidth = 1242.0;
                curPrimaryHeight = 1369.0;
                poster.setPrimaryX(0);
                poster.setPrimaryY(765);


                //详情文字

                /*
                g.setColor(new Color(0, 255, 1));
                g.fillRect(312,844,619,178);

                g.setColor(new Color(0, 255, 1));
                g.fillRect(540,2120,160,21);
                */
                poster.setDetailX(312);
                poster.setDetailY(750);
                poster.setDetailWidth(619);
                poster.setDetailHeight(178);

                //主标题
                /*
                g.setColor(new Color(51, 51, 51));
                g.fillRect(288,329,666,216);
                */
                poster.setMainX(288);
                poster.setMainY(260);
                poster.setMainWidth(666);
                poster.setMainHeight(350);

                //副标题
                /*
                g.setColor(new Color(153, 153, 153));
                g.fillRect(244,624,755,70);
                */
                poster.setSubX(244);
                poster.setSubY(500);
                poster.setSubWidth(755);
                poster.setSubHeight(100);

                //装饰素材2
                /*
                g.setColor(new Color(255, 123, 172));
                g.fillRect(476,1282,606,561);
                */
                poster.setFirstDecorate2X(476);
                poster.setFirstDecorate2Y(1282);
                poster.setFirstDecorate2Width(606);
                poster.setFirstDecorate2Height(561);


                //二维码
                /*
                g.setColor(new Color(102, 46, 145));
                g.fillRect(540,1940,160,160);
                */
                poster.setBarcodeX(540);
                poster.setBarcodeY(1940);
                poster.setBarcodeWidth(160);
                poster.setBarcodeHeight(160);

                break;
            //25
            case 17:
                flag = true;
                //logo
                /*
                g.setColor(new Color(251, 176, 58));
                g.fillRect(548,63,145,55);
                (101,65,129,38)
                */

                poster.setLogoX(101);
                poster.setLogoY(65);
                poster.setLogoWidth(137);
                poster.setLogoHeight(52);
                //主素材
                /*
                g.setColor(new Color(254, 0, 0));
                g.fillRect(-49,765,1579,1369);(170,278,905,1146)*/
                curPrimaryWidth = 1242.0;
                curPrimaryHeight = 2208.0;
                poster.setPrimaryX(0);
                poster.setPrimaryY(0);


                //辅助素材
                /*
                g.setColor(new Color(0, 0, 254));
                g.fillRect(0,1309,320,815);(0,199,1240,485);
                */
                poster.setSecondaryX(0);
                poster.setSecondaryY(199);
                poster.setSecondaryWidth(1242);
                poster.setSecondaryHeight(485);


                //详情文字

                /*
                g.setColor(new Color(0, 255, 1));
                g.fillRect(312,844,619,178);

                g.setColor(new Color(0, 255, 1));
                g.fillRect(540,2120,160,21);

                (95,808,156,313);
                */
                poster.setDetailX(95);
                poster.setDetailY(1000);
                poster.setDetailWidth(516);
                poster.setDetailHeight(313);

                //主标题
                /*
                g.setColor(new Color(51, 51, 51));
                g.fillRect(288,329,666,216);(687,810,458,149);
                */
                poster.setMainX(520);
                poster.setMainY(250);
                poster.setMainWidth(600);
                poster.setMainHeight(300);


                //副标题
                /*
                g.setColor(new Color(153, 153, 153));
                g.fillRect(244,624,755,70);(777,1218,369,104);
                */
                poster.setSubX(550);
                poster.setSubY(550);
                poster.setSubWidth(600);
                poster.setSubHeight(300);


                //装饰素材2
                /*
                g.setColor(new Color(255, 123, 172));
                g.fillRect(476,1282,606,561);

                (106,1946,130,96);(986,2111,160,27);
                */
                poster.setFirstDecorate2X(106);
                poster.setFirstDecorate2Y(1946);
                poster.setFirstDecorate2Width(130);
                poster.setFirstDecorate2Height(130);

                poster.setSecondDecorate2X(986);
                poster.setSecondDecorate2Y(1177);
                poster.setSecondDecorate2Width(130);
                poster.setSecondDecorate2Height(130);

                //二维码
                /*g.setColor(new Color(102, 46, 145));
                g.fillRect(540,1940,160,160);(986,1933,160,160);*/
                poster.setBarcodeX(986);
                poster.setBarcodeY(1933);
                poster.setBarcodeWidth(160);
                poster.setBarcodeHeight(160);

                mainColor = ctm.test(IMG_ROUTE + "src\\main\\resources\\draw\\PrimaryElement\\p1.png");
                red = colorReverse(Integer.parseInt(mainColor[0]));
                green = colorReverse(Integer.parseInt(mainColor[1]));
                blue = colorReverse(Integer.parseInt(mainColor[2]));
                //主标题
                poster.setMainFont(mainFontStyle);//字体
                poster.setMainColor(new Color(red,green,blue));//颜色
                //poster.setMainColor(new Color(red,255,255));
                //副标题
                poster.setSubFont(subFontStyle);
                poster.setSubColor(new Color(red,green,blue));
                //poster.setSubColor(new Color(255,255,255));
                //详细文字
                poster.setDetailFont(detailFontStyle);
                poster.setDetailColor(new Color(red,green,blue));
                //poster.setDetailColor(new Color(255,255,255));

                /*
                //主素材
                g.setColor(new Color(254, 0, 0));
                g.fillRect(0,0,1242,2208);

                //logo
                g.setColor(new Color(251, 176, 58));
                g.fillRect(101,65,129,38);

                //辅助素材
                g.setColor(new Color(0, 0, 254));
                g.fillRect(0,199,1240,485);

                //详情文字
                g.setColor(new Color(0, 255, 1));
                g.fillRect(95,808,156,313);

                g.setColor(new Color(0, 255, 1));
                g.fillRect(96,1507,153,51);

                g.setColor(new Color(0, 255, 1));
                g.fillRect(986,2111,160,27);

                //主标题
                g.setColor(new Color(51, 51, 51));
                g.fillRect(687,810,458,149);

                //副标题
                g.setColor(new Color(153, 153, 153));
                g.fillRect(777,1218,369,104);

                //装饰素材2
                g.setColor(new Color(255, 123, 172));
                g.fillRect(95,1177,5,274);

                g.setColor(new Color(255, 123, 172));
                g.fillRect(967,1058,179,60);

                g.setColor(new Color(255, 123, 172));
                g.fillRect(106,1946,130,96);

                //二维码
                g.setColor(new Color(102, 46, 145));
                g.fillRect(986,1933,160,160);*/
                break;
            //32
            case 18:
                flag = true;
                //logo
                /*
                g.setColor(new Color(251, 176, 58));
                g.fillRect(548,63,145,55);
                (162,107,129,38)
                */

                poster.setLogoX(101);
                poster.setLogoY(65);
                poster.setLogoWidth(137);
                poster.setLogoHeight(52);

                //主素材
                /*
                g.setColor(new Color(254, 0, 0));
                g.fillRect(-49,765,1579,1369);(170,278,905,1146)*/
                curPrimaryWidth = 1242.0;
                curPrimaryHeight = 2208.0;
                poster.setPrimaryX(0);
                poster.setPrimaryY(0);

                //详情文字

                /*
                g.setColor(new Color(0, 255, 1));
                g.fillRect(312,844,619,178);

                g.setColor(new Color(0, 255, 1));
                g.fillRect(540,2120,160,21);

                (382,886,475,126);
                */
                poster.setDetailX(382);
                poster.setDetailY(886);
                poster.setDetailWidth(475);
                poster.setDetailHeight(313);

                //主标题
                /*
                g.setColor(new Color(51, 51, 51));
                g.fillRect(288,329,666,216);(192,281,899,249);
                */
                poster.setMainX(192);
                poster.setMainY(200);
                poster.setMainWidth(899);
                poster.setMainHeight(350);


                //副标题
                /*
                g.setColor(new Color(153, 153, 153));
                g.fillRect(244,624,755,70);(600,526,517,93);
                */
                poster.setSubX(600);
                poster.setSubY(550);
                poster.setSubWidth(600);
                poster.setSubHeight(300);

                //二维码
                /*g.setColor(new Color(102, 46, 145));
                g.fillRect(540,1940,160,160);(541,1930,160,160);*/
                poster.setBarcodeX(541);
                poster.setBarcodeY(1930);
                poster.setBarcodeWidth(160);
                poster.setBarcodeHeight(160);

                mainColor = ctm.test(IMG_ROUTE + "src\\main\\resources\\draw\\PrimaryElement\\p1.png");
                red = colorReverse(Integer.parseInt(mainColor[0]));
                green = colorReverse(Integer.parseInt(mainColor[1]));
                blue = colorReverse(Integer.parseInt(mainColor[2]));
                //主标题
                poster.setMainFont(mainFontStyle);//字体
                poster.setMainColor(new Color(red,green,blue));//颜色
                //poster.setMainColor(new Color(red,255,255));
                //副标题
                poster.setSubFont(subFontStyle);
                poster.setSubColor(new Color(red,green,blue));
                //poster.setSubColor(new Color(255,255,255));
                //详细文字
                poster.setDetailFont(detailFontStyle);
                poster.setDetailColor(new Color(red,green,blue));
                //poster.setDetailColor(new Color(255,255,255));

/*
                //主素材
                g.setColor(new Color(254, 0, 0));
                g.fillRect(0,0,1242,2208);

                //logo
                g.setColor(new Color(251, 176, 58));
                g.fillRect(162,107,129,38);

                //装饰素材2
                g.setColor(new Color(255, 123, 172));
                g.fillRect(225,691,792,108);

                //详情文字
                g.setColor(new Color(0, 255, 1));
                g.fillRect(424,706,549,78);

                g.setColor(new Color(0, 255, 1));
                g.fillRect(237,721,146,63);

                g.setColor(new Color(0, 255, 1));
                g.fillRect(382,886,475,126);

                g.setColor(new Color(0, 255, 1));
                g.fillRect(541,2108,160,27);

                //副标题
                g.setColor(new Color(153, 153, 153));
                g.fillRect(600,526,517,93);

                //主标题
                g.setColor(new Color(51, 51, 51));
                g.fillRect(192,281,899,249);

                //二维码
                g.setColor(new Color(102, 46, 145));
                g.fillRect(541,1930,160,160);*/
                break;
            //35
            case 19:
                flag = true;
                //logo
                /*
                g.setColor(new Color(251, 176, 58));
                g.fillRect(548,63,145,55);
                (58,59,129,38)
                */

                poster.setLogoX(58);
                poster.setLogoY(59);
                poster.setLogoWidth(129);
                poster.setLogoHeight(38);

                //主素材
                /*
                g.setColor(new Color(254, 0, 0));
                g.fillRect(-49,765,1579,1369);(170,278,905,1146)*/
                curPrimaryWidth = 1242.0;
                curPrimaryHeight = 2208.0;
                poster.setPrimaryX(0);
                poster.setPrimaryY(0);

                //详情文字

                /*
                g.setColor(new Color(0, 255, 1));
                g.fillRect(312,844,619,178);

                g.setColor(new Color(0, 255, 1));
                g.fillRect(540,2120,160,21);

                (580,732,90,342);
                */
                poster.setDetailX(580);
                poster.setDetailY(940);
                poster.setDetailWidth(475);
                poster.setDetailHeight(313);

                //主标题
                /*
                g.setColor(new Color(51, 51, 51));
                g.fillRect(288,329,666,216);(433,504,410,77);
                */
                poster.setMainX(433);
                poster.setMainY(504);
                poster.setMainWidth(700);
                poster.setMainHeight(500);


                //副标题
                /*
                g.setColor(new Color(153, 153, 153));
                g.fillRect(244,624,755,70);(267,231,779,259);
                */
                poster.setSubX(267);
                poster.setSubY(231);
                poster.setSubWidth(779);
                poster.setSubHeight(259);

                //二维码
                /*g.setColor(new Color(102, 46, 145));
                g.fillRect(540,1940,160,160);(541,1951,160,160);*/
                poster.setBarcodeX(541);
                poster.setBarcodeY(1951);
                poster.setBarcodeWidth(160);
                poster.setBarcodeHeight(160);

                mainColor = ctm.test(IMG_ROUTE + "src\\main\\resources\\draw\\PrimaryElement\\p1.png");
                red = colorReverse(Integer.parseInt(mainColor[0]));
                green = colorReverse(Integer.parseInt(mainColor[1]));
                blue = colorReverse(Integer.parseInt(mainColor[2]));
                //主标题
                poster.setMainFont(mainFontStyle);//字体
                poster.setMainColor(new Color(red,green,blue));//颜色
                //poster.setMainColor(new Color(red,255,255));
                //副标题
                poster.setSubFont(subFontStyle);
                poster.setSubColor(new Color(red,green,blue));
                //poster.setSubColor(new Color(255,255,255));
                //详细文字
                poster.setDetailFont(detailFontStyle);
                poster.setDetailColor(new Color(red,green,blue));
                //poster.setDetailColor(new Color(255,255,255));

                /*
                //主素材
                g.setColor(new Color(254, 0, 0));
                g.fillRect(0,0,1242,2208);

                //logo
                g.setColor(new Color(251, 176, 58));
                g.fillRect(58,59,129,38);

                //装饰素材1
                g.setColor(new Color(205, 125, 255));
                g.fillRect(609,943,121,223);

                //装饰素材2
                g.setColor(new Color(255, 123, 172));
                g.fillRect(937,72,234,67);

                //详情文字
                g.setColor(new Color(0, 255, 1));
                g.fillRect(951,85,205,40);

                g.setColor(new Color(0, 255, 1));
                g.fillRect(580,732,90,342);

                g.setColor(new Color(0, 255, 1));
                g.fillRect(541,2122,160,27);

                //副标题
                g.setColor(new Color(153, 153, 153));
                g.fillRect(267,231,779,259);

                //主标题
                g.setColor(new Color(51, 51, 51));
                g.fillRect(433,504,410,77);

                //二维码
                g.setColor(new Color(102, 46, 145));
                g.fillRect(541,1951,160,160);*/
                break;
            //39
            case 20:
                //logo
                /*
                g.setColor(new Color(251, 176, 58));
                g.fillRect(548,63,145,55);(553,46,135,39)*/

                poster.setLogoX(553);
                poster.setLogoY(46);
                poster.setLogoWidth(135);
                poster.setLogoHeight(39);

                //主素材
                /*
                g.setColor(new Color(254, 0, 0));
                g.fillRect(-49,765,1579,1369);(219,875,912,1222)*/
                curPrimaryWidth = 912.0;
                curPrimaryHeight = 1222.0;
                poster.setPrimaryX(219);
                poster.setPrimaryY(875);

                //辅助素材
                /*g.setColor(new Color(0, 0, 254));
                g.fillRect(90,110,1062,1988);*/
                poster.setSecondaryX(90);
                poster.setSecondaryY(110);
                poster.setSecondaryWidth(1062);
                poster.setSecondaryHeight(1988);


                //详情文字

                /*
                g.setColor(new Color(0, 255, 1));
                g.fillRect(312,844,619,178);

                g.setColor(new Color(0, 255, 1));
                g.fillRect(540,2120,160,21);(467,684,307,132)
                */
                poster.setDetailX(400);
                poster.setDetailY(684);
                poster.setDetailWidth(307);
                poster.setDetailHeight(132);

                //主标题
                /*
                g.setColor(new Color(51, 51, 51));
                g.fillRect(288,329,666,216);(513,224,210,395)
                */
                poster.setMainX(513);
                poster.setMainY(224);
                poster.setMainWidth(210);
                poster.setMainHeight(450);

                //副标题
                /*
                g.setColor(new Color(153, 153, 153));
                g.fillRect(244,624,755,70);(114,325,387,76)
                */
                poster.setSubX(0);
                poster.setSubY(0);
                poster.setSubWidth(0);
                poster.setSubHeight(0);

                //二维码
                /*g.setColor(new Color(102, 46, 145));
                g.fillRect(541,1937,160,160);*/
                poster.setBarcodeX(541);
                poster.setBarcodeY(1980);
                poster.setBarcodeWidth(160);
                poster.setBarcodeHeight(160);

                /*
                //辅助素材
                g.setColor(new Color(0, 0, 254));
                g.fillRect(90,110,1062,1988);

                //主素材
                g.setColor(new Color(254, 0, 0));
                g.fillRect(219,875,912,1222);

                //logo
                g.setColor(new Color(251, 176, 58));
                g.fillRect(553,46,135,39);

                //装饰素材2
                g.setColor(new Color(255, 123, 172));
                g.fillRect(422,227,400,350);

                g.setColor(new Color(255, 123, 172));
                g.fillRect(897,162,216,96);

                //详情文字
                g.setColor(new Color(0, 255, 1));
                g.fillRect(467,684,307,132);

                g.setColor(new Color(0, 255, 1));
                g.fillRect(923,173,170,70);

                g.setColor(new Color(0, 255, 1));
                g.fillRect(541,2115,160,27);

                //主标题
                g.setColor(new Color(51, 51, 51));
                g.fillRect(513,224,210,395);

                //二维码
                g.setColor(new Color(102, 46, 145));
                g.fillRect(541,1937,160,160);*/
                break;
            //40
            case 21:
                flag = true;
                //logo
                /*
                g.setColor(new Color(251, 176, 58));
                g.fillRect(548,63,145,55);
                (555,58,133,40)
                */

                poster.setLogoX(555);
                poster.setLogoY(59);
                poster.setLogoWidth(133);
                poster.setLogoHeight(40);

                //主素材
                /*
                g.setColor(new Color(254, 0, 0));
                g.fillRect(-49,765,1579,1369);(170,278,905,1146)*/
                curPrimaryWidth = 1242.0;
                curPrimaryHeight = 2208.0;
                poster.setPrimaryX(0);
                poster.setPrimaryY(0);

                //详情文字

                /*
                g.setColor(new Color(0, 255, 1));
                g.fillRect(312,844,619,178);

                g.setColor(new Color(0, 255, 1));
                g.fillRect(540,2120,160,21);

                (377,1547,488,131);
                */
                poster.setDetailX(300);
                poster.setDetailY(1547);
                poster.setDetailWidth(600);
                poster.setDetailHeight(313);

                //主标题
                /*
                g.setColor(new Color(51, 51, 51));
                g.fillRect(288,329,666,216);(233,294,784,132);
                */
                poster.setMainX(233);
                poster.setMainY(294);
                poster.setMainWidth(784);
                poster.setMainHeight(500);


                //副标题
                /*
                g.setColor(new Color(153, 153, 153));
                g.fillRect(244,624,755,70);(267,231,779,259);
                */
                poster.setSubX(267);
                poster.setSubY(790);
                poster.setSubWidth(779);
                poster.setSubHeight(259);

                //二维码
                /*g.setColor(new Color(102, 46, 145));
                g.fillRect(540,1940,160,160);(541,1866,160,160);*/
                poster.setBarcodeX(541);
                poster.setBarcodeY(1866);
                poster.setBarcodeWidth(160);
                poster.setBarcodeHeight(160);

                mainColor = ctm.test(IMG_ROUTE + "src\\main\\resources\\draw\\PrimaryElement\\p1.png");
                red = colorReverse(Integer.parseInt(mainColor[0]));
                green = colorReverse(Integer.parseInt(mainColor[1]));
                blue = colorReverse(Integer.parseInt(mainColor[2]));
                //主标题
                poster.setMainFont(mainFontStyle);//字体
                poster.setMainColor(new Color(red,green,blue));//颜色
                //poster.setMainColor(new Color(red,255,255));
                //副标题
                poster.setSubFont(subFontStyle);
                poster.setSubColor(new Color(red,green,blue));
                //poster.setSubColor(new Color(255,255,255));
                //详细文字
                poster.setDetailFont(detailFontStyle);
                poster.setDetailColor(new Color(red,green,blue));
                //poster.setDetailColor(new Color(255,255,255));

                /*
                //主素材
                g.setColor(new Color(254, 0, 0));
                g.fillRect(0,0,1242,2208);

                //logo
                g.setColor(new Color(251, 176, 58));
                g.fillRect(555,58,133,40);

                //装饰素材2
                g.setColor(new Color(255, 123, 172));
                g.fillRect(440,493,413,62);

                //详情文字
                g.setColor(new Color(0, 255, 1));
                g.fillRect(459,505,380,39);

                g.setColor(new Color(0, 255, 1));
                g.fillRect(377,1547,488,131);

                g.setColor(new Color(0, 255, 1));
                g.fillRect(541,2044,160,27);

                //主标题
                g.setColor(new Color(51, 51, 51));
                g.fillRect(233,294,784,132);

                //二维码
                g.setColor(new Color(102, 46, 145));
                g.fillRect(541,1866,160,160);*/
                break;
            //42
            case 22:
                //logo
                /*
                g.setColor(new Color(251, 176, 58));
                g.fillRect(548,63,145,55);(558,50,127,38)*/

                poster.setLogoX(558);
                poster.setLogoY(50);
                poster.setLogoWidth(127);
                poster.setLogoHeight(38);

                //主素材
                /*
                g.setColor(new Color(254, 0, 0));
                g.fillRect(-49,765,1579,1369);(0,774,591,1434)*/
                curPrimaryWidth = 800.0;
                curPrimaryHeight = 1434.0;
                poster.setPrimaryX(0);
                poster.setPrimaryY(774);

                //辅助素材
                /*g.setColor(new Color(0, 0, 254));
                g.fillRect(0,532,1242,1685);*/
                poster.setSecondaryX(0);
                poster.setSecondaryY(532);
                poster.setSecondaryWidth(1242);
                poster.setSecondaryHeight(1685);


                //详情文字

                /*
                g.setColor(new Color(0, 255, 1));
                g.fillRect(312,844,619,178);

                g.setColor(new Color(0, 255, 1));
                g.fillRect(540,2120,160,21);(667,788,417,200)
                */
                poster.setDetailX(700);
                poster.setDetailY(788);
                poster.setDetailWidth(417);
                poster.setDetailHeight(200);

                //主标题
                /*
                g.setColor(new Color(51, 51, 51));
                g.fillRect(288,329,666,216);(173,226,897,398)
                */
                poster.setMainX(173);
                poster.setMainY(226);
                poster.setMainWidth(897);
                poster.setMainHeight(398);

                //副标题
                /*
                g.setColor(new Color(153, 153, 153));
                g.fillRect(244,624,755,70);
                */
                poster.setSubX(0);
                poster.setSubY(0);
                poster.setSubWidth(0);
                poster.setSubHeight(0);

                //二维码
                /*g.setColor(new Color(102, 46, 145));
                g.fillRect(541,1914,160,160);*/
                poster.setBarcodeX(541);
                poster.setBarcodeY(1914);
                poster.setBarcodeWidth(160);
                poster.setBarcodeHeight(160);

                /*
                //辅助素材
                g.setColor(new Color(0, 0, 254));
                g.fillRect(0,532,1242,1685);

                //主素材
                g.setColor(new Color(254, 0, 0));
                g.fillRect(0,774,591,1434);

                //logo
                g.setColor(new Color(251, 176, 58));
                g.fillRect(558,50,127,38);

                //详情文字
                g.setColor(new Color(0, 255, 1));
                g.fillRect(667,788,417,200);

                g.setColor(new Color(0, 255, 1));
                g.fillRect(541,2092,160,27);

                //主标题
                g.setColor(new Color(51, 51, 51));
                g.fillRect(173,226,897,398);

                //二维码
                g.setColor(new Color(102, 46, 145));
                g.fillRect(541,1914,160,160);*/
                break;
            //46
            case 23:
                //logo
                /*
                g.setColor(new Color(251, 176, 58));
                g.fillRect(548,63,145,55);(558,71,127,38)*/

                poster.setLogoX(558);
                poster.setLogoY(71);
                poster.setLogoWidth(127);
                poster.setLogoHeight(38);

                //主素材
                /*
                g.setColor(new Color(254, 0, 0));
                g.fillRect(-49,765,1579,1369);(234,651,755,792)*/
                curPrimaryWidth = 755.0;
                curPrimaryHeight = 792.0;
                poster.setPrimaryX(234);
                poster.setPrimaryY(651);
                //辅助素材
                /*g.setColor(new Color(0, 0, 254));
                g.fillRect(130,160,983,1919);*/
                poster.setSecondaryX(130);
                poster.setSecondaryY(160);
                poster.setSecondaryWidth(983);
                poster.setSecondaryHeight(1919);

                //二维码
                /*g.setColor(new Color(102, 46, 145));
                g.fillRect(848,1805,160,160);*/
                poster.setBarcodeX(848);
                poster.setBarcodeY(1805);
                poster.setBarcodeWidth(160);
                poster.setBarcodeHeight(160);

                //详情文字

                /*
                g.setColor(new Color(0, 255, 1));
                g.fillRect(312,844,619,178);

                g.setColor(new Color(0, 255, 1));
                g.fillRect(540,2120,160,21);(239,1531,643,232)
                */
                poster.setDetailX(239);
                poster.setDetailY(1700);
                poster.setDetailWidth(643);
                poster.setDetailHeight(232);

                //主标题
                /*
                g.setColor(new Color(51, 51, 51));
                g.fillRect(288,329,666,216);(244,442,755,142)
                */
                poster.setMainX(244);
                poster.setMainY(300);
                poster.setMainWidth(755);
                poster.setMainHeight(350);


                /*
                //辅助素材
                g.setColor(new Color(0, 0, 254));
                g.fillRect(130,160,983,1919);

                //主素材
                g.setColor(new Color(254, 0, 0));
                g.fillRect(234,651,755,792);

                //logo
                g.setColor(new Color(251, 176, 58));
                g.fillRect(558,71,127,38);

                //详情文字
                g.setColor(new Color(0, 255, 1));
                g.fillRect(239,1531,643,232);

                g.setColor(new Color(0, 255, 1));
                g.fillRect(848,1982,160,27);

                //主标题
                g.setColor(new Color(51, 51, 51));
                g.fillRect(244,442,755,142);

                //二维码
                g.setColor(new Color(102, 46, 145));
                g.fillRect(848,1805,160,160);*/
                break;
            //49
            case 24:
                flag = true;
                //logo
                /*
                g.setColor(new Color(251, 176, 58));
                g.fillRect(548,63,145,55);
                (563,68,115,36)
                */

                poster.setLogoX(563);
                poster.setLogoY(68);
                poster.setLogoWidth(115);
                poster.setLogoHeight(36);

                //主素材
                /*
                g.setColor(new Color(254, 0, 0));
                g.fillRect(-49,765,1579,1369);(170,278,905,1146)*/
                curPrimaryWidth = 1242.0;
                curPrimaryHeight = 2208.0;
                poster.setPrimaryX(0);
                poster.setPrimaryY(0);

                //详情文字

                /*
                g.setColor(new Color(0, 255, 1));
                g.fillRect(312,844,619,178);

                g.setColor(new Color(0, 255, 1));
                g.fillRect(540,2120,160,21);

                (139,1516,669,134);
                */
                poster.setDetailX(139);
                poster.setDetailY(1516);
                poster.setDetailWidth(500);
                poster.setDetailHeight(313);
                //装饰素材2
                /*g.setColor(new Color(255, 123, 172));
                g.fillRect(138,756,144,82);*/
                poster.setFirstDecorate2X(138);
                poster.setFirstDecorate2Y(756);
                poster.setFirstDecorate2Width(144);
                poster.setFirstDecorate2Height(82);

                //主标题
                /*
                g.setColor(new Color(51, 51, 51));
                g.fillRect(288,329,666,216);(136,274,574,403);
                */
                poster.setMainX(136);
                poster.setMainY(274);
                poster.setMainWidth(574);
                poster.setMainHeight(403);


                //副标题
                /*
                g.setColor(new Color(153, 153, 153));
                g.fillRect(244,624,755,70);(267,231,779,259);
                */
                poster.setSubX(150);
                poster.setSubY(800);
                poster.setSubWidth(500);
                poster.setSubHeight(400);

                //二维码
                /*g.setColor(new Color(102, 46, 145));
                g.fillRect(540,1940,160,160);(541,1866,160,160);*/
                poster.setBarcodeX(541);
                poster.setBarcodeY(1866);
                poster.setBarcodeWidth(160);
                poster.setBarcodeHeight(160);

                mainColor = ctm.test(IMG_ROUTE + "src\\main\\resources\\draw\\PrimaryElement\\p1.png");
                red = colorReverse(Integer.parseInt(mainColor[0]));
                green = colorReverse(Integer.parseInt(mainColor[1]));
                blue = colorReverse(Integer.parseInt(mainColor[2]));
                //主标题
                poster.setMainFont(mainFontStyle);//字体
                poster.setMainColor(new Color(red,green,blue));//颜色
                //poster.setMainColor(new Color(red,255,255));
                //副标题
                poster.setSubFont(subFontStyle);
                poster.setSubColor(new Color(red,green,blue));
                //poster.setSubColor(new Color(255,255,255));
                //详细文字
                poster.setDetailFont(detailFontStyle);
                poster.setDetailColor(new Color(red,green,blue));
                //poster.setDetailColor(new Color(255,255,255));

                /*
                //主素材
                g.setColor(new Color(254, 0, 0));
                g.fillRect(0,0,1242,2208);

                //logo
                g.setColor(new Color(251, 176, 58));
                g.fillRect(563,68,115,36);

                //装饰素材2
                g.setColor(new Color(255, 123, 172));
                g.fillRect(138,756,144,82);

                //详情文字
                g.setColor(new Color(0, 255, 1));
                g.fillRect(139,1516,669,134);

                g.setColor(new Color(0, 255, 1));
                g.fillRect(541,2055,160,27);

                //主标题
                g.setColor(new Color(51, 51, 51));
                g.fillRect(136,274,574,403);

                //二维码
                g.setColor(new Color(102, 46, 145));
                g.fillRect(541,1877,160,160);*/
                break;
            //50
            case 25:
                //logo
                /*
                g.setColor(new Color(251, 176, 58));
                g.fillRect(548,63,145,55);(563,55,115,36)*/

                poster.setLogoX(563);
                poster.setLogoY(55);
                poster.setLogoWidth(115);
                poster.setLogoHeight(36);

                //主素材
                /*
                g.setColor(new Color(254, 0, 0));
                g.fillRect(-49,765,1579,1369);(167,1167,904,804)*/
                curPrimaryWidth = 904.0;
                curPrimaryHeight = 804.0;
                poster.setPrimaryX(167);
                poster.setPrimaryY(1167);


                //详情文字

                /*
                g.setColor(new Color(0, 255, 1));
                g.fillRect(312,844,619,178);

                g.setColor(new Color(0, 255, 1));
                g.fillRect(540,2120,160,21);(377,744,488,35)
                */
                poster.setDetailX(377);
                poster.setDetailY(744);
                poster.setDetailWidth(488);
                poster.setDetailHeight(300);

                //主标题
                /*
                g.setColor(new Color(51, 51, 51));
                g.fillRect(288,329,666,216);(267,302,707,325)
                */
                poster.setMainX(267);
                poster.setMainY(302);
                poster.setMainWidth(707);
                poster.setMainHeight(325);

                //副标题
                /*
                g.setColor(new Color(153, 153, 153));
                g.fillRect(244,624,755,70);
                */
                poster.setSubX(0);
                poster.setSubY(0);
                poster.setSubWidth(0);
                poster.setSubHeight(0);
                /*g.fillRect(541,1881,160,160);*/
                poster.setBarcodeX(541);
                poster.setBarcodeY(1881);
                poster.setBarcodeWidth(160);
                poster.setBarcodeHeight(160);
                /*
                //logo
                g.setColor(new Color(251, 176, 58));
                g.fillRect(563,55,115,36);
                //主素材
                g.setColor(new Color(254, 0, 0));
                g.fillRect(167,1167,904,804);

                g.setColor(new Color(51, 51, 51));
                g.fillRect(267,302,707,325);

                g.setColor(new Color(255, 123, 172));
                g.fillRect(338,731,568,57);

                g.setColor(new Color(0, 255, 1));
                g.fillRect(377,744,488,35);

                g.setColor(new Color(0, 255, 1));
                g.fillRect(286,858,670,56);

                g.setColor(new Color(102, 46, 145));
                g.fillRect(541,1881,160,160);

                g.setColor(new Color(0, 255, 1));
                g.fillRect(541,2059,160,27);*/
                break;
            //60
            case 26:
                //logo
                /*
                g.setColor(new Color(251, 176, 58));
                g.fillRect(548,63,145,55);(1050,65,130,38)*/

                poster.setLogoX(1050);
                poster.setLogoY(65);
                poster.setLogoWidth(130);
                poster.setLogoHeight(38);

                //主素材
                /*
                g.setColor(new Color(254, 0, 0));
                g.fillRect(-49,765,1579,1369);(0,1320,1242,888)*/
                curPrimaryWidth = 1242.0;
                curPrimaryHeight = 888.0;
                poster.setPrimaryX(0);
                poster.setPrimaryY(1320);

                /*g.fillRect(0,0,1242,472);*/
                poster.setSecondaryX(0);
                poster.setSecondaryY(0);
                poster.setSecondaryWidth(1242);
                poster.setSecondaryHeight(472);


                //详情文字

                /*
                g.setColor(new Color(0, 255, 1));
                g.fillRect(312,844,619,178);

                g.setColor(new Color(0, 255, 1));
                g.fillRect(540,2120,160,21);(204,1331,834,99)
                */
                poster.setDetailX(204);
                poster.setDetailY(1231);
                poster.setDetailWidth(834);
                poster.setDetailHeight(99);

                //主标题
                /*
                g.setColor(new Color(51, 51, 51));
                g.fillRect(288,329,666,216);(460,324,143,600)
                */
                poster.setMainX(460);
                poster.setMainY(150);
                poster.setMainWidth(143);
                poster.setMainHeight(900);

                //副标题
                /*
                g.setColor(new Color(153, 153, 153));
                g.fillRect(244,624,755,70);(206,1253,821,50)
                */
                poster.setSubX(206);
                poster.setSubY(1060);
                poster.setSubWidth(821);
                poster.setSubHeight(100);

                //装饰素材2
                /*
                g.setColor(new Color(255, 123, 172));
                g.fillRect(476,1282,606,561);

                g.fillRect(84,139,179,91);
                g.fillRect(663,321,107,107);
                */

                poster.setFirstDecorate2X(84);
                poster.setFirstDecorate2Y(139);
                poster.setFirstDecorate2Width(179);
                poster.setFirstDecorate2Height(91);

                poster.setSecondDecorate2X(663);
                poster.setSecondDecorate2Y(321);
                poster.setSecondDecorate2Width(107);
                poster.setSecondDecorate2Height(107);

                /*g.fillRect(946,1861,201,201);*/
                poster.setBarcodeX(1000);
                poster.setBarcodeY(1900);
                poster.setBarcodeWidth(201);
                poster.setBarcodeHeight(201);
                /*
                g.setColor(new Color(0, 0, 254));
                g.fillRect(0,0,1242,472);

                g.setColor(new Color(251, 176, 58));
                g.fillRect(1050,65,130,38);

                g.setColor(new Color(51, 51, 51));
                g.fillRect(460,324,143,600);

                g.setColor(new Color(153, 153, 153));
                g.fillRect(206,1253,821,50);

                g.setColor(new Color(254, 0, 0));
                g.fillRect(0,1320,1242,888);

                g.setColor(new Color(0, 255, 1));
                g.fillRect(204,1331,834,99);
                g.fillRect(959,2092,170,39);

                g.setColor(new Color(255, 123, 172));
                g.fillRect(84,139,179,91);
                g.fillRect(663,321,107,107);

                g.setColor(new Color(102, 46, 145));
                g.fillRect(946,1861,201,201);*/
                break;
            //61
            case 27:
                //logo
                /*
                g.setColor(new Color(251, 176, 58));
                g.fillRect(548,63,145,55);(77,60,130,38)*/

                poster.setLogoX(77);
                poster.setLogoY(60);
                poster.setLogoWidth(130);
                poster.setLogoHeight(38);

                //主素材
                /*
                g.setColor(new Color(254, 0, 0));
                g.fillRect(-49,765,1579,1369);(136,244,982,1276)*/
                curPrimaryWidth = 982.0;
                curPrimaryHeight = 1276.0;
                poster.setPrimaryX(136);
                poster.setPrimaryY(244);

                /*g.fillRect(61,198,1141,1394);*/
                poster.setSecondaryX(61);
                poster.setSecondaryY(198);
                poster.setSecondaryWidth(1141);
                poster.setSecondaryHeight(1394);


                //详情文字

                /*
                g.setColor(new Color(0, 255, 1));
                g.fillRect(312,844,619,178);

                g.setColor(new Color(0, 255, 1));
                g.fillRect(540,2120,160,21);(14,1877,1052,44)
                */
                poster.setDetailX(50);
                poster.setDetailY(2040);
                poster.setDetailWidth(300);
                poster.setDetailHeight(170);

                //主标题
                /*
                g.setColor(new Color(51, 51, 51));
                g.fillRect(288,329,666,216);(527,1641,629,172)
                */
                poster.setMainX(400);
                poster.setMainY(1641);
                poster.setMainWidth(629);
                poster.setMainHeight(400);

                //副标题
                /*
                g.setColor(new Color(153, 153, 153));
                g.fillRect(244,624,755,70);
                */
                poster.setSubX(0);
                poster.setSubY(0);
                poster.setSubWidth(0);
                poster.setSubHeight(0);

                //装饰素材2
                /*
                g.setColor(new Color(255, 123, 172));
                g.fillRect(476,1282,606,561);

                g.fillRect(738,0,504,267);
                g.fillRect(0,1447,309,427);
                */

                poster.setFirstDecorate2X(0);
                poster.setFirstDecorate2Y(1447);
                poster.setFirstDecorate2Width(260);
                poster.setFirstDecorate2Height(300);

                poster.setSecondDecorate2X(820);
                poster.setSecondDecorate2Y(100);
                poster.setSecondDecorate2Width(300);
                poster.setSecondDecorate2Height(180);
                //二维码
                poster.setBarcodeX(1000);
                poster.setBarcodeY(2000);
                poster.setBarcodeWidth(160);
                poster.setBarcodeHeight(160);
                /*
                //logo
                g.setColor(new Color(251, 176, 58));
                g.fillRect(77,60,130,38);

                //辅助素材
                g.setColor(new Color(0, 0, 254));
                g.fillRect(738,0,504,267);
                g.fillRect(0,1447,309,427);

                //装饰素材2
                g.setColor(new Color(255, 123, 172));
                g.fillRect(61,198,1141,1394);
                g.fillRect(510,1623,661,200);

                //主素材
                g.setColor(new Color(254, 0, 0));
                g.fillRect(136,244,982,1276);

                //主标题
                g.setColor(new Color(51, 51, 51));
                g.fillRect(527,1641,629,172);

                //详情文字
                g.setColor(new Color(0, 255, 1));
                g.fillRect(14,1877,1052,44);
                g.fillRect(928,1967,238,39);*/
                break;
            //66
            case 28:
                //logo
                /*
                g.setColor(new Color(251, 176, 58));
                g.fillRect(548,63,145,55);(1027,137,130,38)*/

                poster.setLogoX(1027);
                poster.setLogoY(80);
                poster.setLogoWidth(130);
                poster.setLogoHeight(38);

                //主素材
                /*
                g.setColor(new Color(254, 0, 0));
                g.fillRect(-49,765,1579,1369);(41,900,1201,1308)*/
                curPrimaryWidth = 1201.0;
                curPrimaryHeight = 1308.0;
                poster.setPrimaryX(41);
                poster.setPrimaryY(900);


                //详情文字

                /*
                g.setColor(new Color(0, 255, 1));
                g.fillRect(312,844,619,178);

                g.setColor(new Color(0, 255, 1));
                g.fillRect(540,2120,160,21);(666,654,466,242);
                */
                poster.setDetailX(666);
                poster.setDetailY(654);
                poster.setDetailWidth(466);
                poster.setDetailHeight(242);

                //主标题
                /*
                g.setColor(new Color(51, 51, 51));
                g.fillRect(288,329,666,216);(135,110,200,516)
                */
                poster.setMainX(135);
                poster.setMainY(110);
                poster.setMainWidth(200);
                poster.setMainHeight(680);

                //副标题
                /*
                g.setColor(new Color(153, 153, 153));
                g.fillRect(244,624,755,70);(83,416,393,96)
                */
                poster.setSubX(450);
                poster.setSubY(280);
                poster.setSubWidth(500);
                poster.setSubHeight(300);

                //二维码
                /*g.setColor(new Color(102, 46, 145));
                g.fillRect(74,1930,206,206);*/
                poster.setBarcodeX(74);
                poster.setBarcodeY(1930);
                poster.setBarcodeWidth(160);
                poster.setBarcodeHeight(160);
                /*
                //logo
                g.setColor(new Color(251, 176, 58));
                g.fillRect(1027,137,130,38);

                //主素材
                g.setColor(new Color(254, 0, 0));
                g.fillRect(41,900,1201,1308);

                //主标题
                g.setColor(new Color(51, 51, 51));
                g.fillRect(135,110,200,516);
                g.fillRect(307,650,170,463);

                //详情文字
                g.setColor(new Color(0, 255, 1));
                g.fillRect(335,356,217,172);
                g.fillRect(666,654,466,242);
                g.fillRect(159,1145,169,135);

                //装饰素材1
                g.setColor(new Color(205, 125, 255));
                g.fillRect(180,659,92,380);

                //装饰素材2
                g.setColor(new Color(255, 123, 172));
                g.fillRect(939,1037,195,68);

                //二维码
                g.setColor(new Color(102, 46, 145));
                g.fillRect(74,1930,206,206);*/
                break;
            //70
            case 29:
                //logo
                /*
                g.setColor(new Color(251, 176, 58));
                g.fillRect(548,63,145,55);(47,37,130,38)*/

                poster.setLogoX(47);
                poster.setLogoY(37);
                poster.setLogoWidth(130);
                poster.setLogoHeight(38);

                //主素材
                /*
                g.setColor(new Color(254, 0, 0));
                g.fillRect(-49,765,1579,1369);(450,574,792,1440)*/
                curPrimaryWidth = 792.0;
                curPrimaryHeight = 1440.0;
                poster.setPrimaryX(450);
                poster.setPrimaryY(574);


                //详情文字

                /*
                g.setColor(new Color(0, 255, 1));
                g.fillRect(312,844,619,178);

                g.setColor(new Color(0, 255, 1));
                g.fillRect(540,2120,160,21);(503,2065,645,91)
                */
                poster.setDetailX(400);
                poster.setDetailY(2000);
                poster.setDetailWidth(500);
                poster.setDetailHeight(170);

                //主标题
                /*
                g.setColor(new Color(51, 51, 51));
                g.fillRect(288,329,666,216);(90,219,1015,151)
                */
                poster.setMainX(90);
                poster.setMainY(150);
                poster.setMainWidth(1015);
                poster.setMainHeight(300);

                //副标题
                /*
                g.setColor(new Color(153, 153, 153));
                g.fillRect(244,624,755,70);(83,416,393,96)
                */
                poster.setSubX(83);
                poster.setSubY(450);
                poster.setSubWidth(1000);
                poster.setSubHeight(300);

                //装饰素材2
                /*
                g.setColor(new Color(255, 123, 172));
                g.fillRect(476,1282,606,561);(760,1704,645,706)
                */

                poster.setFirstDecorate2X(760);
                poster.setFirstDecorate2Y(1704);
                poster.setFirstDecorate2Width(482);
                poster.setFirstDecorate2Height(504);


                //二维码
                /*g.setColor(new Color(102, 46, 145));
                g.fillRect(90,1967,187,187);*/
                poster.setBarcodeX(90);
                poster.setBarcodeY(1967);
                poster.setBarcodeWidth(160);
                poster.setBarcodeHeight(160);
                /*
                //装饰素材1
                g.setColor(new Color(205, 125, 255));
                g.fillRect(-102,20,457,2356);

                //logo
                g.setColor(new Color(251, 176, 58));
                g.fillRect(47,37,130,38);

                //主标题
                g.setColor(new Color(51, 51, 51));
                g.fillRect(90,219,1015,151);

                //副标题
                g.setColor(new Color(153, 153, 153));
                g.fillRect(83,416,393,96);

                //主素材
                g.setColor(new Color(254, 0, 0));
                g.fillRect(450,574,792,1440);

                //详情文字
                g.setColor(new Color(0, 255, 1));
                g.fillRect(171,659,123,640);
                g.fillRect(503,2065,645,91);

                //装饰素材2
                g.setColor(new Color(255, 123, 172));
                g.fillRect(760,1704,645,706);

                //二维码
                g.setColor(new Color(102, 46, 145));
                g.fillRect(90,1967,187,187);*/
                break;
            //73
            case 30:
                flag = true;
                //logo
                /*
                g.setColor(new Color(251, 176, 58));
                g.fillRect(548,63,145,55);
                (430,61,130,38);
                */

                poster.setLogoX(430);
                poster.setLogoY(61);
                poster.setLogoWidth(130);
                poster.setLogoHeight(38);

                //主素材
                /*
                g.setColor(new Color(254, 0, 0));
                g.fillRect(-49,765,1579,1369);(0,1130,1242,1444);*/
                curPrimaryWidth = 1242.0;
                curPrimaryHeight = 1078.0;
                poster.setPrimaryX(0);
                poster.setPrimaryY(1130);

                /*g.fillRect(108,172,1022,1143);*/
                poster.setSecondaryX(108);
                poster.setSecondaryY(172);
                poster.setSecondaryWidth(1022);
                poster.setSecondaryHeight(1143);

                //详情文字

                /*
                g.setColor(new Color(0, 255, 1));
                g.fillRect(312,844,619,178);

                g.setColor(new Color(0, 255, 1));
                g.fillRect(540,2120,160,21);

                g.fillRect(353,634,536,283);
                */
                poster.setDetailX(353);
                poster.setDetailY(634);
                poster.setDetailWidth(536);
                poster.setDetailHeight(313);
                //装饰素材2
                /*g.setColor(new Color(255, 123, 172));
                g.fillRect(138,756,144,82);
                g.fillRect(-67,0,372,356);
                g.fillRect(923,0,371,357);*/
                poster.setFirstDecorate2X(0);
                poster.setFirstDecorate2Y(0);
                poster.setFirstDecorate2Width(372);
                poster.setFirstDecorate2Height(356);

                poster.setSecondDecorate2X(870);
                poster.setSecondDecorate2Y(0);
                poster.setSecondDecorate2Width(372);
                poster.setSecondDecorate2Height(356);

                //主标题
                /*
                g.setColor(new Color(51, 51, 51));
                g.fillRect(288,329,666,216);(345,522,551,63);
                */
                poster.setMainX(245);
                poster.setMainY(300);
                poster.setMainWidth(700);
                poster.setMainHeight(500);


                //副标题
                /*
                g.setColor(new Color(153, 153, 153));
                g.fillRect(244,624,755,70);(783,959,130,90);
                */
                poster.setSubX(400);
                poster.setSubY(959);
                poster.setSubWidth(700);
                poster.setSubHeight(400);

                //二维码
                /*g.setColor(new Color(102, 46, 145));
                g.fillRect(540,1940,160,160);(541,1866,160,160);*/
                poster.setBarcodeX(90);
                poster.setBarcodeY(1967);
                poster.setBarcodeWidth(160);
                poster.setBarcodeHeight(160);

                mainColor = ctm.test(IMG_ROUTE + "src\\main\\resources\\draw\\PrimaryElement\\p1.png");
                red = colorReverse(Integer.parseInt(mainColor[0]));
                green = colorReverse(Integer.parseInt(mainColor[1]));
                blue = colorReverse(Integer.parseInt(mainColor[2]));
                //主标题
                poster.setMainFont(mainFontStyle);//字体
                poster.setMainColor(new Color(red,green,blue));//颜色
                //poster.setMainColor(new Color(red,255,255));
                //副标题
                poster.setSubFont(subFontStyle);
                poster.setSubColor(new Color(red,green,blue));
                //poster.setSubColor(new Color(255,255,255));
                //详细文字
                poster.setDetailFont(detailFontStyle);
                poster.setDetailColor(new Color(red,green,blue));
                //poster.setDetailColor(new Color(255,255,255));

                /*
                //logo
                g.setColor(new Color(251, 176, 58));
                g.fillRect(430,61,130,38);

                //辅助素材
                g.setColor(new Color(0, 0, 254));
                g.fillRect(-67,0,372,356);
                g.fillRect(923,0,371,357);

                //装饰素材1
                g.setColor(new Color(205, 125, 255));
                g.fillRect(108,172,1022,1143);

                //主素材
                g.setColor(new Color(254, 0, 0));
                g.fillRect(0,1130,1242,1444);

                //详情文字
                g.setColor(new Color(0, 255, 1));
                g.fillRect(353,634,536,283);
                g.fillRect(783,959,130,90);

                //主标题
                g.setColor(new Color(51, 51, 51));
                g.fillRect(345,522,551,63);*/
                break;
            //83
            case 31:
                //logo
                /*
                g.setColor(new Color(251, 176, 58));
                g.fillRect(548,63,145,55);(79,75,130,38)*/

                poster.setLogoX(79);
                poster.setLogoY(75);
                poster.setLogoWidth(130);
                poster.setLogoHeight(38);

                //主素材
                /*
                g.setColor(new Color(254, 0, 0));
                g.fillRect(-49,765,1579,1369);(60,1086,1132,760)*/
                curPrimaryWidth = 1132.0;
                curPrimaryHeight = 760.0;
                poster.setPrimaryX(60);
                poster.setPrimaryY(1086);



                //详情文字

                /*
                g.setColor(new Color(0, 255, 1));
                g.fillRect(312,844,619,178);

                g.setColor(new Color(0, 255, 1));
                g.fillRect(540,2120,160,21);(150,821,942,183);
                */
                poster.setDetailX(150);
                poster.setDetailY(821);
                poster.setDetailWidth(942);
                poster.setDetailHeight(183);

                //主标题
                /*
                g.setColor(new Color(51, 51, 51));
                g.fillRect(288,329,666,216);(121,270,1021,289)
                */
                poster.setMainX(121);
                poster.setMainY(270);
                poster.setMainWidth(1021);
                poster.setMainHeight(289);

                //副标题
                /*
                g.setColor(new Color(153, 153, 153));
                g.fillRect(244,624,755,70);(393,683,457,59)
                */
                poster.setSubX(121);
                poster.setSubY(500);
                poster.setSubWidth(1000);
                poster.setSubHeight(100);

                //装饰素材2
                /*
                g.setColor(new Color(255, 123, 172));
                g.fillRect(476,1282,606,561);
                g.fillRect(998,0, 244, 262);
                g.fillRect(0,1802,200,406);
                */
                poster.setFirstDecorate2X(0);
                poster.setFirstDecorate2Y(1802);
                poster.setFirstDecorate2Width(200);
                poster.setFirstDecorate2Height(406);

                poster.setSecondDecorate2X(998);
                poster.setSecondDecorate2Y(0);
                poster.setSecondDecorate2Width(244);
                poster.setSecondDecorate2Height(262);

                //二维码
                /*g.setColor(new Color(102, 46, 145));
                g.fillRect(520,1855,200,200);*/
                poster.setBarcodeX(520);
                poster.setBarcodeY(1855);
                poster.setBarcodeWidth(160);
                poster.setBarcodeHeight(160);

                /*
                //logo
                g.setColor(new Color(251, 176, 58));
                g.fillRect(79,75,130,38);

                //主素材
                g.setColor(new Color(254, 0, 0));
                g.fillRect(60,1086,1132,760);

                //辅助素材
                g.setColor(new Color(0, 0, 254));
                g.fillRect(998,0, 244, 262);
                g.fillRect(0,1802,200,406);

                //详情文字
                g.setColor(new Color(0, 255, 1));
                g.fillRect(286,607,670,37);
                g.fillRect(150,821,942,183);
                g.fillRect(496,2070,248,40);

                //主标题
                g.setColor(new Color(51, 51, 51));
                g.fillRect(121,270,1021,289);

                //副标题
                g.setColor(new Color(153, 153, 153));
                g.fillRect(393,683,457,59);
                //装饰素材2
                g.setColor(new Color(255, 123, 172));
                g.fillRect(105,338,85,171);
                g.fillRect(399,767,443,17);

                //二维码
                g.setColor(new Color(102, 46, 145));
                g.fillRect(520,1855,200,200);*/
                break;
            //2
            case 32:
                //logo
                /*
                g.setColor(new Color(251, 176, 58));
                g.fillRect(548,63,145,55);(553,59,134,52)*/

                poster.setLogoX(553);
                poster.setLogoY(59);
                poster.setLogoWidth(134);
                poster.setLogoHeight(52);

                //辅助素材
                /*g.setColor(new Color(0, 0, 254));
                g.fillRect(596,1510,924,924);
                g.setColor(new Color(0, 0, 254));
                g.fillRect(0,1872,1236,336);*/

                poster.setSecondaryX(596);
                poster.setSecondaryY(1510);
                poster.setSecondaryWidth(924);
                poster.setSecondaryHeight(924);

                //主素材
                /*
                g.setColor(new Color(254, 0, 0));
                g.fillRect(-49,765,1579,1369);(191,777,795,1248)*/
                curPrimaryWidth = 795.0;
                curPrimaryHeight = 1248.0;
                poster.setPrimaryX(191);
                poster.setPrimaryY(777);


                //详情文字

                /*
                g.setColor(new Color(0, 255, 1));
                g.fillRect(312,844,619,178);

                g.setColor(new Color(0, 255, 1));
                g.fillRect(540,2120,160,21);(789,1764,300,69)
                */
                poster.setDetailX(789);
                poster.setDetailY(1950);
                poster.setDetailWidth(300);
                poster.setDetailHeight(170);

                //主标题
                /*
                g.setColor(new Color(51, 51, 51));
                g.fillRect(288,329,666,216);(289,399,665,356)
                */
                poster.setMainX(289);
                poster.setMainY(399);
                poster.setMainWidth(665);
                poster.setMainHeight(356);

                //副标题
                /*
                g.setColor(new Color(153, 153, 153));
                g.fillRect(244,624,755,70)(214,186,811,180);
                */
                poster.setSubX(214);
                poster.setSubY(186);
                poster.setSubWidth(811);
                poster.setSubHeight(180);

                //装饰素材2
                /*
                g.setColor(new Color(255, 123, 172));
                g.fillRect(476,1282,606,561);

                g.fillRect(101,732,147,146);

                g.setColor(new Color(255, 123, 172));
                g.fillRect(999,66,95,96);
                */

                poster.setFirstDecorate2X(101);
                poster.setFirstDecorate2Y(732);
                poster.setFirstDecorate2Width(147);
                poster.setFirstDecorate2Height(146);

                poster.setSecondDecorate2X(999);
                poster.setSecondDecorate2Y(66);
                poster.setSecondDecorate2Width(95);
                poster.setSecondDecorate2Height(96);

                //二维码
                /*
                g.setColor(new Color(102, 46, 145));
                g.fillRect(540,1940,160,160);
                */
                poster.setBarcodeX(540);
                poster.setBarcodeY(1940);
                poster.setBarcodeWidth(160);
                poster.setBarcodeHeight(160);

                //二维码
                /*
                g.setColor(new Color(102, 46, 145));
                g.fillRect(540,1940,160,160);
                */
                break;
            //20
            case 33:
                //logo
                g.setColor(new Color(251, 176, 58));
                g.fillRect(556,52,130,38);

                //详情文字
                g.setColor(new Color(0, 255, 1));
                g.fillRect(402,1260,438,60);

                g.setColor(new Color(0, 255, 1));
                g.fillRect(162,1419,917,338);

                g.setColor(new Color(0, 255, 1));
                g.fillRect(541,2072,160,27);

                //主标题
                g.setColor(new Color(51, 51, 51));
                g.fillRect(293,555,651,453);

                //副标题
                g.setColor(new Color(153, 153, 153));
                g.fillRect(295,391,631,103);

                //装饰素材2
                g.setColor(new Color(255, 123, 172));
                g.fillRect(388,1236,463,2);

                g.setColor(new Color(255, 123, 172));
                g.fillRect(388,1342,463,2);

                //二维码
                g.setColor(new Color(102, 46, 145));
                g.fillRect(541,1894,160,160);
                break;
            //65
            case 34:

                //详情文字
                g.setColor(new Color(0, 255, 1));
                g.fillRect(585,88,555,24);
                g.fillRect(513,838,616,35);
                g.fillRect(235,1237,893,215);

                //主标题
                g.setColor(new Color(51, 51, 51));
                g.fillRect(465,913,663,130);

                //装饰素材2
                g.setColor(new Color(255, 123, 172));
                g.fillRect(475,1093,653,33);
                g.fillRect(1066,1708,62,33);

                //辅助素材
                g.setColor(new Color(0, 0, 254));
                g.fillRect(0,1754,753,447);

                //二维码
                g.setColor(new Color(102, 46, 145));
                g.fillRect(932,1913,195,195);
                break;

            //72
            case 35:
                //logo
                g.setColor(new Color(251, 176, 58));
                g.fillRect(556,81,130,38);

                //辅助素材
                g.setColor(new Color(0, 0, 254));
                g.fillRect(122,79,354,461);
                g.fillRect(766,79,354,461);

                //装饰素材1
                g.setColor(new Color(205, 125, 255));
                g.fillRect(237,330,739,678);

                //主素材
                g.setColor(new Color(254, 0, 0));
                g.fillRect(108,820,446,599);
                g.fillRect(683,820,446,599);

                //主标题
                g.setColor(new Color(51, 51, 51));
                g.fillRect(540,462,162,470);

                //装饰素材2
                g.setColor(new Color(255, 123, 172));
                g.fillRect(109,1446,1025,59);

                //详情文字
                g.setColor(new Color(0, 255, 1));
                g.fillRect(482,1555,310,62);
                g.fillRect(229,1663,812,265);
                g.fillRect(842,1970,197,46);
                break;

            //81
            case 36:
                //logo
                g.setColor(new Color(251, 176, 58));
                g.fillRect(437,90,130,38);

                //装饰素材2
                g.setColor(new Color(255, 123, 172));
                g.fillRect(69,5,154,72);
                g.fillRect(863,326,721,721);
                g.fillRect(0,1132,413,243);

                //主素材
                g.setColor(new Color(254, 0, 0));
                g.fillRect(0,147,358,781);
                g.fillRect(903,723,901,781);

                //详情文字
                g.setColor(new Color(0, 255, 1));
                g.fillRect(360,1240,523,151);
                g.fillRect(484,1543,275,68);
                g.fillRect(125,1773,733,128);

                //主标题
                g.setColor(new Color(51, 51, 51));
                g.fillRect(520,385,200,500);

                //二维码
                g.setColor(new Color(102, 46, 145));
                g.fillRect(929,1885,191,191);
                break;

            //84
            case 37:
                //logo
                g.setColor(new Color(251, 176, 58));
                g.fillRect(1056,65,130,38);

                //详情文字
                g.setColor(new Color(0, 255, 1));
                g.fillRect(792,776,356,328);
                g.fillRect(250,2041,640,98);

                //主标题
                g.setColor(new Color(51, 51, 51));
                g.fillRect(56,99,541,1675);

                //副标题
                g.setColor(new Color(153, 153, 153));
                g.fillRect(969,259,183,314);

                //装饰素材2
                g.setColor(new Color(255, 123, 172));
                g.fillRect(1128,719,19,249);

                //二维码
                g.setColor(new Color(102, 46, 145));
                g.fillRect(935,1916,225,225);
                break;

            //89
            case 38:

                //装饰素材1
                g.setColor(new Color(205, 125, 255));
                g.fillRect(450,315,1000,1300);

                //装饰素材2
                g.setColor(new Color(255, 123, 172));
                g.fillRect(480,0,1000,315);
                g.fillRect(621,876,508,160);
                //logo
                g.setColor(new Color(251, 176, 58));
                g.fillRect(749,75,130,38);


                //详情文字
                g.setColor(new Color(0, 255, 1));
                g.fillRect(696,905,359,102);
                g.fillRect(506,1142,625,409);
                g.fillRect(887,2107,242,36);

                //主标题
                g.setColor(new Color(51, 51, 51));
                g.fillRect(480,311,672,348);

                //副标题
                g.setColor(new Color(153, 153, 153));
                g.fillRect(420,720,700,95);

                //二维码
                g.setColor(new Color(102, 46, 145));
                g.fillRect(941,1894,188,188);
                break;

            //97
            case 39:
                //logo
                g.setColor(new Color(251, 176, 58));
                g.fillRect(101,103,130,38);

                //主标题
                g.setColor(new Color(51, 51, 51));
                g.fillRect(103,301,890,312);

                //副标题
                g.setColor(new Color(153, 153, 153));
                g.fillRect(102,1728,593,73);

                //装饰素材2
                g.setColor(new Color(255, 123, 172));
                g.fillRect(103,650,550,100);

                //详情文字
                g.setColor(new Color(0, 255, 1));
                g.fillRect(621,305,330,101);
                g.fillRect(148,668,450,64);
                g.fillRect(101,1861,600,150);

                //二维码
                g.setColor(new Color(102, 46, 145));
                g.fillRect(949,1849,192,192);
                break;
        }

        if(poster.getLogoWidth() == 0) return ;
        if(flag){
            g.drawImage(primary.getScaledInstance((int)curPrimaryWidth, (int)curPrimaryHeight, Image.SCALE_DEFAULT), poster.getPrimaryX(), poster.getPrimaryY(), null);
            //辅助素材
            if(poster.getSecondaryWidth() != 0){
                g.drawImage(secondary.getScaledInstance(poster.getSecondaryWidth(), poster.getSecondaryHeight(), Image.SCALE_SMOOTH),
                        poster.getSecondaryX(), poster.getSecondaryY(), null);
            }
            flag = false;
        }else{
            //辅助素材
            if(poster.getSecondaryWidth() != 0){
                g.drawImage(secondary.getScaledInstance(poster.getSecondaryWidth(), poster.getSecondaryHeight(), Image.SCALE_SMOOTH),
                        poster.getSecondaryX(), poster.getSecondaryY(), null);
            }

            //主素材
            double pRate = 0;
            if(curPrimaryHeight > curPrimaryWidth){
                pRate = curPrimaryWidth/poster.getPrimaryWidth();
                poster.setPrimaryHeight((int)(pRate * poster.getPrimaryHeight()));
                poster.setPrimaryWidth((int)curPrimaryWidth);
            /*if(poster.getPrimaryWidth() > curPrimaryWidth){

            }*/

            }else{
                pRate = curPrimaryHeight/poster.getPrimaryHeight();
                poster.setPrimaryWidth((int)(pRate * poster.getPrimaryWidth()));
                poster.setPrimaryHeight((int)curPrimaryHeight);
            }
        /*if(poster.getPrimaryHeight() > poster.getPrimaryWidth()){
            if(curSecondaryHeight > curSecondaryWidth){
                pRate = curPrimaryWidth/poster.getPrimaryWidth();
                poster.setPrimaryHeight((int)(pRate * poster.getPrimaryHeight()));
                poster.setPrimaryWidth((int)curPrimaryWidth);
            }else{
                pRate = curPrimaryHeight/poster.getPrimaryHeight();
                poster.setPrimaryWidth((int)(pRate * poster.getPrimaryWidth()));
                poster.setPrimaryHeight((int)curPrimaryHeight);
            }
            *//*if(poster.getPrimaryHeight() <= curPrimaryHeight){
                System.out.println(poster.getPrimaryHeight());
                System.out.println(poster.getPrimaryWidth());
                System.out.println(curPrimaryHeight);
                System.out.println(curPrimaryWidth);
                pRate = curPrimaryHeight/poster.getPrimaryHeight();
                poster.setPrimaryWidth((int)(poster.getPrimaryWidth()/pRate));
                poster.setPrimaryHeight((int)curPrimaryHeight);
                System.out.println(poster.getPrimaryWidth());

            }else{
                pRate = curPrimaryHeight/poster.getPrimaryHeight();
                poster.setPrimaryWidth((int)(pRate * poster.getPrimaryWidth()));
                poster.setPrimaryHeight((int)curPrimaryHeight);

            }*//*
        }else if(poster.getPrimaryHeight() <= poster.getPrimaryWidth()){
            if(curSecondaryHeight > curSecondaryWidth){
                pRate = curPrimaryWidth/poster.getPrimaryWidth();
                poster.setPrimaryHeight((int)(pRate * poster.getPrimaryHeight()));
                poster.setPrimaryWidth((int)curPrimaryWidth);
            }else{
                pRate = curPrimaryHeight/poster.getPrimaryHeight();
                poster.setPrimaryWidth((int)(pRate * poster.getPrimaryWidth()));
                poster.setPrimaryHeight((int)curPrimaryHeight);
            }
            *//*if(poster.getPrimaryWidth() <= curPrimaryWidth){
                pRate = curPrimaryWidth/poster.getPrimaryWidth();
                poster.setPrimaryHeight((int)(pRate * poster.getPrimaryHeight()));
                poster.setPrimaryWidth((int)curPrimaryWidth);

            }
            else{
                pRate = curPrimaryWidth/poster.getPrimaryWidth();
                poster.setPrimaryHeight((int)(pRate * poster.getPrimaryHeight()));
                poster.setPrimaryWidth((int)curPrimaryWidth);
            }*//*
        }*/

            g.drawImage(primary.getScaledInstance(poster.getPrimaryWidth(), poster.getPrimaryHeight(), Image.SCALE_SMOOTH),
                    poster.getPrimaryX() +((int)curPrimaryWidth - poster.getPrimaryWidth()) /2, poster.getPrimaryY() + ((int)curPrimaryHeight - poster.getPrimaryHeight()) /2, null);
        }


        //装饰素材1
        //装饰素材2

      /*          g.setColor(new Color(255, 123, 172));
                g.fillRect(101,732,147,146);

                g.setColor(new Color(255, 123, 172));
                g.fillRect(999,66,95,96);
        */
        if(poster.getFirstDecorate1Width() != 0){
            g.drawImage(decorate10.getScaledInstance(poster.getFirstDecorate1Width(), poster.getFirstDecorate1Height(), Image.SCALE_SMOOTH),
                    poster.getFirstDecorate1X(), poster.getFirstDecorate1Y(), null);
        }
        if(poster.getFirstDecorate2Width() != 0){
            g.drawImage(decorate20.getScaledInstance(poster.getFirstDecorate2Width(), poster.getFirstDecorate2Height(), Image.SCALE_SMOOTH),
                    poster.getFirstDecorate2X(), poster.getFirstDecorate2Y(), null);
        }
        if(poster.getSecondDecorate1Width() != 0){
            g.drawImage(decorate11.getScaledInstance(poster.getSecondDecorate1Width(), poster.getSecondDecorate1Height(), Image.SCALE_SMOOTH),
                    poster.getSecondDecorate1X(), poster.getSecondDecorate1Y(), null);
        }
        if(poster.getSecondDecorate2Width() != 0){
            g.drawImage(decorate21.getScaledInstance(poster.getSecondDecorate2Width(), poster.getSecondDecorate2Height(), Image.SCALE_SMOOTH),
                    poster.getSecondDecorate2X(), poster.getSecondDecorate2Y(), null);
        }

        /*for(BufferedImage BI : decorate2List){
            int decorate0Width = BI.getWidth();
            int decorate0Height = BI.getHeight();

            double rate = 0;
            if(flag){
                flag = false;
                if(firstDecorate2Width == 0) continue;
                if(decorate0Height > decorate0Width){
                    if(decorate0Height <= firstDecorate2Height){
                        rate = firstDecorate2Height/decorate0Height;
                        decorate0Width = (int)(rate * decorate0Width);
                        decorate0Height = (int)firstDecorate2Height;
                    }else{
                        rate = firstDecorate2Height/decorate0Height;
                        decorate0Width = (int)(rate * decorate0Width);
                        decorate0Height = (int)firstDecorate2Height;
                    }
                }else if(decorate0Height <= decorate0Width){
                    if(decorate0Width <= firstDecorate2Width){
                        rate = firstDecorate2Width/decorate0Width;
                        decorate0Height = (int)(rate * decorate0Height);
                        decorate0Width = (int)firstDecorate2Width;

                    }
                    else{
                        rate = firstDecorate2Width/decorate0Width;
                        decorate0Height = (int)(rate * decorate0Height);
                        decorate0Width = (int)firstDecorate2Width;
                    }
                }
                g.drawImage(BI.getScaledInstance(decorate0Width, decorate0Height, Image.SCALE_SMOOTH),
                        poster.getFirstDecorate2X(), poster.getFirstDecorate2Y(), null);

            }else{
                flag = true;
                if(secondDecorate2Width == 0) continue;
                if(decorate0Height > decorate0Width){
                    if(decorate0Height <= secondDecorate2Height){
                        rate = secondDecorate2Height/decorate0Height;
                        decorate0Width = (int)(rate * decorate0Width);
                        decorate0Height = (int)secondDecorate2Height;
                    }else{
                        rate = secondDecorate2Height/decorate0Height;
                        decorate0Width = (int)(rate * decorate0Width);
                        decorate0Height = (int)secondDecorate2Height;
                    }
                }else if(decorate0Height <= decorate0Width){
                    if(decorate0Width <= secondDecorate2Width){
                        rate = secondDecorate2Width/decorate0Width;
                        decorate0Height = (int)(rate * decorate0Height);
                        decorate0Width = (int)secondDecorate2Width;
                    }else{
                        rate = secondDecorate2Width/decorate0Height;
                        decorate0Height = (int)(rate * decorate0Height);
                        decorate0Width = (int)secondDecorate2Width;
                    }
                }
                g.drawImage(BI.getScaledInstance(decorate0Width, decorate0Height, Image.SCALE_SMOOTH),
                        poster.getSecondDecorate2X(), poster.getSecondDecorate2Y(), null);
            }
        }*/


        //logo
        g.drawImage(logo.getScaledInstance(poster.getLogoWidth(),poster.getLogoHeight(), Image.SCALE_SMOOTH),
                poster.getLogoX(),poster.getLogoY(), null);
        //二维码
                /*
                g.setColor(new Color(102, 46, 145));
                g.fillRect(540,1940,160,160);
                */
        if(poster.getBarcodeWidth() != 0){
            g.drawImage(barcode.getScaledInstance(poster.getBarcodeWidth(),poster.getBarcodeWidth(), Image.SCALE_SMOOTH),
                    poster.getBarcodeX(),poster.getBarcodeY(), null);
        }


        //详情文字
                /*
                g.setColor(new Color(0, 255, 1));
                g.fillRect(789,1764,300,69);

                g.setColor(new Color(0, 255, 1));
                g.fillRect(794,1854,200,113);

                g.setColor(new Color(0, 255, 1));
                g.fillRect(540,2120,160,21);
                */

        g.setColor(poster.getDetailColor());
        //主标题初始化为150
        while(getWordHeight(poster.getDetailFont()) > poster.getDetailHeight()){
            detailSize--;
            poster.setDetailFont(FontUtil.getFont(18, detailSize));

        }
        int curDetailSize = detailSize;
        if(getWordWidth(poster.getDetailFont(),detail) > poster.getDetailWidth()){
            while(getWordWidth(poster.getDetailFont(),detail) > poster.getDetailWidth()){
                curDetailSize--;
                poster.setDetailFont(FontUtil.getFont(18, curDetailSize));
            }
        }

        if(curDetailSize <= 40){
            poster.setDetailFont(FontUtil.getFont(18, detailSize));
            //System.out.println(getWordWidth(poster.getSubFont(),subHeading) );
            if(getWordWidth(poster.getDetailFont(),detail) > poster.getDetailWidth()){
                while(getWordHeight(poster.getDetailFont())*2 > poster.getDetailHeight()){
                    detailSize--;
                    poster.setDetailFont(FontUtil.getFont(18, detailSize));
                }


                String firstDetail = detail.substring(0,1);
                String secondDetail = detail.substring(0,1);


                int curIndex = 0;
                int preIndex = 0;
                while(curIndex < detail.length()) {
                    preIndex = curIndex;
                    curIndex ++;
                    firstDetail = detail.substring(0, preIndex);
                    secondDetail = detail.substring(preIndex, detail.length());
                    firstDetailWidth = getWordWidth(poster.getDetailFont(), firstDetail);
                    secondDetailWidth = getWordWidth(poster.getDetailFont(), secondDetail);
//                    System.out.println(detail.length());
//                    System.out.println(detail.length()/2);
//                    System.out.println(detail.length()/2);
                    if (firstDetailWidth > poster.getDetailWidth()) {

                        break;
                    }

                }

                g.setFont(poster.getDetailFont());
                g.drawString(firstDetail, poster.getDetailX() + (poster.getDetailWidth() - firstDetailWidth)/2,poster.getDetailY() + g.getFontMetrics(poster.getDetailFont()).getAscent());
                g.drawString(secondDetail, poster.getDetailX() + (poster.getDetailWidth() - secondDetailWidth)/2 < poster.getDetailX()? poster.getDetailX() + (poster.getDetailWidth() - firstDetailWidth)/2 : poster.getDetailX() + (poster.getDetailWidth() - secondDetailWidth)/2,poster.getDetailY() + 2 * g.getFontMetrics(poster.getDetailFont()).getAscent() + g.getFontMetrics(poster.getDetailFont()).getDescent() );


            }else{
                g.setFont(poster.getDetailFont());
                g.drawString(poster.getDetail(), poster.getDetailX() + (poster.getDetailWidth() - getWordWidth(poster.getDetailFont(),detail))/2, poster.getDetailY() + g.getFontMetrics(poster.getDetailFont()).getAscent());
            }
        }else{
            g.setFont(poster.getDetailFont());
            g.drawString(poster.getDetail(), poster.getDetailX() + (poster.getDetailWidth() - getWordWidth(poster.getDetailFont(),detail))/2, poster.getDetailY() + g.getFontMetrics(poster.getDetailFont()).getAscent());

        }

        //主标题
                /*g.setColor(new Color(51, 51, 51));
                g.fillRect(289,399,665,356);
                */

        if(poster.getMainWidth() <= 370){

            g.setColor(poster.getMainColor());
            int curMainSize = mainSize;
            while(getWordHeight(poster.getMainFont()) * poster.getMainHeading().length() > poster.getMainHeight()){
                curMainSize--;
                poster.setMainFont(FontUtil.getFont(28, curMainSize));
            }
            g.setFont(poster.getMainFont());
            int mainY = poster.getMainY() + g.getFontMetrics(poster.getMainFont()).getAscent();
            int high = getWordHeight(poster.getMainFont());
            for (int i = 0; i < poster.getMainHeading().length(); i++) {
                g.drawString(String.valueOf(poster.getMainHeading().charAt(i)),poster.getMainX() + (poster.getMainWidth() - getWordWidth(poster.getMainFont(),String.valueOf(poster.getMainHeading().charAt(i))))/2,mainY);
                mainY += high;
            }
        }else{
            g.setColor(poster.getMainColor());
            //主标题初始化为150
            while(getWordHeight(poster.getMainFont()) > poster.getMainHeight()){
                mainSize--;
                poster.setMainFont(FontUtil.getFont(28, mainSize));

            }

            int curSize = mainSize;
            if(getWordWidth(poster.getMainFont(),mainHeading) > poster.getMainWidth()){
                while(getWordWidth(poster.getMainFont(),mainHeading) > poster.getMainWidth()){
                    curSize--;
                    poster.setMainFont(FontUtil.getFont(28, curSize));
                }
            }
            /*System.out.println(poster.getMainWidth());
            System.out.println(getWordWidth(poster.getMainFont(),mainHeading));*/
            if(curSize <= 100){
                //System.out.println("gggggg" );
                poster.setMainFont(FontUtil.getFont(28, mainSize));
                if(getWordWidth(poster.getMainFont(),mainHeading) > poster.getMainWidth()){
                    while(getWordHeight(poster.getMainFont())*2 > poster.getMainHeight()){
                        mainSize--;
                        poster.setMainFont(FontUtil.getFont(28, mainSize));
                    }


                    String firstMainHeading = mainHeading.substring(0,1);
                    String secondMainHeading = mainHeading.substring(0,1);

                    //System.out.println(",,,,,,,,,,,,,,,,,,,,,,,,");
                    int curIndex = 0;
                    int preIndex = 0;
                    while(curIndex < mainHeading.length()) {
                        preIndex = curIndex;
                        curIndex ++;
                        firstMainHeading = mainHeading.substring(0, preIndex);
                        secondMainHeading = mainHeading.substring(preIndex, mainHeading.length());
                        firstMainHeadingWidth = getWordWidth(poster.getMainFont(), firstMainHeading);
                        secondMainHeadingWidth = getWordWidth(poster.getMainFont(), secondMainHeading);
                        //System.out.println(firstSubHeading.length());
                        //System.out.println(detail.length()/2);
                        //System.out.println(detail.length()/2);
                        if (firstMainHeadingWidth > poster.getMainWidth()) {
                            break;
                        }

                    }

                    g.setFont(poster.getMainFont());
                    g.drawString(firstMainHeading, poster.getMainX() + (poster.getMainWidth() - firstMainHeadingWidth)/2,poster.getMainY() + g.getFontMetrics(poster.getMainFont()).getAscent());
                    g.drawString(secondMainHeading, poster.getMainX() + (poster.getMainWidth() - secondMainHeadingWidth)/2 < poster.getMainX()? poster.getMainX() + (poster.getMainWidth() - firstMainHeadingWidth)/2 : poster.getMainX() + (poster.getMainWidth() - secondMainHeadingWidth)/2,poster.getMainY() + 2 * g.getFontMetrics(poster.getMainFont()).getAscent() + g.getFontMetrics(poster.getMainFont()).getDescent() );


                }else{

                    g.setFont(poster.getMainFont());
                    g.drawString(poster.getMainHeading(), poster.getMainX() + (poster.getMainWidth() - getWordWidth(poster.getMainFont(),mainHeading))/2, poster.getMainY() + g.getFontMetrics(poster.getMainFont()).getAscent());
                }
            }else{
                //System.out.println("ppp");
                g.setFont(poster.getMainFont());
                g.drawString(poster.getMainHeading(), poster.getMainX() + (poster.getMainWidth() - getWordWidth(poster.getMainFont(),mainHeading))/2 - 30, poster.getMainY() + g.getFontMetrics(poster.getMainFont()).getAscent());

            }

        }



        //副标题
        if(poster.getSubWidth() != 0){

                /*g.setColor(new Color(153, 153, 153));
                g.fillRect(214,186,811,180);
                */
            if(poster.getSubWidth() <= 200){
                g.setColor(poster.getSubColor());
                int curSubSize = subSize;
                while(getWordHeight(poster.getSubFont()) * poster.getSubHeading().length() > poster.getSubHeight()){
                    curSubSize--;
                    poster.setSubFont(FontUtil.getFont(8, curSubSize));
                }
                g.setFont(poster.getSubFont());
                int subY = poster.getSubY() + g.getFontMetrics(poster.getSubFont()).getAscent();
                int high = getWordHeight(poster.getSubFont());
                for (int i = 0; i < poster.getSubHeading().length(); i++) {
                    g.drawString(String.valueOf(poster.getSubHeading().charAt(i)),poster.getSubX(),subY);
                    subY += high;
                }
            }else{
                g.setColor(poster.getSubColor());
                while(getWordHeight(poster.getSubFont()) > poster.getSubHeight()){
                    subSize--;
                    poster.setSubFont(FontUtil.getFont(8, subSize));

                }
                int curSize = subSize;
                if(getWordWidth(poster.getSubFont(),subHeading) > poster.getSubWidth()){
                    while(getWordWidth(poster.getSubFont(),subHeading) > poster.getSubWidth()){
                        curSize--;
                        poster.setSubFont(FontUtil.getFont(8, curSize));
                    }
                }
//                System.out.println(getWordWidth(poster.getSubFont(),subHeading));
//                System.out.println(poster.getSubWidth());
                if(curSize <= 20){
                    poster.setSubFont(FontUtil.getFont(8, subSize));
                    if(getWordWidth(poster.getSubFont(),subHeading) > poster.getSubWidth()){
                        while(getWordHeight(poster.getSubFont())*2 > poster.getSubHeight()){
                            subSize--;
                            poster.setSubFont(FontUtil.getFont(8, subSize));

                        }


                        String firstSubHeading = subHeading.substring(0,1);
                        String secondSubHeading = subHeading.substring(0,1);

                        //System.out.println(",,,,,,,,,,,,,,,,,,,,,,,,");
                        int curIndex = 0;
                        int preIndex = 0;
                        while(curIndex < subHeading.length()) {
                            preIndex = curIndex;
                            curIndex ++;
                            firstSubHeading = subHeading.substring(0, preIndex);
                            secondSubHeading = subHeading.substring(preIndex, subHeading.length());
                            firstSubHeadingWidth = getWordWidth(poster.getSubFont(), firstSubHeading);
                            secondSubHeadingWidth = getWordWidth(poster.getSubFont(), secondSubHeading);
                            //System.out.println(firstSubHeading.length());
                            //System.out.println(detail.length()/2);
                            //System.out.println(detail.length()/2);
                            if (firstSubHeadingWidth > poster.getSubWidth()) {
                                break;
                            }

                        }
                        g.setFont(poster.getSubFont());
                        g.drawString(firstSubHeading, poster.getSubX() + (poster.getSubWidth() - firstSubHeadingWidth)/2,poster.getSubY() + g.getFontMetrics(poster.getSubFont()).getAscent());
                        g.drawString(secondSubHeading, poster.getSubX() + (poster.getSubWidth() - secondSubHeadingWidth)/2 < poster.getSubX()? poster.getSubX() + (poster.getSubWidth() - firstSubHeadingWidth)/2 : poster.getSubX() + (poster.getSubWidth() - secondSubHeadingWidth)/2,poster.getSubY() + 2 * g.getFontMetrics(poster.getSubFont()).getAscent() + g.getFontMetrics(poster.getSubFont()).getDescent() );


                    }else{
                        g.setFont(poster.getSubFont());
                        g.drawString(poster.getSubHeading(), poster.getSubX() + (poster.getSubWidth() - getWordWidth(poster.getSubFont(),subHeading))/2, poster.getSubY() + g.getFontMetrics(poster.getSubFont()).getAscent());
                    }
                }else{
                    g.setFont(poster.getSubFont());
                    g.drawString(poster.getSubHeading(), poster.getSubX() + (poster.getSubWidth() - getWordWidth(poster.getSubFont(),subHeading))/2, poster.getSubY() + g.getFontMetrics(poster.getSubFont()).getAscent());
                }

            }
        }

        g.dispose();

        //生成图片地址
        int res = new Random().nextInt(10000);
        File resultImg = new File(FONT_ROUTE + "static\\ResultImgs\\"+res+".png");
        ImageIO.write(canvas, "png", resultImg);
        resList.add(resultImg.getName());
    }
    //得到该字体字符串的长度
    public static int getWordWidth(Font font, String content) {
        FontDesignMetrics metrics = FontDesignMetrics.getMetrics(font);
        int width = metrics.charsWidth(content.toCharArray(),0, content.length());
        /*for (int i = 0; i < content.length(); i++) {
            width += metrics.charWidth(content.charAt(i));
        }*/
        return width;
    }
    //得到该字体的高度
    public static int getWordHeight(Font font) {
        FontDesignMetrics metrics = FontDesignMetrics.getMetrics(font);
        int height = metrics.getHeight();//计算高度
        return height;
    }
    //取互补色||对比色
    public static int colorReverse(int curColor){
        //System.out.println("原始"+curColor);
        int bottom = (256/3+curColor)%256;
        int top = (256/2+curColor)%256;
        /*System.out.println("上界"+top);
        System.out.println("下界"+bottom);*/
        /**
         * 生成 [m,n] 的数字
         * int i1 = random.nextInt() * (n-m+1)+m;
         * */
        int res = new Random().nextInt(top-bottom+1)+bottom;
        //System.out.println("颜色"+res);
        return res;
    }
}
