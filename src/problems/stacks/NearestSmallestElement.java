package problems.stacks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 * Problem Statement See <a href="https://www.interviewbit.com/problems/nearest-smaller-element/">
 * Nearest Smallest Element</a>
 * <p>Time Complexity - O(n)</p>
 * <p>Space Complexity - O(n)</p>
 *
 * @author Harsha Prabha E
 */

public class NearestSmallestElement {

  public static void main(String[] args) {
    ArrayList<Integer> result = new ArrayList<>(Arrays.asList(39, 27, 11, 4, 24, 32, 32, 1));
    System.out.println(new NearestSmallestElement().prevSmaller(result));
  }

  public ArrayList<Integer> prevSmaller(ArrayList<Integer> A) {

    Stack<Integer> stack = new Stack<Integer>();
    ArrayList<Integer> result = new ArrayList<Integer>();
    int n = A.size();
    if (n == 0) {
      return A;
    }

    result.add(-1);
    if (n == 1) {
      return result;
    }

    stack.push(A.get(0));

    for (int i = 1; i < n; i++) {
      if (stack.peek() < A.get(i)) {
        result.add(stack.peek());
      } else {
        while (!stack.isEmpty() && stack.peek() >= A.get(i)) {
          stack.pop();
        }

        if (stack.isEmpty()) {
          result.add(-1);
        } else {
          result.add(stack.peek());
        }


      }
      stack.push(A.get(i));

    }//for

    return result;

  }


}
