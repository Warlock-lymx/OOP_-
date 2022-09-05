package com.huawei.classroom.student.h83.q01;

/**
 * 本题10分 ,共计9道题,本题难度系数2星
 *
 */
public class Test {
	// TODO Auto-generated constructor stub //{79da95d36b82231501b9984e61e4e440}
	public static void main(String[] args) {
		// TODO Auto-generated constructor stub //{7a9da278857f396ae373559e70a4e4d5}
		// 在本包下增加或完善合适的类，使得如下代码编译通过并正确运行
		// 本题目所有答案必须放在和本Test同级的目录下,除了JDK1.8自带的包以外，不允许引用第三方的包
		// 本目录下的程序不要引用其他考题或者作业的类，否则会导致编译失败
		// 不能随意读写文件，建立网络连接，访问数据库，创建临时文件目录等
		// 此类应该为无状态类，也就是new一个实例以后，可以调用若干次encrypt decrypt方法，而不互相干扰

		// 完成一个简单的字符串加密、解密类,加密 解密规则见MyEncryptUtil说明
		MyEncryptUtil util = new MyEncryptUtil();
		String target = "ifmmpx";

		// 字符串加密
		String test = util.encrypt("hellow");
		if (target.equals(test)) {
			System.out.println("pass 1");
		}
		// 字符串解密
		if ("hellow".equals(util.decrypt("ifmmpx"))) {
			System.out.println("pass 2");
		}
		System.out.println(util.encrypt("abcdefghijklmnopqrstuvwxyz"));
		System.out.println(util.encrypt("abcdefghijklmnopqrstuvwxyz!@"));
	}

}
// TODO Auto-generated constructor stub //{7b5a4e65b9c80b8cc388c841b0b3709d}