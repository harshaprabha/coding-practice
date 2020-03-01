package problems.dp;

import java.util.Stack;

public class LargestRectInHistogram {

  public static void main(String[] args) {
    int A[] = {6, 2, 5, 4, 5, 1, 6};
    System.out.println(getMaxArea(A,A.length));

  }
  //Meth 1 - O(N^2)
  static void bruteForce(int A[], int n) {

    int left = 0;
    int right = 0;
    int maxArea = Integer.MIN_VALUE;

    for (int i = 0; i < n; i++) {
      left = i - 1;
      right = i + 1;
      while (left >= 0 && A[left] >= A[i]) {
        left--;
      }
      while (right < n && A[right] >= A[i]) {
        right++;
      }

      left = left == -1 ? 0 : left;
      right = right >= n ? n - 1 : right;

      int diff = (right - left - 1);

      int sum = diff * A[i];
      maxArea = sum > maxArea ? sum : maxArea;

    }
    System.out.println(maxArea);

  }

  //Meth 2 - O(N) time and O(N) space
  static int getMaxArea(int row[], int n) {
    Stack<Integer> stack = new Stack<>();
    int[] leftMin = new int[n];
    int[] rightMin = new int[n];
    //calculate nearest smallest from left
    int maxArea = Integer.MIN_VALUE;
    stack.push(0);
    leftMin[0] = -1;
    int i = 1;

    while (i < n) {
      while (!stack.isEmpty() && row[stack.peek()] >= row[i]) {
        stack.pop();
      }
      if (stack.isEmpty()) {
        leftMin[i] = -1;
      } else {
        leftMin[i] = stack.peek();
      }
      stack.push(i);
      i++;
    }

    //calculate nearest smallest from right
    stack.clear();
    stack.push(n - 1);
    rightMin[n - 1] = -1;
    i = n - 2;
    while (i >= 0) {
      while (!stack.isEmpty() && row[stack.peek()] >= row[i]) {
        stack.pop();
      }
      if (stack.isEmpty()) {
        rightMin[i] = -1;
      } else {
        rightMin[i] = stack.peek();
      }
      stack.push(i);
      i--;
    }

    for (int k = 0; k < n; k++) {
      int right = rightMin[k] == -1 ? n : rightMin[k];
      int area = (right - leftMin[k] - 1) * row[k];
      maxArea = area > maxArea ? area : maxArea;
    }

    return maxArea;

  }


}
