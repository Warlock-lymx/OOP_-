package com.huawei.classroom.student.h06;


public class GameBase extends Building {
    public GameBase(int x, int y) {
        super(x, y, 500, 0, 0);
    }

    public static GameBase createGameBase(int x, int y) {
        return new GameBase(x, y);
    }

    public Unit building(EnumObjectType type, int x, int y) {
        if (this.hp <= 0) {
            return null;
        }
        switch (type) {
            case barrack:
                return new Barrack(x, y);
            case warFactory:
                return new WarFactory(x, y);
            default:
                return null;
        }
    }
}
