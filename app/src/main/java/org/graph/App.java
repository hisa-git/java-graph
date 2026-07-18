package org.graph;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.SingleGraph;

import org.graphstream.ui.fx_viewer.FxViewPanel;
import org.graphstream.ui.fx_viewer.FxViewer;
import org.graphstream.ui.view.Viewer;

public class App extends Application {

    @Override
    public void start(Stage stage) {
        Graph graph = new SingleGraph("Demo");

        graph.setAttribute("ui.stylesheet",
                "node {" +
                "   fill-color: #4CAF50;" +
                "   size: 20px;" +
                "   text-size: 18;" +
                "}" +
                "edge {" +
                "   fill-color: gray;" +
                "}");

        graph.addNode("A").setAttribute("ui.label", "A");
        graph.addNode("B").setAttribute("ui.label", "B");
        graph.addNode("C").setAttribute("ui.label", "C");

        graph.addEdge("AB", "A", "B");
        graph.addEdge("BC", "B", "C");
        graph.addEdge("CA", "C", "A");

        FxViewer viewer = new FxViewer(graph, Viewer.ThreadingModel.GRAPH_IN_GUI_THREAD);
        viewer.enableAutoLayout();

        FxViewPanel view = (FxViewPanel) viewer.addDefaultView(false);

        BorderPane root = new BorderPane();
        root.setCenter(view);

        Scene scene = new Scene(root, 1000, 700);

        stage.setTitle("GraphStream");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}