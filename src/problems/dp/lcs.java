package problems.dp;

public class lcs {

  public static void main(String[] args) {
    String A = "aedb";
    String B = "abecdba";
    new lcs().lcs2(A, B, A.length(), B.length());

  }

  // O(2^n)
  int lcs(String A, String B, int i, int j) {
    if (i < 0 || j < 0) {
      return 0;
    }
    int count = 0;
    if (A.charAt(i) == B.charAt(j)) {
      count = lcs(A, B, i - 1, j - 1) + 1;
    } else {
      count = Math.max(lcs(A, B, i, j - 1), lcs(A, B, i - 1, j));
    }

    return count;
  }


  // O(n^2)
  void lcs2(String A, String B, int m, int n) {

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

    System.out.println(lcs[m][n]);

  }


}
