package problems.dp;

public class RepeatingStringEasy {

  public static void main(String[] args) {
    System.out.println(new RepeatingStringEasy().maximalLength("aababbababbabbbbabbabb"));
  }

  int maximalLength(String s) {
    int max = 0;
    int n = s.length();
    // n-1 partitions
    for (int i = 1; i <= n; i++) {
      String first = s.substring(0, i);
      String second = s.substring(i);
      max = Math.max(max, lcs2(first, second));


    }

    return max;
  }

  int lcs2(String A, String B) {
    int m = A.length();
    int n = B.length();

    int lcs[][] = new int[m + 1][n + 1];
    for (int l = 0; l < m; l++) {
      lcs[l][0] = 0;
    }
    for (int k = 0; k < n; k++) {
      lcs[0][k] = 0;
    }

    for (int i = 1; i <= m; i++) {
      for (int j = 1; j <= n; j++) {
        if (A.charAt(i - 1) == B.charAt(j - 1)) {
          lcs[i][j] = lcs[i - 1][j - 1] + 1;
        } else {
          lcs[i][j] = Math.max(lcs[i - 1][j], lcs[i][j - 1]);
        }

      }
    }

    return lcs[m][n];

  }
}
