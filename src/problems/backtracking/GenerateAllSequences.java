package problems.backtracking;

import java.util.ArrayList;

public class GenerateAllSequences {

  public static void main(String[] args) {
    int[] A = {1, 2, 3};
    new GenerateAllSequences().combinationSum4Recursive(0, 4, A, new ArrayList<Integer>());
  }

  public int combinationSum4Recursive(int i, int sumleft, int[] nums, ArrayList<Integer> arr) {

    int count = 0;
    if (sumleft == 0) {
      System.out.println(arr);
      return 1;
    }

    if (i < 0 || i == nums.length) {
      return 0;
    }

    count = combinationSum4Recursive(i + 1, sumleft, nums, arr);
    if (sumleft >= nums[i]) {
      arr.add(nums[i]);
      //System.out.println(arr);
      count += combinationSum4Recursive(i, sumleft - nums[i], nums, arr);
      arr.remove(arr.size() - 1);
    }
    return count;

  }

}
