package problems.array;

/**
 * Problem Statement See <a href="https://www.interviewbit.com/problems/reverse-integer/"> reverse
 * Integer</a>
 * <p>Time Complexity - O(n) </p>
 *
 * @author Harsha Prabha E
 */

public class ReverseInteger {

  public static void main(String[] args) {

    System.out.println(reverse(-1146467285));
  }

  public static int reverse(int A) {

    int sign = A < 0 ? -1 : 1;

    long rev = 0;
    A = Math.abs(A);
    while (A != 0) {
      int remainder = A % 10;
      rev = rev * 10 + remainder;
      A = A / 10;
    }

    int r = (int) rev;
    return rev > Integer.MAX_VALUE ? 0 : sign * (int) rev;

  }

}
