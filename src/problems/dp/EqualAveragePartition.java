package problems.dp;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

class Pair {

  ArrayList<Integer> A;
  ArrayList<Integer> B;

  Pair(ArrayList<Integer> A, ArrayList<Integer> B) {
    this.A = A;
    this.B = B;
  }


}

public class EqualAveragePartition {

  static Set<ArrayList<Integer>> result = new HashSet<>();
  static List<Pair> output = new LinkedList<>();

  public static void main(String[] args) {
    //ArrayList<Integer> inp=new ArrayList<>(Arrays.asList( 2, 36, 10, 9, 34, 19, 32, 39, 34, 36));
    ArrayList<Integer> inp = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
    // ArrayList<Integer> inp=new ArrayList<>(Arrays.asList( 1 ,7 ,15 ,29 ,11 ,9));
    Collections.sort(inp);
    new EqualAveragePartition()
        .getAvgPartition(new ArrayList<>(), new ArrayList<>(), inp, 0, 0, inp.size(), 0);

    System.out.println(output);
  }


  void getAvgPartition(ArrayList<Integer> tempA, ArrayList<Integer> tempB, ArrayList<Integer> A,
      int sumA, int sumB, int n, int i) {

    if (tempA.size() > 0 && tempB.size() > 0 && sumA * tempB.size() == sumB * tempA.size()
        && tempA.size() + tempB.size() == n) {
      if (!result.contains(tempA) && !result.contains(tempB)) {
        result.add(new ArrayList<>(tempA));
        result.add(new ArrayList<>(tempB));
        if (tempA.size() < tempB.size()) {
          output.add(new Pair(new ArrayList<Integer>(tempA), new ArrayList<Integer>(tempB)));
        } else {
          output.add(new Pair(new ArrayList<Integer>(tempB), new ArrayList<Integer>(tempA)));
        }
        return;
      }
    }
    if (i == n) {
      return;
    }

    tempA.add(A.get(i));
    getAvgPartition(tempA, tempB, A, sumA + A.get(i), sumB, n, i + 1);
    tempA.remove(tempA.size() - 1);
    tempB.add(A.get(i));
    getAvgPartition(tempA, tempB, A, sumA, sumB + A.get(i), n, i + 1);
    tempB.remove(tempB.size() - 1);

  }

}
