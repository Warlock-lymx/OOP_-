package com.huawei.classroom.student.h17;

public class GameBase extends GameObject {
    public GameBase(Player player, int x, int y) {
        super(x, y, Integer.parseInt(BattleField.properties.getProperty("base.health").replace(" ", "")), Integer.parseInt(BattleField.properties.getProperty("base.strength").replace(" ", "")), Integer.parseInt(BattleField.properties.getProperty("base.range").replace(" ", "")), player);
    }

    public GameObject building(EnumObjectType type, int x, int y) {
        if (this.isDestroyed()) return null;
        switch (type) {
            case barrack: {
                Barrack barrack = new Barrack(this.player, x, y);
                this.player.gameObjects.add(barrack);
                return barrack;
            }
            case warFactory: {
                WarFactory warFactory = new WarFactory(this.player, x, y);
                this.player.gameObjects.add(warFactory);
                return warFactory;
            }
            default:
                return null;
        }
    }
}
