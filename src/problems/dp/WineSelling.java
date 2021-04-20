package problems.dp;

import java.util.Arrays;

public class WineSelling {

  static int N;

  static int memo[][];

  public static void main(String[] args) {
    int A[] = {2, 3, 5, 1, 4};

    int maxProfit = 0;
    N = A.length;

    memo = new int[A.length][A.length];
    for (int i = 0; i < A.length; i++) {
      Arrays.fill(memo[i], -1);
    }

    System.out.println(new WineSelling().maxProfit(A, 0, A.length - 1));
  }

  int maxProfit(int[] A, int i, int j) {

    if (i >= A.length || i > j || j < 0) {
      return 0;
    }

    if (memo[i][j] != -1) {
      return memo[i][j];
    }

    int years = N - (j - i + 1) + 1;
    memo[i][j] = Math.max(maxProfit(A, i + 1, j) + years * A[i],
        maxProfit(A, i, j - 1) + years * A[j]);

    return memo[i][j];

  }


}
