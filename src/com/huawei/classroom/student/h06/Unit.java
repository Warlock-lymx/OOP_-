package com.huawei.classroom.student.h06;


public class Unit {
    public int x, y;
    public int hp, atk, range;
    public static int livesoldier = 0;
    public static int deadsoldier = 0;

    public Unit(int x, int y, int hp, int atk, int range) {
        this.x = x;
        this.y = y;
        this.hp = hp;
        this.atk = atk;
        this.range = range;
    }

    public void move(int x, int y) {
        this.x += x;
        this.y += y;
    }

    public double getDistance(Unit unit) {
        return Math.sqrt(Math.pow(this.x - unit.x, 2) + Math.pow(this.y - unit.y, 2));
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

    public void attack(Soldier soldier) {
        double dis = getDistance(soldier);
        if (soldier.hp > 0 && dis <= this.range) {
            soldier.hp -= this.atk;
            if (soldier.hp <= 0) {
                livesoldier--;
                deadsoldier++;
            }
        }
    }

    public void attack(Dog dog) {
        double dis = getDistance(dog);
        if (dog.hp > 0 && dis <= this.range)
            dog.hp -= this.atk;
    }

    public void attack(Tank tank) {
        double dis = getDistance(tank);
        if (tank.hp > 0 && dis <= this.range)
            tank.hp -= this.atk;
    }

    public void attack(Building building) {
        double dis = getDistance(building);
        if (building.hp > 0 && dis <= this.range)
            building.hp -= this.atk;
    }
}
