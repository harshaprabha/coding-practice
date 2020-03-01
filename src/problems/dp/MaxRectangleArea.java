package problems.dp;

import java.util.Stack;

public class MaxRectangleArea {

  public static void main(String[] args) {
    int n = 4;
    int A[][] = {{1, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 0}};
    int maxArea = maximalRectangle(A);
//    int maxArea = 0;
//
//    for (int i = 0; i < n; i++) {
//      for (int j = 0; j < n; j++) {
//        // for each element, compute rectangle starting from that point of all possible lengths
//        for (int l = 1; l <= n; l++) {
//          for (int m = 1; m <= n; m++) {
//            if (i + l <= n && j + m <= n) {
//              int sum = checkAllOnes(i, j, l, m, A, n);
//              maxArea = sum != -1 && maxArea < sum ? sum : maxArea;
//            }
//          }
//        }
//
//      }
//    }//for
    System.out.println(maxArea);
  }

  // O(n^6)
  int bruteForce(int A[][]) {
    int n = A.length;
    int maxArea = Integer.MIN_VALUE;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        // for each element, compute rectangle starting from that point of all possible lengths
        for (int l = 1; l <= n; l++) {
          for (int m = 1; m <= n; m++) {
            if (i + l <= n && j + m <= n) {
              int sum = checkAllOnes(i, j, l, m, A, n);
              maxArea = sum != -1 && maxArea < sum ? sum : maxArea;
            }
          }
        }

      }
    }//for
    return maxArea;
  }

  static int checkAllOnes(int i, int j, int l, int m, int[][] A, int n) {

    for (int p = i; p < i + l; p++) {
      for (int q = j; q < j + m; q++) {
        if (A[p][q] != 1) {
          return -1;
        }
      }
    }

    return l * m;
  }

  //O(N^2)
  public static int maximalRectangle(int[][] A) {

    int R = A.length;
    int C = A[0].length;

    int maxArea = getMaxArea(A[0], C);

    for (int i = 1; i < R; i++) {
      for (int j = 0; j < C; j++) {
        if (A[i][j] == 1) {
          A[i][j] = A[i - 1][j] + 1;
        }

      }
      int area = getMaxArea(A[i], C);
      maxArea = area > maxArea ? area : maxArea;

    }
    return maxArea;
  }

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
