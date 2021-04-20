package problems.contests.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Min {

  public static void main(String[] args) {
    List<List<Integer>> ll= new ArrayList<>();
    List<Integer> one = new ArrayList<>();
    one.add(new Integer(1));
    one.add(new Integer(2));
    one.add(new Integer(3));
    ll.add(one);
    List<Integer> two = new ArrayList<>();
    two.add(new Integer(4));
    two.add(new Integer(5));
    ll.add(two);
    List<Integer> three = new ArrayList<>();
    three.add(new Integer(1));
    three.add(new Integer(2));
    three.add(new Integer(3));
    ll.add(three);


    System.out.println(new Min().maxDistance(ll));
  }

  public int maxDistance(List<List<Integer>> arrays) {
    int m = arrays.size();
    PriorityQueue<int[]> pq = new PriorityQueue<>();

    for (int i = 0; i < m; i++) {
      if (arrays.get(i).size() != 0) {
        pq.add(new int[]{(int) arrays.get(i).get(0), i, 0});
      }
    }

    int min = pq.peek()[0];
    int[] ele = new int[3];
    while (!pq.isEmpty()) {
      ele = pq.remove();
      if (arrays.get(ele[1]) != null
          && arrays.get(ele[1]).get(ele[2] + 1) != null)// row and col exists
      {
        pq.add(new int[]{arrays.get(ele[1]).get(ele[2]), ele[1], ele[2] + 1});
      }

    }

    return Math.abs(ele[0] - min);


  }
}
