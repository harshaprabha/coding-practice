package problems.graphs.practice;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import javafx.util.Pair;

public class ShortestBridge {

  public static void main(String[] args) {
    int A[][] = {{0, 1, 1, 0}, {0, 1, 0, 0}, {0, 0, 0, 0}, {1, 1, 0, 0}};

    PriorityQueue<Pair<Character,Integer>> pq= new PriorityQueue<>((a,b)->a.getValue()-b.getValue());

//        {{0, 0, 0, 0, 0, 0}, {0, 1, 0, 0, 0, 0}, {1, 1, 0, 0, 0, 0}, {1, 1, 0, 0, 0, 0},
//            {0, 0, 0, 0, 0, 0}, {0, 0, 1, 1, 0, 0}};
    // {
//        {0, 1, 0, 0, 0, 0}, {0, 1, 1, 1, 0, 0}, {0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0},
//        {0, 0, 0, 0, 0, 0}, {1, 1, 0, 0, 0, 0}};
    System.out.println(new ShortestBridge().shortestBridge(A));
  }

  boolean visited[][];
  Queue<QueueEntry> queue = new LinkedList<>();

  class QueueEntry {

    int x;
    int y;
    int hop;

    QueueEntry(int x, int y, int hop) {
      this.x = x;
      this.y = y;
      this.hop = hop;
    }
  }

  int min = 1000000;

  public int shortestBridge(int[][] A) {
    int m = A.length;

    int n = A[0].length;
    visited = new boolean[m][n];
    boolean dfs1 = false;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (A[i][j] == 1 && !dfs1) {
          dfs(i, j, A);
          // first component mark as 2
          dfs1 = true;


        }
      }
      if (dfs1) {
        break;
      }
    }//for

    for (int p = 0; p < m; p++) {
      for (int q = 0; q < n; q++) {
        System.out.print(A[p][q] + " ");
      }
      System.out.println();
    }

    bfs(A);

    return min;

  }


  void bfs(int[][] A) {
    // second component - Do BFS

    int X[] = {1, -1, 0, 0};
    int Y[] = {0, 0, 1, -1};

    while (!queue.isEmpty()) {
      QueueEntry entry = queue.remove();
      System.out.println("entry.x=" + entry.x);
      System.out.println("entry.y=" + entry.y);
      System.out.println("entry.hop=" + entry.hop);
      for (int p = 0; p < A.length; p++) {
        for (int q = 0; q < A.length; q++) {
          System.out.print(visited[p][q] + " ");
        }
        System.out.println();
      }
      if (A[entry.x][entry.y] == 1) {
        min = Math.min(min, entry.hop - 1);
        break;
      }

      for (int k = 0; k < 4; k++) {
        int x = X[k] + entry.x;
        int y = Y[k] + entry.y;

        if (x >= 0 && x < A.length && y >= 0 && y < A[0].length && !visited[x][y] && A[x][y] != 2) {
          visited[x][y] = true;
          queue.add(new QueueEntry(x, y, entry.hop + 1));
        }

      }//for


    }//while
  }

  void dfs(int i, int j, int[][] A) {

    A[i][j] = 2;
    queue.add(new QueueEntry(i, j, 0));
    visited[i][j] = true;
    int X[] = {1, -1, 0, 0};
    int Y[] = {0, 0, 1, -1};

    for (int k = 0; k < 4; k++) {
      int x = X[k] + i;
      int y = Y[k] + j;

      if (x >= 0 && x < A.length && y >= 0 && y < A[0].length && A[x][y] != 0 && !visited[x][y]) {
        dfs(x, y, A);
      }
    }
    visited[i][j] = false;

  }

}
