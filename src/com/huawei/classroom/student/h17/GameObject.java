package com.huawei.classroom.student.h17;


public class GameObject {
    public int x, y;
    public int hp, atk, range;
    public Player player;

    public GameObject(int x, int y, int hp, int atk, int range, Player player) {
        this.x = x;
        this.y = y;
        this.hp = hp;
        this.atk = atk;
        this.range = range;
        this.player = player;
    }

    public void move(int x, int y) {
        this.x += x;
        this.y += y;
    }

    public double getDistance(GameObject object) {
        return Math.sqrt(Math.pow(this.x - object.x, 2) + Math.pow(this.y - object.y, 2));
    }

    public int getHealth() {
        return this.hp;
    }

    public boolean isDestroyed() {
        if (this.hp <= 0)
            return true;
        else
            return false;
    }

    public void attack() {
        if (this.isDestroyed()) return;
        double mindis = 0x0fffffff;
        GameObject target = null;
        for (int i = 0; i < BattleField.getAllPlayer().size(); i++) {
            Player currentPlayer = BattleField.getAllPlayer().get(i);
            if (this.player == currentPlayer) continue;
            else {
                for (int j = 0; j < currentPlayer.gameObjects.size(); j++) {
                    GameObject currentObject = currentPlayer.gameObjects.get(j);
                    Double dis = this.getDistance(currentObject);
                    if (dis < mindis && !currentObject.isDestroyed() && dis <= this.range) {
                        mindis = dis;
                        target = currentObject;
                    }
                }
            }
        }
        if (target != null) {
            attack(target);
            System.out.println(player.name + " live = " + !isDestroyed() + " x = " + x + " y = " + y + " health = " + hp +
                    " 攻击" + target.player.name + " live = " + !(target.isDestroyed()) + " x = " + target.x + " y = " + target.y + " health = " + target.hp +
                    " 攻击后" + " health=" + target.hp);
        }
    }

    public void attack(GameObject object) {
        if (this.isDestroyed()) return;
        double dis = this.getDistance(object);
        if (!object.isDestroyed() && dis <= this.range)
            object.hp -= this.atk;
    }

}
