package designPatterns.decorator;

public class WhipCondimentDecorator extends CondimentDecorator {

  private Beverage beverage;
  private double cost;

  public WhipCondimentDecorator(Beverage beverage) {
    this.beverage = beverage;
    this.cost = 2.0;
  }

  @Override
  public String getDescription() {
    return beverage.getDescription() + ", Whipped";
  }

  @Override
  protected double cost() {
    return this.beverage.cost() + this.cost;
  }

}
