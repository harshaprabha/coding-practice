package javaBasics.access2;

import javaBasics.access1.A;
import java.util.TreeSet;

public class E extends A {

  int var; // same variable as super class

  public static void main(String[] args) {

    E e = new E();
    e.protectedMethod(); // inherit protected methods across packages
    e.publicMethod();

    int i=3;
    int j=i;
    j++;
    System.out.println(j);
    System.out.println(i);
    TreeSet<String> a= new TreeSet<>();
    a.pollFirst();
    a.iterator().next();


  }

  E() {
    super(); // invocation of superclass constructor must be the first line in subclass constructor
  }

  @Override
  public void someParentMethod() {
    System.out.println("child class implementation");

  }

  @Override
  public String toString() {
    // return super.toString();    // super is used to access members of parent class

    super.someParentMethod();
    someParentMethod();
    return "";

  }
}
