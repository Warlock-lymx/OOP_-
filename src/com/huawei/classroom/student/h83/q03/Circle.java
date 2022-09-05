package com.huawei.classroom.student.h83.q03;

public class Circle {
    public double R;
    public double area;

    public void setR(int R) {
        this.R = R;
    }

    public double getArea() {
        this.area= 3.14 * R * R;
        return area;
    }
}
