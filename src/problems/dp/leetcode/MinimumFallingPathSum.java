package problems.dp.leetcode;

public class MinimumFallingPathSum {

  public static void main(String[] args) {

    int[][] A={{-80,-13,22},{83,94,-5},{73,-48,61}};
    System.out.println(new MinimumFallingPathSum().minFallingPathSum(A));

  }

  public int minFallingPathSum(int[][] A) {

    int m=A.length;
    int n= A[0].length;
    if(m==0)
      return 0;

    for(int i=1;i<m;i++){

      for(int j=0;j<n;j++){
        int minCol=Integer.MAX_VALUE;
        //for all possibilities of column
        for(int k=-1;k<=1;k++){
          int col=j+k;
          if(col>=0 && col<n)
          {
            minCol=Math.min(minCol,A[i-1][col]);
          }
        }//for

        A[i][j]=minCol+A[i][j];

      }
    }//for

    int min=Integer.MAX_VALUE;
    for(int p=0;p<n;p++)
    {
      min=Math.min(min,A[m-1][p]);
    }

    return min;
  }

}
