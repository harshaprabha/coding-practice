package problems.dp.leetcode;

public class RollDice {

  public static void main(String[] args) {
    System.out.println(new RollDice().numRollsToTarget(1, 6, 3));
  }

  private static final int MOD = (int) Math.pow(10, 9) + 7;

  public int numRollsToTarget(int d, int f, int target) {
    long dp[][] = new long[d + 1][target + 1];

    dp[0][0] = 1; // base case

    for (int i = 1; i <= d; i++) {
      for (int j = 1; j <= target; j++) {
        //check all possibilities
        for (int k = 1; k <= f; k++) {
          if (j >= k) {
            dp[i][j] = dp[i][j] % MOD + dp[i - 1][j - k] % MOD;
          }
        }
      }
    }
    return (int) dp[d][target] % MOD;

    //return countRollsRecursive(d,target,f);
  }


  int countRollsRecursive(int d, int sumleft, int f) {

    int count = 0;
    if (d == 0) {
      if (sumleft == 0) {
        return 1;
      }
      return 0;
    }

    if (sumleft == 0) {
      return 0;
    }

    for (int j = 1; j <= f; j++) {
      if (j <= sumleft) {
        count += countRollsRecursive(d - 1, sumleft - j, f); // include face f
      }

    }

    return count;
  }
}
