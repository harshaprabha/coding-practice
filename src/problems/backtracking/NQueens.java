package problems.backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class NQueens {

  public static void main(String[] args) {
    System.out.println(new NQueens().solveNQueens(8));
  }

  ArrayList<ArrayList<String>> solutions = new ArrayList<>();

  public ArrayList<ArrayList<String>> solveNQueens(int n) {
    ArrayList<String> result = new ArrayList<String>();
    result = initialize_result(result, n);
    backtrack(result, n, 0);
    return solutions;
  }

  public ArrayList<String> initialize_result(ArrayList<String> result, int n) {
    //undo change
    result = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    for (int l = 0; l < n; l++) {
      sb.append(".");
    }

    for (int m = 0; m < n; m++) {
      result.add(sb.toString());
    }

    return result;

  }

  public boolean backtrack(ArrayList<String> result, int n, int col) {

    if (col >= n) {
      solutions.add(new ArrayList<>(result));
    }

    for (int row = 0; row < n; row++) {

      if (isValid(result, row, col, n)) {

        //place queen here
        char[] arr = result.get(row).toCharArray();
        arr[col] = 'Q';
        result.set(row, String.valueOf(arr));

        if (backtrack(result, n, col + 1) == true) {
          return true;
        }
        // remove the placed queen
        char[] arr1 = result.get(row).toCharArray();
        arr1[col] = '.';
        result.set(row, String.valueOf(arr1));

      }
      //backtrack
    }

    return false;

  }


  public boolean isValid(ArrayList<String> result, int row, int col,
      int n) {
    int i, j;

    //check all columns in that row
    for (j = 0; j < n; j++) {
      if (result.get(row).charAt(j) == 'Q') {
        return false;
      }

    }

    //check left diagonals up and down
    for (i = row, j = col; i >= 0 && j >= 0; i--, j--) {
      if (result.get(i).charAt(j) == 'Q') {
        return false;
      }
    }

    for (i = row, j = col; i < n && j >= 0; i++, j--) {
      if (result.get(i).charAt(j) == 'Q') {
        return false;
      }
    }

    return true;
  }


}
