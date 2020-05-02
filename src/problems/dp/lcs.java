package problems.dp;

public class lcs {

  public static void main(String[] args) {
    String A = "abcdefgh";
    String B = "acefg";
    new lcs().lcs2(A, B);


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
  int lcs2(String A, String B) {
    int m = A.length();
    int n = B.length();

    int lcs[][] = new int[m + 1][n + 1];
    for (int i = 1; i <= m; i++) {
      for (int j = 1; j <= n; j++) {
        if (A.charAt(i - 1) == B.charAt(j - 1)) {
          lcs[i][j] = lcs[i - 1][j - 1] + 1;
        } else {
          lcs[i][j] = Math.max(lcs[i - 1][j], lcs[i][j - 1]);
        }

      }
    }

    for (int i = 0; i <= m; i++) {
      for (int j = 0; j <= n; j++) {
        System.out.print(lcs[i][j] + " ");
      }
      System.out.println();
    }

    // Print LCS
    StringBuilder result = new StringBuilder();
    for (int i = m; i > 0; ) {

      for (int j = n; j > 0; ) {

        if (A.charAt(i - 1) == B.charAt(j - 1)) {
          result.append(A.charAt(i - 1));
          i--;
          j--;
        } else {
          //go to max index
          if (lcs[i][j]==lcs[i - 1][j]) {
            i--;
          }
          else
            j--;
        }


      }
    }

    System.out.println(result.reverse().toString());

    return lcs[m][n];

  }


}
