package designPatterns.decorator;

public class MochaCondimentDecorator extends CondimentDecorator {

  private Beverage beverage;

  private double cost;

  public MochaCondimentDecorator(Beverage beverage) {
    this.beverage = beverage;
    this.cost=2.0;
  }

  @Override
  public String getDescription() {
    return beverage.getDescription() + ", Mocha";
  }

  @Override
  protected double cost() {
    return this.beverage.cost()+ this.cost;
  }
}
