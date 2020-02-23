package problems.dp;

import java.util.Arrays;
import java.util.List;

public class BirthdayParty {

  public static void main(String[] args) {
    List<Integer> A = Arrays.asList(2, 3, 1, 5, 4);
    List<Integer> B = Arrays.asList(3, 2, 4, 1);
    List<Integer> C = Arrays.asList(1, 2, 5, 10); //2+1+10+3+4
    System.out.println(solve(A, B, C));
  }

  public static int solve(final List<Integer> A, final List<Integer> capacity,
      final List<Integer> cost) {
    int n = capacity.size();

    int max = Integer.MIN_VALUE;
    for (int p = 0; p < A.size(); p++) {
      max = max < A.get(p) ? A.get(p) : max;
    }

    long memo[][] = new long[n + 1][max + 1];
    for (int i = 0; i < n; i++) {
      Arrays.fill(memo[i], -1L);
    }

    long sum = 0;
    for (int k = 0; k < A.size(); k++) {
      sum += computeMinCostMemo(n - 1, A.get(k), capacity, cost, memo);
    }
    return (int) sum;

  }


  static int computeMinCost(int N, int C, final List<Integer> capacity, final List<Integer> cost) {
    if (C == 0) {
      return 0;
    } else if (N < 0) {
      return C == 0 ? 0 : Integer.MAX_VALUE;
    } else if (C < capacity.get(N)) {
      return computeMinCost(N - 1, C, capacity, cost);
    } else {
      long c1 = (long) cost.get(N) + computeMinCost(N, C - capacity.get(N), capacity, cost);
      long c2 = computeMinCost(N - 1, C, capacity, cost);
      return (int) Math.min(c1, c2);
    }

  }


  static int computeMinCostMemo(int N, int C, final List<Integer> capacity,
      final List<Integer> cost, long memo[][]) {

    if (C == 0) {
      return 0;
    } else if (N < 0) {
      return C == 0 ? 0 : Integer.MAX_VALUE;
    } else if (memo[N][C] != -1) {
      return (int) memo[N][C];
    } else if (C < capacity.get(N)) {
      memo[N][C] = computeMinCostMemo(N - 1, C, capacity, cost, memo);
      return (int) memo[N][C];
    } else {
      long c1 =
          (long) cost.get(N) + computeMinCostMemo(N, C - capacity.get(N), capacity, cost, memo);
      long c2 = computeMinCostMemo(N - 1, C, capacity, cost, memo);
      memo[N][C] = Math.min(c1, c2);
      return (int) memo[N][C];
    }

  }


}
