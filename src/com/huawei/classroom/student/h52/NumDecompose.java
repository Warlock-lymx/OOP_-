package com.huawei.classroom.student.h52;

import java.util.HashSet;
import java.util.Set;

public class NumDecompose {
    /**
     * 将num进行质因数分解，将分解到的质因数放到Set里面返回
     */
    public Set<Integer> decompose(int num) {
        Set set = new HashSet();
        if (isPrime(num)) {
            set.add(num);
        } else {
            int tmp = num;
            for (int i = 2; i < Math.sqrt(num); i++) {
                while (tmp % i == 0) {
                    set.add(i);
                    tmp /= i;
                }
            }
            if (tmp != 1) set.add(tmp);
        }
        return set;
    }

    public boolean isPrime(int num) {
        if (num == 1) return false;
        else {
            for (int i = 2; i <= Math.sqrt(num); i++) {
                if (num % i == 0) return false;
            }
            return true;
        }
    }
}
