package problems.math;

/**
 * Problem Statement See <a href="https://www.interviewbit.com/problems/implement-power-function/">
 * Power Function</a>
 * <p>Time Complexity - O(logn) </p>
 *
 * @author Harsha Prabha E
 */
public class PowerFunction {


  public static void main(String[] args) {
    System.out.println(pow(-1, 1, 20));

  }

  public static int pow(int x, int n, int d) {
    long res = 1;
    long a = x;
    a = a % d;

    while (n > 0) {
      if (n % 2 == 1) {
        res = (res * a);
      }

      n = n >> 1;
      a = (a * a) % d;

    }
    if (res >= 0) {
      return (int) res % d;
    }
    return (d + (int) res);
  }
}

