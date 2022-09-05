package com.huawei.classroom.student.h19.q02;

public class Person {
    private String name;
    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Student extends Person {
    public Student(String name) {
        super(name);
    }
}