/**
 * @Description
 * @Author
 * @Date 2018年10月6日
 */
package com.guolin.algorithm;

import java.util.Scanner;

/**
 * @author guolin 2018-10-06 16:48:45
 * 浪潮 已知无序的三点，求多边形的面积
 */
public class LC2 {
    public static void main(String args[]){
    	Scanner input = new Scanner(System.in);
        float[] a = new float[2];//第一个点
        float[] b = new float[2];//第二个点
        float[] c = new float[2];//第三个点
        float[] v1 = new float[2];
        float[] v2 = new float[2];
        int n = input.nextInt();

        int i=0;
        while(i<n){
        	a[0] = input.nextFloat();
        	a[1] = input.nextFloat();
        	b[0] =input.nextFloat();
        	b[1] =input.nextFloat();
        	c[0] =input.nextFloat();
        	c[1] =input.nextFloat();
        	v1[0] = a[0]-b[0];
        	v1[1] = a[1]-b[1];
        	v2[0] = b[0] -c[0];
        	v2[1] = b[1] - c[1];
        	double x = a[0] -b[0];
        	double y = a[1] -b[1];
        	double ab = Math.sqrt(x*x+y*y);
        	
        	double cosA = (v1[0]*v2[0]+v1[1]*v2[1])/(Math.sqrt(v1[0]*v1[0]+v1[1]*v1[1])*Math.sqrt(v2[0]*v2[0]+v2[1]*v2[1]));
        	double angA = Math.acos(cosA);//内角
        	double angAO = Math.PI-angA;//外角
        	int edgeCount = (int) (Math.PI*2/angAO);
        	double h = Math.tan(angA/2)*ab/2;//三角形的高
        	double triS = ab*h/2;
        	double s = triS * edgeCount;
        	System.out.println(String .format("%.6f",s));
        	i++;
        }
    }
}
