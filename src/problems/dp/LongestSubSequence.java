package problems.dp;

import java.util.Arrays;
import java.util.List;

public class LongestSubSequence {

  public static void main(String[] args) {
    System.out
        .println(new LongestSubSequence().longestSubsequenceLength(Arrays.asList(1, 1, 2, 1, 1)));
  }

  public int longestSubsequenceLength(final List<Integer> A) {
    int n = A.size();
    int increasing[] = new int[n];
    int decreasing[] = new int[n];

    if (n == 0 || n == 1) {
      return n;
    }

    for (int i = 0; i < n; i++) {
      increasing[i] = 1;
    }

    for (int i = 0; i < n; i++) {
      decreasing[i] = 1;
    }

    //fill increasing array
    for (int j = 1; j < n; j++) {
      for (int i = 0; i < j; i++) {
        if (A.get(i) < A.get(j)) {
          increasing[j] = Math.max(increasing[i] + 1, increasing[j]);
        }
      }
    }

    //fill decreasing array
    for (int j = n - 2; j >= 0; j--) {
      for (int i = n - 1; i > j; i--) {
        if (A.get(i) < A.get(j)) {
          decreasing[j] = Math.max(decreasing[i] + 1, decreasing[j]);
        }
      }
    }

    int max = -1;
    for (int p = 0; p < n; p++) {
      int diff = Math.abs(increasing[p] + decreasing[p]) - 1;
      max = max < diff ? diff : max;
    }

    return max;


  }

}
