package problems.contests.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class JobScheduling {

  public static void main(String[] args) {
    int[] A = {1, 2};
    int[] B = {3, 4};
    int[] P = {50, 10};
    System.out.println(new JobScheduling().jobScheduling(A, B, P));
  }


  int[][] memo;

  public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {

    List<int[]> intervals = new ArrayList<>();
    int n = startTime.length;
    memo = new int[n][n];

    for (int i = 0; i < n; i++) {
      Arrays.fill(memo[i], -1);
    }
    intervals.add(new int[]{0, 0, 0});

    for (int i = 0; i < n; i++) {
      intervals.add(new int[]{startTime[i], endTime[i], profit[i]});
    }

    for (int i = 0; i < n + 1; i++) {
      System.out
          .println(intervals.get(i)[0] + " " + intervals.get(i)[1] + " " + intervals.get(i)[2]);
    }
    Collections.sort(intervals, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
    return maxProfit(1, 0, intervals, intervals.size());
  }

  int maxProfit(int i, int previ, List<int[]> intervals, int n) {
    if (i == n) {
      return 0;
    }

    // if(previ!=i && memo[i][previ]!=-1)
    //      return memo[i][previ];
    int mxprofit = maxProfit(i + 1, previ, intervals, n);
    System.out.println("i=" + i + " previ=" + previ);
    int currStart = intervals.get(i)[0];
    int prevEnd = intervals.get(previ)[1];

    System.out.println("currStart=" + currStart + " prevEnd=" + prevEnd);
    if (prevEnd <= currStart) {
      mxprofit = Math.max(mxprofit, intervals.get(i)[2] + maxProfit(i + 1, i, intervals, n));
    }

    // memo[i][previ]=mxprofit;
    return mxprofit;

  }

}

