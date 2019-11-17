package problems.numbers;
/**
 * Problem Statement See <a href="https://www.interviewbit.com/problems/largest-number/">
 * Largest Number</a>
 * <p>Time Complexity - O(nlogn) </p>
 *
 * @author Harsha Prabha E
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LargestNumber {

  public static void main(String[] args) {

    LargestNumber largestNumber = new LargestNumber();

    int[] A = {977507686, 30, 2243460, 5, 9};
    System.out.println(largestNumber.generateLargestNumber(A));

  }

  public String generateLargestNumber(int[] A) {

    List<String> list = new ArrayList<>();
    int n = A.length;

    if (n == 0) {
      return "";
    }
    if (n == 1) {
      return list.get(0).toString();
    }

    for (int k = 0; k < n; k++) {
      list.add(String.valueOf(A[k]));
    }

    Collections.sort(list, new Comparator<String>() {
      @Override
      public int compare(String o1, String o2) {

        String AB = o1.toString() + o2.toString();
        String BA = o2.toString() + o1.toString();

        return BA.compareTo(AB);
      }
    });

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < list.size(); i++) {
      sb.append(list.get(i));
    }
    return sb.toString();
  }

}

