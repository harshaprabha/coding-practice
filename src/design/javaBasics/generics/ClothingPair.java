package javaBasics.generics;

// generics can extend many interfaces separated by '&' and also single class. Class must be first
public class ClothingPair<E extends Sized & Colored> extends Pair<E> {

  public ClothingPair(E key, E value) {
    super(key, value);
  }

  boolean isMatched() {
    return key.getSize() == value.getSize() && key.getColor().equals(value.getColor());
  }


  public static <T extends Sized & Colored> boolean match(T one, T two) {
    return one.getSize() == two.getSize() && one.getColor().equals(two.getColor());
  }


}
