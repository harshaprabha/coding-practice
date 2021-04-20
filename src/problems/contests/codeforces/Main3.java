package problems.contests.codeforces;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Main3 {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    PrintWriter out = new PrintWriter(System.out);
    solution(in, out);
    in.close();
    out.close();
  }

  public static void solution(Scanner in, PrintWriter out) {
    int t = in.nextInt();
    while (t-- > 0) {
      algo(in, out);
    }
  }

  public static void algo(Scanner in, PrintWriter out) {

    int[] A = new int[4];

    for (int i = 0; i < 4; i++) {
      A[i] = in.nextInt();
    }

    int[][] graph= {{1,2},{1}};


    Arrays.sort(A);

    System.out.println(A[1] + A[2]);


  }

}

