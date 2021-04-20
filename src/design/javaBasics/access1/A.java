package javaBasics.access1;

public class A {
  int var;

  public A(){

  }

  public void someParentMethod(){
    System.out.println("p[arent implementation");

  }
  public void publicMethod() {

  }

  protected void protectedMethod() {

  }

  private void privateMethod() {

  }

  void defaultMethod() {
    A a = new A();
    a.privateMethod();
  }



}
