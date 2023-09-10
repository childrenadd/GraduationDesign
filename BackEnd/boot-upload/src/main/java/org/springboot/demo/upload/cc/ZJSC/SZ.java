package org.springboot.demo.upload.cc.ZJSC;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class SZ extends JPanel {
    public static void main(String[] args) {
//画布

        JFrame frame = new JFrame("DrawLine");
        frame.getContentPane().add(new SZ());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 1000);
        frame.setVisible(true);
        savePic(frame);

    }
    /*//十字针迹01
    protected void paintComponent(Graphics g) {
        BasicStroke stokeLine = new BasicStroke(1);
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(stokeLine);
        super.paintComponent(g);
        for (int i = 0; i <= 1000; ) {
            g.drawLine(0, i, i, 0);
            i += 5;
        }
        for (int i = 0; i <= 1000; ) {
            g.drawLine(i, 1000, 1000, i);
            i += 5;
        }
        int k = 5;
        for (int i = 995; i >= 0; ) {
            g.drawLine(0, i, k, 1000);
            i -= 5;
            k += 5;
        }
        k = 1000;
        for (int i = 0; i <= 1000; ) {
            g.drawLine(i, 0, 1000, k);
            i += 5;
            k -= 5;
        }
    }*/
    /*//十字针迹02
    protected void paintComponent(Graphics g) {
        BasicStroke stokeLine = new BasicStroke(1);
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(stokeLine);
        super.paintComponent(g);
        for(int i = 0;i < 1200;i++){
            for(int j = 0;j < 1200;j++){
                g.drawRect(i,j,1,1);//画线框44
                j+=2;
            }
            i+=2;

        }
    }*/
    //乱针绣针迹
    protected void paintComponent(Graphics g) {
        BasicStroke stokeLine = new BasicStroke(1);
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(stokeLine);
        super.paintComponent(g);
        for(int i = 0;i <= 1000;){
            g.drawLine(0, i, i, 0);
            i+=5;
        }
        for(int i = 0;i <= 1000;){
            g.drawLine(i, 1000, 1000, i);
            i+=5;
        }
        int k = 5;
        for(int i = 995;i >= 0;){
            g.drawLine(0, i, k, 1000);
            i-=5;
            k+=5;
        }
        k = 1000;
        for(int i = 0;i <= 1000;){
            g.drawLine(i, 0, 1000, k);
            i+=5;
            k-=5;
        }

        g2.setStroke(new BasicStroke(1));
        //120
        int startX = 0;
        int startY = 0;
        int endX   = (int)(startX + 40 * Math.cos(Math.toRadians(30)));
        int endY   = (int)(startY - 40 * Math.sin(Math.toRadians(30)));
        int spanx = (int)(40 * Math.cos(Math.toRadians(30)));
        int spany = (int)(40 * Math.sin(Math.toRadians(30)));
        System.out.println("120x"+spanx);
        System.out.println("120y"+spany);
        for (int i = 1000; i > 0;i--){
            for(int j = 1000;j > 0;j--){
                g.drawLine(startX, startY, endX,  endY);	//绘制线段
                g.drawLine(endX, startY, startX,  endY);	//绘制线段
                startX += spanx;
                endX += spanx;
            }
            startX = 0;
            startY += spany;
            endX   = (int)(startX + 40 * Math.cos(Math.toRadians(30)));
            endY   = (int)(startY - 40 * Math.sin(Math.toRadians(30)));
        }
        //60
        startX = 0;
        startY = 0;
        endX   = (int)(startX + 40 * Math.cos(Math.toRadians(60)));
        endY   = (int)(startY - 40 * Math.sin(Math.toRadians(60)));
        spanx = (int)(40 * Math.cos(Math.toRadians(60)));
        spany = (int)(40 * Math.sin(Math.toRadians(60)));
        System.out.println("60x"+spanx);
        System.out.println("60y"+spany);
        for (int i = 1000; i > 0;i--){
            for(int j = 1000;j > 0;j--){
                g.drawLine(startX, startY, endX,  endY);	//绘制线段
                g.drawLine(endX, startY, startX,  endY);	//绘制线段
                startX += spanx;
                endX += spanx;
            }
            startX = 0;
            startY += spany;
            endX   = (int)(startX + 40 * Math.cos(Math.toRadians(60)));
            endY   = (int)(startY - 40 * Math.sin(Math.toRadians(60)));
        }

      /*  for(int i = 0;i < 2000;i++){
            g.drawLine(100, i, i, i);
            i+=5;
        }*/
        //g.drawLine(0, 500, 500, 0);
    }
 /*   //缎面针迹
    protected void paintComponent(Graphics g) {
        BasicStroke stokeLine = new BasicStroke(2);
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(stokeLine);
        super.paintComponent(g);

        for(int i = 0;i < 2000;i++){
            g.drawLine(0, i, i, 0);
            i+=3;
        }
        //g.drawLine(0, 500, 500, 0);
    }*/
    /*//长短针针迹
    protected void paintComponent(Graphics g) {
        BasicStroke stokeLine = new BasicStroke(1);
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(stokeLine);
        super.paintComponent(g);
        boolean flag = true;
        int y = 0,k = 0;

        for(int i = 0;i < 500;i++){
            if(!flag){
                g.drawOval(0, y, 10, 3);
                k += 10;
            }
            for(int x0 = k;x0 < 1000;x0 += 20){
                g.drawOval(x0, y, 20, 3);
            }
            flag = !flag;
            y += 5;
            k = 0;
        }



       //for(int i = 0;i < 2000;i++){
       //     g.drawLine(0, i, i, 0);
       //     i+=5;
       // }
        //g.drawLine(0, 500, 500, 0);
    }*/

/*    public static void drawSelPolygon(Graphics2D g2, Color frameColor, int[] x, int[] y,
                                      int numPoints) {
        g2.setColor(frameColor);
        //初始化多边形
        Polygon p = new Polygon(x, y, numPoints);
        //取得多边形外接矩形
        Rectangle r = p.getBounds();
        //裁切
        g2.setClip(p);
        //绘制填充线
        for (int j = r.y; j-r.width < r.y + r.height; j = j + 6) {
            //<--NG
            Line2D line = new Line2D.Float(r.x, j, (r.x + r.width), j-r.width);
            g2.draw(line);
        }
        //绘制多边形
        g2.drawPolygon(p);
    }*/
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
            ImageIO.write(img, "png", new File("panel.png"));
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