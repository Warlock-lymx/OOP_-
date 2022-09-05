package com.huawei.classroom.student.h17;

public class Dog extends GameObject{
    public Dog(Player player,int x,int y) {
        super(x, y,Integer.parseInt(BattleField.properties.getProperty("dog.health").replace(" ", "")), Integer.parseInt(BattleField.properties.getProperty("dog.strength").replace(" ", "")), Integer.parseInt(BattleField.properties.getProperty("dog.range").replace(" ", "")),player);
    }
}
