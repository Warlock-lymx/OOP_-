package com.huawei.classroom.student.h17;

public class WarFactory extends GameObject{
    public WarFactory(Player player,int x,int y) {
        super(x, y,Integer.parseInt(BattleField.properties.getProperty("warFactory.health").replace(" ", "")), Integer.parseInt(BattleField.properties.getProperty("warFactory.strength").replace(" ", "")), Integer.parseInt(BattleField.properties.getProperty("warFactory.range").replace(" ", "")),player);
    }

    public GameObject building(EnumObjectType type) {
        if(this.isDestroyed()) return null;
        if (type == EnumObjectType.heavyTank) {
            HeavyTank heavyTank = new HeavyTank(this.player, this.x, this.y);
            this.player.gameObjects.add(heavyTank);
            return heavyTank;
        } else if (type == EnumObjectType.mediumTank) {
            MediumTank mediumTank = new MediumTank(this.player, this.x, this.y);
            this.player.gameObjects.add(mediumTank);
            return mediumTank;
        } else {
            return null;
        }
    }
}
