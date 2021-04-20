package problems.graphs.practice;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import javafx.util.Pair;

public class ShortestDistanceFromAllBuildings {

  public static void main(String[] args) {
    int[][] A = {{0, 1, 0}, {2, 0, 0}, {1, 0, 0}};
    System.out.println(new ShortestDistanceFromAllBuildings().shortestDistance(A));
  }

  class QEntry {

    int x;
    int y;
    int dist;
    HashSet<Pair<Integer, Integer>> set;

    QEntry(int x, int y, int d, HashSet<Pair<Integer, Integer>> s) {
      this.x = x;
      this.y = y;
      this.dist = d;
      this.set = new HashSet<>();
      this.set.addAll(s);
    }

  }


  public int shortestDistance(int[][] grid) {
    int m = grid.length;
    int mindist = Integer.MAX_VALUE;

    if (m == 0) {
      return 0;
    }

    int n = grid[0].length;
    int[][] dist = new int[m][n];

    Queue<QEntry> queue = new LinkedList<>();

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (grid[i][j] == 1) {
          queue.add(new QEntry(i, j, 0, new HashSet<>()));
        }
      }
    }

    // BFS

    int X[] = {0, 0, 1, -1};
    int Y[] = {1, -1, 0, 0};

    while (!queue.isEmpty()) {
      QEntry entry = queue.remove();

      dist[entry.x][entry.y] += entry.dist;

      List<QEntry> entries = new ArrayList<>();

      for (int k = 0; k < 4; k++) {
        int x = X[k] + entry.x;
        int y = Y[k] + entry.y;
        if (x >= 0 && y >= 0 && x < m && y < n && grid[x][y] == 0 && !entry.set
            .contains(new Pair<Integer, Integer>(x, y))) {
          entry.set.add(new Pair<>(x, y));
          queue.add(new QEntry(x, y, entry.dist + 1, entry.set));
        }
      }


    }//while

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {

        if (grid[i][j] == 0) {
          mindist = Math.min(mindist, dist[i][j]);
        }

      }
    }

    return mindist == Integer.MAX_VALUE ? -1 : mindist;
  }

}
