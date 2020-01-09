package problems.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Problem Statement See <a href="https://www.interviewbit.com/problems/subset/"> Subsets</a>
 * <p>Time Complexity - O(2^n)</p>
 *
 * @author Harsha Prabha E
 */
public class Subsets {

  public static void main(String[] args) {
    ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1, 2, 3));
    subsetsIterativeNoOrder(A);
    System.out.println(new Subsets().subsets(A));

  }

  public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {

    ArrayList<ArrayList<Integer>> output = new ArrayList<ArrayList<Integer>>();
    Collections.sort(A);
    output.add(new ArrayList<Integer>());
    subsetsInLexicographicalOrder(output, A, new ArrayList<Integer>(), -1, A.size());
    return output;

  }

  void subsetsInLexicographicalOrder(ArrayList<ArrayList<Integer>> output, ArrayList<Integer> A,
      ArrayList<Integer> temp,
      int k, int n) {

    k = k + 1;

    if (k == n) {
      return;
    }

    temp.add(A.get(k));
    output.add(new ArrayList<Integer>(temp));
    subsetsInLexicographicalOrder(output, A, temp, k, n);
    temp.remove(temp.size() - 1);

    subsetsInLexicographicalOrder(output, A, temp, k, n);

  }

  void subsetsNoOrder(ArrayList<ArrayList<Integer>> output, ArrayList<Integer> A,
      ArrayList<Integer> temp,
      int k, int n) {

    k = k + 1;

    if (k == n) {
      return;
    }

    subsetsNoOrder(output, A, temp, k, n);
    temp.add(A.get(k));

    subsetsNoOrder(output, A, temp, k, n);
    output.add(new ArrayList<Integer>(temp));
    temp.remove(temp.size() - 1);


  }

  static void subsetsIterativeNoOrder(ArrayList<Integer> A) {

    ArrayList<ArrayList<Integer>> output;

    Queue<ArrayList<Integer>> queue = new LinkedList<>();
    queue.add(new ArrayList<>());

    for (int i = 0; i < A.size(); i++) {

      while (!queue.isEmpty()) {
        ArrayList<Integer> list = queue.poll();
        list.add(A.get(i));
        queue.add(new ArrayList<>(list));
        list.remove(list.size() - 1);
        queue.add(new ArrayList<>(list));
        // Use empty set as marker set
        if (list.isEmpty()) {
          break;
        }

      }

    }

    while (!queue.isEmpty()) {
      System.out.println(queue.poll());
    }


  }


}
