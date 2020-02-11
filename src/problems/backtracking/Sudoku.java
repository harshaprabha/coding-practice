package problems.backtracking;

import java.util.ArrayList;

public class Sudoku {

  int n;
  boolean isFull = true;

  public void solveSudoku(ArrayList<ArrayList<Character>> a) {
    n = a.size();
    backtrackSudoku(a, n);

  }

  public boolean backtrackSudoku(ArrayList<ArrayList<Character>> A, int n) {
    int row = -1;
    int col = -1;
    // check for any empty cells
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (A.get(i).get(j) == '.') {
          row = i;
          col = j;
          isFull = false;
          break;
        }
      }
    }

    if (isFull) {
      return true;
    }

    for (int num = 1; num <= n; num++) {
      if (isValid(num, A, row, col)) {
        char ch = (char) (num + '0');
        //Set number to empty space
        A.get(row).set(col, ch);

        isFull = true;

        if (backtrackSudoku(A, n)) {
          return true;
        }

        //Unset number
        A.get(row).set(col, ch);

      }//if

    }// for

    return false;
  }


  public boolean isValid(int num, ArrayList<ArrayList<Character>> A, int row, int col) {
    char ch = (char) (num + '0');

    //check row
    for (int i = 0; i < n; i++) {

      if (A.get(row).get(i) == ch) {
        return false;
      }

    }
    //check column
    for (int j = 0; j < n; j++) {

      if (A.get(j).get(col) == ch) {
        return false;
      }

    }

    //check box
    int sqrt = (int) Math.sqrt(n);

    int boxStartRow = row - row % sqrt;
    int boxStartCol = col - col % sqrt;

    for (int p = 0; p < 3; p++) {
      for (int q = 0; q < 3; q++) {
        if (A.get(p + boxStartRow).get(q + boxStartCol) == ch) {
          return false;
        }
      }
    }

    return true;
  }

}
