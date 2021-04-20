package problems.intervals;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class MergeIntervals {

  public static void main(String[] args) {

    int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
    List<int[]> result= new LinkedList<>();
    Arrays.sort(intervals, (o1, o2) -> o2[0] - o1[0]);

    for (int i = 0; i < 3; i++) {
      System.out.println(intervals[i][0] + " " + intervals[i][1]);
    }

    System.out.println(new MergeIntervals().merge(intervals));

  }
  public int[][] merge(int[][] intervals) {
    Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]); // nlogn
    List<int[]>  result= new LinkedList<>();
    int n= intervals.length;

    Map<Integer,Integer> endTimes= new HashMap<>();

    for(int i=1;i<n;i++)
    {
      if(intervals[i][0]<=intervals[i-1][1])
      {
        int a=Math.min(intervals[i-1][0],intervals[i][0]);
        int b=Math.max(intervals[i-1][1],intervals[i][1]);
        intervals[i][0]=a;
        intervals[i][1]=b;
        System.out.println(a+" "+b);
        result.add(new int[]{a,b});
      }
      else
        result.add(intervals[i-1]);


    }

    return result.toArray(new int[result.size()][]);

  }

}
