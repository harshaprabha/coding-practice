package problems.dp;

import java.util.Arrays;

public class SuperSum {

  public static void main(String[] args) {
    int k = 10;
    int n = 10;
    int[][] memo = new int[k + 1][n + 1];

    for (int i = 0; i <= k; i++) {
      Arrays.fill(memo[i], -1);
    }

    for (int i = 0; i <= n; i++) {
      memo[0][i] = n;
    }
    //System.out.println(new SuperSum().calculate(k,n,memo));
    System.out.println(new SuperSum().calculateBottomUp(k, n));
    return;
  }


  int calculate(int k, int n, int[][] memo) {

    if (k == 0) {
      return n;
    }

    if (memo[k][n] != -1) {
      return memo[k][n];
    }

    int sum = 0;
    for (int i = 1; i <= n; i++) {
      sum += calculate(k - 1, i, memo);
    }

    memo[k][n] = sum;
    return memo[k][n];
  }

  int calculateBottomUp(int k, int n) {

    int[][] dp = new int[2][n + 1];

    for (int i = 0; i <= n; i++) {
      dp[0%2][i] = i;
    }

    for (int i = 1; i <= k; i++) {
      for (int j = 1; j <= n; j++) {
        int sum = 0;
        for (int m = 1; m <= j; m++) {
          sum += dp[(i - 1)%2][m];
        }

        dp[i%2][j] = sum;
      }
    }

    return dp[k%2][n];
  }


}
