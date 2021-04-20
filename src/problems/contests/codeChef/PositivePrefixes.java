package problems.contests.codeChef;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class PositivePrefixes {

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
    int K = in.nextInt();

   // getSequence(1, K, 0, N, new ArrayList<>(), new ArrayList<>());


  }


  void getSequence(int i, int K, int sum, int N, ArrayList<Integer> temp,
      ArrayList<Integer> result) {

    if (i > N) {
      if (K == 0) {
        result.addAll(temp);
      }
      return;
    }

    sum = sum + i;
    temp.add(i);
    getSequence(i + 1, sum > 0 ? K - 1 : K, sum, N, temp, result);
    temp.remove(temp.size() - 1);
    sum = sum - i;
    sum = sum - i;
    temp.add(-i);
    getSequence(i + 1, sum > 0 ? K - 1 : K, sum, N, temp, result);
    temp.remove(temp.size() - 1);


  }

}
