package problems.twopointer;

import java.util.HashMap;
import java.util.Map;

public class CountNiceArrays {

  public static void main(String[] args) {
    int muns[]={1,1,2,1,1};
    int k=3;

    System.out.println(new CountNiceArrays().numberOfSubarrays(muns,k));

  }

  public int numberOfSubarrays(int[] nums, int k) {
    int n=nums.length;
    int count=0;

    Map<Integer,Integer> map= new HashMap<>();
    int[] oddCount= new int[n+1];

    for(int i=1;i<=n;i++)
    {
      oddCount[i]=oddCount[i-1]+ nums[i-1]%2;
      //System.out.print(oddCount[i]+" ");
    }

    for(int j=0;j<=n;j++)
    {
      count+=map.getOrDefault(oddCount[j],0);
     // System.out.print(count+" ");
      map.put(oddCount[j]+k,map.getOrDefault(oddCount[j]+k,0)+1);
    }

    return count;

  }

}
