package problems.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {

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
    System.out.println(new BFS().getConnectedComponents(graph));

  }

  int getConnectedComponents(Graph g) {
    int count = 0;
    boolean visited[] = new boolean[g.V];
    Arrays.fill(visited, false);
    for (int i = 0; i < g.V; i++) {
      if (!visited[i]) {
        count += 1;
        bfs(g, i, visited);
      }

    }
    return count;

  }

  static void bfs(Graph g, int start, boolean visited[]) {

    Queue<Integer> queue = new LinkedList<>();
    int parent[] = new int[g.V];
    Arrays.fill(parent, -1);

    visited[start] = true;
    ((LinkedList<Integer>) queue).add(start);
    ((LinkedList<Integer>) queue).add(-1);
    String level = "";
    int prev = -1;
    while (!queue.isEmpty()) {

      int ele = queue.remove();
      if (ele == -1 && prev == -1) {
        break;
      }
      prev = ele;

      if (ele == -1) {
        // System.out.println(level);
        level = "";
        //System.out.println("____________");
        ((LinkedList<Integer>) queue).add(-1);
        continue;
      } else {
        level = level + ele;
      }

      Iterator<Integer> iterator = g.adjLists[ele].listIterator();

      while (iterator.hasNext()) {
        int item = iterator.next();
        if (!visited[item]) {
          parent[item] = ele;
          visited[item] = true;
          ((LinkedList<Integer>) queue).add(item);

        }//if


      }
    }//while

  }

}
