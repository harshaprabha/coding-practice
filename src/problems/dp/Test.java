package problems.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeMap;

public class Test {

  static class Node {

    int val;
    String name;

    Node(int v, String name) {
      this.val = v;
      this.name = name;
    }
  }

  public static void main(String[] args) {

//    TreeMap<Integer, Node> map = new TreeMap<>();
//
//    map.put(1, new Node(123, "harsha"));
//    map.put(1, new Node(345, "prabha"));
//
//    int[]arr= {1,2,-1,3,4};


    ArrayList<Integer> a = new ArrayList<>();
    a.add(0);
    a.add(0);
    a.add(0);

    a.set(1,5);
    for(int ele: a)
    System.out.print(ele +" ");


//    System.out.println(map.firstEntry().getValue().name);
//    map.pollFirstEntry();
//    System.out.println(map.firstEntry().getValue().name);

  }
}
