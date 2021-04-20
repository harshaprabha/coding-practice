package designPatterns.observer;

public class Client2 implements Observer {

  private String name;
  private Subject observable;

  public Client2(Subject observable) {
    this.name = "client 2";
    this.observable = observable;
  }

  @Override
  public void update(Subject ob, int payload) {
    if (ob instanceof MessageServer) {
      System.out.println("i received. my name is =" + this.name);
      System.out.println(payload);

    }
  }
}
