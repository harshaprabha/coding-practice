package problems.twopointer;

import java.util.ArrayList;
import java.util.Arrays;
/**
 * Problem Statement See <a href="https://www.interviewbit.com/problems/remove-duplicates-from-sorted-array/">
 * Remove Duplicates from Sorted Array</a>
 * <p>Time Complexity - O(n)</p>
 *
 * @author Harsha Prabha E
 */
public class RemoveDuplicates {

  public static void main(String[] args) {
    ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1, 1, 1, 2, 3));
    System.out.println(new RemoveDuplicates().removeDuplicates(A));
  }

  public int removeDuplicates2(ArrayList<Integer> A) {

    int n = A.size();

    if (n <= 1) {
      return n;
    }

    int slow = 0;
    int fast = 0;

    while (slow < n && fast < n) {
      int prev = A.get(fast);
      while (fast < n && A.get(fast).equals(prev)) {
        fast++;
      }

      A.set(slow, prev);
      slow++;

    }
    int i = A.size() - slow;
    while (i > 0) {
      A.remove(A.size() - 1);
      i--;
    }

    return slow;


  }

  public int removeDuplicates(ArrayList<Integer> A) {

    int n = A.size();

    if (n <= 1) {
      return n;
    }

    int s = 0;
    int e = s + 1;
    while (s < A.size() && e < A.size()) {
      int ele = A.get(s);

      while (e < A.size() && A.get(e).equals(A.get(s))) {
        e++;
      }

      int count = e - s;
      while (count > 1) {
        A.remove(s);
        count--;
      }

      e = s + 1;
      s = s + 1;

    }
    return A.size();


  }

}
