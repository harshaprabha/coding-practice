package problems.graphs;

import java.util.LinkedList;
import java.util.Queue;

public class ValidPath {

  public static void main(String[] args) {
    int x = 4;
    int y = 4;
    int N = 2;
    int R = 1;
    int[] X = {2, 1};
    int[] Y = {2, 3};
    System.out.println(new ValidPath().solve(x, y, N, R, X, Y));
  }

  public String solve(int x, int y, int N, int R, int[] X, int[] Y) {

    int[][] valid = new int[x + 1][y + 1];
    valid = computeValidMatrix(valid, X, Y, N, R);
    if (valid[0][0] == -1 || valid[x][y] == -1) {
      return "NO";
    }
    return bfs(valid);

  }


  int[][] computeValidMatrix(int[][] valid, int[] X, int[] Y, int N, int R) {

    int row = valid.length;
    int col = valid[0].length;

    //O(N*R*R)
    for (int a = 0; a < N; a++) {
      for (int i = -R; i <= R; i++) {
        for (int j = -R; j <= R; j++) {
          int x1 = X[a] + i;
          int y1 = Y[a] + j;
          if (x1 >= 0 && x1 < row && y1 >= 0 && y1 < col) {
            valid[x1][y1] = -1;
          }
        }
      }

    }
    return valid;

  }

  class Pair {

    int x;
    int y;

    Pair(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }

  String bfs(int[][] rect) {

    Queue<Pair> queue = new LinkedList<>();
    int row = rect.length;
    int col = rect[0].length;
    boolean visited[][] = new boolean[row][col];

    queue.add(new Pair(0, 0));
    visited[0][0] = true;

    while (!queue.isEmpty()) {
      Pair pair = queue.remove();

      for (int i = -1; i <= 1; i++) {
        for (int j = -1; j <= 1; j++) {
          int x1 = pair.x + i;
          int y1 = pair.y + j;

          if (x1 >= 0 && x1 < row && y1 >= 0 && y1 < col && !visited[x1][y1]
              && rect[x1][y1] != -1) {
            if (x1 == row - 1 && y1 == col - 1) {
              return "YES";
            }
            visited[x1][y1] = true;
            queue.add(new Pair(x1, y1));
          }
        }
      }//for


    } //while

    return "NO";

  }

}
