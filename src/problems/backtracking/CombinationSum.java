package problems.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class CombinationSum {

  public static void main(String[] args) {
    ArrayList<Integer> A = new ArrayList<>(Arrays.asList(8, 10, 6, 11, 1, 16, 8));
    System.out.println(new CombinationSum().combinationSum(A, 28));
  }

  ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

  public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int sum) {
    int n = A.size();
    Collections.sort(A);
    ArrayList<Integer> B = new ArrayList<>();

    // remove duplicates
    int i = 0;
    while (i < n) {
      B.add(A.get(i));
      int j = i + 1;
      while (j < n && A.get(i) == A.get(j)) {
        j++;
      }
      i = j;
    }

    combnSum(B, 0, sum, B.size(), new ArrayList<Integer>(), 0);
    return result;
  }

  public void combnSum(ArrayList<Integer> A, int i, int sum, int n, ArrayList<Integer> temp,
      int tempSum) {
    if (tempSum == sum) {
      result.add(new ArrayList<>(temp));
    } else if (tempSum < sum && i < n) {

      tempSum = tempSum + A.get(i);
      temp.add(A.get(i));
      combnSum(A, i, sum, n, temp, tempSum);
      temp.remove(temp.size() - 1);
      tempSum = tempSum - A.get(i);
      combnSum(A, i + 1, sum, n, temp, tempSum);

    }

  }


}
