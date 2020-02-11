package problems.backtracking;

import java.util.ArrayList;

public class GrayCode {

  public static void main(String[] args) {
    System.out.println(new GrayCode().grayCode(3));

  }

  public ArrayList<Integer> grayCode(int a) {
    ArrayList<String> result = new ArrayList<String>();
    ArrayList<String> code;
    ArrayList<Integer> ans = new ArrayList<Integer>();

    result.add("0");
    result.add("1");
    if (a == 1) {
      ans.add(0);
      ans.add(1);
      return ans;
    }

    for (int i = 2; i <= a; i++) {
      code = new ArrayList<String>();
      for (int j = 0; j < result.size(); j++) {
        String temp = "0" + result.get(j);
        code.add(temp);
      }

      for (int k = result.size() - 1; k >= 0; k--) {
        String temp1 = "1" + result.get(k);
        code.add(temp1);
      }
      result = new ArrayList<String>();
      result.addAll(code);

    }//for

    for (int p = 0; p < result.size(); p++) {
      ans.add(getBinary(result.get(p), a));
    }

    return ans;

  }

  public int getBinary(String s, int n) {
    int value = 0;
    for (int i = n - 1, j = 0; i >= 0 && j < n; i--, j++) {
      value += Math.pow(2, i) * (s.charAt(j) - '0');
    }

    return value;
  }


}
