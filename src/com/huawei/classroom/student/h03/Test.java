package com.huawei.classroom.student.h03;

import java.math.BigInteger;
import java.util.Arrays;

public class Test {

	public Test() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//isNarcissisticNum 测试用例
		if(!Home03.isNarcissisticNum(3)) {
			System.out.println("isNarcissisticNum 测试用1通过");
		}
		if(Home03.isNarcissisticNum(153)) {
			System.out.println("isNarcissisticNum测试用2通过");
		}

		//Perfectnumber 测试用例
		if(Home03.Perfectnumber(6)) {
			System.out.println("Perfectnumber 测试用1通过");
		}

		//factorial 测试用例
		if(Home03.factorial(3)==6) {
			System.out.println("factorial 测试用1通过");
		}
		if(Home03.binToDec("10").equals("2") ) {
			System.out.println("binToDec 测试用1通过");
		}

		//求解二元一次方程的测试用例 自己想怎么写，方程肯定有两个不同的解，也就是deta>0,解没有顺序要求，那个放在前面都都行
		double result1[] = Home03.getRoot(1,-2,-3);
		if((result1[0]==-1&&result1[1]==3)||(result1[0]==3&&result1[1]==-1))
			System.out.println("getRoot 测试用1通过");
		double result2[] = Home03.getRoot(1,-2,2);
		if(result2==null)
			System.out.println("getRoot 测试用2通过");

		//getPascalTriangle测x试用例自己想想怎么写
		int result3[] = Home03.getPascalTriangle(4);
		if(result3[0]==1&&result3[1]==3&&result3[2]==3&&result3[3]==1)
			System.out.println("getPascalTriangle 测试用1通过");
		int result4[] = Home03.getPascalTriangle(5);
		if(result4[0]==1&&result4[1]==4&&result4[2]==6&&result4[3]==4&&result4[4]==1)
			System.out.println("getPascalTriangle 测试用2通过");
//		int result5[] = Home03.getPascalTriangle(4);
//		String a = Arrays.toString(result5);
//		System.out.println(a);


		//zipSpace 测试用例
		if(Home03.zipSpace("1 2").equals("12") ) {
			System.out.println("zipSpace 测试用1通过");
		}
	}


}
