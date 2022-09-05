//package com.huawei.classroom.student.h83.q06;
//
///**
// * 本题7分 ,共计9道题,本题难度系数3星
// *
// */
//// TODO Auto-generated constructor stub //{a50d6602789b770a5e5aee28fd392a2c}
//public class Test {
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		// 在本包下增加或完善合适的类，使得如下代码编译通过并正确运行
//		// 本题目所有答案必须放在和本Test同级的目录下,除了JDK1.8自带的包以外，不允许引用第三方的包
//		// 本目录下的程序不要引用其他考题或者作业的类，否则会导致编译失败
//		// 不能随意读写文件，建立网络连接，访问数据库，创建临时文件目录等
//		// 此类应该为无状态类，也就是new一个实例以后，可以调用若干次getAvgWait方法，而不互相干扰
//		MyQueueUtil util = new MyQueueUtil();
//		// detail文件存放了每个市民到达核酸检测场所的时间，具体格式见detail.txt
//		String detail = "合适的目录/detail.txt";
//
//		// 每个医生检测一个核酸检测需要50秒,50秒这个数值永远不变
//		// doctorCount 表示可以进行核酸检测的医生数量
//		int doctorCount = 2;
//		//计算一次核酸检测中市民的平均排队时间，具体要求见getAvgWait方法
//		double avg = util.getAvgWait(detail, doctorCount);
//		if (Math.abs(avg - 20.0) < 0.01) {//这个测试用例正确答案是20，允许有0.01误差
//			System.out.println("pass 1");
//		}
//		System.out.print(avg);
//
//	}
//	// TODO Auto-generated constructor stub //{ac3b73869c633a6f5a06d71b1bc04312}
//}
//// TODO Auto-generated constructor stub //{b224a09901b2885d1822181847585f39}