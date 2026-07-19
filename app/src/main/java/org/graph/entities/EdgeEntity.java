package org.graph.entities;

public class EdgeEntity {
    String id;
    String node1;
    String node2;

    public EdgeEntity(String id, String node1, String node2) {
        this.id = id;
        this.node1 = node1;
        this.node2 = node2;
    }

    public String getId() {
        return id;
    }
    public String getNode1() {
        return node1;
    }
    public String getNode2() {
        return node2;
    }
}

