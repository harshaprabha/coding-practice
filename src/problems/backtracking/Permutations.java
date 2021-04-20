package problems.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Permutations {

  static List<List<Integer>> result = new ArrayList<>();

  public static void main(String[] args) {
    int[] A = {1, 2,3};
    new Permutations().permute(A);
    System.out.println(result);
  }

  public List<List<Integer>> permute(int[] nums) {

    int n = nums.length;
    if (n == 0) {
      return result;
    }

    List<Integer> arr = Arrays.stream(nums).boxed().collect(Collectors.toList());
    permutation(arr, 0);
    return result;

  }


  void permutation(List<Integer> arr, int i) {
    if (i == arr.size() - 1) {
      result.add(new ArrayList<>(arr));
      return;
    }

    for (int j = i; j < arr.size(); j++) {

      Collections.swap(arr, i,j);

      permutation(arr, i+1);

      Collections.swap(arr, i,j);// undo

    }//for


  }



}
