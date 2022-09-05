/**
 *
 */
package com.huawei.classroom.student.h54;

/**
 * @author Administrator
 *
 */
public class PasswordChecker {
    /**
     * 判断一个口令是否是一个复杂度合法的口令，复杂度合法的口令有如下要求：
     * 1  长度>=8
     * 2 最少包含一个数字
     * 3 最少包含一个小写英文字母
     * 4 虽少包含一个大写英文字母
     * 5 最少包含一个特殊字符 特殊字符定义为   ~!@#$%^&*()_+
     *
     *
     */
    public boolean isSpecial(char c) {
        if (c == '~' || c == '!' || c == '#' || c == '$' || c == '%' || c == '^' || c == '&' || c == '*' || c == '('
                || c == ')' || c == '_' || c == '+')
            return true;
        else return false;
    }

    public boolean isValidPassword(String password) {
        if (password.length() < 8) return false;
        else {
            boolean num_flag = false;
            boolean LowerCase = false;
            boolean UpperCase = false;
            boolean special_flag = false;
            for (int i = 0; i < password.length(); i++) {
                if (Character.isDigit(password.charAt(i))) num_flag = true;
                else if (Character.isLowerCase(password.charAt(i))) LowerCase = true;
                else if (Character.isUpperCase(password.charAt(i))) UpperCase = true;
                else if (isSpecial(password.charAt(i))) special_flag = true;
            }
            if (num_flag && LowerCase && UpperCase && special_flag) return true;
            else return false;
        }

    }
}
