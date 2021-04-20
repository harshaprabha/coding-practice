package designPatterns.decorator;

public abstract class Beverage {

  String description ="Base beverage";

  public String getDescription(){
    return description;
  }

  protected abstract double cost();
}
