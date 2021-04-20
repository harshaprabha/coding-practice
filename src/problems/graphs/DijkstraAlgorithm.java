package problems.graphs;

import problems.graphs.WeightedGraph.EdgeNode;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class DijkstraAlgorithm {

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

        // new PrimAlgorithm().prim(0, graph.V, graph);
        new DijkstraAlgorithm().dijkstraAlgorithmOptimal(0, graph.V, graph);

    }


    void dijkstraAlgorithmOptimal(int vertex, int V, WeightedGraph graph) {
        Set<Integer> visited = new HashSet<>();
        int[] distance = new int[V]; // cost to be paid to be added in MST
        int[] parent = new int[V];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        //Initialize starting vertex
        for (int i = 0; i < V; i++) {
            distance[i] = i == vertex ? 0 : Integer.MAX_VALUE;
            parent[i] = -1;
            pq.add(new int[]{i, distance[i]});
        }

        // Add a single vertex in every iteration
        while (visited.size() < V) { // O(V)
            int minVertex = pq.poll()[0]; // logV
            visited.add(minVertex);

            //O(ElogV)
            for (EdgeNode edgeNode : graph.adjList[minVertex]) {
              //  V,V-1,V-2,...1 vertex eligible for loop
                if (!visited.contains(edgeNode.vertex) && distance[minVertex] + edgeNode.weight < distance[edgeNode.vertex]) {
                    //relax
                    // Don't remove just add as duplicate data will be polled as this condition will fail of non min values
                    //- pq.remove(new int[]{edgeNode.vertex, distance[edgeNode.vertex]}); // O(V) + logV
                    distance[edgeNode.vertex] = distance[minVertex] + edgeNode.weight;
                    parent[edgeNode.vertex] = parent[minVertex];
                    pq.add(new int[]{edgeNode.vertex, distance[edgeNode.vertex]}); // log V
                }
            }


        }
        for (int i = 0; i < V; i++) {
            System.out.print(distance[i] + " ");
        }
    }


    // O(V*V)
    void dijkstraAlgorithm(int vertex, int V, WeightedGraph graph) {

        boolean[] intree = new boolean[V]; // all vertices inside spanning tree

        int[] distance = new int[V]; // cost to be paid to be added in MST
        int[] parent = new int[V];

        int dist = 0;

        //Initialize starting vertex
        for (int i = 0; i < V; i++) {
            intree[i] = false;
            distance[i] = Integer.MAX_VALUE;
            parent[i] = -1;
        }

        //Start vertex
        distance[vertex] = 0;
        int nextVertex = 1;
        // Add a single vertex in every iteration
        while (!intree[vertex]) { // O(V)

            intree[vertex] = true;

            System.out.println(vertex);
            for (EdgeNode edge : graph.adjList[vertex]) {
                //Step 1 - Update the distance of all vertices adjacent to current vertex - O(V) not E

                if (distance[edge.vertex] > edge.weight + distance[vertex]
                        && !intree[edge.vertex]) {
                    parent[edge.vertex] = vertex;
                    distance[edge.vertex] = edge.weight + distance[vertex];
                }

                //Step 2 - Pick edge with minimum distance among all nodes not in minimum spanning tree - O(V)
                nextVertex = 1;
                int minDist = Integer.MAX_VALUE;

                // This will automatically pick ones relaxed as others have distance infinity
                for (int i = 0; i < graph.V; i++) {
                    if (!intree[i] && distance[i] < minDist) {
                        minDist = distance[i];
                        nextVertex = i;
                    }
                }


            }
            vertex = nextVertex;

        }

        findPathFromSourceToVertex(parent);

        for (int i = 0; i < intree.length; i++) {
            System.out.print(intree[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < V; i++) {
            System.out.print(distance[i] + " ");
        }

        System.out.println("Overall distance= " + dist);


    }


    void findPathFromSourceToVertex(int[] parent) {

        System.out.println("Path");
        int target = 3;
        int source = 0;
        int i = 3;
        while (i != 0) {
            System.out.println(i);
            i = parent[i];
        }


    }


}
