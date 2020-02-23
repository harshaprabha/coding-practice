package problems.dp;

import java.util.ArrayList;
import java.util.Arrays;

public class SumOfDigits {

  static int count = 0;
  static ArrayList<String> result = new ArrayList<>();
  static long[][] memo;

  public static void main(String[] args) {
    int n = 2;
    int sum = 2;
    memo = new long[n + 1][sum + 1];
    for (int i = 0; i < n + 1; i++) {
      Arrays.fill(memo[i], -1L);
    }
    System.out.println(getNum(n, sum, memo));

    // DP => Problem is a fuction of two variables - Sum[0-S] and pos[0-n]
    long dp[][] = new long[n + 1][sum + 1];
    dp[0][0] = 1;

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= sum; j++) {
        long count = 0L;
        for (int d = 0; d < 10 && d <= j; d++) {
          count += dp[i - 1][j - d];
        }
        dp[i][j] = count;
      }
    }


  }


  static long getNumRecursive(int pos, int sum) {
    if (pos == 0) {
      return sum == 0 ? 1L : 0L;
    }
    if (sum <= 0) {
      return 0L;
    }

    long count = 0L;
    for (int j = 0; j < 10 && j <= sum; j++) {
      count += getNumRecursive(pos - 1, sum - j);
    }//for

    return count;
  }


  // O(9*10^n)
  static long getNum(int pos, int sum, long memo[][]) {

    if (pos == 0) {
      return sum == 0 ? 1L : 0L;
    }
    if (sum <= 0) {
      return 0L;
    }
    if (memo[pos][sum] != -1L) {
      return memo[pos][sum];
    }

    long count = 0L;
    for (int j = 0; j < 10 && j <= sum; j++) {
      if (pos == 0 && j == 0) {
        continue;
      }
      count += getNum(pos - 1, sum - j, memo);
    }//for

    memo[pos][sum] = count;

    return memo[pos][sum];
  }

}
