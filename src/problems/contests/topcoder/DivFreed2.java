package problems.contests.topcoder;

import java.util.Arrays;

public class DivFreed2 {

  public static void main(String[] args) {
    int n = 10;
    int k = 100000;
    // System.out.println(new DivFreed2().count(n, k) % 1000000007);
    System.out.println(new DivFreed2().countDIvBottomUp(k, n) % 1000000007);
  }

  public int count(int n, int k) {
    int memo[][] = new int[n + 1][k + 1];
    for (int m = 0; m <= n; m++) {
      Arrays.fill(memo[m], -1);
    }
    return countDIv(1, 1, k, n, memo) % 1000000007;

  }

  public int countDIv(int prev, int i, int k, int n, int[][] memo) {

    if (i > n) {
      return 1;
    }

    if (memo[i][prev] % 1000000007 != -1) {
      return memo[i][prev] % 1000000007;
    }

    int count = 0;
    for (int l = 1; l <= k; l++) {
      if (l < prev && prev % l != 0) {
        count = count % 1000000007 + countDIv(l, i + 1, k, n, memo) % 1000000007;
      } else if (l >= prev) {
        count = count % 1000000007 + countDIv(l, i + 1, k, n, memo) % 1000000007;
      }
    }
    memo[i][prev] = count % 1000000007;
    return memo[i][prev] % 1000000007;

  }


  public int countDIvBottomUp(int k, int n) {

    int dp[][] = new int[n + 1][k + 1];
    for (int m = 0; m <= n; m++) {
      Arrays.fill(dp[m], 0%1000000007);
    }

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= k; j++) {

        for (int l = 1; l <= k; l++) {
          if ((l < j && j % l != 0) || (l >= j)) {
            dp[i][j] = dp[i][j]%1000000007 +1%1000000007;
          }
        }
      }
    }

    int count = 0%1000000007;
    for (int h = 0; h <= k; h++) {
      count = count%1000000007 + dp[n][h]%1000000007;
    }
    return count%1000000007;

  }


}
