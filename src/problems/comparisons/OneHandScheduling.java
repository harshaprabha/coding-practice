package problems.comparisons;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


/**
 * 
 * Problem Statement
 * Misof recently had an accident in which he managed to cut his left hand on some
 * broken glass. He is now "all right" - meaning that he can only use his right hand for a while.
 * Help him with some issues he has.Misof needs to do some tasks. Each of the tasks has to be done
 * during a specific time interval, and it requires constant use of his only hand. Find out whether
 * he can do all the tasks. You are given the int[]s tStart and tEnd, each with N elements. For each
 * i between 0 and N-1, inclusive, tStart[i] is the timestamp of the beginning and tEnd[i] the
 * timestamp of the end of task i. (All timestamps are in seconds, with timestamp 0 being the
 * midnight today.) For each task, Misof needs his hand for the entire interval of time, including
 * both endpoints. That is, if one task ends exactly at the same time at which another task begins,
 * Misof cannot do both of them.Return "possible" (quotes for clarity) if Misof can do all the tasks
 * and "impossible" if he cannot do that.
 *
 */
public class OneHandScheduling {

  public enum Result {
    POSSIBLE("possible"), IMPOSSIBLE("impossible");
    private String value;

    Result(String value) {
      this.value = value;
    }

  }

  public static void main(String[] args) {

    int[] s = {30, 20, 10};
    int[] e = {40, 29, 19};
    OneHandScheduling oneHandScheduler = new OneHandScheduling();

    System.out.println(oneHandScheduler.checkScheduleWithComparator(s, e));
    System.out.println(oneHandScheduler.checkScheduleWithBinarySearch(s, e));

    int[] s1 = {30, 19, 10};
    int[] e1 = {40, 29, 19};

    System.out.println(oneHandScheduler.checkScheduleWithComparator(s1, e1));
    System.out.println(oneHandScheduler.checkScheduleWithBinarySearch(s1, e1));
  }

  public class Schedule {
    int start;
    int end;

    public Schedule(int s, int e) {
      this.start = s;
      this.end = e;
    }

  }

  /**
   * Method 1 Using Binary Search - O(nlogn)
   * 
   */
  public String checkScheduleWithBinarySearch(int[] start, int[] end) {

    int n = start.length;
    int starttime[] = new int[n];

    // copy start into startime
    for (int k = 0; k < n; k++)
      starttime[k] = start[k];

    Arrays.sort(starttime);
    int endtime[] = new int[n];


    for (int i = 0; i < n; i++) {
      int ele = start[i];
      int s = 0;
      int e = n - 1;
      int result = -1;

      /**
       * For every element in start, search for the same in startime and store corresponding end in
       * endtime
       */

      while (s <= e) {
        int mid = (s + e) / 2;

        if (starttime[mid] == ele) {
          result = mid;
          break;
        } else if (starttime[mid] < ele) {
          s = mid + 1;
        }

        else {
          e = mid - 1;
        }

      }
      endtime[result] = end[i];
    }

    for (int j = 0; j < n - 1; j++) {
      if (endtime[j] >= starttime[j + 1])
        return Result.IMPOSSIBLE.toString();

    }
    return Result.POSSIBLE.toString();

  }

  /**
   * 
   * Method 2 Using Java Comparator - O(nlogn)
   * 
   * 
   */
  public String checkScheduleWithComparator(int[] start, int[] end) {

    int n = start.length;
    List<Schedule> schedules = new ArrayList<Schedule>();
    OneHandScheduling onehand = new OneHandScheduling();

    // Load the start and end arrays to a List
    for (int i = 0; i < n; i++) {
      schedules.add(onehand.new Schedule(start[i], end[i]));
    }

    // Sort list based on start and end times - O(nlogn)
    schedules.sort(new Comparator<Schedule>() {

      @Override
      public int compare(Schedule o1, Schedule o2) {
        return o1.end - o2.start;
      }
    });

    // Check the condition
    for (int j = 0; j < n - 1; j++) {
      if (schedules.get(j).end >= schedules.get(j + 1).start)
        return Result.IMPOSSIBLE.toString();

    }

    return Result.POSSIBLE.toString();

  }



}
