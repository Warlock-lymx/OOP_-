package com.huawei.classroom.student.h17;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class BattleField {
    public static Properties properties = new Properties();
    public static FileInputStream fileInputStream = null;
    public static List<Player> Players = new ArrayList<Player>();

    public static void init(String path){
        try{
            fileInputStream = new FileInputStream(path);
            properties.load(fileInputStream);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void createPlayer(String name) {
        Player player = new Player(name);
        Players.add(player);
    }

    public static List<Player> getAllPlayer() {
        return Players;
    }

    public static GameBase createGameBase(Player player,int x,int y) {
        GameBase gameBase = new GameBase(player,x,y);
        player.gameObjects.add(gameBase);
        return gameBase;
    }

}
