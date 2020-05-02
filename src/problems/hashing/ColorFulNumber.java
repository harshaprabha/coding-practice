package problems.hashing;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ColorFulNumber {

  public static void main(String[] args) {
    System.out.println(new ColorFulNumber().colorful(3245));

  }

  public int colorful(int A) {
    String s = String.valueOf(A);
    List<String> substrings = new ArrayList<>();
    Set<Integer> set = new HashSet<>();
    for (int i = 1; i <= s.length(); i++) {

      for (int j = 0; j < s.length(); j++) {

        int end = j + i;
        if (end <= s.length()) {
          String sub = s.substring(j, end);
          substrings.add(sub);
        }

      }
    }

    for (int k = 0; k < substrings.size(); k++) {

      String sub = substrings.get(k);
      int prod = 1;
      for (int p = 0; p < sub.length(); p++) {
        prod *= Integer.valueOf(sub.charAt(p) - '0');
      }
      if (!set.contains(prod)) {
        set.add(prod);
      } else {
        return 0;
      }

    }

    return 1;

  }

}
