package problems.strings;
/**
 * Problem Statement See <a href="https://www.interviewbit.com/problems/integer-to-roman/"> Integer
 * To Roman</a>
 * <p>Time Complexity - O(n) where n - length integer</p>
 *
 * @author Harsha Prabha E
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class IntegerToRoman {

  public static void main(String[] args) {

  }

  public String intToRoman(int A) {

    if (A == 0) {
      return "";
    }
    HashMap<Integer, String> romans = new HashMap<Integer, String>();
    romans.put(1, "I");
    romans.put(2, "II");
    romans.put(3, "III");
    romans.put(4, "IV");
    romans.put(5, "V");
    romans.put(6, "VI");
    romans.put(7, "VII");
    romans.put(8, "VIII");
    romans.put(9, "IX");
    romans.put(10, "X");
    romans.put(50, "L");
    romans.put(100, "C");
    romans.put(500, "D");
    romans.put(1000, "M");
    romans.put(40, "XL");
    romans.put(400, "CD");
    romans.put(90, "XC");
    romans.put(900, "CM");

    StringBuilder sb = new StringBuilder();
    List<String> values = new ArrayList<>();
    int k = 0;
    while (A > 0) {
      int lsb = A < 10 ? A : A % 10;
      int tens = (int) Math.pow(10, k);

      if (romans.containsKey(lsb * tens)) {
        values.add(romans.get(lsb * tens));
      } else {
        String prefix = "";
        if (lsb > 5) {
          prefix = romans.get(5 * tens);
          lsb = lsb - 5;
        }

        for (int i = 0; i < lsb; i++) {
          prefix = prefix + romans.get(tens);
        }
        values.add(prefix);

      }
      A = A / 10;
      k++;
    }

    for (int p = values.size() - 1; p >= 0; p--) {
      sb.append(values.get(p));
    }

    return sb.toString();


  }

}
