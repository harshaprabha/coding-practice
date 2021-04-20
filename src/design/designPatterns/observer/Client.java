package designPatterns.observer;

public class Client implements Observer {

  private Subject observable;
  private String name;

  public Client(Subject observable) {
    this.name = "client 1";

  }

  @Override
  public void update(Subject ob, int payload) {
    if (ob instanceof MessageServer) {
      System.out.println("i received. my name is =" + this.name);
      System.out.println(payload);
    }
  }
}
