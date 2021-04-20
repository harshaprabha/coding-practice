package designPatterns.abstractFactory;

public class FactoryProvider {

  private AbstractFactory abstractFactory;

  public AbstractFactory getFactory(String type) {
    if (type.equals("COLOR")) {
      abstractFactory = new ColorFactory();
    } else {
      abstractFactory = new AnimalFactory();
    }

    return abstractFactory;

  }

}
