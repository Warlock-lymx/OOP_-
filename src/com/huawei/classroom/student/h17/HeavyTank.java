package com.huawei.classroom.student.h17;

public class HeavyTank extends GameObject{
    public HeavyTank(Player player,int x,int y) {
        super(x, y,Integer.parseInt(BattleField.properties.getProperty("heavyTank.health").replace(" ", "")), Integer.parseInt(BattleField.properties.getProperty("heavyTank.strength").replace(" ", "")), Integer.parseInt(BattleField.properties.getProperty("heavyTank.range").replace(" ", "")),player);
    }
}
