package com.huawei.classroom.student.h59;

public class a {
    public static void main(String[] args) {
        String a = "sdvvca +  cwwvwv +      wfwefw   +weffweff";
        String[] b = a.split(" *\\+ *");
        String[] c = a.split("\\s*\\+\\s*");
        for (int i = 0; i < b.length; i++) {
            System.out.println(b[i]);
        }
    }
}
