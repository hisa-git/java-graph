package org.graph.ui;

import org.graph.entities.GraphModel;

import javafx.scene.control.Button;
import javafx.scene.control.ToolBar;

import org.graph.entities.Node;
import org.graph.entities.Edge;

public class GraphToolbar extends ToolBar {

    public GraphToolbar() {
        Button addNodeButton = new Button("Добавить точку");
        addNodeButton.setOnAction(e -> {
            addNode();
        });
        Button addEdgeButton = new Button("Добавить связь");
        addEdgeButton.setOnAction(e -> {
            addEdge();
        });
        getItems().addAll(addEdgeButton, addNodeButton);
    }

    private void addNode() {
        Node node = new Node("v_1", "red");
        GraphModel.addNode(node);
    }

    private void addEdge() {
        Edge edge = new Edge("e_1", "v_1", "v_2");
        GraphModel.addEdge(edge);
    }
}