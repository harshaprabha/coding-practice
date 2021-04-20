package javaBasics.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntegerTest {


  public static void main(String[] args) {

    Integer a = new Integer(1);
    //Integer b= new Integer(1);

    Integer b = null;
    int bb = 0;
    // System.out.println(b < bb);
    List<Integer> ll = new ArrayList<>();
    ll.add(1);
    IntegerTest obj = new IntegerTest();
    obj.printValues(Arrays.asList(1, 2, ""));
    obj.printValues(Arrays.asList(1, 2, 3, 4, 5));
    obj.printValues(Arrays.asList("harsha", "prabha"));
    obj.printValues(ll);

    List<String> list = new ArrayList();
    list.add("hahah");
    //list.add(1);

    //int value= (int)list.get(0);
    // System.out.println(value);
  }

  <T> void printValues(List<T> values) {
    for (T t : values) {
      System.out.println(t);
    }
  }


}
