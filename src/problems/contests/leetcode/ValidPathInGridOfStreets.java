package problems.contests.leetcode;

import java.util.HashMap;
import java.util.Map;

public class ValidPathInGridOfStreets {

  public static void main(String[] args) {
    int grid[][] = {{1,1,1,1,1,1,3}};
    System.out.println(new ValidPathInGridOfStreets().hasValidPath(grid));
  }

  class Street {

    int entry;
    int exit;

    Street(int e, int exit) {
      this.entry = e;
      this.exit = exit;
    }

  }


  public boolean hasValidPath(int[][] grid) {
    int m = grid.length;
    if (m == 0) {
      return false;
    }
    int n = grid[0].length;

    if (m == 1 && n == 1) {
      return true;
    }

    if (grid[0][0] == 5) {
      return false;
    }

    Map<Integer, Street> compatible = new HashMap<>();
    compatible.put(1, new Street(0, 1));
    compatible.put(2, new Street(2, 3));
    compatible.put(3, new Street(0, 3));
    compatible.put(4, new Street(1, 3));
    compatible.put(5, new Street(0, 2));
    compatible.put(6, new Street(2, 1));

    /**
     * 0-L
     * 1-R
     * 2-T
     * 3-B
     */
    boolean visited[][][] = new boolean[m][n][4];
    visited[0][0][compatible.get(grid[0][0]).entry] = true;

    return hasPath(grid, 0, 0, m, n, visited, compatible);


  }

  public boolean hasPath(int[][] grid, int i, int j, int m, int n, boolean[][][] visited,
      Map<Integer, Street> compatible) {

    if (i == m - 1 && j == n - 1) {
      return true;
    }

    //find exit of node
    int a = compatible.get(grid[i][j]).entry;
    int b = compatible.get(grid[i][j]).exit;
    int exit = !visited[i][j][a] ? a : b;

    int x = -1;
    int y = -1;
    if (exit == 0) {
      x = i;
      y = j - 1;
    } else if (exit == 1) {
      x = i;
      y = j + 1;
    } else if (exit == 2) {
      x = i - 1;
      y = j;
    } else if (exit == 3) {
      x = i + 1;
      y = j;
    }

    int oppExit = getOppExit(exit);
    //x and y within boundaries
    if (x >= 0 && x < m && y >= 0 && y < n) {

      Street st = compatible.get(grid[x][y]);
      int[] paths = new int[2];
      paths[0] = st.entry;
      paths[1] = st.exit;

      for (int p = 0; p < 2; p++) {
        if (oppExit == paths[p] && !visited[x][y][paths[p]]) {
          visited[x][y][paths[p]] = true;
          if (hasPath(grid, x, y, m, n, visited, compatible)) {
            return true;
          }

          visited[x][y][paths[p]] = false;
        }

      }//for


    }//if

    return false;


  }

  int getOppExit(int exit) {
    if (exit == 1) {
      return 0;
    } else if (exit == 0) {
      return 1;
    } else if (exit == 2) {
      return 3;
    }
    return 2;
  }


}


