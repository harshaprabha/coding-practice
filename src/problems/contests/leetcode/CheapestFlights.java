package problems.contests.leetcode;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class CheapestFlights {


  public static void main(String[] args) {
    int[][] arr = {{0, 1, 100}, {1, 2, 100}, {0, 2, 500}};
    System.out.println(new CheapestFlights().findCheapestPrice(3, arr, 0, 2, 0));
  }

  class EdgeNode {

    int v;
    int w;
    int k;

    EdgeNode(int v, int w, int k) {
      this.v = v;
      this.w = w;
      this.k = k;
    }
  }

  LinkedList<EdgeNode> adjList[];

  public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
    int row = flights.length;
    adjList = new LinkedList[n];
    // Load to adjacency list
    for (int i = 0; i < n; i++) {
      adjList[i] = new LinkedList<>();
    }

    for (int i = 0; i < row; i++) {
      adjList[flights[i][0]].add(new EdgeNode(flights[i][1], flights[i][2], 0));
    }

    int min = Integer.MAX_VALUE;
    Queue<EdgeNode> queue = new LinkedList<>();

    queue.add(new EdgeNode(src, 0, K));
    int stop = 0;
    while (!queue.isEmpty() && stop <= K + 1) {

      EdgeNode node = queue.remove();
      if (node.v == dst) {
        min = Math.min(min, node.w);
        continue;
      }

      Iterator<EdgeNode> itr = adjList[node.v].iterator();
      while (itr.hasNext()) {
        EdgeNode adjNode = itr.next();
        queue.add(new EdgeNode(adjNode.v, node.w + adjNode.w, node.k - 1));
      }
      stop++;
    }//while

    return min == Integer.MAX_VALUE ? -1 : min;
  }

}


