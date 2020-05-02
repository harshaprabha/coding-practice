package problems.graphs;

public class DFSDetailed {

  static int state[];
  static int time = 0;
  static int[] entry;
  static int[] exit;
  static int[] parent;
  static int[] reachable_ancestor;
  static int[] tree_out_degree;

  public static void main(String[] args) {

    Graph graph = new Graph(4);
    graph.addEdge(0, 1);
    graph.addEdge(1, 2);
    graph.addEdge(3, 1);
    graph.addEdge(2, 3);
    state = new int[graph.V];
    entry = new int[graph.V];
    exit = new int[graph.V];
    parent = new int[graph.V];
    reachable_ancestor = new int[graph.V];
    tree_out_degree = new int[graph.V];
    parent[0] = -1;
    new DFSDetailed().dfsWithTime(0, graph);

    printResults(graph.V);

  }

  static void printResults(int V) {
    System.out.println("Parent");
    for (int i = 0; i < V; i++) {
      System.out.print(parent[i] + " ");
    }
    System.out.println("\nEntry");
    for (int i = 0; i < V; i++) {
      System.out.print(entry[i] + " ");
    }
    System.out.println("\nExit");
    for (int i = 0; i < V; i++) {
      System.out.print(exit[i] + " ");
    }
    System.out.println("\nState");
    for (int i = 0; i < V; i++) {
      System.out.print(state[i] + " ");
    }
  }

  /**
   * With entry and exit times
   */
  public void dfsWithTime(int vertex, Graph g) {

    state[vertex] = 1; // discovered
    time = time + 1;
    entry[vertex] = time;

    processVertexEarly(vertex);

    for (Integer adjvertex : g.adjLists[vertex]) {

      // Process Edge
      processEdge(vertex, adjvertex);

      if (state[adjvertex] != 1) { // if not discovered
        parent[adjvertex] = vertex;  // store parent of vertex
        dfsWithTime(adjvertex, g);
      }
    }

    processVertexLate(vertex);

    state[vertex] = 2;//processed
    time = time + 1;
    exit[vertex] = time;

  }


  void processEdge(int u, int v) {

    String edgeClass = getEdgeClassification(u, v);

    if (edgeClass.equals("TREE")) {
      tree_out_degree[u] = tree_out_degree[u] + 1;
    }

    if (edgeClass.equals("BACK") && parent[u] != v) {
      if (entry[v] < entry[reachable_ancestor[u]]) {
        reachable_ancestor[u] = v;
      }
    }

  }

  void processVertexEarly(int u) {
    reachable_ancestor[u] = u;
  }

  void processVertexLate(int u) {
    reachable_ancestor[u] = u;
  }

  String getEdgeClassification(int u, int v) {

    //Tree Edge
    if (parent[v] == u) {
      System.out.println("Tree Edge");
      return "TREE";
    }

    //Back Edge
    if (state[v] == 1) {
      System.out.println("Back edge");
      return "BACK";
    }

    //Forward Edge
    if (state[v] == 2 && entry[u] < entry[v]) {
      System.out.println("Forward Edge");
      return "FORWARD";
    }
    //Cross Edge  - unrelated vertices
    if (state[v] == 2 && entry[u] > entry[v]) {
      System.out.println("Cross Edge");
      return "CROSS";
    }

    return "";
  }


}
