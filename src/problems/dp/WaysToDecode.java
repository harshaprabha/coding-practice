package problems.dp;

import java.util.ArrayList;

public class WaysToDecode {

  ArrayList<ArrayList<Integer>> result = new ArrayList<>();

  public static void main(String[] args) {
    new WaysToDecode().numDecodings("1325");
  }

  public void numDecodings(String A) {
    int n = A.length();

    //findWaysToDecode(A, n, 0, new ArrayList<>());
    System.out.println(findWaysToDecode2(A, n, 0, 1));

  }


  void findWaysToDecode(String A, int n, int i, ArrayList<Integer> temp) {

    if (i >= n) {
      result.add(new ArrayList<>(temp));
      return;
    }
    for (int p = 1; p <= 2; p++) {
      if ((i + p) <= n) {

        if (Integer.parseInt(A.substring(i, i + p)) <= 26) {
          temp.add(Integer.parseInt(A.substring(i, i + p)));
          findWaysToDecode(A, n, i + p, temp);
          temp.remove(temp.size() - 1);
        }

      }//if
    }//for

  }


  int findWaysToDecode1(String A, int n, int i) {

    int count = 0;

    if (i >= n) {
      return 1;
    }

    for (int p = 1; p <= 2; p++) {
      if ((i + p) <= n) {
        if (Integer.parseInt(A.substring(i, i + p)) <= 26) {
          count += findWaysToDecode1(A, n, i + p);
        }

      }//if
    }//for

    return count;
  }


  int findWaysToDecode2(String A, int n, int i, int p) {

    int count = 0;

    if (p > 2) {
      return 0;
    }

    if (i >= n) {
      return 1;
    }

    if ((i + p) <= n) {
      if (Integer.parseInt(A.substring(i, i + p)) <= 26) {
        count += (findWaysToDecode2(A, n, i + p, p) + findWaysToDecode2(A, n, i + p, p + 1));
      }

    }//if

    return count;
  }


}
