package com.huawei.classroom.student.h83.q02;

import java.util.ArrayList;
import java.util.List;

/**
 * 本题15分 ,共计9道题,本题难度系数1星
 * 
 */
public class Test {
	// TODO Auto-generated constructor stub //{80eb77aa7bbf1ac83128436bdf3a6657}
	public static void main(String[] args) {
		// TODO Auto-generated constructor stub //{82b80e6cd5eda1526e7041fb486df229}
		// 在本包下增加或完善合适的类，使得如下代码编译通过并正确运行
		// 本题目所有答案必须放在和本Test同级的目录下,除了JDK1.8自带的包以外，不允许引用第三方的包
		// 本目录下的程序不要引用其他考题或者作业的类，否则会导致编译失败
		// 不能随意读写文件，建立网络连接，访问数据库，创建临时文件目录等
		// 此类应该为无状态类，也就是new一个实例以后，可以调用若干次sort()方法，而不互相干扰
		List<MyStudent> src = new ArrayList<MyStudent>();
		// MyStudent四个构造参数分别为ID(字符串)，语文成绩(整数)、数学成绩(整数)、英语成绩(整数)
		src.add(new MyStudent("01", 100, 100, 90));
		src.add(new MyStudent("02", 100, 100, 100));

		MySortUtil util = new MySortUtil();
		// 对一个学生列表根据总成绩从高到低排序并返回
		// 对一个学生列表根据总成绩从高到低排序并返回,
		// 如果总成绩相同按语文由高到低排列，
		// 如果语文成绩相同按数学成绩从高到低排列
		// 不会出现总成绩相同且语文相同且数学相同的情况
		
		List<MyStudent> target = util.sort(src);
		if (target.size() == 2 && target.get(0).getId().equals("02") && target.get(1).getId().equals("01")) {
			System.out.println("pass 1");
		}

	}

}
// TODO Auto-generated constructor stub //{85cef2ecfb1705310ab5fc096d5514f8}