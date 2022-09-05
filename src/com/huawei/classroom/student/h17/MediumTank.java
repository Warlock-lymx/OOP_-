package com.huawei.classroom.student.h17;

public class MediumTank extends GameObject{
    public MediumTank(Player player,int x,int y) {
        super(x, y,Integer.parseInt(BattleField.properties.getProperty("mediumTank.health").replace(" ", "")), Integer.parseInt(BattleField.properties.getProperty("mediumTank.strength").replace(" ", "")), Integer.parseInt(BattleField.properties.getProperty("mediumTank.range").replace(" ", "")),player);
    }
}
