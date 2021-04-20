package problems.divideAndConquer;

public class UniqueBST {

  int[][] memo;

  public static void main(String[] args) {
    System.out.println(new UniqueBST().numTrees(3));
  }

  public int numTrees(int n) {

    if (n == 1) {
      return 1;
    }
    if (n == 0) {
      return 0;
    }

    int[][] dp = new int[n + 2][n
        + 2];// unique bsts in between range left and right from every number as root

    dp[0][0] = 1;

    for (int i = 0; i < n + 1; i++) {
      for (int j = 0; j < n + 1; j++) {
        if (i == j || i > j) {
          dp[i][j] = 1;
        }
      }
    }

    for (int i = 0; i < n + 1; i++) {
      for (int j = 0; j < n + 1; j++) {
        System.out.print(dp[i][j] + " ");
      }
      System.out.println();
    }

    for (int len = 1; len <= n; len++) {
      for (int left = 1; left+len <= n; left++) {
        int right = left + len;
        int count=0;
        for (int k = left; k <= right; k++) // tree rooted at k
        {
          count += (dp[left][k - 1] * dp[k + 1][right]);
        }
        dp[left][right]=count;
      }

    }

    for (int i = 0; i < n + 2; i++) {
      for (int j = 0; j < n + 2; j++) {
        System.out.print(dp[i][j] + " ");
      }
      System.out.println();
    }

    return dp[1][n];

//         memo= new int[n+1][n+1];
//         for(int i=0;i<n+1;i++)
//             Arrays.fill(memo[i],-1);

//         return countTrees(1,n);

  }

  int countTrees(int left, int right) {
    int count = 0;

    if (left > right) {
      return 1;// no subtree
    }

    if (left == right) {
      return 1; // hit leaf node
    }

    if (memo[left][right] != -1) {
      return memo[left][right];
    }

    for (int i = left; i <= right; i++) {
      int leftTrees = countTrees(left, i - 1);
      int rightTrees = countTrees(i + 1, right);
      count += (rightTrees * leftTrees);
    }

    memo[left][right] = count;
    return count;

  }


}
