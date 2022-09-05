/**
 * 
 */
package com.huawei.classroom.student.h03;
import java.util.Arrays;

import static java.lang.Math.*;
/**
 * @author Administrator
 * 作业  完成本类的方法
 */
public class Home03 {

	/**
	 * 判断一个数是否是水仙花数，
	 * 所谓 "水仙花数 "是指一个三位数，其各位数字立方和等于该数本身。例如：153是一个 "水仙花数 "，因为153=1的三次方＋5的三次方＋3的三次方。
	 * 难度系数2星
	 * @param i
	 * @return
	 */
	public static boolean isNarcissisticNum(int i) {
		// 完成本函数里面的代码
		if(i/100>=1&&i/100<10){
			int bai = i/100;
			int shi = i%100/10;
			int ge = i%10;
			if(bai*bai*bai + shi*shi*shi + ge*ge*ge == i)
				return true;
			else
				return false;
		}
		else
			return false;
	}
	
	/**
	 * 判断一个数是否是完全数，如果不清楚完全数，可以百度
	 * 一个数如果恰好等于它的因子之和，这个数就称为 "完全数 "。
	 * 难度系数2星
	 * @param i
	 * @return
	 */
	public static boolean Perfectnumber(int i) {
		// 完成本函数里面的代码
		int sum = 0;
		for(int j=1;j<i;j++){
			if(i % j == 0)
				sum += j;
		}
		if(sum==i)
			return true;
		else
			return false;
	}
	
	/**
	 * 计算n的阶乘(n>=0，且结果不会超出整数范围)
	 * @param n
	 * @return
	 */
	public static int  factorial(int n) {
		int result = 1;
		for(int i=n;i>0;i--){
			result *= i;
		}
		return result;
	}
	
	/**
	 * 将一个二进制的数变成10进制的数字 
	 * 例如将 1000 转换为 8，将10000 转换为16
	 * @return
	 */
	public static String binToDec(String bin) {
//		//如何把一个字符串转换为整数，供参考
//		int i=Integer.valueOf("1");
//		//如何把一个整数转换为字符串，供参考
//		String s=String.valueOf(i);
//		// 完成本函数里面的代码
		int n = Integer.valueOf(bin);
		int res = 0;
		for(int i=0; n!=0; i++){
			int a = n%10;
			res += a*pow(2,i);
			n /= 10;
		}
		String str = String.valueOf(res);
		return str;
	}
	
	/**
	 * 设二元一次方程 a*x*x+bx+c=0;
	 * 的系数分别为a,b,c
	 * 请将这个方程的两个实数根放在数组中返回,如果没有实数解则返回null
	 * 例如 getRoot(1,-2,1)返回 {1,1}
	 * 例如 getRoot(1,-2,2)返回 null
	 * 难度系数1星
	 * @return
	 */
	public static double[] getRoot(double a,double b,double c) {
		if(b*b-4*a*c<0)
			return null;
		else{
			double x1,x2;
			x1 = (-b+sqrt(b*b-4*a*c))/2*a;
			x2 = (-b-sqrt(b*b-4*a*c))/2*a;
			double[] result = {x1,x2};
			return result;
		}
	}

	/**
	 * 返回杨辉三角( Pascal  triangle,请百度 杨辉三角 或者 Pascal  triangle )第i行的系数，杨辉三角第一行定义为1
	 * 提示：从顶部的单个1开始，下面一行中的每个数字都是上面两个数字的和
	 * 例如getPascalTriangle(1)返回{1}，
	 * getPascalTriangle(2)返回{1,1}
	 * 测试的时候，系数肯定不会超过int的范围 
	 * 难度系数3星
	 * @param line
	 * @return
	 */
	public static int[] getPascalTriangle(int i) {
		int a[][] = new int[100][100];
		for(int j=1;j<=i;j++){
			a[j][j] = 1;
			a[j][1] = 1;
		}
		for(int j=2;j<=i;j++){
			for(int k=2;k<j;k++){
				a[j][k]=a[j-1][k]+a[j-1][k-1];
			}
		}
		int[] result = new int[i];
		for(int j=0;j<i;j++){
			result[j] = a[i][j+1];
		}
		return result;
	}
	
	/**
	 * 去掉一个字符串中所有的空格
	 * 难度系数1星
	 * 例如：zipSpace(" a b  c ")返回 "abc"
	 * @return
	 */
	public static String zipSpace(String str) {
		// 完成本函数里面的代码
		str = str.replace(" ","");
		return str;
	}
}
