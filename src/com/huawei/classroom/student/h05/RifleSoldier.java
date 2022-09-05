package com.huawei.classroom.student.h05;

public class RifleSoldier extends Soldier {
    public RifleSoldier() {
        super(50, 5);
    }

    public void attack(Dog dog) {
        dog.hp = 0;
    }
}
