package org.graph.ui;

import javafx.scene.control.Button;
import javafx.scene.control.ToolBar;

public class GraphToolbar extends ToolBar {

    public GraphToolbar() {
        Button add = new Button("Добавить");
        Button remove = new Button("Удалить");

        getItems().addAll(add, remove);
    }
}