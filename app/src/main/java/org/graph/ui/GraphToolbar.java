package org.graph.ui;

import javafx.scene.control.Button;
import javafx.scene.control.ToolBar;

import org.graph.entities.EdgeEntity;
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
        NodeEntity node = new NodeEntity("v_" + nodeIndex);
        model.addNode(node);
    }

    private void addEdge() {
        edgeIndex++;

        EdgeEntity edge = new EdgeEntity("e_" + edgeIndex, "v_1", "v_2");
        model.addEdge(edge);
    }
}