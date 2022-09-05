package com.huawei.classroom.student.h05;

public class Soldier extends Base {
    public Soldier(int hp, int atk) {
        super(hp, atk);
        livesoldier++;
    }

    public static int getLivingSoldierCount() {
        return livesoldier;
    }

    public static int getDeadedSoldierCount() {
        return deadsoldier;
    }
}
