package problems.dp;

public class MaxSumWithoutAdjacentElements {

  public static void main(String[] args) {
    int A[][] = {{2,68},
                 {13,4}};
    System.out.println(new MaxSumWithoutAdjacentElements().adjacent(A));
  }

  int maxSum = Integer.MIN_VALUE;

  public int adjacent(int[][] A) {
    int n = A[0].length;

    System.out.println(adjacent1(A,n));
    return maxSum;

  }

  int adjacent(int i, int j, int[][] A, int n, int sum) {

    if (sum > maxSum) {
      maxSum = sum;
    }

    if (j >= n) {
      return 0;
    }

    for (int k = i; k < 2; k++) {
      adjacent(k, j + 2, A, n, sum + A[i][j]);
      adjacent(k, j + 1, A, n, sum);
    }

    return maxSum;

  }

    // Top down
  int adjacent3(int i, int j, int[][] A) {

    if (j < 0) {
      return 0;
    }
    int s=0;
    for (int k = i; k >=0; k--) {
      s = Math.max(A[k][j] + adjacent3(k, j - 2, A), adjacent3(k, j - 1, A));

    }

    return s;

  }

  int adjacent1(int[][] A,int n) {

    int dp[]= new int[n];
    dp[0]=Math.max(A[0][0],A[1][0]);
    dp[1]=Math.max(dp[0],Math.max(A[0][1],A[1][1]));

    for(int k=2;k<n;k++){
     dp[k]=Math.max(dp[k-2]+Math.max(A[0][k],A[1][k]),dp[k-1]);
    }
    return dp[n-1];

  }






}
