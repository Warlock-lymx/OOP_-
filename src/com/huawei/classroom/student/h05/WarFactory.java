package com.huawei.classroom.student.h05;

public class WarFactory extends Building {
    public WarFactory() {
        super(100, 0);
    }

    public Base building(EnumObjectType type) {
        if (this.hp <= 0)
            return null;
        switch (type) {
            case heavyTank:
                return new HeavyTank();
            case mediumTank:
                return new MediumTank();
            default:
                return null;
        }
    }
}
