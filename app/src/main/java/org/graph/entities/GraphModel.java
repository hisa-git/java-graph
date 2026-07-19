package org.graph.entities;

import org.graph.view.GraphView;

import java.util.ArrayList;
import java.util.List;

public class GraphModel {
    private final static List<Node> nodes = new ArrayList<>();
    private final static List<Edge> edges = new ArrayList<>();

    private final GraphView view;

    public GraphModel(GraphView view) {
        this.view = view;
    }

    public List<Node> getNodes() {
        return nodes;
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public void addNode(Node node) {
        try {
            nodes.add(node);
            view.visualizeNode(node);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addEdge(Edge edge) {
        try {
            edges.add(edge);
            view.visualizeEdge(edge);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}