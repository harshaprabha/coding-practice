package problems.backtracking;

public class SolveSudoku {

  public static void main(String[] args) {
    char[][] board =
        {{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
        {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
        {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
        {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
        {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
        {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
        {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
        {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
        {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
    new SolveSudoku().solveSudoku(board);
  }

  public void solveSudoku(char[][] board) {
    int n = board.length; // 9
    backtrack(0, 0, board);

  }

  boolean backtrack(int i, int j, char[][] board) {
    if (i == board.length) {
      return true;// end of sudoku
    }

    if (board[i][j] == '.') {
      //start assigning number between 1-9
      for (int k = 1; k <= 9; k++) {
        if (checkRow(k, i, board) && checkColumn(k, j, board) && checkBox(k, i, j, board)) {
          board[i][j] = (char) (k + '0');// assign number
          System.out.println(board[i][j]);
          if(gotoNextPosition(i, j, board))
            return true;
          board[i][j] = '.'; // remove assignment
        }
      }//for
    }//if
    else {
      gotoNextPosition(i, j, board);
    }
return true;
  }


  boolean gotoNextPosition(int i, int j, char[][] board) {
    if (j + 1 == 9) {
      return backtrack(i + 1, 0, board); // move to next row
    }
      return backtrack(i, j + 1, board);// move to next column

  }

  boolean checkRow(int k, int i, char[][] board) {
    for (int col = 0; col < 9; col++) {
      if (board[i][col] == k + '0') {
        return false;
      }
    }
    return true;
  }

  boolean checkColumn(int k, int j, char[][] board) {
    for (int row = 0; row < 9; row++) {
      if (board[row][j] == k + '0') {
        return false;
      }

    }
    return true;
  }

  boolean checkBox(int k, int i, int j, char[][] board) {
    int x = i / 3;
    int y = j / 3;
    int xstart = x * 3;
    int xEnd = xstart + 3;
    int ystart = y * 3;
    int yEnd = ystart + 3;
    for (int p = xstart; p < xEnd; p++) {
      for (int q = ystart; q < yEnd; q++) {
        if (board[p][q] == (k + '0')) {
          return false;
        }
      }
    }
    return true;
  }

}
