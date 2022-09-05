package com.huawei.classroom.student.h05;


public class Base {
    public int hp;
    public int atk;
    public static int livesoldier = 0;
    public static int deadsoldier = 0;


    public Base(int hp, int atk) {
        this.hp = hp;
        this.atk = atk;
    }

    public void attack(Soldier soldier) {
        if (soldier.hp > 0) {
            soldier.hp -= this.atk;
            if (soldier.hp <= 0) {
                livesoldier--;
                deadsoldier++;
            }
        }
    }

    public void attack(Dog dog) {
        if (dog.hp > 0)
            dog.hp -= this.atk;
    }

    public void attack(Tank tank) {
        if (tank.hp > 0)
            tank.hp -= this.atk;

    }

    public void attack(Building building){
        if(building.hp > 0)
            building.hp -= this.atk;
    }

    public int getHealth() {
        return this.hp;
    }

    public boolean isDestroyed() {
        if (this.hp <= 0)
            return true;
        else
            return false;
    }
}
