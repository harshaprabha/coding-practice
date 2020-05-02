package problems.hashing;

import java.util.HashMap;
import java.util.Map;

public class Fraction {

  public static void main(String[] args) {
    System.out.println(new Fraction().fractionToDecimal(87, 22));
  }

  public String fractionToDecimal(int a, int b) {
    String result = "";
    Map<Long, Long> map = new HashMap<>();
    long A = a;
    long B = b;
    int sign = 0;

    if (A % B == 0) {
      long C = (A / B);
      return String.valueOf(C);
    }

    if ((A < 0 && B > 0) || (A > 0 && B < 0)) {
      sign = 1;
    }

    A = A < 0 ? -A : A;
    B = B < 0 ? -B : B;

    int n = 0;
    if (A > B) {
      n = (int) (A / B);
      A = A - (B * n);
    }

    result += n;
    result += ".";

    boolean isRepeat = false;

    String decimal = "";
    long d = 0;
    long startIndex = 0;
    while (A < B && !isRepeat) {
      if (A * 10 > B) {
        A = A * 10;
      } else {
        A = A * 10;
        if (!map.containsKey(A)) {
          decimal += "0";
          map.put(A, d);
          d++;
          continue;
        } else {
          startIndex = map.get(A);
          isRepeat = true;

        }
      }
      int t = (int) (A / B);
      int r = (int) (A % B);

      if (!map.containsKey(A)) {
        map.put(A, d);
        d++;
        decimal += t;
        A = r;
      } else {
        isRepeat = true;
        startIndex = map.get(A);
        break;

      }

      if (A == 0) {
        break;
      }

    }

    result += isRepeat ? decimal.substring(0, (int) startIndex) + "(" + decimal
        .substring((int) startIndex, decimal.length()) + ")" : decimal;

    result = sign == 1 ? "-" + result : result;

    return result;


  }
}
