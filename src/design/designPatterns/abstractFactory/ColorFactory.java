package designPatterns.abstractFactory;

public class ColorFactory extends AbstractFactory<Color> {

  @Override
  public Color create(String type) {
    if (type.equals("WHITE")) {
      return new White();
    } else if (type.equals("BLACK")) {
      return new Black();
    }
    return null;
  }
}
