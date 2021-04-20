package javaBasics.generics;

public class GloveDupe extends Glove implements Sized,Colored {

  public GloveDupe(int id, String color) {
   super(id,color);
  }

  @Override
  public int getSize() {
    return size;
  }

  @Override
  public String getColor() {
    return color;
  }

}
