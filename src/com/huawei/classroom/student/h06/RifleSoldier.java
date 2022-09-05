package com.huawei.classroom.student.h06;


public class RifleSoldier extends Soldier {
    public RifleSoldier(int x, int y) {
        super(x, y, 50, 5, 5);
    }

    public void attack(Dog dog) {
        double dis = getDistance(dog);
        if (dog.hp > 0 && dis <= this.range)
            dog.hp = 0;
    }
}
