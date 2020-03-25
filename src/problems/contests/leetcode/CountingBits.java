package problems.contests.leetcode;

public class CountingBits {


  public static void main(String[] args) {

    System.out.println(new CountingBits().numDecodings("226"));

  }

  public int numDecodings(String s) {

    // s,i,l
    return noOfDecodings(0, s, s.length());

  }


  public int noOfDecodings(int i, String s, int n) {

    int count = 0;
    if (i >= n) {
      return 1;
    }

    for (int l = 1; l <= 2; l++) {
      if (i + l <= n) {
        int value = Integer.valueOf(s.substring(i, i + l));

        if (value != 0) {
          if (value >= 1 && value <= 26) {
            count += noOfDecodings(i + l, s, n);
          }
        }

      }

    }

    return count;

  }

}
