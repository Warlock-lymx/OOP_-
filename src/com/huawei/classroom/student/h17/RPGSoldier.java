package com.huawei.classroom.student.h17;

public class RPGSoldier extends GameObject{
    public RPGSoldier(Player player,int x,int y) {
        super(x, y,Integer.parseInt(BattleField.properties.getProperty("RPGSoldier.health").replace(" ", "")), Integer.parseInt(BattleField.properties.getProperty("RPGSoldier.strength").replace(" ", "")), Integer.parseInt(BattleField.properties.getProperty("RPGSoldier.range").replace(" ", "")),player);
    }
}
