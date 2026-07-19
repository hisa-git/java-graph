package org.graph.entities;

import org.graph.view.GraphView;

import java.util.ArrayList;
import java.util.List;

public class GraphModel {
    private final static List<NodeEntity> nodes = new ArrayList<>();
    private final static List<EdgeEntity> edges = new ArrayList<>();

    private final GraphView view;

    public GraphModel(GraphView view) {
        this.view = view;
    }

    public List<NodeEntity> getNodes() {
        return nodes;
    }

    public List<EdgeEntity> getEdges() {
        return edges;
    }

    public void addNode(NodeEntity node) {
        try {
            nodes.add(node);
            view.visualizeNode(node);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addEdge(EdgeEntity edge) {
        try {
            edges.add(edge);
            view.visualizeEdge(edge);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}