package problems.graphs;

import java.util.Comparator;
import java.util.PriorityQueue;
import problems.graphs.WeightedGraph.EdgeNode;

public class PrimAlgorithm {

  class ENode {

    int weight;
    int vertex;

    ENode(int v, int w) {
      this.vertex = v;
      this.weight = w;

    }

    @Override
    public boolean equals(Object obj) {
      ENode node = (ENode) obj;
      return this.weight == ((ENode) obj).weight && this.vertex == ((ENode) obj).vertex;
    }

    @Override
    public int hashCode() {
      return super.hashCode();
    }
  }

  public static void main(String[] args) {

    WeightedGraph graph = new WeightedGraph(5);
    graph.addEdge(0, 1, 40);
    // graph.addEdge(1, 0, 40);  Directed graph

    graph.addEdge(1, 3, 9);
    // graph.addEdge(3, 1, 9);

    graph.addEdge(0, 2, 2);
    // graph.addEdge(2, 0, 2);

    graph.addEdge(2, 4, 20);
    // graph.addEdge(4, 2, 20);

    graph.addEdge(1, 2, 3);
    // graph.addEdge(2, 1, 3);

    graph.addEdge(2, 3, 5);
    //  graph.addEdge(3, 2, 5);

    graph.addEdge(3, 4, 11);
    //  graph.addEdge(4, 3, 11);

    // new PrimAlgorithm().prim(0, graph.V, graph);
    new PrimAlgorithm().primPQ(0, graph.V, graph);

  }

  /**
   * Using Arrays - o(n*n)
   */
  void prim(int vertex, int V, WeightedGraph graph) {

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

    // Add a single vertex in every iteration
    while (!intree[vertex]) {
      intree[vertex] = true;
      dist += distance[vertex];
      System.out.println(vertex);
      for (EdgeNode edge : graph.adjList[vertex]) {
        //Step 1 - Update the distance of all vertices adjacent to current vertex

        if (distance[edge.vertex] > edge.weight
            && !intree[edge.vertex]) {
          parent[edge.vertex] = vertex;
          distance[edge.vertex] = edge.weight;
        }

        //Step 2 - Pick edge with minimum distance amoung all nodes not in minimum spanning tree - O(n)
        int nextVertex = 1;
        int minDist = Integer.MAX_VALUE;
        for (int i = 0; i < graph.V; i++) {

          if (intree[i] == false && distance[i] < minDist) {
            minDist = distance[i];
            nextVertex = i;
          }

        }
        vertex = nextVertex;

      }

    }

    for (int i = 0; i < intree.length; i++) {
      System.out.print(intree[i] + " ");
    }
    System.out.println();
    for (int i = 0; i < V; i++) {
      System.out.print(distance[i] + " ");
    }

    System.out.println("Overall distance= " + dist);
  }


  /**
   * Using PQ - o(V+ElogV)
   */
  void primPQ(int vertex, int V, WeightedGraph graph) {

    boolean[] intree = new boolean[V]; // all vertices inside spanning tree

    int[] distance = new int[V];  // cost to be paid to be added in MST
    ENode[] enode = new ENode[V];  // it will be V as MST will have V-1 edges since its a tree
    int[] parent = new int[V];  // it will be V as MST will have V-1 edges since its a tree

    PriorityQueue<ENode> queue = new PriorityQueue<>(new Comparator<ENode>() {
      @Override
      public int compare(ENode o1, ENode o2) {
        return o1.weight - o2.weight;
      }
    });

    int dist = 0;

    //Initialize starting vertex
    for (int i = 0; i < V; i++) {
      intree[i] = false;
      enode[i] = new ENode(i, Integer.MAX_VALUE);
    }

    //Start vertex
    distance[vertex] = 0;
    parent[0] = -1;
    enode[0].weight = 0;

    for (int i = 0; i < V; i++) {
      queue.add(enode[i]);
    }

    // Add a single vertex in every iteration
    while (!queue.isEmpty()) {

      ENode edgeNode = queue.remove(); // Pick minimum element
      intree[edgeNode.vertex] = true;
      dist += enode[edgeNode.vertex].weight;

      for (EdgeNode edge : graph.adjList[edgeNode.vertex]) {
        //Step 1 - Update the distance of all vertices adjacent to current vertex

        if (enode[edge.vertex].weight > edge.weight
            && !intree[edge.vertex]) {

          //Update weight of element in queue
          queue.remove(enode[edge.vertex]);
          enode[edge.vertex].weight = edge.weight;
          queue.add(enode[edge.vertex]);
          parent[edge.vertex] = edgeNode.vertex;

        }
      }

    }

    for (int i = 0; i < intree.length; i++) {
      System.out.print(intree[i] + " ");
    }
    System.out.println();

    for (int i = 0; i < V; i++) {
      System.out.print(enode[i].weight + " ");
    }
    System.out.println();
    for (int i = 0; i < V; i++) {
      System.out.print(parent[i] + " ");
    }

    System.out.println("Overall distance= " + dist);
  }

}
