package designPatterns.abstractFactory;

/**
 * Single factory Method implementtaion
 */

public class AnimalFactory extends AbstractFactory<Animal> {

  @Override
  public Animal create(String type) {

    if (type.equals("Dog")) {
      return new Dog();
    } else if (type.equals("Cat")) {
      return new Cat();
    }
    return new Animal();

  }
}

