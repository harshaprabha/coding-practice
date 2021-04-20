package problems.twopointer;

public class SubArraySum {


  public static void main(String[] args) {
    System.out.println(new SubArraySum().subarraySum(new int[]{1, 1, 1}, 2));
  }

  public int subarraySum(int[] nums, int k) {

    int n = nums.length;
    int[] prefix = new int[n + 1];

    for (int i = 1; i < n + 1; i++) {
      prefix[i] = prefix[i - 1] + nums[i - 1];
    }

    int ans = 0;
    for (int i = 0; i < n + 1; i++) {
      int f = checkIfPresent(k + prefix[i], prefix, true);
      int l = checkIfPresent(k + prefix[i] + 1, prefix, false);
      System.out.println("first=" + f);
      System.out.println("last=" + l);
      if (f == -1) {
        continue;
      }

      ans += (l == f ? 1 : l - f);
    }
    return ans;
  }

  // find the first occurence of number == v
  int checkIfPresent(int v, int[] prefix, boolean first) {
    int low = 0;
    int high = prefix.length - 1;
    int ans = high+1;

    while (low <= high) {
      int mid = (low + high) / 2;
      if (prefix[mid] >= v) {
        ans = mid;
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }
    if (first) {
      return prefix[ans] == v ? ans : -1;
    }

    return ans;

  }

}
