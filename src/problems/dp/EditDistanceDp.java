package problems.dp;

public class EditDistanceDp {

  public static void main(String[] args) {
    System.out
        .println(new EditDistanceDp().minDistance("abac", "aac"));
  }

  public int minDistance(String A, String B) {

    int m = A.length() + 1;
    int n = B.length() + 1;
    int dp[][] = new int[m][n];

    for (int p = 0; p < m; p++) {
      dp[p][0] = p;
    }
    for (int q = 0; q < n; q++) {
      dp[0][q] = q;
    }

    for (int i = 1; i < m; i++) {
      for (int j = 1; j < n; j++) {
        if (A.charAt(i - 1) == B.charAt(j - 1)) {
          dp[i][j] = dp[i - 1][j - 1];
        } else {
          dp[i][j] = 1 + Math.min(Math.min(dp[i - 1][j - 1], dp[i - 1][j]), dp[i][j - 1]);
        }
      }
    }

    return dp[m - 1][n - 1];
  }

}
