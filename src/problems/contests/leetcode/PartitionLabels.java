package problems.contests.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PartitionLabels {

  public static void main(String[] args) {
    System.out.println(new PartitionLabels().partitionLabels("abcab"));
  }

  public List<Integer> partitionLabels(String S) {
    List<Integer> result = new ArrayList<>();

    int n = S.length();

    Map<Character, Integer> map = new HashMap<>();

    for (int i = 0; i < n; i++) {
      map.put(S.charAt(i), i);
    }

    int right = 0;
    int start = 0;
    for (int left = 0; left < n; left++) {

      if (left <= right) {
        right = Math.max(map.get(S.charAt(left)), right);
        System.out.println(right);
      } else {
        result.add(right - start + 1);
        right = left;
        start = left;
        left=left-1;
      }
    }

      result.add(right - start + 1);

    return result;


  }

}
