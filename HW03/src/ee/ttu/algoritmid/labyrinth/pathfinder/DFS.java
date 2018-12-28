package ee.ttu.algoritmid.labyrinth.pathfinder;

import ee.ttu.algoritmid.labyrinth.graph.Edge;
import ee.ttu.algoritmid.labyrinth.graph.Graph;
import ee.ttu.algoritmid.labyrinth.graph.Vertex;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DFS {

    private Graph graph;

    public DFS(Graph graph) {
        this.graph = graph;
    }

    private List<Vertex> getNeighbourVertices(Vertex vertex) {
        List<Edge> edges = graph.getGraph().get(vertex);
        List<Vertex> neighbourVertices = new ArrayList<>();

        for (Edge edge : edges) {
            if (!edge.getVertex1().equals(vertex)) {
                neighbourVertices.add(edge.getVertex1());
            }

            if (!edge.getVertex2().equals(vertex)) {
                neighbourVertices.add(edge.getVertex2());
            }
        }

        return neighbourVertices;
    }

    private void visit(Vertex currentVertex, List<Vertex> current, List<Vertex> visited) {
        current.add(currentVertex);
        List<Vertex> neighbourVertices = getNeighbourVertices(currentVertex);

        for (Vertex neighbourVertex : neighbourVertices) {
            if (!visited.contains(neighbourVertex)) {
                visited.add(currentVertex);
                visit(neighbourVertex, current, visited);
            }
        }

        visited.add(currentVertex);

    }

    public void getPreOrder() {
        List<Vertex> current = new ArrayList<>();
        List<Vertex> visited = new ArrayList<>();

        for (Map.Entry<Vertex, List<Edge>> currentVertex : graph.getGraph().entrySet()) {
            if (!visited.contains(currentVertex.getKey())) {
                visit(currentVertex.getKey(), current, visited);
            }
        }

        System.out.println(current);
    }
}
