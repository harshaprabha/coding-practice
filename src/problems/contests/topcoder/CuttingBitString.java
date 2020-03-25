package problems.contests.topcoder;

public class CuttingBitString {

  public static void main(String[] args) {
    System.out.println(new CuttingBitString().getmin("111011100110101100101110111"));
  }

  public int getmin(String S) {
    int count = 0;

    if (isMultipleOf5(S)) {
      return 0;
    }
    count = getMinCuts(0, "", 0, S, S.length());
    return count == Integer.MAX_VALUE ? -1 : count + 1;

  }

  int getMinCuts(int i, String subString, int k, String S, int n) {

    int count = 0;
    if (isMultipleOf5(subString) && i == n) {
      return k;
    } else if (i == n) {
      return Integer.MAX_VALUE;
    }
    if (subString.startsWith("0")) {
      return Integer.MAX_VALUE;
    }

    if (isMultipleOf5(subString)) {
      count = Math.min(getMinCuts(i + 1, String.valueOf(S.charAt(i)), k + 1, S, n),
          getMinCuts(i + 1, subString + S.charAt(i), k, S, n));
    } else {
      count = getMinCuts(i + 1, subString + S.charAt(i), k, S, n);
    }

    return count;
  }

  boolean isMultipleOf5(String S) {
    if (S.startsWith("0")) {
      return false;
    }
    int n = S.length() - 1;
    int value = 0;
    int i = 0;
    while (n >= 0) {
      value += (S.charAt(n) - 48) * Math.pow(2, i);
      i++;
      n--;
    }
    //check if pow of 5
    int num = value;
    boolean isMultiple = true;
    while (num > 1) {
      if (num % 5 != 0) {
        isMultiple = false;
        break;
      }
      num = num / 5;
    }

    return S.isEmpty() || value == 0 ? false : isMultiple;
  }

}
