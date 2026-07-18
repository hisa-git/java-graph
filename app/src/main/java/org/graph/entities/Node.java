package org.graph.entities;

public class Node {
    private final String name;
    private final String color;

    public Node(String name, String color) {
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