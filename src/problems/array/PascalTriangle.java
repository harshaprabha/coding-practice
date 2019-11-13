package problems.array;

/**
 * Problem Statement See <a href="https://www.interviewbit.com/problems/pascal-triangle/> Pascal
 * Triangle</a>
 * <p>Time Complexity - O(n^2) </p>
 *
 * @author Harsha Prabha E
 */

import java.util.ArrayList;

public class PascalTriangle {


  public static void main(String[] args) {

    PascalTriangle pascalTriangle = new PascalTriangle();
    ArrayList<ArrayList<Integer>> out = pascalTriangle.solve(5);

    for (int i = 0; i < out.size(); i++) {
      for (int j = 0; j < out.get(i).size(); j++) {
        System.out.print(out.get(i).get(j) + " ");
      }

      System.out.println();
    }

  }

  public ArrayList<ArrayList<Integer>> solve(int A) {
    ArrayList<ArrayList<Integer>> pascal = new ArrayList<ArrayList<Integer>>();
    ArrayList<Integer> one = new ArrayList<Integer>() {{
      add(1);
    }};

    if (A == 0) {
      return pascal;
    }

    if (A == 1) {
      pascal.add(one);
      return pascal;
    }

    pascal.add(one);

    for (int i = 2; i <= A; i++) {
      ArrayList<Integer> rows = new ArrayList<Integer>();

      for (int j = 0; j < i; j++) {
        if (j == 0 || j == i - 1) {
          rows.add(1);
          continue;
        } else {
          rows.add(pascal.get(i - 2).get(j - 1) + pascal.get(i - 2).get(j));
        }

      }
      pascal.add(rows);

    }

    return pascal;

  }


}
