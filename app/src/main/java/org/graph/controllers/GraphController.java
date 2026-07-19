package org.graph.controllers;

import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;

import org.graphstream.ui.view.ViewerListener;
import org.graphstream.ui.view.ViewerPipe;
import org.graphstream.ui.fx_viewer.FxViewer;

public class GraphController implements ViewerListener {

    private final Graph graph;
    private final ViewerPipe pipe;

    public GraphController(Graph graph, FxViewer viewer) {
        this.graph = graph;

        pipe = viewer.newViewerPipe();
        pipe.addAttributeSink(graph);
        pipe.addViewerListener(this);
    }

    public void update() {
        pipe.pump();
    }

    @Override
    public void buttonPushed(String id) {
        Node node = graph.getNode(id);
        System.out.println("Нажато" + node.getId());
    }

    @Override
    public void buttonReleased(String id) {
    }

    @Override
    public void viewClosed(String id) {
    }

    @Override
    public void mouseOver(String id) {
    }

    @Override
    public void mouseLeft(String id) {
    }
}