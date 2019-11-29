package problems.math;
/**
 * Problem Statement See <a href="https://www.interviewbit.com/problems/numbers-of-length-n-and-value-less-than-k/">
 * Set Numbers Of Length N and Value Less Than K</a>
 * <p>Time Complexity - O(nlogC) </p>
 *
 * @author Harsha Prabha E
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class NumerOfLengthDAndValueLessThanK {

  public static void main(String[] args) {
    NumerOfLengthDAndValueLessThanK solution = new NumerOfLengthDAndValueLessThanK();
    int A[] = {2, 3, 5, 6, 7, 9};
    int C = 42950;
    int B = 5;
    System.out.println(solution
        .solve(Arrays.stream(A).boxed().collect(Collectors.toCollection(ArrayList::new)), B, C));

  }

  public int solve(ArrayList<Integer> A, int B, int C) {
    boolean zeroflg = false;
    int Clength = (int) Math.log10(C) + 1;

    int n = A.size();

    if (n == 0 || B == 0) {
      return 0;
    }

    if (n < B) {
      return 0;
    }

    if (A.get(0) == 0) {
      zeroflg = true;
    }

    if (B > Clength) {
      return 0;
    }

    if (B < Clength) {
      if (zeroflg && B > 1) {
        return n - 1 * (int) Math.pow(n - 1, B - 1);
      } else {
        return (int) Math.pow(n, B);
      }

    }

    return compute(A, B, C, zeroflg, B);

  }


  public int compute(ArrayList<Integer> A, int d, int C, boolean zeroflg, int digit) {
    int Clength = (int) Math.log10(C) + 1;
    int count = 0;
    if (d == 0) {
      return 0;
    }

    int limit = getUpperLimitbyPos(C, d);

    int lessThanLimit = getNosLesserThanLimit(A, limit);
    lessThanLimit = zeroflg && d == Clength && digit > 1 ? --lessThanLimit : lessThanLimit;

    if (d == 1) {
      count += lessThanLimit;
    } else {
      count += lessThanLimit * Math.pow(A.size(), d - 1);
    }

    count += 1 * compute(A, d - 1, C, zeroflg, digit);
    return count;

  }


  public int getUpperLimitbyPos(int C, int d) {
    String no = String.valueOf(C);
    return no.charAt(no.length() - d) - '0';
  }

  public int getNosLesserThanLimit(ArrayList<Integer> A, int limit) {
    //using binary search
    int n = A.size();
    int low = 0;
    int high = n - 1;
    while (low <= high) {
      int mid = (low + high) / 2;

      if (A.get(mid) == limit) {
        return mid;
      } else if (A.get(mid) < limit) {
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }

    return low;

  }
}
