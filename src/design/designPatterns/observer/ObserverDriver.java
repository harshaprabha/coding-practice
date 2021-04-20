package designPatterns.observer;

public class ObserverDriver {

  public static void main(String[] args) {

    MessageServer server = new MessageServer();
    Client2 cl2 = new Client2(
        server);
    Client cl = new Client(server);

    server.action();
  }


}
