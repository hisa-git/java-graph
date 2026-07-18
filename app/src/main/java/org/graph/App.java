package org.graph;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.SingleGraph;

import org.graphstream.ui.fx_viewer.FxViewPanel;
import org.graphstream.ui.fx_viewer.FxViewer;
import org.graphstream.ui.view.Viewer;

import java.util.ArrayList;
import java.util.List;

import org.graph.entities.Node;
import org.graph.entities.Edge;

import org.graph.ui.GraphToolbar;

public class App extends Application {
    List<Node> nodeInput = new ArrayList<>();

    {
        nodeInput.add(new Node("v_1", "red"));
        nodeInput.add(new Node("v_2", "red"));
    }

    List<Edge> edgeInput = new ArrayList<>();

    {
        edgeInput.add(new Edge("e1", "v_1", "v_2"));
    }

    private void visualizeNodes(Graph graph) {
        for (Node node : nodeInput) {
            graph.addNode(node.getName());
        }
    }

    private void visualizeEdges(Graph graph) {
        for (Edge edge : edgeInput) {
            graph.addEdge(edge.getId(), edge.getNode1(), edge.getNode2());
        }
    }

    @Override
    public void start(Stage stage) {
        Graph graph = new SingleGraph("Demo");

        graph.setAttribute("ui.stylesheet",
                "node {" +
                        "   fill-color: #4c87af;" +
                        "   size: 20px;" +
                        "   text-size: 18;" +
                        "}" +
                        "edge {" +
                        "   fill-color: gray;" +
                        "}");

        visualizeNodes(graph);
        visualizeEdges(graph);
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