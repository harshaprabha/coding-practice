package problems.contests.codeChef;

import java.io.PrintWriter;
import java.util.Scanner;

public class EvenPairSum {

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
    int D = in.nextInt();
    int threat = 0;
    for (int i = 0; i < N; i++) {
      int A = in.nextInt();
      if (A >= 80 || A <= 9) {
        threat++;
      }
    }
    int ans = threat % D == 0 ? threat / D : (threat / D) + 1;
    N = N - threat;
    ans += N % D == 0 ? N / D : (N / D) + 1;
    out.println(ans);


  }

}
