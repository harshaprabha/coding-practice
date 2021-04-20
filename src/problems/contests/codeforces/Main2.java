package problems.contests.codeforces;

import java.io.PrintWriter;
import java.util.Scanner;

public class Main2 {

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

    int[] pos = new int[32];

    for (int i = 0; i < N; i++) {
      for (int j = 31; j >= 0; j--) {
        if ((A[i] & (1 << j)) > 0) {
          pos[j]++;
          break;
        }
      }

    }//for

    long count = 0;
    for (int k = 0; k < 32; k++) {
      if (pos[k] > 1) {
        long v = pos[k];
        count += (v * (v - 1)) / 2;
      }
    }

    System.out.println(count);
  }

}
