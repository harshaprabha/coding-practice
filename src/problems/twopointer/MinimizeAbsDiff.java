package problems.twopointer;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Problem Statement See <a href="https://www.interviewbit.com/problems/minimize-the-absolute-difference/">
 * Minimize The Absolute Difference</a>
 * <p>Time Complexity - O(a+b+c)</p>
 *
 * @author Harsha Prabha E
 */
public class MinimizeAbsDiff {

  public static void main(String[] args) {
    ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1, 4, 5, 8, 10));
    ArrayList<Integer> B = new ArrayList<>(Arrays.asList(6, 9, 10));
    ArrayList<Integer> C = new ArrayList<>(Arrays.asList(2, 3, 6, 10));
    System.out.println(new MinimizeAbsDiff().solve(A, B, C));
  }

  public int solve(ArrayList<Integer> A, ArrayList<Integer> B, ArrayList<Integer> C) {

    int an = A.size();
    int bn = B.size();
    int cn = C.size();

    int a = 0, b = 0, c = 0;
    int result = Integer.MAX_VALUE;

    while (a < an && b < bn && c < cn) {
      int max = Math.max(A.get(a), Math.max(B.get(b), C.get(c)));
      int min = Math.min(A.get(a), Math.min(B.get(b), C.get(c)));

      result = Math.min(result, Math.abs(max - min));

      if (result == 0) {
        return 0;
      }

      if (A.get(a) == min) {
        a++;
      } else if (B.get(b) == min) {
        b++;
      } else {
        c++;
      }

    }

    return result;
  }
}
