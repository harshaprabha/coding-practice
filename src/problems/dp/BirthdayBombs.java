package problems.dp;

import java.util.ArrayList;
import java.util.Arrays;

public class BirthdayBombs {

  static ArrayList<Integer> result = new ArrayList<>();
  static int size = 0;

  public static void main(String[] args) {
    solve(11, new ArrayList<>(Arrays.asList(8, 8, 6, 5, 4)));

  }

  static public ArrayList<Integer> solve(int A, ArrayList<Integer> B) {
    findMax(A, B, new ArrayList<>(), 0);
    return result;

  }

  static void findMax(int A, ArrayList<Integer> B, ArrayList<Integer> temp, int i) {

    if (i >= B.size() || A < 0) {
      return;
    }
    temp.add(i);
    findMax(A - B.get(i), B, temp, i);
    temp.remove(temp.size() - 1);

    if (temp.size() > result.size()) {
      result.clear();
      result.addAll(temp);
      size = temp.size();
    }

    findMax(A, B, temp, i + 1);
  }


}
