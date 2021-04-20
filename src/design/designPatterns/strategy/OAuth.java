package designPatterns.strategy;

public class OAuth extends BaseAuth {

  int childVar;

  public void authenticate() {
    System.out.println("Oauth");
  }
}
