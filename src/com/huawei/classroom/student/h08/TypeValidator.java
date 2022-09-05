package com.huawei.classroom.student.h08;

public class TypeValidator {
    public void validate(String str) {
    }

    public void validate(Object obj) {
        throw new RuntimeException();
    }
}
