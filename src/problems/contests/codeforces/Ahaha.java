package problems.contests.codeforces;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ahaha {

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
    int n = in.nextInt();
    int[] A = new int[n];

    int oneCount = 0;
    for (int i = 0; i < n; i++) {
      A[i] = in.nextInt();
      if (A[i] == 1) {
        oneCount++;
      }
    }

    int allowedOnes = oneCount % 2 == 0 ? oneCount : oneCount - 1;
    int zeroCount = 0;
    List<Integer> res = new ArrayList<>();
    for (int i = 0; i < n; i++) {

      if (A[i] == 1) {
        if (zeroCount != 0 && zeroCount % 2 != 0) {
          res.remove(res.size() - 1);
        }

        if (allowedOnes > 0) {
          res.add(1);
          allowedOnes--;
        }
        zeroCount = 0;

      } else {
        res.add(0);
        zeroCount++;
      }

    }

    String ans = "";

    for (int i = 0; i < res.size(); i++) {
      ans += res.get(i);
      if (i != res.size() - 1) {
        ans += " ";
      }

    }
    System.out.println(res.size());
    System.out.println(ans);

  }

}
