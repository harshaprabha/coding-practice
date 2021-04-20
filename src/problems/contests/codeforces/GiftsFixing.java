package problems.contests.codeforces;

import java.io.PrintWriter;
import java.util.Scanner;

public class GiftsFixing {

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
    int[] B = new int[N];
    int Amin = Integer.MAX_VALUE;
    int Bmin = Integer.MAX_VALUE;

    for (int i = 0; i < N; i++) {
      A[i] = in.nextInt();
      Amin = Math.min(Amin, A[i]);
    }

    for (int i = 0; i < N; i++) {
      B[i] = in.nextInt();
      Bmin = Math.min(Bmin, B[i]);
    }

    long count = 0;
    for (int i = 0; i < N; i++) {
      while (!(A[i] == Amin && B[i] == Bmin)) {
        if (A[i] > Amin && B[i] > Bmin) {
          int min = Math.min(Amin, Bmin);
          count += min;
          A[i] = A[i] - min;
          B[i] = B[i] - min;
        } else if (A[i] > Amin) {
          count += A[i] - Amin;
          A[i] = Amin;
        } else if (B[i] > Bmin) {
          count += B[i] - Bmin;
          B[i] = Bmin;
        }
      }
    }//for

    out.println(count);
  }


}
