package problems.graphs;

public class CycleDetectionInUndirectedGraph {

  static boolean[] visited;

  public static void main(String[] args) {

    Graph graph = new Graph(6);
    graph.addEdge(0, 1);
    graph.addEdge(1, 0);
    graph.addEdge(0, 2);
    graph.addEdge(2, 0);
    graph.addEdge(2, 3);
    graph.addEdge(3, 2);

    visited = new boolean[4];
    visited[0] = true;
    System.out.println(detectCycle(0, graph, -1));
  }

  /**
   * Modified DFS with parent - O(V+E)
   */
  static boolean detectCycle(int vertex, Graph graph, int parent) {

    for (Integer adjvertex : graph.adjLists[vertex]) {
      if (visited[adjvertex] && adjvertex != parent) {
        return true;
      }

      if (!visited[adjvertex]) {
        visited[adjvertex] = true;
        if (detectCycle(adjvertex, graph, vertex)) {
          return true;
        }
      }
    }

    return false;
  }


}
