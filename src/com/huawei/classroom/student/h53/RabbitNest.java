package com.huawei.classroom.student.h53;

import java.util.ArrayList;
import java.util.List;

public class RabbitNest {
    private final List<Rabbit> rabbits = new ArrayList<>();

    public RabbitNest(int startCount) {
        for (int i = 0; i < startCount; i++) {
            Rabbit rabbit = new Rabbit();
            rabbits.add(rabbit);
        }
    }

    public void rabbitsGrow() {
        for (Rabbit rabbit : rabbits) {
            rabbit.growOneDay();
        }
    }

    public void rabbitsDead() {
        rabbits.removeIf(Rabbit::isDead);
    }

    public void rabbitsBearLittleRabbits() {
        List<Rabbit> rabbitsBornOneDay = new ArrayList<>();// 这一天生的兔子
        for (Rabbit rabbit : rabbits) {// 这一天存活的兔子，不包括新生的兔子
            int dayAge = rabbit.getDayAge();// 某兔子的年龄
            boolean isRabbitCanBear = (dayAge == 180) || (dayAge > 180 && dayAge % 90 == 0);// 可以生小兔子的条件
            if (isRabbitCanBear && !rabbit.isDead()) {// 可生且未死亡
                Rabbit rabbit1 = new Rabbit();// 生了一对
                Rabbit rabbit2 = new Rabbit();// 又生了一对
                rabbitsBornOneDay.add(rabbit1);
                rabbitsBornOneDay.add(rabbit2);// 加入到这一天新生的兔子中
            }
        }
        rabbits.addAll(rabbitsBornOneDay);// 这一天新生的兔子加入到兔子集体
    }

    public void oneDayPass() {
        rabbitsGrow();
        rabbitsDead();
        rabbitsBearLittleRabbits();
    }

    public int getLivingRabbits() {
        return rabbits.size();
    }

}
