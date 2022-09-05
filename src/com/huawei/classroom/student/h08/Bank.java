package com.huawei.classroom.student.h08;

public class Bank {
    int remain = 0;

    public void save(int money) {
        remain += money;
    }
    public void get(int money) {
        if(money >remain){
            throw new NoMoneyException();
        }
        remain -= money;
    }
}

class NoMoneyException extends RuntimeException{}