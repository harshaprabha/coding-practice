package problems.trees.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;
import problems.trees.Node;

public class Inorder {

  Map<Integer,Integer> map= new TreeMap<>();

  public static void main(String[] args) {
Node root= new Node(7);
root.left=new Node(4);
root.right=new Node(9);
    root.left.left= new Node(1);
    root.right.right= new Node(10);
    inorder(root);
  }

  static void inorder(Node node)
  {

    LinkedList<Integer> ll= new LinkedList<>();
    Deque<Integer> dq= new LinkedList<>();
    if(node==null)
      return;
    inorder(node.right);
    System.out.println(node.value);
    inorder(node.left);
  }

}
