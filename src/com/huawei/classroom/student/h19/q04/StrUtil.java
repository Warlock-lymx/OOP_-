package com.huawei.classroom.student.h19.q04;

import java.util.HashSet;
import java.util.LinkedHashSet;

public class StrUtil {
    public String removeDulpicatedChar(String str) {
        HashSet<Character> hashSet = new LinkedHashSet<>();
        char[] tmp = str.toCharArray();
        for (char c : tmp) {
            hashSet.add(c);
        }
        String res = "";
        for (char c : hashSet) {
            res += c;
        }
        return res;
    }
}
