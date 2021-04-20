package javaBasics.access1;

public class D extends A {

  public static void main(String[] args) {

    D d = new D();
    d.defaultMethod(); // inherit from parent same package
    d.protectedMethod(); // inherit from parent same package
    d.publicMethod();


  }
}
