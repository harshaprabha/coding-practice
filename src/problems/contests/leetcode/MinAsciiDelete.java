package problems.contests.leetcode;

import javafx.util.Pair;

public class MinAsciiDelete {

  class Memo {

    int i;
    int j;
    int sum;

    Memo(int i, int j, int sum) {
      this.i = i;
      this.j = j;
      this.sum = sum;
    }

    @Override
    public boolean equals(Object obj) {
      Memo m = (Memo) obj;
      return this.i == m.i && this.j == m.j && this.sum == m.sum;
    }
  }

  public static void main(String[] args) {
    String s1 = "sea";
    String s2 = "eat";

    System.out.println(new MinAsciiDelete().minimumDeleteSum(s1, s2));

  }

  public int minimumDeleteSum(String s1, String s2) {
    int m = s1.length();
    int n = s2.length();
    Pair<Integer,Integer> pair= new Pair<>(1,2);

    int dp[][] = new int[m + 1][n + 1];

    dp[0][0] = 0;

    for (int l = 1; l <= m; l++) {
      dp[l][0] = dp[l - 1][0] + s1.charAt(l - 1);
    }

    for (int l = 1; l <= n; l++) {
      dp[0][l] = dp[0][l - 1] + s2.charAt(l - 1);
    }

    for (int i = 1; i <= m; i++) {
      for (int j = 1; j <= n; j++) {

        if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
          dp[i][j] = dp[i - 1][j - 1];
        } else {
          dp[i][j] = Math.min(dp[i - 1][j] + s1.charAt(i - 1), dp[i][j - 1] + s2.charAt(j - 1));
        }
      }
    }

    for (int p = 0; p <= m; p++) {
      for (int q = 0; q <= n; q++) {
        System.out.print(dp[p][q] + " ");
      }
      System.out.println();
    }
    return dp[m][n];

    //return minDelSum(m-1,n-1,s1,s2,0);

  }


  int minDelSum(int i, int j, String s1, String s2, int prevSum) {
    int sum = 0;
    int mini = Integer.MAX_VALUE;
    int maxi = Integer.MAX_VALUE;

    if (i < 0 && j < 0) {
      return prevSum;
    }

    if (i >= 0 && j >= 0 && s1.charAt(i) == s2.charAt(j)) {
      sum = minDelSum(i - 1, j - 1, s1, s2, prevSum);
    } else {
      if (j >= 0) {
        mini = minDelSum(i, j - 1, s1, s2,
            prevSum + s2.charAt(j));
      }
      if (i >= 0) {
        maxi = minDelSum(i - 1, j, s1, s2,
            prevSum + s1.charAt(i));
      }

      sum = Math.min(mini, maxi);
    }
    return sum;
  }


}
