package problems.contests.topcoder;

import java.util.ArrayList;

public class SmallestRegular {

  int[] findLexSmallest(String S) {
    ArrayList<Integer> result = new ArrayList<>();

    for (int i = 1; i < S.length(); i++) {

      if (S.charAt(i) == '(') {

        if (S.charAt(i - 1) == ')') {

          int j = i;
          while (S.charAt(j) != '(') {
            j++;
          }

          result.add(0);
          result.add(j - 1);
          result.add(j);

          S = '(' + S.substring(0, j) + S.substring(j + 1, S.length());
        } else {
          continue;
        }

      }


    }

    int arr[] = new int[result.size()];
    for (int i = 0; i < result.size(); i++) {
      arr[i] = result.get(i);
    }
    return arr;
  }
}

