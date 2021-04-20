package problems.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {

  public static void main(String[] args) {
    int[] A={2,3,6,7};
    System.out.println(new CombinationSum().combinationSum(A, 7));
  }


  List<List<Integer>> result = new ArrayList<>();

  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    int n = candidates.length;

    if (n == 0) {
      return result;
    }

    combination(0, new ArrayList<>(), target, candidates);
    return result;
  }

  void combination(int i, ArrayList<Integer> temp, int target, int[] candidates) {
    if (target == 0) {
      result.add(new ArrayList<>(temp));
      return;
    }

    if (i >= candidates.length) {
      return;
    }

    for (int k = i; k < candidates.length; k++) {
      if (candidates[k] <= target) {
        temp.add(candidates[k]);
        combination(k, temp, target - candidates[k], candidates);
        temp.remove(temp.size() - 1);
      }
    }

  }


}
