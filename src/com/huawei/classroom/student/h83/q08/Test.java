//package com.huawei.classroom.student.h83.q08;
//
//import java.util.HashSet;
//import java.util.Set;
//
///**
// * 本题10分 ,共计9道题,本题难度系数3星
// *
// */
//public class Test {
//	// TODO Auto-generated constructor stub //{d20090482ff7e5771ebadc578d50c28d}
//	public static void main(String[] args) {
//		// TODO Auto-generated constructor stub //{dd7588ce9f5298862045ae9e365bb01d}
//		// 在本包下增加或完善合适的类，使得如下代码编译通过并正确运行
//		// 本题目所有答案必须放在和本Test同级的目录下,除了JDK1.8自带的包以外，不允许引用第三方的包
//		// 本目录下的程序不要引用其他考题或者作业的类，否则会导致编译失败
//		// 不能随意读写文件，建立网络连接，访问数据库，创建临时文件目录等
//		// 此类应该为无状态类，也就是new一个实例以后，可以调用若干次getAllReachablePoints方法，而不互相干扰
//		// **注意此题目除了写错正确的getAllReachablePoints方法外，还要合理的实现Point类，使得本类中的判断方法可以正确通过
//
//		// 湖里有很多小岛 allPoints，每个岛(Point)坐标用 整数X，Y
//		Set<Point> all = new HashSet<Point>();
//		all.add(new Point(1, 1));
//		all.add(new Point(2, 2));
//		all.add(new Point(3, 3));
//		all.add(new Point(5, 5));
//		all.add(new Point(9, 9));
//		MyPointUtil util = new MyPointUtil();
//
//		// 一只猫现在站在小岛src上，这个猫每次最远跳跃距离是maxJumpLen
//		double maxJumpLen = 2.5;
//		Point src=new Point(1,1);
//		// 判断猫从src触发，在all中所有可以到达的岛屿
//		Set<Point> reachPoint = util.getAllReachablePoints(src, all, maxJumpLen);
//
//		Set<Point> target = new HashSet<Point>();
//		target.add(new Point(1, 1));
//		target.add(new Point(2, 2));
//		target.add(new Point(3, 3));
//		//注意此题目除了写出正确的getAllReachablePoints方法外，还要合理的实现Point类，使得本类中的判断方法可以正确通过
//		if (reachPoint.equals(target)) {
//
//			System.out.println("pass 1");
//		}
//		// TODO Auto-generated constructor stub //{e1d29f063c09bcaaaf267aff1fad0d43}
//	}
//}
//// TODO Auto-generated constructor stub //{e203e34500331c3b929a185b59405a51}