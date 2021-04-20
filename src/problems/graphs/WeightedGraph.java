package problems.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


class WeightedGraph {

    int V;
    int E;
    LinkedList<EdgeNode> adjList[];
    List<Edge> edgeList;

    public WeightedGraph(int v) {
        this.V = v;
        this.adjList = new LinkedList[v];
        edgeList = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adjList[i] = new LinkedList<EdgeNode>();
        }
    }

    class Edge {
        int src;
        int weight;
        int dest;

        public Edge(int src, int w, int d) {
            this.src = src;
            this.weight = w;
            this.dest = d;
        }
    }

    class EdgeNode {

        int vertex;
        int weight;

        public EdgeNode(int v, int w) {
            this.vertex = v;
            this.weight = w;
        }

    }


    public void addEdge(int startVertex, int endVertex, int weight) {
        E++;
        edgeList.add(new Edge(startVertex, weight, endVertex));
        adjList[startVertex].add(new EdgeNode(endVertex, weight));
    }
}