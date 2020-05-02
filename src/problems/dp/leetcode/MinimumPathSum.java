package problems.dp.leetcode;

import java.util.Arrays;

public class MinimumPathSum {


  public static void main(String[] args) {
    int grid[][] = {{}};
    System.out.println(new MinimumPathSum().minPathSum(grid));
  }


  public int minPathSum(int[][] grid) {

    int m = grid.length;
    if (m == 0) {
      return 0;
    }
    int n = grid[0].length;
    if (n == 0) {
      return 0;
    }
    if (m == 1 && n == 1) {
      return grid[0][0];
    }

    for (int i = 1; i < n; i++) {
      grid[0][i] = grid[0][i - 1] + grid[0][i];
    }

    for (int j = 1; j < m; j++) {
      grid[j][0] = grid[j][0] + grid[j - 1][0];
    }

    for (int p = 1; p < m; p++) {
      for (int q = 1; q < n; q++) {
        grid[p][q] = grid[p][q] + Math.min(grid[p - 1][q], grid[p][q - 1]);
      }
    }

    return grid[m - 1][n - 1];
  }

}
