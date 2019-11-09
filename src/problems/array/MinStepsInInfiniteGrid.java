package problems.array;

/**
 * Problem Statement See <a href="https://www.interviewbit.com/problems/min-steps-in-infinite-grid/">
 * Minimum Steps In Infinite Grid</a>
 *
 * @author Harsha Prabha E
 */
public class MinStepsInInfiniteGrid {

  public static void main(String[] args) {
    MinStepsInInfiniteGrid minsteps = new MinStepsInInfiniteGrid();

    int A[] = {-7, -13};
    int B[] = {1, -5};
    System.out.println(minsteps.coverPoints(A, B));

  }

  public int coverPoints(int[] A, int[] B) {
    int result = 0;

    int i = 1;
    int x1 = A[0];
    int y1 = B[0];

    if (A.length == 1 || A.length == 0) {
      return result;
    }

    while (i < A.length) {

      int x2 = A[i];
      int y2 = B[i];
      result += Math.max(Math.abs(x2 - x1), Math.abs(y2 - y1));
      x1 = x2;
      y1 = y2;
      i++;
    }
    return result;


  }

}
