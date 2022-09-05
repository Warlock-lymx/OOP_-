package com.huawei.classroom.student.h83.q01;

import java.util.HashMap;
import java.util.Map;

//TODO Auto-generated constructor stub //{6fc6b3e0955d76c5af994f16a7eb8ea2}
public class MyEncryptUtil {

    //

    /**
     * 完成对一个字符串的加密，加密规则如下：
     * 将源字符串中的a替换为b,b替换为c...，y替换为z，z替换为a
     * 将源字符串中的A替换为B,B替换为C...，Y替换为Z，Z替换为A
     * 其他字符不变
     *
     * @param src
     * @return
     */
    public String encrypt(String src) {
        //
        // TODO Auto-generated constructor stub //{776adb932c1fc742448d57cbe82d0b62}
        char[] result = new char[src.length()];
        String s = "";
        for (int i = 0; i < src.length(); i++) {
            char c = src.charAt(i);
            char res = (char) (c + 1);
            result[i] = res;
        }
        for (int i = 0; i < result.length; i++) {
            s += result[i];
        }
        return s;
    }

    /**
     * 完成对一个字符串的解密，字符串当初的加密规则见encrypt函数说明
     * @param src
     * @return
     */
	public String decrypt(String src) {
		// TODO Auto-generated constructor stub //{78b4a8bbb962160c7f26ee769660620d}
        char[] result = new char[src.length()];
        String s = "";
        for (int i = 0; i < src.length(); i++) {
            char c = src.charAt(i);
            char res = (char) (c - 1);
            result[i] = res;
        }
        for (int i = 0; i < result.length; i++) {
            s += result[i];
        }
        return s;

	}
}
//TODO Auto-generated constructor stub //{795281172c94d98ad241b4aae8f98321}