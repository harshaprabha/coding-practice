package problems.contests.leetcode;

public class MaxPerformance {

  public static void main(String[] args) {
    int S[]={10,9};
    int E[]={9,6};
    System.out.println(new MaxPerformance().maxPerformance(2,S,E,1));
  }
    int mod=1000000007;
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {

      if(n==1)
        return speed[0]*efficiency[0];

      return getMaxPerf(0,0,0,Integer.MAX_VALUE,n,k,speed,efficiency)%mod;

    }

    public int getMaxPerf(int i,int k,int speedSum,int minEfficiency,int n,int K,int[] speed,int[] efficiency)
    {

      int perf=0;
      if(i==n)
        return ((speedSum)%mod)*((minEfficiency)%mod);
      if(k<=K)
        perf=Math.max(getMaxPerf(i+1,k+1,speedSum+speed[i],Math.min(minEfficiency,efficiency[i]),n,K,speed,efficiency)%mod,getMaxPerf(i+1,k,speedSum,minEfficiency,n,K,speed,efficiency)%mod);

      return perf%mod;
    }

}
