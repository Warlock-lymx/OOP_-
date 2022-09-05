package com.huawei.classroom.student.h06;


public class Dog extends Unit {
    public Dog(int x, int y) {
        super(x, y, 50, 5, 5);
    }

    public void attack(Soldier soldier) {
        double dis = getDistance(soldier);
        if (soldier.hp > 0 && dis <= this.range) {
            soldier.hp = 0;
            livesoldier--;
            deadsoldier++;
        }

    }
}
