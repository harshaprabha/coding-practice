package problems.hashing;

import java.util.HashMap;
import java.util.Map;

public class LongestSubStringWithoutRepeat {

  public static void main(String[] args) {
    System.out.println(new LongestSubStringWithoutRepeat().lengthOfLongestSubstring("dadbc"));
  }

  public int lengthOfLongestSubstring(String A) {
    int n = A.length();
    if (n == 1) {
      return 1;
    }
    boolean play = true;
    Map<Character, Integer> map = new HashMap<>();
    int maxlen = Integer.MIN_VALUE;
    int l = 1;
    for (int i = 0; i < n; i++) {
      play = true;
      map.put(A.charAt(i), i);
      for (int j = i + 1; j < n && play; j++) {
        if (!map.containsKey(A.charAt(j))) {
          map.put(A.charAt(j), j);
          l++;
        } else {
          play = false;

        }

      }
      maxlen = maxlen > l ? maxlen : l;
      map = new HashMap<>();
      l = 1;

    }

    return maxlen;


  }

}
