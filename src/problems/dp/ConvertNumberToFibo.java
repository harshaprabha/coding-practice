package problems.dp;

import java.util.Arrays;

public class ConvertNumberToFibo {

  public static void main(String[] args) {

    int a = 0;
    int b = 1;
    int N = 4;

    int c = 0;
    while (c < N) {
      c = a + b;
      if (c == N) {
        System.out.println("0");
        return;
      }

      a = b;
      b = c;
    }
    System.out.println(Math.min(N - a, b - N));


  }


  public  void cards(String[] args) {

    int a = 0;
    int b = 1;
    int N = 4;

    int c = 0;
    while (c < N) {
      c = a + b;
      if (c == N) {
        System.out.println("0");
        return;
      }

      a = b;
      b = c;
    }
    System.out.println(Math.min(N - a, b - N));


  }

}
