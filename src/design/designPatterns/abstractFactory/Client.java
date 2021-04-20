package designPatterns.abstractFactory;

public class Client {

  private static FactoryProvider factoryProvider;

  public Client(FactoryProvider provider) {
    this.factoryProvider = provider;
  }

  public static void main(String[] args) {
   Client client = new Client(new FactoryProvider());
   client.method();
  }

  void method() {
    Color color = (Color) factoryProvider.getFactory("COLOR").create("WHITE");
    System.out.println(color.toString());
  }

}
