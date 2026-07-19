package org.graph.entities;

public class NodeEntity {
    private final String name;
    private final String color;

    public NodeEntity(String name, String color) {
        this.name = name;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }
}