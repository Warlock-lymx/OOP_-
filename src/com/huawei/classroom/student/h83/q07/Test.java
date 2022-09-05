package com.huawei.classroom.student.h83.q07;

/**
 * 本题15分 ,共计9道题,本题难度系数2星
 *
 */
public class Test {
	// TODO Auto-generated constructor stub //{c52a64dd5e9703580abae806a8f9d07d}
	public static void main(String[] args) {
		//TODO Auto-generated constructor stub //{c73cfb984aa594e808c8c696968bd081}
		// 在本包下增加或完善合适的类，使得如下代码编译通过并正确运行
		// 本题目所有答案必须放在和本Test同级的目录下,除了JDK1.8自带的包以外，不允许引用第三方的包
		// 本目录下的程序不要引用其他考题或者作业的类，否则会导致编译失败
		// 不能随意读写文件，建立网络连接，访问数据库，创建临时文件目录等
		// 此类应该为无状态类，也就是new一个实例以后，可以调用若干次containsAllLetters()方法，而不互相干扰

		// 判断str中是否包含了所有的英文字母（不区分小写)
		MyStrUtil util = new MyStrUtil();
		if (util.containsAllLetters("abcdefghijklmnopqrstuvwxyz天津大学abc")) {
			System.out.println("pass 1");
		}
		// 没有包含 "z"
		if (!util.containsAllLetters("abcdefghijklmnopqrstuvwxy ")) {
			System.out.println("pass 2");
		}
		// "Z"虽然是大写的，但是也算包含了
		if (util.containsAllLetters("abcdefghijklmnopqrstuvwxyZ")) {
			System.out.println("pass 3");
		}
	}

}
//TODO Auto-generated constructor stub //{c783a485970ad9b0c2ac079d89eec58d}