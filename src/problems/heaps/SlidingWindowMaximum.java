package problems.heaps;

import java.util.TreeMap;

public class SlidingWindowMaximum {

  public static void main(String[] args) {
    int[] nums = {7,5,7,1,6,0};
    int[] res = new SlidingWindowMaximum().maxSlidingWindow(nums, 4);
    for (int i : res) {
      System.out.println(i);
    }
  }

  public int[] maxSlidingWindow(int[] nums, int k) {

    int n = nums.length;

    int[] ans = new int[n - k + 1];
    int a = 0;
    TreeMap<Integer, Integer> tmap = new TreeMap<>((b, c) -> nums[c] - nums[b]);

    for (int i = 0; i < k - 1; i++) {
      tmap.put(i, i);
    }

    int left = 0;
    int right = k - 1;

    while (left < n && right < n) {
      tmap.put(right, right);
      ans[a++] = nums[tmap.firstKey()];// get index of max value
      tmap.remove(left);         // remove left index
      right++;
      left++;
    }

    return ans;
  }

}
