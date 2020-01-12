package problems.backtracking;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Problem Statement : Find all permutations of a set with unique numbers
 * <p>Time Complexity - O(n^2)</p>
 *
 * @author Harsha Prabha E
 */

public class Permutation {

  public static void main(String[] args) {
    ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1, 2, 3));
    System.out.println(new Permutation().permute(A));

  }

  ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

  public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {
    int n = A.size();
    permutation(A, 0, n - 1);
    return result;

  }

  public void swap(ArrayList<Integer> A, int i, int j) {
    Integer temp = A.get(i);
    A.set(i, A.get(j));
    A.set(j, temp);
  }

  public void permutation(ArrayList<Integer> A, int left, int right) {

    if (left == right) {
      result.add(new ArrayList<>(A));
      return;
    }

    for (int i = left; i <= right; i++) {
      swap(A, left, i);
      permutation(A, left + 1, right);
    }


  }


}
