package problems.twopointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Problem Statement See <a href="https://www.interviewbit.com/problems/3-sum/"> Three Sum</a>
 * <p>Time Complexity - O(n^2)</p>
 *
 * @author Harsha Prabha E
 */
public class ThreeSumClosest {

  public static void main(String[] args) {
    ArrayList<Integer> A = new ArrayList<>(
        Arrays.asList(-2147483648, -2147483648, -2147483648, 2147483647, 2147483647, 2147483647));
    System.out.println(new ThreeSumClosest().threeSumClosest(A, 2147483640));
  }

  public int threeSumClosest(ArrayList<Integer> A, int B) {

    int n = A.size();

    int l = -1;
    int r = n - 1;
    long diff = Long.MAX_VALUE;
    long s = 0;
    long b = B;

    long result = 0;
    Collections.sort(A);
    for (int i = 0; i < n - 2; i++) {
      l = i + 1;
      r = n - 1;
      while (l < r) {
        s = (long) A.get(i) + (long) A.get(l) + (long) A.get(r);
        if (s == b) {
          return B;
        } else if (s < b) {
          l++;
        } else {
          r--;
        }

        if (diff > Math.abs(s - b)) {
          diff = Math.abs(s - b);
          result = s;
        }//if

      }

    }
    return (int) result;


  }

}
