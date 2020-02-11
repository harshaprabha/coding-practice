package problems.dp;

public class EditDistanceRecursion {

  public static void main(String[] args) {

    String A = "anagram";
    String B = "ane";

    String a = A.length() >= B.length() ? A : B;
    String b = A.length() < B.length() ? A : B;

    for (int i = 0; i < A.length() - B.length(); i++) {
      b = " " + b;
    }

    System.out
        .println(new EditDistanceRecursion().minDistance(a, b, a.length() - 1, b.length() - 1));

  }

  public int minDistance(String A, String B, int i, int j) {

    int cost = 0;
    if (i < 0 || j < 0) {
      return 0;
    }

    if (A.charAt(i) == B.charAt(j)) {
      cost = minDistance(A, B, i - 1, j - 1);
    } else {
      cost = Math.min(1 + minDistance(A, B, i - 1, j),
          Math.min(1 + minDistance(A, B, i - 1, j - 1), 1 + minDistance(A, B, i, j - 1)));
    }

    return cost;
  }
}
