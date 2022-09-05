package com.huawei.classroom.student.h05;

public class Barrack extends Building {
    public Barrack() {
        super(100, 0);
    }

    public Base traing(EnumObjectType type) {
        if (this.hp <= 0)
            return null;
        switch (type) {
            case dog:
                return new Dog();
            case RPGSoldier:
                return new RPGSoldier();
            case rifleSoldier:
                return new RifleSoldier();
            default:
                return null;
        }
    }
}
