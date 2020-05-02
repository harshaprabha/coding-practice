package problems.contests.leetcode;

import java.util.Collections;
import java.util.PriorityQueue;

public class LastStoneWeight {

  public static void main(String[] args) {
    int[] stones={2,7,4,1,8,1};
    System.out.println(new LastStoneWeight().lastStoneWeight(stones));
  }

  public int lastStoneWeight(int[] stones) {

    int result=0;
    PriorityQueue<Integer> pq= new PriorityQueue<>(Collections.reverseOrder());

    for(int i=0;i<stones.length;i++)
      pq.add(stones[i]);

    while(pq.size()>1)
    {
      int x=0,y=0;
      if(!pq.isEmpty())
        x=pq.remove();
      if(!pq.isEmpty())
        y=pq.remove();

      int z= Math.abs(x-y);
      if(z!=0)
        pq.add(z);
    }

    if(!pq.isEmpty())
      result=pq.remove();

    return result;

  }



}
