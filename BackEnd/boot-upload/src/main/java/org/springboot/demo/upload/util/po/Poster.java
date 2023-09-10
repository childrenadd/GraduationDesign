package org.springboot.demo.upload.util.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.awt.*;
import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Poster implements Serializable {
    private int width;//海报的宽（像素为单位）
    private int height;//海报的高

    //背景
    private String background;


    //主标题
    private String mainHeading;
    private Font mainFont;
    private Color mainColor;
    private int mainX;
    private int mainY;
    private int mainHeight;
    private int mainWidth;

    //副标题
    private String subHeading;
    private Font subFont;
    private Color subColor;
    private int subX;
    private int subY;
    private int subHeight;
    private int subWidth;

    //主元素
    private String primaryElement;
    private int primaryX;
    private int primaryY;
    private int primaryWidth;
    private int primaryHeight;

    //主元素(网页URL)
    private String qrCodeUrl;
    private int qrCodeX;
    private int qrCodeY;
    private int qrCodeWidth;
    private int qrCodeHeight;

    //辅助元素
    private String secondaryElement;
    private int secondaryX;
    private int secondaryY;
    private int secondaryWidth;
    private int secondaryHeight;

    //详细文字
    private String detail;
    private String firstDetail;
    private String secondDetail;
    private Font detailFont;
    private Color detailColor;
    private int firstDetailX;
    private int secondDetailX;
    private int firstDetailY;
    private int secondDetailY;
    private int firstDetailWidth;
    private int secondDetailWidth;
    private int detailX;
    private int detailY;
    private int detailHeight;
    private int detailWidth;

    //内容
    private List<String> mainContent;
    private Font mainContentFont;
    private Color mainContentColor;
    private int mainContentX;
    private int mainContentY;
    private int mainContentHeight;
    private int mainContentWidth;
    
    //LOGO
    private String logoUrl;
    private int logoX;
    private int logoY;
    private int logoWidth;
    private int logoHeight;

    //二维码
    private String  barcode;
    private int  barcodeX;
    private int  barcodeY;
    private int  barcodeWidth;
    private int  barcodeHeight;

    //装饰元素1
    private int  firstDecorate1X;
    private int  firstDecorate1Y;
    private int  firstDecorate1Width;
    private int  firstDecorate1Height;
    private int  secondDecorate1X;
    private int  secondDecorate1Y;
    private int  secondDecorate1Width;
    private int  secondDecorate1Height;

    //装饰元素2
    private int  firstDecorate2X;
    private int  firstDecorate2Y;
    private int  firstDecorate2Width;
    private int  firstDecorate2Height;
    private int  secondDecorate2X;
    private int  secondDecorate2Y;
    private int  secondDecorate2Width;
    private int  secondDecorate2Height;
}


