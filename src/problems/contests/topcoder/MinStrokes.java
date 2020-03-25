package problems.contests.topcoder;

public class MinStrokes {

  static int min = Integer.MAX_VALUE;
  static int R = 2;

  public static void main(String[] args) {
    String[] level =
        {"##..v..##",
            "###.....#",
            "#####...#",
            "####...##",
            "###..####",
            "#.......#",
            "#...#####"};

    System.out.println(new MinStrokes().minKeystrokes(level, R));
  }

  /**
   * O(n*m*R) DP Approach - Make it acyclic
   */
  int minKeystrokes2(String[] level, int rate) {
    int row = level.length;
    int col = level[0].length();
    int inf = Integer.MAX_VALUE;

    int dp[][][] = new int[row + 1][col + 1][rate + 1];

    for (int i = 0; i < row + 1; i++) {
      for (int j = 0; j < col + 1; j++) {
        for (int k = 0; k < rate + 1; k++) {
          dp[i][j][k] = inf;
        }
      }
    }
    int i = 0;
    for (i = 0; i < row; i++) {
      if (level[0].charAt(i) == 'v') {
        break;
      }

    }

    for (int l = i - rate; l <= i + rate; l++) {
      if (l >= 0 && l < col) {
        if (level[0].charAt(l) != '#') {


        }
      }


    }//for
return 0;

  }//meth

  int minKeystrokes(String[] level, int rate) {
    if (level.length == 1) {
      return 0;
    }

    int i;
    for (i = 0; i < level[0].length(); i++) {
      if (level[0].charAt(i) == 'v') {
        break;
      }
    }
    R = rate;
    boolean[][] visited = new boolean[level.length][level[0].length()];

    minStrokes(0, i, R, level, level.length, visited, 0);
    return min == Integer.MAX_VALUE ? -1 : min;
  }

  /**
   * Recursive Approach Graph approach - Cyclic
   */
  public void minStrokes(int i, int j, int leftRate, String[] level, int row, boolean[][] visited,
      int count) {

    if (i >= row || j >= level[0].length()) {
      return;
    }

    if (level[i].charAt(j) == '#' || visited[i][j]
        || leftRate < 0) {
      return;
    }
    if (i == row - 1) {
      min = Math.min(min, count);
      return;
    }

    visited[i][j] = true;
    minStrokes(i, j - 1, leftRate - 1, level, row, visited, count + 1);
    minStrokes(i, j + 1, leftRate - 1, level, row, visited, count + 1);
    minStrokes(i + 1, j, R, level, row, visited, count);
    visited[i][j] = false;

  }


}
