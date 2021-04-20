package javaBasics.generics;

public class Glove extends BaseGlove implements Sized, Colored {


  public Glove(int id, String color) {
    super(id, color);
  }

  @Override
  public int getSize() {
    return this.size;
  }

  @Override
  public String getColor() {
    return color;
  }


  @Override
  public boolean equals(Object obj) {
    return this.color.equals(((Glove) obj).color) && this.size == ((Glove) obj).size;
  }


}
