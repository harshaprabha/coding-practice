package problems.array;

/**
 * Problem Statement See <a href="https://www.interviewbit.com/problems/add-one-to-number/">
 * AddOneToNumber</a>
 * <p>Time Complexity - O(n) </p>
 *
 * @author Harsha Prabha E
 */

public class AddOneToNumber {

  public static void main(String[] args) {
    AddOneToNumber addOne = new AddOneToNumber();

    int A[] = {1, 9, 9, 9};
    System.out.println(addOne.plusOne(A)[0]);

  }

  public int[] plusOne(int[] A) {

    int n = A.length;
    int result[];
    int s = 0;

    //Find first non zero element in array
    for (int i = 0; i < n; i++) {
      s = i;
      if (A[i] != 0) {
        break;
      }
    }

    int e = n - 1;

    // Initialize the array to store result
    result = new int[e - s + 1 + 1];

    int carry = 0;
    int k = result.length - 1;
    int add = 0;

    for (int j = e; j >= s; j--) {
      if (j == e) {
        add = 1;
      } else {
        add = 0;
      }

      int val = A[j] + add + carry;
      if (val == 10) {
        carry = 1;
        val = 0;
      } else {
        carry = 0;
      }
      result[k--] = val;
    }

    if (carry == 1) {
      result[k--] = 1;
    } else {
      int out[] = new int[result.length - 1];
      for (int m = 0; m < out.length; m++) {
        out[m] = result[m + 1];

      }
      return out;
    }

    return result;


  }

}
