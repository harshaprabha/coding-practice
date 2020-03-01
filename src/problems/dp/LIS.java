package problems.dp;

import java.util.Arrays;

public class LIS {

  public static void main(String[] args) {
    int A[] = {5, 4, 3, 2, 1};
    System.out.println(new LIS().lis(A));

  }

  public int lis(final int[] A) {
    int n = A.length;
    int[] lis = new int[n + 1];

    Arrays.fill(lis, 1);
    int max = 1;

    for (int i = 1; i < n; i++) {

      for (int j = i - 1; j >= 0; j--) {

        if (j >= 0 && A[j] < A[i] && lis[j] + 1 > lis[i]) {
          lis[i] = lis[j] + 1;
        }
        max = Math.max(max, lis[i]);

      }//for i

    }
    return max;
  }


}