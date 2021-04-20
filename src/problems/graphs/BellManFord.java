package problems.graphs;

import java.util.Arrays;

public class BellManFord {

    public static void main(String[] args) {
        WeightedGraph graph = new WeightedGraph(5);
        graph.addEdge(0, 1, 40);
        // graph.addEdge(1, 0, 40);  Directed graph

        graph.addEdge(1, 3, 9);
        // graph.addEdge(3, 1, 9);

        graph.addEdge(0, 2, 2);
        // graph.addEdge(2, 0, 2);

        graph.addEdge(2, 4, 2);
        // graph.addEdge(4, 2, 20);

        graph.addEdge(1, 2, 3);
        // graph.addEdge(2, 1, 3);

        graph.addEdge(2, 3, 5);
        //  graph.addEdge(3, 2, 5);

        graph.addEdge(3, 4, 11);
        //  graph.addEdge(4, 3, 11);

        double d=1.0;
        double ans= 0.5*0.5;
        System.out.println(ans);
        // new PrimAlgorithm().prim(0, graph.V, graph);
       // new BellManFord().bellmanFord(0, graph.V, graph);
    }

    void bellmanFord(int start, int V, WeightedGraph graph) {

        int[] dist = new int[V];
        int[] parent = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(parent, -1);
        boolean updated = false;

        dist[start] = 0;
        for (int i = 0; i < V; i++) {
            updated = false;
            for (WeightedGraph.Edge edge : graph.edgeList) {
                if (dist[edge.src] != Integer.MAX_VALUE && dist[edge.src] + edge.weight < dist[edge.dest]) {
                    parent[edge.dest] = edge.src;
                    dist[edge.dest] = dist[edge.src] + edge.weight;
                    updated = true;
                }
                if (!updated)
                    break; // no vertex was relaxed
            }
        }//for

        // relax one more time to check -ve cycles
        updated = false;
        for (WeightedGraph.Edge edge : graph.edgeList) {
            if (dist[edge.src] != Integer.MAX_VALUE && dist[edge.src] + edge.weight < dist[edge.dest]) {
                parent[edge.dest] = edge.src;
                dist[edge.dest] = dist[edge.src] + edge.weight;
                updated = true;
            }
            if (updated) {
                System.out.println("cycle exist");
                break;
            }

        }


    }


}
