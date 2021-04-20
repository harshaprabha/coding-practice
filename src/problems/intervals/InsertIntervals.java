package problems.intervals;

import java.util.LinkedList;
import java.util.List;

public class InsertIntervals {


  public static void main(String[] args) {

  }

  public int[][] insert(int[][] intervals, int[] newInterval) {

    int n = intervals.length;

    boolean inserted = false;
    List<int[]> intervalList = new LinkedList<>();

    if (n == 0) {
      intervalList.add(newInterval);
      return intervalList.toArray(new int[1][]);
    }

    int insertionPoint = 0;
    while (insertionPoint < n && intervals[insertionPoint][0] < newInterval[0]) {
      intervalList.add(intervals[insertionPoint]);
      insertionPoint++;
    }

    if (((LinkedList<int[]>) intervalList).getLast()[1] >= newInterval[0])// overlapping
    {
      int a = ((LinkedList<int[]>) intervalList).getLast()[0];
      int b = Math.max(((LinkedList<int[]>) intervalList).getLast()[1], newInterval[1]);
      ((LinkedList<int[]>) intervalList).removeLast();
      intervalList.add(new int[]{a, b});
    } else {
      intervalList.add(newInterval);
    }

    int i = insertionPoint;
    while (i < n) {

      // if overlapping then merge else just add
      if (((LinkedList<int[]>) intervalList).getLast()[1] >= intervals[i][0]) {
        int a = ((LinkedList<int[]>) intervalList).getLast()[0];
        int b = Math.max(((LinkedList<int[]>) intervalList).getLast()[1], intervals[i][1]);
        ((LinkedList<int[]>) intervalList).removeLast();
        intervalList.add(new int[]{a, b});
      } else {
        intervalList.add(intervals[i]);
      }
      i++;

    }

    return intervalList.toArray(new int[intervalList.size()][]);

  }

}
