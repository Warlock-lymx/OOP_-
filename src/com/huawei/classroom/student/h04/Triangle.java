package com.huawei.classroom.student.h04;

public class Triangle {
    double A,B,C;
    double area;

    public void setA(double n) {
        A = n;
    }

    public void setB(double n) {
        B = n;
    }

    public void setC(double n) {
        C = n;
    }

    public double getArea() {
        double p = (A + B + C) / 2;
        area = Math.sqrt(p * (p - A) * (p - B) * (p - C));
        return area;
    }
}
