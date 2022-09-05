package com.huawei.classroom.student.h19.q03;


import java.util.Arrays;

public class ArrayUtil {
    public int getMin(int[] arr) {
        Arrays.sort(arr);
        return arr[0];
    }
}
