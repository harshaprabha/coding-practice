package lld.Chess;


import lld.Chess.Piece;

public class NoPiece extends Piece {

  String name;

  @Override
  boolean isValidMove(Board board, int fromRow, int fromCol, int toRow, int toCol) {
    return true;
  }
}
