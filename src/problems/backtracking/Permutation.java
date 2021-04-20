package problems.backtracking;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Problem Statement : Find all permutations of a set with unique numbers
 * <p>Time Complexity - O(n!)</p>
 *
 * @author Harsha Prabha E
 */

public class Permutation {

  static ArrayList<ArrayList<Integer>> result = new ArrayList<>();
  public static void main(String[] args) {
    ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1, 2, 3));
    new Permutation().permutations(A, 0, 3, new ArrayList<>());
    System.out.println(result);
  }

  void permutations(ArrayList<Integer> A, int i, int n, ArrayList<Integer> temp) {

    if (i >= n) {
      if (temp.size() == n) {
        result.add(new ArrayList<>(temp));
      }
      return;
    }

    for (int j = i; j < n; j++) {
      swap(A, i, j);
      temp.add(A.get(i));
      permutations(A, i + 1, n, temp);
      temp.remove(temp.size() - 1);
      swap(A,i,j);// undo swap

    }
  }

  void swap(ArrayList<Integer> A, int i, int j) {
    int iValue = A.get(i);
    int jValue = A.get(j);
    A.set(i, jValue);
    A.set(j, iValue);
  }
}
