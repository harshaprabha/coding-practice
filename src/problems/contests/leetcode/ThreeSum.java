package problems.contests.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ThreeSum {

  public static void main(String[] args) {
    int[] inp = {-1, 0, 1, 2, -1, -4};
    int target = 0;
    System.out.println(new ThreeSum().threeSum2(inp));
  }

  //
  public List<List<Integer>> threeSum(int[] nums) {

    List<List<Integer>> result = new ArrayList<>();

    Map<Integer, Integer> hmap;
    Set<List<Integer>> set = new HashSet<>();
    int n = nums.length;

    int sum = 0;

    for (int i = 0; i < n; i++) {
      //keep one fixed
      sum = 0 - nums[i];
      hmap = new HashMap<>();

      for (int j = i + 1; j < n; j++) {
        if (i != j) {
          if (hmap.get(nums[j]) != null) {

            ArrayList<Integer> newArr = new ArrayList<>(
                Arrays.asList(nums[i], nums[j], sum - nums[j]));
            Collections.sort(newArr);
            if (!set.contains(newArr)) {
              result.add(newArr);
              set.add(newArr);
            }

          } else {
            hmap.put(sum - nums[j], j);
          }
        }

      }

    }//for

    return result;


  }


  public List<List<Integer>> threeSum2(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();

    Arrays.sort(nums);
    int n = nums.length;

    if (n == 0) {
      return result;
    }

    for (int i = 0; i < n; i++) {

      if (i > 0 && nums[i] == nums[i - 1]) {
        continue;
      }

      int low = i + 1;
      int high = n - 1;

      while (low < high) {

        if (nums[low] + nums[high] + nums[i] == 0) {
          result.add(new ArrayList<>(Arrays.asList(nums[low], nums[high], nums[i])));
          while (low < high && nums[low] == nums[low + 1])   // remove duplicates
          {
            low++;
          }
          while (low < high && high > 0 && nums[high] == nums[high - 1]) {
            high--;
          }

          low++;
          high--;
        } else if (nums[low] + nums[high] + nums[i] < 0) {
          low++;
        } else {
          high--;
        }
      }

    }

    return result;
  }

}
