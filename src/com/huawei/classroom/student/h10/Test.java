package com.huawei.classroom.student.h10;

/**
 * 
 * 
 * 
 * 
 * 不要引用jdk1.8以外第三方的包
 * 
 * @author cjy
 *
 */
public class Test {

	public Test() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {

		Home10 home10 = new Home10();
		// 完成 Home10的orderChar方法,开业在本目录下适当的增加类
		if (home10.orderChar("天津大学软件学院").equals("学天津大软件院")) {
			System.out.println("test case 1 ok");
		}
	 
	}
}
