package problems.heaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MagicianAndChocolates {

  public static void main(String[] args) {
    System.out.println(new MagicianAndChocolates()
        .nchoc(10, new ArrayList<Integer>(Arrays.asList(2147483647, 2000000014, 2147483647))));
  }

  public int nchoc(int A, ArrayList<Integer> B) {
    int n = B.size();

    PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
    pq.addAll(B);
    System.out.println(pq);
    Long sum = 0L;

    //klogn
    while (A > 0) {
      int ele = pq.remove();
      sum += (long) ele;
      pq.add(ele / 2);
      System.out.println(pq);
      A--;
    }

    return (int) (sum % (Math.pow(10, 9) + 7));


  }

}
