package org.graph.view;

import java.util.Random;
import java.awt.Color;

import org.graph.entities.EdgeEntity;
import org.graph.entities.NodeEntity;

import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.SingleGraph;
import org.graphstream.graph.Node;

public class GraphView {

    private final Graph graph = new SingleGraph("Demo");;

    public GraphView() {
        String css = getClass()
                .getResource("/css/graph.css")
                .toExternalForm();

        graph.setAttribute("ui.stylesheet", "url('" + css + "')");
    }

    public void visualizeNode(NodeEntity node) {
        Random rand = new Random();
        int r = rand.nextInt(256);
        int g = rand.nextInt(256);
        int b = rand.nextInt(256);
        Color randomColor = new Color(r, g, b);

        String cssColor = String.format(
                "rgb(%d,%d,%d)",
                randomColor.getRed(),
                randomColor.getGreen(),
                randomColor.getBlue());

        Node newNode = graph.addNode(node.getName());
        newNode.setAttribute("ui.label", node.getName());
        newNode.setAttribute(
                "ui.style",
                "fill-color: " + cssColor + ";");
    }

    public void visualizeEdge(EdgeEntity edge) {
        graph.addEdge(
                edge.getId(),
                edge.getNode1(),
                edge.getNode2());
    }

    public Graph getGraph() {
        return graph;
    }
}