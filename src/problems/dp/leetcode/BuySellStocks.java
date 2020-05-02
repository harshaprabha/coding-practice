package problems.dp.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class BuySellStocks {

  public static void main(String[] args) {
    int A[]={9,9,9,4,5,16,7,7};
    System.out.println(new BuySellStocks().maxProfit(A));
  }

  class MemoObj{
    int i;
    int buy;
    int profit;
    MemoObj(int i,int buy, int profit){
      this.i=i;
      this.buy=buy;
      this.profit=profit;
    }
    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }
      MemoObj memoObj = (MemoObj) o;
      return i == memoObj.i &&
          buy == memoObj.buy &&
          profit == memoObj.profit;
    }

    @Override
    public int hashCode() {
      return Objects.hash(i, buy, profit);
    }

  }

  public int maxProfit(int[] prices) {
    int n=prices.length;
    if(n==1)
      return 0;

    int sum=0;
    for(int v:prices)
      sum+=v;

    Map<MemoObj,Integer> hmap= new HashMap<>();

    return maxProfitUtil(0,0,0,prices,hmap);
  }

  int maxProfitUtil(int i,int buy,int profit,int[] prices,Map<MemoObj,Integer> hmap )
  {
    int maxProfit=0;

    if(i==prices.length)
      return profit;

    MemoObj obj= new MemoObj(i,buy,profit);
    if(hmap.get(obj)!=null)
      return hmap.get(obj);

    if(buy==0)
      maxProfit=Math.max(maxProfitUtil(i+1,1,profit-prices[i],prices,hmap), maxProfitUtil(i+1,0,profit,prices,hmap));
    else
      maxProfit=Math.max(maxProfitUtil(i+1,0,profit+prices[i],prices,hmap),maxProfitUtil(i+1,1,profit,prices,hmap));
    hmap.put(obj,maxProfit);

    return hmap.get(obj);
  }


}
