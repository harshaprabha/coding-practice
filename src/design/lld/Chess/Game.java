package lld.Chess;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Game {

  private design.lld.Chess.Player A;
  private design.lld.Chess.Player B;
  private Board board;
  private design.lld.Chess.Player lastMoveBy;
  private List<Move> moves;

  public Game(Board board, design.lld.Chess.Player A, design.lld.Chess.Player B) {
    this.board = board;
    this.A = A;
    this.B = B;
    this.moves = new ArrayList<Move>();
    this.lastMoveBy = null;
  }

  void recordMove(Move move) {
    moves.add(move);
  }

  public design.lld.Chess.Player startGame() {
    this.board.initializeBoard();
    return assignPlayers();
  }

  private design.lld.Chess.Player assignPlayers() {
    int playerOne = (int) Math.round(Math.random() * 2.0);
    design.lld.Chess.Player first = null;
    if (playerOne == 1) {
      first = A;
      B.setWhite(false);
    } else {
      first = B;
      A.setWhite(true);
    }
    return first;
  }

  public boolean makeMove(int fromRow, int toRow, int fromCol, int toCol,
      design.lld.Chess.Player player) {

    if (player.equals(lastMoveBy)) {
      return false;
    }
    Collections.sort(new ArrayList<Integer>());

    Piece piece = board.board[fromRow][fromCol];
    if (!piece.isValidMove(board, fromRow, toRow, fromCol, toCol)) {
      return false;
    }

    Piece killed = new NoPiece();
    if (board.board[toRow][toCol] instanceof NoPiece) {
      board.board[toRow][toCol] = board.board[fromRow][fromCol];
      board.board[fromRow][fromCol] = new NoPiece();
    } else {
      killed = board.board[fromRow][fromCol];
      board.board[toRow][toCol] = board.board[fromRow][fromCol];
    }

    recordMove(new Move(player, fromRow, fromCol, toRow, toCol, piece, killed));
    checkForStaleMate();

    lastMoveBy = player;
    return true;
  }

  void checkForStaleMate() {
    //
  }
}
