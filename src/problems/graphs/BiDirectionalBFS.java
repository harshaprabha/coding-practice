package problems.graphs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class BiDirectionalBFS {

  class Node {

    int x;
    int y;
    int dist;

    public Node(int x, int y, int dist) {
      this.x = x;
      this.y = y;
      this.dist = dist;
    }

    @Override
    public boolean equals(Object obj) {
      Node n = (Node) obj;
      return this.x == n.x && this.y == n.y;
    }

  }

  class Pair {

    int x;
    int y;

    public Pair(int x, int y) {
      this.x = x;
      this.y = y;

    }

    @Override
    public boolean equals(Object obj) {
      Pair n = (Pair) obj;
      return this.x == n.x && this.y == n.y;
    }

    @Override
    public int hashCode() {
      int x = Math.abs(this.x);
      int y = Math.abs(this.y);
      return x + y;
    }
  }

  public static void main(String[] args) {

    new BiDirectionalBFS().bfs();

  }

  public void bfs() {
    // Q1 and Q2
    Queue<Node> sourceQueue = new LinkedList<>();
    Queue<Node> targetQueue = new LinkedList<>();

    Map<Pair, Integer> sourceVisited = new HashMap<>();
    Map<Pair, Integer> targetVisited = new HashMap<>();

    sourceQueue.add(new Node(0, 0, 0));
    targetQueue.add(new Node(5, 5, 0));

    sourceVisited.put(new Pair(0, 0), 0);
    targetVisited.put(new Pair(5, 5), 0);

    int X[] = {2, 2, -2, -2, 1, -1, 1, -1};
    int Y[] = {1, -1, 1, -1, 2, 2, -2, -2};
    int ans = 0;
    boolean found = false;

    while (!sourceQueue.isEmpty() || !targetQueue.isEmpty()) {

      if (!sourceQueue.isEmpty()) {
        Node ele = sourceQueue.remove();
        for (int k = 0; k < 8; k++) {
          int i = X[k] + ele.x;
          int j = Y[k] + ele.y;

          Pair visitedpair = new Pair(i, j);
          if (!sourceVisited.containsKey(visitedpair)) {
            if (targetVisited.containsKey(visitedpair)) {
              //
              found = true;
              ans = targetVisited.get(visitedpair) + ele.dist + 1;
              break;
            } else {
              sourceVisited.put(visitedpair, ele.dist + 1);
              ((LinkedList<Node>) sourceQueue).add(new Node(i, j, ele.dist + 1));
            }
          }


        }//for

      }

      if (found) {
        break;
      }

      if (!targetQueue.isEmpty()) {
        Node ele = targetQueue.remove();
        for (int k = 0; k < 8; k++) {
          int i = X[k] + ele.x;
          int j = Y[k] + ele.y;

          Pair visitedpair = new Pair(i, j);
          if (!targetVisited.containsKey(visitedpair)) {
            if (sourceVisited.containsKey(visitedpair)) {
              //
              ans = sourceVisited.get(visitedpair) + ele.dist + 1;
              found = true;
              break;
            } else {
              targetVisited.put(visitedpair, ele.dist + 1);
              ((LinkedList<Node>) targetQueue).add(new Node(i, j, ele.dist + 1));
            }
          }


        }//for

      }
      if (found) {
        break;
      }


    }

    System.out.println(ans);
  }

}
