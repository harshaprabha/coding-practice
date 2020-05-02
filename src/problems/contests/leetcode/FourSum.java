package problems.contests.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FourSum {

  List<List<Integer>> result = new ArrayList<>();
  Set<List<Integer>> set = new HashSet<>();

  public static void main(String[] args) {
    int[] inp = {1, 2, 4, 3, 5};
    int target = 6;
   // System.out.println(new FourSum().fourSum(inp, target));
  }

  public List<List<Integer>> fourSum(int[] nums, int target) {

    int n = nums.length;
    findSum(nums, 0, target, new ArrayList<>());
    return result;
  }

  void findSum(int[] nums, int i, int target, ArrayList<Integer> temp) {

    if (i > nums.length) {
      return;
    }
   // System.out.println(temp);
    if (temp.size() == 2) {

      System.out.println(temp);
      if (target == 0) {
        List<Integer> newArr = new ArrayList<>();
        newArr.addAll(temp);
        Collections.sort(newArr);

        if (!set.contains(newArr)) {
          set.add(new ArrayList<>(newArr));
          result.add(new ArrayList<>(newArr));
        }

      }//if

      return;
    }//if



    //include
    temp.add(nums[i]);
    findSum(nums, i + 1, target - nums[i], temp);
    temp.remove(temp.size() - 1);

    //dont include
    findSum(nums, i + 1, target, temp);

  }


}
