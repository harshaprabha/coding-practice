package problems.contests.codeforces;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main4 {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    PrintWriter out = new PrintWriter(System.out);
    solution(in, out);
    in.close();
    out.close();
  }

  public static void solution(Scanner in, PrintWriter out) {
    int t = in.nextInt();
    in.nextLine();
    while (t-- > 0) {
      algo(in, out);
    }
  }


  public static void algo(Scanner in, PrintWriter out) {

    int n = in.nextInt();

    int A[] = new int[n];
    int[][] ans = new int[n][n];

    ArrayList<Integer> primes = sieve(100000);
    int start = 4;
    int sum = 0;
    for (int i = 0; i < n - 1; i++) {
      ans[0][i] = start;
      sum += start;
      start = start + 2;
    }

    // columns
    for (int i = 0; i < n - 1; i++) {

      int first = ans[0][i];

      int j = 1;
      while (j < n - 1 && first > 6) {
        first = first - 2;
        ans[j][i] = first;
        j++;
      }

      int prev = ans[0][i];
      for (int k = j; k < n - 1; k++) {
        prev = prev + 2;
        ans[k][i] = prev;
      }

    }

    // last column

    for (int i = 0; i < n - 1; i++) {
      int rowSum = 0;
      for (int k = 0; k < n - 1; k++) {
        rowSum += ans[i][k];
      }

      int ll = Collections.binarySearch(primes, rowSum);
      if (ll < 0) {
        ll = -(ll + 1);
      }

      while (primes.contains(primes.get(ll) - rowSum)) {
        ll = ll + 1;
      }
      ans[i][n - 1] = primes.get(ll) - rowSum;
    }

    // last row

    for (int j = 0; j < n; j++) {
      int colSum = 0;
      for (int k = 0; k < n - 1; k++) {
        colSum += ans[k][j];
      }

      int ll = Collections.binarySearch(primes, colSum);
      if (ll < 0) {
        ll = -(ll + 1);
      }

      while (primes.contains(primes.get(ll) - colSum)) {
        ll = ll + 1;
      }
      ans[n - 1][j] = primes.get(ll) - colSum;
    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        System.out.print(ans[i][j]);
        if (j < n - 1) {
          System.out.print(" ");
        }
      }
      System.out.println();
    }


  }


  public static ArrayList<Integer> sieve(int A) {
    boolean prime[] = new boolean[A + 1];
    Arrays.fill(prime, true);
    prime[0] = prime[1] = false;

    for (int i = 2; i <= A; i++) {
      if (!prime[i]) {
        continue;
      }

      for (long j = 1L * i * i; j <= (long) A; j += i) {
        prime[(int) j] = false;
      }
    }

    ArrayList<Integer> res = new ArrayList<>();

    for (int i = 0; i <= A; i++) {
      if (prime[i]) {
        res.add(i);
      }
    }

    return res;
  }


}


