package problems.dp.leetcode;

import java.util.Arrays;

public class CoinChange {

  public static void main(String[] args) {

    int coins[]={1,2};
    int amt=3;
    System.out.println(new CoinChange().minCoinsToMakeChangeBU2(coins.length,amt,coins));
  }

  /**
   * With Time complexity - O(n*sum)
   * @param n
   * @param amount
   * @param coins
   * @return
   */
  public int minCoinsToMakeChangeBU(int n,int amount,int[] coins){

    int dp[][]= new int[n+1][amount+1];

    Arrays.fill(dp[0],amount+1);

    // min no of ways to make change for amount=0 is 0
    for(int k=0;k<=n;k++){
      dp[k][0]=0;
    }

    for(int i=1;i<=n;i++){
      for(int j=1;j<=amount;j++){

        if(j>=coins[i-1])
          dp[i][j]=Math.min(dp[i][j-coins[i-1]]+1,dp[i-1][j]);

        else
          dp[i][j]=dp[i-1][j]; // then old count continues

      }//for
    }//for

    return dp[n][amount]>=amount+1?-1:dp[n][amount];
  }

  /**
   * O(sum)
   *
   * @param n
   * @param amount
   * @param coins
   * @return
   */
  public int minCoinsToMakeChangeBU2(int n,int amount,int[] coins){

    int dp[]= new int[amount+1];

    Arrays.fill(dp,amount+1);

    dp[0]=0;  // min no of ways to make change for amount=0 is 0

    for(int i=1;i<=amount;i++){
      for(int j=0;j<n;j++){

        // for all possible coins
        if(i>=coins[j])
        {
          dp[i]=Math.min(dp[i],1+dp[i-coins[j]]);
        }
      }//for

    }//for

    return dp[amount]>=amount+1?-1:dp[amount];
  }
}
