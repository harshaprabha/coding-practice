package javaBasics.generics;

// E type param applies to all instances of Pair
// In generics "extends"  means its assignment compatible to and includes same type(eg: String extends String,) and includes interfaces
public class Pair<E> {

  protected E key;
  protected E value;

  public Pair(E k, E v) {
    this.key = k;
    this.value = v;
  }

  public E getKey() {
    return key;
  }

  public void setKey(E key) {
    this.key = key;
  }

  public E getValue() {
    return value;
  }

  public void setValue(E value) {
    this.value = value;
  }

  // this E is not the same as declared in Pair class
  public void doStuff(E something) {
    System.out.println(something);

  }


//  // Method 1 - use the equals implementation of the objects of type E
//  boolean matched() {
//    return key.equals(value);
//  }

// Method 2 - Extend by interface
//  boolean matched() {
//    return key.getSize() == value.getSize();
//  }
//



  @Override
  public String toString() {
    return super.toString();
  }
}
