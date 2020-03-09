package problems.graphs;

import java.util.Iterator;
import java.util.Stack;

public class DFS {

  public static void main(String[] args) {

    Graph graph = new Graph(6);
    graph.addEdge(0, 1);
    graph.addEdge(1, 0);
    graph.addEdge(0, 2);
    graph.addEdge(2, 0);
    graph.addEdge(1, 2);
    graph.addEdge(2, 1);
    graph.addEdge(2, 3);
    graph.addEdge(3, 2);

    int count = 0;
    new DFS().dfs(graph);
  }

  public void dfs(Graph g) {

    Stack<Integer> stack = new Stack<>();
    stack.push(0);
    boolean visited[] = new boolean[g.V];
    visited[0] = true;

    while (!stack.isEmpty()) {
      int ele = stack.pop();
      System.out.println(ele);
      Iterator<Integer> itr = g.adjLists[ele].iterator();
      while (itr.hasNext()) {
        int node = itr.next();
        if (!visited[node]) {
          visited[node] = true;
          stack.push(node);
        }

      }

    }


  }


}
