package problems.dp;

/**
 * Note - Subsequence can have max n-1 overlap
 * Eg: aaaa
 * Ans= 3
 */
public class LongestRepeatingSubSequence {

  public static void main(String[] args) {
    String A = "aaaa";
    System.out.println(new LongestRepeatingSubSequence().LRS(A.length() - 1, A.length() - 1, A));
    //System.out.println(new LongestRepeatingSubSequence().LRS2(A));

  }


  public int LRS(int i, int j, String A) {

    int count = 0;

    if (i < 0 || j < 0) {
      return 0;
    }

    if (A.charAt(i) == A.charAt(j) && i != j) {
      count = 1 + LRS(i - 1, j - 1, A);
    } else {
      count = Math.max(LRS(i, j - 1, A), LRS(i - 1, j, A));
    }

    return count;

  }


  /**
   * Bottom up approach
   */
  public int LRS2(String A) {

    int count = 0;

    int dp[][] = new int[A.length() + 1][A.length() + 1];

    for (int i = 1; i <= A.length(); i++) {
      for (int j = 1; j <= A.length(); j++) {

        if (A.charAt(i - 1) == A.charAt(j - 1) && i - 1 != j - 1) {
          dp[i][j] = 1 + dp[i - 1][j - 1];
        } else {
          dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
        }
      }
    }
    return dp[A.length()][A.length()];

  }

}
