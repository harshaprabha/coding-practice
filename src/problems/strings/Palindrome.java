package problems.strings;

/**
 * Problem Statement See <a href="https://www.interviewbit.com/problems/palindrome-string/">
 * Palindrome strings</a>
 * <p>Time Complexity - O(n)</p>
 *
 * @author Harsha Prabha E
 */

public class Palindrome {

  public static void main(String[] args) {
    Palindrome palindrome = new Palindrome();
    System.out.println(palindrome.isPalindrome("A man, a plan, a canal: Panama"));

  }

  public int isPalindrome2(String A) {
    int n = A.length();
    if (n == 0) {
      return 0;
    }
    String B = "";
    B = A.replaceAll("[^a-zA-Z0-9_]", "");
    StringBuilder sb = new StringBuilder();
    sb.append(B);
    if (sb.reverse().toString().equalsIgnoreCase(B)) {
      return 1;
    }
    return 0;


  }

  public int isPalindrome(String A) {
    int n = A.length();

    if (n == 0) {
      return 0;
    }
    String B = "";
    String C = "";

    for (int i = 0; i < n; i++) {
      Character ch = A.charAt(i);
      if (Character.isDigit(ch) || Character.isLetter(ch)) {
        B += ch;
        C = ch + C;
      }
    }
    if (!B.equalsIgnoreCase(C)) {
      return 0;
    }
    return 1;

  }
}
