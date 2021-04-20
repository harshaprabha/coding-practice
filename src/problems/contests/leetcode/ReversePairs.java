package problems.contests.leetcode;

public class ReversePairs {

  public static void main(String[] args) {
    int[] A = {1, 3, 2,1};
    System.out.println(new ReversePairs().reversePairs(A));
  }

  public int reversePairs(int[] nums) {
    int n = nums.length;
    if (n <= 1) {
      return 0;
    }

    return mergeSort(0, n - 1, nums);

  }

  int mergeSort(int start, int end, int[] nums) {
    if (start >= end) {
      return 0;
    }

    int mid = (start + end) / 2;
    int leftInversionCount = mergeSort(start, mid, nums);
    int rightInversionCount = mergeSort(mid + 1, end, nums);

    int j = mid + 1, i = start;
    int count = 0;
    // count inversions before merge
    while (i <= mid && j <= end) {
      while (i <= mid && j <= end && 1l * nums[i] <= 2l * nums[j]) {
        i++;
      }
      count += (mid - start + 1 - i);
      j++;
    }

    merge(start, mid, end, nums);
    return leftInversionCount + rightInversionCount + count;
  }

  void merge(int start, int mid, int end, int[] nums) {
    int m = mid - start + 1;
    int n = end - mid;

    int left[] = new int[m];
    int right[] = new int[n];
    int l = 0;
    int r = 0;

    for (int i = start; i <= mid; i++) {
      left[l++] = nums[i];
    }
    for (int j = mid + 1; j <= end; j++) {
      right[r++] = nums[j];
    }

    // System.out.println("start m=" + start);
    // System.out.println("left m=" + m);
    // System.out.println("right n=" + n);
    // perform merge
    l = 0;
    r = 0;

    // System.out.println("start m=" + start);
    // System.out.println("left m=" + m);
    // System.out.println("right n=" + n);
    // perform merge

    for (int k = start; k <= end; k++) {
      if (r >= n || (l < m && left[l] <= right[r])) {
        nums[k] = left[l++];
      } else {
        // right is lesser
        nums[k] = right[r];
        r++;
      }
    }


  }

}
