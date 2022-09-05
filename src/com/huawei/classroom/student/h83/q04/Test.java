package com.huawei.classroom.student.h83.q04;

import java.util.ArrayList;
import java.util.List;


/**
 * 本题15分 ,共计9道题,本题难度系数1星
 *
 */
//TODO Auto-generated constructor stub //{906a9d1e3af50a92fc793a0ea8b7c11f}
public class Test {

	public static void main(String[] args) {
		//TODO Auto-generated constructor stub //{94f36337dcfdae6538d0eb7a26d908f8}
		// 在本包下增加或完善合适的类，使得如下代码编译通过并正确运行
		// 本题目所有答案必须放在和本Test同级的目录下,除了JDK1.8自带的包以外，不允许引用第三方的包
		// 本目录下的程序不要引用其他考题或者作业的类，否则会导致编译失败
		// 不能随意读写文件，建立网络连接，访问数据库，创建临时文件目录等
		// 此类应该为无状态类，也就是new一个ListUtil() 实例以后，可以调用若干次getSum()方法，而不互相干扰
		//完成一个工具类，能够对整数的List中所有元素求加和并返回
		ListUtil util=new ListUtil();
		List list=new ArrayList();
		list.add(10);
		list.add(20);
		if(Math.abs(util.getSum(list)-30)<0.01){
			System.out.println("pass 1");
			System.out.println(Integer.MAX_VALUE +Integer.MAX_VALUE -4.294967294E9);
		}
		// TODO Auto-generated constructor stub //{990a5277fe4ea87da42dda53f6433a6f}
	}

}
//TODO Auto-generated constructor stub //{9997f513ea71b2bc59f79e50eebdc01b}