package problems.math;
/**
 * Problem Statement See <a href="https://www.interviewbit.com/problems/search-for-a-range/"> Search
 * for a range</a>
 * <p>Time Complexity - O(logn) </p>
 *
 * @author Harsha Prabha E
 */

import java.util.ArrayList;
import java.util.List;

public class SearchForRange {

  public ArrayList<Integer> searchRange(final List<Integer> a, int b) {
    ArrayList<Integer> result = new ArrayList<Integer>();

    int s = binarySearch(a, b, true);
    int e = binarySearch(a, b, false);

    result.add(s);
    result.add(e);
    return result;

  }


  public int binarySearch(List<Integer> A, int b, boolean first) {

    int low = 0;
    int high = A.size() - 1;
    int result = -1;

    while (low <= high) {
      int mid = (low + high) / 2;

      if (A.get(mid) == b) {
        result = mid;
        if (first) {
          high = mid - 1;
        } else {
          low = mid + 1;
        }
      } else if (A.get(mid) < b) {
        low = mid + 1;
      } else {
        high = mid - 1;
      }

    }
    return result;
  }


}
