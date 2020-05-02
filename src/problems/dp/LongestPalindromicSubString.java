package problems.dp;

public class LongestPalindromicSubString {

  public static void main(String[] args) {
    System.out.println(new LongestPalindromicSubString().longestPalindrome("cbbd"));
  }
  String str = "";
  int max = 0;

  public String longestPalindrome(String s) {
    int n = s.length();
    if (n == 0) {
      return "";
    }

    if (n == 1) {
      return s;
    }

    findLongPalin(s, 0, n - 1);

    return str;
  }


  boolean findLongPalin(String s, int i, int j) {

    boolean isPalin = false;

    if (i == j) {
      return true;
    }
    if (i + 1 == j) {
      if (s.charAt(i) == s.charAt(j)) {
        return true;
      }
      return false;
    }

    if (s.charAt(i) == s.charAt(j)) {
      isPalin = findLongPalin(s, i + 1, j - 1);
    }
    else
    {
      isPalin = findLongPalin(s, i + 1, j) || findLongPalin(s, i, j - 1);

    }

    if (isPalin) {
      if (max < j - i) {
        max = j - i;
        str = s.substring(i, j + 1);

      }
    }
    return isPalin;

  }

}
