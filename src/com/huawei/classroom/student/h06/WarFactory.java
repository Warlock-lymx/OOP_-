package com.huawei.classroom.student.h06;

public class WarFactory extends Building {
    public WarFactory(int x, int y) {
        super(x, y, 100, 0, 0);
    }

    public void move(int x, int y) {
    }

    public Unit building(EnumObjectType type) {
        switch (type) {
            case mediumTank:
                return new MediumTank(this.x, this.y);
            case heavyTank:
                return new HeavyTank(this.x, this.y);
            default:
                return null;
        }
    }
}
