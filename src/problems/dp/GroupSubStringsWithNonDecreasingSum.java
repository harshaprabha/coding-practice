package problems.dp;

import java.util.Arrays;

/**
 * https://www.quora.com/q/kfhwdajorrdsqlrs/Dynamic-Programming-Part-1
 */
public class GroupSubStringsWithNonDecreasingSum {

  public static void main(String[] args) {

    String S = "123";
    int memo[][] = new int[25][225];
    for (int i = 0; i < 25; i++) {
      Arrays.fill(memo[i], -1);
    }
    System.out.println(new GroupSubStringsWithNonDecreasingSum().getWays(S, 0, 0, S.length(), memo));
    System.out.println(new GroupSubStringsWithNonDecreasingSum().getWaysBottomUp(S, S.length()));


  }

  int getWays(String S, int i, int prevSum, int n, int[][] memo) {

    if (i == n) {
      return 1;
    }
    if (memo[i][prevSum] != -1) {
      return memo[i][prevSum];
    }

    int count = 0;

    int sum = 0;
    for (int p = i; p < n; p++) {
      sum += (S.charAt(p) - '0');
      if (prevSum <= sum) {
        count = count + getWays(S, p + 1, sum, n,
            memo);  // looking for higher index result to fill lower index
      }

    }
    memo[i][prevSum] = count;
    return memo[i][prevSum];


  }

  int getWaysBottomUp(String S, int n) {

    int dp[][] = new int[26][226];

    //for last digit in input string, no of possibilities is always 1
    for (int prevSum = 0; prevSum < 226; prevSum++) {
      dp[n][prevSum] = 1;
    }

    //looking for higher index result to fill lower index
    for (int i = n - 1; i >= 0; i--) {
      for (int prevSum = 0; prevSum < 226; prevSum++) {

        int ans = 0;
        int sum = 0;
        dp[i][prevSum] = 0;

        // for all possibilities starting from i
        for (int k = i; k < n; k++) {
          sum += S.charAt(k) - 48;
          if (prevSum <= sum) {
            ans += dp[k + 1][sum];
          }
        }//for
        dp[i][prevSum] = ans;

      }
    }

    return dp[0][0];

  }
}
