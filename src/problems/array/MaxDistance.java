package problems.array;

/**
 * Problem Statement See <a href="https://www.interviewbit.com/problems/max-distance/">
 * Max Distance</a>
 * <p>Time Complexity - O(nlogn) </p>
 *
 * @author Harsha Prabha E
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MaxDistance {

  class ArrayObj {

    Integer ele;
    int index;

    ArrayObj(Integer ele1, int in) {
      ele = ele1;
      index = in;
    }

  }

  public int maximumGap(final List<Integer> A) {
    List<ArrayObj> arraylist = new ArrayList<>();
    int n = A.size();

    if (A.get(0) < A.get(n - 1)) {
      return n - 1;
    }

    if (n == 1) {
      return 0;
    }

    if (n == 0) {
      return -1;
    }

    for (int i = 0; i < n; i++) {
      arraylist.add(new ArrayObj(A.get(i), i));
    }

    Collections.sort(arraylist, new Comparator<ArrayObj>() {
      @Override
      public int compare(ArrayObj ob1, ArrayObj ob2) {
        return ob1.ele - ob2.ele;
      }

    });

    int max = arraylist.get(n - 1).index;
    int maxdiff = 0;

    for (int k = n - 1; k >= 0; k--) {
      max = Math.max(max, arraylist.get(k).index);
      maxdiff = Math.max(maxdiff, max - arraylist.get(k).index);
    }

    return maxdiff;


  }
}


}
