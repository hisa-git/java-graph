package org.graph.ui;

import java.util.Random;
import java.awt.Color;

import javafx.scene.control.Button;
import javafx.scene.control.ToolBar;

import org.graph.entities.Edge;
import org.graph.entities.GraphModel;
import org.graph.entities.NodeEntity;

public class GraphToolbar extends ToolBar {

    private final GraphModel model;

    private int nodeIndex = 0;
    private int edgeIndex = 0;

    public GraphToolbar(GraphModel model) {
        this.model = model;

        Button addNodeButton = new Button("Добавить точку");
        addNodeButton.setOnAction(e -> addNode());

        Button addEdgeButton = new Button("Добавить связь");
        addEdgeButton.setOnAction(e -> addEdge());

        getItems().addAll(addEdgeButton, addNodeButton);
    }

    private void addNode() {
        nodeIndex++;
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

        NodeEntity node = new NodeEntity("v_" + nodeIndex, cssColor);
        model.addNode(node);
    }

    private void addEdge() {
        edgeIndex++;

        Edge edge = new Edge("e_" + edgeIndex, "v_1", "v_2");
        model.addEdge(edge);
    }
}