package org.graph;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import org.graphstream.graph.Graph;
import org.graphstream.ui.fx_viewer.FxViewPanel;
import org.graphstream.ui.fx_viewer.FxViewer;
import org.graphstream.ui.view.Viewer;

import org.graph.ui.GraphToolbar;
import org.graph.view.GraphView;

public class App extends Application {

    @Override
    public void start(Stage stage) {
        GraphView graphView = new GraphView();
        Graph graph = graphView.getGraph();

        graph.setAttribute("ui.stylesheet",
                "node {" +
                        "   fill-color: #4c87af;" +
                        "   size: 20px;" +
                        "   text-size: 18;" +
                        "}" +
                        "edge {" +
                        "   fill-color: gray;" +
                        "}");

        FxViewer viewer = new FxViewer(graph, Viewer.ThreadingModel.GRAPH_IN_GUI_THREAD);
        viewer.enableAutoLayout();

        FxViewPanel view = (FxViewPanel) viewer.addDefaultView(false);
        ToolBar toolBar = new GraphToolbar();
        BorderPane root = new BorderPane();
        root.setCenter(view);
        root.setTop(toolBar);
        Scene scene = new Scene(root, 1000, 700);

        stage.setTitle("Графовый визуализатор");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}