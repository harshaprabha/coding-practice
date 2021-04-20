package problems.contests.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {

  public static void main(String[] args) {
    int A[] = {31, 1, 1, 18, 15, 3, 15, 14};
    int target = 33;
    System.out.println(new Solution().minSumOfLengths(A, target));
  }

  class Node {

    int i;
    int j;
    int range;

    public Node(int i, int j, int r) {
      this.i = i;
      this.j = j;
      this.range = r;
    }

  }

  public int minSumOfLengths(int[] arr, int target) {
    PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
      @Override
      public int compare(Node o1, Node o2) {

        int fcomp = o1.range - o2.range;
        if (fcomp != 0) {
          return fcomp;
        }

        return o1.j - o2.i;

      }
    });

    int i = 0;
    int j = 0;
    int n = arr.length;
    int sum = 0;
    int prev = -1;

    while (i < n && j < n) {
      if (prev != j) {
        sum += arr[j];
      }
      prev = j;
      if (sum == target) {
        pq.add(new Node(i, j, j - i + 1));
        j++;
      } else if (sum > target) {

        if (i <= j) {
          sum -= arr[i];
          i++;
        } else {
          j++;
        }

      } else {
        j++;
      }

    }


    if (pq.isEmpty()) {
      return -1;
    }

    Node one = pq.remove();
    Node two = null;
    while (!pq.isEmpty()) {
      Node ele = pq.remove();
      if ((one.i < ele.i && one.j < ele.i) || (one.i > ele.i && one.j > ele.i)) {
        two = ele;
        break;
      } else {
        continue;
      }
    }

    if (two == null) {
      return -1;
    }

    return one.range + two.range > 0 ? one.range + two.range : -1;


  }
}
