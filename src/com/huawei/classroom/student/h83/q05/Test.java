package com.huawei.classroom.student.h83.q05;

import java.util.Map;
/**
 * 本题8分 ,共计9道题,本题难度系数3星
 *
 */
public class Test {
	// TODO Auto-generated constructor stub //{a049eded5137771bdb032e959df2c8a3}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 在本包下增加或完善合适的类，使得如下代码编译通过并正确运行
		// 本题目所有答案必须放在和本Test同级的目录下,除了JDK1.8自带的包以外，不允许引用第三方的包
		// 本目录下的程序不要引用其他考题或者作业的类，否则会导致编译失败
		// 不能随意读写文件，建立网络连接，访问数据库，创建临时文件目录等
		// 此类应该为无状态类，也就是new一个实例以后，可以调用若干次getApplicationResult方法，而不互相干扰
		MyApplicationUtil util=new MyApplicationUtil();
		String appFile="D:\\homework\\src\\com\\huawei\\classroom\\student\\h83\\q05\\applications.txt";
		String scoreFile="D:\\homework\\src\\com\\huawei\\classroom\\student\\h83\\q05\\scores.txt";
		int enrollment=2;
		//scoreFile  存放了所有学生总分 ，格式见scores.txt文件
		//appFile存放了所有学生志愿，格式见applications.txt文件
		//enrollment表示每个大学最多录取人数
		//返回每个学生的录取情况 具体要求见 MyApplicationUtil

		Map<String,String> result=util.getApplicationResult(scoreFile, appFile, enrollment);
		if(result.size()==4
				&&"u2".equals(result.get("001"))
				&&"u1".equals(result.get("002"))
				&&"u1".equals(result.get("003"))
				&&null==result.get("004")) {
			System.out.println("pass 1 !");
		}

		// TODO Auto-generated constructor stub //{a260aadddf2255be15e8d89a00179c6e}
	}

}
//TODO Auto-generated constructor stub //{a3ef740583d8917924aba9d0d6eafb30}