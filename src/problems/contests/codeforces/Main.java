package problems.contests.codeforces;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    PrintWriter out = new PrintWriter(System.out);
    solution(in, out);
    in.close();
    out.close();
  }

  public static void solution(Scanner in, PrintWriter out) {
    //type = 0 (number of test cases known), 1 (only 1 test case), 2 (number of test cases unknown)
    int T = 0, type = 0;
    if (type == 0) {
      T = Integer.parseInt(in.nextLine());
    } else if (type == 1) {
      T = 1;
    }
    for (int t = 0; t < T; t++) {
      algo(in, out);
    }
  }

  static long[][] memo;

  public static void algo(Scanner in, PrintWriter out) {
    int N = in.nextInt();
    int q = in.nextInt();
    int[] A = new int[N];
    memo = new long[N][2];
    for (int i = 0; i < N; i++) {
      A[i] = in.nextInt();
      Arrays.fill(memo[i], -1);
    }

    System.out.println(maxStrength(0, 1, A));

  }

  static long maxStrength(int i, int parity, int[] A) {
    long profit = 0;

    if (i >= A.length) {
      return 0;
    }

    if (memo[i][parity] != -1) {
      return memo[i][parity];
    }

    profit = maxStrength(i + 1, parity, A);
    if (parity == 1) {
      profit = Math.max(profit, A[i] + maxStrength(i + 1, parity - 1, A));
    } else {
      profit = Math.max(profit, -A[i] + maxStrength(i + 1, parity + 1, A));
    }
    memo[i][parity] = profit;
    return profit;
  }


}

