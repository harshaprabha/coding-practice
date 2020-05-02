package problems.heaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Set;

public class NMaxPairCombination {

  public static void main(String[] args) {
    ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
    ArrayList<Integer> B = new ArrayList<>(Arrays.asList(5, 6, 7, 8));
    System.out.println(new NMaxPairCombination().solve(A, B));
  }

  class PairSum implements Comparable<PairSum> {

    int sum;
    int i;
    int j;

    public PairSum(int sum, int i, int j) {
      this.sum = sum;
      this.i = i;
      this.j = j;
    }

    @Override
    public int compareTo(PairSum o) {
      return Integer.valueOf(o.sum).compareTo(this.sum);
    }
  }

  class Pair {

    int i;
    int j;

    public Pair(int i, int j) {
      this.i = i;
      this.j = j;
    }

    @Override
    public boolean equals(Object obj) {
      if (obj == null) {
        return false;
      }
      if (!(obj instanceof Pair)) {
        return false;
      }
      Pair p = (Pair) obj;

      return this.i == p.i && this.j == p.j;
    }


    @Override
    public int hashCode() {
      return Objects.hash(i, j);
    }
  }


  public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B) {
    int n = A.size();

    Collections.sort(A);
    Collections.sort(B);

    ArrayList<Integer> result = new ArrayList<Integer>();
    PriorityQueue<PairSum> pq = new PriorityQueue<PairSum>(Collections.reverseOrder());
    Set<Pair> set = new HashSet<Pair>();

    int c = 0;
    pq.add(new PairSum(A.get(n - 1) + B.get(n - 1), n - 1, n - 1));
    set.add(new Pair(n - 1, n - 1));

    for (int k = 0; k < n; k++) {
      PairSum pairSum = pq.remove();
      result.add(pairSum.sum);

      int i = pairSum.i;
      int j = pairSum.j;
      PairSum sum = null;

      if (j - 1 >= 0 && i >= 0) {
        sum = new PairSum(A.get(i) + B.get(j - 1), i, j - 1);
        Pair pair = new Pair(i, j - 1);
        if (!set.contains(pair)) {
          pq.add(sum);
          set.add(pair);
        }

      }
      if (i - 1 >= 0 && j >= 0) {
        sum = new PairSum(A.get(i - 1) + B.get(j), i - 1, j);
        Pair pair = new Pair(i - 1, j);
        if (!set.contains(sum)) {
          pq.add(sum);
          set.add(pair);
        }
      }

    }
    return result;


  }

}


