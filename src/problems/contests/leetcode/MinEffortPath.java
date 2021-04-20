package problems.contests.leetcode;

public class MinEffortPath {

  public static void main(String[] args) {
    int A[][] = {{1, 2, 2}, {3, 8, 2}, {5, 3, 5}};
    System.out.println(new MinEffortPath().minimumEffortPath(A));
  }

  boolean[][] visited;

  public int minimumEffortPath(int[][] heights) {

    int m = heights.length;
    int n = heights[0].length;

    if (m == 1 && n == 1) {
      return 0;
    }
    visited = new boolean[m][n];
    int low = 0;
    int high = 8;

    int ans = high;
    while (low <= high) {
      int mid = (low + high) / 2;
      System.out.println("mid= " + mid);

      boolean exists = checkIfPathExists(0, 0, heights, mid);
      for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
          System.out.print(visited[i][j] + " ");
        }
        System.out.println();
      }
      if (exists) {
        ans = mid;
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }//while

    return ans;
  }

  // DFS
  boolean checkIfPathExists(int i, int j, int[][] heights, int midMax) {

    if (i == heights.length - 1 && j == heights[0].length - 1) {
      return true;
    }

    visited[i][j] = true;

    int[] X = {0, 1, 0, -1};
    int[] Y = {1, 0, -1, 0};

    for (int k = 0; k < 4; k++) {
      int x = X[k] + i;
      int y = Y[k] + j;
      if (x >= 0 && x < heights.length && y >= 0 && y < heights[0].length && !visited[x][y]
          && Math.abs(heights[i][j] - heights[x][y]) <= midMax) {
        //System.out.println("max= "+Math.abs(heights[i][j]-heights[x][y]));
        if (checkIfPathExists(x, y, heights, midMax)) {
          visited[i][j] = false;
          return true;
        }
      }
    }
    visited[i][j] = false;
    return false;
  }


}
