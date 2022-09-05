package com.huawei.classroom.student.h08;

public class Dog {
    int cnt= 0;
    public void feed() throws Exception{
        if(cnt >= 3) {
            throw new Exception("I can not eat more!");
        }
        cnt++;
    }
}
