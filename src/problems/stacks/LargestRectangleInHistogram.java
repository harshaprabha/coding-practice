package problems.stacks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 * Problem Statement See <a href="https://www.interviewbit.com/problems/largest-rectangle-in-histogram/">
 * Largest Rectangle in Histogram</a>
 * <p>Time Complexity - O(n)</p>
 * <p>Space Complexity - O(n)</p>
 *
 * @author Harsha Prabha E
 */
public class LargestRectangleInHistogram {

  class StackElement {

    Integer ele;
    int index;

    StackElement(Integer ele, int index) {
      this.ele = ele;
      this.index = index;
    }

  }

  public static void main(String[] args) {
    ArrayList<Integer> result = new ArrayList<>(Arrays.asList(3, 1, 1, 1));
    System.out.println(new LargestRectangleInHistogram().largestRectangleArea(result));
  }

  public int largestRectangleArea(ArrayList<Integer> A) {

    int n = A.size();
    if (n == 0) {
      return 0;
    }
    if (n == 1) {
      return A.get(0);
    }

    Stack<StackElement> stack = new Stack<StackElement>();
    int left[] = new int[n];
    int right[] = new int[n];

    stack.push(new StackElement(A.get(0), 0));
    left[0] = -1;
    //populate left smallest element
    for (int i = 1; i < n; i++) {

      if (A.get(i) > stack.peek().ele) {
        left[i] = stack.peek().index;
      } else {
        int c = 1;
        while (!stack.isEmpty() && stack.peek().ele >= A.get(i)) {
          stack.pop();
          c++;
        }
        if (stack.empty()) {
          left[i] = -1;
        } else {
          left[i] = stack.peek().index;
        }
      }
      stack.push(new StackElement(A.get(i), i));

    }

    stack = new Stack<StackElement>();
    stack.push(new StackElement(A.get(n - 1), n - 1));
    right[n - 1] = -1;

    //populate right smallest element
    for (int j = n - 2; j >= 0; j--) {

      if (A.get(j) > stack.peek().ele) {
        right[j] = stack.peek().index;
      } else {
        int c = 1;
        while (!stack.isEmpty() && stack.peek().ele >= A.get(j)) {
          stack.pop();
          c++;
        }
        if (stack.empty()) {
          right[j] = -1;
        } else {
          right[j] = stack.peek().index;
        }
      }
      stack.push(new StackElement(A.get(j), j));

    }

    //compute area
    int maxArea = Integer.MIN_VALUE;
    for (int k = 0; k < n; k++) {
      int range = 0;
      if (left[k] == -1 && right[k] == -1) {
        range = n;
      } else {
        int start = left[k] == -1 ? -1 : left[k];
        int end = right[k] == -1 ? n : right[k];
        range = end - start - 1;
      }
      int area = A.get(k) * (range);
      maxArea = maxArea < area ? area : maxArea;

    }

    return maxArea;


  }

}
