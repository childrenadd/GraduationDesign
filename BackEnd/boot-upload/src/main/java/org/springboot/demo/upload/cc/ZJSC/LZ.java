package org.springboot.demo.upload.cc.ZJSC;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.security.SecureRandom;

/**
 * @author wxy
 * @date 2023/2/10 16:20
 */
public class LZ extends JPanel
{
    public static void main(String[] args)
    {
        JFrame application = new JFrame("乱针绣针迹");
        application.getContentPane().add(new LZ());
        // set the frame to exit when it is closed
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //application.add(panel,BorderLayout.CENTER); // add the panel to the frame
        //application.add(statusBar,BorderLayout.SOUTH); // add the statusBar to the frame
        application.setSize(1000, 1000); // set the size of the frame
        application.setVisible(true); // make the frame visible
        savePic(application);
    }


    public void paint(Graphics g)
    {
        Graphics2D g2d = (Graphics2D) g;
        super.paint(g);
        double width = getWidth(); // total width
        double height = getHeight(); // total height
        int rRed=0;
        int rGreen=0;
        int rBlue=0;

        final SecureRandom rn = new SecureRandom();
        //30
        double startX = 20;
        double startY = 50;
        double endX   = startX + 40 * Math.cos(Math.toRadians(75));
        double endY   = startY - 40 * Math.sin(Math.toRadians(75));
        g2d.setColor(new Color(0,0,0));	//设置线段颜色
        g2d.setStroke(new BasicStroke(3));  //设置线段的粗细
        double spanx = 40 * Math.cos(Math.toRadians(75));
        double spany = 40 * Math.sin(Math.toRadians(75));
        /*//画8个同心圆，每个同心圆相距10个像素
        for (int i = 100; i > 0;i--){
            for(int j = 100;j > 0;j--){
                g2d.draw(new Line2D.Double(startX, startY, endX,  endY));	//绘制线段
                g2d.draw(new Line2D.Double(endX, startY, startX,  endY));	//绘制线段
                startX += spanx;
                endX += spanx;
            }
            startX = 20;
            startY += spany;
            endX   = startX + 40 * Math.cos(Math.toRadians(75));
            endY   = startY - 40 * Math.sin(Math.toRadians(75));
        }*/
     /*   //60
        startX = 0;
        startY = 30;
        endX   = startX + 40 * Math.cos(Math.toRadians(60));
        endY   = startY - 40 * Math.sin(Math.toRadians(60));
        spanx = 40 * Math.cos(Math.toRadians(60)) + 30;
        spany = 40 * Math.sin(Math.toRadians(60)) + 20;
        for (int i = 100; i > 0;i--){
            for(int j = 100;j > 0;j--){
                g2d.draw(new Line2D.Double(startX, startY, endX,  endY));	//绘制线段
                g2d.draw(new Line2D.Double(endX, startY, startX,  endY));	//绘制线段
                startX += spanx;
                endX += spanx;
            }
            startX = 0;
            startY += spany;
            endX   = startX + 40 * Math.cos(Math.toRadians(60));
            endY   = startY - 40 * Math.sin(Math.toRadians(60));
        }*/
        /*//90
        startX = 10;
        startY = 30;
        endX   = startX + 40 * Math.cos(Math.toRadians(45));
        endY   = startY - 40 * Math.sin(Math.toRadians(45));
        spanx = 40 * Math.cos(Math.toRadians(45));
        spany = 40 * Math.sin(Math.toRadians(45));
        for (int i = 100; i > 0;i--){
            for(int j = 100;j > 0;j--){
                g2d.draw(new Line2D.Double(startX, startY, endX,  endY));	//绘制线段
                g2d.draw(new Line2D.Double(endX, startY, startX,  endY));	//绘制线段
                startX += spanx;
                endX += spanx;
            }
            startX = 10;
            startY += spany;
            endX   = startX + 40 * Math.cos(Math.toRadians(45));
            endY   = startY - 40 * Math.sin(Math.toRadians(45));
        }*/
        //120
        startX = 0;
        startY = 0;
        endX   = startX + 40 * Math.cos(Math.toRadians(30));
        endY   = startY - 40 * Math.sin(Math.toRadians(30));
        spanx = 40 * Math.cos(Math.toRadians(30));
        spany = 40 * Math.sin(Math.toRadians(30));
        for (int i = 1000; i > 0;i--){
            for(int j = 1000;j > 0;j--){
                g2d.draw(new Line2D.Double(startX, startY, endX,  endY));	//绘制线段
                g2d.draw(new Line2D.Double(endX, startY, startX,  endY));	//绘制线段
                startX += spanx;
                endX += spanx;
            }
            startX = 0;
            startY += spany;
            endX   = startX + 40 * Math.cos(Math.toRadians(30));
            endY   = startY - 40 * Math.sin(Math.toRadians(30));
        }
        /*//150
        startX = 0;
        startY = 10;
        endX   = startX + 40 * Math.cos(Math.toRadians(15));
        endY   = startY - 40 * Math.sin(Math.toRadians(15));
        spanx = 40 * Math.cos(Math.toRadians(15));
        spany = 40 * Math.sin(Math.toRadians(15));
        for (int i = 100; i > 0;i--){
            for(int j = 100;j > 0;j--){
                g2d.draw(new Line2D.Double(startX, startY, endX,  endY));	//绘制线段
                g2d.draw(new Line2D.Double(endX, startY, startX,  endY));	//绘制线段
                startX += spanx;
                endX += spanx;
            }
            startX = 0;
            startY += spany;
            endX   = startX + 40 * Math.cos(Math.toRadians(15));
            endY   = startY - 40 * Math.sin(Math.toRadians(15));
        }*/
    }
    public static void savePic(JFrame jf){
        //得到窗口内容面板
        Container content=jf.getContentPane();
        //创建缓冲图片对象
        BufferedImage img=new BufferedImage(
                jf.getWidth(),jf.getHeight(),BufferedImage.TYPE_INT_ARGB);
        //得到图形对象
        Graphics2D g2d = img.createGraphics();
        //将窗口内容面板输出到图形对象中
        //content.printAll(g2d);
        // 把面板的内容画到画布中
        jf.paint(g2d);
        try {
            // 把缓存图片保存到本地文件
            ImageIO.write(img, "png", new File("luan.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        //保存为图片
        /*File f=new File("saveScreen.jpg");
        try {
            ImageIO.write(img, "jpg", f);
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        //释放图形对象
        g2d.dispose();
    }

}

