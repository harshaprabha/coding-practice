package problems.graphs;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Kosaraju's algo - O(V+E)
 */
public class CountAllStronglyConnectedComponents {

  static boolean visited[];
  static Stack<Integer> stack = new Stack<>();

  public static void main(String[] args) {
    Graph graph = new Graph(4);
    graph.addEdge(0, 1);
    graph.addEdge(3, 1);
    graph.addEdge(1, 2);
    graph.addEdge(2, 3);
    // graph.addEdge(3, 1);

    System.out.println(countAllStronglyConnectedComponents(graph));
  }


  static int countAllStronglyConnectedComponents(Graph graph) {

    visited = new boolean[graph.V];

    dfs(0, graph);

    //Get transpose of G
    Graph graphT = getTranspose(graph);

    for (int k = 0; k < graph.V; k++) {
      visited[k] = false;
    }

    int scc = 0;
    while (!stack.isEmpty()) {
      Integer vertex = stack.pop();
      if (!visited[vertex]) {
        scc++;
        visited[vertex] = true;
        dfs(vertex, graphT);
      }

    }

    return scc;
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
    stack.push(vertex);
  }


}
