package problems.strings;

/**
 * Problem Statement See <a href="https://www.interviewbit.com/problems/atoi/"> Atoi</a>
 * <p>Time Complexity - O(n)</p>
 *
 * @author Harsha Prabha E
 */
public class Atoi {

  public static void main(String[] args) {
    Atoi atoi = new Atoi();
    atoi.atoi("9 2704");

  }

  public int atoi(final String A) {
    StringBuilder sb = new StringBuilder();
    int result;
    boolean isNeg = A.charAt(0) == '-' ? true : false;
    boolean isPos = A.charAt(0) == '+' ? true : false;
    char next = isNeg || isPos ? A.charAt(1) : A.charAt(0);

    if (!Character.isDigit(next)) {
      return 0;
    }
    int zeroCount = 0;
    int k = isNeg || isPos ? 1 : 0;

    int n = 0;
    int s = 0;
    while (s < A.length()) {
      if (A.charAt(s) == ' ') {
        break;
      }
      s++;
    }
    n = s;

    while (k < n) {
      if (A.charAt(k) != '0') {
        break;
      }

      k++;
    }

    if (k == n) {
      return 0;
    }

    for (int p = k; p < n; p++) {
      if (A.charAt(p) == ' ' || !Character.isDigit(A.charAt(p))) {
        break;
      }
      if (Long.valueOf(sb.toString() + A.charAt(p)) > Integer.MAX_VALUE) {
        return Integer.MAX_VALUE;
      }
      if (Long.valueOf('-' + sb.toString() + A.charAt(p)) < Integer.MIN_VALUE) {
        return Integer.MIN_VALUE;
      }
      sb.append(A.charAt(p));

    }

    String out = isNeg ? "-" + sb.toString() : sb.toString();
    result = Integer.parseInt(out);

    return result;
  }

}
