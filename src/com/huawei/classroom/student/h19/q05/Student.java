package com.huawei.classroom.student.h19.q05;

public class Student implements Comparable {
    public String name;
    public int chinese = 0;
    public int math = 0;
    public int english = 0;
    public int physics = 0;
    public int total = 0;

    public Student() {
        // TODO Auto-generated constructor stub
    }

    @Override
    public int compareTo(Object o) {
        // TODO Auto-generated method stub
        Student student = (Student) o;
        if (total != student.total)
            return Integer.compare(student.total, total);
        else if (chinese != student.chinese)
            return Integer.compare(student.chinese, chinese);
        else if (math != student.math)
            return Integer.compare(student.math, math);
        else if (english != student.english)
            return Integer.compare(student.english, english);
        else
            return Integer.compare(student.physics, physics);
    }

    public void set_score(String subject, String score) {
        if (subject.equals("语文")) chinese = Integer.parseInt(score);
        else if (subject.equals("数学")) math = Integer.parseInt(score);
        else if (subject.equals("英语")) english = Integer.parseInt(score);
        else if (subject.equals("物理")) physics = Integer.parseInt(score);
        else return;
    }

    public void set_name(String name) {
        this.name = name;
    }

    public void set_total() {
        total = chinese + math + english + physics;
    }

}
