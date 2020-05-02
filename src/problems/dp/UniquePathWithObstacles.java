package problems.dp;

import java.util.Arrays;

public class UniquePathWithObstacles {

  public static void main(String[] args) {
    int A[][] = {{0, 0,0},{0,1,0},{1,0,0}};
    System.out.println(uniquePathsWithObstacles(A));
  }

  public static int uniquePathsWithObstacles(int[][] A) {

    int m = A.length;
    int n = A[0].length;
    boolean isVisited[][] = new boolean[m][n];
    for (int k = 0; k < m; k++) {
      Arrays.fill(isVisited[k], false);
    }
    int memo[][]=new int [m][n];
    for (int k = 0; k < m; k++) {
      Arrays.fill(memo[k], -1);
    }
    return countPaths(A, 0, 0, isVisited, m, n,memo);


  }

  // O(M*N) Top down with memoization
  static int countPaths(int[][] A, int i, int j, boolean isVisited[][], int m, int n,int memo[][]) {

    int count = 0;

    if (i == m - 1 && j == n - 1 && A[i][j] != 1) {
      return 1;
    }

    if (checkValidMove(A, i, j, m, n, isVisited) ) {

      if(memo[i][j]!=-1)
        return memo[i][j];

      isVisited[i][j] = true;

      int c1 = countPaths(A, i, j + 1, isVisited, m, n,memo);
      int c2 = countPaths(A, i + 1, j, isVisited, m, n,memo);

      count = c1+c2;
      memo[i][j]=count;
      isVisited[i][j] = false;

    }

    return count;


  }

  static int countPaths2(int[][] A, int i, int j) {

    int count = 0;
    int m = A.length;
    int n = A[0].length;
    boolean isVisited[][] = new boolean[m][n];
    for (int k = 0; k < m; k++) {
      Arrays.fill(isVisited[k], false);
    }

    int countpaths[][] = new int[m + 1][n + 1];


      if (i == m - 1 && j == n - 1 && A[i][j] != 1) {
        return 1;
      }


    if (checkValidMove(A, i, j, m, n, isVisited)) {
      isVisited[i][j] = true;

      int c1 = countPaths2(A, i, j + 1);
      int c2 = countPaths2(A, i + 1, j);

      count = c1 + c2;

      isVisited[i][j] = false;

    }

    return count;


  }


  static boolean checkValidMove(int[][] A, int i, int j, int m, int n, boolean[][] isVisited) {

    if (i < 0 || j < 0 || i >= m || j >= n) {
      return false;
    }

    if (isVisited[i][j] == true) {
      return false;
    }

    if (A[i][j] == 1) {
      return false;
    }

    return true;

  }

}
