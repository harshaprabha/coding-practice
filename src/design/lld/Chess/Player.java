package design.lld.Chess;

public class Player {

  private String name;
  private boolean isWhite;

  public Player(String name) {
    this.name = name;
    this.isWhite = true;
  }

  public void setWhite(boolean white) {
    isWhite = white;
  }

}
