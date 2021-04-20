package problems.twopointer;

public class MinWindowSubstring {

  public static void main(String[] args) {

    System.out.println(new MinWindowSubstring().minWindow("a", "aa"));
  }

  int expected[];
  int actual[];

  public String minWindow(String s, String t) {

    int target = t.length();
    int n = s.length();

    expected = new int[58];
    actual = new int[58];

    char forIndexing = 'A';

    for (int i = 0; i < t.length(); i++) {
      expected[t.charAt(i) - forIndexing]++;
    }

    int left = 0;

    int minWindow = Integer.MAX_VALUE;
    String minStr = "";

    for (int right = 0; right < n && left<n; right++) {
      if (expected[s.charAt(right) - forIndexing] != 0) {
        actual[s.charAt(right) - forIndexing]++;  // update condition
        while (left<n && checkValid()) // check condition is met
        {
          // Note window size
          if (minWindow > right - left + 1) {
            minWindow = right - left + 1;
            minStr = s.substring(left, right + 1);
          }

          // Move left
          actual[s.charAt(left) - forIndexing]--;  // remove condition using left
          left++;

        }//while

      }//if
    }

    return minStr;
  }

  boolean checkValid() {
    for (int i = 0; i < 58; i++) {
      if (expected[i] != 0) {
        if (expected[i] > actual[i]) {
          return false;
        }
      }
    }

    return true;

  }
}
