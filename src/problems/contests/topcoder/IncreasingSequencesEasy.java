package problems.contests.topcoder;

import java.util.Arrays;

public class IncreasingSequencesEasy {

  int count = 0;

  public static void main(String[] args) {
    int[] L = {1, 3};
    int[] R = {2, 4};
    // System.out.println(new IncreasingSequencesEasy().count(L, R));
    System.out.println(new IncreasingSequencesEasy().getCountBottomUp(L.length, L, R));
  }

  public int count(int[] L, int[] R) {
    int prev = 0;
    int memo[][] = new int[10001][L.length + 1];

    for (int k = 0; k < 10001; k++) {
      Arrays.fill(memo[k], -1);
    }
    return getCount(prev, 0, L.length, L, R, memo) % 998244353;

  }


  public int getCount(int prev, int i, int n, int[] L, int[] R, int memo[][]) {

    if (i == n) {
      return 1;
    }
    if (memo[prev][i] != -1) {
      return memo[prev][i] % 998244353;
    }

    int count = 0;
    for (int p = L[i]; p <= R[i]; p++) {
      if (prev < p) {
        count = count % 998244353 + getCount(p, i + 1, n, L, R, memo) % 998244353;
      }
    }

    memo[prev][i] = count % 998244353;
    return memo[prev][i] % 998244353;
  }


  public int getCountBottomUp(int n, int[] L, int[] R) {

    int limit = 5;
    int dp[][] = new int[n + 1][limit];

    for (int i = 0; i <= n; i++) {
      for (int j = 0; j < limit; j++) {
        for (int p = L[i - 1]; p <= R[i - 1]; p++) {
          if (j < p) {
            dp[i][j] += dp[i - 1][p] + 1;
          }
        }
      }//for
    }//for

    int c = 0;
    for (int k = 0; k < limit; k++) {
      if (dp[n][k] == n) {
        c++;
      }

    }
    return c;
  }


}
