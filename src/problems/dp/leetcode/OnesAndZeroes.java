package problems.dp.leetcode;

public class OnesAndZeroes {

  public static void main(String[] args) {
    String[] strs = {"10", "0", "1"};
    int m = 1;
    int n = 1;
    System.out.println(new OnesAndZeroes().findMaxForm(strs,m,n));
  }

  public int findMaxForm(String[] strs, int m, int n) {

    int no = strs.length;
    int ones[] = new int[no];

    //count 1s in string
    for (int p = 0; p < no; p++) {

      String s = strs[p];
      int count = 0;
      for (int l = 0; l < s.length(); l++) {
        if (s.charAt(l) == '1') {
          count++;
        }
      }
      ones[p] = count;

    }//for

    //dp
    int dp[][][] = new int[no + 1][m + 1][n + 1];

    for (int i = 1; i < no + 1; i++) {
      for (int j = 1; j < m + 1; j++) { // zero
        for (int k = 1; k < n + 1; k++) { //one

          int one = ones[i - 1];
          int zero = strs[i - 1].length() - one;

          if (j >= zero && k >= one) {
            dp[i][j][k]= Math.max(dp[i - 1][j][k], dp[i-1][j-zero][k-one] + 1);
          } else {
            dp[i][j][k] = dp[i - 1][j][k];
          }
        }
      }
    }

    return dp[no][m][n];


  }

}
