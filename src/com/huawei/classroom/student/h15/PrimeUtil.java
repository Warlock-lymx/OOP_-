package com.huawei.classroom.student.h15;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PrimeUtil {
    public synchronized List getPrimeList(long start, long end, int threadCount) {
        List<Integer> list = new ArrayList<>();
        try {
            long num = (end - start) / threadCount;
            long low = 0;
            long high = 0;
            for (int i = 1; i <= threadCount; i++) {
                if (i != threadCount) {
                    low = start + (i - 1) * num;
                    high = low + num - 1;
                } else {
                    low = start + (i - 1) * num;
                    high = end - 1;
                }
                MyThread myThread = new MyThread(low, high, list);
                myThread.start();
                myThread.join();
            }
            Collections.sort(list);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            return list;
        }
    }
}
