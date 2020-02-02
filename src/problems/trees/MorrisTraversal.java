package problems.trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Set;

public class MorrisTraversal {

  Node begin;
  static ArrayList<Integer> result = new ArrayList<Integer>();
  HashMap<Integer, Integer> map = new LinkedHashMap<>();

  public static void main(String[] args) {
    Node A = new Node(76);
    A.left = new Node(77);
    //  A.right = new Node(9);
    //A.left.left = new Node(1);
    //A.left.right = new Node(3);
    new MorrisTraversal().morrisTraversalIterative(A);
    System.out.println(result);
  }


  public void morrisTraversalIterative(Node root) {

    Node current = root;
    Node prev = null;

    while (current != null) {
      Node pred = getPredecessor(current);
      if (pred == null) {
        System.out.println(current.value);
        prev = current;
        current = current.right;
        if (current != null && prev.value > current.value) {
          map.put(prev.value, current.value);
        }
      } else {
        if (pred.right != null) {
          System.out.println(current.value);
          Node temp = current;
          current = current.right;
          if (temp.value > current.value) {
            map.put(temp.value, current.value);
          }

          temp.right = null;
        } else {
          pred.right = current;
          prev = current;
          current = current.left;
          if (prev.value < current.value) {
            map.put(current.value, prev.value);
          }

        }
      }//else


    }
    Set<Integer> keys = map.keySet();
    ArrayList<Integer> list = new ArrayList<Integer>(keys);
    if (!keys.isEmpty()) {
      if (keys.size() > 1) {

        result.add(list.get(0));
        result.add(map.get(list.get(1)));
      } else {
        result.add(list.get(0));
        result.add(map.get(list.get(0)));
      }
    }


  }

  public Node getPredecessor(Node current) {
    if (current == null) {
      return current;
    }

    Node leftSubTree = current.left;
    Node prev = null;
    while (leftSubTree != null) {
      if (leftSubTree == current) {
        return null;
      }
      prev = leftSubTree;
      leftSubTree = leftSubTree.right;
    }

    return prev;
  }


}
