package problems.graphs;

import java.util.Iterator;
import java.util.LinkedList;
import problems.graphs.WeightedGraph.EdgeNode;


public class FloydWarshallAlgo {


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
    new FloydWarshallAlgo().floydAlgorithm(0, graph.V, graph);

  }


  void floydAlgorithm(int vertex, int V, WeightedGraph graph) {

    int weight[][] = new int[V][V];
    int path[][] = new int[V][V];

    // initialize weight matrix

    for (int r = 0; r < V; r++) {
      for (int c = 0; c < V; c++) {
        weight[r][c] = Integer.MAX_VALUE;
      }

    }

    int l = 0;
    for (LinkedList<EdgeNode> list : graph.adjList) {
      Iterator<EdgeNode> itr = list.iterator();

      while (itr.hasNext()) {
        EdgeNode node = itr.next();
        weight[l][node.vertex] = node.weight;
      }
      l++;
    }//for

    for (int k = 0; k < V; k++) {
      for (int i = 0; i < V; i++) {
        for (int j = 0; j < V; j++) {
          if (weight[k][j] == Integer.MAX_VALUE || weight[i][k] == Integer.MAX_VALUE) {
            continue;
          }
          weight[i][j] = Math.min(weight[i][j], weight[i][k] + weight[k][j]);

        }
      }
    }

    for (int r = 0; r < V; r++) {
      for (int c = 0; c < V; c++) {
        if (weight[r][c] == Integer.MAX_VALUE) {
          System.out.print("I" + " ");
        } else {
          System.out.print(weight[r][c] + " ");
        }
      }
      System.out.println();

    }


  }

}
