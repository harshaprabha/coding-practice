package problems.strings;

/**
 * Problem Statement See <a href="https://www.interviewbit.com/problems/length-of-last-word/">
 * Length of last word in a String</a>
 * <p>Time Complexity - O(n)</p>
 *
 * @author Harsha Prabha E
 */
public class LengthOfLastWord {

  public static void main(String[] args) {
    System.out.println(new LengthOfLastWord().lengthOfLastWord("   dddd   "));
  }

  public int lengthOfLastWord(final String A) {

    int n = A.length();
    int s = 0;
    int e = 0;
    int prevCount = 0;

    while (s < n && e < n) {
      if (A.charAt(s) == ' ') {
        e = 0;
      } else {
        e++;
        prevCount = e;
      }
      s++;

    }
    String[] str = new String[3];

    return Math.max(prevCount, e);


  }
}
