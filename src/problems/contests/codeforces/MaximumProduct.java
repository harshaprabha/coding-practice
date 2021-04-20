package problems.contests.codeforces;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class MaximumProduct {

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


  public static void algo(Scanner in, PrintWriter out) {

    int N = in.nextInt();
    int[] A = new int[N];

    for (int i = 0; i < N; i++) {
      A[i] = in.nextInt();
    }
    long max = 0;
    Arrays.sort(A);

    long one = 1l * A[N - 1] * A[N - 2] * A[N - 3] * A[N - 4] * A[N - 5];
    long two = 1l * A[N - 1] * A[N - 2] * A[N - 3] * A[0] * A[1];

    max = Math.max(one, two);

    long three = 1l * A[0] * A[1] * A[2] * A[3] * A[N - 1];
    max = Math.max(max, three);
    System.out.println(max);

  }

}
