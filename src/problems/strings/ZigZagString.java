package problems.strings;

/**
 * Problem Statement See <a href="https://www.interviewbit.com/problems/zigzag-string/"> Zig Zag
 * String</a>
 * <p>Time Complexity - O(n)</p>
 *
 * @author Harsha Prabha E
 */
public class ZigZagString {

  public static void main(String[] args) {
    ZigZagString zigZagString = new ZigZagString();
    System.out.println(zigZagString.convert("PAYPALISHIRING", 3));

  }

  public String convert(String A, int B) {
    if (B == 1) {
      return A;
    }

    if (B == 0) {
      return "";
    }

    if (A == "") {
      return "";
    }

    int n = A.length();
    String[] str = new String[B];
    int k = 0;

    for (int i = 0; i < n; ) {
      if (k == 0) {
        while (i < n && k < B) {
          str[k] += A.charAt(i);
          k++;
          i++;
        }
        k = k - 2;
      }

      if (k < B - 1) {
        while (i < n && k > 0) {
          str[k] += A.charAt(i);
          k--;
          i++;
        }
      }

    }

    StringBuilder sb = new StringBuilder();
    for (int p = 0; p < B; p++) {
      sb.append(str[p]);
    }

    return sb.toString().replaceAll("null", "");

  }

}
