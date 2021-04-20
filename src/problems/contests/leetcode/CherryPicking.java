package problems.contests.leetcode;

public class CherryPicking {

  boolean firstRun;
  int max = Integer.MIN_VALUE;
  int[][] grid;

  public static void main(String[] args) {

    int[][] grid = {{
        1, 1, 1, 1, 0, 0, 0}, {0, 0, 0, 1, 0, 0, 0}, {0, 0, 0, 1, 0, 0, 1}, {1, 0, 0, 1, 0, 0, 0},
        {0, 0, 0, 1, 0, 0, 0}, {0, 0, 0, 1, 0, 0, 0}, {0, 0, 0, 1, 1, 1, 1}};

    System.out.println(new CherryPicking().cherryPickup(grid));

  }

  public int cherryPickup(int[][] grid1) {

    int N = grid1.length;
    firstRun = true;

    if (grid1[N - 1][N - 1] == -1) {
      return 0;
    }

    grid = new int[N][N];
    grid = grid1;

    cherryCount(0, 0, N, 0);
    return max;
  }

  void cherryCount(int i, int j, int N, int count) {

    if (grid[i][j] == -1) {
      return;
    }
    boolean isCherryPresent = grid[i][j] == 1 ? true : false;

    if (isCherryPresent) {
      count += grid[i][j]; //collect cherries if any
      grid[i][j] = 0;
    }

    if (i == N - 1 && j == N - 1 && grid[i][j] != -1 && firstRun) {
      firstRun = false;
    }

    if (i == 0 && j == 0 && grid[i][j] != -1 && !firstRun) {
      max = Math.max(max, count);
      return;
    }

    if (firstRun) {
      // right and down
      if (j + 1 < N) {
        cherryCount(i, j + 1, N, count);
      }
      if (i + 1 < N) {
        cherryCount(i + 1, j, N, count);
      }
    } else {
      // left and top
      if (j - 1 >= 0) {
        cherryCount(i, j - 1, N, count);
      }
      if (i - 1 >= 0) {
        cherryCount(i - 1, j, N, count);
      }
    }

    if (isCherryPresent) {
      grid[i][j] = 1;
    }

  }

}
