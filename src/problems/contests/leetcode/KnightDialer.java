package problems.contests.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class KnightDialer {

  int MOD = (int) Math.pow(10, 9) + 7;

  public static void main(String[] args) {
    System.out.println(new KnightDialer().knightDialer(1));
  }

  public int knightDialer(int N) {

    Map<Integer, List<Integer>> map = new HashMap<>();
    map.put(0, new ArrayList<>(Arrays.asList(4, 6)));
    map.put(1, new ArrayList<>(Arrays.asList(8, 6)));
    map.put(2, new ArrayList<>(Arrays.asList(7, 9)));
    map.put(3, new ArrayList<>(Arrays.asList(4, 8)));
    map.put(4, new ArrayList<>(Arrays.asList(3, 9, 0)));
    map.put(5, new ArrayList<>());
    map.put(6, new ArrayList<>(Arrays.asList(7, 1, 0)));
    map.put(7, new ArrayList<>(Arrays.asList(2, 6)));
    map.put(8, new ArrayList<>(Arrays.asList(1, 3)));
    map.put(9, new ArrayList<>(Arrays.asList(2, 4)));

    int dp[][] = new int[11][N + 1];

    for (int p = 0; p < 11; p++) {
      dp[p][0] = 1;
    }


    return dp[10][N] % MOD;

  }

}
