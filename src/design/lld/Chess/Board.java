package lld.Chess;

public class Board {

  Piece[][] board;
  int N;

  public Board() {
    N = 8;
    board = new Piece[N][N];
    initializeBoard();
  }

  void initializeBoard() {
    board[1][1] = new Soldier();
    board[1][2] = new Knight();
  }

  void resetBoard() {
    initializeBoard();
  }
}
