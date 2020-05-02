package problems.array;
/**
 * Problem Statement See <a href="https://www.interviewbit.com/problems/rotated-sorted-array-search/">
 * Rotated Sorted Array Search</a>
 * <p>Time Complexity - O(logn) </p>
 *
 * @author Harsha Prabha E
 */

import java.util.Arrays;
import java.util.List;

public class RotatedSortedArraySearch {

  public static void main(String[] args) {
    RotatedSortedArraySearch rotatedSortedArraySearch = new RotatedSortedArraySearch();
    List<Integer> A = Arrays.asList(6, 7, 0, 1, 2, 3);
    System.out.println(rotatedSortedArraySearch.search(A, 7));
    StringBuilder s= new StringBuilder();
    s.reverse().toString();

  }

  /*
  Method 1 : O(logN) in 2 loops
   */
  public int search(final List<Integer> A, int B) {

    int n = A.size();
    if (n == 0) {
      return -1;
    }
    if (n == 1 && A.get(0) == B) {
      return 0;
    }

    //get start index of rotated array
    int low = 0;
    int high = n - 1;
    int result = -1;
    int highValue = A.get(n - 1);

    while (low <= high) {

      int mid = (low + high) / 2;
      int prevMid = (mid - 1 + n) % n;

      if (A.get(prevMid) > A.get(mid)) {
        result = mid;
        break;
      } else if (A.get(mid) > highValue) {
        low = mid + 1;
      } else {
        high = mid - 1;
      }

    }

    //search rotated array for B
    return bSearch(A, n - 1, result, B);

  }

  public int bSearch(List<Integer> A, int n, int result, int B) {
    int res = -1;

    int low = result;
    int high = (result - 1 + n) % n;
    int mid = -1;
    int c = 0;
    while (c <= n) {

      if (low <= high) {
        mid = (low + high) / 2;
      } else {
        mid = (((low + (n - low + high)) % n) / 2);
      }

      if (A.get(mid) == B) {
        res = mid;
        c++;
        return res;
      } else if (A.get(mid) < B) {
        low = (mid + 1) % n;
        c++;
      } else {
        high = (mid - 1 + n) % n;
        c++;
      }

    }

    return res;
  }

}
