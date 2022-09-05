package com.huawei.classroom.student.h06;


public class Barrack extends Building {
    public Barrack(int x, int y) {
        super(x, y, 100, 0, 0);
    }

    public void move(int x, int y) {
    }

    public Unit traing(EnumObjectType type) {
        if (this.hp <= 0) {
            return null;
        }
        switch (type) {
            case dog:
                return new Dog(this.x, this.y);
            case RPGSoldier:
                return new RPGSoldier(this.x, this.y);
            case rifleSoldier:
                return new RifleSoldier(this.x, this.y);
            default:
                return null;
        }
    }
}