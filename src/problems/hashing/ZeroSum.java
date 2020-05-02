package problems.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ZeroSum {

  public static void main(String[] args) {
    System.out.println(new ZeroSum().lszero(new ArrayList<>(Arrays
        .asList(-9, -13, 6, -28, 27, -5, -27, 17, 15, -17, -25, 6, -8, 2, -13, -13, -23, 21, -4, 22,
            -9, -10, 0, -28, -11, 8, 8, 17))));
  }

  public ArrayList<Integer> lszero(ArrayList<Integer> A) {
    int n = A.size();
    Map<Integer, Integer> start = new HashMap<>();
    Map<Integer, Integer> end = new HashMap<>();
    ArrayList<Integer> result = new ArrayList<Integer>();
    ArrayList<Integer> countArr = new ArrayList<Integer>();

    countArr.add(A.get(0));
    for (int i = 1; i < n; i++) {
      int value = A.get(i) + countArr.get(i - 1);
      countArr.add(value);
    }

    for (int j = 0; j < n; j++) {
      if (!start.containsKey(countArr.get(j))) {
        start.put(countArr.get(j), j);
      } else {
        end.put(countArr.get(j), j);
      }

    }

    int from = -1;
    int to = -1;
    int maxDiff = Integer.MIN_VALUE;
    boolean isZero = false;
    int startindex = -1;
    int endIndex = -1;

    for (Map.Entry<Integer, Integer> entry : start.entrySet()) {

      int key = entry.getKey();

      if (key == 0) {
        if (end.containsKey(key)) {
          endIndex = end.get(key);
        } else {
          endIndex = entry.getValue();
        }
        startindex = -1;
      } else if (end.containsKey(key)) {
        startindex = entry.getValue();
        endIndex = end.get(key);

      }

      if (endIndex - startindex > maxDiff) {
        to = endIndex;
        from = startindex;
        maxDiff = to - from;
      }

    }//for

    if (from == -1 && to == -1) {
      return result;
    }

    for (int k = from + 1; k <= to; k++) {

      result.add(A.get(k));

    }

    return result;

  }
}
