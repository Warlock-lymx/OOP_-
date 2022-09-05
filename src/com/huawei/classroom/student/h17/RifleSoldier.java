package com.huawei.classroom.student.h17;

public class RifleSoldier extends GameObject{
    public RifleSoldier(Player player,int x,int y) {
        super(x, y,Integer.parseInt(BattleField.properties.getProperty("rifleSoldier.health").replace(" ", "")), Integer.parseInt(BattleField.properties.getProperty("rifleSoldier.strength").replace(" ", "")), Integer.parseInt(BattleField.properties.getProperty("rifleSoldier.range").replace(" ", "")),player);
    }
}
