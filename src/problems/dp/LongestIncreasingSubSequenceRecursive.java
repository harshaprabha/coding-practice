package problems.dp;

public class LongestIncreasingSubSequenceRecursive {

  static int maxLength = 0;

  public static void main(String[] args) {
    String A = "192384";

    new LongestIncreasingSubSequenceRecursive().maxlength(A, 0, A.length(), 1);
    System.out.println(maxLength);
  }

  public void maxlength(String A, int start, int n, int l) {

    if (start == n) {
      return;
    }

    for (int i = start + 1; i < n; i++) {
      if (A.charAt(i) > A.charAt(start)) {
        l = l + 1;
        maxlength(A, i, n, l);
        maxLength = l > maxLength ? l : maxLength;
        l--;
      }
    }//for

  }


  public int maxlength2(String A, int start, int n, int l) {

    if (start == n) {
      return l;
    }

    for (int i = start + 1; i < n; i++) {
      if (A.charAt(i) > A.charAt(start)) {
        l = l + 1;
        maxlength(A, i, n, l);
        maxLength = l > maxLength ? l : maxLength;
        l--;
      }
    }//for

    return l;
  }

}
