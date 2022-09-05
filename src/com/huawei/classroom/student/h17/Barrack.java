package com.huawei.classroom.student.h17;

public class Barrack extends GameObject {
    public Barrack(Player player, int x, int y) {
        super(x, y, Integer.parseInt(BattleField.properties.getProperty("barrack.health").replace(" ", "")), Integer.parseInt(BattleField.properties.getProperty("barrack.strength").replace(" ", "")), Integer.parseInt(BattleField.properties.getProperty("barrack.range").replace(" ", "")), player);
    }

    public GameObject traing(EnumObjectType type) {
        if(this.isDestroyed()) return null;
        if (type == EnumObjectType.rifleSoldier) {
            RifleSoldier riflesoldier = new RifleSoldier(this.player, this.x, this.y);
            this.player.gameObjects.add(riflesoldier);
            return riflesoldier;
        } else if (type == EnumObjectType.RPGSoldier) {
            RPGSoldier rpgsoldier = new RPGSoldier(this.player, this.x, this.y);
            player.gameObjects.add(rpgsoldier);
            return rpgsoldier;
        } else if (type == EnumObjectType.dog) {
            Dog dog = new Dog(this.player, this.x, this.y);
            player.gameObjects.add(dog);
            return dog;
        } else {
            return null;
        }
    }
}