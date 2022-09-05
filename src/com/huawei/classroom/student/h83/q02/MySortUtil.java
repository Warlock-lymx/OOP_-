package com.huawei.classroom.student.h83.q02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;

//TODO Auto-generated constructor stub //{7c659b3a726b51e03bda71c55d2425fa}
public class MySortUtil {

	/**
	 * 对一个学生列表根据总成绩从高到低排序并返回,
	 * 如果总成绩相同按语文由高到低排列，
	 * 如果语文成绩相同按数学成绩从高到低排列
	 * 不会出现总成绩相同且语文相同且数学相同的情况
	 * @param list
	 * @return 完成排序的学生
	 */
	public List<MyStudent> sort(List<MyStudent> list){
		// 
		// TODO Auto-generated constructor stub //{7c6f8728157a20260e1056300857b99b}
		List<MyStudent> result = new ArrayList();
		TreeSet<MyStudent> sorted = new TreeSet<>();
		for(MyStudent student:list) {
			student.set_total();
			sorted.add(student);
		}
		for(MyStudent student:sorted) {
			result.add(student);
		}
		return result;
	}
}
//TODO Auto-generated constructor stub //{8076a1ff61513c53ac3a390e8a955044}	