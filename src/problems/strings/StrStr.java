package problems.strings;

/**
 * Problem Statement See <https://www.interviewbit.com/problems/implement-strstr/"> Sub String</a>
 * <p>Time Complexity - O(n*m) where n-> length of string and m->length of substring</p>
 *
 * @author Harsha Prabha E
 */

public class StrStr {

  public static void main(String[] args) {
    StrStr strStr = new StrStr();
    System.out.println(strStr.strStr("bbbbbbbbbaba", "baba"));

  }

  public int strStr(final String A, final String B) {

    int m = A.length();
    int n = B.length();

    if (n > m) {
      return -1;
    }

    if (m == 0) {
      return -1;
    }

    if (n == 0) {
      return -1;
    }

    char ch = B.charAt(0);
    int k = -1;
    boolean isPresent = true;
    for (int i = 0; i < m; ) {
      if (A.charAt(i) == ch && m - i >= n) {
        k = i;
        isPresent = true;
        for (int j = 0; j < n; j++) {
          if (A.charAt(i + j) != B.charAt(j)) {
            isPresent = false;
            break;
          }
        }// for j

        if (isPresent) {
          return k;
        } else {
          i = k + 1;
        }
      } else {
        i++;
      }
    }

    return -1;

  }
}
