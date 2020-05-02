package problems.dp;

import java.util.ArrayList;

/**
 * O(n^2) is DP - come up with 2^n combinations of intervals and optimize O(nlogn) is Greedy
 */

class Pair implements Comparable {

  int start;
  int end;

  Pair(int s, int e) {
    this.start = s;
    this.end = e;
  }

  @Override
  public int compareTo(Object o) {
    return this.end - ((Pair) o).end;
  }
}

public class ActivitySelection {

  public static void main(String[] args) {

    int S[] = {1, 3};
    int E[] = {2, 5};
    int N = S.length;

    ArrayList<Pair> pairs = new ArrayList<>();
    pairs.addAll(new ActivitySelection().createPairs(S, E));
    System.out.println(new ActivitySelection().countActivitiesDp(pairs, 0, 1, N));

  }


  int countActivitiesDp(ArrayList<Pair> pairs, int prev, int i, int n) {

    if (i == n) {
      return 0;
    }

    int ans = 0;

    ans = countActivitiesDp(pairs, prev, i + 1, n);

    if ( pairs.get(prev).end <= pairs.get(i).start) {
      ans += Math
          .max(ans, 1 + countActivitiesDp(pairs, i, i + 1, n));

    }

    return ans;
  }

  ArrayList<Pair> createPairs(int[] S, int E[]) {
    ArrayList<Pair> p = new ArrayList<>();
    for (int i = 0; i < S.length; i++) {
      p.add(new Pair(S[i], E[i]));
    }
    return p;
  }


}
