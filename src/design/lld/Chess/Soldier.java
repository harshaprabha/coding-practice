package lld.Chess;



public class Soldier extends Piece {

  @Override
  boolean isValidMove(Board board, int fromRow, int fromCol, int toRow,
      int toCol) {
    return super.isValidMove(board, fromRow, fromCol, toRow, toCol);
  }
}
