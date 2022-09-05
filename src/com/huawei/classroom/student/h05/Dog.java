package com.huawei.classroom.student.h05;

public class Dog extends Base {
    public Dog() {
        super(50, 5);
    }

    public void attack(Soldier soldier) {
        soldier.hp = 0;
        livesoldier--;
        deadsoldier++;
    }
}
