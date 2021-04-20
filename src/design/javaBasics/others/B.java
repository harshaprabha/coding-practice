package javaBasics.others;

public class B extends A {
  int b;

  B(int a){
    super(a);
  }
  public static void main(String[] args) {
    A a = new A(10);
    B b = new B(11);
  }

}
