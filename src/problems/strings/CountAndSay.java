package problems.strings;

/**
 * Problem Statement See <a href="https://www.interviewbit.com/problems/count-and-say/"> Count And
 * Say</a>
 * <p>Time Complexity - O(n) where n - length of previous string</p>
 *
 * @author Harsha Prabha E
 */
public class CountAndSay {

  public static void main(String[] args) {
    CountAndSay countAndSay = new CountAndSay();
    System.out.println(countAndSay.countAndSay(5));
  }

  public String countAndSay(int A) {
    if (A == 0) {
      return "";
    }
    if (A == 1) {
      return "1";
    }

    String prev = "1";
    StringBuilder result = new StringBuilder();

    for (int k = 2; k <= A; k++) {
      result = new StringBuilder();

      for (int i = 0; i < prev.length(); ) {

        String temp_prev = prev;
        Character start = temp_prev.charAt(i);
        int count = 0;
        int p = i;
        while (p < temp_prev.length() && temp_prev.charAt(p) == start) {
          p++;
          count++;
        }
        result.append(count);
        result.append(start);
        i = p;
        temp_prev = result.toString();
      }
      prev = result.toString();
    }

    return result.toString();

  }

}
