package com.huawei.classroom.student.h83.q03;

/**
 * 本题15分 ,共计9道题,本题难度系数1星
 *
 */
public class Test {
	// TODO Auto-generated constructor stub //{866f7e5abe5c6f3339c6cee2c4969c28}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 在本包下增加或完善合适的类，使得如下代码编译通过并正确运行
		// 本题目所有答案必须放在和本Test同级的目录下,除了JDK1.8自带的包以外，不允许引用第三方的包
		// 本目录下的程序不要引用其他考题或者作业的类，否则会导致编译失败
		// 不能随意读写文件，建立网络连接，访问数据库，创建临时文件目录等

		// 实现一个“圆”类，可以设置半径，可以根据半径计算面积
		Circle circle = new Circle();
		circle.setR(1);
		if (Math.abs(circle.getArea() - 3.14) < 0.1) {
			System.out.println("case 1 pass!");
		}
		circle.setR(2);
		if (Math.abs(circle.getArea() - 12.56) < 0.1) {
			System.out.println("case 2 pass!");
		}
	}
	// TODO Auto-generated constructor stub //{87b1bb0a660d23a4cc3552028788ffd2}
}
// TODO Auto-generated constructor stub //{899780c4f05dbb5beff2a3f9878615c3}