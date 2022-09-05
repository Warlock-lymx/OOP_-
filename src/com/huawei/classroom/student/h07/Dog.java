package com.huawei.classroom.student.h07;

public class Dog extends GameObject {

    public Dog(int x, int y) {
        super(x, y);
        // super( Param.DOG_HEALTH,Param.DOG_STRENGTH);
        // TODO Auto-generated constructor stub
    }

    public void attack(Soldier soldier) {
        if (soldier.getHealth() > 0) {
            int dx = this.getX() - soldier.getX();
            int dy = this.getY() - soldier.getY();
            double dis = Math.pow(dx * dx + dy * dy, 0.5);
            if (this.getRange() < dis) {
                return;
            }
            if (soldier instanceof Soldier) {
                soldier.setHealth(0);
                soldier.livingSoldierCount--;
                soldier.deadedSoldierCount++;
            } else {
                soldier.setHealth(soldier.getHealth() - this.getStrength());
            }
        } else return;

    }

}
