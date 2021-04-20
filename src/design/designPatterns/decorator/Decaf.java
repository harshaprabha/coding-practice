package designPatterns.decorator;

public class Decaf extends Beverage {

  public Decaf() {
    this.description = "Decaf";
  }

  @Override
  public String getDescription() {
    return super.getDescription();
  }

  @Override
  protected double cost() {
    return 5;
  }
}
