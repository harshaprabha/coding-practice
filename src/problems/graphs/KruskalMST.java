package problems.graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import javafx.util.Pair;
import problems.graphs.WeightedGraph.EdgeNode;

public class KruskalMST {

  public static void main(String[] args) {
    Queue<Pair<String, Integer>> queue = new LinkedList<>();

    WeightedGraph graph = new WeightedGraph(5);
    graph.addEdge(0, 1, 10);

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
    new KruskalMST().kruskal(0, graph.V, graph);
  }

  class Edge {

    int src;
    int destn;
    int weight;

    public Edge(int s, int d, int w) {
      this.src = s;
      this.destn = d;
      this.weight = w;
    }
  }

  void kruskal(int vertex, int V, WeightedGraph graph) {
    int mst = 0;
    Set<Edge> mstEdges = new HashSet<>();
    //Sort all edges
    UnionFind unionFind = new UnionFind(graph.V);
    List<Edge> edgeList = new ArrayList<>();
    for (int i = 0; i < graph.V; i++) {

      for (EdgeNode edge : graph.adjList[i]) {
        edgeList.add(new Edge(i, edge.vertex, edge.weight));
      }
    }//for

    Collections.sort(edgeList, new Comparator<Edge>() {
      @Override
      public int compare(Edge o1, Edge o2) {
        return o1.weight - o2.weight;
      }
    });

    //Pick smallest edge and add as long as it doesnt create cycle
    for (Edge edge : edgeList) { //ElogV
      int from = unionFind.find(edge.src); // logn
      int to = unionFind.find(edge.destn); //logn
      if (from == to) {
        continue; // forms cycle and hence dont add
      }

      mst += edge.weight;
      mstEdges.add(edge);
      unionFind.union(from, to);

    }
    System.out.println("Total path = " + mst);
    System.out.println(mstEdges);
  }

}
