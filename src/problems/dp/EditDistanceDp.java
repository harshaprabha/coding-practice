package problems.dp;

public class EditDistanceDp {

  public static void main(String[] args) {
    System.out
        .println(new EditDistanceDp().minDistance("anagram", "ane"));
  }

  public int minDistance(String A, String B) {
    int cost = 0;
    int dp[][] = new int[A.length() + 1][B.length() + 1];

    for (int m = 0; m < B.length() + 1; m++) {
      dp[0][m] = m;
    }
    for (int n = 0; n < A.length() + 1; n++) {
      dp[n][0] = n;
    }

    for (int i = 1; i < A.length(); i++) {
      for (int j = 1; j < B.length(); j++) {
        if (A.charAt(i - 1) == B.charAt(j - 1)) {
          dp[i][j] = dp[i - 1][j - 1];
        } else {
          dp[i][j] = Math.min(Math.min(1 + dp[i - 1][j - 1], 1 + dp[i][j - 1]), dp[i][j - 1]);
        }
      }
    }

    return dp[A.length() - 1][B.length() - 1];
  }

}
