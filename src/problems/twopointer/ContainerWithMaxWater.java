package problems.twopointer;


import java.util.ArrayList;
import java.util.Arrays;

/**
 * Problem Statement See <a href="https://www.interviewbit.com/problems/container-with-most-water//">
 * Container With Most Water</a>
 * <p>Time Complexity - O(n)</p>
 *
 * @author Harsha Prabha E
 */
public class ContainerWithMaxWater {

  public static void main(String[] args) {
    ContainerWithMaxWater containerWithMaxWater = new ContainerWithMaxWater();
    System.out.println(containerWithMaxWater.maxArea(new ArrayList<>(Arrays.asList(1, 5, 4, 3))));

  }

  public int maxArea(ArrayList<Integer> A) {

    int n = A.size();

    if (n <= 1) {
      return 0;
    }

    int left = 0;
    int right = n - 1;
    int global_max = Integer.MIN_VALUE;
    int max = Integer.MIN_VALUE;
    ;
    while (left < right) {

      int min = Math.min(A.get(left), A.get(right));
      int area = (right - left) * min;
      max = Math.max(max, area);

      if (A.get(left) <= A.get(right)) {
        left++;
      } else {
        right--;
      }

    }

    return max;

  }

}
