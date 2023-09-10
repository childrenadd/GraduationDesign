package org.springboot.demo.upload.util;

import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;


public class FontUtil {

    /**
     * 根据字体类型获取字体
     *
     * @param type
     * @param size
     * @return
     */
    private static final String FONT_ROUTE = "E:\\boot-upload\\";//后端地址
    public static Font getFont(int type, float size) {
        // 字体路径 TODO
        String path = "";
        switch (type) {
            case 0:
                path = FONT_ROUTE + "src\\main\\resources\\draw\\font\\HongLei.ttf";
                break;
            case 1:
                path = FONT_ROUTE + "src\\main\\resources\\draw\\font\\LXGWWenKai-Regular.ttf";
                break;
            case 2:
                path = FONT_ROUTE + "src\\main\\resources\\draw\\font\\OPPOSans-H.ttf";
                break;
            case 3:
                path = FONT_ROUTE + "src\\main\\resources\\draw\\font\\HuaWenXingkai.ttf";
                break;
            case 4:
                path = FONT_ROUTE + "src\\main\\resources\\draw\\font\\OPPOSans-M.ttf";
                break;
            case 5:
                path = FONT_ROUTE + "src\\main\\resources\\draw\\font\\XinYe.otf";
                break;
            case 6:
                path = FONT_ROUTE + "src\\main\\resources\\draw\\font\\Slidexiaxing-Regular.ttf";
                break;
            case 7:
                path = FONT_ROUTE + "src\\main\\resources\\draw\\font\\slideyouran-Regular.ttf";
                break;
            case 8:
                path = FONT_ROUTE + "src\\main\\resources\\draw\\font\\SourceHanSansCN-Bold.otf";
                break;
            case 9:
                path = FONT_ROUTE + "src\\main\\resources\\draw\\font\\AaJianHao.ttf";
                break;
            case 10:
                path = FONT_ROUTE + "src\\main\\resources\\draw\\font\\YouZi.ttf";
                break;
            case 11:
                path = FONT_ROUTE + "src\\main\\resources\\draw\\font\\ALi.ttf";
                break;
            case 12:
                path = FONT_ROUTE + "src\\main\\resources\\draw\\font\\SourceHanSansCN-Medium.otf";
                break;
            case 13:
                path = FONT_ROUTE + "src\\main\\resources\\draw\\font\\KuaiLe.ttf";
                break;
            case 14:
                path = FONT_ROUTE + "src\\main\\resources\\draw\\font\\JinNian.ttf";
                break;
            case 15:
                path = FONT_ROUTE + "src\\main\\resources\\draw\\font\\Zhanku.otf";
                break;
            case 16:
                path = FONT_ROUTE + "src\\main\\resources\\draw\\font\\Pangmen.ttf";
                break;
            case 17:
                path = FONT_ROUTE + "src\\main\\resources\\draw\\font\\PingXian.ttf";
                break;
            case 18:
                path = FONT_ROUTE + "src\\main\\resources\\draw\\font\\YangRen.ttf";
                break;
            case 19:
                path = FONT_ROUTE + "src\\main\\resources\\draw\\font\\SanJi.ttf";
                break;
            case 20:
                path = FONT_ROUTE + "src\\main\\resources\\draw\\font\\PinRu.ttf";
                break;
            case 21:
                path = FONT_ROUTE + "src\\main\\resources\\draw\\font\\SourceHanSerifCN-SemiBold.otf";
                break;
            case 22:
                path = FONT_ROUTE + "src\\main\\resources\\draw\\font\\XiaolaiMonoSC-Regular.ttf";
                break;
            case 23:
                path = FONT_ROUTE + "src\\main\\resources\\draw\\font\\YSHaoShenTi.ttf";
                break;
            case 24:
                path = FONT_ROUTE + "src\\main\\resources\\draw\\font\\WenYiTi.ttf";
                break;
            case 25:
                path = FONT_ROUTE + "src\\main\\resources\\draw\\font\\OPPOSans-B.ttf";
                break;
            case 26:
                path = FONT_ROUTE + "src\\main\\resources\\draw\\font\\Xia.ttf";
                break;
            case 27:
                path = FONT_ROUTE + "src\\main\\resources\\draw\\font\\HuaWenXinWei.ttf";
                break;
            case 28:
                path = FONT_ROUTE + "src\\main\\resources\\draw\\font\\cc.OTF";
                break;
        }

        File file = new File(path);
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(file);


            Font sPfBoldFont = Font.createFont(Font.TRUETYPE_FONT, inputStream);

            sPfBoldFont = sPfBoldFont.deriveFont(Font.PLAIN,size);

            return sPfBoldFont;
        } catch (FontFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
