package problems.graphs;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * SCC check using Kosaraju's algorithm - O(V+E)
 */
public class CheckIfGraphIsStronglyConnected {

  static boolean visited[];

  public static void main(String[] args) {
    Graph graph = new Graph(4);
    graph.addEdge(0, 1);
    graph.addEdge(3, 0);
    graph.addEdge(1, 2);
    graph.addEdge(2, 3);
    graph.addEdge(3, 1);

    System.out.println(checkIfGraphIsStronglyConnected(graph));
  }


  static boolean checkIfGraphIsStronglyConnected(Graph graph) {

    visited = new boolean[graph.V];

    //Do dfs
    visited[0] = true;
    dfs(0, graph);

    //check if all vertices are visited
    for (boolean visit : visited) {
      if (!visit) {
        return false;
      }
    }

    //Get transpose of G
    Graph graphT = getTranspose(graph);

    for (int k = 0; k < graph.V; k++) {
      visited[k] = false;
    }

    dfs(0, graphT);

    //check if all vertices are visited
    for (boolean visit : visited) {
      if (!visit) {
        return false;
      }
    }

    return true;
  }


  static Graph getTranspose(Graph graph) {

    Graph graphT = new Graph(graph.V);

    for (int i = 0; i < graph.V; i++) {

      LinkedList<Integer> list = graph.adjLists[i];
      Iterator<Integer> iterator = list.iterator();

      while (iterator.hasNext()) {
        graphT.adjLists[iterator.next()].add(i);
      }

    }

    return graphT;

  }

  static void dfs(int vertex, Graph graph) {

    for (Integer adjVertex : graph.adjLists[vertex]) {
      if (!visited[adjVertex]) {
        visited[adjVertex] = true;
        dfs(adjVertex, graph);
      }
    }
  }

}
