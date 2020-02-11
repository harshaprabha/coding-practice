package problems.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class CombinationSumII {

  public static void main(String[] args) {
    ArrayList<Integer> A = new ArrayList<>(Arrays.asList(10, 1, 2, 7, 6, 1, 5));
    System.out.println(new CombinationSumII().combinationSum(A, 8));
  }

  ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
  HashSet<ArrayList<Integer>> set = new HashSet<ArrayList<Integer>>();

  public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int sum) {
    int n = A.size();
    Collections.sort(A);
    //for (int i = 0; i < n; i++) {
    combnSum(A, 0, sum, A.size(), new ArrayList<Integer>(), 0);
    //}
    return result;
  }

  public void combnSum(ArrayList<Integer> A, int i, int sum, int n, ArrayList<Integer> temp,
      int tempSum) {

    if (tempSum == sum && !set.contains(temp)) {
      result.add(new ArrayList<>(temp));
      set.add(temp);
    } else {
      while (tempSum < sum && i < n) {
        tempSum = tempSum + A.get(i);
        temp.add(A.get(i));
        combnSum(A, i + 1, sum, n, temp, tempSum);
        temp.remove(temp.size() - 1);
        tempSum = tempSum - A.get(i);
        i++;
      }

    }


  }

}
