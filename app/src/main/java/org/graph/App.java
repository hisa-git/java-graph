package org.graph;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import org.graphstream.graph.Graph;
import org.graphstream.ui.fx_viewer.FxViewPanel;
import org.graphstream.ui.fx_viewer.FxViewer;
import org.graphstream.ui.view.Viewer;

import org.graph.controllers.GraphController;
import org.graph.entities.GraphModel;
import org.graph.ui.GraphToolbar;
import org.graph.view.GraphView;

public class App extends Application {

    @Override
    public void start(Stage stage) {
        GraphView graphView = new GraphView();
        Graph graph = graphView.getGraph();
        GraphModel graphModel = new GraphModel(graphView);

        FxViewer viewer = new FxViewer(graph, Viewer.ThreadingModel.GRAPH_IN_GUI_THREAD);
        viewer.enableAutoLayout();

        FxViewPanel view = (FxViewPanel) viewer.addDefaultView(false);

        GraphController controller = new GraphController(graph, viewer);

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                controller.update();
            }
        };

        timer.start();
        ToolBar toolBar = new GraphToolbar(graphModel);
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