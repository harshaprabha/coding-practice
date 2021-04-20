package problems.graphs;

public class CycleDetectionInUndirectedGraph {

  static boolean[] visited;
  static int parent1[];

  public static void main(String[] args) {

    Graph graph = new Graph(4);
    graph.addEdge(0, 1);
    graph.addEdge(0, 2);
    graph.addEdge(0, 3);
    //  graph.addEdge(3, 0);

    visited = new boolean[4];
    visited[0] = true;
    //System.out.println(detectCycle(0, graph, -1));
    System.out.println(detectCycleUsingUF(0, graph));
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


  /**
   * Using union-find
   */
  static boolean detectCycleUsingUF(int vertex, Graph graph) {

    int component[] = new int[graph.V];
    parent1 = new int[graph.V];

    for (int i = 0; i < graph.V; i++) {
      parent1[i] = i;
    }

    for (int j = 0; j < graph.V; j++) {
      for (Integer adj : graph.adjLists[j]) {// every edge

        //naive union
        int rep1 = find(j);
        int rep2 = find(adj);

        if (rep1 == rep2) {
          return true;
        }
        parent1[rep1] = rep2;

      }


    }

    return false;
  }

  static int find(int i) {

    if (parent1[i] == i) {
      return i;
    }

    return find(parent1[i]);
  }


}
