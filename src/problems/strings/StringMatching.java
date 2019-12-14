package problems.strings;

/**
 * String Matching Algorithms Knuth Morris Pratt Algorithm - O(m+n)
 *
 * @author Harsha Prabha E
 */
public class StringMatching {


  public static void main(String[] args) {
    StringMatching stringMatching = new StringMatching();
    int suffix[] = stringMatching.computeSuffixArray("abxab");
    for (int i = 0; i < suffix.length; i++) {
      System.out.print(suffix[i] + " ");
    }
    matchString(suffix, "abxabxab", "abxab");


  }

  public static void matchString(int suffix[], String str, String pat) {

    int m = str.length();

    int n = pat.length();

    for (int i = 0, j = 0; i < m && j < n; ) {

      if (str.charAt(i) != pat.charAt(j)) {
        j = suffix[j];
        continue;
      } else {
        if (j == n - 1) {
          System.out.println("pattern from " + (i - (n - 1)) + "to " + i);
        } else {
          j++;
        }
      }
      i++;

    }//for
  }

  public int[] computeSuffixArray(String str) {
    int n = str.length();
    int suffix[] = new int[n];
    suffix[0] = 0;

    for (int i = 1, j = 0; i < n && j < n; ) {

      if (str.charAt(i) == str.charAt(j)) {
        suffix[i] = j + 1;
        i++;
        j++;
      } else {
        if (j == 0) {
          suffix[i] = 0;
          i++;
        } else {
          j = suffix[j - 1];
        }
      }

    }

    return suffix;
  }


}
