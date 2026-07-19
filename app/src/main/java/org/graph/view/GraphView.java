package org.graph.view;

import org.graph.entities.Edge;
import org.graph.entities.Node;
import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.SingleGraph;

public class GraphView {

    private final Graph graph = new SingleGraph("Demo");;

    public GraphView() {
        graph.setAttribute(
                "ui.stylesheet",
                "node {" +
                        "fill-color: #4c87af;" +
                        "size: 20px;" +
                        "text-size: 18;" +
                        "}" +
                        "edge {" +
                        "fill-color: gray;" +
                        "}");
    }

    public void visualizeNode(Node node) {
        graph.addNode(node.getName());
    }

    public void visualizeEdge(Edge edge) {
        graph.addEdge(
                edge.getId(),
                edge.getNode1(),
                edge.getNode2());
    }

    public Graph getGraph() {
        return graph;
    }
}