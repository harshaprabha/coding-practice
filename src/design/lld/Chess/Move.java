package lld.Chess;


public class Move {

  private design.lld.Chess.Player player;
  private Piece piece;
  private Piece killedPiece;
  private int fromX;
  private int fromY;
  private int toX;
  private int toY;

  public Move(design.lld.Chess.Player player, int fromX, int fromY, int toX, int toY, Piece piece,
      Piece killedPiece) {
    this.player = player;
    this.piece = piece;
  }

}
