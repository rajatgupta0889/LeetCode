package org.leetcode.google;

import java.util.ArrayList;
import java.util.List;


public class Entity {
    int id;
    String type;
    String name;
    int size;
    List<Entity> children;

    public Entity(int id, String type, String name, int size) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.size = size;
        this.children = new ArrayList<>();
    }
}
