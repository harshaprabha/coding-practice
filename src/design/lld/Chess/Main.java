package lld.Chess;

import lld.Chess.Board;
import lld.Chess.Game;

public class Main {

  public static void main(String[] args) {

    Board board = new Board();
    design.lld.Chess.Player A = new design.lld.Chess.Player("harsha");
    design.lld.Chess.Player B = new design.lld.Chess.Player("sravan");

    Game chessGame = new Game(board,A,B);

    design.lld.Chess.Player first = chessGame.startGame();


  }

}
