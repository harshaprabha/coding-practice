package problems.contests.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

import java.util.List;
import java.util.Map;
import javafx.util.Pair;

public class MinStackDLL {

  Node last;
  MinStackDLL() {
    this.last = null;
  }

  /**
   * Doubly linked list Node
   */

  class Node {

    Pair<Integer, Integer> pair;
    Node next;
    Node prev;


    Node(Pair<Integer, Integer> pair) {
      this.pair = pair;
      this.next = null;
      this.prev = null;
    }
  }


  public void push(int x) {

    Node newNode;
    if (last == null) {
      newNode = new Node(new Pair<>(x, x));
      last = newNode;
      return;
    } else {
      newNode = new Node(new Pair<>(x, Math.min(x,last.pair.getValue())));
    }
    last.next = newNode;
    newNode.prev=last;
    last = last.next;
  }

  public void pop() {
    if (last == null) {
      return;
    }

    if (last.prev == null) {
      last = null;
      return;
    }

    Node lastDel= last;
    last = last.prev;
    lastDel.next = null;
    lastDel.prev=null;

  }

  public int top() {
    if (last != null) {
      return last.pair.getKey();
    }
    return 0;

  }

  public int getMin() {
    if (last != null) {
      return last.pair.getValue();
    }
    return 0;

  }


  public static void main(String[] args) {
    problems.contests.leetcode.MinStackDLL minStack = new problems.contests.leetcode.MinStackDLL();
    minStack.push(-1);
    minStack.top();
    minStack.getMin();
    minStack.pop();
    minStack.pop();
    minStack.pop();
    minStack.pop();
    minStack.push(-2);
    minStack.push(10);
    minStack.push(-6);
    minStack.pop();
    minStack.getMin();
    minStack.pop();
    minStack.pop();

    Map<Integer,Integer> map= new HashMap<>();

    List<Integer> r= new ArrayList<>();
    r.addAll(map.values());

  }

}




