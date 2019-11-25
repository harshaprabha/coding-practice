package problems.math;

import java.util.ArrayList;

/**
 * Problem Statement See <a href=" https://www.interviewbit.com/problems/rearrange-array/">
 * Rearrange Array with O(1) space complexity </a>
 * <p>Time Complexity - O(n) </p>
 * <p>Space Complexity - O(1) </p>
 *
 * @author Harsha Prabha E
 */
public class RearrangeArray {


  public static void main(String[] args) {
    ArrayList<Integer> a = new ArrayList<>();
    a.add(4);
    a.add(0);
    a.add(2);
    a.add(1);
    a.add(3);
    arrange(a);
    System.out.println();
  }

  public static void arrange(ArrayList<Integer> a) {
    int n = a.size();

    //use modulo arithmetic to encode two numbers into one
    for (int i = 0; i < n; i++) {
      // r+c*n=a then r=a%n
      int temp = a.get(i) + (a.get(a.get(i)) % n) * n;
      a.set(i, temp);
      System.out.println(a.get(i));

    }

    for (int j = 0; j < n; j++) {
      // r+c*n=a and c= a/n
      a.set(j, a.get(j) / n);

    }


  }

}
