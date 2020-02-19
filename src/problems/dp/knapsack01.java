package problems.dp;

import java.util.Arrays;

public class knapsack01 {

  static int P[] = {1, 2, 5, 6};
  static int W[] = {2, 3, 4, 5};
  static int C = 8;
  static int n = P.length;


  // Time complexity - O(n2)
  public static void main(String[] args) {

    System.out.println(new knapsack01().knapsackRecursive(n - 1, C));

    // DP 0-1 Knapsack
    int dp[][] = new int[n + 1][C + 1];
    Arrays.fill(dp[0], 0);

    for (int m = 0; m < n + 1; m++) {
      dp[m][0] = 0;
    }

    int maxProfit = Integer.MIN_VALUE;
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= C; j++) {
        if (W[i - 1] > j) {
          dp[i][j] = dp[i - 1][j];
        } else {
          dp[i][j] = Math.max(dp[i - 1][j], P[i - 1] + dp[i - 1][j - W[i - 1]]);
        }
      }
    }
    System.out.println(dp[n][C]);
  }

  // Time complexity - O(2^n)
  int knapsackRecursive(int n, int C) {

    if (n < 0 || C < 0) {
      return 0;
    } else if (W[n] > C) {
      return knapsackRecursive(n - 1, C);
    }
    return Math.max(knapsackRecursive(n - 1, C), P[n] + knapsackRecursive(n - 1, C - W[n]));
  }


}
