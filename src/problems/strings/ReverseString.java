package problems.strings;

public class ReverseString {

  public static void main(String[] args) {
    ReverseString reverseString = new ReverseString();
    System.out.println(reverseString.solve(
        "fwbpudnbrozzifml osdt ulc jsx kxorifrhubk ouhsuhf sswz qfho dqmy sn myq igjgip iwfcqq"));
  }

  public String solve(String A) {

    int n = A.length();
    if (n <= 1) {
      return A;
    }

    int l = 0;
    int t = n - 1;
    // remove leading spaces
    while (l < n) {
      if (A.charAt(l) != ' ') {
        break;
      }
      l++;
    }
    if (l == n) {
      return " ";
    }
    // remove trailing spaces
    while (t >= 0) {
      if (A.charAt(t) != ' ') {
        break;
      }
      t--;
    }
    String B = "";
    int s = t, e = t;
    A = A.substring(l, t);

    while (s >= 0 && e >= 0) {

      if (A.charAt(s) == ' ' || s == 0) {
        int k = s == 0 ? s : s + 1;
        for (int i = k; i <= e; i++) {
          B += A.charAt(i);
        }

        if (s > 0) {
          B += ' ';
        }

        while (s >= 0) {
          if (A.charAt(s) != ' ') {
            break;
          }
          s--;
        }

        e = s;
      } else {
        s--;
      }


    }

    return B;


  }

}
