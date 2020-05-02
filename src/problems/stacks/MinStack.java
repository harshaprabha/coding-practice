package problems.stacks;

public class MinStack {

  public static void main(String[] args) {

    MinStack minStack = new MinStack();
    minStack.push(19);
    minStack.push(10);
    minStack.push(9);
    System.out.println(minStack.getMin());

    minStack.push(8);
    System.out.println(minStack.getMin());
    minStack.push(7);
    System.out.println(minStack.getMin());
    minStack.push(6);
    System.out.println(minStack.getMin());
    minStack.pop();
    System.out.println(minStack.getMin());
    minStack.pop();
    System.out.println(minStack.getMin());
    minStack.pop();
    System.out.println(minStack.getMin());
    minStack.pop();
    System.out.println(minStack.getMin());
    minStack.pop();
    System.out.println(minStack.getMin());
    minStack.pop();
    System.out.println(minStack.getMin());

  }

  int min = Integer.MAX_VALUE;

  int top = -1;
  int mintop = -1;


  class Node {

    int v;
    Node next;
    Node prev;

    Node(int v) {
      this.v = v;
      this.next = null;
      this.prev = null;
    }
  }

  Node start = null;
  Node tail = null;

  Node minstart = null;
  Node mintail = null;

  public void push(int x) {
    Node newNode = new Node(x);
    Node minNode = new Node(x);
    if (start == null && minstart == null) {
      start = newNode;
      tail = newNode;
      minstart = minNode;
      mintail = minNode;

    } else {
      tail.next = newNode;
      newNode.prev = tail;
      tail = newNode;

      if (tail.v < mintail.v) {
        mintail.next = minNode;
        minNode.prev = mintail;
        mintail = minNode;
      }


    }//else


  }

  public void pop() {

    if (start == null && tail == null) {
      return;
    }
    //one element
    if (start == tail) {
      start = null;
      tail = null;

      minstart = null;
      mintail = null;
    } else {

      if (tail.v == mintail.v) {
        Node temp = mintail;
        mintail = mintail.prev;
        mintail.next = null;
        temp.next = null;
        temp.prev = null;

      }
      Node temp2 = tail;
        tail = tail.prev;
        tail.next = null;
      temp2.next = null;
      temp2.prev = null;

      }



    }//else




  public int top() {
    if (start == null) {
      return -1;
    }

    return tail.v;

  }

  public int getMin() {
    if (mintail == null) {
      return -1;
    }
    return mintail.v;

  }
}



