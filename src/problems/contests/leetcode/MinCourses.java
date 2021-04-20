package problems.contests.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MinCourses {

  public static void main(String[] args) {

    int[][] arr = {{2, 1}, {3, 1}, {1, 4}};
    System.out.println(new MinCourses().minNumberOfSemesters(4, arr, 2));
  }

  public int minNumberOfSemesters(int n, int[][] dependencies, int K) {

    int d = dependencies.length;
    if (d == 0) {
      return (int) Math.ceil(n / K);
    }

    int[] indegree = new int[n + 1];
    boolean[] done = new boolean[n + 1];
    List<Integer> sameRun = new ArrayList<>();
    for (int i = 0; i < d; i++) {
      int destn = dependencies[i][1];
      indegree[destn]++;

    }

    Queue<Integer> queue= new LinkedList<>();

    for(int i=1;i<=n;i++)
      if(indegree[i]==0)
        ((LinkedList<Integer>) queue).add(i);
    queue.add(-1);

    int semesters = 0;

    int k=K;
    while (!queue.isEmpty()) {






    }//covered

    return semesters;

  }
}


