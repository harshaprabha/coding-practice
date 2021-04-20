package javaBasics.generics;

import java.util.ArrayList;
import java.util.List;
import javaBasics.generics.taxables.Corporation;
import javaBasics.generics.taxables.Individual;
import javaBasics.generics.taxables.Taxable;

public class CoVAndCT {

  public static void main(String[] args) {

    // Arrays are covariant as its a reifiable type
    // A reifiable type is a type whose type information is fully available at runtime. This includes primitives, non-generic types, raw types, and invocations of unbound wildcards.
    // reifiable type fool compiler but get caught in runtime
    // 2 aspects - actual type of object and other is refernce pointing to that object

    // Both scenarios lead to heap pollution

    Taxable[] arr= new Taxable[3];
    arr[0]= new Taxable();
    arr[1]= new Individual();
    arr[2]= new Corporation();

    // Applies to arrays
    Individual[] iArr= new Individual[2];
    arr=iArr;

    arr[1]=new Corporation(); // not right

    // Whereas with List - compiler throws error

    List<Integer> myInts = new ArrayList<Integer>();
    myInts.add(1);
    myInts.add(2);
  //  List<Number> myNums = myInts; //compiler error
   // myNums.add(3.14); //heap polution

  }
}
