package org.graph.entities;

import org.graph.view.GraphView;
import org.graphstream.graph.Graph;

import java.util.ArrayList;
import java.util.List;

public class GraphModel {
    private final static List<Node> nodes = new ArrayList<>();
    private final static List<Edge> edges = new ArrayList<>();

    public GraphModel(Graph graph) {
    }

    public List<Node> getNodes() {
        return nodes;
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public static void addNode(Node node) {
        try {
            nodes.add(node);
            GraphView.visualizeNodes(nodes);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void addEdge(Edge edge) {
        try {
            edges.add(edge);
            GraphView.visualizeEdges(edges);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}