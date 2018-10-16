/**
 * @Description
 * @Author
 * @Date 2018年9月18日
 */
package com.guolin.graphics;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * @author guolin 2018-09-18 22:21:21
 *
 */
public class DrawSig {
	/**
     * 创建一个BufferedImage图片缓冲区对象并指定它宽高和类型 这样相当于创建一个画板，然后可以在上面画画
     */
    static BufferedImage bi = new BufferedImage(200, 150, BufferedImage.TYPE_INT_BGR);

    /**
     * 要生成图片的类型,可以是JPG GIF JPEG PNG等...
     */
    final static String picType = "png";

    /**
     * 成生成图片的保存路径和图片名称
     */
    final static File file = new File("D://drawDig." + picType);
    
    final static int cx = 100;
    final static int cy = 75;
    final static int a = 80;
    final static int b = 55;
    /**
     * 通过指定参数写一个图片
     * 
     * @param bi
     * @param picType
     * @param file
     * @return boolean 如果失败返回一个布尔值
     */
    public static boolean writeImage(BufferedImage bi, String picType, File file) {
        // 拿到画笔
        Graphics g = bi.getGraphics();
        Graphics2D g2 = (Graphics2D)g; //这一句   
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        // 画一个图形系统默认是白色
        g2.fillRect(0, 0, 200, 150);        
        // 设置画笔颜色
        g2.setColor(new Color(255, 0, 0));
        g2.drawOval(0, 0, 200, 150);
        // 画内圈和十字定位
        g2.drawOval(20, 20, 160, 110);
        //g2.drawLine(0, 75, 200, 75);
        //g2.drawLine(100, 0, 100, 150);
        
        // 设置画笔画出的字体风格
        Font font = new Font("宋体", Font.PLAIN, 20);
        g2.setFont(font);
        
        //g2.drawRect(20, 65, 20, 20);//左上角
        //g2.drawString("我", 10, 85);//左下角
        AffineTransform trans = new AffineTransform();
        trans.rotate(Math.toRadians(-90),20,75);
        //trans.translate(20, 85);
        //Font transedFont = font.deriveFont(trans);
        
        g2.setTransform(trans);
        // 写一个字符串
        g2.drawString("河", 10, 75);
                
        trans.setToIdentity();
        g2.setTransform(trans);
        int []p=getP(-168);//确定下个字的中点
        //g2.drawLine(cx, cy, p[0], p[1]);
        trans.rotate(getRotate(p),p[0],p[1]);
        g2.setTransform(trans);
        g2.drawString("南", p[0]-10, p[1]);
        
        trans.setToIdentity();
        g2.setTransform(trans);
        p=getP(-155);//确定下个字的中点
        //g2.drawLine(cx, cy, p[0], p[1]);
        trans.rotate(getRotate(p),p[0],p[1]);
        g2.setTransform(trans);
        g2.drawString("绿", p[0]-10, p[1]);
        
        trans.setToIdentity();
        g2.setTransform(trans);
        p=getP(-141);//确定下个字的中点
        //g2.drawLine(cx, cy, p[0], p[1]);
        trans.rotate(getRotate(p),p[0],p[1]);
        g2.setTransform(trans);
        g2.drawString("野", p[0]-10, p[1]);
        
        trans.setToIdentity();
        g2.setTransform(trans);
        p=getP(-45);//确定下个字的中点
        //g2.drawLine(cx, cy, p[0], p[1]);
        trans.rotate(getRotate(p),p[0],p[1]);
        g2.setTransform(trans);
        g2.drawString("科", p[0]-10, p[1]);
        
        trans.setToIdentity();
        g2.setTransform(trans);
        p=getP(45);//确定下个字的中点
        //g2.drawLine(cx, cy, p[0], p[1]);
        trans.rotate(getRotate(p)-Math.PI,p[0],p[1]);
        g2.setTransform(trans);
        g2.drawString("技", p[0]-10, p[1]);
        
        trans.setToIdentity();
        g2.setTransform(trans);
        p=getP(125);//确定下个字的中点
        //g2.drawLine(cx, cy, p[0], p[1]);
        trans.rotate(Math.PI+getRotate(p),p[0],p[1]);//在下方 则多旋转 180°
        g2.setTransform(trans);
        g2.drawString("有", p[0]-10, p[1]);
        
        trans.setToIdentity();
        g2.setTransform(trans);
        p=getP(145);//确定下个字的中点
        //g2.drawLine(cx, cy, p[0], p[1]);
        trans.rotate(Math.PI+getRotate(p),p[0],p[1]);//在下方 则多旋转 180°
        trans.scale(0.8, 1);//文字变窄
        g2.setTransform(trans);
        g2.drawString("限", p[0]-10, p[1]);
        
        // 释放画笔
        g2.dispose();               
        // 将画好的图片通过流形式写到硬盘上
        boolean val = false;
        try {
            val = ImageIO.write(bi, picType, file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return val;
    }
    public static void main(String[] args) {
        writeImage(bi, picType, file);
        System.out.println("绘制成功！");
    }
    
    /**
     * https://blog.csdn.net/stereohomology/article/details/52725770
     * 角度从x轴正向，顺时针转
     * @author guolin
     * @param ang 角度值
     * @return
     */
    public static int[] getP(int ang) {
    	int[] p = new int[2];
    	double sin = Math.sin(Math.toRadians(ang));
    	double cos = Math.cos(Math.toRadians(ang));
    	double denominator = Math.sqrt(a*a*sin*sin+b*b*cos*cos);//分母
    	p[0] = (int) ((a*b*cos)/denominator)+cx;//平移到绘图坐标系
    	p[1] = (int) ((a*b*sin)/denominator)+cy;
    	return p;
    }
    
    /**
     * https://www.zybang.com/question/799c4adc3261b5876c763b8a83564b23.html
     * 根据椭圆上的点 确定旋转角度
     * @author guolin
     * @param p 椭圆上的点
     * @return 返回弧度
     */
    public static double getRotate(int[] p) {
    	//变回0,0位中心
    	int x = p[0]-cx;
    	int y = p[1]-cy;
    	double k = -b*b*x*1.0/(a*a*y);//求斜率
    	double sita = Math.atan(k);
    	return sita;    	
    }
}
