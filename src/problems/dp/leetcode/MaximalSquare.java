package problems.dp.leetcode;

public class MaximalSquare {

  public static void main(String[] args) {
    char[][] inp = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};

    System.out.println(new MaximalSquare().maximalSquare(inp));

  }

  public int maximalSquare(char[][] matrix) {

    int m = matrix.length;
    int n = matrix[0].length;

    int max = Integer.MIN_VALUE;

    if (m == 0 || n == 0) {
      return 0;
    }

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {

        if (matrix[i][j] != '0') {
          if (i - 1 >= 0 && i - 1 < m && j - 1 >= 0 && j - 1 < n) {
            int min = Math.min(matrix[i - 1][j - 1] - 48,
                Math.min(matrix[i][j - 1] - 48, matrix[i - 1][j] - 48));
            if (min != 0) {
              min = (int) Math.sqrt(min);
              int area = (min + 1) * (min + 1);
              max = Math.max(max, area);
              matrix[i][j] = (char) (area + '0');
            }
          } else {
            max = Math.max(max, matrix[i][j]-'0');
          }


        }//if


      }//for
    }//for

    return max == Integer.MAX_VALUE ? 0 : max;
  }

}
