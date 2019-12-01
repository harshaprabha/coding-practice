package problems.strings;

import java.util.Arrays;

/**
 * Problem Statement See <a href="https://www.interviewbit.com/problems/multiply-strings/"> Multiply
 * two large strings</a>
 * <p>Time Complexity - O(n) where n - length of largest string</p>
 *
 * @author Harsha Prabha E
 */

public class MultiplyStrings {

  public static void main(String[] args) {
    MultiplyStrings multiplyStrings = new MultiplyStrings();
    System.out.println(multiplyStrings.multiply("1234567654321234567", "98765435678987654"));

  }

  public String multiply(String A, String B) {
    int m = A.length();
    int n = B.length();

    if (A.equals("0") || B.equals("0")) {
      return "0";
    }

    if (A.equals("1")) {
      return B;
    }
    if (B.equals("1")) {
      return A;
    }
    String result = "";
    char[] first = new StringBuilder(A).reverse().toString().toCharArray();

    char[] second = new StringBuilder(B).reverse().toString().toCharArray();

    char[] product = new char[m + n];
    Arrays.fill(product, '0');

    for (int i = 0; i < first.length; i++) {

      int carry = 0;
      int k = 0;

      for (int j = 0; j < second.length; j++) {

        int prod = (first[i] - '0') * (second[j] - '0') + carry;
        int rowSum = prod + (product[i + j] - '0');
        int lsb = rowSum % 10;
        carry = rowSum / 10;

        product[i + j] = (char) (lsb + '0');
        k = i + j;
      }

      if (carry != 0) {
        product[k + 1] = (char) (carry + '0');
      }

    }
    int k = 0;

    while (k < result.length()) {
      if (result.charAt(k) != '0') {
        break;
      }
      k++;
    }
    String output = new StringBuilder(new String(result)).reverse().toString();
    return output.substring(k, result.length());


  }

}
