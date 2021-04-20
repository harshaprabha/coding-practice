package designPatterns.decorator;

public class Client {

  public static void main(String[] args) {
    new Client().makeBeverage();
  }

  void makeBeverage() {
    Beverage beverage = new Espresso();
    System.out.println(beverage.getDescription());
    System.out.println(beverage.cost());

    CondimentDecorator decorator1 = new MochaCondimentDecorator(beverage);
    System.out.println(decorator1.getDescription());
    System.out.println(decorator1.cost());
    CondimentDecorator decorator2 = new WhipCondimentDecorator(decorator1);
    System.out.println(decorator2.getDescription());
    System.out.println(decorator2.cost());


  }

}
