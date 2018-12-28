package ee.ttu.algoritmid.labyrinth.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {

    private Map<Vertex, List<Edge>> graph = new HashMap<>();

    public void putVertex(Vertex vertex) {
        graph.put(vertex, new ArrayList<>());
    }

    public void putEdge(Vertex vertex, Edge edge) {
        graph.get(vertex).add(edge);
    }

    public Map<Vertex, List<Edge>> getGraph() {
        return graph;
    }
}
