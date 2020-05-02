package problems.dp.leetcode;

import java.util.Arrays;

public class MinCostForTickets {

  public static void main(String[] args) {
    int[] days = {3, 5, 6, 8, 9, 10, 11, 12, 13, 14, 15, 16, 20, 21, 23, 25, 26, 27, 29, 30, 33, 34,
        35, 36, 38, 39, 40, 42, 45, 46, 47, 48, 49, 51, 53, 54, 56, 57, 58, 59, 60, 61, 63, 64, 67,
        68, 69, 70, 72, 74, 77, 78, 79, 80, 81, 82, 83, 84, 85, 88, 91, 92, 93, 96};
    //int[] days = {1,2,3,4,5,6,7,8,9,10,30,31};
    int[] costs = {3, 17, 57};
    //int[] costs = {2,7,15};
    System.out.println(new MinCostForTickets().mincostTickets(days, costs));
  }

  public int mincostTickets(int[] days, int[] costs) {

    int n = days.length;

    int[][] memo = new int[n + 1][366];
    for (int l = 0; l < n + 1; l++) {
      Arrays.fill(memo[l], -1);
    }

    return minCost(0, 0, 0, days, costs, memo);

  }

  int minCost(int i, int doh, int cost, int[] days, int[] costs, int[][] memo) {

    int minCost = Integer.MAX_VALUE;
    if (i >= days.length) {
      return cost;
    }
    if (memo[i][doh] != -1) {
      return memo[i][doh];
    }

    if (days[i] < doh) {
      minCost = minCost(i + 1, doh, cost, days, costs, memo);
    } else {
      minCost = Math.min(minCost(i + 1, days[i] + 1, cost + costs[0], days, costs, memo),
          Math.min(minCost(i + 1, days[i] + 7, cost + costs[1], days, costs, memo),
              minCost(i + 1, days[i] + 30, cost + costs[2], days, costs, memo)));
    }
    memo[i][doh] = minCost;
    return memo[i][doh];

  }


}
