package com.huawei.classroom.student.h15;

import java.util.List;

public class MyThread extends Thread {
    public long low;
    public long high;
    public List list;

    public MyThread(long low, long high, List list) {
        this.low = low;
        this.high = high;
        this.list = list;
    }

    public boolean isPrime(long num) {
        if (num <= 1) return false;
        else {
            for (int i = 2; i <= Math.sqrt(num); i++) {
                if (num % i == 0) return false;
            }
            return true;
        }
    }

    @Override
    public void run() {
        for (long i = low; i <= high; i++) {
            if (isPrime(i))
                list.add(i);
        }
    }
}
