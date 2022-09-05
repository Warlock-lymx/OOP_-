package com.huawei.classroom.student.h83.q07;

import java.util.*;

//TODO Auto-generated constructor stub //{baf7818a1d47b2c98098f21904f247b9}
public class MyStrUtil {

    /**
     * 判断str中是否包含了所有的英文字母（不区分小写)
     *
     * @param str
     * @return 如果包含了全部的英文字母则返回true，否则 false
     */
    public boolean containsAllLetters(String str) {
        //
        // TODO Auto-generated constructor stub //{bd1caca35e9baf07da31fe3e75944461}
        Set<Character> set = new HashSet<>();
        List<Character> target = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            target.add((char) ('a' + i));
        }
        str = str.toLowerCase();
        for (int i = 0; i < str.length(); i++) {
            set.add(str.charAt(i));
        }
        if(set.containsAll(target)) return true;
        else return false;
    }
}
//TODO Auto-generated constructor stub //{bee6c2c71c225e12e2f4440df5fccf17}