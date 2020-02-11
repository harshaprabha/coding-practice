package problems.backtracking;

import java.util.ArrayList;

public class GenerateBinarySequences {

  public static void main(String[] args) {

    ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    new GenerateBinarySequences().generateBinary(result, new ArrayList<Integer>(), 3);
    System.out.println(result);

  }

  public void generateBinary(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> temp, int n) {

    if (temp.size() == n) {
      result.add(new ArrayList<>(temp));
    } else if (n > 0) {
      temp.add(0);
      generateBinary(result, temp, n);
      temp.remove(temp.size() - 1);

      temp.add(1);
      generateBinary(result, temp, n);
      temp.remove(temp.size() - 1);
    }

  }

}
