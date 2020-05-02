package problems.math;

/**
 * Problem Statement See <a href="https://www.interviewbit.com/problems/square-root-of-integer/">
 * Sqrt Function</a>
 * <p>Time Complexity - O(logn) </p>
 *
 * @author Harsha Prabha E
 */
public class SqrtFunction {

  public static void main(String[] args) {
    SqrtFunction sqrtFunction = new SqrtFunction();
    sqrtFunction.sqrt(723456142);
  }

  public int sqrt(int a) {
    if (a == 0) {
      return 0;
    }
    if (a == 1) {
      return 1;
    }

    int low = 1;
    int high = a;

    while (low <= high) {
      int mid = (low + high) / 2;
      if (mid * mid == a) {
        return mid;
      } else if (mid < a / mid) {
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }

    return high;
  }
}

