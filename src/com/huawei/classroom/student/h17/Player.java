package com.huawei.classroom.student.h17;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Player {
    public String name;
    public List<GameObject> gameObjects =  new ArrayList<>();

    public Player(String name) {
        this.name = name;
    }
}
