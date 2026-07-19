package org.graph.view;

import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.SingleGraph;

import org.graph.entities.Node;

import java.util.List;

import org.graph.entities.Edge;

public class GraphView {

    static Graph graph = new SingleGraph("Demo");

    public static void visualizeNodes(List<Node> nodes) {
        for (Node node : nodes) {
            graph.addNode(node.getName());
        }
    }

    public static void visualizeEdges(List<Edge> edges) {
        for (Edge edge : edges) {
            graph.addEdge(edge.getId(), edge.getNode1(), edge.getNode2());
        }
    }

    public Graph getGraph() {
        return graph;
    }
}
