package problems.numbers;
/**
 * Problem Statement See <a href="https://www.interviewbit.com/problems/find-duplicate-in-array/">
 * Find Duplicate in and Array</a>
 *
 * @author Harsha Prabha E
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RepeatedNumber {


  public static void main(String[] args) {
    RepeatedNumber repeatedNumber = new RepeatedNumber();
    List<Integer> A = new ArrayList<Integer>() {{
      add(3);
      add(4);
      add(1);
      add(4);
      add(1);
    }};
    System.out.println(repeatedNumber.repeatedNumber1(A));

  }

  /**
   * Method 1 - Floyd's Cycle algorithm Time Complexity - O(n) Space complexity - O(1)
   */
  public int repeatedNumber1(final List<Integer> A) {

    int n = A.size();
    if (n <= 1) {
      return -1;
    }

    int slow = A.get(0);
    int fast = A.get(0);

    //find meeting point
    do {
      slow = A.get(slow);
      fast = A.get(A.get(fast));
    } while (slow != fast);

    //find start point
    int start = A.get(0);
    int end = slow;
    while (start != end) {
      start = A.get(start);
      end = A.get(end);
    }

    return start;


  }

  /**
   * Method 1 - Floyd's Cycle algorithm Time Complexity - O(n) Space complexity - O(n)
   */

  public int repeatedNumber2(final List<Integer> A) {

    int n = A.size();
    if (n == 0 || n == 1) {
      return -1;
    }

    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

    for (int i = 0; i < n; i++) {
      if (map.containsKey(A.get(i))) {
        return A.get(i);
      } else {
        map.put(A.get(i), 1);
      }

    }

    return -1;


  }
}
