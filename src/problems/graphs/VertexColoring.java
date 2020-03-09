package problems.graphs;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class VertexColoring {

  public static void main(String[] args) {

    Graph graph = new Graph(5);
    graph.addEdge(0, 1);
    graph.addEdge(1, 0);
    graph.addEdge(0, 2);
    graph.addEdge(2, 0);
    graph.addEdge(0, 3);
    graph.addEdge(2, 3);
    graph.addEdge(3, 2);
    graph.addEdge(3, 0);
    graph.addEdge(1, 4);
    graph.addEdge(4, 1);

    int count = 0;
    new VertexColoring().colorVertex(graph);

  }

  public void colorVertex(Graph g) {

    boolean visited[] = new boolean[g.V];
    int color[] = new int[g.V];
    Arrays.fill(color, -1);
    visited[0] = true;
    color[0] = 0;

    Queue<Integer> queue = new LinkedList<>();
    ((LinkedList<Integer>) queue).add(0);

    while (!queue.isEmpty()) {

      int ele = queue.remove();
      LinkedList<Integer> list = g.adjLists[ele];
      Iterator<Integer> iterator = list.iterator();

      while (iterator.hasNext()) {
        int vertex = iterator.next();

        if (color[vertex] == color[ele]) {
          System.out.println("non bipartite");
          return;
        }

        if (!visited[vertex] && color[vertex] == -1) {
          visited[vertex] = true;
          color[vertex] = color[ele] == 0 ? 1 : 0;
          ((LinkedList<Integer>) queue).add(vertex);
        }

      }

    }


  }


}
