package problems.divideAndConquer;

public class MinCostTreeFromLeafValues {

  public static void main(String[] args) {
    int arr[] = {4, 3, 2, 1};
    System.out.println(new MinCostTreeFromLeafValues().mctFromLeafValues(arr));
  }

  int sumMin = Integer.MAX_VALUE;

  public int mctFromLeafValues(int[] arr) {
    int n = arr.length;

    if (n == 1) {
      return 0;
    }

    minCostTree(0, n - 1, arr);
    return sumMin;
  }


  int[] minCostTree(int left, int right, int[] arr) {

    if (left >= right) {
      return new int[]{arr[right], 0}; // maxLeaf, sum
    }

    int[] leftValue = new int[3];
    int[] rightValue = new int[3];
    int maxLeaf = 0;
    int prod = 1;
    int sum = Integer.MAX_VALUE;

    for (int k = left; k < right; k++) {
      leftValue = minCostTree(left, k, arr);
      rightValue = minCostTree(k + 1, right, arr);

      sum = Math.min(leftValue[1] + rightValue[1] + (leftValue[0] * rightValue[0]), sum);
      if (left == 0 && right == arr.length - 1) {
        sumMin = Math.min(sum, sumMin);
      }
    }

    return new int[]{Math.max(leftValue[0], rightValue[0]), sum};


  }

}
