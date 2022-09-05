package com.huawei.classroom.student.h06;

public class Soldier extends Unit {
    public Soldier(int x, int y, int hp, int atk, int range) {
        super(x, y, hp, atk, range);
        livesoldier++;
    }

    public static int getLivingSoldierCount() {
        return livesoldier;
    }

    public static int getDeadedSoldierCount() {
        return deadsoldier;
    }
}
