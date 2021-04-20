package problems.contests.codeforces;

import java.util.Scanner;

public class RemoveSmallest {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = Integer.parseInt(sc.nextLine());

    while (t-- > 0) {
      int n = Integer.parseInt(sc.nextLine());
      String[] arr = sc.nextLine().split(" ");
      int[] nums = new int[n];
      for (int i = 0; i < n; i++) {
        nums[i] = Integer.parseInt(arr[i]);
      }
      if (n == 1 || partition(nums, 0, 0, Integer.MIN_VALUE, Integer.MIN_VALUE, 0)) {
        System.out.println("YES");
      } else {
        System.out.println("NO");
      }

    }
    sc.close();
  }

  static boolean partition(int[] nums, int i, int sumA, int maxA, int maxB, int sumB) {
    if (i == nums.length) {
      if (Math.abs(sumA - sumB) <= 1 && Math.abs(maxA - maxB) <= 1) {
        return true;
      }
      return false;
    }

    if (partition(nums, i + 1, nums[i] + sumA, Math.max(nums[i], maxA), maxB, sumB) || partition(
        nums, i + 1, sumA, maxA, Math.max(nums[i], maxB), sumB + nums[i])) {
      return true;
    }

    return false;


  }


}
