package designPatterns.decorator;

public class Espresso extends Beverage {

  public Espresso() {
    description = "Espresso";
  }

  @Override
  public String getDescription() {
    return this.description;
  }

  @Override
  protected double cost() {
    return 2.0;
  }
}
