package problems.contests.leetcode;

import java.util.ArrayList;
import java.util.List;

public class CharacterReplacement {

  public static void main(String[] args) {

    System.out.println(new CharacterReplacement().characterReplacement("AABABBA", 1));
  }

  public int characterReplacement(String s, int k) {

    int n = s.length();
    int K = k;
    int[] count = new int[26];

    int left = 0;
    int max = 0;
    int maxLength = 0;

    for (int right = 0; right < n; right++) {

      max = Math.max(++count[s.charAt(right) - 'A'], max);

      while (right - left + 1 - max > k) {
        count[s.charAt(left) - 'A']--;
        left++;
      }
      maxLength = Math.max(maxLength, right - left + 1);

    }//for

    List<int[]> result= new ArrayList<>();

    return maxLength;



  }

}
