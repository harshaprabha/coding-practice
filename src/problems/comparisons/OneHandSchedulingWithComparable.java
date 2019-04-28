package problems.comparisons;

import java.util.ArrayList;
import java.util.Collections;
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

public class OneHandSchedulingWithComparable {

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
    OneHandSchedulingWithComparable oneHandScheduler = new OneHandSchedulingWithComparable();

    System.out.println(oneHandScheduler.checkScheduleWithComparable(s, e));

    int[] s1 = {30, 19, 10};
    int[] e1 = {40, 29, 19};

    System.out.println(oneHandScheduler.checkScheduleWithComparable(s1, e1));
  }


  public class Schedule implements Comparable<Schedule> {
    int start;
    int end;

    public Schedule(int s, int e) {
      this.start = s;
      this.end = e;
    }

    @Override
    public int compareTo(Schedule o) {
      return this.end - o.start;

    }

  }

  private String checkScheduleWithComparable(int[] start, int[] end) {

    List<Schedule> schedules = new ArrayList<Schedule>();
    OneHandSchedulingWithComparable onehand = new OneHandSchedulingWithComparable();
    int n = start.length;
    // Load the start and end arrays to a List
    for (int i = 0; i < n; i++) {
      schedules.add(onehand.new Schedule(start[i], end[i]));
    }

    Collections.sort(schedules);
    // Check the condition
    for (int j = 0; j < n - 1; j++) {
      if (schedules.get(j).end >= schedules.get(j + 1).start)
        return Result.IMPOSSIBLE.toString();

    }
    return Result.POSSIBLE.toString();
  }


}
