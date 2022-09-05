package com.huawei.classroom.student.h83.q02;

public class MyStudent implements Comparable{
    public String id;
    public int total;
    public int chinese = 0;
    public int math = 0;
    public int english = 0;

    public MyStudent(String id, int chinese, int math, int english) {
        this.id = id;
        this.chinese = chinese;
        this.math = math;
        this.english = english;
    }

    @Override
    public int compareTo(Object o) {
        MyStudent student = (MyStudent) o;
        if (total != student.total)
            return Integer.compare(student.total, total);
        else if (chinese != student.chinese)
            return Integer.compare(student.chinese, chinese);
        else
            return Integer.compare(student.math, math);
    }

    public void set_total() {
        total = chinese + math + english;
    }

    public String getId() {
        return this.id;
    }
}
