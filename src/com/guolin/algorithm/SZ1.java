/**
 * @Description
 * @Author
 * @Date 2018年10月11日
 */
package com.guolin.algorithm;

/**
 * 神州1 数组排序  每次选最大的放到最后
 * @author guolin 2018-10-11 10:19:17
 *
 */
public class SZ1 {
	
	public static void main(String[] args) {
		
		int[] tmp = new int[100];
		int i=0;
		int count=0;//移动次数
		for(;i<args.length;i++) {
			tmp[i] = Integer.parseInt(args[i]);
		}		
		//每次挑选最大的数
		int maxIndex =0;
		while(maxIndex!=args.length-1) {
			int maxNum = tmp[0];
			for(i=1;i<args.length;i++) {
				if(tmp[i]>maxNum) {
					maxIndex=i;
					maxNum = tmp[i];
				}
			}
			for(i=maxIndex;i<args.length-1;i++) {
				tmp[i]=tmp[i+1];
			}
			count++;
			tmp[args.length-count]=maxNum;
		}
		System.out.println(count);
	}
}
