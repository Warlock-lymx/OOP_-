package com.huawei.classroom.student.h53;

public class Rabbit {
    private int dayAge;
    private boolean dead;

    public Rabbit() {
        dayAge = 0;
        dead = false;
    }

    public int getDayAge() {
        return dayAge;
    }

    public boolean isDead() {
        return dead;
    }

    public void growOneDay() {
        if (isDead()) return;
        dayAge++;
        if (dayAge > 700) dead = true;
    }
}
