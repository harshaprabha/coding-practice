package problems.graphs;


public class DetectCycleInDirectedGraph {

  static boolean discovered[];
  static boolean processed[];

  public static void main(String[] args) {
    Graph graph = new Graph(4);
    graph.addEdge(0, 1);
    graph.addEdge(0, 2);
    graph.addEdge(2, 3);

    discovered = new boolean[4];
    processed = new boolean[4];

    discovered[0] = true;

    System.out.println(detectCycle(0, graph));
  }

  /**
   * Going back to ancestor vertex u from v=> cycle
   */

  static boolean detectCycle(int vertex, Graph graph) {

    for (Integer adjVertex : graph.adjLists[vertex]) {

      if (discovered[adjVertex] && !processed[adjVertex]) {
        return true;
      }

      if (!discovered[adjVertex]) {
        discovered[adjVertex] = true;
        if (detectCycle(adjVertex, graph)) {
          return true;
        }
      }


    }

    processed[vertex] = true;

    return false;
  }

}
