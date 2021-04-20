package problems.dp;

public class SplitArrayLargestSum {

  public static void main(String[] args) {
    int A[]={1,2147483647};
    int m=2;
    System.out.println(new SplitArrayLargestSum().splitArray(A,m));
  }

  int minSum=Integer.MAX_VALUE;


  public int splitArray(int[] nums, int m) {
    int n= nums.length;
    if(n==0)
      return 0;


    long minSum= findLargestSum(0,0,m-1,nums,0);
    return minSum==Long.MAX_VALUE?0:(int)minSum;
  }


  long findLargestSum(long sum,int i,int m,int[] nums, long maxSum){
    long minSum=Long.MAX_VALUE;
    if(i>=nums.length || m<0)
    {
      if(m==0) // all assigned
        return maxSum;
      return Long.MAX_VALUE;
    }
    minSum=Math.min(findLargestSum(sum+nums[i],i+1,m,nums,Math.max(maxSum,sum+nums[i])),findLargestSum(nums[i],i+1,m-1,nums,Math.max(maxSum,nums[i])));
    return minSum;
  }


}
